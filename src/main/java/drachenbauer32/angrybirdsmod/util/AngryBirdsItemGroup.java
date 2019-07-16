package drachenbauer32.angrybirdsmod.util;

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
    
    /*public void displayAllRelevantItems(NonNullList<ItemStack> items)
    {
        super.displayAllRelevantItems(items);
        items.sort(tabSorter);
    }*/
}
