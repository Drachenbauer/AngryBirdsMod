package drachenbauer32.angrybirdsmod;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Ordering;

import drachenbauer32.angrybirdsmod.entities.renderers.StellaMoviePlayerRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.StellaPlayerRenderer;
import drachenbauer32.angrybirdsmod.init.AngryBirdsBlocks;
import drachenbauer32.angrybirdsmod.init.AngryBirdsEntities;
import drachenbauer32.angrybirdsmod.init.AngryBirdsItems;
import drachenbauer32.angrybirdsmod.init.AngryBirdsTileEntities;
import drachenbauer32.angrybirdsmod.items.SupplierSpawnEggItem;
import drachenbauer32.angrybirdsmod.util.AngryBirdsItemGroup;
import drachenbauer32.angrybirdsmod.util.Reference;
import drachenbauer32.angrybirdsmod.util.handlers.RenderHandler;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MOD_ID)
public class AngryBirds
{   
    public static final ItemGroup ANGRY_BIRDS = new AngryBirdsItemGroup();
    
    public static Comparator<ItemStack> itemSorter;
    
    private static StellaPlayerRenderer stella_player_renderer = new StellaPlayerRenderer(null);
    private static StellaMoviePlayerRenderer stella_movie_player_renderer = new StellaMoviePlayerRenderer(null);
    
    public AngryBirds() 
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
        AngryBirdsBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        AngryBirdsItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        AngryBirdsEntities.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        AngryBirdsTileEntities.TILE_ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    private void setup(final FMLCommonSetupEvent event)
    {
        List<Item> items = Arrays.asList(AngryBirdsItems.RED_EGG.get(),
                                         AngryBirdsItems.CHUCK_EGG.get(),
                                         AngryBirdsItems.BLUES_EGG.get(),
                                         AngryBirdsItems.BOMB_EGG.get(),
                                         AngryBirdsItems.MATHILDA_EGG.get(),
                                         AngryBirdsItems.TERENCE_EGG.get(),
                                         AngryBirdsItems.SILVER_EGG.get(),
                                         AngryBirdsItems.BUBBLES_EGG.get(),
                                         AngryBirdsItems.HAL_EGG.get(),
                                         AngryBirdsItems.STELLA_EGG.get(),
                                         AngryBirdsItems.POPPY_EGG.get(),
                                         AngryBirdsItems.WILLOW_EGG.get(),
                                         AngryBirdsItems.DAHLIA_EGG.get(),
                                         AngryBirdsItems.LUCA_EGG.get(),
                                         AngryBirdsItems.ICE_BIRD_EGG.get(),
                                         AngryBirdsItems.CORAL_EGG.get(),
                                         
                                         AngryBirdsItems.RED_SHOT.get(),
                                         AngryBirdsItems.CHUCK_SHOT.get(),
                                         AngryBirdsItems.BLUES_SHOT.get(),
                                         AngryBirdsItems.BOMB_SHOT.get(),
                                         AngryBirdsItems.MATHILDA_SHOT.get(),
                                         AngryBirdsItems.TERENCE_SHOT.get(),
                                         AngryBirdsItems.SILVER_SHOT.get(),
                                         AngryBirdsItems.BUBBLES_SHOT.get(),
                                         AngryBirdsItems.HAL_SHOT.get(),
                                         AngryBirdsItems.STELLA_SHOT.get(),
                                         AngryBirdsItems.POPPY_SHOT.get(),
                                         AngryBirdsItems.WILLOW_SHOT.get(),
                                         AngryBirdsItems.DAHLIA_SHOT.get(),
                                         AngryBirdsItems.LUCA_SHOT.get(),
                                         AngryBirdsItems.ICE_BIRD_SHOT.get(),
                                         AngryBirdsItems.SLINGSHOT.get(),
                                         
                                         AngryBirdsItems.EGG_BLOCK.get(),
                                         AngryBirdsItems.NEST.get(),
                                         
                                         AngryBirdsItems.SLINGSHOT_ACACIA.get(),
                                         AngryBirdsItems.SLINGSHOT_ACACIA_2.get(),
                                         AngryBirdsItems.SLINGSHOT_BIRCH.get(),
                                         AngryBirdsItems.SLINGSHOT_BIRCH_2.get(),
                                         AngryBirdsItems.SLINGSHOT_DARK_OAK.get(),
                                         AngryBirdsItems.SLINGSHOT_DARK_OAK_2.get(),
                                         AngryBirdsItems.SLINGSHOT_JUNGLE.get(),
                                         AngryBirdsItems.SLINGSHOT_JUNGLE_2.get(),
                                         AngryBirdsItems.SLINGSHOT_OAK.get(),
                                         AngryBirdsItems.SLINGSHOT_OAK_2.get(),
                                         AngryBirdsItems.SLINGSHOT_SPRUCE.get(),
                                         AngryBirdsItems.SLINGSHOT_SPRUCE_2.get(),
                                         
                                         AngryBirdsItems.ACACIA_PLANKS_FRAME.get(),
                                         AngryBirdsItems.BIRCH_PLANKS_FRAME.get(),
                                         AngryBirdsItems.DARK_OAK_PLANKS_FRAME.get(),
                                         AngryBirdsItems.JUNGlE_PLANKS_FRAME.get(),
                                         AngryBirdsItems.OAK_PLANKS_FRAME.get(),
                                         AngryBirdsItems.SPRUCE_PLANKS_FRAME.get(),
                                         AngryBirdsItems.STONE_FRAME.get(),
                                         AngryBirdsItems.BLUE_ICE_FRAME.get(),
                                         
                                         AngryBirdsItems.RED_BALLOON.get(),
                                         AngryBirdsItems.ORANGE_BALLOON.get(),
                                         AngryBirdsItems.YELLOW_BALLOON.get(),
                                         AngryBirdsItems.LIME_BALLOON.get(),
                                         AngryBirdsItems.CYAN_BALLOON.get(),
                                         AngryBirdsItems.BLUE_BALLOON.get(),
                                         AngryBirdsItems.PURPLE_BALLOON.get(),
                                         AngryBirdsItems.MAGENTA_BALLOON.get(),
                                         AngryBirdsItems.PINK_BALLOON.get(),
                                         AngryBirdsItems.LIGHT_BLUE_BALLOON.get(),
                                         AngryBirdsItems.GREEN_BALLOON.get(),
                                         AngryBirdsItems.BROWN_BALLOON.get(),
                                         AngryBirdsItems.BLACK_BALLOON.get(),
                                         AngryBirdsItems.GRAY_BALLOON.get(),
                                         AngryBirdsItems.LIGHT_GRAY_BALLOON.get(),
                                         AngryBirdsItems.WHITE_BALLOON.get());
        
        itemSorter = Ordering.explicit(items).onResultOf(ItemStack::getItem);
    }
    
