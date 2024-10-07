#!/bin/sh
java -cp "desktopRuntime/MakeOfflineDownload.jar:desktopRuntime/CompileEPK.jar" net.lax1dude.eaglercraft.v1_8.buildtools.workspace.MakeOfflineDownload "desktopRuntime/resources/OfflineDownloadTemplate.txt" "javascript/classes.js" "javascript/assets.epk" "javascript/Starlike_Client_Offline.html"
