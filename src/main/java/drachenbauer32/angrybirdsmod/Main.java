package drachenbauer32.angrybirdsmod;

import java.util.function.Function;

import drachenbauer32.angrybirdsmod.entity.EntityBlues;
import drachenbauer32.angrybirdsmod.entity.EntityBomb;
import drachenbauer32.angrybirdsmod.entity.EntityChuck;
import drachenbauer32.angrybirdsmod.entity.EntityMathilda;
import drachenbauer32.angrybirdsmod.entity.EntityRed;
import drachenbauer32.angrybirdsmod.init.BlockInit;
import drachenbauer32.angrybirdsmod.init.ItemInit;
import drachenbauer32.angrybirdsmod.util.Reference;
import drachenbauer32.angrybirdsmod.util.handlers.RenderHandler;
import com.google.common.base.Preconditions;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemSpawnEgg;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

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
		BlockInit.initBlocks();
		ItemInit.initItems();
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
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			final IForgeRegistry<Block> registry = event.getRegistry();
		    for(Block block: BlockInit.BLOCKS)
		    {
		        registry.register(block);
		    }
		}
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			final IForgeRegistry<Item> registry = event.getRegistry();
			
		    for(ItemBlock itemBlock:BlockInit.ITEMBLOCKS)
		    {
		        final Block block = itemBlock.getBlock();
		        final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
		        ItemBlock itemBlock1 = (ItemBlock) new ItemBlock(block,new Item.Properties().group(itemBlock.getGroup())).setRegistryName(registryName);   
		        registry.register(itemBlock1);
		    }
		    
			//registerEntityAndEgg(event.getRegistry(), EntityRed.class, EntityRed::new, 0xdf0000, 0xdfbf9f, 32, 1, true, "red");
			EggRed = EntityType.Builder.create(EntityRed.class, EntityRed::new).tracker(32, 1, true).build("angrybirdsmod.red").setRegistryName("red");
		    event.getRegistry().register(new ItemSpawnEgg(EggRed, 0xdf0000, 0xdfbf9f, new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("red_spawn_egg"));
		    EggChuck = EntityType.Builder.create(EntityChuck.class, EntityChuck::new).tracker(32, 1, true).build(Reference.MOD_ID + ".chuck").setRegistryName("chuck");
		    event.getRegistry().register(new ItemSpawnEgg(EggChuck, 0xffff00, 0xffffff, new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("chuck_spawn_egg"));
		    EggBlues = EntityType.Builder.create(EntityBlues.class, EntityBlues::new).tracker(32, 1, true).build(Reference.MOD_ID + ".blues").setRegistryName("blues");
		    event.getRegistry().register(new ItemSpawnEgg(EggBlues, 0x007fff, 0xff0000, new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("blues_spawn_egg"));
		    EggBomb = EntityType.Builder.create(EntityBomb.class, EntityBomb::new).tracker(32, 1, true).build(Reference.MOD_ID + ".bomb").setRegistryName("bomb");
		    event.getRegistry().register(new ItemSpawnEgg(EggBomb, 0x3f3f3f, 0x7f7f7f, new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("bomb_spawn_egg"));
		    EggMathilda = EntityType.Builder.create(EntityMathilda.class, EntityMathilda::new).tracker(32, 1, true).build(Reference.MOD_ID + ".mathilda").setRegistryName("mathilda");
		    event.getRegistry().register(new ItemSpawnEgg(EggMathilda, 0xffffff, 0xffbfbf, new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("mathilda_spawn_egg"));
		}
		
		@SubscribeEvent
		public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event)
		{
			event.getRegistry().register(EggRed);
			event.getRegistry().register(EggChuck);
			event.getRegistry().register(EggBlues);
			event.getRegistry().register(EggBomb);
			event.getRegistry().register(EggMathilda);
		}
		
		/*public static <T extends Entity>EntityType<T> registerEntityAndEgg(IForgeRegistry<Item> itemRegistry, Class<T> entityClass, Function<? super World, T> factory, int eggPrimaryColor, int eggSecondaryColor, int trackingRange, int updateFrequency, boolean sendVelocityUpdates, String name)
	    {
	        @SuppressWarnings("unchecked")
			EntityType<T> type = (EntityType<T>) EntityType.Builder.create(entityClass, factory).tracker(trackingRange, updateFrequency, sendVelocityUpdates).build(Reference.MOD_ID + '.' + name).setRegistryName(name);
	        itemRegistry.register(new ItemSpawnEgg(type, eggPrimaryColor, eggSecondaryColor, new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(name + "_spawn_egg"));
	        return type;
	    }*/
    }
}
