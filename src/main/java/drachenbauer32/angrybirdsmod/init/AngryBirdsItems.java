package drachenbauer32.angrybirdsmod.init;

import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class AngryBirdsItems 
{
    public static Item red_egg,
                       chuck_egg,
                       blues_egg,
                       bomb_egg,
                       mathilda_egg,
                       terence_egg,
                       silver_egg,
                       bubbles_egg,
                       hal_egg,
                       stella_egg,
                       poppy_egg,
                       willow_egg,
                       dahlia_egg,
                       luca_egg,
                       ice_bird_egg,
                       coral_egg,
                       
                       red_shot,
                       chuck_shot,
                       blues_shot,
                       bomb_shot,
                       mathilda_shot,
                       terence_shot,
                       silver_shot,
                       bubbles_shot,
                       hal_shot,
                       stella_shot,
                       poppy_shot,
                       willow_shot,
                       dahlia_shot,
                       luca_shot,
                       ice_bird_shot,
                       slingshot,
                       
                       egg_block,
                       nest,
                       
                       slingshot_acacia,
                       slingshot_acacia_2,
                       slingshot_birch,
                       slingshot_birch_2,
                       slingshot_dark_oak,
                       slingshot_dark_oak_2,
                       slingshot_jungle,
                       slingshot_jungle_2,
                       slingshot_oak,
                       slingshot_oak_2,
                       slingshot_spruce,
                       slingshot_spruce_2,
                       
                       acacia_planks_frame,
                       birch_planks_frame,
                       dark_oak_planks_frame,
                       jungle_planks_frame,
                       oak_planks_frame,
                       spruce_planks_frame,
                       stone_frame,
                       blue_ice_frame,
                       
                       black_balloon,
                       blue_balloon,
                       brown_balloon,
                       cyan_balloon,
                       gray_balloon,
                       green_balloon,
                       light_blue_balloon,
                       light_gray_balloon,
                       lime_balloon,
                       magenta_balloon,
                       orange_balloon,
                       pink_balloon,
                       purple_balloon,
                       red_balloon,
                       white_balloon,
                       yellow_balloon;
    
    public static final Tag<Item> BIRD_SHOTS = makeWrapperTag("bird_shots");
    
    private static Tag<Item> makeWrapperTag(String p_199901_0_)
    {
        return new ItemTags.Wrapper(new ResourceLocation(p_199901_0_));
    }
}
