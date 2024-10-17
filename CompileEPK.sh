#!/bin/sh
echo "compiling, please wait..."
java -jar "desktopRuntime/CompileEPK.jar" "desktopRuntime/resources" "javascript/assets.epk"
echo "finished compiling epk"
