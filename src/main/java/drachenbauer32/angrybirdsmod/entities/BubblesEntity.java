package drachenbauer32.angrybirdsmod.entities;

import java.util.List;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
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
                AxisAlignedBB aabb = this.getBoundingBox();
                this.setBoundingBox(new AxisAlignedBB(aabb.minX + 0.5d, aabb.minY, aabb.minZ + 0.5d, aabb.maxX - 0.5d, aabb.maxY - 1.0d, aabb.maxZ - 0.5d));
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
            AxisAlignedBB aabb = this.getBoundingBox();
            this.setBoundingBox(new AxisAlignedBB(aabb.minX - 0.5d, aabb.minY, aabb.minZ - 0.5d, aabb.maxX + 0.5d, aabb.maxY + 1.0d, aabb.maxZ + 0.5d));
            this.collideWithEntities(this.world.getEntitiesInAABBexcluding(this, this.getBoundingBox().grow(0.5D, 0.5D, 0.5D).offset(0.0D, 0.0D, 0.0D), null));
        }
    }
    
    private void collideWithEntities(List<Entity> entities)
    {
        double d0 = (getBoundingBox().minX + getBoundingBox().maxX) / 2.0D;
        double d1 = (getBoundingBox().minZ + getBoundingBox().maxZ) / 2.0D;
        
        for(Entity entity : entities)
        {
            if (entity instanceof LivingEntity)
            {
                double d2 = entity.getPosX() - d0;
                double d3 = entity.getPosZ() - d1;
                double d4 = d2 * d2 + d3 * d3;
                entity.addVelocity(d2 / d4 * 4.0D, (double)0.2F, d3 / d4 * 4.0D);
            }
        }
    }
}
