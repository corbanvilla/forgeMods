package org.devoxx4kids.forge.mods;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class GetHandheldItem {
	static Item handItem;
	private String handItemId;
	static Block HandBlock;

	@SubscribeEvent
	public void handItems(PlayerTickEvent event) {
		if (event.player.getHeldItem() == null) {
			return;
		}
		else {
			handItem = event.player.getHeldItem().getItem();
			System.out.println("The item in your hand is: " + handItem);
			HandBlock = Block.getBlockFromItem(handItem);
			System.out.println("The ID of the item in your hand is: " + HandBlock);
			
/*			if (handItem == Item.getItemById(SonicScrewdriver)) {
				
			}
*/		}
	}
}