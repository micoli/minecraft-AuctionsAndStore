package org.micoli.minecraft.webAuctionsAndStore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.Listener;
import org.micoli.minecraft.webAuctionsAndStore.WebAuctionsAndStore;

public class QDBlockListener implements Listener {
	WebAuctionsAndStore activeBall;

	public QDBlockListener(WebAuctionsAndStore activeBall) {
		this.activeBall = activeBall;
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		//activeBall.blockBreak(event);
	}
}
