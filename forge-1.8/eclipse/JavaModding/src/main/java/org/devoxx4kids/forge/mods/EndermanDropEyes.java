package org.devoxx4kids.forge.mods;

import java.util.Random;

import net.minecraft.entity.monster.EntityEnderman;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EndermanDropEyes {

	@SubscribeEvent
	public void dropEyes (LivingDeathEvent event) {
		if (!(event.entity instanceof EntityEnderman)) {
			return;
		}
		else {
			Random random = new Random();
			
			if (!event.entity.worldObj.isRemote) {
				event.entity.dropItem(Main.enderEye, random.nextInt(5));
			}
		}
	}
}
