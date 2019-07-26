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

public class NestBlock extends Block
{
    protected static final VoxelShape NEST_BLOCK_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D);
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    
    public NestBlock(String name, Properties properties) 
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
    
    public VoxelShape getShape(BlockState state, IBlockReader p_196244_2_, BlockPos p_196244_3_)
    {
        return NEST_BLOCK_AABB;
    }
    
    @Override
    public VoxelShape getRenderShape(BlockState state, IBlockReader p_196247_2_, BlockPos p_196247_3_)
    {
        return NEST_BLOCK_AABB;
    }
    
    public VoxelShape getCollisionShape(BlockState state, IBlockReader p_196268_2_, BlockPos p_196268_3_)
    {
        return NEST_BLOCK_AABB;
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
}
