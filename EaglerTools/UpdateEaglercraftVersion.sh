#!/bin/bash

set -euo pipefail

echo '
##################################################

You need Eclipse installed to use this script.

Import the Eclipse Clean Up profile from:
./desktopRuntime/eclipseProject/starlike_basic_format.xml

##################################################
'

if ! dos2unix -V &> /dev/null; then
echo "Error: dos2unix is not installed. Please install it and try again."
exit 1
fi

SCRIPT_DONE="0"
TMP_DIR="$(mktemp -d)"

cleanup() {
if [[ "$SCRIPT_DONE" != "1" ]]; then
echo
echo
echo "Script interrupted, cleaning up..."
echo

git branch -D update-branch 2>/dev/null || :
rm -rf "$TMP_DIR"

if [[ -n "${CURRENT_BRANCH:-}" ]]; then
git checkout -f "$CURRENT_BRANCH"
fi

echo
echo "Cleaned up."
SCRIPT_DONE="1"
fi
exit
}

for sig in HUP INT QUIT ABRT ALRM TERM USR1 USR2 PIPE EXIT; do
trap cleanup "$sig"
done

echo
echo "Starting script..."
echo

git remote remove workspace
git remote add workspace "https://git.eaglercraft.rip/eaglercraft/eaglercraft-1.8-workspace.git"
git fetch workspace

echo
echo
echo "Here are the last 5 commits and their commit hashes:"
git --no-pager log -n 5 --oneline workspace/master
echo
echo "What is the commit hash of the client's current update?"
echo "(e.g. the client is currently on u40 and the latest is u42, type the commit hash of u40)"
read -rp "> " CURRENT_HASH
echo
echo
if ! git rev-parse "$CURRENT_HASH" &> /dev/null; then
echo "Invalid hash: $CURRENT_HASH"
exit 1
fi

CURRENT_BRANCH="$(git branch --show-current)"
git stash -u
echo
echo
echo "All current working changes have been stashed."
echo "You can apply them by running \`git stash apply\`."
echo
echo
git checkout -f "$CURRENT_BRANCH"
git reset --hard "$CURRENT_BRANCH"
echo
echo
echo "Run Clean Up in Eclipse using the imported profile"
echo "Press enter to continue..."
read -r
echo
echo
git add -A
FORMAT_COMMIT="0"
if git commit -m 'format'; then
FORMAT_COMMIT="1"
fi

git checkout -f workspace/master
git reset --hard workspace/master
cp -r . "$TMP_DIR"
rm -rf "$TMP_DIR"/.git

git branch -D update-branch || :
git checkout -b update-branch "$CURRENT_HASH"
git reset --hard "$CURRENT_HASH"
echo
echo
echo "Run Clean Up in Eclipse using the imported profile"
echo "Press enter to continue..."
read -r
echo
echo
find . -type f -print0 | xargs -0 dos2unix || :
find . -type f -print0 | xargs -0 chmod -x || :
chmod +x ./gradlew ./*.sh
git add -A
git commit --amend -m "$(git log -n 1 --format='%s' "$CURRENT_HASH")" -m "$(git log -n 1 --format='%b' "$CURRENT_HASH")"

cp -r "$TMP_DIR"/ ./
rm -rf "$TMP_DIR"
echo
echo
echo "Run Clean Up in Eclipse using the imported profile"
echo "Press enter to continue..."
read -r
echo
echo
find . -type f -print0 | xargs -0 dos2unix || :
find . -type f -print0 | xargs -0 chmod -x || :
chmod +x ./gradlew ./*.sh
git add -A
git commit -m "$(git log -n 1 --format='%s' workspace/master)" -m "$(git log -n 1 --format='%b' workspace/master)"

git checkout -f "$CURRENT_BRANCH"
git reset --hard "$CURRENT_BRANCH"
if ! git cherry-pick -n "$(git log -n 1 --format="%H" update-branch)"; then
echo
echo
echo "Fix all merge conflicts before continuing."
echo "Press enter to continue..."
read -r
echo
echo
fi

git add -A
echo
echo
while [[ -z "${COMMIT_NAME:-}" ]]; do
echo "Please enter a commit name."
read -rp "> " COMMIT_NAME
done
echo
echo
if [[ "$FORMAT_COMMIT" == "1" ]]; then
git commit --amend -m "$COMMIT_NAME"
else
git commit -m "$COMMIT_NAME"
fi

git branch -D update-branch

echo
echo
echo "Done!"
SCRIPT_DONE="1"
exit
