package drachenbauer32.angrybirdsmod.entities.tile_entities;

import drachenbauer32.angrybirdsmod.init.AngryBirdsTileEntities;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;

public class BlockColorsTileEntity extends TileEntity
{
    public BlockColorsTileEntity()
    {
        super(AngryBirdsTileEntities.BLOCK_COLORS);
    }
    
    @Override
    public void read(CompoundNBT compound)
    {
        super.read(compound);
    }
    
    @Override
    public CompoundNBT write(CompoundNBT compound)
    {
        return super.write(compound);
    }
}
