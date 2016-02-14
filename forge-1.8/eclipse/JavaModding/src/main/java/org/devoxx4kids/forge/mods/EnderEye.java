package org.devoxx4kids.forge.mods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class EnderEye extends ItemFood {

	public EnderEye() {
		super(9, 15.0F, false);
		this.setPotionEffect(1, 60, 2, 0.5F);
		this.setAlwaysEdible();
		this.setUnlocalizedName("enderEye");
		this.setCreativeTab(CreativeTabs.tabFood);
	}
	
}
