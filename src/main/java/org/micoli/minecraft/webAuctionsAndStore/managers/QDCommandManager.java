package org.micoli.minecraft.webAuctionsAndStore.managers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.micoli.minecraft.utils.ChatFormater;
import org.micoli.minecraft.webAuctionsAndStore.WebAuctionsAndStore;

public final class QDCommandManager implements CommandExecutor {
	private WebAuctionsAndStore plugin;

	public QDCommandManager(WebAuctionsAndStore plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (command.getName().equalsIgnoreCase(WebAuctionsAndStore.getCommandString()))
					if (args.length > 0) {
						WebAuctionsAndStore.log("[QuidditchBall] Command " + args[0]);
						if (args[0].equalsIgnoreCase("commentsOn")) {
							WebAuctionsAndStore.setComments(player, true);
						} else {
							player.sendMessage(ChatFormater.format("{ChatColor.RED} command unknown"));
						}
					} else {
						player.sendMessage(ChatFormater.format("{ChatColor.RED} Need more arguments"));
					}
			} else {
				WebAuctionsAndStore.log(ChatFormater.format("[QuidditchBall] Pushball requires you to be a Player"));
			}
			return false;
		} catch (Exception ex) {
			WebAuctionsAndStore.log(ChatFormater.format("[QuidditchBall] Command failure: %s", ex.getMessage()));
		}

		return false;
	}
}