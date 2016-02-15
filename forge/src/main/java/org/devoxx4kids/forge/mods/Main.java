package org.devoxx4kids.forge.mods;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, version = Main.VERSION)

public class Main {

	public static final String MODID = "improved-minecraft";
	public static final String VERSION = "1.1";
	public static Block enderBlock;
	public static Item enderIngot;
	public static Item enderEye;
	public static Item sonicScrewdriver;
	
	//Material
	public static ToolMaterial MyMaterial = EnumHelper.addToolMaterial("MyMaterial", 4, 3000, 5.0F, 8.0F, 30);
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//Importing Events
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
		
		//Items
		enderBlock = new EnderBlock();
		GameRegistry.registerBlock(enderBlock, "enderBlock");
		enderIngot = new EnderIngot();
		GameRegistry.registerItem(enderIngot, "enderIngot");
		enderEye = new EnderEye();
		GameRegistry.registerItem(enderEye, "enderEye");
		sonicScrewdriver = new SonicScrewdriver(MyMaterial);
		GameRegistry.registerItem(sonicScrewdriver, "sonicScrewdriver");
		
		//Shaped Recipes
		GameRegistry.addRecipe(
				new ItemStack(Blocks.cobblestone, 2),
				"dd",
				"dd",
				'd', Blocks.dirt);
		GameRegistry.addRecipe(
				new ItemStack(enderBlock),
				"iii",
				"iii",
				"iii",
				'i', enderIngot);
		GameRegistry.addRecipe(
				new ItemStack(enderBlock),
				"e e",
				" o ",
				"e e",
				'e', Items.ender_eye,
				'o', Blocks.obsidian);
		GameRegistry.addRecipe(
				new ItemStack(sonicScrewdriver),
				"pep",
				"oso",
				"adh",
				'p', Items.diamond_pickaxe,
				'e', Items.emerald,
				'o', Blocks.obsidian,
				's', Items.diamond_sword,
				'a', Items.diamond_axe,
				'd', Items.diamond,
				'h', Items.diamond_shovel);
		
		//Shapeless Recipes
		GameRegistry.addShapelessRecipe(
				new ItemStack(enderIngot, 9),
				new ItemStack(enderBlock));
		GameRegistry.addShapelessRecipe(
				new ItemStack(enderIngot, 12),
				new ItemStack(enderBlock, 1),
				new ItemStack(Items.iron_ingot),
				new ItemStack(Items.gold_ingot));
		GameRegistry.addSmelting(
				Items.ender_pearl,
				new ItemStack(enderIngot, 1),
				1.0F);
		Items.cake.setPotionEffect(PotionHelper.blazePowderEffect
				+ "+6" + "+14");
		
		//Textures
		Item enderBlockItem = GameRegistry.findItem("improved-minecraft", "enderBlock"); 
		ModelResourceLocation enderBlockModel =
			new ModelResourceLocation("improved-minecraft:enderBlock", "inventory"); 
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			.register(enderBlockItem, 0, enderBlockModel); 

		Item enderIngotItem = GameRegistry.findItem("improved-minecraft", "enderIngot"); 
		ModelResourceLocation enderIngotModel =
			new ModelResourceLocation("improved-minecraft:enderIngot", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			.register(enderIngotItem, 0, enderIngotModel);
		
		Item enderEyeItem = GameRegistry.findItem("improved-minecraft", "enderEye");
		ModelResourceLocation enderEyeModel =
			new ModelResourceLocation("improved-minecraft:enderEye", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			.register(enderEyeItem, 0, enderEyeModel);
		
		Item sonicScrewdriverItem = GameRegistry.findItem("improved-minecraft", "sonicScrewdriver");
		ModelResourceLocation sonicScrewdriverModel = 
			new ModelResourceLocation("improved-minecraft:sonicScrewdriver", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			.register(sonicScrewdriverItem, 0, sonicScrewdriverModel);
		
	}
	@EventHandler
	public void registerCommands(FMLServerStartingEvent event) {

	}
}