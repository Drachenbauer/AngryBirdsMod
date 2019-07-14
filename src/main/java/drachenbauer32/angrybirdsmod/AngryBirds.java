package drachenbauer32.angrybirdsmod;

import drachenbauer32.angrybirdsmod.blocks.BalloonBlock;
import drachenbauer32.angrybirdsmod.blocks.EggBlock;
import drachenbauer32.angrybirdsmod.blocks.NestBlock;
import drachenbauer32.angrybirdsmod.blocks.Slingshot2Block;
import drachenbauer32.angrybirdsmod.blocks.SlingshotBlock;
import drachenbauer32.angrybirdsmod.init.AngryBirdsBlocks;
import drachenbauer32.angrybirdsmod.init.AngryBirdsEntities;
import drachenbauer32.angrybirdsmod.init.AngryBirdsItems;
import drachenbauer32.angrybirdsmod.util.Reference;
import drachenbauer32.angrybirdsmod.util.handlers.RenderHandler;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Rarity;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
//import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MOD_ID)
public class AngryBirds
{
    public AngryBirds() 
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
		}
        
        @SubscribeEvent(priority=normal)*/
        
        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event)
        {
            event.getRegistry().registerAll(AngryBirdsBlocks.balloon_block = new BalloonBlock("balloon_block", DyeColor.WHITE, Block.Properties.create(Material.WOOL, MaterialColor.SNOW).sound(SoundType.CLOTH).
                                                 lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()),
                                            AngryBirdsBlocks.egg_block = new EggBlock("egg_block", Block.Properties.create(Material.CLAY, MaterialColor.SNOW).sound(SoundType.STONE).
                                                 lightValue(0).hardnessAndResistance(0.2f, 1.0f).variableOpacity()),
                                            AngryBirdsBlocks.nest_block = new NestBlock("nest_block", Block.Properties.create(Material.PLANTS, MaterialColor.GOLD).sound(SoundType.PLANT).
                                                 lightValue(0).hardnessAndResistance(0.2f, 1.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_block = new SlingshotBlock("slingshot_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                 lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot2_block = new Slingshot2Block("slingshot2_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                 lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()));
        }
        
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event)
        {
            event.getRegistry().registerAll(AngryBirdsItems.balloon_block = new BlockItem(AngryBirdsBlocks.balloon_block, new Item.Properties().defaultMaxDamage(0).group(ItemGroup.DECORATIONS).
                                                 maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.balloon_block.getRegistryName()),
                                            AngryBirdsItems.egg_block = new BlockItem(AngryBirdsBlocks.egg_block, new Item.Properties().defaultMaxDamage(0).group(ItemGroup.DECORATIONS).
                                                 maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.egg_block.getRegistryName()),
                                            AngryBirdsItems.nest_block = new BlockItem(AngryBirdsBlocks.nest_block, new Item.Properties().defaultMaxDamage(0).group(ItemGroup.DECORATIONS).
                                                 maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.nest_block.getRegistryName()),
                                            AngryBirdsItems.slingshot_block = new BlockItem(AngryBirdsBlocks.slingshot_block, new Item.Properties().defaultMaxDamage(0).group(ItemGroup.DECORATIONS).
                                                 maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.slingshot_block.getRegistryName()),
                                            AngryBirdsItems.slingshot2_block = new BlockItem(AngryBirdsBlocks.slingshot2_block, new Item.Properties().defaultMaxDamage(0).group(ItemGroup.DECORATIONS).
                                                 maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.slingshot2_block.getRegistryName()));
            
            AngryBirdsEntities.registerEntitySpawnEggs(event);
        }
        
        @SubscribeEvent
        public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event)
        {
            event.getRegistry().registerAll(AngryBirdsEntities.RED_ENTITY,
                                            AngryBirdsEntities.CHUCK_ENTITY,
                                            AngryBirdsEntities.BLUES_ENTITY,
                                            AngryBirdsEntities.BOMB_ENTITY,
                                            AngryBirdsEntities.MATHILDA_ENTITY);
        }
    }
}
