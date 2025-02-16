package net.minecraft.creativetab;

import java.util.List;

import net.minecraft.block.BlockDoublePlant;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * + This portion of EaglercraftX contains deobfuscated Minecraft 1.8 source
 * code.
 *
 * Minecraft 1.8.8 bytecode is (c) 2015 Mojang AB. "Do not distribute!" Mod
 * Coder Pack v9.18 deobfuscation configs are (c) Copyright by the MCP Team
 *
 * EaglercraftX 1.8 patch files (c) 2022-2025 lax1dude, ayunami2000. All Rights
 * Reserved.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 */
public abstract class CreativeTabs {
	public static final CreativeTabs[] creativeTabArray = new CreativeTabs[13];
	public static final CreativeTabs tabBlock = new CreativeTabs(0, "buildingBlocks") {
		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.brick_block);
		}
	};
	public static final CreativeTabs tabDecorations = new CreativeTabs(1, "decorations") {
		@Override
		public int getIconItemDamage() {
			return BlockDoublePlant.EnumPlantType.PAEONIA.getMeta();
		}

		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.double_plant);
		}
	};
	public static final CreativeTabs tabRedstone = new CreativeTabs(2, "redstone") {
		@Override
		public Item getTabIconItem() {
			return Items.redstone;
		}
	};
	public static final CreativeTabs tabTransport = new CreativeTabs(3, "transportation") {
		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.golden_rail);
		}
	};
	public static final CreativeTabs tabMisc = (new CreativeTabs(4, "misc") {
		@Override
		public Item getTabIconItem() {
			return Items.lava_bucket;
		}
	}).setRelevantEnchantmentTypes(new EnumEnchantmentType[] { EnumEnchantmentType.ALL });
	public static final CreativeTabs tabAllSearch = (new CreativeTabs(5, "search") {
		@Override
		public Item getTabIconItem() {
			return Items.compass;
		}
	}).setBackgroundImageName("item_search.png");
	public static final CreativeTabs tabFood = new CreativeTabs(6, "food") {
		@Override
		public Item getTabIconItem() {
			return Items.apple;
		}
	};
	public static final CreativeTabs tabTools = (new CreativeTabs(7, "tools") {
		@Override
		public Item getTabIconItem() {
			return Items.iron_axe;
		}
	}).setRelevantEnchantmentTypes(new EnumEnchantmentType[] { EnumEnchantmentType.DIGGER,
			EnumEnchantmentType.FISHING_ROD, EnumEnchantmentType.BREAKABLE });
	public static final CreativeTabs tabCombat = (new CreativeTabs(8, "combat") {
		@Override
		public Item getTabIconItem() {
			return Items.golden_sword;
		}
	}).setRelevantEnchantmentTypes(new EnumEnchantmentType[] { EnumEnchantmentType.ARMOR,
			EnumEnchantmentType.ARMOR_FEET, EnumEnchantmentType.ARMOR_HEAD, EnumEnchantmentType.ARMOR_LEGS,
			EnumEnchantmentType.ARMOR_TORSO, EnumEnchantmentType.BOW, EnumEnchantmentType.WEAPON });
	public static final CreativeTabs tabBrewing = new CreativeTabs(9, "brewing") {
		@Override
		public Item getTabIconItem() {
			return Items.cooked_porkchop;
		}
	};
	public static final CreativeTabs tabMaterials = new CreativeTabs(10, "materials") {
		@Override
		public Item getTabIconItem() {
			return Items.stick;
		}
	};
	public static final CreativeTabs tabInventory = (new CreativeTabs(11, "inventory") {
		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.chest);
		}
	}).setBackgroundImageName("inventory.png").setNoScrollbar().setNoTitle();
	public static final CreativeTabs tabStarlike = new CreativeTabs(12, "starlike") {
		@Override
		public Item getTabIconItem() {
			return Items.titanium_drill;
		}
	};
	private final int tabIndex;
	private final String tabLabel;
	/**
	 * + Texture to use.
	 */
	private String theTexture = "items.png";
	private boolean hasScrollbar = true;
	/**
	 * + Whether to draw the title in the foreground of the creative GUI
	 */
	private boolean drawTitle = true;
	private EnumEnchantmentType[] enchantmentTypes;
	private ItemStack iconItemStack;

	public CreativeTabs(int index, String label) {
		this.tabIndex = index;
		this.tabLabel = label;
		creativeTabArray[index] = this;
	}

	/**
	 * + Adds the enchantment books from the supplied EnumEnchantmentType to the
	 * given list.
	 */
	public void addEnchantmentBooksToList(List<ItemStack> itemList, EnumEnchantmentType... enchantmentType) {
		for (int i = 0; i < Enchantment.enchantmentsBookList.length; ++i) {
			Enchantment enchantment = Enchantment.enchantmentsBookList[i];
			if (enchantment != null && enchantment.type != null) {
				boolean flag = false;

				for (int j = 0; j < enchantmentType.length && !flag; ++j) {
					if (enchantment.type == enchantmentType[j]) {
						flag = true;
					}
				}

				if (flag) {
					itemList.add(Items.enchanted_book
							.getEnchantedItemStack(new EnchantmentData(enchantment, enchantment.getMaxLevel())));
				}
			}
		}

	}

	/**
	 * + only shows items which have tabToDisplayOn == this
	 */
	public void displayAllReleventItems(List<ItemStack> parList) {
		for (Item item : Item.itemRegistry) {
			if (item != null && item.getCreativeTab() == this) {
				item.getSubItems(item, this, parList);
			}
		}

		if (this.getRelevantEnchantmentTypes() != null) {
			this.addEnchantmentBooksToList(parList, this.getRelevantEnchantmentTypes());
		}

	}

	public boolean drawInForegroundOfTab() {
		return this.drawTitle;
	}

	public String getBackgroundImageName() {
		return this.theTexture;
	}

	public int getIconItemDamage() {
		return 0;
	}

	public ItemStack getIconItemStack() {
		if (this.iconItemStack == null) {
			this.iconItemStack = new ItemStack(this.getTabIconItem(), 1, this.getIconItemDamage());
		}

		return this.iconItemStack;
	}

	/**
	 * + Returns the enchantment types relevant to this tab
	 */
	public EnumEnchantmentType[] getRelevantEnchantmentTypes() {
		return this.enchantmentTypes;
	}

	/**
	 * + returns index % 6
	 */
	public int getTabColumn() {
		return this.tabIndex % 6;
	}

	public abstract Item getTabIconItem();

	public int getTabIndex() {
		return this.tabIndex;
	}

	public String getTabLabel() {
		return this.tabLabel;
	}

	/**
	 * + Gets the translated Label.
	 */
	public String getTranslatedTabLabel() {
		return "itemGroup." + this.getTabLabel();
	}

	public boolean hasRelevantEnchantmentType(EnumEnchantmentType enchantmentType) {
		if (this.enchantmentTypes == null) {
			return false;
		} else {
			for (int i = 0; i < this.enchantmentTypes.length; ++i) {
				if (this.enchantmentTypes[i] == enchantmentType) {
					return true;
				}
			}

			return false;
		}
	}

	/**
	 * + returns tabIndex < 6
	 */
	public boolean isTabInFirstRow() {
		return this.tabIndex < 7;
	}

	public CreativeTabs setBackgroundImageName(String texture) {
		this.theTexture = texture;
		return this;
	}

	public CreativeTabs setNoScrollbar() {
		this.hasScrollbar = false;
		return this;
	}

	public CreativeTabs setNoTitle() {
		this.drawTitle = false;
		return this;
	}

	/**
	 * + Sets the enchantment types for populating this tab with enchanting books
	 */
	public CreativeTabs setRelevantEnchantmentTypes(EnumEnchantmentType... types) {
		this.enchantmentTypes = types;
		return this;
	}

	public boolean shouldHidePlayerInventory() {
		return this.hasScrollbar;
	}
}
