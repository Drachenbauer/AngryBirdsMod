package drachenbauer32.angrybirdsmod.blocks;

import drachenbauer32.angrybirdsmod.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class Slingshot2Block extends Block
{	
	protected static final VoxelShape NORTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
	protected static final VoxelShape EAST_AABB = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
	protected static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
	protected static final VoxelShape WEST_AABB = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	
	public Slingshot2Block(String name, Properties properties) 
	{
		super(properties);
		setRegistryName(Reference.MOD_ID, name);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
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
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
	{
        builder.add(FACING);
    }
	
	public BlockState getStateForPlacement(BlockItemUseContext context)
	{
	    return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}
	
	public BlockState rotate(BlockState state, Rotation rot)
	{
	    return state.with(FACING, rot.rotate(state.get(FACING)));
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader p_196244_2_, BlockPos p_196244_3_)
	{
		Direction enumfacing = state.get(FACING);
	    switch(enumfacing)
	    {
	        default:
	            return NORTH_AABB;
	        case EAST:
		        return EAST_AABB;   
	        case SOUTH:
	            return SOUTH_AABB;
	        case WEST:
	            return WEST_AABB;
	    }
	}
	
	@Override
	public VoxelShape getRenderShape(BlockState state, IBlockReader p_196247_2_, BlockPos p_196247_3_)
	{
		Direction enumfacing = state.get(FACING);
	    switch(enumfacing)
	    {
	        default:
	            return NORTH_AABB;
	        case EAST:
		        return EAST_AABB;   
	        case SOUTH:
	            return SOUTH_AABB;
	        case WEST:
	            return WEST_AABB;
	    }
	}
	
	public VoxelShape getCollisionShape(BlockState state, IBlockReader p_196268_2_, BlockPos p_196268_3_)
	{
		Direction enumfacing = state.get(FACING);
	    switch(enumfacing)
	    {
	        default:
	            return NORTH_AABB;
	        case EAST:
		        return EAST_AABB;   
	        case SOUTH:
	            return SOUTH_AABB;
	        case WEST:
	            return WEST_AABB;
	    }
	}
}
