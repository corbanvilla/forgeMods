package org.devoxx4kids.forge.mods;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class GetHandheldItem {
	private Item handItem;
	static Block HandBlock;

	@SubscribeEvent
	public void handItems(PlayerInteractEvent event) {
		if (event.entityPlayer.getHeldItem() == null ||
			!(event.entityPlayer.capabilities.isCreativeMode)) {
			return;
		}
		else {
			handItem = event.entityPlayer.getHeldItem().getItem();
			System.out.println("The item in your hand is: " + handItem);
			HandBlock = Block.getBlockFromItem(handItem);
			System.out.println("The ID of the item in your hand is: " + HandBlock);
		}
	}
}