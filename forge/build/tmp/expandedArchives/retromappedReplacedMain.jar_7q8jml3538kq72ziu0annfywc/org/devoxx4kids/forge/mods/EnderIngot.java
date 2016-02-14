package org.devoxx4kids.forge.mods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EnderIngot extends Item {

	public EnderIngot() {
		super();
		this.func_77655_b("enderIngot");
		this.func_77637_a(CreativeTabs.field_78035_l);
	}
	public ItemStack func_77659_a(ItemStack stack, 
			World world, EntityPlayer player) {
		
		EntityEnderman enderman = new EntityEnderman(world);
		enderman.func_70012_b((player.field_70165_t + 3), player.field_70163_u, player.field_70161_v, 0, 0);
		
		world.func_72838_d(enderman);
		
		if (!player.field_71075_bZ.field_75098_d) {
			stack.field_77994_a--;
		}
		return stack;
	}

}