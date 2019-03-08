package drachenbauer32.angrybirdsmod.entity;

import com.mojang.authlib.GameProfile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityStellaPlayer extends EntityPlayer
{

	public EntityStellaPlayer(World worldIn, GameProfile gameProfileIn)
	{
		super(worldIn, gameProfileIn);
		this.setSize(0.5F, 0.875F);
	}

	@Override
	public float getEyeHeight()
	{
		return 0.25f;
	}
	
	@Override
	public boolean isSpectator()
	{
		return false;
	}

	@Override
	public boolean isCreative()
	{
		return false;
	}
}
