package drachenbauer32.angrybirdsmod.init;

import drachenbauer32.angrybirdsmod.entities.BluesEntity;
import drachenbauer32.angrybirdsmod.entities.BombEntity;
import drachenbauer32.angrybirdsmod.entities.BubblesEntity;
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
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.event.RegistryEvent;

public class AngryBirdsEntities 
{
    public static EntityType<?> RED = EntityType.Builder.create(RedEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".red").setRegistryName("red");
    public static EntityType<?> CHUCK = EntityType.Builder.create(ChuckEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".chuck").setRegistryName("chuck");
    public static EntityType<?> BLUES = EntityType.Builder.create(BluesEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".blues").setRegistryName("blues");
    public static EntityType<?> BOMB = EntityType.Builder.create(BombEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".bomb").setRegistryName("bomb");
    public static EntityType<?> MATHILDA = EntityType.Builder.create(MathildaEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".mathilda").setRegistryName("mathilda");
    public static EntityType<?> TERENCE = EntityType.Builder.create(TerenceEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".terence").setRegistryName("terence");
    public static EntityType<?> SILVER = EntityType.Builder.create(SilverEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".silver").setRegistryName("silver");
    public static EntityType<?> BUBBLES = EntityType.Builder.create(BubblesEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".bubbles").setRegistryName("bubbles");
    public static EntityType<?> HAL = EntityType.Builder.create(HalEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".hal").setRegistryName("hal");
    public static EntityType<?> STELLA = EntityType.Builder.create(StellaEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".stella").setRegistryName("stella");
    public static EntityType<?> POPPY = EntityType.Builder.create(PoppyEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".poppy").setRegistryName("poppy");
    public static EntityType<?> WILLOW = EntityType.Builder.create(WillowEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".willow").setRegistryName("willow");
    public static EntityType<?> DAHLIA = EntityType.Builder.create(DahliaEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".dahlia").setRegistryName("dahlia");
    public static EntityType<?> LUCA = EntityType.Builder.create(LucaEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".luca").setRegistryName("luca");
    public static EntityType<?> ICE_BIRD = EntityType.Builder.create(IceBirdEntity::new, EntityClassification.CREATURE).build(Reference.MOD_ID + ".ice_bird").setRegistryName("ice_bird");
    
    public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item>event)
    {
        event.getRegistry().registerAll(AngryBirdsItems.red_egg = registerEntitySpawnEgg(RED, 0xdf0000, 0xdfbf9f, "red_egg"),
                                        AngryBirdsItems.chuck_egg = registerEntitySpawnEgg(CHUCK, 0xffff00, 0xffffff, "chuck_egg"),
                                        AngryBirdsItems.blues_egg = registerEntitySpawnEgg(BLUES, 0x007fff, 0xff0000, "blues_egg"),
                                        AngryBirdsItems.bomb_egg = registerEntitySpawnEgg(BOMB, 0x3f3f3f, 0x7f7f7f, "bomb_egg"),
                                        AngryBirdsItems.mathilda_egg = registerEntitySpawnEgg(MATHILDA, 0xffffff, 0xffbfbf, "mathilda_egg"),
                                        AngryBirdsItems.terence_egg = registerEntitySpawnEgg(TERENCE, 0xbf002f, 0xbf9f7f, "terence_egg"),
                                        AngryBirdsItems.silver_egg = registerEntitySpawnEgg(SILVER, 0xbfbfbf, 0xffffff, "silver_egg"),
                                        AngryBirdsItems.bubbles_egg = registerEntitySpawnEgg(BUBBLES, 0xff7f00, 0x000000, "bubbles_egg"),
                                        AngryBirdsItems.hal_egg = registerEntitySpawnEgg(HAL, 0x00bf00, 0xffffff, "hal_egg"),
                                        AngryBirdsItems.stella_egg = registerEntitySpawnEgg(STELLA, 0xffadb7, 0xffd7dc, "stella_egg"),
                                        AngryBirdsItems.poppy_egg = registerEntitySpawnEgg(POPPY, 0xffff3f, 0xffffbf, "poppy_egg"),
                                        AngryBirdsItems.willow_egg = registerEntitySpawnEgg(WILLOW, 0x3f9fff, 0x7fbfff, "willow_egg"),
                                        AngryBirdsItems.dahlia_egg = registerEntitySpawnEgg(DAHLIA, 0xbf7f3f, 0xffdfbf, "dahlia_egg"),
                                        AngryBirdsItems.luca_egg = registerEntitySpawnEgg(LUCA, 0x7fbfff, 0xffffbf, "luca_egg"),
                                        AngryBirdsItems.ice_bird_egg = registerEntitySpawnEgg(ICE_BIRD, 0x7fbfff, 0x007fff, "ice_bird_egg"));	    
    }
    
    public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name)
    {
        SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(ItemGroup.MISC));
        item.setRegistryName(name);
        return item;
    }
}
