package org.devoxx4kids.forge.mods;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockFillerPositionSelector {
	static List<Integer> pos1 = new ArrayList();
	static List<Integer> pos2 = new ArrayList();
	
	@SubscribeEvent
	public void choosePotitions(PlayerInteractEvent event) {
		if (event.entityPlayer.func_70694_bm() == null ||
			event.entityPlayer.func_70694_bm().func_77973_b()
				!= Items.field_151053_p ||
				!event.entityPlayer.field_71075_bZ.field_75098_d) {
						return;
		}
		
		if (event.action == Action.RIGHT_CLICK_BLOCK) {
				pos1.clear();
				pos1.add(event.pos.func_177958_n());
				pos1.add(event.pos.func_177956_o());
				pos1.add(event.pos.func_177952_p());
				event.entityPlayer.func_145747_a(new ChatComponentText(
									EnumChatFormatting.GREEN
									+ "Position 1 set to "
									+ event.pos.func_177958_n() + ", "
									+ event.pos.func_177956_o() + ", "
									+ event.pos.func_177952_p() + "."));
				event.setCanceled(true);
				
		}
		
		else if (event.action == Action.LEFT_CLICK_BLOCK) {
				pos2.clear();
				pos2.add(event.pos.func_177958_n());
				pos2.add(event.pos.func_177956_o());
				pos2.add(event.pos.func_177952_p());
				event.entityPlayer.func_145747_a(new ChatComponentText( 
									EnumChatFormatting.GREEN
									+ "Position 2 set to "
									+ event.pos.func_177958_n() + ", "
									+ event.pos.func_177956_o() + ", "
									+ event.pos.func_177952_p() + "."));
				event.setCanceled(true);
			
		}
		
	}
	
}
