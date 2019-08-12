package drachenbauer32.angrybirdsmod.entities;

import drachenbauer32.angrybirdsmod.init.AngryBirdsEntities;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class BubblesEntity extends AnimalEntity
{
    private int timeUntilDeflating = 0;
    private BubblesInflatedEntity inflated = new BubblesInflatedEntity(AngryBirdsEntities.BUBBLES_INFLATED, world);
    
    @SuppressWarnings("unchecked")
    public BubblesEntity(EntityType<? extends AnimalEntity> type, World worldIn)
    {
        super((EntityType<? extends AnimalEntity>) AngryBirdsEntities.BUBBLES, worldIn);
    }
    
    @Override
    public AgeableEntity createChild(AgeableEntity arg0)
    {
        return null;
    }
    
    @Override
    public float getEyeHeight(Pose pose)
    {
        return this.getSize(pose).height * 0.625f;
    }
    
    @Override
    protected void registerGoals()
    {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 0.2d, 10));
        this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.2d));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
    }
    
    @Override
    protected void registerAttributes()
    {
        super.registerAttributes();
    }
    
    @Override
    public void livingTick()
    {
        if (timeUntilDeflating > 0)
        {
            timeUntilDeflating--;
            
            if (timeUntilDeflating == 0)
            {
                //command for deflating here
            }
        }
        else
        {
            super.livingTick();
        }
    }
    
    @Override
    public void onCollideWithPlayer(PlayerEntity entityIn)
    {
        if (timeUntilDeflating == 0)
        {
            timeUntilDeflating = 80;
            //command for inflating here
        }
    }
}
