package org.devoxx4kids.forge.mods;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class EnderBlock extends Block {
	
		public EnderBlock() {
			super(Material.iron);
			this.setUnlocalizedName("enderBlock");
			this.setCreativeTab(CreativeTabs.tabBlock);
			this.setResistance(7.5F);
			this.setHardness(10.0F);
			this.setLightLevel(1.0F);
		}
		
		@Override
		public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
			IBlockState block = world.getBlockState(pos.add(0, -1, 0));
			if (!(block.getBlock() == Blocks.obsidian || block.getBlock() == Blocks.air)) {
			world.setBlockState(pos, block);
			EntityLightningBolt lightning = new EntityLightningBolt(world,
											pos.getX(), pos.getY(), pos.getZ());
			world.addWeatherEffect(lightning);
			
		}
			else {
				return;
			}
		}
			
		@Override
		public boolean onBlockActivated(World world, BlockPos pos, IBlockState state,
										EntityPlayer player, EnumFacing side,
										float hitX, float hitY, float hitZ) {
			if (!world.isRemote)
				return false;

			player.addChatMessage(new ChatComponentText( 
					EnumChatFormatting.DARK_PURPLE +
						"You have clicked on the most magic of all blocks - the ENDERIUM BLOCK!!!!!!!!!!!!!!!!!!!!!!!! Be Prepared for whatever might happen next! It is very mysterious..."));		
			EntityEnderEye eye = new EntityEnderEye(world,
			pos.getX() + 0.5,
			pos.getY() + 1.5,
			pos.getZ() + 0.5); 
			eye.motionY = 0.1;
			world.spawnEntityInWorld(eye);
			return true;
		}		
		
		public Item getItemDropped(IBlockState state, Random random, int i2) {
			return Main.enderIngot;
		}
		
		public int quantityDropped(Random random) {
			return random.nextInt(2) + 3;
		}
}