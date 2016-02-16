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
	public static Item sonicPickaxe;
	public static Item sonicShovel;
	public static Item sonicAxe;
	public static Item sonicSword;
	
	//Material
	public static ToolMaterial Pickaxe = EnumHelper.addToolMaterial("Pickaxe", 4, 1500, 4.5F, 6.0F, 30);
	public static ToolMaterial Shovel = EnumHelper.addToolMaterial("Shovel", 4, 1500, 4.5F, 6.0F, 30);
	public static ToolMaterial Axe = EnumHelper.addToolMaterial("Axe", 4, 1500, 4.5F, 8.0F, 30);
	public static ToolMaterial Sword = EnumHelper.addToolMaterial("Sword", 4, 1500, 2.0F, 10.0F, 30);
	public static ToolMaterial SonicScrewdriver = EnumHelper.addToolMaterial("SonicScrewdriver", 30, 10000, 30.0F, 40.0F, 100);
	
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
		
		//Sonic Mod
		sonicScrewdriver = new SonicScrewdriver(SonicScrewdriver);
		GameRegistry.registerItem(sonicScrewdriver, "sonicScrewdriver");
		
		sonicPickaxe = new SonicPickaxe(Pickaxe);
		GameRegistry.registerItem(sonicPickaxe, "sonicPic");
		
		sonicShovel = new SonicShovel(Shovel);
		GameRegistry.registerItem(sonicShovel, "sonicShovel");
		
		sonicSword = new SonicSword(Sword);
		GameRegistry.registerItem(sonicSword, "sonicSword");
		
		sonicAxe = new SonicAxe(Axe);
		GameRegistry.registerItem(sonicAxe, "sonicAxe");
		
		
				
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
				"pes",
				"dod",
				"hda",
				'p', sonicPickaxe,
				'e', Items.emerald,
				's', sonicSword,
				'd', Items.diamond,
				'o', Blocks.obsidian,
				'h', sonicShovel,
				'a', sonicAxe);
		GameRegistry.addRecipe(
				new ItemStack(sonicSword),
				"oeo",
				"dsd",
				"ddd",
				'o', Blocks.obsidian,
				'e', Items.emerald,
				'd', Items.diamond,
				's', Items.diamond_sword);
		GameRegistry.addRecipe(
				new ItemStack(sonicShovel),
				"oeo",
				"dsd",
				"ddd",
				'o', Blocks.obsidian,
				'e', Items.emerald,
				'd', Items.diamond,
				's', Items.diamond_shovel);
		GameRegistry.addRecipe(
				new ItemStack(sonicPickaxe),
				"oeo",
				"dsd",
				"ddd",
				'o', Blocks.obsidian,
				'e', Items.emerald,
				'd', Items.diamond,
				's', Items.diamond_pickaxe);
		GameRegistry.addRecipe(
				new ItemStack(sonicAxe),
				"oeo",
				"dsd",
				"ddd",
				'o', Blocks.obsidian,
				'e', Items.emerald,
				'd', Items.diamond,
				's', Items.diamond_axe);
		
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
		
		Item sonicSwordItem = GameRegistry.findItem("improved-minecraft", "sonicSword");
		ModelResourceLocation sonicSwordModel = 
			new ModelResourceLocation("improved-minecraft:sonicSword", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			.register(sonicSwordItem, 0, sonicSwordModel);

		Item sonicPickaxeItem = GameRegistry.findItem("improved-minecraft", "sonicPic");
		ModelResourceLocation sonicPickaxeModel = 
			new ModelResourceLocation("improved-minecraft:sonicPic", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			.register(sonicPickaxeItem, 0, sonicPickaxeModel);
		
		Item sonicAxeItem = GameRegistry.findItem("improved-minecraft", "sonicAxe");
		ModelResourceLocation sonicAxeModel = 
			new ModelResourceLocation("improved-minecraft:sonicAxe", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			.register(sonicAxeItem, 0, sonicAxeModel);
		
		Item sonicShovelItem = GameRegistry.findItem("improved-minecraft", "sonicShovel");
		ModelResourceLocation sonicShovelModel = 
			new ModelResourceLocation("improved-minecraft:sonicShovel", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			.register(sonicShovelItem, 0, sonicShovelModel);
		
	}
	@EventHandler
	public void registerCommands(FMLServerStartingEvent event) {

	}
}