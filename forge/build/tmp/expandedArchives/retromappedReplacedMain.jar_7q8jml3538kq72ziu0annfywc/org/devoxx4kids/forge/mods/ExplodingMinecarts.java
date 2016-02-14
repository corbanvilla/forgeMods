package org.devoxx4kids.forge.mods;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraftforge.event.entity.minecart.MinecartCollisionEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ExplodingMinecarts {

	@SubscribeEvent
	public void explode(MinecartCollisionEvent event) {
		EntityMinecart minecart = event.minecart;
		minecart.field_70170_p.func_72876_a(
			minecart,
			minecart.field_70165_t,
			minecart.field_70163_u,
			minecart.field_70161_v,
			2,
			false);
		
	}
}
