package drachenbauer32.angrybirdsmod.entities.tile_entity;

import drachenbauer32.angrybirdsmod.blocks.AbstractColorBlock;
import java.util.function.Supplier;

import net.minecraft.block.BlockState;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class TileEntityBlockColors extends TileEntity
{	
    private DyeColor Color = DyeColor.WHITE;
    
	public TileEntityBlockColors(TileEntityType<?> tileEntityTypeIn)
    {
        super(tileEntityTypeIn);
    }

	public void loadFromItemStack(ItemStack p_195534_1_, DyeColor dye_color)
	{
		this.Color = dye_color;
	}

	public void read(CompoundNBT compound) 
	{
		super.read(compound);
		if (this.hasWorld())
		{
			this.Color = ((AbstractColorBlock)this.getBlockState().getBlock()).getColor();
		}
		else 
		{
			this.Color = null;
		}
	}

	public DyeColor getBaseColor(Supplier<BlockState> p_195533_1_)
	{
		if (this.Color == null)
		{
			this.Color = ((AbstractColorBlock)this.getBlockState().getBlock()).getColor();
		}

		return this.Color;
	}
}
