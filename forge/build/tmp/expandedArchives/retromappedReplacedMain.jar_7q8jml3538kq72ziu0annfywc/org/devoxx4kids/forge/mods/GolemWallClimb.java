package org.devoxx4kids.forge.mods;

import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GolemWallClimb {
	
	@SubscribeEvent
	public void climWall(LivingUpdateEvent event) {
		if (!(event.entity instanceof EntitySnowman) &&
				!(event.entity instanceof EntityIronGolem)) {
			return;
		}
		
		if (!event.entity.field_70123_F) {
			return;
		}
		
		event.entity.field_70181_x = 0.5;
	}
}
