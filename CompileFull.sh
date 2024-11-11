#!/bin/sh
. ./CompileEPK.sh &&
. ./CompileJS.sh &&
. ./MakeOfflineDownload.sh &&
cd ./wasm_gc_teavm &&
. ./CompileEPK.sh &&
. ./CompileWASM.sh &&
. ./CompileEagRuntimeJS.sh &&
. ./CompileBootstrapJS.sh &&
. ./CompileLoaderWASM.sh &&
. ./MakeWASMClientBundle.sh &&
cd ..
