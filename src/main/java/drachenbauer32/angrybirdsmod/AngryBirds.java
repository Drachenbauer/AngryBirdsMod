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
import drachenbauer32.angrybirdsmod.entities.BubblesInflatedEntity;
import drachenbauer32.angrybirdsmod.entities.ChuckEntity;
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
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ColorHandlerEvent;
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
                                           
                                         AngryBirdsItems.balloon_block,
                                         AngryBirdsItems.egg_block,
                                         AngryBirdsItems.nest_block,
                                         AngryBirdsItems.slingshot_acacia_block,
                                         AngryBirdsItems.slingshot_acacia_2_block,
                                         AngryBirdsItems.slingshot_birch_block,
                                         AngryBirdsItems.slingshot_birch_2_block,
                                         AngryBirdsItems.slingshot_dark_oak_block,
                                         AngryBirdsItems.slingshot_dark_oak_2_block,
                                         AngryBirdsItems.slingshot_jungle_block,
                                         AngryBirdsItems.slingshot_jungle_2_block,
                                         AngryBirdsItems.slingshot_oak_block,
                                         AngryBirdsItems.slingshot_oak_2_block,
                                         AngryBirdsItems.slingshot_spruce_block,
                                         AngryBirdsItems.slingshot_spruce_2_block,
                                         AngryBirdsItems.acacia_planks_frame_block,
                                         AngryBirdsItems.birch_planks_frame_block,
                                         AngryBirdsItems.dark_oak_planks_frame_block,
                                         AngryBirdsItems.jungle_planks_frame_block,
                                         AngryBirdsItems.oak_planks_frame_block,
                                         AngryBirdsItems.spruce_planks_frame_block,
                                         AngryBirdsItems.stone_frame_block,
                                         AngryBirdsItems.blue_ice_frame_block);
        
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
        
        /*@SubscribeEvent
		public static void onRenderPlayer(RenderPlayerEvent.Pre event)
		{
			event.setCanceled(true);
		}
        
        @SubscribeEvent(priority=normal)*/
        
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
                                            
                                            AngryBirdsItems.balloon_block = new BalloonBlockItem(AngryBirdsBlocks.balloon_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.balloon_block.getRegistryName()),
                                            AngryBirdsItems.egg_block = new BlockItem(AngryBirdsBlocks.egg_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.egg_block.getRegistryName()),
                                            AngryBirdsItems.nest_block = new BlockItem(AngryBirdsBlocks.nest_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.nest_block.getRegistryName()),
                                            AngryBirdsItems.slingshot_acacia_block = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_acacia_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.slingshot_acacia_block.getRegistryName()),
                                            AngryBirdsItems.slingshot_acacia_2_block = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_acacia_2_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.slingshot_acacia_2_block.getRegistryName()),
                                            AngryBirdsItems.slingshot_birch_block = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_birch_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.slingshot_birch_block.getRegistryName()),
                                            AngryBirdsItems.slingshot_birch_2_block = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_birch_2_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.slingshot_birch_2_block.getRegistryName()),
                                            AngryBirdsItems.slingshot_dark_oak_block = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_dark_oak_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.slingshot_dark_oak_block.getRegistryName()),
                                            AngryBirdsItems.slingshot_dark_oak_2_block = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_dark_oak_2_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.slingshot_dark_oak_2_block.getRegistryName()),
                                            AngryBirdsItems.slingshot_jungle_block = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_jungle_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.slingshot_jungle_block.getRegistryName()),
                                            AngryBirdsItems.slingshot_jungle_2_block = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_jungle_2_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.slingshot_jungle_2_block.getRegistryName()),
                                            AngryBirdsItems.slingshot_oak_block = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_oak_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.slingshot_oak_block.getRegistryName()),
                                            AngryBirdsItems.slingshot_oak_2_block = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_oak_2_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.slingshot_oak_2_block.getRegistryName()),
                                            AngryBirdsItems.slingshot_spruce_block = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_spruce_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.slingshot_spruce_block.getRegistryName()),
                                            AngryBirdsItems.slingshot_spruce_2_block = new SlingshotBlockItem(AngryBirdsBlocks.slingshot_spruce_2_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.slingshot_spruce_2_block.getRegistryName()),
                                            AngryBirdsItems.acacia_planks_frame_block = new ScaffoldingItem(AngryBirdsBlocks.acacia_planks_frame_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.acacia_planks_frame_block.getRegistryName()),
                                            AngryBirdsItems.birch_planks_frame_block = new ScaffoldingItem(AngryBirdsBlocks.birch_planks_frame_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.birch_planks_frame_block.getRegistryName()),
                                            AngryBirdsItems.dark_oak_planks_frame_block = new ScaffoldingItem(AngryBirdsBlocks.dark_oak_planks_frame_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.dark_oak_planks_frame_block.getRegistryName()),
                                            AngryBirdsItems.jungle_planks_frame_block = new ScaffoldingItem(AngryBirdsBlocks.jungle_planks_frame_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.jungle_planks_frame_block.getRegistryName()),
                                            AngryBirdsItems.oak_planks_frame_block = new ScaffoldingItem(AngryBirdsBlocks.oak_planks_frame_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.oak_planks_frame_block.getRegistryName()),
                                            AngryBirdsItems.spruce_planks_frame_block = new ScaffoldingItem(AngryBirdsBlocks.spruce_planks_frame_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.spruce_planks_frame_block.getRegistryName()),
                                            AngryBirdsItems.stone_frame_block = new ScaffoldingItem(AngryBirdsBlocks.stone_frame_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.stone_frame_block.getRegistryName()),
                                            AngryBirdsItems.blue_ice_frame_block = new ScaffoldingItem(AngryBirdsBlocks.blue_ice_frame_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.blue_ice_frame_block.getRegistryName()));
        }
        
        public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item>event)
        {
            AngryBirdsEntities.RED = EntityType.Builder.create(RedEntity::new, EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".red").setRegistryName("red");
            AngryBirdsEntities.CHUCK = EntityType.Builder.create(ChuckEntity::new, EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".chuck").setRegistryName("chuck");
            AngryBirdsEntities.BLUES = EntityType.Builder.create(BluesEntity::new, EntityClassification.CREATURE).size(0.25F, 0.75F).build(Reference.MOD_ID + ".blues").setRegistryName("blues");
            AngryBirdsEntities.BOMB = EntityType.Builder.create(BombEntity::new, EntityClassification.CREATURE).size(0.75F, 0.75F).build(Reference.MOD_ID + ".bomb").setRegistryName("bomb");
            AngryBirdsEntities.MATHILDA = EntityType.Builder.create(MathildaEntity::new, EntityClassification.CREATURE).size(0.5F, 0.625F).build(Reference.MOD_ID + ".mathilda").setRegistryName("mathilda");
            AngryBirdsEntities.TERENCE = EntityType.Builder.create(TerenceEntity::new, EntityClassification.CREATURE).size(1.25F, 1.25F).build(Reference.MOD_ID + ".terence").setRegistryName("terence");
            AngryBirdsEntities.SILVER = EntityType.Builder.create(SilverEntity::new, EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".silver").setRegistryName("silver");
            AngryBirdsEntities.BUBBLES = EntityType.Builder.create(BubblesEntity::new, EntityClassification.CREATURE).size(0.25F, 0.25F).build(Reference.MOD_ID + ".bubbles").setRegistryName("bubbles");
            AngryBirdsEntities.BUBBLES_INFLATED = EntityType.Builder.create(BubblesInflatedEntity::new, EntityClassification.MISC).size(1.25F, 1.25F).build(Reference.MOD_ID + ".bubbles_inflated").setRegistryName("bubbles_inflated");
            AngryBirdsEntities.HAL = EntityType.Builder.create(HalEntity::new, EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".hal").setRegistryName("hal");
            AngryBirdsEntities.STELLA = EntityType.Builder.create(StellaEntity::new, EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".stella").setRegistryName("stella");
            AngryBirdsEntities.POPPY = EntityType.Builder.create(PoppyEntity::new, EntityClassification.CREATURE).size(0.5F, 0.625F).build(Reference.MOD_ID + ".poppy").setRegistryName("poppy");
            AngryBirdsEntities.WILLOW = EntityType.Builder.create(WillowEntity::new, EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".willow").setRegistryName("willow");
            AngryBirdsEntities.DAHLIA = EntityType.Builder.create(DahliaEntity::new, EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".dahlia").setRegistryName("dahlia");
            AngryBirdsEntities.LUCA = EntityType.Builder.create(LucaEntity::new, EntityClassification.CREATURE).size(0.25F, 0.25F).build(Reference.MOD_ID + ".luca").setRegistryName("luca");
            AngryBirdsEntities.ICE_BIRD = EntityType.Builder.create(IceBirdEntity::new, EntityClassification.CREATURE).size(0.5F, 0.5F).build(Reference.MOD_ID + ".ice_bird").setRegistryName("ice_bird");
            
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
                                            AngryBirdsItems.ice_bird_egg = registerEntitySpawnEgg(AngryBirdsEntities.ICE_BIRD, 0x7fbfff, 0x007fff, "ice_bird_egg"));       
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
                                            AngryBirdsEntities.ICE_BIRD);
        }
        
        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event)
        {
            event.getRegistry().registerAll(AngryBirdsBlocks.balloon_block = new BalloonBlock("balloon_block", Block.Properties.create(Material.WOOL, MaterialColor.SNOW).sound(SoundType.CLOTH).
                                                lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()),
                                            AngryBirdsBlocks.balloon_block_top = new BalloonBlockTop("balloon_block_top", Block.Properties.create(Material.WOOL, MaterialColor.SNOW).sound(SoundType.CLOTH).
                                                lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()),
                                            AngryBirdsBlocks.egg_block = new EggBlock("egg_block", Block.Properties.create(Material.CLAY, MaterialColor.SNOW).sound(SoundType.STONE).
                                                lightValue(0).hardnessAndResistance(0.2f, 1.0f).variableOpacity()),
                                            AngryBirdsBlocks.nest_block = new NestBlock("nest_block", Block.Properties.create(Material.PLANTS, MaterialColor.GOLD).sound(SoundType.PLANT).
                                                lightValue(0).hardnessAndResistance(0.2f, 1.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_acacia_block = new SlingshotBlock("slingshot_acacia_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_acacia_wood_base_block = new SlingshotWoodBaseBlock("slingshot_acacia_wood_base_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_acacia_2_block = new SlingshotBlock("slingshot_acacia_2_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_acacia_2_wood_base_block = new SlingshotWoodBaseBlock("slingshot_acacia_2_wood_base_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_acacia_block_side = new SlingshotBlockSide("slingshot_acacia_block_side", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_acacia_block_side_top = new SlingshotBlockSideTop("slingshot_acacia_block_side_top", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_birch_block = new SlingshotBlock("slingshot_birch_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_birch_wood_base_block = new SlingshotWoodBaseBlock("slingshot_birch_wood_base_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_birch_2_block = new SlingshotBlock("slingshot_birch_2_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_birch_2_wood_base_block = new SlingshotWoodBaseBlock("slingshot_birch_2_wood_base_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_birch_block_side = new SlingshotBlockSide("slingshot_birch_block_side", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_birch_block_side_top = new SlingshotBlockSideTop("slingshot_birch_block_side_top", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_dark_oak_block = new SlingshotBlock("slingshot_dark_oak_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_dark_oak_wood_base_block = new SlingshotWoodBaseBlock("slingshot_dark_oak_wood_base_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_dark_oak_2_block = new SlingshotBlock("slingshot_dark_oak_2_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_dark_oak_2_wood_base_block = new SlingshotWoodBaseBlock("slingshot_dark_oak_2_wood_base_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_dark_oak_block_side = new SlingshotBlockSide("slingshot_dark_oak_block_side", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_dark_oak_block_side_top = new SlingshotBlockSideTop("slingshot_dark_oak_block_side_top", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_jungle_block = new SlingshotBlock("slingshot_jungle_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_jungle_wood_base_block = new SlingshotWoodBaseBlock("slingshot_jungle_wood_base_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_jungle_2_block = new SlingshotBlock("slingshot_jungle_2_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_jungle_2_wood_base_block = new SlingshotWoodBaseBlock("slingshot_jungle_2_wood_base_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_jungle_block_side = new SlingshotBlockSide("slingshot_jungle_block_side", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_jungle_block_side_top = new SlingshotBlockSideTop("slingshot_jungle_block_side_top", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_oak_block = new SlingshotBlock("slingshot_oak_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_oak_wood_base_block = new SlingshotWoodBaseBlock("slingshot_oak_wood_base_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_oak_2_block = new SlingshotBlock("slingshot_oak_2_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_oak_2_wood_base_block = new SlingshotWoodBaseBlock("slingshot_oak_2_wood_base_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_oak_block_side = new SlingshotBlockSide("slingshot_oak_block_side", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_oak_block_side_top = new SlingshotBlockSideTop("slingshot_oak_block_side_top", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_spruce_block = new SlingshotBlock("slingshot_spruce_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_spruce_wood_base_block = new SlingshotWoodBaseBlock("slingshot_spruce_wood_base_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_spruce_2_block = new SlingshotBlock("slingshot_spruce_2_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_spruce_2_wood_base_block = new SlingshotWoodBaseBlock("slingshot_spruce_2_wood_base_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_spruce_block_side = new SlingshotBlockSide("slingshot_spruce_block_side", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.slingshot_spruce_block_side_top = new SlingshotBlockSideTop("slingshot_spruce_block_side_top", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.acacia_planks_frame_block = new FrameBlock("acacia_planks_frame_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.birch_planks_frame_block = new FrameBlock("birch_planks_frame_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.dark_oak_planks_frame_block = new FrameBlock("dark_oak_planks_frame_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.jungle_planks_frame_block = new FrameBlock("jungle_planks_frame_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.oak_planks_frame_block = new FrameBlock("oak_planks_frame_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.spruce_planks_frame_block = new FrameBlock("spruce_planks_frame_block", Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.stone_frame_block = new FrameBlock("stone_frame_block", Block.Properties.create(Material.ROCK, MaterialColor.STONE).sound(SoundType.STONE).
                                                lightValue(0).hardnessAndResistance(2.0f, 3.0f).variableOpacity()),
                                            AngryBirdsBlocks.blue_ice_frame_block = new FrameBlock("blue_ice_frame_block", Block.Properties.create(Material.ICE, MaterialColor.ICE).sound(SoundType.GLASS).
                                                lightValue(0).hardnessAndResistance(1.0f, 2.0f).variableOpacity()));
        }
        
        @SubscribeEvent
        public static void registerTE(RegistryEvent.Register<TileEntityType<?>> event)
        {
             AngryBirdsTileEntities.BLOCK_COLORS = TileEntityType.Builder.create(BlockColorsTileEntity::new, AngryBirdsBlocks.balloon_block,
                                                                                                             AngryBirdsBlocks.balloon_block_top,
                                                                                                             AngryBirdsBlocks.slingshot_acacia_block,
                                                                                                             AngryBirdsBlocks.slingshot_acacia_2_block,
                                                                                                             AngryBirdsBlocks.slingshot_birch_block,
                                                                                                             AngryBirdsBlocks.slingshot_birch_2_block,
                                                                                                             AngryBirdsBlocks.slingshot_dark_oak_block,
                                                                                                             AngryBirdsBlocks.slingshot_dark_oak_2_block,
                                                                                                             AngryBirdsBlocks.slingshot_jungle_block,
                                                                                                             AngryBirdsBlocks.slingshot_jungle_2_block,
                                                                                                             AngryBirdsBlocks.slingshot_oak_block,
                                                                                                             AngryBirdsBlocks.slingshot_oak_2_block,
                                                                                                             AngryBirdsBlocks.slingshot_spruce_block,
                                                                                                             AngryBirdsBlocks.slingshot_spruce_2_block).build(null);
             AngryBirdsTileEntities.BLOCK_COLORS.setRegistryName(Reference.MOD_ID, "block_colors");
             event.getRegistry().register(AngryBirdsTileEntities.BLOCK_COLORS);
        }
        
        @SubscribeEvent
        public static void registerItemColors(final ColorHandlerEvent.Item event)
        {
            event.getItemColors().register(itemColor, AngryBirdsItems.balloon_block,
                                                      AngryBirdsItems.slingshot_acacia_block,
                                                      AngryBirdsItems.slingshot_acacia_2_block,
                                                      AngryBirdsItems.slingshot_birch_block,
                                                      AngryBirdsItems.slingshot_birch_2_block,
                                                      AngryBirdsItems.slingshot_dark_oak_block,
                                                      AngryBirdsItems.slingshot_dark_oak_2_block,
                                                      AngryBirdsItems.slingshot_jungle_block,
                                                      AngryBirdsItems.slingshot_jungle_2_block,
                                                      AngryBirdsItems.slingshot_oak_block,
                                                      AngryBirdsItems.slingshot_oak_2_block,
                                                      AngryBirdsItems.slingshot_spruce_block,
                                                      AngryBirdsItems.slingshot_spruce_2_block);
        }
        
        @SubscribeEvent
        public static void registerBlockColors(final ColorHandlerEvent.Block event)
        {
            event.getBlockColors().register(blockColor, AngryBirdsBlocks.balloon_block,
                                                        AngryBirdsBlocks.slingshot_acacia_block,
                                                        AngryBirdsBlocks.slingshot_acacia_2_block,
                                                        AngryBirdsBlocks.slingshot_birch_block,
                                                        AngryBirdsBlocks.slingshot_birch_2_block,
                                                        AngryBirdsBlocks.slingshot_dark_oak_block,
                                                        AngryBirdsBlocks.slingshot_dark_oak_2_block,
                                                        AngryBirdsBlocks.slingshot_jungle_block,
                                                        AngryBirdsBlocks.slingshot_jungle_2_block,
                                                        AngryBirdsBlocks.slingshot_oak_block,
                                                        AngryBirdsBlocks.slingshot_oak_2_block,
                                                        AngryBirdsBlocks.slingshot_spruce_block,
                                                        AngryBirdsBlocks.slingshot_spruce_2_block);
        }
    }
}
