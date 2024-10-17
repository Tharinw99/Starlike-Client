package net.starlikeclient.minecraft.guis.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.starlikeclient.minecraft.guis.inventory.ContainerSmithing;

public class GuiSmithing extends GuiContainer {
	private static final ResourceLocation SMITHING_GUI_TEXTURE = new ResourceLocation(
			"starlike:textures/gui/container/smithing.png");
	private final ContainerSmithing containerSmithing;

	public GuiSmithing(Container container) {
		super(container);
		this.containerSmithing = (ContainerSmithing) container;
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		this.mc.getTextureManager().bindTexture(SMITHING_GUI_TEXTURE);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

		// x arrow if invalid craft
		if (this.containerSmithing.isCraftingValid() == false && (this.containerSmithing.getSlot(0).getHasStack()
				|| this.containerSmithing.getSlot(1).getHasStack())) {
			this.drawTexturedModalRect(k + 99, l + 45, 176, 0, 28, 21); // Arrow with an "X" at (176, 0) to (203, 20)
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String title = "Upgrade Gear";
		int titleX = ((this.xSize - this.fontRendererObj.getStringWidth(title)) / 2) + 7;
		int titleY = 18;
		this.fontRendererObj.drawString(title, titleX, titleY, 0xFFFFFF);
	}

}