package drachenbauer32.angrybirdsmod.util;

import drachenbauer32.angrybirdsmod.AngryBirds;
import drachenbauer32.angrybirdsmod.init.AngryBirdsItems;
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
        super.fill(itemStacks);
        itemStacks.sort(AngryBirds.itemSorter);
    }
}
