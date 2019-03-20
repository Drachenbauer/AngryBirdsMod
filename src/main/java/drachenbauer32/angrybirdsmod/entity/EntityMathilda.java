package drachenbauer32.angrybirdsmod.entity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityMathilda extends EntityAnimal
{
	protected EntityMathilda(EntityType<?> type, World p_i48568_2_)
	{
		super(type, p_i48568_2_);
		setSize(0.5F, 0.875F);
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
}
