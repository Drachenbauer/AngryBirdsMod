package drachenbauer32.angrybirdsmod.entity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityChuck extends EntityChicken
{
	public EntityChuck(World worldIn)
	{
		super(worldIn);
		this.setSize(0.5F, 0.6875F);
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
		return 0.25f;
	}
	
	@Override
	public void livingTick()
	{
		super.livingTick();
		this.timeUntilNextEgg = 100;
	}
}
