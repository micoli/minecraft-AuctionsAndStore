package org.micoli.minecraft.webAuctionsAndStore.entities;

import java.util.Date;

import org.bukkit.entity.Player;

public class QDSale {
	public Player vendor;
	public Player buyer;
	public double buyPrice=0;
	public double auctionPrice=0;
	public Integer number=0;
	public Date beginDate = new Date();
	public Date endDate = new Date();
	public QDSale (){

	}

}
