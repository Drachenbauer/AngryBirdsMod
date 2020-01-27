package drachenbauer32.angrybirdsmod.blocks;

import drachenbauer32.angrybirdsmod.entities.tile_entities.BlockColorsTileEntity;
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
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class SlingshotBlock extends Block
{
    private String name;
    private static final VoxelShape NORTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    private static final VoxelShape EAST_AABB = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
    private static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    private static final VoxelShape WEST_AABB = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    
    public SlingshotBlock(String name, Properties properties) 
    {
        super(properties);
        setRegistryName(Reference.MOD_ID, name);
        this.name = name;
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
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer,
                                ItemStack stack)
    {
        if (name.contains("acacia"))
        {
            if (name.contains("2"))
            {
                replaceBlockByDirection(worldIn, pos, state, placer, stack,
                                        AngryBirdsBlocks.slingshot_acacia_2_wood_base_block, AngryBirdsBlocks.slingshot_acacia_block_side, AngryBirdsBlocks.slingshot_acacia_block_side_top);
            }
            else
            {
                replaceBlockByDirection(worldIn, pos, state, placer, stack,
                                        AngryBirdsBlocks.slingshot_acacia_wood_base_block, AngryBirdsBlocks.slingshot_acacia_block_side, AngryBirdsBlocks.slingshot_acacia_block_side_top);
            }
        }
        else
        {
            if (name.contains("birch"))
            {
                if (name.contains("2"))
                {
                    replaceBlockByDirection(worldIn, pos, state, placer, stack,
                                            AngryBirdsBlocks.slingshot_birch_2_wood_base_block,
                                            AngryBirdsBlocks.slingshot_acacia_block_side,
                                            AngryBirdsBlocks.slingshot_birch_block_side_top);
                }
                else
                {
                    replaceBlockByDirection(worldIn, pos, state, placer, stack,
                                            AngryBirdsBlocks.slingshot_birch_wood_base_block,
                                            AngryBirdsBlocks.slingshot_birch_block_side,
                                            AngryBirdsBlocks.slingshot_birch_block_side_top);
                }
            }
            else
            {
                if (name.contains("dark_oak"))
                {
                    if (name.contains("2"))
                    {
                        replaceBlockByDirection(worldIn, pos, state, placer, stack,
                                                AngryBirdsBlocks.slingshot_dark_oak_2_wood_base_block,
                                                AngryBirdsBlocks.slingshot_dark_oak_block_side,
                                                AngryBirdsBlocks.slingshot_dark_oak_block_side_top);
                    }
                    else
                    {
                        replaceBlockByDirection(worldIn, pos, state, placer, stack,
                                                AngryBirdsBlocks.slingshot_dark_oak_wood_base_block,
                                                AngryBirdsBlocks.slingshot_dark_oak_block_side,
                                                AngryBirdsBlocks.slingshot_dark_oak_block_side_top);
                    }
                }
                else
                {
                    if (name.contains("jungle"))
                    {
                        if (name.contains("2"))
                        {
                            replaceBlockByDirection(worldIn, pos, state, placer, stack,
                                                    AngryBirdsBlocks.slingshot_jungle_2_wood_base_block,
                                                    AngryBirdsBlocks.slingshot_jungle_block_side,
                                                    AngryBirdsBlocks.slingshot_jungle_block_side_top);
                        }
                        else
                        {
                            replaceBlockByDirection(worldIn, pos, state, placer, stack,
                                                    AngryBirdsBlocks.slingshot_jungle_wood_base_block,
                                                    AngryBirdsBlocks.slingshot_jungle_block_side,
                                                    AngryBirdsBlocks.slingshot_jungle_block_side_top);
                        }
                    }
                    else
                    {
                        if (name.contains("oak"))
                        {
                            if (name.contains("2"))
                            {
                                replaceBlockByDirection(worldIn, pos, state, placer, stack,
                                                        AngryBirdsBlocks.slingshot_oak_2_wood_base_block,
                                                        AngryBirdsBlocks.slingshot_oak_block_side,
                                                        AngryBirdsBlocks.slingshot_oak_block_side_top);
                            }
                            else
                            {
                                replaceBlockByDirection(worldIn, pos, state, placer, stack,
                                                        AngryBirdsBlocks.slingshot_oak_wood_base_block,
                                                        AngryBirdsBlocks.slingshot_oak_block_side,
                                                        AngryBirdsBlocks.slingshot_oak_block_side_top);
                            }
                        }
                        else
                        {
                            if (name.contains("spruce"))
                            {
                                if (name.contains("2"))
                                {
                                    replaceBlockByDirection(worldIn, pos, state, placer, stack,
                                                            AngryBirdsBlocks.slingshot_spruce_2_wood_base_block,
                                                            AngryBirdsBlocks.slingshot_spruce_block_side,
                                                            AngryBirdsBlocks.slingshot_spruce_block_side_top);
                                }
                                else
                                {
                                    replaceBlockByDirection(worldIn, pos, state, placer, stack,
                                                            AngryBirdsBlocks.slingshot_spruce_wood_base_block,
                                                            AngryBirdsBlocks.slingshot_spruce_block_side,
                                                            AngryBirdsBlocks.slingshot_spruce_block_side_top);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void replaceBlockByDirection(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack,
                                         Block block1, Block block2, Block block3)
    {
        BlockPos pos1;
        BlockPos pos2;
        BlockPos pos3;
        BlockPos pos4;
        
        Direction facing = state.get(FACING);
        
        worldIn.setBlockState(pos.up(), block1.getDefaultState().with(FACING, facing));
        
        switch(facing)
        {
            default:
            pos1 = pos.west();
            pos2 = pos.east();
            pos3 = pos.west().up();
            pos4 = pos.east().up();
            break;
            
            case EAST:
            pos1 = pos.north();
            pos2 = pos.south();
            pos3 = pos.north().up();
            pos4 = pos.south().up();
            break;
            
            case SOUTH:
            pos1 = pos.east();
            pos2 = pos.west();
            pos3 = pos.east().up();
            pos4 = pos.west().up();
            break;
            
            case WEST:
            pos1 = pos.south();
            pos2 = pos.north();
            pos3 = pos.south().up();
            pos4 = pos.north().up();
        }
        
        worldIn.setBlockState(pos1, block2.getDefaultState().with(FACING, facing));
        worldIn.setBlockState(pos2, block2.getDefaultState().with(FACING, facing.rotateY().rotateY()));
        worldIn.setBlockState(pos3, block3.getDefaultState().with(FACING, facing));
        worldIn.setBlockState(pos4, block3.getDefaultState().with(FACING, facing.rotateY().rotateY()));
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
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
            pos2 = pos.east();
            pos3 = pos.west().up();
            pos4 = pos.east().up();
            break;
            
            case EAST:
            pos1 = pos.north();
            pos2 = pos.south();
            pos3 = pos.north().up();
            pos4 = pos.south().up();
            break;
            
            case SOUTH:
            pos1 = pos.east();
            pos2 = pos.west();
            pos3 = pos.east().up();
            pos4 = pos.west().up();
            break;
            
            case WEST:
            pos1 = pos.south();
            pos2 = pos.north();
            pos3 = pos.south().up();
            pos4 = pos.north().up();
        }
        
        worldIn.setBlockState(pos1, Blocks.AIR.getDefaultState());
        worldIn.setBlockState(pos2, Blocks.AIR.getDefaultState());
        worldIn.setBlockState(pos3, Blocks.AIR.getDefaultState());
        worldIn.setBlockState(pos4, Blocks.AIR.getDefaultState());
        super.onBlockHarvested(worldIn, pos, state, player);
    }
    
    @Override
    public boolean hasTileEntity(BlockState state)
    {
        return true;
    }
    
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world)
    {
        return new BlockColorsTileEntity();
    }
}
