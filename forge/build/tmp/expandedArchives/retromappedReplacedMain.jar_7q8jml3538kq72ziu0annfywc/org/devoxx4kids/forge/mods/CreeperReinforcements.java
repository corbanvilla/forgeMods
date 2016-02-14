package org.devoxx4kids.forge.mods;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CreeperReinforcements {
	@SubscribeEvent
	public void spawnReinforcements(LivingDeathEvent event) {
		if(!(event.entity instanceof EntityCreeper)) {
			return;
		}
		
		for (int i = 0 ; i < 5 ; i++) {
			EntityCreeper creeper = new EntityCreeper(event.entity.field_70170_p);
			creeper.func_70012_b(event.entity.field_70165_t,
					event.entity.field_70163_u,
					event.entity.field_70161_v,
					0,
					0);
			if (!event.entity.field_70170_p.field_72995_K) {
				event.entity.field_70170_p.func_72838_d(creeper);
			}
		}
	}

}
