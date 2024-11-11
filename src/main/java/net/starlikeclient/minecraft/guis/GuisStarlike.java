package net.starlikeclient.minecraft.guis;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.IInteractionObject;
import net.starlikeclient.minecraft.guis.gui.GuiBackpack;
import net.starlikeclient.minecraft.guis.gui.GuiEnderBackpack;
import net.starlikeclient.minecraft.guis.gui.GuiSmithing;

public class GuisStarlike {
	public static void displayGui(IInteractionObject iinteractionobject, EntityPlayer entityplayer) {
		if (!entityplayer.worldObj.isRemote) {
			return;
		} else {
			String guiID = iinteractionobject.getGuiID();
			switch (guiID) {
			case "starlike:smithing_table":
				Minecraft.getMinecraft().displayGuiScreen(new GuiSmithing(entityplayer.inventory));
				break;
			case "starlike:backpack":
				Minecraft.getMinecraft().displayGuiScreen(
						new GuiBackpack(entityplayer.inventory, entityplayer.getCurrentEquippedItem()));
				break;
			case "starlike:ender_backpack":
				Minecraft.getMinecraft().displayGuiScreen(
						new GuiEnderBackpack(entityplayer.inventory, entityplayer.getCurrentEquippedItem()));
				break;
			default:
				throw new IllegalArgumentException("Unknown GUI ID: " + guiID);
			}
		}
	}
}
