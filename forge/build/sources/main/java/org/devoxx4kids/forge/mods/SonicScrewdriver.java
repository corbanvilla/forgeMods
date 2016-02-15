package org.devoxx4kids.forge.mods;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class SonicScrewdriver extends ItemPickaxe {

    public SonicScrewdriver(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName("sonicScrewdriver");
	}
    
    @Override
    public Set<String> getToolClasses(ItemStack stack) {
        return ImmutableSet.of("pickaxe", "spade");
    }
    
    
    
    private static Set effectiveAgainst = Sets.newHashSet(new Block[] {
    	    Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, 
    	    Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, 
    	    Blocks.soul_sand, Blocks.mycelium, Blocks.planks, Blocks.bookshelf, 
    	    Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin});
    
    
 }