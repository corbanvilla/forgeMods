package org.devoxx4kids.forge.mods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class EnderEye extends ItemFood {

	public EnderEye() {
		super(9, 15.0F, false);
		this.func_77844_a(1, 60, 2, 0.5F);
		this.func_77848_i();
		this.func_77655_b("enderEye");
		this.func_77637_a(CreativeTabs.field_78039_h);
	}
	
}
