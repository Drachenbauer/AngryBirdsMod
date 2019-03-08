package drachenbauer32.angrybirdsmod.blocks;

import drachenbauer32.angrybirdsmod.init.BlockInit;
import drachenbauer32.angrybirdsmod.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class EggBlock extends Block
{
	protected static final VoxelShape EGG_BLOCK_AABB = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 8.0D, 11.0D);
	
	public EggBlock(String name, Properties class1) 
	{
		super(class1);
		setRegistryName(Reference.MOD_ID, name);
	}
	
	public Block addToBlockAndItemBlockRegistryList()
	{
		BlockInit.BLOCKS.add(this);
		BlockInit.ITEMBLOCKS.add(new ItemBlock(this, new Item.Properties().defaultMaxDamage(0).group(ItemGroup.DECORATIONS).maxStackSize(64).rarity(EnumRarity.COMMON).setNoRepair()));
		return this;
	}
	
	@Override
	public boolean isSolid(IBlockState state)
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	
	@Override
	public VoxelShape getShape(IBlockState state, IBlockReader p_196244_2_, BlockPos p_196244_3_)
	{
		return EGG_BLOCK_AABB;
	}
	
	@Override
	public VoxelShape getRenderShape(IBlockState state, IBlockReader p_196247_2_, BlockPos p_196247_3_)
	{
		return EGG_BLOCK_AABB;
	}
	
	@Override
	public VoxelShape getCollisionShape(IBlockState state, IBlockReader p_196268_2_, BlockPos p_196268_3_)
	{
		return EGG_BLOCK_AABB;
	}
}
