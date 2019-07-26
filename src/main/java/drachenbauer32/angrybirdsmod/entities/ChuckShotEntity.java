package drachenbauer32.angrybirdsmod.entities;

import drachenbauer32.angrybirdsmod.init.AngryBirdsEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;

public class ChuckShotEntity extends BirdShotEntity
{
    public ChuckShotEntity(EntityType<? extends BirdShotEntity> type, World worldIn)
    {
        super((EntityType<? extends BirdShotEntity>)AngryBirdsEntities.CHUCK_SHOT, worldIn);
    }
    
    public ChuckShotEntity(World worldIn, double x, double y, double z)
    {
        super((EntityType<? extends BirdShotEntity>)AngryBirdsEntities.CHUCK_SHOT,worldIn, x, y, z);
    }
    
    public ChuckShotEntity(World worldIn, LivingEntity shooter)
    {
        super((EntityType<? extends BirdShotEntity>)AngryBirdsEntities.CHUCK_SHOT,worldIn, shooter);
    }
}
