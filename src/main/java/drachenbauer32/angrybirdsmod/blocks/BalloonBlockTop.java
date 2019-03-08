package drachenbauer32.angrybirdsmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class BalloonBlockTop extends Block
{
	protected static final VoxelShape BALLOON_BLOCK_AABB = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
	public BalloonBlockTop(Properties properties) 
	{
		super(properties);
	}
	
	@Override
	public VoxelShape getShape(IBlockState state, IBlockReader p_196244_2_, BlockPos p_196244_3_)
	{
		return BALLOON_BLOCK_AABB;
	}
	
	@Override
	public VoxelShape getRenderShape(IBlockState state, IBlockReader p_196247_2_, BlockPos p_196247_3_)
	{
		return BALLOON_BLOCK_AABB;
	}
	
	@Override
	public VoxelShape getCollisionShape(IBlockState state, IBlockReader p_196268_2_, BlockPos p_196268_3_)
	{
		return BALLOON_BLOCK_AABB;
	}
}
