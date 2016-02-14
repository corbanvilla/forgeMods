package org.devoxx4kids.forge.mods;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, version = Main.VERSION)

public class Main {

	public static final String MODID = "ImprovedMinecraft";
	public static final String VERSION = "1.1";
	public static Block enderBlock;
	public static Item enderIngot;
	public static Item enderEye;
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new BlockBreakMessage());
		MinecraftForge.EVENT_BUS.register(new ExplodingMinecarts());
		MinecraftForge.EVENT_BUS.register(new ExplodingAnvils());
		MinecraftForge.EVENT_BUS.register(new DiamondOreTrap());
		MinecraftForge.EVENT_BUS.register(new BiggerTNTExplosions());
		MinecraftForge.EVENT_BUS.register(new PigsDroppingDiamonds());
		MinecraftForge.EVENT_BUS.register(new ZombieKnights());
		MinecraftForge.EVENT_BUS.register(new CreeperReinforcements());
		MinecraftForge.EVENT_BUS.register(new SuperJump());
		FMLCommonHandler.instance().bus().register(new Parachute());
		MinecraftForge.EVENT_BUS.register(new Parachute());
		MinecraftForge.EVENT_BUS.register(new GolemWallClimb());
		MinecraftForge.EVENT_BUS.register(new BlockFillerPositionSelector());
		MinecraftForge.EVENT_BUS.register(new EndermanDropEyes());
		enderBlock = new EnderBlock();
		GameRegistry.registerBlock(enderBlock, "enderBlock");
		enderIngot = new EnderIngot();
		GameRegistry.registerItem(enderIngot, "enderIngot");
		enderEye = new EnderEye();
		GameRegistry.registerItem(enderEye, "enderEye");
		GameRegistry.addRecipe(
				new ItemStack(Blocks.field_150347_e, 2),
				"dd",
				"dd",
				'd', Blocks.field_150346_d);
		GameRegistry.addRecipe(
				new ItemStack(enderBlock, 3),
				"iii",
				"iii",
				"iii",
				'i', enderIngot);
		GameRegistry.addRecipe(
				new ItemStack(enderBlock),
				"e e",
				" o ",
				"e e",
				'e', Items.field_151061_bv,
				'o', Blocks.field_150343_Z);
		GameRegistry.addShapelessRecipe(
				new ItemStack(enderIngot, 9),
				new ItemStack(enderBlock));
		GameRegistry.addShapelessRecipe(
				new ItemStack(enderIngot, 12),
				new ItemStack(enderBlock, 1),
				new ItemStack(Items.field_151042_j),
				new ItemStack(Items.field_151043_k));
		GameRegistry.addSmelting(
				Items.field_151079_bi,
				new ItemStack(enderIngot, 1),
				1.0F);
		Items.field_151105_aU.func_77631_c(PotionHelper.field_77919_g
				+ "+6" + "+14");
		
		Item enderBlockItem = GameRegistry.findItem("mymods", "enderBlock"); 
		ModelResourceLocation enderBlockModel =
			new ModelResourceLocation("mymods:enderBlock", "inventory"); 
		Minecraft.func_71410_x().func_175599_af().func_175037_a()
			.func_178086_a(enderBlockItem, 0, enderBlockModel); 

		Item enderIngotItem = GameRegistry.findItem("mymods", "enderIngot"); 
		ModelResourceLocation enderIngotModel =
			new ModelResourceLocation("mymods:enderIngot", "inventory");
		Minecraft.func_71410_x().func_175599_af().func_175037_a()
			.func_178086_a(enderIngotItem, 0, enderIngotModel);
		
		Item enderEyeItem = GameRegistry.findItem("mymods", "enderEye");
		ModelResourceLocation enderEyeModel =
			new ModelResourceLocation("mymods:enderEye", "inventory");
		Minecraft.func_71410_x().func_175599_af().func_175037_a()
			.func_178086_a(enderEyeItem, 0, enderEyeModel);
		
	}
	@EventHandler
	public void registerCommands(FMLServerStartingEvent event) {

	}
}