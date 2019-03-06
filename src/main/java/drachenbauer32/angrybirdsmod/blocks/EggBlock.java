package drachenbauer32.angrybirdsmod.blocks;

import drachenbauer32.angrybirdsmod.init.BlockInit;
import drachenbauer32.angrybirdsmod.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.registries.ForgeRegistries;

public class EggBlock extends Block
{
	public static final AxisAlignedBB EGG_BLOCK_AABB = new AxisAlignedBB(0.3125, 0, 0.3125, 0.6875, 0.5, 0.6875);
	
	public EggBlock(String name, Properties class1) 
	{
		super(class1);
		setRegistryName(Reference.MOD_ID, name);
		//BlockInit.BLOCKS.add(this);
		//ItemInit.ITEMS.add(new ItemBlock(this, new Item.Properties().group(ItemGroup.DECORATIONS).maxStackSize(64)).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public Item asItem()
	{
	    return ForgeRegistries.ITEMS.getValue(this.getRegistryName());
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
		return VoxelShapes.create(EGG_BLOCK_AABB);
	}
	
	@Override
	public VoxelShape getRenderShape(IBlockState state, IBlockReader p_196247_2_, BlockPos p_196247_3_)
	{
		return VoxelShapes.create(EGG_BLOCK_AABB);
	}
	
	@Override
	public VoxelShape getCollisionShape(IBlockState state, IBlockReader p_196268_2_, BlockPos p_196268_3_)
	{
		return VoxelShapes.create(EGG_BLOCK_AABB);
	}
}
