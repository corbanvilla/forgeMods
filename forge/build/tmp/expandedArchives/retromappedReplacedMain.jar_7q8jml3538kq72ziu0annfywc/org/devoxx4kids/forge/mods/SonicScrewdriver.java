package org.devoxx4kids.forge.mods;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

import net.minecraft.item.Item.ToolMaterial;

public class SonicScrewdriver extends ItemPickaxe {

    protected SonicScrewdriver(ToolMaterial material) {
		super(material);
		this.func_77655_b("sonicScrewdriver");
	}
    
    @Override
    public Set<String> getToolClasses(ItemStack stack) {
        return ImmutableSet.of("pickaxe", "spade", "axe");
    }
    
    private static Set effectiveAgainst = Sets.newHashSet(new Block[] {
    	    Blocks.field_150349_c, Blocks.field_150346_d, Blocks.field_150354_m, Blocks.field_150351_n, 
    	    Blocks.field_150431_aC, Blocks.field_150433_aE, Blocks.field_150435_aG, Blocks.field_150458_ak, 
    	    Blocks.field_150425_aM, Blocks.field_150391_bh, Blocks.field_150344_f, Blocks.field_150342_X, 
    	    Blocks.field_150364_r, Blocks.field_150363_s, Blocks.field_150486_ae, Blocks.field_150423_aK, Blocks.field_150428_aP});
    
    @Override
    public boolean func_150897_b(Block block) {
        return effectiveAgainst.contains(block) ? true : super.func_150897_b(block);
    }
    
    @Override
    public float func_150893_a(ItemStack stack, Block block) {
        if (block.func_149688_o() == Material.field_151575_d || block.func_149688_o() == Material.field_151582_l || block.func_149688_o() == Material.field_151585_k)
            return this.field_77864_a;
        return effectiveAgainst.contains(block) ? this.field_77864_a : super.func_150893_a(stack, block);
    }
    
}