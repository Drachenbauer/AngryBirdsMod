package drachenbauer32.angrybirdsmod.entities;

import drachenbauer32.angrybirdsmod.init.AngryBirdsEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;

public class BubblesInflatedEntity extends Entity
{
    public BubblesInflatedEntity(EntityType<?> entityTypeIn, World worldIn)
    {
        super((EntityType<?>)AngryBirdsEntities.BUBBLES_INFLATED, worldIn);
    }
    
    @Override
    protected void registerData()
    {
        
    }
    
    @Override
    protected void readAdditional(CompoundNBT compound)
    {
        
    }
    
    @Override
    protected void writeAdditional(CompoundNBT compound)
    {
        
    }
    
    @Override
    public IPacket<?> createSpawnPacket()
    {
        return null;
    }
}
