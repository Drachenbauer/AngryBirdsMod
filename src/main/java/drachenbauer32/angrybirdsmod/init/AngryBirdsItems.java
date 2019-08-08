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
                       
                       balloon_block,
                       egg_block,
                       nest_block,
                       slingshot_acacia_block,
                       slingshot_acacia_2_block,
                       slingshot_birch_block,
                       slingshot_birch_2_block,
                       slingshot_dark_oak_block,
                       slingshot_dark_oak_2_block,
                       slingshot_jungle_block,
                       slingshot_jungle_2_block,
                       slingshot_oak_block,
                       slingshot_oak_2_block,
                       slingshot_spruce_block,
                       slingshot_spruce_2_block,
                       acacia_planks_frame_block,
                       birch_planks_frame_block,
                       dark_oak_planks_frame_block,
                       jungle_planks_frame_block,
                       oak_planks_frame_block,
                       spruce_planks_frame_block,
                       stone_frame_block,
                       blue_ice_frame_block;
    
    public static final Tag<Item> BIRD_SHOTS = makeWrapperTag("bird_shots");
    
    private static Tag<Item> makeWrapperTag(String p_199901_0_) {
        return new ItemTags.Wrapper(new ResourceLocation(p_199901_0_));
     }
}
