package drachenbauer32.angrybirdsmod.entities;

import drachenbauer32.angrybirdsmod.init.AngryBirdsEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;

public class RedShotEntity extends BirdShotEntity
{
    public RedShotEntity(EntityType<? extends BirdShotEntity> type, World worldIn)
    {
        super((EntityType<? extends BirdShotEntity>)AngryBirdsEntities.RED_SHOT, worldIn);
    }
    
    public RedShotEntity(World worldIn, double x, double y, double z)
    {
        super((EntityType<? extends BirdShotEntity>)AngryBirdsEntities.RED_SHOT,worldIn, x, y, z);
    }
    
    public RedShotEntity(World worldIn, LivingEntity shooter)
    {
        super((EntityType<? extends BirdShotEntity>)AngryBirdsEntities.RED_SHOT,worldIn, shooter);
    }
    
    
}
