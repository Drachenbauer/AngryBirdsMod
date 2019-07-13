package drachenbauer32.angrybirdsmod.blocks;

import javax.annotation.Nullable;

import drachenbauer32.angrybirdsmod.entities.tile_entity.TileEntityBlockColors;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class AbstractColorBlock extends ContainerBlock
{
	private final DyeColor color;
	
	protected AbstractColorBlock(DyeColor p_i48453_1_ , Properties builder)
	{
		super(builder);
		color = p_i48453_1_;
	}

	/*@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn)
	{
		return new TileEntityBlockColors();
	}*/

	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack)
	{
	    TileEntity tileentity = worldIn.getTileEntity(pos);
	    if (tileentity instanceof TileEntityBlockColors)
	    {
	        ((TileEntityBlockColors)tileentity).loadFromItemStack(stack, this.color);
	    }
	}
    
	public DyeColor getColor()
	{
	    return this.color;
    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn)
    {
        return null;
    }
}
