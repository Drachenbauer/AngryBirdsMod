package drachenbauer32.angrybirdsmod.entity.tile_entity;

import drachenbauer32.angrybirdsmod.util.AngryBirdsTileEntityType;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
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
}
