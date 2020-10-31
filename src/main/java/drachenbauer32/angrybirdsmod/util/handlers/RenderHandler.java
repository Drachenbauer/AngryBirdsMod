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
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.RED.get(), RedRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.CHUCK.get(), ChuckRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.BLUES.get(), BluesTrioRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.BOMB.get(), BombRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.MATHILDA.get(), MathildaRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.TERENCE.get(), TerenceRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.SILVER.get(), SilverRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.BUBBLES.get(), BubblesRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.HAL.get(), HalRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.STELLA.get(), StellaRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.POPPY.get(), PoppyRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.WILLOW.get(), WillowRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.DAHLIA.get(), DahliaRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.LUCA.get(), LucaRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.ICE_BIRD.get(), IceBirdRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.CORAL.get(), CoralRenderer::new);
                
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.RED_SHOT.get(), RedShotRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AngryBirdsEntities.CHUCK_SHOT.get(), ChuckShotRenderer::new);
    }
}
