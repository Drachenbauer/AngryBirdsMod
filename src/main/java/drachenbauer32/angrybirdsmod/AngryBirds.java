package drachenbauer32.angrybirdsmod;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Ordering;

import drachenbauer32.angrybirdsmod.blocks.BalloonBlock;
import drachenbauer32.angrybirdsmod.blocks.BalloonBlockTop;
import drachenbauer32.angrybirdsmod.blocks.EggBlock;
import drachenbauer32.angrybirdsmod.blocks.FrameBlock;
import drachenbauer32.angrybirdsmod.blocks.NestBlock;
import drachenbauer32.angrybirdsmod.blocks.SlingshotBlock;
import drachenbauer32.angrybirdsmod.blocks.SlingshotBlockSide;
import drachenbauer32.angrybirdsmod.blocks.SlingshotBlockSideTop;
import drachenbauer32.angrybirdsmod.blocks.SlingshotWoodBaseBlock;
import drachenbauer32.angrybirdsmod.entities.BluesEntity;
import drachenbauer32.angrybirdsmod.entities.BombEntity;
import drachenbauer32.angrybirdsmod.entities.BubblesEntity;
import drachenbauer32.angrybirdsmod.entities.ChuckEntity;
import drachenbauer32.angrybirdsmod.entities.CoralEntity;
import drachenbauer32.angrybirdsmod.entities.DahliaEntity;
import drachenbauer32.angrybirdsmod.entities.HalEntity;
import drachenbauer32.angrybirdsmod.entities.IceBirdEntity;
import drachenbauer32.angrybirdsmod.entities.LucaEntity;
import drachenbauer32.angrybirdsmod.entities.MathildaEntity;
import drachenbauer32.angrybirdsmod.entities.PoppyEntity;
import drachenbauer32.angrybirdsmod.entities.RedEntity;
//import drachenbauer32.angrybirdsmod.entities.RedShotEntity;
import drachenbauer32.angrybirdsmod.entities.SilverEntity;
import drachenbauer32.angrybirdsmod.entities.StellaEntity;
import drachenbauer32.angrybirdsmod.entities.TerenceEntity;
import drachenbauer32.angrybirdsmod.entities.WillowEntity;
import drachenbauer32.angrybirdsmod.entities.renderers.StellaMoviePlayerRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.StellaPlayerRenderer;
import drachenbauer32.angrybirdsmod.entities.tile_entities.BlockColorsTileEntity;
import drachenbauer32.angrybirdsmod.init.AngryBirdsBlocks;
import drachenbauer32.angrybirdsmod.init.AngryBirdsEntities;
import drachenbauer32.angrybirdsmod.init.AngryBirdsItems;
import drachenbauer32.angrybirdsmod.init.AngryBirdsTileEntities;
import drachenbauer32.angrybirdsmod.items.BalloonBlockItem;
import drachenbauer32.angrybirdsmod.items.BirdShotItem;
import drachenbauer32.angrybirdsmod.items.SlingshotBlockItem;
import drachenbauer32.angrybirdsmod.items.SlingshotItem;
import drachenbauer32.angrybirdsmod.util.AngryBirdsItemGroup;
import drachenbauer32.angrybirdsmod.util.Reference;
import drachenbauer32.angrybirdsmod.util.handlers.RenderHandler;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Rarity;
import net.minecraft.item.ScaffoldingItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
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
    public static Comparator<ItemStack> itemSorter;
    private static StellaPlayerRenderer stella_player_renderer = new StellaPlayerRenderer(null);
    private static StellaMoviePlayerRenderer stella_movie_player_renderer = new StellaMoviePlayerRenderer(null);
    
    public AngryBirds() 
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    private void setup(final FMLCommonSetupEvent event)
    {
        List<Item> items = Arrays.asList(AngryBirdsItems.red_egg,
                                         AngryBirdsItems.chuck_egg,
                                         AngryBirdsItems.blues_egg,
                                         AngryBirdsItems.bomb_egg,
                                         AngryBirdsItems.mathilda_egg,
                                         AngryBirdsItems.terence_egg,
                                         AngryBirdsItems.silver_egg,
                                         AngryBirdsItems.bubbles_egg,
                                         AngryBirdsItems.hal_egg,
                                         AngryBirdsItems.stella_egg,
                                         AngryBirdsItems.poppy_egg,
                                         AngryBirdsItems.willow_egg,
                                         AngryBirdsItems.dahlia_egg,
                                         AngryBirdsItems.luca_egg,
                                         AngryBirdsItems.ice_bird_egg,
                                         AngryBirdsItems.coral_egg,
                                         
                                         AngryBirdsItems.red_shot,
                                         AngryBirdsItems.chuck_shot,
                                         AngryBirdsItems.blues_shot,
                                         AngryBirdsItems.bomb_shot,
                                         AngryBirdsItems.mathilda_shot,
                                         AngryBirdsItems.terence_shot,
                                         AngryBirdsItems.silver_shot,
                                         AngryBirdsItems.bubbles_shot,
                                         AngryBirdsItems.hal_shot,
                                         AngryBirdsItems.stella_shot,
                                         AngryBirdsItems.poppy_shot,
                                         AngryBirdsItems.willow_shot,
                                         AngryBirdsItems.dahlia_shot,
                                         AngryBirdsItems.luca_shot,
                                         AngryBirdsItems.ice_bird_shot,
                                         AngryBirdsItems.slingshot,
                                         
                                         AngryBirdsItems.egg_block,
                                         AngryBirdsItems.nest,
                                         
                                         AngryBirdsItems.slingshot_acacia,
                                         AngryBirdsItems.slingshot_acacia_2,
                                         AngryBirdsItems.slingshot_birch,
                                         AngryBirdsItems.slingshot_birch_2,
                                         AngryBirdsItems.slingshot_dark_oak,
                                         AngryBirdsItems.slingshot_dark_oak_2,
                                         AngryBirdsItems.slingshot_jungle,
                                         AngryBirdsItems.slingshot_jungle_2,
                                         AngryBirdsItems.slingshot_oak,
                                         AngryBirdsItems.slingshot_oak_2,
                                         AngryBirdsItems.slingshot_spruce,
                                         AngryBirdsItems.slingshot_spruce_2,
                                         
                                         AngryBirdsItems.acacia_planks_frame,
                                         AngryBirdsItems.birch_planks_frame,
                                         AngryBirdsItems.dark_oak_planks_frame,
                                         AngryBirdsItems.jungle_planks_frame,
                                         AngryBirdsItems.oak_planks_frame,
                                         AngryBirdsItems.spruce_planks_frame,
                                         AngryBirdsItems.stone_frame,
                                         AngryBirdsItems.blue_ice_frame,
                                         
                                         AngryBirdsItems.red_balloon,
                                         AngryBirdsItems.orange_balloon,
                                         AngryBirdsItems.yellow_balloon,
                                         AngryBirdsItems.lime_balloon,
                                         AngryBirdsItems.cyan_balloon,
                                         AngryBirdsItems.blue_balloon,
                                         AngryBirdsItems.purple_balloon,
                                         AngryBirdsItems.magenta_balloon,
                                         AngryBirdsItems.pink_balloon,
                                         AngryBirdsItems.light_blue_balloon,
                                         AngryBirdsItems.green_balloon,
                                         AngryBirdsItems.brown_balloon,
                                         AngryBirdsItems.black_balloon,
                                         AngryBirdsItems.gray_balloon,
                                         AngryBirdsItems.light_gray_balloon,
                                         AngryBirdsItems.white_balloon);
        
        itemSorter = Ordering.explicit(items).onResultOf(ItemStack::getItem);
    }
    
    private void clientRegistries(final FMLClientSetupEvent event)
    {
        RenderHandler.regigisterEntityRenders();
    }
    
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        public static final ItemGroup ANGRY_BIRDS = new AngryBirdsItemGroup();
        
        public static IBlockColor blockColor;
        
        public static IItemColor itemColor;
        
        @SubscribeEvent
		public static void onRenderPlayer(RenderPlayerEvent.Pre event)
		{
			event.setCanceled(true);
			//event.getRenderer().render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			
			//stella_movie_player_renderer.render((AbstractClientPlayerEntity) event.getPlayer(), event.getX(), event.getY(), event.getZ(), event.getEntity().rotationYaw, event.getPartialRenderTick());
			//StellaMoviePlayerRenderer.render(null, 0, 0, null, null, 0);
		}
        
        //@SubscribeEvent(priority=normal)
        
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event)
        {
            registerEntitySpawnEggs(event);
            
            event.getRegistry().registerAll(AngryBirdsItems.red_shot = new BirdShotItem("red_shot", new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()),
                                            AngryBirdsItems.chuck_shot = new BirdShotItem("chuck_shot", new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()),
                                            AngryBirdsItems.blues_shot = new BirdShotItem("blues_shot", new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()),
                                            AngryBirdsItems.bomb_shot = new BirdShotItem("bomb_shot", new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()),
                                            AngryBirdsItems.mathilda_shot = new BirdShotItem("mathilda_shot", new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()),
                                            AngryBirdsItems.terence_shot = new BirdShotItem("terence_shot", new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()),
                                            AngryBirdsItems.silver_shot = new BirdShotItem("silver_shot", new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()),
                                            AngryBirdsItems.bubbles_shot = new BirdShotItem("bubbles_shot", new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()),
                                            AngryBirdsItems.hal_shot = new BirdShotItem("hal_shot", new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()),
                                            AngryBirdsItems.stella_shot = new BirdShotItem("stella_shot", new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()),
                                            AngryBirdsItems.poppy_shot = new BirdShotItem("poppy_shot", new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()),
                                            AngryBirdsItems.willow_shot = new BirdShotItem("willow_shot", new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()),
                                            AngryBirdsItems.dahlia_shot = new BirdShotItem("dahlia_shot", new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()),
                                            AngryBirdsItems.luca_shot = new BirdShotItem("luca_shot", new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()),
                                            AngryBirdsItems.ice_bird_shot = new BirdShotItem("ice_bird_shot", new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()),
                                            AngryBirdsItems.slingshot = new SlingshotItem(new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(1).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("slingshot"),
                                            
                                            AngryBirdsItems.egg_block = new BlockItem(AngryBirdsBlocks.egg_block,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("egg_block"),
                                            AngryBirdsItems.nest = new BlockItem(AngryBirdsBlocks.nest,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("nest"),
                                            
                                            AngryBirdsItems.slingshot_acacia = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_acacia,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("slingshot_acacia"),
                                            AngryBirdsItems.slingshot_acacia_2 = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_acacia_2,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("slingshot_acacia_2"),
                                            AngryBirdsItems.slingshot_birch = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_birch,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("slingshot_birch"),
                                            AngryBirdsItems.slingshot_birch_2 = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_birch_2,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("slingshot_birch_2"),
                                            AngryBirdsItems.slingshot_dark_oak = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_dark_oak,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("slingshot_dark_oak"),
                                            AngryBirdsItems.slingshot_dark_oak_2 = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_dark_oak_2,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("slingshot_dark_oak_2"),
                                            AngryBirdsItems.slingshot_jungle = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_jungle,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("slingshot_jungle"),
                                            AngryBirdsItems.slingshot_jungle_2 = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_jungle_2,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("slingshot_jungle_2"),
                                            AngryBirdsItems.slingshot_oak = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_oak,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("slingshot_oak"),
                                            AngryBirdsItems.slingshot_oak_2 = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_oak_2,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("slingshot_oak_2"),
                                            AngryBirdsItems.slingshot_spruce = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_spruce,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("slingshot_spruce"),
                                            AngryBirdsItems.slingshot_spruce_2 = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_spruce_2,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("slingshot_spruce_2"),
                                            
                                            AngryBirdsItems.acacia_planks_frame = new ScaffoldingItem(AngryBirdsBlocks.acacia_planks_frame,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("acacia_planks_frame"),
                                            AngryBirdsItems.birch_planks_frame = new ScaffoldingItem(AngryBirdsBlocks.birch_planks_frame,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("birch_planks_frame"),
                                            AngryBirdsItems.dark_oak_planks_frame = new ScaffoldingItem(AngryBirdsBlocks.dark_oak_planks_frame,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("dark_oak_planks_frame"),
                                            AngryBirdsItems.jungle_planks_frame = new ScaffoldingItem(AngryBirdsBlocks.jungle_planks_frame,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("jungle_planks_frame"),
                                            AngryBirdsItems.oak_planks_frame = new ScaffoldingItem(AngryBirdsBlocks.oak_planks_frame,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("oak_planks_frame"),
                                            AngryBirdsItems.spruce_planks_frame = new ScaffoldingItem(AngryBirdsBlocks.spruce_planks_frame,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("spruce_planks_frame"),
                                            AngryBirdsItems.stone_frame = new ScaffoldingItem(AngryBirdsBlocks.stone_frame,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("stone_frame"),
                                            AngryBirdsItems.blue_ice_frame = new ScaffoldingItem(AngryBirdsBlocks.blue_ice_frame,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("blue_ice_frame"),
                                            
                                            AngryBirdsItems.black_balloon = new BalloonBlockItem(AngryBirdsBlocks.black_balloon,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("black_balloon"),
                                            AngryBirdsItems.blue_balloon = new BalloonBlockItem(AngryBirdsBlocks.blue_balloon,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("blue_balloon"),
                                            AngryBirdsItems.brown_balloon = new BalloonBlockItem(AngryBirdsBlocks.brown_balloon,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("brown_balloon"),
                                            AngryBirdsItems.cyan_balloon = new BalloonBlockItem(AngryBirdsBlocks.cyan_balloon,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("cyan_balloon"),
                                            AngryBirdsItems.gray_balloon = new BalloonBlockItem(AngryBirdsBlocks.gray_balloon,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("gray_balloon"),
                                            AngryBirdsItems.green_balloon = new BalloonBlockItem(AngryBirdsBlocks.green_balloon,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("green_balloon"),
                                            AngryBirdsItems.light_blue_balloon = new BalloonBlockItem(AngryBirdsBlocks.light_blue_balloon,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("light_blue_balloon"),
                                            AngryBirdsItems.light_gray_balloon = new BalloonBlockItem(AngryBirdsBlocks.light_gray_balloon,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("light_gray_balloon"),
                                            AngryBirdsItems.lime_balloon = new BalloonBlockItem(AngryBirdsBlocks.lime_balloon,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("lime_balloon"),
                                            AngryBirdsItems.magenta_balloon = new BalloonBlockItem(AngryBirdsBlocks.magenta_balloon,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("magenta_balloon"),
                                            AngryBirdsItems.orange_balloon = new BalloonBlockItem(AngryBirdsBlocks.orange_balloon,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("orange_balloon"),
                                            AngryBirdsItems.pink_balloon = new BalloonBlockItem(AngryBirdsBlocks.pink_balloon,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("pink_balloon"),
                                            AngryBirdsItems.purple_balloon = new BalloonBlockItem(AngryBirdsBlocks.purple_balloon,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("purple_balloon"),
                                            AngryBirdsItems.red_balloon = new BalloonBlockItem(AngryBirdsBlocks.red_balloon,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("red_balloon"),
                                            AngryBirdsItems.white_balloon = new BalloonBlockItem(AngryBirdsBlocks.white_balloon,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("white_balloon"),
                                            AngryBirdsItems.yellow_balloon = new BalloonBlockItem(AngryBirdsBlocks.yellow_balloon,
                                            new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                            maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("yellow_balloon"));
        }
        
        @SuppressWarnings("unchecked")
        public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item>event)
        {
            AngryBirdsEntities.RED = (EntityType<RedEntity>) EntityType.Builder.create(RedEntity::new, EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".red").setRegistryName("red");
            AngryBirdsEntities.CHUCK = (EntityType<ChuckEntity>) EntityType.Builder.create(ChuckEntity::new, EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".chuck").setRegistryName("chuck");
            AngryBirdsEntities.BLUES = (EntityType<BluesEntity>) EntityType.Builder.create(BluesEntity::new, EntityClassification.CREATURE).size(0.25F, 0.75F).build(Reference.MOD_ID + ".blues").setRegistryName("blues");
            AngryBirdsEntities.BOMB = (EntityType<BombEntity>) EntityType.Builder.create(BombEntity::new, EntityClassification.CREATURE).size(0.75F, 0.75F).build(Reference.MOD_ID + ".bomb").setRegistryName("bomb");
            AngryBirdsEntities.MATHILDA = (EntityType<MathildaEntity>) EntityType.Builder.create(MathildaEntity::new, EntityClassification.CREATURE).size(0.5F, 0.625F).build(Reference.MOD_ID + ".mathilda").setRegistryName("mathilda");
            AngryBirdsEntities.TERENCE = (EntityType<TerenceEntity>) EntityType.Builder.create(TerenceEntity::new, EntityClassification.CREATURE).size(1.25F, 1.25F).build(Reference.MOD_ID + ".terence").setRegistryName("terence");
            AngryBirdsEntities.SILVER = (EntityType<SilverEntity>) EntityType.Builder.create(SilverEntity::new, EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".silver").setRegistryName("silver");
            AngryBirdsEntities.BUBBLES = (EntityType<BubblesEntity>) EntityType.Builder.create(BubblesEntity::new, EntityClassification.CREATURE).size(0.25F, 0.25F).build(Reference.MOD_ID + ".bubbles").setRegistryName("bubbles");
            AngryBirdsEntities.HAL = (EntityType<HalEntity>) EntityType.Builder.create(HalEntity::new, EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".hal").setRegistryName("hal");
            AngryBirdsEntities.STELLA = (EntityType<StellaEntity>) EntityType.Builder.create(StellaEntity::new, EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".stella").setRegistryName("stella");
            AngryBirdsEntities.POPPY = (EntityType<PoppyEntity>) EntityType.Builder.create(PoppyEntity::new, EntityClassification.CREATURE).size(0.5F, 0.625F).build(Reference.MOD_ID + ".poppy").setRegistryName("poppy");
            AngryBirdsEntities.WILLOW = (EntityType<WillowEntity>) EntityType.Builder.create(WillowEntity::new, EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".willow").setRegistryName("willow");
            AngryBirdsEntities.DAHLIA = (EntityType<DahliaEntity>) EntityType.Builder.create(DahliaEntity::new, EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".dahlia").setRegistryName("dahlia");
            AngryBirdsEntities.LUCA = (EntityType<LucaEntity>) EntityType.Builder.create(LucaEntity::new, EntityClassification.CREATURE).size(0.25F, 0.25F).build(Reference.MOD_ID + ".luca").setRegistryName("luca");
            AngryBirdsEntities.ICE_BIRD = (EntityType<IceBirdEntity>) EntityType.Builder.create(IceBirdEntity::new, EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".ice_bird").setRegistryName("ice_bird");
            AngryBirdsEntities.CORAL = (EntityType<CoralEntity>) EntityType.Builder.create(CoralEntity::new, EntityClassification.CREATURE).size(0.5F, 0.875F).build(Reference.MOD_ID + ".coral").setRegistryName("coral");
            
            //AngryBirdsEntities.RED_SHOT = EntityType.Builder.<RedShotEntity>create(RedShotEntity::new, EntityClassification.MISC).size(0.5F, 0.5F);
            
            event.getRegistry().registerAll(AngryBirdsItems.red_egg = registerEntitySpawnEgg(AngryBirdsEntities.RED, 0xdf0000, 0xdfbf9f, "red_egg"),
                                            AngryBirdsItems.chuck_egg = registerEntitySpawnEgg(AngryBirdsEntities.CHUCK, 0xffff00, 0xffffff, "chuck_egg"),
                                            AngryBirdsItems.blues_egg = registerEntitySpawnEgg(AngryBirdsEntities.BLUES, 0x007fff, 0xff0000, "blues_egg"),
                                            AngryBirdsItems.bomb_egg = registerEntitySpawnEgg(AngryBirdsEntities.BOMB, 0x3f3f3f, 0x7f7f7f, "bomb_egg"),
                                            AngryBirdsItems.mathilda_egg = registerEntitySpawnEgg(AngryBirdsEntities.MATHILDA, 0xffffff, 0xffbfbf, "mathilda_egg"),
                                            AngryBirdsItems.terence_egg = registerEntitySpawnEgg(AngryBirdsEntities.TERENCE, 0xbf002f, 0xbf9f7f, "terence_egg"),
                                            AngryBirdsItems.silver_egg = registerEntitySpawnEgg(AngryBirdsEntities.SILVER, 0xbfbfbf, 0xffffff, "silver_egg"),
                                            AngryBirdsItems.bubbles_egg = registerEntitySpawnEgg(AngryBirdsEntities.BUBBLES, 0xff7f00, 0x000000, "bubbles_egg"),
                                            AngryBirdsItems.hal_egg = registerEntitySpawnEgg(AngryBirdsEntities.HAL, 0x00bf00, 0xffffff, "hal_egg"),
                                            AngryBirdsItems.stella_egg = registerEntitySpawnEgg(AngryBirdsEntities.STELLA, 0xffadb7, 0xffd7dc, "stella_egg"),
                                            AngryBirdsItems.poppy_egg = registerEntitySpawnEgg(AngryBirdsEntities.POPPY, 0xffff3f, 0xffffbf, "poppy_egg"),
                                            AngryBirdsItems.willow_egg = registerEntitySpawnEgg(AngryBirdsEntities.WILLOW, 0x3f9fff, 0x7fbfff, "willow_egg"),
                                            AngryBirdsItems.dahlia_egg = registerEntitySpawnEgg(AngryBirdsEntities.DAHLIA, 0xbf7f3f, 0xffdfbf, "dahlia_egg"),
                                            AngryBirdsItems.luca_egg = registerEntitySpawnEgg(AngryBirdsEntities.LUCA, 0x7fbfff, 0xffffbf, "luca_egg"),
                                            AngryBirdsItems.ice_bird_egg = registerEntitySpawnEgg(AngryBirdsEntities.ICE_BIRD, 0x7fbfff, 0x007fff, "ice_bird_egg"),
                                            AngryBirdsItems.coral_egg = registerEntitySpawnEgg(AngryBirdsEntities.CORAL, 0xff7fff, 0xffbfff, "coral_egg"));       
        }
        
        public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name)
        {
            SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(ANGRY_BIRDS));
            item.setRegistryName(name);
            return item;
        }
        
        @SubscribeEvent
        public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event)
        {
            event.getRegistry().registerAll(AngryBirdsEntities.RED,
                                            AngryBirdsEntities.CHUCK,
                                            AngryBirdsEntities.BLUES,
                                            AngryBirdsEntities.BOMB,
                                            AngryBirdsEntities.MATHILDA,
                                            AngryBirdsEntities.TERENCE,
                                            AngryBirdsEntities.SILVER,
                                            AngryBirdsEntities.BUBBLES,
                                            AngryBirdsEntities.HAL,
                                            AngryBirdsEntities.STELLA,
                                            AngryBirdsEntities.POPPY,
                                            AngryBirdsEntities.WILLOW,
                                            AngryBirdsEntities.DAHLIA,
                                            AngryBirdsEntities.LUCA,
                                            AngryBirdsEntities.ICE_BIRD,
                                            AngryBirdsEntities.CORAL);
        }
        
        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event)
        {
            event.getRegistry().registerAll(AngryBirdsBlocks.egg_block = new EggBlock(Block.Properties.create(Material.CLAY, MaterialColor.SNOW).notSolid().sound(SoundType.STONE).
                                                lightValue(0).hardnessAndResistance(0.2f, 1.0f).variableOpacity()).setRegistryName("egg_block"),
                                            AngryBirdsBlocks.nest = new NestBlock(Block.Properties.create(Material.PLANTS, MaterialColor.GOLD).notSolid().sound(SoundType.PLANT).
                                                lightValue(0).hardnessAndResistance(0.2f, 1.0f).variableOpacity()).setRegistryName("nest"),
                                            
                                            AngryBirdsBlocks.slingshot_acacia = new SlingshotBlock("slingshot_acacia",
                                            Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_acacia_wood_base = new SlingshotWoodBaseBlock("slingshot_acacia_wood_base",
                                            Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_acacia_2 = new SlingshotBlock("slingshot_acacia_2",
                                            Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_acacia_2_wood_base = new SlingshotWoodBaseBlock("slingshot_acacia_2_wood_base",
                                            Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_acacia_side = new SlingshotBlockSide(Block.Properties.create(
                                            Material.WOOD, MaterialColor.ADOBE).notSolid().sound(SoundType.WOOD).lightValue(0).
                                            hardnessAndResistance(2.0f, 3.0f).variableOpacity()).setRegistryName("slingshot_acacia_side"),
                                            AngryBirdsBlocks.slingshot_acacia_side_top = new SlingshotBlockSideTop(Block.Properties.create(
                                            Material.WOOD, MaterialColor.ADOBE).notSolid().sound(SoundType.WOOD).lightValue(0).
                                            hardnessAndResistance(2.0f, 3.0f).variableOpacity()).setRegistryName("slingshot_acacia_side_top"),
                                            
                                            AngryBirdsBlocks.slingshot_birch = new SlingshotBlock("slingshot_birch",
                                            Block.Properties.create(Material.WOOD, MaterialColor.SAND).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_birch_wood_base = new SlingshotWoodBaseBlock("slingshot_birch_wood_base",
                                            Block.Properties.create(Material.WOOD, MaterialColor.SAND).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_birch_2 = new SlingshotBlock("slingshot_birch_2",
                                            Block.Properties.create(Material.WOOD, MaterialColor.SAND).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_birch_2_wood_base = new SlingshotWoodBaseBlock("slingshot_birch_2_wood_base",
                                            Block.Properties.create(Material.WOOD, MaterialColor.SAND).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_birch_side = new SlingshotBlockSide(Block.Properties.create(
                                            Material.WOOD, MaterialColor.SAND).notSolid().sound(SoundType.WOOD).lightValue(0).
                                            hardnessAndResistance(2.0f, 3.0f).variableOpacity()).setRegistryName("slingshot_birch_side"),
                                            AngryBirdsBlocks.slingshot_birch_side_top = new SlingshotBlockSideTop(Block.Properties.create(
                                            Material.WOOD, MaterialColor.SAND).notSolid().sound(SoundType.WOOD).lightValue(0).
                                            hardnessAndResistance(2.0f, 3.0f).variableOpacity()).setRegistryName("slingshot_birch_side_top"),
                                            
                                            AngryBirdsBlocks.slingshot_dark_oak = new SlingshotBlock("slingshot_dark_oak",
                                            Block.Properties.create(Material.WOOD, MaterialColor.BROWN).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_dark_oak_wood_base = new SlingshotWoodBaseBlock("slingshot_dark_oak_wood_base",
                                            Block.Properties.create(Material.WOOD, MaterialColor.BROWN).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_dark_oak_2 = new SlingshotBlock("slingshot_dark_oak_2",
                                            Block.Properties.create(Material.WOOD, MaterialColor.BROWN).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_dark_oak_2_wood_base = new SlingshotWoodBaseBlock("slingshot_dark_oak_2_wood_base",
                                            Block.Properties.create(Material.WOOD, MaterialColor.BROWN).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_dark_oak_side = new SlingshotBlockSide(Block.Properties.create(
                                            Material.WOOD, MaterialColor.BROWN).notSolid().sound(SoundType.WOOD).lightValue(0).
                                            hardnessAndResistance(2.0f, 3.0f).variableOpacity()).setRegistryName("slingshot_dark_oak_side"),
                                            AngryBirdsBlocks.slingshot_dark_oak_side_top = new SlingshotBlockSideTop(Block.Properties.create(
                                            Material.WOOD, MaterialColor.BROWN).notSolid().sound(SoundType.WOOD).lightValue(0).
                                            hardnessAndResistance(2.0f, 3.0f).variableOpacity()).setRegistryName("slingshot_dark_oak_side_top"),
                                            
                                            AngryBirdsBlocks.slingshot_jungle = new SlingshotBlock("slingshot_jungle",
                                            Block.Properties.create(Material.WOOD, MaterialColor.DIRT).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_jungle_wood_base = new SlingshotWoodBaseBlock("slingshot_jungle_wood_base",
                                            Block.Properties.create(Material.WOOD, MaterialColor.DIRT).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_jungle_2 = new SlingshotBlock("slingshot_jungle_2",
                                            Block.Properties.create(Material.WOOD, MaterialColor.DIRT).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_jungle_2_wood_base = new SlingshotWoodBaseBlock("slingshot_jungle_2_wood_base",
                                            Block.Properties.create(Material.WOOD, MaterialColor.DIRT).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_jungle_side = new SlingshotBlockSide(Block.Properties.create(
                                            Material.WOOD, MaterialColor.DIRT).notSolid().sound(SoundType.WOOD).lightValue(0).
                                            hardnessAndResistance(2.0f, 3.0f).variableOpacity()).setRegistryName("slingshot_jungle_side"),
                                            AngryBirdsBlocks.slingshot_jungle_side_top = new SlingshotBlockSideTop(Block.Properties.create(
                                            Material.WOOD, MaterialColor.DIRT).notSolid().sound(SoundType.WOOD).lightValue(0).
                                            hardnessAndResistance(2.0f, 3.0f).variableOpacity()).setRegistryName("slingshot_jungle_side_top"),
                                            
                                            AngryBirdsBlocks.slingshot_oak = new SlingshotBlock("slingshot_oak",
                                            Block.Properties.create(Material.WOOD, MaterialColor.WOOD).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_oak_wood_base = new SlingshotWoodBaseBlock("slingshot_oak_wood_base",
                                            Block.Properties.create(Material.WOOD, MaterialColor.WOOD).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_oak_2 = new SlingshotBlock("slingshot_oak_2",
                                            Block.Properties.create(Material.WOOD, MaterialColor.WOOD).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_oak_2_wood_base = new SlingshotWoodBaseBlock("slingshot_oak_2_wood_base",
                                            Block.Properties.create(Material.WOOD, MaterialColor.WOOD).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_oak_side = new SlingshotBlockSide(Block.Properties.create(
                                            Material.WOOD, MaterialColor.WOOD).notSolid().sound(SoundType.WOOD).lightValue(0).
                                            hardnessAndResistance(2.0f, 3.0f).variableOpacity()).setRegistryName("slingshot_oak_side"),
                                            AngryBirdsBlocks.slingshot_oak_side_top = new SlingshotBlockSideTop(Block.Properties.create(
                                            Material.WOOD, MaterialColor.WOOD).notSolid().sound(SoundType.WOOD).lightValue(0).
                                            hardnessAndResistance(2.0f, 3.0f).variableOpacity()).setRegistryName("slingshot_oak_side_top"),
                                            
                                            AngryBirdsBlocks.slingshot_spruce = new SlingshotBlock("slingshot_spruce",
                                            Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_spruce_wood_base = new SlingshotWoodBaseBlock("slingshot_spruce_wood_base",
                                            Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_spruce_2 = new SlingshotBlock("slingshot_spruce_2",
                                            Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_spruce_2_wood_base = new SlingshotWoodBaseBlock("slingshot_spruce_2_wood_base",
                                            Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).notSolid().
                                            sound(SoundType.WOOD).lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_spruce_side = new SlingshotBlockSide(Block.Properties.create(
                                            Material.WOOD, MaterialColor.OBSIDIAN).notSolid().sound(SoundType.WOOD).lightValue(0).
                                            hardnessAndResistance(2.0f, 3.0f).variableOpacity()).setRegistryName("slingshot_spruce_side"),
                                            AngryBirdsBlocks.slingshot_spruce_side_top = new SlingshotBlockSideTop(Block.Properties.create(
                                            Material.WOOD, MaterialColor.OBSIDIAN).notSolid().sound(SoundType.WOOD).lightValue(0).
                                            hardnessAndResistance(2.0f, 3.0f).variableOpacity()).setRegistryName("slingshot_spruce_side_top"),
                                            
                                            AngryBirdsBlocks.acacia_planks_frame = new FrameBlock(Block.Properties.create(
                                            Material.WOOD, MaterialColor.ADOBE).notSolid().sound(SoundType.WOOD).lightValue(0).
                                            hardnessAndResistance(2.0f, 3.0f).variableOpacity()).setRegistryName("acacia_planks_frame"),
                                            AngryBirdsBlocks.birch_planks_frame = new FrameBlock(Block.Properties.create(
                                            Material.WOOD, MaterialColor.SAND).notSolid().sound(SoundType.WOOD).lightValue(0).
                                            hardnessAndResistance(2.0f, 3.0f).variableOpacity()).setRegistryName("birch_planks_frame"),
                                            AngryBirdsBlocks.dark_oak_planks_frame = new FrameBlock(Block.Properties.create(
                                            Material.WOOD, MaterialColor.BROWN).notSolid().sound(SoundType.WOOD).lightValue(0).
                                            hardnessAndResistance(2.0f, 3.0f).variableOpacity()).setRegistryName("dark_oak_planks_frame"),
                                            AngryBirdsBlocks.jungle_planks_frame = new FrameBlock(Block.Properties.create(
                                            Material.WOOD, MaterialColor.DIRT).notSolid().sound(SoundType.WOOD).lightValue(0).
                                            hardnessAndResistance(2.0f, 3.0f).variableOpacity()).setRegistryName("jungle_planks_frame"),
                                            AngryBirdsBlocks.oak_planks_frame = new FrameBlock(Block.Properties.create(
                                            Material.WOOD, MaterialColor.WOOD).notSolid().sound(SoundType.WOOD).lightValue(0).
                                            hardnessAndResistance(2.0f, 3.0f).variableOpacity()).setRegistryName("oak_planks_frame"),
                                            AngryBirdsBlocks.spruce_planks_frame = new FrameBlock(Block.Properties.create(
                                            Material.WOOD, MaterialColor.OBSIDIAN).notSolid().sound(SoundType.WOOD).lightValue(0).
                                            hardnessAndResistance(2.0f, 3.0f).variableOpacity()).setRegistryName("spruce_planks_frame"),
                                            AngryBirdsBlocks.stone_frame = new FrameBlock(Block.Properties.create(
                                            Material.ROCK, MaterialColor.STONE).notSolid().sound(SoundType.STONE).lightValue(0).
                                            hardnessAndResistance(2.0f, 3.0f).variableOpacity()).setRegistryName("stone_frame"),
                                            AngryBirdsBlocks.blue_ice_frame = new FrameBlock(Block.Properties.create(
                                            Material.ICE, MaterialColor.ICE).notSolid().sound(SoundType.GLASS).lightValue(0).
                                            hardnessAndResistance(1.0f, 2.0f).variableOpacity()).setRegistryName("blue_ice_frame"),
                                            
                                            AngryBirdsBlocks.black_balloon_top = new BalloonBlockTop(AngryBirdsItems.black_balloon,
                                            Block.Properties.create(Material.WOOL,MaterialColor.BLACK).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("black_balloon_top"),
                                            AngryBirdsBlocks.blue_balloon_top = new BalloonBlockTop(AngryBirdsItems.blue_balloon,
                                            Block.Properties.create(Material.WOOL,MaterialColor.BLUE).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("blue_balloon_top"),
                                            AngryBirdsBlocks.brown_balloon_top = new BalloonBlockTop(AngryBirdsItems.brown_balloon,
                                            Block.Properties.create(Material.WOOL,MaterialColor.BROWN).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("brown_balloon_top"),
                                            AngryBirdsBlocks.cyan_balloon_top = new BalloonBlockTop(AngryBirdsItems.cyan_balloon,
                                            Block.Properties.create(Material.WOOL,MaterialColor.CYAN).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("cyan_balloon_top"),
                                            AngryBirdsBlocks.gray_balloon_top = new BalloonBlockTop(AngryBirdsItems.gray_balloon,
                                            Block.Properties.create(Material.WOOL,MaterialColor.GRAY).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("gray_balloon_top"),
                                            AngryBirdsBlocks.green_balloon_top = new BalloonBlockTop(AngryBirdsItems.green_balloon,
                                            Block.Properties.create(Material.WOOL,MaterialColor.GREEN).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("green_balloon_top"),
                                            AngryBirdsBlocks.light_blue_balloon_top = new BalloonBlockTop(AngryBirdsItems.light_blue_balloon,
                                            Block.Properties.create(Material.WOOL,MaterialColor.LIGHT_BLUE).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("light_blue_balloon_top"),
                                            AngryBirdsBlocks.light_gray_balloon_top = new BalloonBlockTop(AngryBirdsItems.light_gray_balloon,
                                            Block.Properties.create(Material.WOOL,MaterialColor.LIGHT_GRAY).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("light_gray_balloon_top"),
                                            AngryBirdsBlocks.lime_balloon_top = new BalloonBlockTop(AngryBirdsItems.lime_balloon,
                                            Block.Properties.create(Material.WOOL,MaterialColor.LIME).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("lime_balloon_top"),
                                            AngryBirdsBlocks.magenta_balloon_top = new BalloonBlockTop(AngryBirdsItems.magenta_balloon,
                                            Block.Properties.create(Material.WOOL,MaterialColor.MAGENTA).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("magenta_balloon_top"),
                                            AngryBirdsBlocks.orange_balloon_top = new BalloonBlockTop(AngryBirdsItems.orange_balloon,
                                            Block.Properties.create(Material.WOOL,MaterialColor.ADOBE).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("orange_balloon_top"),
                                            AngryBirdsBlocks.pink_balloon_top = new BalloonBlockTop(AngryBirdsItems.pink_balloon,
                                            Block.Properties.create(Material.WOOL,MaterialColor.PINK).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("pink_balloon_top"),
                                            AngryBirdsBlocks.purple_balloon_top = new BalloonBlockTop(AngryBirdsItems.purple_balloon,
                                            Block.Properties.create(Material.WOOL,MaterialColor.PURPLE).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("purple_balloon_top"),
                                            AngryBirdsBlocks.red_balloon_top = new BalloonBlockTop(AngryBirdsItems.red_balloon,
                                            Block.Properties.create(Material.WOOL,MaterialColor.RED).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("red_balloon_top"),
                                            AngryBirdsBlocks.white_balloon_top = new BalloonBlockTop(AngryBirdsItems.white_balloon,
                                            Block.Properties.create(Material.WOOL,MaterialColor.SNOW).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("white_balloon_top"),
                                            AngryBirdsBlocks.yellow_balloon_top = new BalloonBlockTop(AngryBirdsItems.yellow_balloon,
                                            Block.Properties.create(Material.WOOL,MaterialColor.YELLOW).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("yellow_balloon_top"),
                                            
                                            AngryBirdsBlocks.black_balloon = new BalloonBlock(DyeColor.BLACK, AngryBirdsBlocks.black_balloon_top,
                                            Block.Properties.create(Material.WOOL, MaterialColor.BLACK).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("black_balloon"),
                                            AngryBirdsBlocks.blue_balloon = new BalloonBlock(DyeColor.BLUE, AngryBirdsBlocks.blue_balloon_top,
                                            Block.Properties.create(Material.WOOL, MaterialColor.BLUE).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("blue_balloon"),
                                            AngryBirdsBlocks.brown_balloon = new BalloonBlock(DyeColor.BROWN, AngryBirdsBlocks.brown_balloon_top,
                                            Block.Properties.create(Material.WOOL, MaterialColor.BROWN).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("brown_balloon"),
                                            AngryBirdsBlocks.cyan_balloon = new BalloonBlock(DyeColor.CYAN, AngryBirdsBlocks.cyan_balloon_top,
                                            Block.Properties.create(Material.WOOL, MaterialColor.CYAN).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("cyan_balloon"),
                                            AngryBirdsBlocks.gray_balloon = new BalloonBlock(DyeColor.GRAY, AngryBirdsBlocks.gray_balloon_top,
                                            Block.Properties.create(Material.WOOL, MaterialColor.GRAY).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("gray_balloon"),
                                            AngryBirdsBlocks.green_balloon = new BalloonBlock(DyeColor.GREEN, AngryBirdsBlocks.green_balloon_top,
                                            Block.Properties.create(Material.WOOL, MaterialColor.GREEN).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("green_balloon"),
                                            AngryBirdsBlocks.light_blue_balloon = new BalloonBlock(DyeColor.LIGHT_BLUE, AngryBirdsBlocks.light_blue_balloon_top,
                                            Block.Properties.create(Material.WOOL, MaterialColor.LIGHT_BLUE).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("light_blue_balloon"),
                                            AngryBirdsBlocks.light_gray_balloon = new BalloonBlock(DyeColor.LIGHT_GRAY, AngryBirdsBlocks.light_gray_balloon_top,
                                            Block.Properties.create(Material.WOOL, MaterialColor.LIGHT_GRAY).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("light_gray_balloon"),
                                            AngryBirdsBlocks.lime_balloon = new BalloonBlock(DyeColor.LIME, AngryBirdsBlocks.lime_balloon_top,
                                            Block.Properties.create(Material.WOOL, MaterialColor.LIME).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("lime_balloon"),
                                            AngryBirdsBlocks.magenta_balloon = new BalloonBlock(DyeColor.MAGENTA, AngryBirdsBlocks.magenta_balloon_top,
                                            Block.Properties.create(Material.WOOL, MaterialColor.MAGENTA).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("magenta_balloon"),
                                            AngryBirdsBlocks.orange_balloon = new BalloonBlock(DyeColor.ORANGE, AngryBirdsBlocks.orange_balloon_top,
                                            Block.Properties.create(Material.WOOL, MaterialColor.ADOBE).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("orange_balloon"),
                                            AngryBirdsBlocks.pink_balloon = new BalloonBlock(DyeColor.PINK, AngryBirdsBlocks.pink_balloon_top,
                                            Block.Properties.create(Material.WOOL, MaterialColor.PINK).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("pink_balloon"),
                                            AngryBirdsBlocks.purple_balloon = new BalloonBlock(DyeColor.PURPLE, AngryBirdsBlocks.purple_balloon_top,
                                            Block.Properties.create(Material.WOOL, MaterialColor.PURPLE).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("purple_balloon"),
                                            AngryBirdsBlocks.red_balloon = new BalloonBlock(DyeColor.RED, AngryBirdsBlocks.red_balloon_top,
                                            Block.Properties.create(Material.WOOL, MaterialColor.RED).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("red_balloon"),
                                            AngryBirdsBlocks.white_balloon = new BalloonBlock(DyeColor.WHITE, AngryBirdsBlocks.white_balloon_top,
                                            Block.Properties.create(Material.WOOL, MaterialColor.SNOW).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("white_balloon"),
                                            AngryBirdsBlocks.yellow_balloon = new BalloonBlock(DyeColor.YELLOW, AngryBirdsBlocks.yellow_balloon_top,
                                            Block.Properties.create(Material.WOOL, MaterialColor.YELLOW).notSolid().sound(SoundType.CLOTH).
                                            lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()).setRegistryName("yellow_balloon"));
        }
        
        @SubscribeEvent
        public static void registerTE(RegistryEvent.Register<TileEntityType<?>> event)
        {
             AngryBirdsTileEntities.BLOCK_COLORS = TileEntityType.Builder.create(BlockColorsTileEntity::new, AngryBirdsBlocks.slingshot_acacia,
                                                                                                             AngryBirdsBlocks.slingshot_acacia_2,
                                                                                                             AngryBirdsBlocks.slingshot_birch,
                                                                                                             AngryBirdsBlocks.slingshot_birch_2,
                                                                                                             AngryBirdsBlocks.slingshot_dark_oak,
                                                                                                             AngryBirdsBlocks.slingshot_dark_oak_2,
                                                                                                             AngryBirdsBlocks.slingshot_jungle,
                                                                                                             AngryBirdsBlocks.slingshot_jungle_2,
                                                                                                             AngryBirdsBlocks.slingshot_oak,
                                                                                                             AngryBirdsBlocks.slingshot_oak_2,
                                                                                                             AngryBirdsBlocks.slingshot_spruce,
                                                                                                             AngryBirdsBlocks.slingshot_spruce_2).build(null);
             AngryBirdsTileEntities.BLOCK_COLORS.setRegistryName(Reference.MOD_ID, "block_colors");
             event.getRegistry().register(AngryBirdsTileEntities.BLOCK_COLORS);
        }
        
        @SubscribeEvent
        public static void registerItemColors(final ColorHandlerEvent.Item event)
        {
            event.getItemColors().register(itemColor, AngryBirdsItems.slingshot_acacia,
                                                      AngryBirdsItems.slingshot_acacia_2,
                                                      AngryBirdsItems.slingshot_birch,
                                                      AngryBirdsItems.slingshot_birch_2,
                                                      AngryBirdsItems.slingshot_dark_oak,
                                                      AngryBirdsItems.slingshot_dark_oak_2,
                                                      AngryBirdsItems.slingshot_jungle,
                                                      AngryBirdsItems.slingshot_jungle_2,
                                                      AngryBirdsItems.slingshot_oak,
                                                      AngryBirdsItems.slingshot_oak_2,
                                                      AngryBirdsItems.slingshot_spruce,
                                                      AngryBirdsItems.slingshot_spruce_2);
        }
        
        @SubscribeEvent
        public static void registerBlockColors(final ColorHandlerEvent.Block event)
        {
            event.getBlockColors().register(blockColor, AngryBirdsBlocks.slingshot_acacia,
                                                        AngryBirdsBlocks.slingshot_acacia_2,
                                                        AngryBirdsBlocks.slingshot_birch,
                                                        AngryBirdsBlocks.slingshot_birch_2,
                                                        AngryBirdsBlocks.slingshot_dark_oak,
                                                        AngryBirdsBlocks.slingshot_dark_oak_2,
                                                        AngryBirdsBlocks.slingshot_jungle,
                                                        AngryBirdsBlocks.slingshot_jungle_2,
                                                        AngryBirdsBlocks.slingshot_oak,
                                                        AngryBirdsBlocks.slingshot_oak_2,
                                                        AngryBirdsBlocks.slingshot_spruce,
                                                        AngryBirdsBlocks.slingshot_spruce_2);
        }
    }
}
