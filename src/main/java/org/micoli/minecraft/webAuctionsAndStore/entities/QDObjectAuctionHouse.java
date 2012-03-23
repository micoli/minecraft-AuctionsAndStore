package org.micoli.minecraft.webAuctionsAndStore.entities;

import java.text.SimpleDateFormat;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.micoli.minecraft.webAuctionsAndStore.WebAuctionsAndStore;

public class QDObjectAuctionHouse {
	static WebAuctionsAndStore plugin;
	boolean debug = false;
	private SimpleDateFormat hourFmt = new SimpleDateFormat("HH:mm:ss");
	private Block block;

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public QDObjectAuctionHouse(Block b, Player player) {
		block = b;
		plugin = WebAuctionsAndStore.getInstance();
	}

}
