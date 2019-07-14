package drachenbauer32.angrybirdsmod.util.handlers;

import drachenbauer32.angrybirdsmod.entities.BluesEntity;
import drachenbauer32.angrybirdsmod.entities.BombEntity;
import drachenbauer32.angrybirdsmod.entities.ChuckEntity;
import drachenbauer32.angrybirdsmod.entities.MathildaEntity;
import drachenbauer32.angrybirdsmod.entities.RedEntity;
import drachenbauer32.angrybirdsmod.entities.SilverEntity;
import drachenbauer32.angrybirdsmod.entities.TerenceEntity;
import drachenbauer32.angrybirdsmod.entities.renderers.BluesRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.BombRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.ChuckRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.MathildaRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.RedRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.SilverRenderer;
import drachenbauer32.angrybirdsmod.entities.renderers.TerenceRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class RenderHandler 
{
	public static void regigisterEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(RedEntity.class,new RedRenderer.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(ChuckEntity.class,new ChuckRenderer.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(BluesEntity.class,new BluesRenderer.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(BombEntity.class,new BombRenderer.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(MathildaEntity.class,new MathildaRenderer.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(TerenceEntity.class,new TerenceRenderer.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(SilverEntity.class,new SilverRenderer.RenderFactory());
	}
}
