package drachenbauer32.angrybirdsmod.util;

import java.util.Arrays;
import java.util.List;

import drachenbauer32.angrybirdsmod.AngryBirds;
import drachenbauer32.angrybirdsmod.init.AngryBirdsItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class AngryBirdsItemGroup extends ItemGroup
{
    public AngryBirdsItemGroup()
    {
        super("AngryBirds");
    }
    
    @Override
    public ItemStack createIcon()
    {
        return new ItemStack(AngryBirdsItems.nest_block);
    }
    
    @Override
    public void fill(NonNullList<ItemStack> itemStacks)
    {
        List<Item> items = Arrays.asList(AngryBirdsItems.red_egg,
                                         AngryBirdsItems.chuck_egg,
                                         AngryBirdsItems.blues_egg,
                                         AngryBirdsItems.bomb_egg,
                                         AngryBirdsItems.mathilda_egg,
                                         AngryBirdsItems.terence_egg,
                                         AngryBirdsItems.silver_egg,
                                         AngryBirdsItems.bubbles_egg,
                                         AngryBirdsItems.hal_egg,
                                         AngryBirdsItems.stella_egg,
                                         AngryBirdsItems.poppy_egg,
                                         AngryBirdsItems.willow_egg,
                                         AngryBirdsItems.dahlia_egg,
                                         AngryBirdsItems.luca_egg,
                                         AngryBirdsItems.ice_bird_egg,
                                         
                                         AngryBirdsItems.slingshot,
                                         AngryBirdsItems.red_shot,
                                         AngryBirdsItems.chuck_shot,
                                         AngryBirdsItems.blues_shot,
                                         AngryBirdsItems.bomb_shot,
                                         AngryBirdsItems.mathilda_shot,
                                         AngryBirdsItems.terence_shot,
                                         AngryBirdsItems.silver_shot,
                                         AngryBirdsItems.bubbles_shot,
                                         AngryBirdsItems.hal_shot,
                                         AngryBirdsItems.stella_shot,
                                         AngryBirdsItems.poppy_shot,
                                         AngryBirdsItems.willow_shot,
                                         AngryBirdsItems.dahlia_shot,
                                         AngryBirdsItems.luca_shot,
                                         AngryBirdsItems.ice_bird_shot,
                                           
                                         AngryBirdsItems.balloon_block,
                                         AngryBirdsItems.egg_block,
                                         AngryBirdsItems.nest_block,
                                         AngryBirdsItems.slingshot_acacia_block,
                                         AngryBirdsItems.slingshot_acacia_2_block,
                                         AngryBirdsItems.slingshot_birch_block,
                                         AngryBirdsItems.slingshot_birch_2_block,
                                         AngryBirdsItems.slingshot_dark_oak_block,
                                         AngryBirdsItems.slingshot_dark_oak_2_block,
                                         AngryBirdsItems.slingshot_jungle_block,
                                         AngryBirdsItems.slingshot_jungle_2_block,
                                         AngryBirdsItems.slingshot_oak_block,
                                         AngryBirdsItems.slingshot_oak_2_block,
                                         AngryBirdsItems.slingshot_spruce_block,
                                         AngryBirdsItems.slingshot_spruce_2_block,
                                         AngryBirdsItems.acacia_planks_frame_block,
                                         AngryBirdsItems.birch_planks_frame_block,
                                         AngryBirdsItems.dark_oak_planks_frame_block,
                                         AngryBirdsItems.jungle_planks_frame_block,
                                         AngryBirdsItems.oak_planks_frame_block,
                                         AngryBirdsItems.spruce_planks_frame_block,
                                         AngryBirdsItems.stone_frame_block,
                                         AngryBirdsItems.blue_ice_frame_block);
        
        itemStacks.clear();
        
        for (Item item : items)
        {
            if(item.getCreativeTabs().contains(AngryBirds.RegistryEvents.ANGRY_BIRDS))
            {
                itemStacks.add(new ItemStack(item));
            }
        }
    }
}
