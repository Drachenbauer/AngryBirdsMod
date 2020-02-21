package drachenbauer32.angrybirdsmod.util.handlers;

import drachenbauer32.angrybirdsmod.entities.renderers.BluesTrioRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.BombRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.BubblesRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.ChuckRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.ChuckShotRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.CoralRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.DahliaRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.HalRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.IceBirdRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.LucaRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.MathildaRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.PoppyRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.RedRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.RedShotRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.SilverRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.StellaRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.TerenceRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.WillowRenderer;
import drachenbauer32.angrybirdsmod.init.AngryBirdsEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class RenderHandler 
{
    public static void regigisterEntityRenders()
    {
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.RED, RedRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.CHUCK, ChuckRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.BLUES, BluesTrioRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.BOMB, BombRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.MATHILDA, MathildaRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.TERENCE, TerenceRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.SILVER, SilverRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.BUBBLES, BubblesRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.HAL, HalRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.STELLA, StellaRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.POPPY, PoppyRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.WILLOW, WillowRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.DAHLIA, DahliaRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.LUCA, LucaRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.ICE_BIRD, IceBirdRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.CORAL, CoralRenderer::new);
                
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.RED_SHOT, RedShotRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.CHUCK_SHOT, ChuckShotRenderer::new);
    }
}
