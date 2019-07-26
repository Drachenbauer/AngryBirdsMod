package drachenbauer32.angrybirdsmod.items;

import drachenbauer32.angrybirdsmod.init.AngryBirdsItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class SlingshotItem extends BowItem
{
    public SlingshotItem(Item.Properties builder)
    {
        super(builder);
    }
    
    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     */
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft)
    {
        if (entityLiving instanceof PlayerEntity)
        {
            PlayerEntity playerentity = (PlayerEntity)entityLiving;
            boolean flag = playerentity.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
            ItemStack itemstack = playerentity.findAmmo(stack);
            
            int i = this.getUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerentity, i, !itemstack.isEmpty() || flag);
            
            if (i < 0)
            {
                return;
            }
            
            if (!itemstack.isEmpty() || flag)
            {
                if (itemstack.isEmpty())
                {
                    itemstack = new ItemStack(AngryBirdsItems.red_shot);
                }
                
                float f = getArrowVelocity(i);
                
                if (!((double)f < 0.1D))
                {
                    boolean flag1 = playerentity.abilities.isCreativeMode || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, stack, playerentity));
                    
                    if (!worldIn.isRemote)
                    {
                        BirdShotItem birdshotitem = (BirdShotItem)(itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
                        AbstractArrowEntity abstractbirdshotentity = birdshotitem.createArrow(worldIn, itemstack, playerentity);
                        abstractbirdshotentity = customeBird(abstractbirdshotentity);
                        abstractbirdshotentity.shoot(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F, f * 3.0F, 1.0F);
                        
                        if (f == 1.0F)
                        {
                            abstractbirdshotentity.setIsCritical(true);
                        }
                        
                        int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
                        
                        if (j > 0)
                        {
                            abstractbirdshotentity.setDamage(abstractbirdshotentity.getDamage() + (double)j * 0.5D + 0.5D);
                        }
                        
                        int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
                        
                        if (k > 0)
                        {
                            abstractbirdshotentity.setKnockbackStrength(k);
                        }
                        
                        if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0)
                        {
                            abstractbirdshotentity.setFire(100);
                        }
                        
                        stack.damageItem(1, playerentity, (p_220009_1_) ->
                        {
                            p_220009_1_.sendBreakAnimation(playerentity.getActiveHand());
                        }
                                );
                        
                        if (flag1 || playerentity.abilities.isCreativeMode && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW))
                        {
                            abstractbirdshotentity.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
                        }
                        
                        worldIn.addEntity(abstractbirdshotentity);
                    }
                    
                    worldIn.playSound((PlayerEntity)null, playerentity.posX, playerentity.posY, playerentity.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    
                    if (!flag1 && !playerentity.abilities.isCreativeMode)
                    {
                        itemstack.shrink(1);
                        
                        if (itemstack.isEmpty())
                        {
                            playerentity.inventory.deleteStack(itemstack);
                        }
                    }
                    
                    playerentity.addStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }
    
    public AbstractArrowEntity customeBird(AbstractArrowEntity abstractbirdshotentity)
    {
        return abstractbirdshotentity;
    }
}