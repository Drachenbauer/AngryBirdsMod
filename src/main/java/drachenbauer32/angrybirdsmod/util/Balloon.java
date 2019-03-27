package drachenbauer32.angrybirdsmod.util;

import java.util.HashMap;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class Balloon
{
    public EntityPlayer player;
    public ItemStack block;
    public EntityFallingBlock fallingBlock;
    public EntityBat bat;
    public boolean active = false;

    public static HashMap<EntityPlayer, Balloon> balloonHashMap = new HashMap<EntityPlayer, Balloon>();

    public Balloon(EntityPlayer player, ItemStack block)
    {
        this.player = player;
        this.block = block;
    }
    
    public void spawn()
    {
    	active = true;
    	balloonHashMap.put(player, this);
    	final EntityFallingBlock[] fallingBlock =
    	{
    		player.getEntityWorld().spawnFallingBlock(player.getPosition().add(0.0D, 2.0D, 0.0D), this.block.(), this.block.getData().getData())
    	};
    	EntityBat bat = (EntityBat)player.getEntityWorld().spawnEntity(player.getPosition().add(0.0D, 2.0D, 0.0D), EntityType.BAT);
    }
    
    
}
