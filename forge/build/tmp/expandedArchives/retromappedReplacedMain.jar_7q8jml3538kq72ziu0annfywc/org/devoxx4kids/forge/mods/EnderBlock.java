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
			super(Material.field_151573_f);
			this.func_149663_c("enderBlock");
			this.func_149647_a(CreativeTabs.field_78030_b);
			this.func_149752_b(7.5F);
			this.func_149711_c(10.0F);
			this.func_149715_a(1.0F);
		}
		
		@Override
		public void func_176213_c(World world, BlockPos pos, IBlockState state) {
			IBlockState block = world.func_180495_p(pos.func_177982_a(0, -1, 0));
			if (!(block.func_177230_c() == Blocks.field_150343_Z || block.func_177230_c() == Blocks.field_150350_a)) {
			world.func_175656_a(pos, block);
			EntityLightningBolt lightning = new EntityLightningBolt(world,
											pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
			world.func_72942_c(lightning);
			
		}
			else {
				return;
			}
		}
			
		@Override
		public boolean func_180639_a(World world, BlockPos pos, IBlockState state,
										EntityPlayer player, EnumFacing side,
										float hitX, float hitY, float hitZ) {
			if (!world.field_72995_K)
				return false;

			player.func_145747_a(new ChatComponentText( 
					EnumChatFormatting.DARK_PURPLE +
						"You have clicked on the most magic of all blocks - the ENDERIUM BLOCK!!!!!!!!!!!!!!!!!!!!!!!! Be Prepared for whatever might happen next! It is very mysterious..."));		
			EntityEnderEye eye = new EntityEnderEye(world,
			pos.func_177958_n() + 0.5,
			pos.func_177956_o() + 1.5,
			pos.func_177952_p() + 0.5); 
			eye.field_70181_x = 0.1;
			world.func_72838_d(eye);
			return true;
		}		
		
		public Item func_180660_a(IBlockState state, Random random, int i2) {
			return Main.enderIngot;
		}
		
		public int func_149745_a(Random random) {
			return random.nextInt(2) + 3;
		}
}