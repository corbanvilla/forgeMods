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
		if (event.player.func_70694_bm() == null) {
			return;
		}
		else {
			handItem = event.player.func_70694_bm().func_77973_b();
			System.out.println("The item in your hand is: " + handItem);
			HandBlock = Block.func_149634_a(handItem);
			System.out.println("The ID of the item in your hand is: " + HandBlock);
			
/*			if (handItem == Item.getItemById(SonicScrewdriver)) {
				
			}
*/		}
	}
}