package drachenbauer32.angrybirdsmod.init;

import drachenbauer32.angrybirdsmod.AngryBirds;
import drachenbauer32.angrybirdsmod.items.BirdShotItem;
import drachenbauer32.angrybirdsmod.items.SlingshotItem;
import drachenbauer32.angrybirdsmod.items.SupplierSpawnEggItem;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AngryBirdsItems 
{
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Reference.MOD_ID);
    
    public static final RegistryObject<Item> RED_EGG = ITEMS.register("red_egg", () -> new SupplierSpawnEggItem(
                        AngryBirdsEntities.RED, 0xdf0000, 0xdfbf9f, new Item.Properties().group(AngryBirds.ANGRY_BIRDS)));
    public static final RegistryObject<Item> CHUCK_EGG = ITEMS.register("chuck_egg", () -> new SupplierSpawnEggItem(
                        AngryBirdsEntities.CHUCK, 0xffff00, 0xffffff, new Item.Properties().group(AngryBirds.ANGRY_BIRDS)));
    public static final RegistryObject<Item> BLUES_EGG = ITEMS.register("blues_egg", () -> new SupplierSpawnEggItem(
                        AngryBirdsEntities.BLUES, 0x007fff, 0xff0000, new Item.Properties().group(AngryBirds.ANGRY_BIRDS)));
    public static final RegistryObject<Item> BOMB_EGG = ITEMS.register("bomb_egg", () -> new SupplierSpawnEggItem(
                        AngryBirdsEntities.BOMB, 0x3f3f3f, 0x7f7f7f, new Item.Properties().group(AngryBirds.ANGRY_BIRDS)));
    public static final RegistryObject<Item> MATHILDA_EGG = ITEMS.register("mathilda_egg", () -> new SupplierSpawnEggItem(
                        AngryBirdsEntities.MATHILDA, 0xffffff, 0xffbfbf, new Item.Properties().group(AngryBirds.ANGRY_BIRDS)));
    public static final RegistryObject<Item> TERENCE_EGG = ITEMS.register("terence_egg", () -> new SupplierSpawnEggItem(
                        AngryBirdsEntities.TERENCE, 0xbf002f, 0xbf9f7f, new Item.Properties().group(AngryBirds.ANGRY_BIRDS)));
    public static final RegistryObject<Item> SILVER_EGG = ITEMS.register("silver_egg", () -> new SupplierSpawnEggItem(
                        AngryBirdsEntities.SILVER, 0xbfbfbf, 0xffffff, new Item.Properties().group(AngryBirds.ANGRY_BIRDS)));
    public static final RegistryObject<Item> BUBBLES_EGG = ITEMS.register("bubbles_egg", () -> new SupplierSpawnEggItem(
                        AngryBirdsEntities.BUBBLES, 0xff7f00, 0x3f3f3f, new Item.Properties().group(AngryBirds.ANGRY_BIRDS)));
    public static final RegistryObject<Item> HAL_EGG = ITEMS.register("hal_egg", () -> new SupplierSpawnEggItem(
                        AngryBirdsEntities.HAL, 0x00bf00, 0xffffff, new Item.Properties().group(AngryBirds.ANGRY_BIRDS)));
    public static final RegistryObject<Item> STELLA_EGG = ITEMS.register("stella_egg", () -> new SupplierSpawnEggItem(
                        AngryBirdsEntities.STELLA, 0xffadb7, 0xffd7dc, new Item.Properties().group(AngryBirds.ANGRY_BIRDS)));
    public static final RegistryObject<Item> POPPY_EGG = ITEMS.register("poppy_egg", () -> new SupplierSpawnEggItem(
                        AngryBirdsEntities.POPPY, 0xffff3f, 0xffffbf, new Item.Properties().group(AngryBirds.ANGRY_BIRDS)));
    public static final RegistryObject<Item> WILLOW_EGG = ITEMS.register("willow_egg", () -> new SupplierSpawnEggItem(
                        AngryBirdsEntities.WILLOW, 0x3f9fff, 0x7fbfff, new Item.Properties().group(AngryBirds.ANGRY_BIRDS)));
    public static final RegistryObject<Item> DAHLIA_EGG = ITEMS.register("dahlia_egg", () -> new SupplierSpawnEggItem(
                        AngryBirdsEntities.DAHLIA, 0xbf7f3f, 0xffdfbf, new Item.Properties().group(AngryBirds.ANGRY_BIRDS)));
    public static final RegistryObject<Item> LUCA_EGG = ITEMS.register("luca_egg", () -> new SupplierSpawnEggItem(
                        AngryBirdsEntities.LUCA, 0x7fbfff, 0xffffbf, new Item.Properties().group(AngryBirds.ANGRY_BIRDS)));
    public static final RegistryObject<Item> ICE_BIRD_EGG = ITEMS.register("ice_bird_egg", () -> new SupplierSpawnEggItem(
                        AngryBirdsEntities.ICE_BIRD, 0x7fbfff, 0x007fff, new Item.Properties().group(AngryBirds.ANGRY_BIRDS)));
    public static final RegistryObject<Item> CORAL_EGG = ITEMS.register("coral_egg", () -> new SupplierSpawnEggItem(
                        AngryBirdsEntities.CORAL, 0xff7fff, 0xffbfff, new Item.Properties().group(AngryBirds.ANGRY_BIRDS)));
    
    public static final RegistryObject<Item> RED_SHOT = ITEMS.register("red_shot", () -> new BirdShotItem(new Item.Properties().
                        defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> CHUCK_SHOT = ITEMS.register("chuck_shot", () -> new BirdShotItem(new Item.Properties().
                        defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> BLUES_SHOT = ITEMS.register("blues_shot", () -> new BirdShotItem(new Item.Properties().
                        defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> BOMB_SHOT = ITEMS.register("bomb_shot", () -> new BirdShotItem(new Item.Properties().
                        defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> MATHILDA_SHOT = ITEMS.register("mathilda_shot", () -> new BirdShotItem(new Item.Properties().
                        defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> TERENCE_SHOT = ITEMS.register("terence_shot", () -> new BirdShotItem(new Item.Properties().
                        defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> SILVER_SHOT = ITEMS.register("silver_shot", () -> new BirdShotItem(new Item.Properties().
                        defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> BUBBLES_SHOT = ITEMS.register("bubbles_shot", () -> new BirdShotItem(new Item.Properties().
                        defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> HAL_SHOT = ITEMS.register("hal_shot", () -> new BirdShotItem(new Item.Properties().
                        defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> STELLA_SHOT = ITEMS.register("stella_shot", () -> new BirdShotItem(new Item.Properties().
                        defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> POPPY_SHOT = ITEMS.register("poppy_shot", () -> new BirdShotItem(new Item.Properties().
                        defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> WILLOW_SHOT = ITEMS.register("willow_shot", () -> new BirdShotItem(new Item.Properties().
                        defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> DAHLIA_SHOT = ITEMS.register("dahlia_shot", () -> new BirdShotItem(new Item.Properties().
                        defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> LUCA_SHOT = ITEMS.register("luca_shot", () -> new BirdShotItem(new Item.Properties().
                        defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> ICE_BIRD_SHOT = ITEMS.register("ice_bird_shot", () -> new BirdShotItem(new Item.Properties().
                        defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> SLINGSHOT = ITEMS.register("slingshot", () -> new SlingshotItem(new Item.Properties().
                        defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(1).rarity(Rarity.COMMON).setNoRepair()));
    
    public static final RegistryObject<Item> EGG_BLOCK = ITEMS.register("egg_block", () -> new BlockItem(AngryBirdsBlocks.EGG_BLOCK.get(),
                        new Item.Properties().defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> NEST = ITEMS.register("nest", () -> new BlockItem(AngryBirdsBlocks.NEST.get(),
                        new Item.Properties().defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    
    public static final RegistryObject<Item> SLINGSHOT_ACACIA = ITEMS.register("slingshot_acacia", () -> new BlockItem(AngryBirdsBlocks.SLINGSHOT_ACACIA.get(),
                        new Item.Properties().defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> SLINGSHOT_ACACIA_2 = ITEMS.register("slingshot_acacia_2", () -> new BlockItem(AngryBirdsBlocks.SLINGSHOT_ACACIA_2.get(),
                        new Item.Properties().defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> SLINGSHOT_BIRCH = ITEMS.register("slingshot_birch", () -> new BlockItem(AngryBirdsBlocks.SLINGSHOT_BIRCH.get(),
                        new Item.Properties().defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> SLINGSHOT_BIRCH_2 = ITEMS.register("slingshot_birch_2", () -> new BlockItem(AngryBirdsBlocks.SLINGSHOT_BIRCH_2.get(),
                        new Item.Properties().defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> SLINGSHOT_DARK_OAK = ITEMS.register("slingshot_dark_oak", () -> new BlockItem(AngryBirdsBlocks.SLINGSHOT_DARK_OAK.get(),
                        new Item.Properties().defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> SLINGSHOT_DARK_OAK_2 = ITEMS.register("slingshot_dark_oak_2", () -> new BlockItem(AngryBirdsBlocks.SLINGSHOT_DARK_OAK_2.get(),
                        new Item.Properties().defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> SLINGSHOT_JUNGLE = ITEMS.register("slingshot_jungle", () -> new BlockItem(AngryBirdsBlocks.SLINGSHOT_JUNGLE.get(),
                        new Item.Properties().defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> SLINGSHOT_JUNGLE_2 = ITEMS.register("slingshot_jungle_2", () -> new BlockItem(AngryBirdsBlocks.SLINGSHOT_JUNGLE_2.get(),
                        new Item.Properties().defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> SLINGSHOT_OAK = ITEMS.register("slingshot_oak", () -> new BlockItem(AngryBirdsBlocks.SLINGSHOT_OAK.get(),
                        new Item.Properties().defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> SLINGSHOT_OAK_2 = ITEMS.register("slingshot_oak_2", () -> new BlockItem(AngryBirdsBlocks.SLINGSHOT_OAK_2.get(),
                        new Item.Properties().defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> SLINGSHOT_SPRUCE = ITEMS.register("slingshot_spruce", () -> new BlockItem(AngryBirdsBlocks.SLINGSHOT_SPRUCE.get(),
                        new Item.Properties().defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> SLINGSHOT_SPRUCE_2 = ITEMS.register("slingshot_spruce_2", () -> new BlockItem(AngryBirdsBlocks.SLINGSHOT_SPRUCE_2.get(),
                        new Item.Properties().defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    
    public static final RegistryObject<Item> ACACIA_PLANKS_FRAME = ITEMS.register("acacia_planks_frame", () -> new BlockItem(AngryBirdsBlocks.ACACIA_PLANKS_FRAME.get(),
                        new Item.Properties().defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> BIRCH_PLANKS_FRAME = ITEMS.register("birch_planks_frame", () -> new BlockItem(AngryBirdsBlocks.BIRCH_PLANKS_FRAME.get(),
                        new Item.Properties().defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> DARK_OAK_PLANKS_FRAME = ITEMS.register("dark_oak_planks_frame", () -> new BlockItem(AngryBirdsBlocks.DARK_OAK_PLANKS_FRAME.get(),
                        new Item.Properties().defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> JUNGlE_PLANKS_FRAME = ITEMS.register("jungle_planks_frame", () -> new BlockItem(AngryBirdsBlocks.JUNGLE_PLANKS_FRAME.get(),
                        new Item.Properties().defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> OAK_PLANKS_FRAME = ITEMS.register("oak_planks_frame", () -> new BlockItem(AngryBirdsBlocks.OAK_PLANKS_FRAME.get(),
                        new Item.Properties().defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> SPRUCE_PLANKS_FRAME = ITEMS.register("spruce_planks_frame", () -> new BlockItem(AngryBirdsBlocks.SPRUCE_PLANKS_FRAME.get(),
                        new Item.Properties().defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> STONE_FRAME = ITEMS.register("stone_frame", () -> new BlockItem(AngryBirdsBlocks.STONE_FRAME.get(),
                        new Item.Properties().defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
    public static final RegistryObject<Item> BLUE_ICE_FRAME = ITEMS.register("blue_ice_frame", () -> new BlockItem(AngryBirdsBlocks.BLUE_ICE_FRAME.get(),
                        new Item.Properties().defaultMaxDamage(0).group(AngryBirds.ANGRY_BIRDS).maxStackSize(64).rarity(Rarity.COMMON).setNoRepair()));
        
    public static final Tag<Item> BIRD_SHOTS = makeWrapperTag("bird_shots");
    
    private static Tag<Item> makeWrapperTag(String name)
    {
        return new ItemTags.Wrapper(new ResourceLocation(name));
    }
}
