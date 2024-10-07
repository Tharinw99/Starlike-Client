package net.minecraft.command;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.WorldSettings;

public class CommandGm extends CommandBase {
	public int gmId;
	public String gmName;

	public CommandGm(int id) {
		this.gmId = id;
		this.gmName = gmId == 0 ? "s" : gmId == 1 ? "c" : gmId == 2 ? "a" : gmId == 3 ? "sp" : null;
	}

	public String getCommandName() {
		return "gm" + this.gmName;
	}

	public String getCommandUsage(ICommandSender var1) {
		return (new ChatComponentTranslation("commands.gm.usage", new Object[] { this.gmName }).getUnformattedText());
	}

	public int getRequiredPermissionLevel() {
		return 2;
	}

	public boolean isUsernameIndex(String[] args, int index) {
		return index == 1;
	}

	public void processCommand(ICommandSender parICommandSender, String[] parArrayOfString) throws CommandException {
		if (parArrayOfString.length < 0) {
			throw new WrongUsageException("commands.gm.usage", new Object[] { this.gmName });
		} else {
			WorldSettings.GameType worldsettings$gametype = WorldSettings.GameType.getByID(this.gmId);
			EntityPlayerMP entityplayermp = parArrayOfString.length >= 1
					? getPlayer(parICommandSender, parArrayOfString[0])
					: getCommandSenderAsPlayer(parICommandSender);
			entityplayermp.setGameType(worldsettings$gametype);
			entityplayermp.fallDistance = 0.0F;
			if (parICommandSender.getEntityWorld().getGameRules().getBoolean("sendCommandFeedback")) {
				entityplayermp.addChatMessage(new ChatComponentTranslation("gameMode.changed", new Object[0]));
			}

			ChatComponentTranslation chatcomponenttranslation = new ChatComponentTranslation(
					"gameMode." + worldsettings$gametype.getName(), new Object[0]);
			if (entityplayermp != parICommandSender) {
				notifyOperators(parICommandSender, this, 1, "commands.gm.success.other",
						new Object[] { entityplayermp.getName(), chatcomponenttranslation });
			} else {
				notifyOperators(parICommandSender, this, 1, "commands.gm.success.self",
						new Object[] { chatcomponenttranslation });
			}
		}
	}
}