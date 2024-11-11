import os
import shutil
import json

base_path = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))

source_folder = os.path.join(base_path,"EaglerTools", "makeBlock")
block_texture_folder = os.path.join(base_path, "desktopRuntime", "resources", "assets", "starlike", "textures", "blocks")
block_model_folder = os.path.join(base_path, "desktopRuntime", "resources", "assets", "starlike", "models", "block")
item_model_folder = os.path.join(base_path, "desktopRuntime", "resources", "assets", "starlike", "models", "item")
blockstate_folder = os.path.join(base_path,"desktopRuntime", "resources", "assets","starlike", "blockstates")
lang_file_path = os.path.join(base_path,"desktopRuntime", "resources", "assets","starlike", "lang", "en_US.lang")

os.makedirs(block_texture_folder, exist_ok=True)
os.makedirs(block_model_folder, exist_ok=True)
os.makedirs(item_model_folder, exist_ok=True)
os.makedirs(blockstate_folder, exist_ok=True)


items_starlike_java_path = os.path.join(
    base_path, "src", "main", "java", "net", "starlikeclient", "minecraft", "init", "ItemsStarlike.java"
)
blocks_java_path = os.path.join(base_path,"src", "game", "java", "net", "minecraft", "init", "Blocks.java")

blockId = 695; #replace with next id
def insert_in_file(file_path, search_text, insert_text, insert_after=True, tab_before=False):
    try:
        with open(file_path, 'r') as file:
            lines = file.readlines()
    except Exception as e:
        print(f"Error reading {file_path}: {e}")
        return False
    
    for i, line in enumerate(lines):
        if search_text in line:
            insert_line = insert_text + '\n'
            if tab_before:
                insert_line = '\t' + insert_line
            if insert_after:
                lines.insert(i + 1, insert_line)
            else:
                lines.insert(i, insert_line)
            break

    try:
        with open(file_path, 'w') as file:
            file.writelines(lines)
        print(f"Updated {file_path} successfully.")
        return True
    except Exception as e:
        print(f"Error writing to {file_path}: {e}")
        return False

def append_to_file(file_path, new_line):
    try:
        with open(file_path, 'a') as file:
            file.write(new_line + '\n')
        print(f"Appended to {file_path} successfully.")
    except Exception as e:
        print(f"Error appending to {file_path}: {e}")

print("Welcome to GenerateBlocks (EaglerTools)")
print("Drag the texture of the FULL block into the ")
for filename in os.listdir(source_folder):
    if filename.endswith(".png"):
        
        block_name = os.path.splitext(filename)[0]

        source_image = os.path.join(source_folder, filename)
        dest_image = os.path.join(block_texture_folder, filename)
        
        try:
            shutil.move(source_image, dest_image)
            print(f"Moved image: {filename} to {dest_image}")
        except Exception as e:
            print(f"Error moving file {filename}: {e}")
            continue

        blockstate_data = {
            "parent": "block/cube_all",
            "textures": {
                "all": f"starlike:blocks/{block_name}"
            }
        }
        blockstate_path = os.path.join(block_model_folder, f"{block_name}.json")
        try:
            with open(blockstate_path, 'w') as blockstate_file:
                json.dump(blockstate_data, blockstate_file, indent=4)
                print(f"Created blockstate JSON: {blockstate_path}")
        except Exception as e:
            print(f"Error writing blockstate JSON for {block_name}: {e}")
            continue

        item_model_data = {
            "parent": f"starlike:block/{block_name}",
            "display": {
                "thirdperson": {
                    "rotation": [10, -45, 170],
                    "translation": [0, 1.5, -2.75],
                    "scale": [0.375, 0.375, 0.375]
                }
            }
        }
        item_model_path = os.path.join(item_model_folder, f"{block_name}.json")
        try:
            with open(item_model_path, 'w') as item_model_file:
                json.dump(item_model_data, item_model_file, indent=4)
                print(f"Created item model JSON: {item_model_path}")
        except Exception as e:
            print(f"Error writing item model JSON for {block_name}: {e}")
            continue

        blockstate_json_data = {
            "variants": {
                "normal": {
                    "model": f"starlike:{block_name}"
                }
            }
        }
        blockstate_json_path = os.path.join(blockstate_folder, f"{block_name}.json")
        try:
            with open(blockstate_json_path, 'w') as blockstate_json_file:
                json.dump(blockstate_json_data, blockstate_json_file, indent=4)
                print(f"Created blockstate JSON: {blockstate_json_path}")
        except Exception as e:
            print(f"Error writing blockstate JSON for {block_name}: {e}")
            continue

        material_type = "Material.wood"
        hardness = "0.5f"
        resistance = "5.0f"
        soundType = "soundTypePiston"
        if any(keyword in block_name for keyword in ["log", "planks", "wood"]):
            material_type = "Material.wood"
            hardness = "0.5f"
            resistance = "10.0f"
            soundType = "soundTypeWood"
        elif any(keyword in block_name for keyword in ["steel", "iron", "grate", "bar", "copper", "gold"]):
            material_type = "Material.iron"
            hardness = "5f"
            resistance = "10.0f"
            soundType = "soundTypeMetal"
        elif any(keyword in block_name for keyword in ["dirt", "grass"]):
            material_type = "Material.ground"
            hardness = "0.5f"
            resistance = "1f"
            soundType = "soundTypeGround"    
        else:
            material_type = "Material.rock"
            hardness = "1.5f"
            resistance = "10.0f"
            soundType = "soundTypePiston"

        registration_line = (
            f"Block.registerBlock({blockId}, \"starlike:{block_name}\", "
            f"(new Block({material_type}, MapColor.purpleColor)).setHardness({hardness}).setResistance({resistance}) "
            f".setStepSound(Block.{soundType}).setUnlocalizedName(\"{block_name}\").setCreativeTab(CreativeTabs.tabStarlike));"
        )
        insert_in_file(items_starlike_java_path, "//autogenerateequals", registration_line)

        block_declaration = f"    public static Block {block_name};"
        get_registered_line = f"        {block_name} = getRegisteredBlock(\"starlike:{block_name}\");"
        insert_in_file(blocks_java_path, "//autogeneratevar", block_declaration)
        insert_in_file(blocks_java_path, "//autogenerateequals", get_registered_line)

        item_block_registration = f"Item.registerItemBlock(Blocks.{block_name});"
        insert_in_file(items_starlike_java_path, "//autogenerateregisterblock", item_block_registration, tab_before=True)
        item_block_render_registration = f'e.registerBlock(Blocks.{block_name},"starlike:{block_name}");'
        insert_in_file(items_starlike_java_path, "//autogeneraterender", item_block_render_registration, tab_before=True)
        lang_entry = f"tile.{block_name}.name={block_name.replace('_', ' ').capitalize()}"
        append_to_file(lang_file_path, lang_entry)
        blockId += 1

