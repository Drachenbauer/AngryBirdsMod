package drachenbauer32.angrybirdsmod.blocks;

import drachenbauer32.angrybirdsmod.init.BlockInit;
import drachenbauer32.angrybirdsmod.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class SlingshotBlock extends Block
{
	public static final AxisAlignedBB SLINGSHOT_BLOCK_AABB = new AxisAlignedBB(-0.375, 0, 0.125, 1.375, 2, 0.875);
	public static final DirectionProperty FACING = BlockHorizontal.HORIZONTAL_FACING;
	
	public SlingshotBlock(String name, Properties class1) 
	{
		super(class1);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, EnumFacing.NORTH));
		setRegistryName(Reference.MOD_ID, name);
		//BlockInit.BLOCKS.add(this);
		//ItemInit.ITEMS.add(new ItemBlock(this, new Item.Properties().group(ItemGroup.DECORATIONS).maxStackSize(64)).setRegistryName(this.getRegistryName()));
	}
	
	public Block addToBlockAndItemBlockRegistryList()
	{
		BlockInit.BLOCKS.add(this);
		BlockInit.ITEMBLOCKS.add(new ItemBlock(this, new Item.Properties().defaultMaxDamage(0).group(ItemGroup.DECORATIONS).maxStackSize(64).rarity(EnumRarity.COMMON).setNoRepair()));
		return this;
	}
	
	/*private Item.Properties getDefaultProperties()
	{
	    return new Item.Properties()
	                .defaultMaxDamage(0)
	                .group(ItemGroup.DECORATIONS)
	                .maxStackSize(64)
	                .rarity(EnumRarity.COMMON)
	                .setNoRepair()
	                ;
	}

	public Item getItemBlock()
	{
	    return new ItemBlock(this, getDefaultProperties()).setRegistryName(this.getRegistryName().getPath());
	}*/
	
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
		return VoxelShapes.create(SLINGSHOT_BLOCK_AABB);
	}
	
	@Override
	public VoxelShape getRenderShape(IBlockState state, IBlockReader p_196247_2_, BlockPos p_196247_3_)
	{
		return VoxelShapes.create(SLINGSHOT_BLOCK_AABB);
	}
	
	@Override
	public VoxelShape getCollisionShape(IBlockState state, IBlockReader p_196268_2_, BlockPos p_196268_3_)
	{
		return VoxelShapes.create(SLINGSHOT_BLOCK_AABB);
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder)
	{
        builder.add(FACING);
    }
	
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.with(FACING, rot.rotate((EnumFacing) state.get(FACING)));
    }

    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().with(FACING, placer.getHorizontalFacing().getOpposite());
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
