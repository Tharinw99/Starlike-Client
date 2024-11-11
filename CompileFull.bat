call CompileEPK &&
call CompileJS &&
call MakeOfflineDownload &&
cd wasm_gc_teavm &&
call CompileEPK &&
call CompileWASM &&
call CompileEagRuntimeJS &&
call CompileBootstrapJS &&
call CompileLoaderWASM &&
call MakeWASMClientBundle &&
cd ..
