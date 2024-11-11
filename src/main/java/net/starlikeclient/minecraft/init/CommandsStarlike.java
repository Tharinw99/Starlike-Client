package net.starlikeclient.minecraft.init;

import net.minecraft.command.ServerCommandManager;
import net.starlikeclient.minecraft.commands.CommandGm;

public class CommandsStarlike {
	public static void registerCommands(ServerCommandManager e) {
		e.registerCommand(new CommandGm(0));
		e.registerCommand(new CommandGm(1));
		e.registerCommand(new CommandGm(2));
		e.registerCommand(new CommandGm(3));
	}
}
