package drachenbauer32.angrybirdsmod.util.handlers;

import drachenbauer32.angrybirdsmod.entities.BluesEntity;
import drachenbauer32.angrybirdsmod.entities.BombEntity;
import drachenbauer32.angrybirdsmod.entities.ChuckEntity;
import drachenbauer32.angrybirdsmod.entities.MathildaEntity;
import drachenbauer32.angrybirdsmod.entities.RedEntity;
import drachenbauer32.angrybirdsmod.entities.renders.BluesRender;
import drachenbauer32.angrybirdsmod.entities.renders.BombRender;
import drachenbauer32.angrybirdsmod.entities.renders.ChuckRender;
import drachenbauer32.angrybirdsmod.entities.renders.MathildaRender;
import drachenbauer32.angrybirdsmod.entities.renders.RedRender;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class RenderHandler 
{
	public static void regigisterEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(RedEntity.class,new RedRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(ChuckEntity.class,new ChuckRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(BluesEntity.class,new BluesRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(BombEntity.class,new BombRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(MathildaEntity.class,new MathildaRender.RenderFactory());
	}
}
