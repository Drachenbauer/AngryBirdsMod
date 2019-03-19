package drachenbauer32.angrybirdsmod.entity;

import com.mojang.authlib.GameProfile;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraft.world.World;

public class EntityStellaPlayer extends AbstractClientPlayer
{

	public EntityStellaPlayer(World worldIn, GameProfile playerProfile) {
		super(worldIn, playerProfile);
		this.setSize(0.5F, 0.875F);
	}

	@Override
	public float getEyeHeight()
	{
		return 0.25f;
	}

	@Override
	public Iterable<ItemStack> getArmorInventoryList()
	{
		return null;
	}

	@Override
	public ItemStack getItemStackFromSlot(EntityEquipmentSlot slotIn)
	{
		return null;
	}

	@Override
	public void setItemStackToSlot(EntityEquipmentSlot slotIn, ItemStack stack)
	{
		
	}

	@Override
	public EnumHandSide getPrimaryHand()
	{
		return null;
	}
}
