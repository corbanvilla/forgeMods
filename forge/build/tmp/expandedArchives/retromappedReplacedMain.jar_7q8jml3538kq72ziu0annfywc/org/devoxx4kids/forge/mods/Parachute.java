package org.devoxx4kids.forge.mods;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class Parachute {
	@SubscribeEvent
	public void deployParachute(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (!player.field_70160_al || !player.func_70093_af()) {
			return;
		}
		
		player.field_70181_x = -0.01;
	}
	
	@SubscribeEvent
	public void negateFallDamage(LivingFallEvent event) {
		if(!(event.entity instanceof EntityPlayer)) {
			return;
		}
		
		EntityPlayer player = (EntityPlayer) event.entity;
		
		if (!player.func_70093_af()) {
			return;
		}
		event.setCanceled(true);
	}

}