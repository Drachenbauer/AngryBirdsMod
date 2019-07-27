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
                       
                       slingshot,
                       red_shot,
                       chuck_shot,
                       
                       balloon_block,
                       egg_block,
                       nest_block,
                       slingshot_block,
                       slingshot2_block;
    
    public static final Tag<Item> BIRD_SHOTS = makeWrapperTag("bird_shots");
    
    private static Tag<Item> makeWrapperTag(String p_199901_0_) {
        return new ItemTags.Wrapper(new ResourceLocation(p_199901_0_));
     }
}
