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
import net.minecraftforge.client.event.RenderPlayerEvent;
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
		public static void onRenderPlayer(RenderPlayerEvent.Pre event)
		{
			event.setCanceled(true);
		}
		
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
		    
			EggRed = registerEntityAndEgg(event.getRegistry(), EntityRed.class, EntityRed::new, 0xdf0000, 0xdfbf9f, 32, 1, true, "red");
			EggChuck = registerEntityAndEgg(event.getRegistry(), EntityChuck.class, EntityChuck::new, 0xffff00, 0xffffff, 32, 1, true, "chuck");
			EggBlues = registerEntityAndEgg(event.getRegistry(), EntityBlues.class, EntityBlues::new, 0x007fff, 0xff0000, 32, 1, true, "blues");
			EggBomb = registerEntityAndEgg(event.getRegistry(), EntityBomb.class, EntityBomb::new, 0x3f3f3f, 0x7f7f7f, 32, 1, true, "bomb");
			EggMathilda = registerEntityAndEgg(event.getRegistry(), EntityMathilda.class, EntityMathilda::new, 0xffffff, 0xffbfbf, 32, 1, true, "mathilda");
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
		
		public static <T extends Entity>EntityType<T> registerEntityAndEgg(IForgeRegistry<Item> itemRegistry, Class<T> entityClass, Function<? super World, T> factory, int eggPrimaryColor, int eggSecondaryColor, int trackingRange, int updateFrequency, boolean sendVelocityUpdates, String name)
	    {
	        @SuppressWarnings("unchecked")
			EntityType<T> type = (EntityType<T>) EntityType.Builder.create(entityClass, factory).tracker(trackingRange, updateFrequency, sendVelocityUpdates).build(Reference.MOD_ID + '.' + name).setRegistryName(name);
	        itemRegistry.register(new ItemSpawnEgg(type, eggPrimaryColor, eggSecondaryColor, new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(name + "_spawn_egg"));
	        return type;
	    }
    }
}
