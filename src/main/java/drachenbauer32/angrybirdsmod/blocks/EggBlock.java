package drachenbauer32.angrybirdsmod.blocks;

import drachenbauer32.angrybirdsmod.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class EggBlock extends Block
{
	protected static final VoxelShape EGG_BLOCK_AABB = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 8.0D, 11.0D);
	
	public EggBlock(String name, Properties properties) 
	{
		super(properties);
		setRegistryName(Reference.MOD_ID, name);
	}
	
	@Override
	public boolean isSolid(BlockState state)
	{
		return false;
	}
	
	public boolean isFullCube(BlockState state)
    {
        return false;
    }
	
	public VoxelShape getShape(BlockState state, IBlockReader p_196244_2_, BlockPos p_196244_3_)
	{
		return EGG_BLOCK_AABB;
	}
	
	@Override
	public VoxelShape getRenderShape(BlockState state, IBlockReader p_196247_2_, BlockPos p_196247_3_)
	{
		return EGG_BLOCK_AABB;
	}
	
	public VoxelShape getCollisionShape(BlockState state, IBlockReader p_196268_2_, BlockPos p_196268_3_)
	{
		return EGG_BLOCK_AABB;
	}
}
