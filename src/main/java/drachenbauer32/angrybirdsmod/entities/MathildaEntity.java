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
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class MathildaEntity extends AnimalEntity
{
    public int timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
    
    @SuppressWarnings("unchecked")
    public MathildaEntity(EntityType<? extends AnimalEntity> type, World worldIn)
    {
        super((EntityType<? extends AnimalEntity>) AngryBirdsEntities.MATHILDA, worldIn);
    }
    
    @Override
    public AgeableEntity createChild(AgeableEntity arg0)
    {
        return null;
    }
    
    @Override
    public float getEyeHeight(Pose pose)
    {
        return this.getSize(pose).height * 0.8f;
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
    
    public void livingTick() {
        super.livingTick();
        if (!this.world.isRemote && this.isAlive() && !this.isChild() && --this.timeUntilNextEgg <= 0)
        {
            this.entityDropItem(Items.EGG);
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        }
        
    }
}
