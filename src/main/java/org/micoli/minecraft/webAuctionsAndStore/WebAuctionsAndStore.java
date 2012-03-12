package org.micoli.minecraft.webAuctionsAndStore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.micoli.minecraft.utils.ChatFormater;
import org.micoli.minecraft.webAuctionsAndStore.entities.QDObjectAuctionHouse;
import org.micoli.minecraft.webAuctionsAndStore.entities.QDObjectStore;
import org.micoli.minecraft.webAuctionsAndStore.listeners.QDBlockListener;
import org.micoli.minecraft.webAuctionsAndStore.listeners.QDPlayerListener;
import org.micoli.minecraft.webAuctionsAndStore.managers.QDCommandManager;

public class WebAuctionsAndStore extends JavaPlugin implements ActionListener {
	private static Logger logger = Logger.getLogger("Minecraft");
	private QDCommandManager myExecutor;
	private static WebAuctionsAndStore instance;
	private static Map<String, QDObjectStore> aStores;
	public static Map<String, QDObjectAuctionHouse> aAuctionHouses;
	private static Map<String, Long> coolDowns;
	private static String commandString = "qdauctions";
	private static boolean comments = true;
	private static String lastMsg = "";

	/**
	 * @return the instance
	 */
	public static WebAuctionsAndStore getInstance() {
		return instance;
	}

	public static String getCommandString() {
		return commandString;
	}

	public static void setComments(Player player, boolean active) {
		comments = active;
		player.sendMessage(ChatFormater.format("{ChatColor.RED} %s", (active ? "comments activated" : "comments desactived")));
	}

	public static boolean getComments() {
		return comments;
	}

	public static void log(String str) {
		logger.info(str);
	}

	public static void sendComments(Player player, String text, boolean global) {
		if (getComments()) {
			if (!WebAuctionsAndStore.lastMsg.equalsIgnoreCase(text)) {
				WebAuctionsAndStore.lastMsg = text + "";
				if (global) {
					getInstance().getServer().broadcastMessage(text);
				} else {
					player.sendMessage(text);
				}
			}
		}
	}

	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		log(ChatFormater.format("%s version disabled", pdfFile.getName(), pdfFile.getVersion()));
	}

	@Override
	public void onEnable() {
		aStores = new HashMap<String, QDObjectStore>();
		aAuctionHouses = new HashMap<String, QDObjectAuctionHouse>();
		instance = this;
		myExecutor = new QDCommandManager(this);
		PluginManager pm = getServer().getPluginManager();
		PluginDescriptionFile pdfFile = getDescription();

		pm.registerEvents(new QDPlayerListener(this), this);
		pm.registerEvents(new QDBlockListener(this), this);
		getCommand(getCommandString()).setExecutor(myExecutor);

		log(ChatFormater.format("%s version enabled", pdfFile.getName(), pdfFile.getVersion()));
	}

	public void actionPerformed(ActionEvent event) {
	}

	public void playerMove(Player player) {
		Iterator<String> iterator = aStores.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			QDObjectStore store = (QDObjectStore) aStores.get(key);
		}
	}
}