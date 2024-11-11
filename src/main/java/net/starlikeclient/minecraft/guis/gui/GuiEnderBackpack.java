package net.starlikeclient.minecraft.guis.gui;

import net.lax1dude.eaglercraft.v1_8.opengl.GlStateManager;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ResourceLocation;
import net.starlikeclient.minecraft.guis.inventory.ContainerEnderBackpack;

public class GuiEnderBackpack extends GuiContainer {
	private static final ResourceLocation CHEST_GUI_TEXTURE = new ResourceLocation(
			"textures/gui/container/generic_54.png");
	private final InventoryPlayer inventoryplayer;
	private final IInventory backpackInventory;
	private final int inventoryRows;

	public GuiEnderBackpack(InventoryPlayer inventoryplayer, ItemStack itemstack) {
		super(new ContainerEnderBackpack(inventoryplayer, itemstack));
		this.inventoryplayer = inventoryplayer;
		this.backpackInventory = ((ContainerEnderBackpack) this.inventorySlots).getLowerChestInventory();
		this.allowUserInput = false;
		short short1 = 222;
		int i = short1 - 108;
		this.inventoryRows = this.backpackInventory.getSizeInventory() / 9;
		this.ySize = i + this.inventoryRows * 18;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(CHEST_GUI_TEXTURE);
		int i = (this.width - this.xSize) / 2;
		int j = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.inventoryRows * 18 + 17);
		this.drawTexturedModalRect(i, j + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int var1, int var2) {
		this.fontRendererObj.drawString(
				new ChatComponentTranslation(this.inventoryplayer.getCurrentItem().getUnlocalizedName() + ".name",
						new Object[0]).getUnformattedText(),
				8, 6, 0xFFFFFF);
		this.fontRendererObj.drawString(this.inventoryplayer.getDisplayName().getUnformattedText(), 8,
				this.ySize - 96 + 2, 0xFFFFFF);
	}
}
