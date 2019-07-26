package drachenbauer32.angrybirdsmod.items;

import drachenbauer32.angrybirdsmod.entities.BirdShotEntity;
import drachenbauer32.angrybirdsmod.entities.RedShotEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BirdShotItem extends Item
{
    public BirdShotItem(Item.Properties builder)
    {
        super(builder);
    }
    
    public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter)
    {
        BirdShotEntity birdshotentity = new RedShotEntity(worldIn, shooter);
        birdshotentity.setPotionEffect(stack);
        return birdshotentity;
    }
    
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player)
    {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.enchantment.Enchantments.INFINITY, bow);
        return enchant <= 0 ? false : this.getClass() == BirdShotItem.class;
    }
}
