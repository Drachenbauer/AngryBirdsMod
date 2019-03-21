package drachenbauer32.angrybirdsmod.entity;

import drachenbauer32.angrybirdsmod.util.AngryBirdsEntityTypes;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityMathilda extends EntityAnimal
{
	public int timeUntilNextEgg;
	
	public EntityMathilda(World worldIn)
    {
		super(AngryBirdsEntityTypes.MATHILDA, worldIn);
		setSize(0.5F, 0.875F);
		this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
	}

	@Override
	protected void playStepSound(BlockPos p_180429_1_, IBlockState p_180429_2_)
	{
		super.playStepSound(p_180429_1_, p_180429_2_);
	}
	
	@Override
	public void setBoundingBox(AxisAlignedBB p_174826_1_)
	{
		super.setBoundingBox(p_174826_1_);
	}
	
	@Override
	public float getEyeHeight()
	{
		return 0.5f;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable)
	{
		return null;
	}
	
	@Override
	public void livingTick()
	{
		super.livingTick();
		if (!this.world.isRemote && !this.isChild() && --this.timeUntilNextEgg <= 0)
		{
	         this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
	         this.entityDropItem(Items.EGG);
	         this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
		}
	}
	
	public void readAdditional(NBTTagCompound compound) 
	{
	    super.readAdditional(compound);
	    if (compound.hasKey("EggLayTime")) 
	    {
	         this.timeUntilNextEgg = compound.getInt("EggLayTime");
	    }
	}
	
	public void writeAdditional(NBTTagCompound compound)
	{
	    super.writeAdditional(compound);
	    compound.setInt("EggLayTime", this.timeUntilNextEgg);
	}
}
