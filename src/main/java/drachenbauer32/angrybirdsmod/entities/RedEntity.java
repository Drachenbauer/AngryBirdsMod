package drachenbauer32.angrybirdsmod.entities;

import drachenbauer32.angrybirdsmod.init.AngryBirdsEntities;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.controller.JumpController;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class RedEntity extends AnimalEntity
{
    private int jumpTicks;
    private int jumpDuration;
    private boolean wasOnGround;
    private int currentMoveTypeDuration;
    //private AxisAlignedBB boundingbox;
    
    @SuppressWarnings("unchecked")
    public RedEntity(EntityType<? extends AnimalEntity> type, World worldIn)
    {
        super((EntityType<? extends AnimalEntity>) AngryBirdsEntities.RED, worldIn);
        //boundingbox = new AxisAlignedBB(0d, 0d, 0d, 0d, 0d, 0d);
        this.jumpController = new RedEntity.JumpHelperController(this);
        this.moveController = new RedEntity.MoveHelperController(this);
        this.setMovementSpeed(0.0D);
    }
    
    @Override
    public AgeableEntity createChild(AgeableEntity arg0)
    {
        return null;
    }
    
    @Override
    public float getEyeHeight(Pose p_213307_1_)
    {
        return 0.25f;
    }
    
    /*@Override
    public AxisAlignedBB getBoundingBox()
    {
        return boundingbox;
    }*/
    
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
    
    protected void jump()
    {
        super.jump();
        double d0 = this.moveController.getSpeed();
        
        if (d0 > 0.0D)
        {
            double d1 = func_213296_b(this.getMotion());
            
            if (d1 < 0.01D)
            {
                this.moveRelative(0.1F, new Vec3d(0.0D, 0.0D, 0.25D));
            }
        }
        
        if (!this.world.isRemote)
        {
            this.world.setEntityState(this, (byte)1);
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public float getJumpCompletion(float p_175521_1_)
    {
        return this.jumpDuration == 0 ? 0.0F : ((float)this.jumpTicks + p_175521_1_) / (float)this.jumpDuration;
    }
    
    public void setMovementSpeed(double newSpeed)
    {
        this.getNavigator().setSpeed(newSpeed);
        this.moveController.setMoveTo(this.moveController.getX(), this.moveController.getY(), this.moveController.getZ(), newSpeed);
    }
    
    public void setJumping(boolean jumping)
    {
        super.setJumping(jumping);
    }
    
    public void startJumping()
    {
        this.setJumping(true);
        this.jumpDuration = 10;
        this.jumpTicks = 0;
    }
    
    public void updateAITasks()
    {
        if (this.currentMoveTypeDuration > 0)
        {
            --this.currentMoveTypeDuration;
        }
        
        if (this.onGround)
        {
            if (!this.wasOnGround)
            {
                this.setJumping(false);
                this.checkLandingDelay();
            }
            
            RedEntity.JumpHelperController redentity$jumphelpercontroller = (RedEntity.JumpHelperController)this.jumpController;
            
            if (!redentity$jumphelpercontroller.getIsJumping())
            {
                if (this.moveController.isUpdating() && this.currentMoveTypeDuration == 0)
                {   
                    this.startJumping();
                    this.wasOnGround = true;
                }
            }
            else if (!redentity$jumphelpercontroller.canJump())
            {
                this.enableJumpControl();
            }
        }
        
        this.wasOnGround = this.onGround;
    }
    
    private void enableJumpControl() {
        ((RedEntity.JumpHelperController)this.jumpController).setCanJump(true);
    }
    
    private void disableJumpControl() {
        ((RedEntity.JumpHelperController)this.jumpController).setCanJump(false);
    }
    
    private void updateMoveTypeDuration() {
        if (this.moveController.getSpeed() < 2.2D) {
            this.currentMoveTypeDuration = 10;
        } else {
            this.currentMoveTypeDuration = 1;
        }
        
    }
    
    private void checkLandingDelay() {
        this.updateMoveTypeDuration();
        this.disableJumpControl();
    }
    
    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void livingTick()
    {
        super.livingTick();
        if (this.jumpTicks != this.jumpDuration)
        {
            ++this.jumpTicks;
        }
        else if (this.jumpDuration != 0)
        {
            this.jumpTicks = 0;
            this.jumpDuration = 0;
            this.setJumping(false);
        }
    }
    
    public class JumpHelperController extends JumpController
    {
        private final RedEntity red;
        private boolean canJump;
        
        public JumpHelperController(RedEntity red)
        {
            super(red);
            this.red = red;
        }
        
        public boolean getIsJumping()
        {
            return this.isJumping;
        }
        
        public boolean canJump()
        {
            return this.canJump;
        }
        
        public void setCanJump(boolean canJumpIn)
        {
            this.canJump = canJumpIn;
        }
        
        /**
         * Called to actually make the entity jump if isJumping is true.
         */
        public void tick()
        {
            if (this.isJumping)
            {
                this.red.startJumping();
                this.isJumping = false;
            }
        }
    }
    
    static class MoveHelperController extends MovementController
    {
        private final RedEntity red;
        private double nextJumpSpeed;
        
        public MoveHelperController(RedEntity red)
        {
            super(red);
            this.red = red;
        }
        
        public void tick()
        {
            if (this.red.onGround && !this.red.isJumping && !((RedEntity.JumpHelperController)this.red.jumpController).getIsJumping()) {
                this.red.setMovementSpeed(0.0D);
            } else if (this.isUpdating()) {
                this.red.setMovementSpeed(this.nextJumpSpeed);
            }
            
            super.tick();
        }
        
        /**
         * Sets the speed and location to move to
         */
        public void setMoveTo(double x, double y, double z, double speedIn)
        {
            if (this.red.isInWater())
            {
                speedIn = 1.5D;
            }
            
            super.setMoveTo(x, y, z, speedIn);
            
            if (speedIn > 0.0D)
            {
                this.nextJumpSpeed = speedIn;
            }
        }
    }
}
