package drachenbauer32.angrybirdsmod;

import java.util.function.Function;

import drachenbauer32.angrybirdsmod.blocks.BalloonBlock;
import drachenbauer32.angrybirdsmod.blocks.EggBlock;
import drachenbauer32.angrybirdsmod.blocks.NestBlock;
import drachenbauer32.angrybirdsmod.blocks.Slingshot2Block;
import drachenbauer32.angrybirdsmod.blocks.SlingshotBlock;
import drachenbauer32.angrybirdsmod.entity.EntityBlues;
import drachenbauer32.angrybirdsmod.entity.EntityBomb;
import drachenbauer32.angrybirdsmod.entity.EntityChuck;
import drachenbauer32.angrybirdsmod.entity.EntityMathilda;
import drachenbauer32.angrybirdsmod.entity.EntityRed;
import drachenbauer32.angrybirdsmod.init.BlockList;
import drachenbauer32.angrybirdsmod.init.ItemList;
import drachenbauer32.angrybirdsmod.util.Reference;
import drachenbauer32.angrybirdsmod.util.handlers.RenderHandler;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemSpawnEgg;
import net.minecraft.world.World;
//import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

//@ObjectHolder(Reference.MOD_ID)
@Mod(Reference.MOD_ID)
public class Main
{	
	//@ObjectHolder("red")
	public static EntityType<?> EggRed;
	//@ObjectHolder("chuck")
	public static EntityType<?> EggChuck;
	//@ObjectHolder("blues")
	public static EntityType<?> EggBlues;
	//@ObjectHolder("bomb")
	public static EntityType<?> EggBomb;
	//@ObjectHolder("mathilda")
	public static EntityType<?> EggMathilda;
	
	public Main() 
	{
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		RenderHandler.regigisterEntityRenders();
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{	
		/*@SubscribeEvent
		public static void onRenderPlayer(RenderPlayerEvent.Pre event)
		{
			event.setCanceled(true);
		}*/
		
		//@SubscribeEvent(priority=normal)
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll(BlockList.balloon_block = new BalloonBlock("balloon_block", EnumDyeColor.WHITE, Block.Properties.create(Material.CLOTH, MaterialColor.SNOW).sound(SoundType.CLOTH).
		                							lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()),
											BlockList.egg_block = new EggBlock("egg_block", Block.Properties.create(Material.CLAY, MaterialColor.SNOW).sound(SoundType.STONE).
													lightValue(0).hardnessAndResistance(0.2f, 1.0f).variableOpacity()),
											BlockList.nest_block = new NestBlock("nest_block", Block.Properties.create(Material.GRASS, MaterialColor.GOLD).sound(SoundType.PLANT).
													lightValue(0).hardnessAndResistance(0.2f, 1.0f).variableOpacity()),
											BlockList.slingshot_block = new SlingshotBlock("slingshot_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
													lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
											BlockList.slingshot2_block = new Slingshot2Block("slingshot2_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
													lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()));
		}
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll(ItemList.baloon_block = new ItemBlock(BlockList.balloon_block, new Item.Properties().defaultMaxDamage(0).group(ItemGroup.DECORATIONS).
													maxStackSize(64).rarity(EnumRarity.COMMON).setNoRepair()).setRegistryName(BlockList.balloon_block.getRegistryName()),
											ItemList.egg_block = new ItemBlock(BlockList.egg_block, new Item.Properties().defaultMaxDamage(0).group(ItemGroup.DECORATIONS).
													maxStackSize(64).rarity(EnumRarity.COMMON).setNoRepair()).setRegistryName(BlockList.egg_block.getRegistryName()),
											ItemList.nest_block = new ItemBlock(BlockList.nest_block, new Item.Properties().defaultMaxDamage(0).group(ItemGroup.DECORATIONS).
													maxStackSize(64).rarity(EnumRarity.COMMON).setNoRepair()).setRegistryName(BlockList.nest_block.getRegistryName()),
											ItemList.slingshot_block = new ItemBlock(BlockList.slingshot_block, new Item.Properties().defaultMaxDamage(0).group(ItemGroup.DECORATIONS).
													maxStackSize(64).rarity(EnumRarity.COMMON).setNoRepair()).setRegistryName(BlockList.slingshot_block.getRegistryName()),
											ItemList.slingshot2_block = new ItemBlock(BlockList.slingshot2_block, new Item.Properties().defaultMaxDamage(0).group(ItemGroup.DECORATIONS).
													maxStackSize(64).rarity(EnumRarity.COMMON).setNoRepair()).setRegistryName(BlockList.slingshot2_block.getRegistryName()));
			
			EggRed = registerEntityAndEgg(event.getRegistry(), EntityRed.class, EntityRed::new, 0xdf0000, 0xdfbf9f, 32, 1, true, "red");
			EggChuck = registerEntityAndEgg(event.getRegistry(), EntityChuck.class, EntityChuck::new, 0xffff00, 0xffffff, 32, 1, true, "chuck");
			EggBlues = registerEntityAndEgg(event.getRegistry(), EntityBlues.class, EntityBlues::new, 0x007fff, 0xff0000, 32, 1, true, "blues");
			EggBomb = registerEntityAndEgg(event.getRegistry(), EntityBomb.class, EntityBomb::new, 0x3f3f3f, 0x7f7f7f, 32, 1, true, "bomb");
			EggMathilda = registerEntityAndEgg(event.getRegistry(), EntityMathilda.class, EntityMathilda::new, 0xffffff, 0xffbfbf, 32, 1, true, "mathilda");
		}
		
		@SubscribeEvent
		public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event)
		{
			event.getRegistry().registerAll(EggRed,
											EggChuck,
											EggBlues,
											EggBomb,
											EggMathilda);
		}
		
		public static <T extends Entity>EntityType<T> registerEntityAndEgg(IForgeRegistry<Item> itemRegistry, Class<T> entityClass, Function<? super World, T> factory, int eggPrimaryColor, int eggSecondaryColor, int trackingRange, int updateFrequency, boolean sendVelocityUpdates, String name)
	    {
	        @SuppressWarnings("unchecked")
			EntityType<T> type = (EntityType<T>) EntityType.Builder.create(entityClass, factory).tracker(trackingRange, updateFrequency, sendVelocityUpdates).build(Reference.MOD_ID + '.' + name).setRegistryName(name);
	        itemRegistry.register(new ItemSpawnEgg(type, eggPrimaryColor, eggSecondaryColor, new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(name + "_spawn_egg"));
	        return type;
	    }
    }
}
