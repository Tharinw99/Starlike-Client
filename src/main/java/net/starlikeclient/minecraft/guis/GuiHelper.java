package net.starlikeclient.minecraft.guis;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.S2DPacketOpenWindow;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.starlikeclient.minecraft.guis.gui.GuiSmithing;
import net.starlikeclient.minecraft.guis.inventory.ContainerSmithing;

public class GuiHelper {
	public static void openGuiSmithing(World world, BlockPos pos, EntityPlayer player) {
		if (world.isRemote) {
			Minecraft.getMinecraft()
					.displayGuiScreen(new GuiSmithing(new ContainerSmithing(player.inventory, world, pos)));
		} else {
			EntityPlayerMP playerMP = (EntityPlayerMP) player;
			playerMP.getNextWindowId();
			playerMP.playerNetServerHandler.sendPacket(new S2DPacketOpenWindow(playerMP.currentWindowId,
					"starlike:smithing_table", new ChatComponentText("Smithing Table")));
			playerMP.openContainer = new ContainerSmithing(player.inventory, world, pos);
			playerMP.openContainer.windowId = playerMP.currentWindowId;
			playerMP.openContainer.onCraftGuiOpened(playerMP);
		}
	}
}