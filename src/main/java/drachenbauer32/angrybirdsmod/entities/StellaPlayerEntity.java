package drachenbauer32.angrybirdsmod.entities;

import com.mojang.authlib.GameProfile;

import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.HandSide;

public class StellaPlayerEntity extends AbstractClientPlayerEntity
{
	
	public StellaPlayerEntity(ClientWorld world, GameProfile profile)
    {
        super(world, profile);
    }

	@Override
	public Iterable<ItemStack> getArmorInventoryList()
	{
		return null;
	}

	@Override
	public ItemStack getItemStackFromSlot(EquipmentSlotType slotIn)
	{
		return null;
	}

	@Override
	public void setItemStackToSlot(EquipmentSlotType slotIn, ItemStack stack)
	{
		
	}

	@Override
	public HandSide getPrimaryHand()
	{
		return null;
	}
}
