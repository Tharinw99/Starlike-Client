import path from 'path';
import fs from 'fs/promises';

let blockId = 695; // replace with next id

const basePath = path.dirname(path.dirname(path.resolve(import.meta.filename)));
const sourceFolder = path.join(basePath, 'EaglerTools', 'makeBlock');
const starlikeAssetsFolder = path.join(
  basePath,
  'desktopRuntime',
  'resources',
  'assets',
  'starlike',
);

const blockTextureFolder = path.join(
  starlikeAssetsFolder,
  'textures',
  'blocks',
);
const blockModelFolder = path.join(starlikeAssetsFolder, 'models', 'block');
const itemModelFolder = path.join(starlikeAssetsFolder, 'models', 'item');
const blockstateFolder = path.join(starlikeAssetsFolder, 'blockstates');
const langFilePath = path.join(starlikeAssetsFolder, 'lang', 'en_US.lang');

const itemsStarlikeJavaPath = path.join(
  basePath,
  'src',
  'main',
  'java',
  'net',
  'starlikeclient',
  'minecraft',
  'init',
  'ItemsStarlike.java',
);
const blocksJavaPath = path.join(
  basePath,
  'src',
  'game',
  'java',
  'net',
  'minecraft',
  'init',
  'Blocks.java',
);

async function createDirectories() {
  await fs.mkdir(blockTextureFolder, { recursive: true });
  await fs.mkdir(blockModelFolder, { recursive: true });
  await fs.mkdir(itemModelFolder, { recursive: true });
  await fs.mkdir(blockstateFolder, { recursive: true });
}

async function insertInFile(
  filePath,
  searchText,
  insertText,
  insertAfter = true,
  tabBefore = false,
) {
  try {
    const content = await fs.readFile(filePath, 'utf8');
    const lines = content.split('\n');

    for (let i = 0; i < lines.length; i++) {
      if (lines[i].includes(searchText)) {
        let insertLine = insertText + '\n';
        if (tabBefore) {
          insertLine = '\t' + insertLine;
        }
        if (insertAfter) {
          lines.splice(i + 1, 0, insertLine);
        } else {
          lines.splice(i, 0, insertLine);
        }
        break;
      }
    }

    await fs.writeFile(filePath, lines.join('\n'));
    console.log(`Updated ${filePath} successfully.`);
    return true;
  } catch (err) {
    console.error(`Error with file ${filePath}: ${err}`);
    return false;
  }
}

async function appendToFile(filePath, newLine) {
  try {
    await fs.appendFile(filePath, newLine + '\n');
    console.log(`Appended to ${filePath} successfully.`);
  } catch (err) {
    console.error(`Error appending to ${filePath}: ${err}`);
  }
}

async function processBlocks() {
  console.log('Welcome to GenerateBlocks (EaglerTools)');
  console.log(
    'Drag the texture of the FULL block into the EaglerTools/makeBlock folder',
  );

  try {
    const files = await fs.readdir(sourceFolder);

    for (const filename of files) {
      if (!filename.endsWith('.png')) continue;

      const blockName = path.parse(filename).name;
      const sourceImage = path.join(sourceFolder, filename);
      const destImage = path.join(blockTextureFolder, filename);

      try {
        await fs.rename(sourceImage, destImage);
        console.log(`Moved image: ${filename} to ${destImage}`);

        // Create blockstate data
        const blockModelData = {
          parent: 'block/cube_all',
          textures: {
            all: `starlike:blocks/${blockName}`,
          },
        };

        // Create item model data
        const itemModelData = {
          parent: `starlike:block/${blockName}`,
          display: {
            thirdperson: {
              rotation: [10, -45, 170],
              translation: [0, 1.5, -2.75],
              scale: [0.375, 0.375, 0.375],
            },
          },
        };

        // Create blockstate JSON data
        const blockstateData = {
          variants: {
            normal: {
              model: `starlike:${blockName}`,
            },
          },
        };

        // Write JSON files
        await fs.writeFile(
          path.join(blockModelFolder, `${blockName}.json`),
          JSON.stringify(blockModelData, null, 4),
        );

        await fs.writeFile(
          path.join(itemModelFolder, `${blockName}.json`),
          JSON.stringify(itemModelData, null, 4),
        );

        await fs.writeFile(
          path.join(blockstateFolder, `${blockName}.json`),
          JSON.stringify(blockstateData, null, 4),
        );

        // Determine material properties
        let materialType = 'Material.rock';
        let hardness = '1.5f';
        let resistance = '10.0f';
        let soundType = 'soundTypePiston';

        if (/log|planks|wood/.test(blockName)) {
          materialType = 'Material.wood';
          hardness = '0.5f';
          resistance = '10.0f';
          soundType = 'soundTypeWood';
        } else if (/steel|iron|grate|bar|copper|gold/.test(blockName)) {
          materialType = 'Material.iron';
          hardness = '5f';
          resistance = '10.0f';
          soundType = 'soundTypeMetal';
        } else if (/dirt|grass/.test(blockName)) {
          materialType = 'Material.ground';
          hardness = '0.5f';
          resistance = '1f';
          soundType = 'soundTypeGround';
        }

        // Generate and insert Java code
        const registrationLine =
          `Block.registerBlock(${blockId}, "starlike:${blockName}", ` +
          `(new Block(${materialType}, MapColor.purpleColor)).setHardness(${hardness}).setResistance(${resistance}) ` +
          `.setStepSound(Block.${soundType}).setUnlocalizedName("${blockName}").setCreativeTab(CreativeTabs.tabStarlike));`;

        await insertInFile(
          itemsStarlikeJavaPath,
          '//autogenerateequals',
          registrationLine,
        );

        const blockDeclaration = `    public static Block ${blockName};`;
        const getRegisteredLine = `        ${blockName} = getRegisteredBlock("starlike:${blockName}");`;

        await insertInFile(
          blocksJavaPath,
          '//autogeneratevar',
          blockDeclaration,
        );
        await insertInFile(
          blocksJavaPath,
          '//autogenerateequals',
          getRegisteredLine,
        );

        const itemBlockRegistration = `Item.registerItemBlock(Blocks.${blockName});`;
        await insertInFile(
          itemsStarlikeJavaPath,
          '//autogenerateregisterblock',
          itemBlockRegistration,
          true,
          true,
        );

        const itemBlockRenderRegistration = `e.registerBlock(Blocks.${blockName},"starlike:${blockName}");`;
        await insertInFile(
          itemsStarlikeJavaPath,
          '//autogeneraterender',
          itemBlockRenderRegistration,
          true,
          true,
        );

        const langEntry = `tile.${blockName}.name=${
          blockName.replace('_', ' ').charAt(0).toUpperCase() +
          blockName.slice(1)
        }`;
        await appendToFile(langFilePath, langEntry);

        blockId++;
      } catch (err) {
        console.error(`Error processing ${filename}: ${err}`);
        continue;
      }
    }
  } catch (err) {
    console.error(`Error reading source folder: ${err}`);
  }
}

// Run the script
createDirectories()
  .then(() => processBlocks())
  .catch((err) => console.error('Error:', err));
