package drachenbauer32.angrybirdsmod.init;

import java.util.ArrayList;

import net.minecraft.item.Item;

public class ItemInit 
{
	public static ArrayList<Item> ITEMS = new ArrayList<>();
	
	//public static Item SAMPLE ***item names***
	
	public static void initItems()
    {
		//SAMPLE = new ItemSample("sample", 0, ItemGroup.DECORATIONS, 64, EnumRarity.COMMON).addToRegistryList();
    }
	
	//public static final ItemBlock BALLOON_BLOCK = new Item("balloon_block", null);
	
	/*public static void register(RegistryEvent.Register<Item> itemRegistryEvent)
	{
		//ItemBlocks for Blocks
		ITEMS.add(BlockInit.BALLOON_BLOCK.getItemBlock());
		ITEMS.add(BlockInit.EGG_BLOCK.getItemBlock());
		ITEMS.add(BlockInit.NEST_BLOCK.getItemBlock());
		ITEMS.add(BlockInit.SLINGSHOT_BLOCK.getItemBlock());
		ITEMS.add(BlockInit.SLINGSHOT2_BLOCK.getItemBlock());
		
	    // Register Items
	    for(Item i : ITEMS)
	    {
	        itemRegistryEvent.getRegistry().register(i);
	    }
	}*/
}
