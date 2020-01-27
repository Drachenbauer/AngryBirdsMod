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

public class SlingshotWoodBaseBlock extends Block
{
    private String name;
    private static final VoxelShape NORTH_AABB = Block.makeCuboidShape(0.0D, 4.0D, 2.0D, 16.0D, 8.0D, 14.0D);
    private static final VoxelShape EAST_AABB = Block.makeCuboidShape(2.0D, 4.0D, 0.0D, 14.0D, 8.0D, 16.0D);
    private static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(0.0D, 4.0D, 2.0D, 16.0D, 8.0D, 14.0D);
    private static final VoxelShape WEST_AABB = Block.makeCuboidShape(2.0D, 4.0D, 0.0D, 14.0D, 8.0D, 16.0D);
    private static final VoxelShape NORTH_2_AABB = Block.makeCuboidShape(0.0D, 4.0D, 8.0D, 16.0D, 16.0D, 12.0D);
    private static final VoxelShape EAST_2_AABB = Block.makeCuboidShape(4.0D, 4.0D, 0.0D, 8.0D, 16.0D, 16.0D);
    private static final VoxelShape SOUTH_2_AABB = Block.makeCuboidShape(0.0D, 4.0D, 4.0D, 16.0D, 16.0D, 8.0D);
    private static final VoxelShape WEST_2_AABB = Block.makeCuboidShape(8.0D, 4.0D, 0.0D, 12.0D, 16.0D, 16.0D);
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    
    public SlingshotWoodBaseBlock(String name, Properties properties)
    {
        super(properties);
        setRegistryName(Reference.MOD_ID, name);
        this.name = name;
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
        
        if(name.contains("2"))
        {
            switch(facing)
            {
                default:
                return NORTH_2_AABB;
                
                case EAST:
                return EAST_2_AABB;
                
                case SOUTH:
                return SOUTH_2_AABB;
                
                case WEST:
                return WEST_2_AABB;
            }
        }
        else
        {
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
        worldIn.setBlockState(pos.down(), Blocks.AIR.getDefaultState());
        
        BlockPos pos1;
        BlockPos pos2;
        BlockPos pos3;
        BlockPos pos4;
        
        Direction facing = state.get(FACING);
        
        switch(facing)
        {
            default:
            pos1 = pos.west();
            pos2 = pos.east();
            pos3 = pos.west().down();
            pos4 = pos.east().down();
            break;
            
            case EAST:
            pos1 = pos.north();
            pos2 = pos.south();
            pos3 = pos.north().down();
            pos4 = pos.south().down();
            break;
            
            case SOUTH:
            pos1 = pos.east();
            pos2 = pos.west();
            pos3 = pos.east().down();
            pos4 = pos.west().down();
            break;
            
            case WEST:
            pos1 = pos.south();
            pos2 = pos.north();
            pos3 = pos.south().down();
            pos4 = pos.north().down();
        }
        
        worldIn.setBlockState(pos1, Blocks.AIR.getDefaultState());
        worldIn.setBlockState(pos2, Blocks.AIR.getDefaultState());
        worldIn.setBlockState(pos3, Blocks.AIR.getDefaultState());
        worldIn.setBlockState(pos4, Blocks.AIR.getDefaultState());
        super.onBlockHarvested(worldIn, pos, state, player);
    }
}
