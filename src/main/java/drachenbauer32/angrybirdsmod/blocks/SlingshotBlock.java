package drachenbauer32.angrybirdsmod.blocks;

import drachenbauer32.angrybirdsmod.init.BlockInit;
import drachenbauer32.angrybirdsmod.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class SlingshotBlock extends Block
{
	protected static final VoxelShape NORTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
	protected static final VoxelShape EAST_AABB = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
	protected static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
	protected static final VoxelShape WEST_AABB = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
	public static final DirectionProperty FACING = BlockHorizontal.HORIZONTAL_FACING;
	
	public SlingshotBlock(String name, Properties properties) 
	{
		super(properties);
		setRegistryName(Reference.MOD_ID, name);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, EnumFacing.NORTH));
	}
	
	public Block addToBlockAndItemBlockRegistryList()
	{
		BlockInit.BLOCKS.add(this);
		BlockInit.ITEMBLOCKS.add(new ItemBlock(this, new Item.Properties().defaultMaxDamage(0).group(ItemGroup.DECORATIONS).maxStackSize(64).rarity(EnumRarity.COMMON).setNoRepair()));
		return this;
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
	
	protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder)
	{
        builder.add(FACING);
    }
	
	public IBlockState getStateForPlacement(BlockItemUseContext context)
	{
	    return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}
	
	public IBlockState rotate(IBlockState state, Rotation rot)
	{
	    return state.with(FACING, rot.rotate(state.get(FACING)));
	}
	
	@Override
	public VoxelShape getShape(IBlockState state, IBlockReader p_196244_2_, BlockPos p_196244_3_)
	{
		EnumFacing enumfacing = state.get(FACING);
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
	public VoxelShape getRenderShape(IBlockState state, IBlockReader p_196247_2_, BlockPos p_196247_3_)
	{
		EnumFacing enumfacing = state.get(FACING);
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
	public VoxelShape getCollisionShape(IBlockState state, IBlockReader p_196268_2_, BlockPos p_196268_3_)
	{
		EnumFacing enumfacing = state.get(FACING);
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

    /*public interface IBlockColor
    {
        int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex);
    }
    @Override
    public IBlockColor getBlockColor() {
        return null;
    }*/
}
