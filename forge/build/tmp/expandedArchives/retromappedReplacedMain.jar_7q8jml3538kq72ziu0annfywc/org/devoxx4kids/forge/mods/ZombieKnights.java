package org.devoxx4kids.forge.mods;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ZombieKnights {

	@SubscribeEvent
	public void giveArmor(EntityJoinWorldEvent event) {
		if (!(event.entity instanceof EntityZombie)) {
			return;
		}
		
		EntityZombie zombie = (EntityZombie) event.entity;
		
		zombie.func_70062_b(0, new ItemStack(Items.field_151056_x));
		zombie.func_70062_b(1, new ItemStack(Items.field_151163_ad));
		zombie.func_70062_b(2, new ItemStack(Items.field_151173_ae));
		zombie.func_70062_b(3, new ItemStack(Items.field_151161_ac));
		zombie.func_70062_b(4, new ItemStack(Items.field_151175_af));
		
	}
}
