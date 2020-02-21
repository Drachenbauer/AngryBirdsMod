package drachenbauer32.angrybirdsmod.entities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class BubblesEntity extends AnimalEntity
{
    private int timeUntilDeflating = 0;
    public boolean isInflated = false;
    protected static final AxisAlignedBB BBUBBLES_AABB = new AxisAlignedBB(6.0D, 0.0D, 6.0D, 12.0D, 4.0D, 12.0D);
    protected static final AxisAlignedBB BBUBBLES_INFLATED_AABB = new AxisAlignedBB(-2.0D, 0.0D, -2.0D, 18.0D, 20.0D, 18.0D);
    
    public BubblesEntity(EntityType<? extends BubblesEntity> type, World worldIn)
    {
        super(type, worldIn);
    }
    
    @Override
    public AgeableEntity createChild(AgeableEntity arg0)
    {
        return null;
    }
    
    @Override
    public float getEyeHeight(Pose pose)
    {
        return this.getSize(pose).height / 8 * 5;
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
    public boolean canBreatheUnderwater()
    {
        return true;
    }
    
    @Override
    protected void registerAttributes()
    {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
    }
    
    @Override
    public void livingTick()
    {
        if (timeUntilDeflating > 0)
        {
            timeUntilDeflating--;
            
            if (timeUntilDeflating == 0)
            {
                isInflated = false;
                setBoundingBox(BBUBBLES_AABB);
                
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
            isInflated = true;
            setBoundingBox(BBUBBLES_INFLATED_AABB);
        }
    }
}
