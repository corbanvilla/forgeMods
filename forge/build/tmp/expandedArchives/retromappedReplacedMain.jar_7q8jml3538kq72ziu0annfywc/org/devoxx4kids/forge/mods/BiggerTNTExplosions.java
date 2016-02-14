package org.devoxx4kids.forge.mods;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BiggerTNTExplosions {
int fuse = 4; //In Seconds
float power = 32F;

	@SubscribeEvent
	public void SpawnTNTItem(EntityJoinWorldEvent event) {
			if (!(event.entity instanceof EntityTNTPrimed)) {
				return;
			}
			
			Entity entity = event.entity;
			EntityItem explosion = new EntityItem(event.world,
							entity.field_70165_t, entity.field_70163_u, entity.field_70161_v,
							new ItemStack(Blocks.field_150335_W));
			explosion.func_174871_r();
			explosion.field_70159_w = 0;
			explosion.field_70181_x = 0;
			explosion.field_70179_y = 0;
			explosion.lifespan = fuse * 20;
			if (!event.world.field_72995_K) {
					event.world.func_72838_d(explosion); }
			}

	@SubscribeEvent
	public void explode(ItemExpireEvent event) {
	         if (event.entityItem.func_92059_d().func_77973_b() !=
	             Item.func_150898_a(Blocks.field_150335_W)) {
	                 return;
	         }

		EntityItem explosion = event.entityItem;
		event.entity.field_70170_p.func_72876_a(explosion,
				explosion.field_70165_t, explosion.field_70163_u, explosion.field_70161_v,
				power, true);
	}
			

}
