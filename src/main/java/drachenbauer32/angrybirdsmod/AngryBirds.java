package drachenbauer32.angrybirdsmod;

//import java.util.Arrays;
import java.util.Comparator;
//import java.util.List;

//import com.google.common.collect.Ordering;

import drachenbauer32.angrybirdsmod.blocks.BalloonBlock;
import drachenbauer32.angrybirdsmod.blocks.EggBlock;
import drachenbauer32.angrybirdsmod.blocks.NestBlock;
import drachenbauer32.angrybirdsmod.blocks.Slingshot2Block;
import drachenbauer32.angrybirdsmod.blocks.SlingshotBlock;
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
import drachenbauer32.angrybirdsmod.entities.SilverEntity;
import drachenbauer32.angrybirdsmod.entities.StellaEntity;
import drachenbauer32.angrybirdsmod.entities.TerenceEntity;
import drachenbauer32.angrybirdsmod.entities.WillowEntity;
import drachenbauer32.angrybirdsmod.init.AngryBirdsBlocks;
import drachenbauer32.angrybirdsmod.init.AngryBirdsEntities;
import drachenbauer32.angrybirdsmod.init.AngryBirdsItems;
import drachenbauer32.angrybirdsmod.items.BirdShotItem;
import drachenbauer32.angrybirdsmod.items.SlingshotItem;
import drachenbauer32.angrybirdsmod.util.AngryBirdsItemGroup;
import drachenbauer32.angrybirdsmod.util.Reference;
import drachenbauer32.angrybirdsmod.util.handlers.RenderHandler;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Rarity;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
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
    public static Comparator<? super ItemStack> tabSorter;
    
    public static final ItemGroup ANGRY_BIRDS = new AngryBirdsItemGroup();
    
    public AngryBirds() 
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    void preInit()
    {
        /*List<Item> order = Arrays.asList(AngryBirdsItems.red_egg,
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
                                         
                                         AngryBirdsItems.slingshot,
                                         AngryBirdsItems.red_shot,
                                         AngryBirdsItems.chuck_shot,
                                         
                                         AngryBirdsItems.balloon_block,
                                         AngryBirdsItems.egg_block,
                                         AngryBirdsItems.nest_block,
                                         AngryBirdsItems.slingshot_block,
                                         AngryBirdsItems.slingshot2_block);*/
        
       //tabSorter = Ordering.explicit(order).onResultOf(ItemStack::g﻿etIt﻿em);
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
            event.getRegistry().registerAll(AngryBirdsItems.balloon_block = new BlockItem(AngryBirdsBlocks.balloon_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                 maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.balloon_block.getRegistryName()),
                                            AngryBirdsItems.egg_block = new BlockItem(AngryBirdsBlocks.egg_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                 maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.egg_block.getRegistryName()),
                                            AngryBirdsItems.nest_block = new BlockItem(AngryBirdsBlocks.nest_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                 maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.nest_block.getRegistryName()),
                                            AngryBirdsItems.slingshot_block = new BlockItem(AngryBirdsBlocks.slingshot_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                 maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.slingshot_block.getRegistryName()),
                                            AngryBirdsItems.slingshot2_block = new BlockItem(AngryBirdsBlocks.slingshot2_block, new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                 maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName(AngryBirdsBlocks.slingshot2_block.getRegistryName()),
                                            
                                            AngryBirdsItems.slingshot = new SlingshotItem(new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                 maxStackSize(1).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("slingshot"),
                                            AngryBirdsItems.red_shot = new BirdShotItem(new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                 maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("red_shot"),
                                            AngryBirdsItems.chuck_shot = new BirdShotItem(new Item.Properties().defaultMaxDamage(0).group(ANGRY_BIRDS).
                                                 maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()).setRegistryName("chuck_shot"));
            
            registerEntitySpawnEggs(event);
        }
        
        public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item>event)
        {
            AngryBirdsEntities.RED = EntityType.Builder.create(RedEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".red").setRegistryName("red");
            AngryBirdsEntities.CHUCK = EntityType.Builder.create(ChuckEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".chuck").setRegistryName("chuck");
            AngryBirdsEntities.BLUES = EntityType.Builder.create(BluesEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".blues").setRegistryName("blues");
            AngryBirdsEntities.BOMB = EntityType.Builder.create(BombEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".bomb").setRegistryName("bomb");
            AngryBirdsEntities.MATHILDA = EntityType.Builder.create(MathildaEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".mathilda").setRegistryName("mathilda");
            AngryBirdsEntities.TERENCE = EntityType.Builder.create(TerenceEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".terence").setRegistryName("terence");
            AngryBirdsEntities.SILVER = EntityType.Builder.create(SilverEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".silver").setRegistryName("silver");
            AngryBirdsEntities.BUBBLES = EntityType.Builder.create(BubblesEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".bubbles").setRegistryName("bubbles");
            AngryBirdsEntities.BUBBLES_INFLATED = EntityType.Builder.create(BubblesInflatedEntity::new, EntityClassification.MISC).build(Reference.MOD_ID + ".bubbles_inflated").setRegistryName("bubbles_inflated");
            AngryBirdsEntities.HAL = EntityType.Builder.create(HalEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".hal").setRegistryName("hal");
            AngryBirdsEntities.STELLA = EntityType.Builder.create(StellaEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".stella").setRegistryName("stella");
            AngryBirdsEntities.POPPY = EntityType.Builder.create(PoppyEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".poppy").setRegistryName("poppy");
            AngryBirdsEntities.WILLOW = EntityType.Builder.create(WillowEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".willow").setRegistryName("willow");
            AngryBirdsEntities.DAHLIA = EntityType.Builder.create(DahliaEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".dahlia").setRegistryName("dahlia");
            AngryBirdsEntities.LUCA = EntityType.Builder.create(LucaEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".luca").setRegistryName("luca");
            AngryBirdsEntities.ICE_BIRD = EntityType.Builder.create(IceBirdEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".ice_bird").setRegistryName("ice_bird");
            
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
        
        public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name)
        {
            SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(AngryBirds.ANGRY_BIRDS));
            item.setRegistryName(name);
            return item;
        }
    }
}
