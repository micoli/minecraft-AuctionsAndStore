package org.micoli.minecraft.webAuctionsAndStore.entities;

import java.text.SimpleDateFormat;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.micoli.minecraft.webAuctionsAndStore.WebAuctionsAndStore;

public class QDObjectStore {
	Block block;
	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	static WebAuctionsAndStore plugin;
	boolean debug = false;
	private SimpleDateFormat hourFmt = new SimpleDateFormat("HH:mm:ss");

	public QDObjectStore(Block b, Player player) {
		block = b;
		plugin = WebAuctionsAndStore.getInstance();
	}

}
