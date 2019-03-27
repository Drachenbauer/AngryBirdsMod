package drachenbauer32.angrybirdsmod.blocks;

import java.util.Map;

import com.google.common.collect.Maps;

import drachenbauer32.angrybirdsmod.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BalloonBlock extends BlockAbstractColors
{
	protected static final VoxelShape BALLOON_BLOCK_AABB = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
	public static final DirectionProperty FACING = BlockHorizontal.HORIZONTAL_FACING;
	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
	private static final Map<EnumDyeColor, Block> BANNERS_BY_COLOR = Maps.newHashMap();
	
	public BalloonBlock(String name, EnumDyeColor p_i48448_1_, Block.Properties builder) 
	{
		super(p_i48448_1_, builder);
		setRegistryName(Reference.MOD_ID, name);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, EnumFacing.NORTH));
		this.setDefaultState(this.stateContainer.getBaseState().with(HALF, DoubleBlockHalf.LOWER));
		BANNERS_BY_COLOR.put(p_i48448_1_, this);
	}
	
	@Override
	public boolean isSolid(IBlockState state)
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state)
    {
        return false;
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
	
	protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder)
	{
        builder.add(FACING, HALF);
    }
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack)
	{
		
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
	}
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
	{
		
		super.onBlockHarvested(worldIn, pos, state, player);
	}
	
	public IBlockState getStateForPlacement(BlockItemUseContext context)
	{
	    return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}
	
	public IBlockState rotate(IBlockState state, Rotation rot)
	{
	    return state.with(FACING, rot.rotate(state.get(FACING)));
	}
	
	public static Block forColor(EnumDyeColor p_196287_0_)
	{
	    return BANNERS_BY_COLOR.getOrDefault(p_196287_0_, Blocks.WHITE_BANNER);
	}
}
