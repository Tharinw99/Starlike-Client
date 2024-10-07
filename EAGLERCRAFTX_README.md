
# EaglercraftX 1.8

### Play Minecraft 1.8 in your browser, supports singleplayer and multiplayer

![EaglercraftX 1.8 Screenshot Main Menu](https://deev.is/eagler/cors/eagler-1.8-u22-titlescreen-480p.png)

### This repository contains:

 - **Utilities to decompile Minecraft 1.8 and apply patch files to it**
 - **Source code to provide the LWJGL keyboard, mouse, and OpenGL APIs in a browser**
 - **Patch files to mod the Minecraft 1.8 source code to make it browser compatible**
 - **Browser-modified portions of Minecraft 1.8's open-source dependencies**
 - **Plugins for Minecraft servers to allow the eagler client to connect to them**

### This repository does NOT contain:

 - **Any portion of the decompiled Minecraft 1.8 source code or resources**
 - **Any portion of Mod Coder Pack and it's config files**
 - **Data that can be used alone to reconstruct portions of the game's source code**

## Getting Started:

### To compile the latest version of the client, on Windows:

1. Make sure you have at least Java 11 installed and added to your PATH, it is recommended to use Java 17
2. Download (clone) this repository to your computer
3. Double click `CompileLatestClient.bat`, a GUI resembling a classic windows installer should open
4. Follow the steps shown to you in the new window to finish compiling

### To compile the latest version of the client, on Linux/macOS:

1. Make sure you have at least Java 11 installed, it is recommended to use Java 17
2. Download (clone) this repository to your computer
3. Open a terminal in the folder the repository was cloned to
4. Type `chmod +x CompileLatestClient.sh` and hit enter
5. Type `./CompileLatestClient.sh` and hit enter, a GUI resembling a classic windows installer should open
6. Follow the steps shown to you in the new window to finish compiling

## Browser Compatibility

EaglercraftX 1.8 is currently known to work on browsers as old as Chrome 38 on Windows XP, the game supports both WebGL 1.0 and WebGL 2.0 however features such as dynamic lighting and PBR shaders require WebGL 2.0. The game also supports mobile browsers that don't have a keyboard or mouse, the game will enter touch screen mode automatically when touch input is detected. The game also includes an embedded OGG codec (JOrbis) for loading audio files on iOS where the browsers don't support loading OGG files in an AudioContext.

## Singleplayer

EaglercraftX 1.8 fully supports singleplayer mode through an integrated server. Worlds are saved to your browser's local storage and are available even if your device does not have an internet connection. You can also import and export worlds in EaglercraftX as EPK files to copy them between devices and send them to your friends.

You can also import and export your existing vanilla Minecraft 1.8 worlds into EaglercraftX using ZIP files if you want to try playing all your old 1.8 maps in a modern browser. The glitch that caused some chunks to become corrupt when exporting worlds as vanilla in Eaglercraft 1.5.2 no longer happens in EaglercraftX 1.8, its perfect now. Beware that the inventories of LAN world players are not saved when the world is converted to vanilla, and pets (dogs, cats, horses, etc) might sometimes forget their owners due to the UUID changes.

## Shared Worlds

**This feature used to be known as "LAN Worlds" but has been renamed to "Shared Worlds" to avoid confusion**

If you would like to invite other players to join your singleplayer world and play the game together, use the "Invite" button in the pause menu. You can configure gamemode and cheats for the other players joining your world, you can also decide if you would like to hide your world from other people on your wifi network or advertise your world to them. If hidden is "off" then other people on your same wifi network will see your world listed on their game's "Multiplayer" screen with all of their servers like how sharing LAN worlds behave in vanilla Minecraft 1.8.

Once you press "Start Shared World", EaglercraftX 1.8 will give you a "join code" (usually 5 letters) to share with your friends. On a different device, go the "Multiplayer" screen and press "Direct Connect" and press "Join Shared World", enter the join code given to you when you started the shared world and press "Join World". Given a few seconds, the client should successfully be able to join your shared world from any other device on the internet that also has unrestricted internet access. If it does not work, check the "Network Settings" screen and make sure you and your friends all have the same set of shared world relay URLs configured or your clients will not be able to find each other.

If you would like to host your own relay, the JAR file and instructions can be downloaded from the "Network Settings" screen in the client. EaglercraftX 1.8 uses the same "LAN world" relay server that is used by Eaglercraft 1.5.2, if you would like the relay source code find a random copy of the Eaglercraft 1.5.2 source code and it should be located in the "sp-relay" folder. The relay has not been updated since then, it has only been renamed from "LAN world relay" to "Shared world relay".

## PBR Shaders

EaglercraftX 1.8 includes a deferred physically-based renderer modeled after the GTA V rendering engine with many new improvements and a novel raytracing technique for fast realistic reflections. It can be enabled in the "Shaders" menu in the game's options screen. Shader packs in EaglercraftX are just a component of resource packs, so any custom shaders you install will be in the form of a resource pack. EaglercraftX also comes with a very well optimized built-in PBR shader pack and also a built-in PBR material texture pack to give all blocks and items in the game realistic lighting and materials that looks better than most vanilla Minecraft shader packs. The default shader and texture packs were created from scratch by lax1dude, shaders packs made for vanilla Minecraft will not work in EaglercraftX and no shaders in EaglercraftX were taken from vanilla Minecraft shader packs. The shaders are not available in WebGL 1.0 mode or if floating point HDR render targets are not fully supported.

## Voice Chat

EaglercraftX 1.8 includes an integrated voice-chat service that can be used in shared worlds and also on multiplayer servers when it is enabled by the server owner. This feature also uses WebRTC like shared worlds, so be careful that you don't leak your IP address accidentally by using it on a public server. If you own a website and don't want people to use voice chat on it, edit the `eaglercraftXOpts` variable in your index.html and add `allowVoiceClient: false`.

## Resource Packs

EaglercraftX 1.8 allows you to use any vanilla Minecraft 1.8 resource pack in your browser by importing it as a zip file, resource packs are saved to your browser's local storage and are saved between page refreshes. This can be used to add the original C418 soundtrack back into the game, download and import [this pack](https://bafybeiayojww5jfyzvlmtuk7l5ufkt7nlfto7mhwmzf2vs4bvsjd5ouiuq.ipfs.nftstorage.link/?filename=Music_For_Eaglercraft.zip) to add music back to Eaglercraft. A known bug with the debug desktop runtime is that sound files in resource packs do not play, this may be fixed in the future but is not a high priority issue.

If you are creating a resource pack and want to disable the blur filter on the main menu panorama, create a file called `assets/minecraft/textures/gui/title/background/enable_blur.txt` in your pack and set it's contents to `enable_blur=0`

## Making a Server

To make a server for EaglercraftX 1.8 the recommended software to use is EaglercraftXBungee ("EaglerXBungee") which is included in this repository in the `gateway/EaglercraftXBungee` folder. This is a plugin designed to be used with BungeeCord to allow Eaglercraft players to join your BungeeCord server. It is assumed that the reader already knows what BungeeCord is and has a working server set up that is joinable via java edition. If you don't know what BungeeCord is, please research the topic yourself first before continuing. Waterfall and FlameCord have also been tested, but EaglerXBungee was natively compiled against BungeeCord.

There is an experimental velocity plugin available in `gateway/EaglercraftXVelocity` but it is still in development and not recommended for public servers, so be sure to check for updates regularly if you use it. Configuration files are basically identical to EaglercraftXBungee so its safe to just directy copy in your old EaglercraftXBungee config files to the `plugins/eaglerxvelocity` folder and they should work with a minimal number of edits if you are migrating your network from BungeeCord to Velocity.

### Detailed READMEs

- [**EaglerXBungee README**](README_EAGLERXBUNGEE.md)
- [**EaglerXVelocity README**](README_EAGLERXVELOCITY.md)
- [**EaglerXBukkitAPI README**](README_EAGLERXBUKKITAPI.md)

### Installation

Obtain the latest version of the EaglerXBungee JAR file (it can be downloaded in the client from the "Multiplayer" screen) and place it in the "plugins" folder of your BungeeCord server. It's recommended to only join native Minecraft 1.8 servers through an EaglerXBungee server but plugins like ProtocolSupport have allowed some people to join newer servers too.

Configuration files and other plugin data will be written in `plugins/EaglercraftXBungee`

### Online Mode Instructions

1. Enable `online_mode` in BungeeCord's `config.yml` file and make sure it works
2. Join the BungeeCord server using Minecraft Java Edition while logged into your Microsoft account
3. Run the `/eagler` command, it will give you a temporary login code
4. Disconnect from the server, close java edition, launch EaglercraftX 1.8
5. Set your profile username to the username of your Microsoft account
6. Go to the "Multiplayer" menu, press "Direct Connect", press "Connect to Server", then enter "ws://localhost:8081/"
7. If you are using a VPS, replace "localhost" with the IP address of the VPS when you connect
8. Press "Join Server", a login screen will be displayed, enter the temporary login code into the password field
9. EaglerXBungee will log you into the server as the Microsoft account you generated the login code with

Players using EaglercraftX will be able to see the vanilla skins of players on the server using vanilla Minecraft, but players on the server using vanilla Minecraft won't be able to see the skins of players using Eaglercraft. Instead they will see the skin of the Minecraft account that was used when the Eaglercraft player originally ran the `/eagler` command.

To disable this vanilla player skin feature and stop the plugin from downloading the textures of any player heads spawned with commands, edit the EaglercraftXBungee `settings.yml` file in the `plugins/EaglercraftXBungee` folder and change `download_vanilla_skins_to_clients` to `false`. Ratelimits configured in `settings.yml` define the maximum number of times per minute a single player is allowed to trigger profile/skin lookups and also define the maximum number of times per minute the entire server is allowed to actually perform profile/skin lookups.

By default, EaglercraftXBungee will use a local SQLite database in the server's working directory to store player skins and authentication codes. SQLite will be downloaded automatically if it is not already present. If you would like to use MySQL or something else instead, EaglercraftXBungee is JDBC-based and supports any database type that you can find a driver for. You can set the path of the database, path of the driver JAR, and the name of the driver class (example: `org.sqlite.JDBC`) for storing player skins in `settings.yml` and for storing login codes and profiles in `authservice.yml`.

### Offline Mode Instructions

By setting `online_mode` to `false` in the BungeeCord `config.yml` the authentication system will be disabled and players will no longer be required to first generate a code to log in. This should only be used for testing or if you can't get the authentication system to work. EaglercraftXBungee's skin system is supposed to be able to display SkinsRestorer skins if you plan to have vanilla players on the server but it's not guaranteed.

### Built-in HTTP server

When configuring the EaglercraftXBungee `listeners.yml` file, every listener includes an `http_server` section that can be used to configure the listener to also behave like a regular HTTP server when the websocket address is entered into a browser. If this is disabled people will get the normal "404 Websocket Upgrade Failure" instead when they accidentally type your server address into their browser. `root` defines the path to the folder containing index.html and the other files you want to host, relative to the `plugins/EaglercraftXBungee` folder. This can be useful for hosting the client if the offline download doesn't work for some reason but might slow your BungeeCord server down if lots of people are loading it all the time.

### Enabling Voice Chat

Voice chat is disabled by default in EaglercraftXBungee because it is not recommended for use on public servers. To enable it, add or change `allow_voice: true` to your EaglercraftXBungee `listeners.yml` file. The main difference between Eaglercraft 1.5.2 and EaglercraftX 1.8's voice chat feature is that the "Global" channel now only includes other players on the same server as you instead of every single player connected to the same bungeecord proxy. If you would like to disable voice chat on certain servers, add the names of the servers to the `disable_voice_chat_on_servers` list in the EaglercraftXBungee `settings.yml` file. You may have to add this property to the YML file manually if you've upgraded your server from an older version of EaglercraftXBungee.

### Disabling FNAW Skins

Players are known to complain about the high-poly Five Nights At Winstons character skins making PVP harder because of the belief that they change a player's hitbox. If you would like to disable those skins in your PVP worlds you can either set `disable_fnaw_skins_everywhere: true` in your EaglercraftXBungee `settings.yml` file to disable them for all players on your whole BungeeCord proxy, or you can disable them on specific servers by adding the names of the servers to the `disable_fnaw_skins_on_servers` list also in `settings.yml` like with disabling voice chat.

## Launch Options

The EaglercraftX 1.8 client is configured primarily through a variable called `window.eaglercraftXOpts` that must be set before the client starts up.

The default eaglercraftXOpts values is this:

    const relayId = Math.floor(Math.random() * 3);
    window.eaglercraftXOpts = {
        demoMode: false,
        container: "game_frame",
        assetsURI: "assets.epk",
        localesURI: "lang/",
        worldsDB: "worlds",
        servers: [
            { addr: "ws://localhost:8081/", name: "Local test server" }
        ],
        relays: [
            { addr: "wss://relay.deev.is/", comment: "lax1dude relay #1", primary: relayId == 0 },
            { addr: "wss://relay.lax1dude.net/", comment: "lax1dude relay #2", primary: relayId == 1 },
            { addr: "wss://relay.shhnowisnottheti.me/", comment: "ayunami relay #1", primary: relayId == 2 }
        ]
    };

### List of available options

- `container:` the ID of the HTML element to create the canvas in **(required)**
- `assetsURI:` the URL of the assets.epk file **(required)**
- `localesURI:` the URL where extra .lang files can be found
- `lang`: the default language to use for the game (like "en_US")
- `joinServer`: server address to join when the game launches
- `worldsDB:` the name of the IndexedDB database to store worlds in
- `resourcePacksDB:` the name of the IndexedDB database to store resource packs in
- `demoMode:` whether to launch the game in java edition demo mode
- `servers:` a list of default servers to display on the Multiplayer screen
- `relays:` the default list of shared world relays to use for invites
- `checkShaderGLErrors:` enables more verbose opengl error logging for the shaders
- `enableDownloadOfflineButton:` whether to show a "Download Offline" button on the title screen
- `downloadOfflineButtonLink:` overrides the download link for the "Download Offline" button
- `html5CursorSupport:` enables support for showing the CSS "pointer" cursor over buttons
- `allowUpdateSvc:` enables the certificate-based update system
- `allowUpdateDL:` allows the client to download new updates it finds
- `logInvalidCerts:` print update certificates with invalid signatures to console
- `enableSignatureBadge:` show a badge on the title screen indicating if digital signature is valid
- `checkRelaysForUpdates:` proprietary feature used in offline downloads
- `allowVoiceClient:` can be used to disable the voice chat feature
- `allowFNAWSkins:` can be used to disable the high poly FNAW skins
- `localStorageNamespace:` can be used to change the prefix of the local storage keys (Default: `"_eaglercraftX"`)
- `enableMinceraft:` can be used to disable the "Minceraft" title screen
- `crashOnUncaughtExceptions:` display crash reports when `window.onerror` is fired
- `openDebugConsoleOnLaunch:` open debug console automatically at launch
- `fixDebugConsoleUnloadListener:` close debug console beforeunload instead of unload
- `forceWebViewSupport:` if the server info webview should be allowed even on browsers without the required safety features
- `enableWebViewCSP:` if the `csp` attibute should be set on the server info webview for extra security
- `enableServerCookies:` can be used to disable server cookies
- `allowServerRedirects:` if servers should be allowed to make the client reconnect to a different address
- `autoFixLegacyStyleAttr:` if the viewport meta tag and style attributes on old offline downloads and websites should be automatically patched
- `showBootMenuOnLaunch:` if the client should always show the boot menu on every launch
- `bootMenuBlocksUnsignedClients:` if the boot menu should only be allowed to launch signed clients
- `allowBootMenu:` can be used to disable the boot menu entirely
- `forceProfanityFilter:` if the profanity filter should be forced enabled
- `forceWebGL1:` if the game should force the browser to only use WebGL 1.0 for the canvas
- `forceWebGL2:` if the game should force the browser to only use WebGL 2.0 for the canvas
- `allowExperimentalWebGL1:` if the game should be allowed to create an `experimental-webgl` context
- `useWebGLExt:` can be used to disable all OpenGL ES extensions to test the game on a pure WebGL 1.0/2.0 context
- `useDelayOnSwap:` if the game should `setTimeout(..., 0)` every frame instead of using MessageChannel hacks
- `useJOrbisAudioDecoder:` if OGG vorbis files should be decoded using the JOrbis Java OGG decoder instead of using the browser
- `useXHRFetch:` if the game should use XMLHttpRequest for downloading resources instead of the fetch API
- `useVisualViewport:` if the game should resize some GUIs relative to `window.visualViewport` (needed on mobile browsers when the keyboard is open)
- `deobfStackTraces:` can be used to disable the runtime stack-trace deobfuscation, reduces micro stutters if the game is logging errors
- `disableBlobURLs:` if the game should use `data:` URLs instead of `blob:` URLs for loading certain resources
- `eaglerNoDelay:` can be used to disable "Vigg's Algorithm", an algorithm that delays and combines multiple EaglercraftX packets together if they are sent in the same tick (does not affect regular Minecraft 1.8 packets)
- `ramdiskMode:` if worlds and resource packs should be stored in RAM instead of IndexedDB
- `singleThreadMode:` if the game should run the client and integrated server in the same context instead of creating a worker object
- `enableEPKVersionCheck:` if the game should attempt to bypass the browser's cache and retry downloading assets.epk when its outdated
- `hooks:` can be used to define JavaScript callbacks for certain events
    * `localStorageSaved:` JavaScript callback to save local storage keys (key, data)
    * `localStorageLoaded:` JavaScript callback to load local storage keys (key) returns data
    * `crashReportShow:` JavaScript callback when a crash report is shown (report, customMessageCB)
    * `screenChanged:` JavaScript callback when the screen changes/resizes (screenName, scaledWidth, scaledHeight, realWidth, realHeight, scaleFactor)

### Using Hooks

You may want to implement some custom logic for loading/saving certain local storage keys. The eaglercraftXOpts hooks section can be used to override the client's local storage load and save functions. Currently, local storage keys are used to save game settings, the user's profile, custom servers, and shared world relays. Worlds and resource packs do not use local storage keys because modern browsers limit local storage keys to only 5 megabytes per domain which is too small for saving entire worlds and resource packs. Worlds and resource packs are saved using [IndexedDB](https://developer.mozilla.org/en-US/docs/Web/API/IndexedDB_API).

    window.eaglercraftXOpts = {
        ...
        ...
        ...
        hooks: {
            localStorageSaved: function(key, data) {
                // 'key' is local storage key name as a string
                // 'data' is base64-encoded byte array as a string
                // function returns nothing
            },
            localStorageLoaded: function(key) {
                // 'key' is local storage key name as a string
                // function returns a base64-encoded byte array as a string
                // function returns null if the key does not exist
            }
        }
    }

Be aware that the client will still save the key to the browser's local storage anyway even if you define a custom save handler, and will just attempt to load the key from the browser's local storage normally if you return null, these are meant to be used like event handlers for creating backups of keys instead of completely replacing the local storage save and load functions.

On a normal client you will only ever need to handle local storage keys called `p` (profile), `g` (game settings), `s` (server list), `r` (shared world relays), in your hooks functions. Feel free to just ignore any other keys. It is guaranteed that the data the client stores will always be valid base64, so it is best practice to decode it to raw binary first if possible to reduce it's size before saving it to something like a MySQL database in your backend if you are trying to implement some kind of profile syncing system for your website. The keys already have GZIP compression applied to them by default so don't bother trying to compress them yourself a second time because it won't reduce their size.

### Crash Report Hook

The `crashReportShow` hook can be used to capture crash reports and append additional text to them. It takes two parameters, the crash report as a string and a callback function for appending text. Do not use the callback function outside the body of the hook.

    hooks: {
        crashReportShow: function(report, customMessageCB) {
            // 'report' is crash report as a string
            customMessageCB("Hello from crashReportShow hook!");
        }
    }

## Developing a Client

There is currently no system in place to make forks of 1.8 and merge commits made to the patch files in this repository with the patch files or workspace of the fork, you're on your own if you try to keep a fork of this repo for reasons other than to contribute to it

A javascript-based modding API resembling Minecraft Forge may be implemented someday though for adding custom content to the game.

# EaglercraftX 1.8 Workspace

### Java 17 is recommended for compiling to TeaVM

### Java 8 or greater is required for the desktop runtime

**Most Java IDEs will allow you to import this repository as a gradle project for compiling it to JavaScript.**

Java must be added to your PATH!

**To compile the web client:**
1. Run `CompileEPK`
2. Run `CompileJS` (or the `generateJavaScript` gradle task in your IDE)
3. Check the "javascript" folder

**To compile an offline download:**
1. Run `CompileEPK`
2. Run `CompileJS` (or the `generateJavaScript` gradle task in your IDE)
3. Run `MakeOfflineDownload`
4. Check the "javascript" folder

**To use the desktop runtime:**
1. Import the Eclipse project in "desktopRuntime/eclipseProject" into your IDE
2. Open one of the .java files from the source folders (workaround for a bug)
3. Run/Debug the client with the included "eaglercraftDebugRuntime" configuration

**See the main 1.8 repository's README for more info**

The source codes of EaglercraftXBungee and EaglercraftXVelocity are not included here.

# Eaglercraft Code Standards

**These are some basic rules to follow if you would like to write code that is consistent with the Eaglercraft 1.8 codebase. If you are already familiar with Eaglercraft 1.5 or b1.3, please abandon whatever you think is the best practice as a result of reading that code, those clients should be considered as obsolete prototypes.**

## Part A. Coding Style

### 1. Tabs, not spaces

Tabs not spaces, it makes indentation easier to manage and reduces file size. Other popular projects that are also known to use tabs instead of spaces include the linux kernel. We prefer to set tab width to 4 spaces on our editors.

Format code like the eclipse formatter on factory settings

### 2. Avoid redundant hash map lookups

Don't retrieve the same value from a hash map more than once, that includes checking if an entry exists first before retrieving its value. If you do this, you are a horrible person!

**Incorrect:**

```java
if(hashMap.containsKey("eagler")) {
    Object val = hashMap.get("eagler");
    // do something with val
}
```

**Correct:**

```java
Object val = hashMap.get("eagler");
if(val != null) {
    // do something with val
}
```

### 3. Cache the return value of a function if you plan to use it multiple times

This is somewhat an extension of rule #2, don't repeatedly call the same function multiple times if there's no reason to, even if its a relatively fast function. Everything is slower and less efficient in a browser.

**Incorrect:**

```java
while(itr.hasNext()) {
    if(!Minecraft.getMinecraft().getRenderManager().getEntityClassRenderObject(SomeEntity.class).shouldRender(itr.next())) {
        itr.remove();
    }
}
```

**Correct:**

```java
Render<SomeEntity> render = Minecraft.getMinecraft().getRenderManager().getEntityClassRenderObject(SomeEntity.class);
while(itr.hasNext()) {
    if(!render.shouldRender(itr.next())) {
        itr.remove();
    }
}
```

### 4. Iterators aren't that great

Avoid using iterators when possible, this includes a `for(Item item : list)` type loop, since this may compile into bytecode that uses an iterator. If the list is a linked list or some other type of data structure that can’t perform random access efficiently, then it is recommended to use an iterator, but if the collection is guaranteed to be something similar to an ArrayList then implement it via a traditional for loop instead.

**Recommended way to iterate an ArrayList:**

```java
for(int i = 0, l = list.size(); i < l; ++i) {
    Item item = list.get(i);
    // do something
}
```

### 5. Don't shit on the heap

Avoid creating temporary single-use objects in performance critical code, since the overhead of doing so is larger in a browser where there’s no type safety to predefine object structures. This includes using lambdas or using most of the stuff in the google guava package. Also this is partially why I prefer not using iterators whenever possible.

**Incorrect, creates 5 temporary objects:**

```java
List<String> list1 = Arrays.asList("eagler", "eagler", "deevis");
List<String> list2 = Lists.newArrayList(
    Collections2.transform(
        Collections2.filter(
            list1,
            (e) -> !e.equals("deevis")
        ),
        (e) -> (e + "!")
    )
);
```

**Correct, creates no temporary objects:**

```java
List<String> list1 = Arrays.asList("eagler", "eagler", "deevis");
List<String> list2 = Lists.newArrayList();
for(int i = 0, l = list1.size(); i < l; ++i) {
    String s = list1.get(i);
    if(!s.equals("deevis")) {
        list2.add(s + "!");
    }
}
```

(note: we are ignoring the StringBuilder instances that the compiler generates from ` + "!"`)

### 6. Don't base game/render logic off of the system time

Use `EagRuntime.steadyTimeMillis()` instead to access a monotonic clock, as in a clock that is guaranteed to only run forwards, and is not affected by changes in the system time. `System.currentTimeMillis()` should only be used in situations where you want to know the actual wall time or are measuring elapsed time across multiple page refreshes.

### 7. Prefer multiplication over division

If you're always gonna divide a number by some constant, it is better to multiply it by one-over-the-constant instead.

**Incorrect**

```java
float b = a / 50.0f;
```

**Correct**

```java
float b = a * 0.02f;
```

### 8. Shaders should take advantage of compiler intrinsics

Although you may think these two pieces of code are identical, its more than likely that the "Correct" example will compile to a more efficient shader on almost any hardware. The functions in GLSL are not a library, they are compiler intrinsics that usually compile to inline assembly that can take advantage of different acceleration instructions in the GPU's instruction set. Vector math should be done in ways that promotes the use of SIMD instructions when the code is compiled to a shader.

**Incorrect:**

```glsl
float dx = pos1.x - pos2.x;
float dy = pos1.y - pos2.y;
float dz = pos1.z - pos2.z;
float distance = sqrt(dx * dx + dy * dy + dz * dz);
float fogDensity = pow(2.718, -density * distance);
```

**Correct:**

```glsl
float fogDensity = exp(-density * length(pos1.xyz - pos2.xyz));
```

### 9. Flatten the control flow of shaders

Modern GPUs are able to execute multiple instances of a shader on a single core, but if one of those shaders encounters a branch (if statement, or related) that causes it to begin executing different code from the other instances of the shader running on that core, that instance of the shader can no longer be executed at the same time as the other instances, and suddenly you've significantly increased the amount of time this core will now be busy executing shader instructions to account for all of the branches the different shader instances have taken.

**Incorrect:**

```glsl
float lightValue = dot(lightDirection, normal);
if(lightValue > 0.0) {
    color += lightValue * lightColor * diffuseColor;
}
```

**Correct:**
```glsl
float lightValue = max(dot(lightDirection, normal), 0.0);
color += lightValue * lightColor * diffuseColor;
```

### 10. Use textureLod unless mipmapping is necessary

This will prevent the shader from wasting time trying to determine what mipmap levels to read from when the texture is sampled.

**Incorrect:**

```glsl
float depthValue = texture(depthBuffer, pos).r;
```

**Correct:**

```glsl
float depthValue = textureLod(depthBuffer, pos, 0.0).r;
```

### 11. Divide complex and branch-intensive shaders into multiple draw calls

You can use a variety of different blending modes to mathematically combine the results of shaders. This is done for the same reason as flattening the control flow, to try and keep instruction pointers in sync by periodically resetting their positions, and also to allow for the driver to multitask better on GPUs with insane numbers of cores. It also allows the shader’s execution to be distributed across multiple frames in the case of something that doesn’t need to update often (like clouds).


### 12. Don't abuse `@JSBody` in TeaVM code

TeaVM provides lots of ways of interacting with JavaScript, using `@JSBody` is not the only way, consider using an overlay type.

**Incorrect**

```java
@JSObject(params = { "obj" }, script = "return obj.valueA;")
public static native JSObject getValueA(JSObject obj);

@JSObject(params = { "obj" }, script = "return obj.valueB;")
public static native JSObject getValueB(JSObject obj);

@JSObject(params = { "obj" }, script = "return obj.valueC;")
public static native JSObject getValueC(JSObject obj);

@JSObject(params = { "obj" }, script = "obj.dumbFunction();")
public static native void callDumbFunction(JSObject obj);
```

**Correct**

```java
public interface MyObject extends JSObject {

    @JSProperty
    JSObject getValueA();

    @JSProperty
    JSObject getValueB();

    @JSProperty
    JSObject getValueC();

    void dumbFunction();

}
```

### 13. Don't fall for TeaVM's threads

It is impossible to have multithreading in JavaScript, only worker objects can be used to execute code concurrently, which can't share javascript variables. Therefore, when you create a thread in TeaVM, you're creating a virtual thread that isn't capable of running at the same time as any other virtual thread in the TeaVM context. This means it's impossible to speed a TeaVM program up through the use of multiple Java threads, instead it is more than likely that it will just slow the program down more to implement multithreading through TeaVM's threads due to the additional time required for synchronization and context switches. Its more efficient to just program the entire application to be single threaded to begin with, just put everything in the main loop and realize that if it was in a different thread it would just periodically interrupt the main loop.

### 14. Always use try-with-resources

For any code that deals with streams to be considered safe, it should either use a try-with-resources or try/finally in order to release resources when complete, since otherwise the stream might not close if an IO error causes the function to return early. This is especially important for plugin code since its supposed to be able to run on a large server for weeks at a time without the underlying JVM being restarted. If hackers discover a bug in the code to cause a function to return early like this without closing a stream, they might exploit it to fatally crash the server by spamming whatever corrupt packet causes the function to leak the stream, so all code must be written so it can fail at any time without leaking resources.

**Incorrect**

```java
InputStream is = new FileInputStream(new File("phile.txt"));
is.write(someArray);
is.close();
```

**Correct**

```java
try(InputStream is = new FileInputStream(new File("phile.txt"))) {
    is.write(someArray);
}
```

Notice that the `.close()` can be omitted completely when using a try-with-resources

### 15. Always close compression/decompression streams 

In the desktop runtime, the default oracle JDK uses native code to implement the compression/decompression streams (InflaterInputStream, GZIPInputStream, etc) and therefore if you forget to close the compression/decompression stream it will cause a memory leak when the code isn't running in a browser. This is a common issue when using byte array input/output streams since you might believe when decompressing data from a byte array that there's no reason to close the stream when you're done since its not a file, but that will still cause a memory leak due to the decompression stream not being cleaned up.

## Part B. Project Structure

### 1. Code decompiled from Minecraft goes in `src/game/java`

Don't add any new classes to `src/game/java`, and ideally any significant additions to the game's source (functions, etc) should be done through creating new classes in `src/main/java` instead of adding it directly to the decompiled classes.

### 2. Do not put platform-dependent code in `src/main/java` or `src/game/java`

One of the objectives of Eaglercraft is to make Minecraft Java edition truly cross platform, why stop at just a desktop and JavaScript runtime? There are plans to create an Android runtime and several WebAssembly runtimes, all of which will be compatible with any pre-existing eaglercraft clients that only depend on the EaglercraftX runtime library and don't directly depend on components of TeaVM or LWJGL. Ideally, all core features of the client should be implemented in the `src/main/java` and `src/game/java` and any platform-dependent features should be stubbed out in some abstract platform-independent way in classes in the `src/teavm/java` and `src/lwjgl/java` and any other future runtime you want your client to support. Ideally, every source folder of platform-dependent code should expose an identical API for access to the platform-independent code as all the other platform-dependant code folders currently expose.

### 3. Don't mix JavaScript with Java

Don’t implement features in the JavaScript runtime by requiring additional JavaScript files be included on index.html, if you must access browser APIs then use the TeaVM JSO to write your code in Java instead so it’s baked directly into classes.js. Certain browser APIs may be missing from the default TeaVM JSO-APIs library but it is not difficult to create the overlay types for them manually. Clients that violate this rule may also not possible to automatically import into the EaglercraftX boot menu depending on how fucked up they are. There aren't any limitations to the TeaVM JSO that give you a good enough excuse not to follow this rule.

### 4. Don't access the classes named "Platform\*" directly from your platform-independent code

Much like the Java runtime environment itself, Eaglercraft's runtime library consists of two layers, the internal classes full of platform-dependent code that expose an intermediate API not meant to be used by programmers directly, and the platform-independent API classes that provide a platform-independent wrapper for the platform dependent classes and also provide all the miscellaneous utility functions that don't require platform dependent code to be implemented. Chances are if you are directly using a function on a class that has a name that starts with "Platform\*", that there is a different class in `src/main/java` that you are meant to use in order to access that feature, that may perform additional checks or adjust the values you are passing to the function before calling the function in the Platform class.

## Part C. Compatibility Standards

### 1. Target minimum JDK version is Java 8

Its difficult to find a platform where its not possible to run Java 8 in some capacity, therefore the desktop runtime of EaglercraftX and the BungeeCord plugin should target Java 8. The Velocity plugin is an exception since Velocity itself doesn't support Java 8 either.

### 2. Target minimum supported browser is Google Chrome 38

Released on October 7, 2014, we think its a good target for the JavaScript versions of EaglercraftX. This is the last version of Chrome that supports hardware accelerated WebGL 1.0 on Windows XP. All base features of the underlying Minecraft 1.8 client must be functional, however things such as EaglercraftX's shaders or dynamic lighting are not required to work. The client cannot crash as a result of any missing features on an old browser, you must either implement fallbacks or safely disable the unsupported features.

### 3. Target minimum supported graphics API is OpenGL ES 2.0 (WebGL 1.0)

The most widely supported graphics API in the world is currently OpenGL ES 2.0, so ideally that should be the target for EaglercraftX 1.8. We can guarantee the client will be on an OpenGL ES 3.0 context 99% of the time, however its not that hard to also maintain support for GLES 2.0 (WebGL 1.0) as well with slightly reduced functionality so we might as well make it a feature in case of the 1% of the time that functionality is not available. The client cannot depend on any GL extensions in order to run in GLES 2.0 mode, however its reasonable to assume there will be VAO support via extensions in most GLES 2.0 contexts so the client includes an abstraction layer (via EaglercraftGPU.java) to seamlessly emulate VAO functionality even when the client is running in GLES 2.0 mode with no VAO extensions. The only core feature of Minecraft 1.8 that is completely unavailable in GLES 2.0 mode is mip-mapping for the blocks/items texture atlas due to being unable to limit the max mipmap level.

### 4. Use preprocessor directives to make portable shaders that can be compiled for both OpenGL ES 2.0 and 3.0 contexts

Most of the shaders in the base "glsl" directory of the resources EPK file use a file called "gles2_compat.glsl" to polyfill certain GLSL features (such as input/output declarations) via preprocessor directives to allow them to be compiled on both OpenGL ES 3.0 and 2.0 contexts. This is the preferred way to implement backwards compatibility over creating seprate versions of the same shaders, since future developers don't need to waste time maintaining multiple versions of the same code if they don't really care about backwards compatibility in the first place.

### 5. Target minimum version of the JavaScript syntax is ES5 strict mode

A shim is included to provide certain ES6 functions, however you should always program with syntax compatible with ES5, so the script doesn't crash immediately due to syntax errors even if the functions that use unsupported syntax aren't actually being called. `build.gradle` currently patches out all the ES5 strict mode incompatible syntax in the output of TeaVM 0.9.2, but this will probably break if you try to update TeaVM. Don't worry though because future WASM versions of EaglercraftX will use the latest versions of TeaVM. **Some common incompatible syntax to avoid includes `const`, `let`, `async`, `( ) => `, and using named functions! You can't do any of these things in your JSBody annotations.**

### 6. You cannot depend on any deprecated browser features

The same way we want EaglercraftX to work on browsers from over 10 years ago, we want it to still work in browsers 10 years from today, therefore the client cannot depend on any deprecated browser features in order for all the base Minecraft 1.8 game's features to work properly. However it is okay to use deprecated features as fallback if any modern non-deprecated feature (such as keyboard event handling) that the game needs if the game is running in an old browser.

### 7. Always use addEventListener to register event handlers

Always use addEventListener to register event handlers for browser APIs, never through the use of assigning the legacy "on\*" (onclick, onkeydown, onmessage, etc) variables, the TeaVMUtils class has a universal helper function for accessing addEventListener on any JSO objects that don’t already implement the function.

### 8. JavaScript should be executed in strict mode

Always make sure your JavaScript files start with `"use strict";`, be careful when adding this to your code retroactively because it will probably break hastily written code unless you haven’t made a single typo that’s not forbidden in strict mode. Be aware that in Chrome 38 this means you can't use stuff such as `const` and `let` or named functions in any of your JSBody annotations!
