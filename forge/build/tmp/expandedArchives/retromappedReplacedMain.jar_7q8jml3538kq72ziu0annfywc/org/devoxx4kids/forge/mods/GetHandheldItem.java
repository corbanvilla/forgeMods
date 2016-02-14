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
		if (event.entityPlayer.func_70694_bm() == null ||
			!(event.entityPlayer.field_71075_bZ.field_75098_d)) {
			return;
		}
		else {
			handItem = event.entityPlayer.func_70694_bm().func_77973_b();
			System.out.println("The item in your hand is: " + handItem);
			HandBlock = Block.func_149634_a(handItem);
			System.out.println("The ID of the item in your hand is: " + HandBlock);
		}
	}
}