@echo off
title MakeSignedClient
java -cp "desktopRuntime/MakeOfflineDownload.jar;desktopRuntime/CompileEPK.jar" net.lax1dude.eaglercraft.v1_8.buildtools.workspace.MakeSignedClient "desktopRuntime/resources/SignedBundleTemplate.txt" "javascript/classes.js" "javascript/assets.epk" "desktopRuntime/resources/SignedClientTemplate.txt" "desktopRuntime/resources/UpdateDownloadSources.txt" "javascript/Starlike_Client_Offline_Signed.html"
pause