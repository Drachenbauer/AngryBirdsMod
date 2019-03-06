package drachenbauer32.angrybirdsmod.init;

import java.util.ArrayList;

import drachenbauer32.angrybirdsmod.blocks.BalloonBlock;
import drachenbauer32.angrybirdsmod.blocks.EggBlock;
import drachenbauer32.angrybirdsmod.blocks.NestBlock;
import drachenbauer32.angrybirdsmod.blocks.Slingshot2Block;
import drachenbauer32.angrybirdsmod.blocks.SlingshotBlock;
import drachenbauer32.angrybirdsmod.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.ItemBlock;

@net.minecraftforge.registries.ObjectHolder(Reference.MOD_ID + ":blocks")
public class BlockInit
{
	public static ArrayList<Block> BLOCKS = new ArrayList<>();
	public static ArrayList<ItemBlock> ITEMBLOCKS = new ArrayList<>();
	
	public static Block BALLOON_BLOCK, EGG_BLOCK, NEST_BLOCK, SLINGSHOT_BLOCK, SLINGSHOT2_BLOCK;
	
	public static void initBlocks()
    {
    	BALLOON_BLOCK = new BalloonBlock("balloon_block", (Block.Properties.create(Material.CLOTH, MaterialColor.SNOW).sound(SoundType.CLOTH).
                lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity())).addToBlockAndItemBlockRegistryList();
    	EGG_BLOCK = new EggBlock("egg_block", (Block.Properties.create(Material.CLAY, MaterialColor.SNOW).sound(SoundType.STONE).
                lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity())).addToBlockAndItemBlockRegistryList();
    	NEST_BLOCK = new NestBlock("nest_block", (Block.Properties.create(Material.GRASS, MaterialColor.GOLD).sound(SoundType.PLANT).
                lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity())).addToBlockAndItemBlockRegistryList();
    	SLINGSHOT_BLOCK = new SlingshotBlock("slingshot_block", (Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity())).addToBlockAndItemBlockRegistryList();
    	SLINGSHOT2_BLOCK = new Slingshot2Block("slingshot2_block", (Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity())).addToBlockAndItemBlockRegistryList();
    }
	
	/*public static void register(RegistryEvent.Register<Block> blockRegistryEvent)
	{
        // Create Instances and add to BLOCKS List.
        BLOCKS.add(new BalloonBlock("balloon_block", (Block.Properties.create(Material.CLOTH, MaterialColor.SNOW).sound(SoundType.CLOTH).
                hardnessAndResistance(30F, 150F).lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity())));
        BLOCKS.add(new EggBlock("egg_block", (Block.Properties.create(Material.CLAY, MaterialColor.SNOW).sound(SoundType.STONE).
                hardnessAndResistance(30F, 150F).lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity())));
        BLOCKS.add(new NestBlock("nest_block", (Block.Properties.create(Material.GRASS, MaterialColor.GOLD).sound(SoundType.PLANT).
                hardnessAndResistance(30F, 150F).lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity())));
        BLOCKS.add(new SlingshotBlock("slingshot_block", (Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                hardnessAndResistance(30F, 150F).lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity())));
        BLOCKS.add(new Slingshot2Block("slingshot2_block", (Block.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).
                hardnessAndResistance(30F, 150F).lightValue(0).hardnessAndResistance(0.1f, 0.5f).variableOpacity())));
        
       
        
        // items for blocks to Items List
        ItemInit.ITEMS.add(BALLOON_BLOCK.getItemBlock());
        ItemInit.ITEMS.add(EGG_BLOCK.getItemBlock());
        ItemInit.ITEMS.add(NEST_BLOCK.getItemBlock());
        ItemInit.ITEMS.add(SLINGSHOT_BLOCK.getItemBlock());
        ItemInit.ITEMS.add(SLINGSHOT2_BLOCK.getItemBlock());
        
        // Registering all
        for(Block b : BLOCKS) 
        {
            blockRegistryEvent.getRegistry().register(b);
        }
	}*/
}