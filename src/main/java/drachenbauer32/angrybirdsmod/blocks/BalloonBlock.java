package drachenbauer32.angrybirdsmod.blocks;

import java.util.Map;

import com.google.common.collect.Maps;

import drachenbauer32.angrybirdsmod.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BalloonBlock extends AbstractColorBlock
{
    protected static final VoxelShape BALLOON_BLOCK_AABB = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    private static final Map<DyeColor, Block> BALLOONS_BY_COLOR = Maps.newHashMap();
    
    public BalloonBlock(String name, DyeColor p_i48448_1_, Block.Properties builder) 
    {
        super(p_i48448_1_, builder);
        setRegistryName(Reference.MOD_ID, name);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
        this.setDefaultState(this.stateContainer.getBaseState().with(HALF, DoubleBlockHalf.LOWER));
        BALLOONS_BY_COLOR.put(p_i48448_1_, this);
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
        return BALLOON_BLOCK_AABB;
    }
    
    @Override
    public VoxelShape getRenderShape(BlockState state, IBlockReader p_196247_2_, BlockPos p_196247_3_)
    {
        return BALLOON_BLOCK_AABB;
    }
    
    public VoxelShape getCollisionShape(BlockState state, IBlockReader p_196268_2_, BlockPos p_196268_3_)
    {
        return BALLOON_BLOCK_AABB;
    }
    
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(FACING, HALF);
    }
    
    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer,
            ItemStack stack)
    {
        //replaceBlock(oldState, newState, worldIn, pos, flags);
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
    }
    
    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player)
    {
        //replaceBlock(oldState, newState, worldIn, pos, flags);
        super.onBlockHarvested(worldIn, pos, state, player);
    }
    
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }
    
    public BlockState rotate(BlockState state, Rotation rot)
    {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }
    
    public static Block forColor(DyeColor p_196287_0_)
    {
        return BALLOONS_BY_COLOR.getOrDefault(p_196287_0_, Blocks.WHITE_BANNER);
    }
}
