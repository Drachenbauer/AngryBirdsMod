package drachenbauer32.angrybirdsmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class SlingshotBlockSide extends Block
{
    private static final VoxelShape NORTH_AABB = Block.makeCuboidShape(10.0D, 14.0D, 7.0D, 16.0D, 16.0D, 9.0D);
    private static final VoxelShape EAST_AABB = Block.makeCuboidShape(7.0D, 14.0D, 10.0D, 9.0D, 16.0D, 16.0D);
    private static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(0.0D, 14.0D, 7.0D, 6.0D, 16.0D, 9.0D);
    private static final VoxelShape WEST_AABB = Block.makeCuboidShape(7.0D, 14.0D, 0.0D, 9.0D, 16.0D, 6.0D);
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    
    public SlingshotBlockSide(Properties properties) 
    {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }
    
    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return getShapeByDirection(state);
    }
    
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return getShapeByDirection(state);
    }
    
    @Override
    public VoxelShape getRenderShape(BlockState state, IBlockReader worldIn, BlockPos pos)
    {
        return getShapeByDirection(state);
    }
    
    private VoxelShape getShapeByDirection(BlockState state)
    {
        Direction facing = state.get(FACING);
        
        switch(facing)
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
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(FACING);
    }
    
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }
    
    @Override
    public BlockState rotate(BlockState state, Rotation rot)
    {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }
    
    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player)
    {
        worldIn.setBlockState(pos.up(), Blocks.AIR.getDefaultState());
        
        BlockPos pos1;
        BlockPos pos2;
        BlockPos pos3;
        BlockPos pos4;
        
        Direction facing = state.get(FACING);
        
        switch(facing)
        {
            default:
            pos1 = pos.west();
            pos2 = pos.west(2);
            pos3 = pos.west().up();
            pos4 = pos.west(2).up();
            break;
            
            case EAST:
            pos1 = pos.north();
            pos2 = pos.north(2);
            pos3 = pos.north().up();
            pos4 = pos.north(2).up();
            break;
            
            case SOUTH:
            pos1 = pos.east();
            pos2 = pos.east(2);
            pos3 = pos.east().up();
            pos4 = pos.east(2).up();
            break;
            
            case WEST:
            pos1 = pos.south();
            pos2 = pos.south(2);
            pos3 = pos.south().up();
            pos4 = pos.south(2).up();
        }
        
        worldIn.setBlockState(pos1, Blocks.AIR.getDefaultState());
        worldIn.setBlockState(pos2, Blocks.AIR.getDefaultState());
        worldIn.setBlockState(pos3, Blocks.AIR.getDefaultState());
        worldIn.setBlockState(pos4, Blocks.AIR.getDefaultState());
        super.onBlockHarvested(worldIn, pos, state, player);
    }
}
