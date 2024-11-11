#!/bin/sh
cd javascript
touch favicon.png
java -cp "../buildtools/org.tukanni.xz.jar:../buildtools/MakeWASMClientBundle.jar:../../desktopRuntime/CompileEPK.jar:../../desktopRuntime/MakeOfflineDownload.jar" net.lax1dude.eaglercraft.v1_8.buildtools.workspace.MakeWASMClientBundle epw_src.txt epw_meta.txt "../../javascript"
rm -f favicon.png ../../javascript/favicon.png
