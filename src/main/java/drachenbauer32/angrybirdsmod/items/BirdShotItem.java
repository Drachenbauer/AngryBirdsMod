package drachenbauer32.angrybirdsmod.items;

import drachenbauer32.angrybirdsmod.entities.BirdShotEntity;
import drachenbauer32.angrybirdsmod.entities.ChuckShotEntity;
import drachenbauer32.angrybirdsmod.entities.RedShotEntity;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BirdShotItem extends Item
{
    private String name;
    
    public BirdShotItem(String name, Item.Properties builder)
    {
        super(builder);
        setRegistryName(Reference.MOD_ID, name);
        this.name = name;
    }
    
    public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter)
    {
        BirdShotEntity birdshotentity;
        
        if(name.equals("ice_bird_shot"))
        {
            birdshotentity = new ChuckShotEntity(worldIn, shooter);
        }
        else
        {
            if(name.equals("luca_shot"))
            {
                birdshotentity = new ChuckShotEntity(worldIn, shooter);
            }
            else
            {
                if(name.equals("dahlia_shot"))
                {
                    birdshotentity = new ChuckShotEntity(worldIn, shooter);
                }
                else
                {
                    if(name.equals("willow_shot"))
                    {
                        birdshotentity = new ChuckShotEntity(worldIn, shooter);
                    }
                    else
                    {
                        if(name.equals("poppy_shot"))
                        {
                            birdshotentity = new ChuckShotEntity(worldIn, shooter);
                        }
                        else
                        {
                            if(name.equals("stella_shot"))
                            {
                                birdshotentity = new ChuckShotEntity(worldIn, shooter);
                            }
                            else
                            {
                                if(name.equals("hal_shot"))
                                {
                                    birdshotentity = new ChuckShotEntity(worldIn, shooter);
                                }
                                else
                                {
                                    if(name.equals("bubbles_shot"))
                                    {
                                        birdshotentity = new ChuckShotEntity(worldIn, shooter);
                                    }
                                    else
                                    {
                                        if(name.equals("silver_shot"))
                                        {
                                            birdshotentity = new ChuckShotEntity(worldIn, shooter);
                                        }
                                        else
                                        {
                                            if(name.equals("terence_shot"))
                                            {
                                                birdshotentity = new ChuckShotEntity(worldIn, shooter);
                                            }
                                            else
                                            {
                                                if(name.equals("mathilda_shot"))
                                                {
                                                    birdshotentity = new ChuckShotEntity(worldIn, shooter);
                                                }
                                                else
                                                {
                                                    if(name.equals("bomb_shot"))
                                                    {
                                                        birdshotentity = new ChuckShotEntity(worldIn, shooter);
                                                    }
                                                    else
                                                    {
                                                        if(name.equals("blues_shot"))
                                                        {
                                                            birdshotentity = new ChuckShotEntity(worldIn, shooter);
                                                        }
                                                        else
                                                        {
                                                            if(name.equals("chuck_shot"))
                                                            {
                                                                birdshotentity = new ChuckShotEntity(worldIn, shooter);
                                                            }
                                                            else
                                                            {
                                                                birdshotentity = new RedShotEntity(worldIn, shooter);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        birdshotentity.setPotionEffect(stack);
        return birdshotentity;
    }
    
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player)
    {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.enchantment.Enchantments.INFINITY, bow);
        return enchant <= 0 ? false : this.getClass() == BirdShotItem.class;
    }
}
