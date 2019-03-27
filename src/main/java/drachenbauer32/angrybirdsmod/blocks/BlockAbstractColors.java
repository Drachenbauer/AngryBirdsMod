package drachenbauer32.angrybirdsmod.blocks;

import javax.annotation.Nullable;

import drachenbauer32.angrybirdsmod.entity.tile_entity.TileEntityBlockColors;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockAbstractColors extends BlockContainer
{
	private final EnumDyeColor color;
	
	protected BlockAbstractColors(EnumDyeColor p_i48453_1_ , Properties builder) {
		super(builder);
		color = p_i48453_1_;
	}

	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return new TileEntityBlockColors(this.color);
	}

	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, @Nullable EntityLivingBase placer, ItemStack stack) {
	      TileEntity tileentity = worldIn.getTileEntity(pos);
	      if (tileentity instanceof TileEntityBlockColors) {
	         ((TileEntityBlockColors)tileentity).loadFromItemStack(stack, this.color);
	      }

	   }

	   public EnumDyeColor getColor() {
	      return this.color;
	   }
}
