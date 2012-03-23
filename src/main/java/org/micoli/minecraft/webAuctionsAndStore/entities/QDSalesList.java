package org.micoli.minecraft.webAuctionsAndStore.entities;

import java.util.HashMap;
import java.util.UUID;
public class QDSalesList {
	HashMap<UUID,QDSale> list = new HashMap<UUID,QDSale>();
	public void add(QDSale sale){
		list.put(UUID.randomUUID(), sale);
	}
}
