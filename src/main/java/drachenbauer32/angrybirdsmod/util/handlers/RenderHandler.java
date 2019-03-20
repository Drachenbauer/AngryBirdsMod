package drachenbauer32.angrybirdsmod.util.handlers;

import drachenbauer32.angrybirdsmod.entity.EntityBlues;
import drachenbauer32.angrybirdsmod.entity.EntityBomb;
import drachenbauer32.angrybirdsmod.entity.EntityChuck;
import drachenbauer32.angrybirdsmod.entity.EntityMathilda;
import drachenbauer32.angrybirdsmod.entity.EntityRed;
import drachenbauer32.angrybirdsmod.entity.render.RenderBlues;
import drachenbauer32.angrybirdsmod.entity.render.RenderBomb;
import drachenbauer32.angrybirdsmod.entity.render.RenderChuck;
import drachenbauer32.angrybirdsmod.entity.render.RenderMathilda;
import drachenbauer32.angrybirdsmod.entity.render.RenderRed;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler 
{
	public static void regigisterEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityRed.class,(RenderManager manager) -> new RenderRed(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityChuck.class,(RenderManager manager) -> new RenderChuck(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlues.class,(RenderManager manager) -> new RenderBlues(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityBomb.class,(RenderManager manager) -> new RenderBomb(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityMathilda.class,(RenderManager manager) -> new RenderMathilda(manager));
	}
}
