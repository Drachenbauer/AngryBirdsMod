package drachenbauer32.angrybirdsmod.blocks;

import drachenbauer32.angrybirdsmod.init.AngryBirdsBlocks;
import drachenbauer32.angrybirdsmod.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class SlingshotBirch2Block extends Block
{	
    protected static final VoxelShape NORTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    protected static final VoxelShape EAST_AABB = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
    protected static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    protected static final VoxelShape WEST_AABB = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    
    public SlingshotBirch2Block(String name, Properties properties) 
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
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer,
            ItemStack stack)
    {
        Direction facing = state.get(FACING);
        
        switch(facing)
        {
            default:
            worldIn.setBlockState(pos.up(), AngryBirdsBlocks.slingshot_birch_2_wood_base_block.getDefaultState());
            worldIn.setBlockState(pos.west(), AngryBirdsBlocks.slingshot_birch_block_side.getDefaultState());
            worldIn.setBlockState(pos.east(), AngryBirdsBlocks.slingshot_birch_block_side.getDefaultState().with(FACING, Direction.SOUTH));
            worldIn.setBlockState(pos.west().up(), AngryBirdsBlocks.slingshot_birch_block_side_top.getDefaultState());
            worldIn.setBlockState(pos.east().up(), AngryBirdsBlocks.slingshot_birch_block_side_top.getDefaultState().with(FACING, Direction.SOUTH));
            super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
            return;
            
            case EAST:
            worldIn.setBlockState(pos.up(), AngryBirdsBlocks.slingshot_birch_2_wood_base_block.getDefaultState().with(FACING, Direction.EAST));
            worldIn.setBlockState(pos.north(), AngryBirdsBlocks.slingshot_birch_block_side.getDefaultState().with(FACING, Direction.EAST));
            worldIn.setBlockState(pos.south(), AngryBirdsBlocks.slingshot_birch_block_side.getDefaultState().with(FACING, Direction.WEST));
            worldIn.setBlockState(pos.north().up(), AngryBirdsBlocks.slingshot_birch_block_side_top.getDefaultState().with(FACING, Direction.EAST));
            worldIn.setBlockState(pos.south().up(), AngryBirdsBlocks.slingshot_birch_block_side_top.getDefaultState().with(FACING, Direction.WEST));
            super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
            return;
            
            case SOUTH:
            worldIn.setBlockState(pos.up(), AngryBirdsBlocks.slingshot_birch_2_wood_base_block.getDefaultState().with(FACING, Direction.SOUTH));
            worldIn.setBlockState(pos.east(), AngryBirdsBlocks.slingshot_birch_block_side.getDefaultState().with(FACING, Direction.SOUTH));
            worldIn.setBlockState(pos.west(), AngryBirdsBlocks.slingshot_birch_block_side.getDefaultState());
            worldIn.setBlockState(pos.east().up(), AngryBirdsBlocks.slingshot_birch_block_side_top.getDefaultState().with(FACING, Direction.SOUTH));
            worldIn.setBlockState(pos.west().up(), AngryBirdsBlocks.slingshot_birch_block_side_top.getDefaultState());
            super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
            return;
            
            case WEST:
            worldIn.setBlockState(pos.up(), AngryBirdsBlocks.slingshot_birch_2_wood_base_block.getDefaultState().with(FACING, Direction.WEST));
            worldIn.setBlockState(pos.south(), AngryBirdsBlocks.slingshot_birch_block_side.getDefaultState().with(FACING, Direction.WEST));
            worldIn.setBlockState(pos.north(), AngryBirdsBlocks.slingshot_birch_block_side.getDefaultState().with(FACING, Direction.EAST));
            worldIn.setBlockState(pos.south().up(), AngryBirdsBlocks.slingshot_birch_block_side_top.getDefaultState().with(FACING, Direction.WEST));
            worldIn.setBlockState(pos.north().up(), AngryBirdsBlocks.slingshot_birch_block_side_top.getDefaultState().with(FACING, Direction.EAST));
            super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
            return;
        }
    }
    
    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player)
    {
        worldIn.setBlockState(pos.up(), Blocks.AIR.getDefaultState());
        
        Direction facing = state.get(FACING);
        
        switch(facing)
        {
            default:
            worldIn.setBlockState(pos.east(), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.west(), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.east().up(), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.west().up(), Blocks.AIR.getDefaultState());
            super.onBlockHarvested(worldIn, pos, state, player);
            return;
            
            case EAST:
            worldIn.setBlockState(pos.north(), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.south(), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.north().up(), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.south().up(), Blocks.AIR.getDefaultState());
            super.onBlockHarvested(worldIn, pos, state, player);
            return;
            
            case SOUTH:
            worldIn.setBlockState(pos.east(), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.west(), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.east().up(), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.west().up(), Blocks.AIR.getDefaultState());
            super.onBlockHarvested(worldIn, pos, state, player);
            return;
            
            case WEST:
            worldIn.setBlockState(pos.north(), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.south(), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.north().up(), Blocks.AIR.getDefaultState());
            worldIn.setBlockState(pos.south().up(), Blocks.AIR.getDefaultState());
            super.onBlockHarvested(worldIn, pos, state, player);
            return;
        }
    }
}
