package org.devoxx4kids.forge.mods;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ExplodingAnvils {

	@SubscribeEvent
	public void explode(LivingHurtEvent event) {
		if (event.source != DamageSource.field_82728_o) {
			return;
		}
		
		Entity entity = event.entity;
		event.entity.field_70170_p.func_72876_a(
				entity,
				entity.field_70165_t,
				entity.field_70163_u,
				entity.field_70161_v,
				2,
				false);
		
	}
}
