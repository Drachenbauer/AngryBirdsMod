package drachenbauer32.angrybirdsmod.util;

import drachenbauer32.angrybirdsmod.entity.tile_entity.TileEntityBlockColors;
import net.minecraft.tileentity.TileEntityType;

public class AngryBirdsTileEntityType
{
	public static final TileEntityType<TileEntityBlockColors> BLOCK_COLORS = TileEntityType.register("block_colors", TileEntityType.Builder.create(TileEntityBlockColors::new));
}
