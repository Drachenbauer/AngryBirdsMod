package drachenbauer32.angrybirdsmod.blocks;

import drachenbauer32.angrybirdsmod.util.Reference;
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

public class SlingshotBirchBlockSide extends Block
{
    protected static final VoxelShape NORTH_AABB = Block.makeCuboidShape(10.0D, 14.0D, 7.0D, 16.0D, 16.0D, 9.0D);
    protected static final VoxelShape EAST_AABB = Block.makeCuboidShape(7.0D, 14.0D, 10.0D, 9.0D, 16.0D, 16.0D);
    protected static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(0.0D, 14.0D, 7.0D, 6.0D, 16.0D, 9.0D);
    protected static final VoxelShape WEST_AABB = Block.makeCuboidShape(7.0D, 14.0D, 0.0D, 9.0D, 16.0D, 6.0D);
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    
    public SlingshotBirchBlockSide(String name, Properties properties) 
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
    
    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
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
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
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
    public VoxelShape getRenderShape(BlockState state, IBlockReader worldIn, BlockPos pos)
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
        
        Direction facing = state.get(FACING);
        
        switch(facing)
        {
            default:
            worldIn.setBlockState(pos.west(), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.west(2), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.west().up(), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.west(2).up(), Blocks.AIR.getDefaultState());
            super.onBlockHarvested(worldIn, pos, state, player);
            return;
            
            case EAST:
            worldIn.setBlockState(pos.north(), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.north(2), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.north().up(), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.north(2).up(), Blocks.AIR.getDefaultState());
            super.onBlockHarvested(worldIn, pos, state, player);
            return;
            
            case SOUTH:
            worldIn.setBlockState(pos.east(), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.east(2), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.east().up(), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.east(2).up(), Blocks.AIR.getDefaultState());
            super.onBlockHarvested(worldIn, pos, state, player);
            return;
            
            case WEST:
            worldIn.setBlockState(pos.south(), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.south(2), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.south().up(), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.south(2).up(), Blocks.AIR.getDefaultState());
            super.onBlockHarvested(worldIn, pos, state, player);
            return;
        }
    }
}