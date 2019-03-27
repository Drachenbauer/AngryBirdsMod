package drachenbauer32.angrybirdsmod.entity.tile_entity;

import drachenbauer32.angrybirdsmod.util.AngryBirdsTileEntityType;
import java.util.function.Supplier;
import net.minecraft.block.BlockAbstractBanner;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBlockColors extends TileEntity
{	
	private EnumDyeColor Color = EnumDyeColor.WHITE;
	   
	public TileEntityBlockColors()
	{
		super(AngryBirdsTileEntityType.BLOCK_COLORS);
	}

	public TileEntityBlockColors(EnumDyeColor dye_color)
	{
	    this();
	    this.Color = dye_color;
	}
	
	public void loadFromItemStack(ItemStack p_195534_1_, EnumDyeColor dye_color)
	{
	    this.Color = dye_color;
	}
	
	public void read(NBTTagCompound compound) 
	{
	    super.read(compound);
	    if (this.hasWorld())
	    {
	        this.Color = ((BlockAbstractBanner)this.getBlockState().getBlock()).getColor();
	    }
	    else 
	    {
	        this.Color = null;
	    }
	}
	
	public EnumDyeColor getBaseColor(Supplier<IBlockState> p_195533_1_)
	{
	    if (this.Color == null)
	    {
	        this.Color = ((BlockAbstractBanner)p_195533_1_.get().getBlock()).getColor();
	    }

	    return this.Color;
	}
}
