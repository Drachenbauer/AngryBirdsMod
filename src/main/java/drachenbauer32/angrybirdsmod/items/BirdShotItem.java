package drachenbauer32.angrybirdsmod.items;

import drachenbauer32.angrybirdsmod.entities.BirdShotEntity;
import drachenbauer32.angrybirdsmod.entities.ChuckShotEntity;
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
        BirdShotEntity bird_shot_entity;
        
        String name = this.getRegistryName().toString();
        
        if(name.equals("ice_bird_shot"))
        {
            bird_shot_entity = new ChuckShotEntity(worldIn, shooter);
        }
        else
        {
            if(name.equals("luca_shot"))
            {
                bird_shot_entity = new ChuckShotEntity(worldIn, shooter);
            }
            else
            {
                if(name.equals("dahlia_shot"))
                {
                    bird_shot_entity = new ChuckShotEntity(worldIn, shooter);
                }
                else
                {
                    if(name.equals("willow_shot"))
                    {
                        bird_shot_entity = new ChuckShotEntity(worldIn, shooter);
                    }
                    else
                    {
                        if(name.equals("poppy_shot"))
                        {
                            bird_shot_entity = new ChuckShotEntity(worldIn, shooter);
                        }
                        else
                        {
                            if(name.equals("stella_shot"))
                            {
                                bird_shot_entity = new ChuckShotEntity(worldIn, shooter);
                            }
                            else
                            {
                                if(name.equals("hal_shot"))
                                {
                                    bird_shot_entity = new ChuckShotEntity(worldIn, shooter);
                                }
                                else
                                {
                                    if(name.equals("bubbles_shot"))
                                    {
                                        bird_shot_entity = new ChuckShotEntity(worldIn, shooter);
                                    }
                                    else
                                    {
                                        if(name.equals("silver_shot"))
                                        {
                                            bird_shot_entity = new ChuckShotEntity(worldIn, shooter);
                                        }
                                        else
                                        {
                                            if(name.equals("terence_shot"))
                                            {
                                                bird_shot_entity = new ChuckShotEntity(worldIn, shooter);
                                            }
                                            else
                                            {
                                                if(name.equals("mathilda_shot"))
                                                {
                                                    bird_shot_entity = new ChuckShotEntity(worldIn, shooter);
                                                }
                                                else
                                                {
                                                    if(name.equals("bomb_shot"))
                                                    {
                                                        bird_shot_entity = new ChuckShotEntity(worldIn, shooter);
                                                    }
                                                    else
                                                    {
                                                        if(name.equals("blues_shot"))
                                                        {
                                                            bird_shot_entity = new ChuckShotEntity(worldIn, shooter);
                                                        }
                                                        else
                                                        {
                                                            if(name.equals("chuck_shot"))
                                                            {
                                                                bird_shot_entity = new ChuckShotEntity(worldIn, shooter);
                                                            }
                                                            else
                                                            {
                                                                bird_shot_entity = new RedShotEntity(worldIn, shooter);
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
        
        bird_shot_entity.setPotionEffect(stack);
        return bird_shot_entity;
    }
    
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player)
    {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.enchantment.Enchantments.INFINITY, bow);
        return enchant <= 0 ? false : this.getClass() == BirdShotItem.class;
    }
}
