package drachenbauer32.angrybirdsmod.entities;

import drachenbauer32.angrybirdsmod.init.AngryBirdsEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;

public class RedShotEntity extends BirdShotEntity
{
    public RedShotEntity(EntityType<? extends RedShotEntity> type, World worldIn)
    {
        super(type, worldIn);
    }
    
    public RedShotEntity(World worldIn, double x, double y, double z)
    {
        super(AngryBirdsEntities.RED_SHOT.get(),worldIn, x, y, z);
    }
    
    public RedShotEntity(World worldIn, LivingEntity shooter)
    {
        super(AngryBirdsEntities.RED_SHOT.get(),worldIn, shooter);
    }
}