    private void clientRegistries(final FMLClientSetupEvent event)
    {
        RenderHandler.regigisterEntityRenders();
    }
    
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        public static IBlockColor blockColor;
        
        public static IItemColor itemColor;
        
        @SubscribeEvent
		public static void onRenderPlayer(RenderPlayerEvent.Pre event)
		{
			event.setCanceled(true);
			//event.getRenderer().render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			
			//stella_movie_player_renderer.render((AbstractClientPlayerEntity) event.getPlayer(), event.getX(), event.getY(), event.getZ(), event.getEntity().rotationYaw, event.getPartialRenderTick());
			//StellaMoviePlayerRenderer.render(null, 0, 0, null, null, 0);
		}
        
        //@SubscribeEvent(priority=normal)
        
        @SubscribeEvent
        public static void registerBlockColors(final ColorHandlerEvent.Block event)
        {
            event.getBlockColors().register(blockColor, AngryBirdsBlocks.SLINGSHOT_BIRCH.get(),
                                                        AngryBirdsBlocks.SLINGSHOT_BIRCH_2.get(),
                                                        AngryBirdsBlocks.SLINGSHOT_BIRCH.get(),
                                                        AngryBirdsBlocks.SLINGSHOT_BIRCH_2.get(),
                                                        AngryBirdsBlocks.SLINGSHOT_DARK_OAK.get(),
                                                        AngryBirdsBlocks.SLINGSHOT_DARK_OAK_2.get(),
                                                        AngryBirdsBlocks.SLINGSHOT_JUNGLE.get(),
                                                        AngryBirdsBlocks.SLINGSHOT_JUNGLE_2.get(),
                                                        AngryBirdsBlocks.SLINGSHOT_OAK.get(),
                                                        AngryBirdsBlocks.SLINGSHOT_OAK_2.get(),
                                                        AngryBirdsBlocks.SLINGSHOT_SPRUCE.get(),
                                                        AngryBirdsBlocks.SLINGSHOT_SPRUCE_2.get());
        }
        
        @SubscribeEvent
        public static void registerItemColors(final ColorHandlerEvent.Item event)
        {
            event.getItemColors().register(itemColor, AngryBirdsItems.SLINGSHOT_BIRCH.get(),
                                                      AngryBirdsItems.SLINGSHOT_BIRCH_2.get(),
                                                      AngryBirdsItems.SLINGSHOT_BIRCH.get(),
                                                      AngryBirdsItems.SLINGSHOT_BIRCH_2.get(),
                                                      AngryBirdsItems.SLINGSHOT_DARK_OAK.get(),
                                                      AngryBirdsItems.SLINGSHOT_DARK_OAK_2.get(),
                                                      AngryBirdsItems.SLINGSHOT_JUNGLE.get(),
                                                      AngryBirdsItems.SLINGSHOT_JUNGLE_2.get(),
                                                      AngryBirdsItems.SLINGSHOT_OAK.get(),
                                                      AngryBirdsItems.SLINGSHOT_OAK_2.get(),
                                                      AngryBirdsItems.SLINGSHOT_SPRUCE.get(),
                                                      AngryBirdsItems.SLINGSHOT_SPRUCE_2.get());
        }
        
        @SubscribeEvent(priority = EventPriority.LOWEST)
        public static void onPostRegisterEntities(final RegistryEvent.Register<EntityType<?>> event)
        {
            SupplierSpawnEggItem.initUnaddedEggs();
        }
    }
}
