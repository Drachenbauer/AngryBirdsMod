package drachenbauer32.angrybirdsmod.init;

import drachenbauer32.angrybirdsmod.blocks.BalloonBlock;
import drachenbauer32.angrybirdsmod.blocks.BalloonBlockTop;
import drachenbauer32.angrybirdsmod.blocks.EggBlock;
import drachenbauer32.angrybirdsmod.blocks.FrameBlock;
import drachenbauer32.angrybirdsmod.blocks.NestBlock;
import drachenbauer32.angrybirdsmod.blocks.SlingshotBlock;
import drachenbauer32.angrybirdsmod.blocks.SlingshotBlockSide;
import drachenbauer32.angrybirdsmod.blocks.SlingshotBlockSideTop;
import drachenbauer32.angrybirdsmod.blocks.SlingshotWoodBaseBlock;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AngryBirdsBlocks
{	
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Reference.MOD_ID);
    
    public static final RegistryObject<Block> EGG_BLOCK = BLOCKS.register("egg_block", () -> new EggBlock(
                        Block.Properties.create(Material.CLAY,MaterialColor.SNOW).notSolid().sound(SoundType.STONE).
                        lightValue(0).hardnessAndResistance(0.2f, 1.0f).variableOpacity()));
    public static final RegistryObject<Block> NEST = BLOCKS.register("nest", () ->
                        new NestBlock(Block.Properties.from(Blocks.HAY_BLOCK)));
    
    public static final RegistryObject<Block> SLINGSHOT_ACACIA = BLOCKS.register("slingshot_acacia", () ->
                        new SlingshotBlock(Block.Properties.from(Blocks.STRIPPED_ACACIA_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_ACACIA_WOOD_BASE = BLOCKS.register("slingshot_acacia_wood_base", () ->
                        new SlingshotWoodBaseBlock(Block.Properties.from(Blocks.STRIPPED_ACACIA_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_ACACIA_2 = BLOCKS.register("slingshot_acacia_2", () ->
                        new SlingshotBlock(Block.Properties.from(Blocks.STRIPPED_ACACIA_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_ACACIA_2_WOOD_BASE = BLOCKS.register("slingshot_acacia_2_wood_base", () ->
                        new SlingshotWoodBaseBlock(Block.Properties.from(Blocks.STRIPPED_ACACIA_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_ACACIA_SIDE = BLOCKS.register("slingshot_acacia_side", () ->
                        new SlingshotBlockSide(Block.Properties.from(Blocks.STRIPPED_ACACIA_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_ACACIA_SIDE_TOP = BLOCKS.register("slingshot_acacia_side_top", () ->
                        new SlingshotBlockSideTop(Block.Properties.from(Blocks.STRIPPED_ACACIA_WOOD)));
    
    public static final RegistryObject<Block> SLINGSHOT_BIRCH = BLOCKS.register("slingshot_birch", () ->
                        new SlingshotBlock(Block.Properties.from(Blocks.STRIPPED_BIRCH_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_BIRCH_WOOD_BASE = BLOCKS.register("slingshot_birch_wood_base", () ->
                        new SlingshotWoodBaseBlock(Block.Properties.from(Blocks.STRIPPED_BIRCH_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_BIRCH_2 = BLOCKS.register("slingshot_birch_2", () ->
                        new SlingshotBlock(Block.Properties.from(Blocks.STRIPPED_BIRCH_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_BIRCH_2_WOOD_BASE = BLOCKS.register("slingshot_birch_2_wood_base", () ->
                        new SlingshotWoodBaseBlock(Block.Properties.from(Blocks.STRIPPED_BIRCH_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_BIRCH_SIDE = BLOCKS.register("slingshot_birch_side", () ->
                        new SlingshotBlockSide(Block.Properties.from(Blocks.STRIPPED_BIRCH_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_BIRCH_SIDE_TOP = BLOCKS.register("slingshot_birch_side_top", () ->
                        new SlingshotBlockSideTop(Block.Properties.from(Blocks.STRIPPED_BIRCH_WOOD)));
    
    public static final RegistryObject<Block> SLINGSHOT_DARK_OAK = BLOCKS.register("slingshot_dark_oak", () ->
                        new SlingshotBlock(Block.Properties.from(Blocks.STRIPPED_DARK_OAK_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_DARK_OAK_WOOD_BASE = BLOCKS.register("slingshot_dark_oak_wood_base", () ->
                        new SlingshotWoodBaseBlock(Block.Properties.from(Blocks.STRIPPED_DARK_OAK_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_DARK_OAK_2 = BLOCKS.register("slingshot_dark_oak_2", () ->
                        new SlingshotBlock(Block.Properties.from(Blocks.STRIPPED_DARK_OAK_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_DARK_OAK_2_WOOD_BASE = BLOCKS.register("slingshot_dark_oak_2_wood_base", () ->
                        new SlingshotWoodBaseBlock(Block.Properties.from(Blocks.STRIPPED_DARK_OAK_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_DARK_OAK_SIDE = BLOCKS.register("slingshot_dark_oak_side", () ->
                        new SlingshotBlockSide(Block.Properties.from(Blocks.STRIPPED_DARK_OAK_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_DARK_OAK_SIDE_TOP = BLOCKS.register("slingshot_dark_oak_side_top", () ->
                        new SlingshotBlockSideTop(Block.Properties.from(Blocks.STRIPPED_DARK_OAK_WOOD)));
    
    public static final RegistryObject<Block> SLINGSHOT_JUNGLE = BLOCKS.register("slingshot_jungle", () ->
                        new SlingshotBlock(Block.Properties.from(Blocks.STRIPPED_JUNGLE_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_JUNGLE_WOOD_BASE = BLOCKS.register("slingshot_jungle_wood_base", () ->
                        new SlingshotWoodBaseBlock(Block.Properties.from(Blocks.STRIPPED_JUNGLE_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_JUNGLE_2 = BLOCKS.register("slingshot_jungle_2", () ->
                        new SlingshotBlock(Block.Properties.from(Blocks.STRIPPED_JUNGLE_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_JUNGLE_2_WOOD_BASE = BLOCKS.register("slingshot_jungle_2_wood_base", () ->
                        new SlingshotWoodBaseBlock(Block.Properties.from(Blocks.STRIPPED_JUNGLE_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_JUNGLE_SIDE = BLOCKS.register("slingshot_jungle_side", () ->
                        new SlingshotBlockSide(Block.Properties.from(Blocks.STRIPPED_JUNGLE_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_JUNGLE_SIDE_TOP = BLOCKS.register("slingshot_jungle_side_top", () ->
                        new SlingshotBlockSideTop(Block.Properties.from(Blocks.STRIPPED_JUNGLE_WOOD)));
    
    public static final RegistryObject<Block> SLINGSHOT_OAK = BLOCKS.register("slingshot_oak", () ->
                        new SlingshotBlock(Block.Properties.from(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_OAK_WOOD_BASE = BLOCKS.register("slingshot_oak_wood_base", () ->
                        new SlingshotWoodBaseBlock(Block.Properties.from(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_OAK_2 = BLOCKS.register("slingshot_oak_2", () ->
                        new SlingshotBlock(Block.Properties.from(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_OAK_2_WOOD_BASE = BLOCKS.register("slingshot_oak_2_wood_base", () ->
                        new SlingshotWoodBaseBlock(Block.Properties.from(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_OAK_SIDE = BLOCKS.register("slingshot_oak_side", () ->
                        new SlingshotBlockSide(Block.Properties.from(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_OAK_SIDE_TOP = BLOCKS.register("slingshot_oak_side_top", () ->
                        new SlingshotBlockSideTop(Block.Properties.from(Blocks.STRIPPED_OAK_WOOD)));
    
    public static final RegistryObject<Block> SLINGSHOT_SPRUCE = BLOCKS.register("slingshot_spruce", () ->
                        new SlingshotBlock(Block.Properties.from(Blocks.STRIPPED_SPRUCE_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_SPRUCE_WOOD_BASE = BLOCKS.register("slingshot_spruce_wood_base", () ->
                        new SlingshotWoodBaseBlock(Block.Properties.from(Blocks.STRIPPED_SPRUCE_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_SPRUCE_2 = BLOCKS.register("slingshot_spruce_2", () ->
                        new SlingshotBlock(Block.Properties.from(Blocks.STRIPPED_SPRUCE_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_SPRUCE_2_WOOD_BASE = BLOCKS.register("slingshot_spruce_2_wood_base", () ->
                        new SlingshotWoodBaseBlock(Block.Properties.from(Blocks.STRIPPED_SPRUCE_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_SPRUCE_SIDE = BLOCKS.register("slingshot_spruce_side", () ->
                        new SlingshotBlockSide(Block.Properties.from(Blocks.STRIPPED_SPRUCE_WOOD)));
    public static final RegistryObject<Block> SLINGSHOT_SPRUCE_SIDE_TOP = BLOCKS.register("slingshot_spruce_side_top", () ->
                        new SlingshotBlockSideTop(Block.Properties.from(Blocks.STRIPPED_SPRUCE_WOOD)));
    
    public static final RegistryObject<Block> ACACIA_PLANKS_FRAME = BLOCKS.register("acacia_planks_frame", () ->
                        new FrameBlock(Block.Properties.from(Blocks.ACACIA_PLANKS)));
    public static final RegistryObject<Block> BIRCH_PLANKS_FRAME = BLOCKS.register("birch_planks_frame", () ->
                        new FrameBlock(Block.Properties.from(Blocks.BIRCH_PLANKS)));
    public static final RegistryObject<Block> DARK_OAK_PLANKS_FRAME = BLOCKS.register("dark_oak_planks_frame", () ->
                        new FrameBlock(Block.Properties.from(Blocks.DARK_OAK_PLANKS)));
    public static final RegistryObject<Block> JUNGLE_PLANKS_FRAME = BLOCKS.register("jungle_planks_frame", () ->
                        new FrameBlock(Block.Properties.from(Blocks.JUNGLE_PLANKS)));
    public static final RegistryObject<Block> OAK_PLANKS_FRAME = BLOCKS.register("oak_planks_frame", () ->
                        new FrameBlock(Block.Properties.from(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> SPRUCE_PLANKS_FRAME = BLOCKS.register("spruce_planks_frame", () ->
                        new FrameBlock(Block.Properties.from(Blocks.SPRUCE_PLANKS)));
    public static final RegistryObject<Block> STONE_FRAME = BLOCKS.register("stone_frame", () ->
                        new FrameBlock(Block.Properties.from(Blocks.STONE)));
    public static final RegistryObject<Block> BLUE_ICE_FRAME = BLOCKS.register("blue_ice_frame", () ->
                        new FrameBlock(Block.Properties.from(Blocks.BLUE_ICE)));
    
    public static final RegistryObject<Block> BLACK_BALLOON_TOP = BLOCKS.register("black_balloon_top", () -> new BalloonBlockTop(
                        AngryBirdsItems.BLACK_BALLOON,Block.Properties.create(Material.WOOL,MaterialColor.BLACK).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> BLUE_BALLOON_TOP = BLOCKS.register("blue_balloon_top", () -> new BalloonBlockTop(
                        AngryBirdsItems.BLUE_BALLOON,Block.Properties.create(Material.WOOL,MaterialColor.BLUE).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> BROWN_BALLOON_TOP = BLOCKS.register("brown_balloon_top", () -> new BalloonBlockTop(
                        AngryBirdsItems.BROWN_BALLOON,Block.Properties.create(Material.WOOL,MaterialColor.BROWN).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> CYAN_BALLOON_TOP = BLOCKS.register("cyan_balloon_top", () -> new BalloonBlockTop(
                        AngryBirdsItems.CYAN_BALLOON,Block.Properties.create(Material.WOOL,MaterialColor.CYAN).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> GRAY_BALLOON_TOP = BLOCKS.register("gray_balloon_top", () -> new BalloonBlockTop(
                        AngryBirdsItems.GRAY_BALLOON,Block.Properties.create(Material.WOOL,MaterialColor.GRAY).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> GREEN_BALLOON_TOP = BLOCKS.register("green_balloon_top", () -> new BalloonBlockTop(
                        AngryBirdsItems.GREEN_BALLOON,Block.Properties.create(Material.WOOL,MaterialColor.GREEN).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> LIGHT_BLUE_BALLOON_TOP = BLOCKS.register("light_blue_balloon_top", () -> new BalloonBlockTop(
                        AngryBirdsItems.LIGHT_BLUE_BALLOON,Block.Properties.create(Material.WOOL,MaterialColor.LIGHT_BLUE).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> LIGHT_GRAY_BALLOON_TOP = BLOCKS.register("light_gray_balloon_top", () -> new BalloonBlockTop(
                        AngryBirdsItems.LIGHT_GRAY_BALLOON,Block.Properties.create(Material.WOOL,MaterialColor.LIGHT_GRAY).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> LIME_BALLOON_TOP = BLOCKS.register("lime_balloon_top", () -> new BalloonBlockTop(
                        AngryBirdsItems.LIME_BALLOON,Block.Properties.create(Material.WOOL,MaterialColor.LIME).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> MAGENTA_BALLOON_TOP = BLOCKS.register("magenta_balloon_top", () -> new BalloonBlockTop(
                        AngryBirdsItems.MAGENTA_BALLOON,Block.Properties.create(Material.WOOL,MaterialColor.MAGENTA).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> ORANGE_BALLOON_TOP = BLOCKS.register("orange_balloon_top", () -> new BalloonBlockTop(
                        AngryBirdsItems.ORANGE_BALLOON,Block.Properties.create(Material.WOOL,MaterialColor.ADOBE).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> PINK_BALLOON_TOP = BLOCKS.register("pink_balloon_top", () -> new BalloonBlockTop(
                        AngryBirdsItems.PINK_BALLOON,Block.Properties.create(Material.WOOL,MaterialColor.PINK).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> PURPLE_BALLOON_TOP = BLOCKS.register("purple_balloon_top", () -> new BalloonBlockTop(
                        AngryBirdsItems.PURPLE_BALLOON,Block.Properties.create(Material.WOOL,MaterialColor.PURPLE).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> RED_BALLOON_TOP = BLOCKS.register("red_balloon_top", () -> new BalloonBlockTop(
                        AngryBirdsItems.RED_BALLOON,Block.Properties.create(Material.WOOL,MaterialColor.RED).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> WHITE_BALLOON_TOP = BLOCKS.register("white_balloon_top", () -> new BalloonBlockTop(
                        AngryBirdsItems.WHITE_BALLOON,Block.Properties.create(Material.WOOL,MaterialColor.SNOW).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> YELLOW_BALLOON_TOP = BLOCKS.register("yellow_balloon_top", () -> new BalloonBlockTop(
                        AngryBirdsItems.YELLOW_BALLOON,Block.Properties.create(Material.WOOL,MaterialColor.YELLOW).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));

    public static final RegistryObject<Block> BLACK_BALLOON = BLOCKS.register("black_balloon", () -> new BalloonBlock(
                        BLACK_BALLOON_TOP,Block.Properties.create(Material.WOOL).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> BLUE_BALLOON = BLOCKS.register("blue_balloon", () -> new BalloonBlock(
                        BLUE_BALLOON_TOP,Block.Properties.create(Material.WOOL).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> BROWN_BALLOON = BLOCKS.register("brown_balloon", () -> new BalloonBlock(
                        BROWN_BALLOON_TOP,Block.Properties.create(Material.WOOL).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> CYAN_BALLOON = BLOCKS.register("cyan_balloon", () -> new BalloonBlock(
                        CYAN_BALLOON_TOP,Block.Properties.create(Material.WOOL).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> GRAY_BALLOON = BLOCKS.register("gray_balloon", () -> new BalloonBlock(
                        GRAY_BALLOON_TOP,Block.Properties.create(Material.WOOL).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> GREEN_BALLOON = BLOCKS.register("green_balloon", () -> new BalloonBlock(
                        GREEN_BALLOON_TOP,Block.Properties.create(Material.WOOL).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> LIGHT_BLUE_BALLOON = BLOCKS.register("light_blue_balloon", () -> new BalloonBlock(
                        LIGHT_BLUE_BALLOON_TOP,Block.Properties.create(Material.WOOL).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> LIGHT_GRAY_BALLOON = BLOCKS.register("light_gray_balloon", () -> new BalloonBlock(
                        LIGHT_GRAY_BALLOON_TOP,Block.Properties.create(Material.WOOL).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> LIME_BALLOON = BLOCKS.register("lime_balloon", () -> new BalloonBlock(
                        LIME_BALLOON_TOP,Block.Properties.create(Material.WOOL).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> MAGENTA_BALLOON = BLOCKS.register("magenta_balloon", () -> new BalloonBlock(
                        MAGENTA_BALLOON_TOP,Block.Properties.create(Material.WOOL).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> ORANGE_BALLOON = BLOCKS.register("orange_balloon", () -> new BalloonBlock(
                        ORANGE_BALLOON_TOP,Block.Properties.create(Material.WOOL).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> PINK_BALLOON = BLOCKS.register("pink_balloon", () -> new BalloonBlock(
                        PINK_BALLOON_TOP,Block.Properties.create(Material.WOOL).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> PURPLE_BALLOON = BLOCKS.register("purple_balloon", () -> new BalloonBlock(
                        PURPLE_BALLOON_TOP,Block.Properties.create(Material.WOOL).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> RED_BALLOON = BLOCKS.register("red_balloon", () -> new BalloonBlock(
                        RED_BALLOON_TOP,Block.Properties.create(Material.WOOL).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> WHITE_BALLOON = BLOCKS.register("white_balloon", () -> new BalloonBlock(
                        WHITE_BALLOON_TOP,Block.Properties.create(Material.WOOL).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
    public static final RegistryObject<Block> YELLOW_BALLOON = BLOCKS.register("yellow_balloon", () -> new BalloonBlock(
                        YELLOW_BALLOON_TOP,Block.Properties.create(Material.WOOL).notSolid().sound(SoundType.CLOTH).
                        lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity()));
}