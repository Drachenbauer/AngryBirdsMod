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

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler 
{
	public static void regigisterEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityRed.class, new IRenderFactory<EntityRed>()
		{
			@Override
			public Render<? super EntityRed> createRenderFor(RenderManager manager)
			{
				return new RenderRed(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityChuck.class, new IRenderFactory<EntityChuck>()
		{
			@Override
			public Render<? super EntityChuck> createRenderFor(RenderManager manager)
			{
				return new RenderChuck(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBlues.class, new IRenderFactory<EntityBlues>()
		{
			@Override
			public Render<? super EntityBlues> createRenderFor(RenderManager manager)
			{
				return new RenderBlues(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBomb.class, new IRenderFactory<EntityBomb>()
		{
			@Override
			public Render<? super EntityBomb> createRenderFor(RenderManager manager)
			{
				return new RenderBomb(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityMathilda.class, new IRenderFactory<EntityMathilda>()
		{
			@Override
			public Render<? super EntityMathilda> createRenderFor(RenderManager manager)
			{
				return new RenderMathilda(manager);
			}
		});
	}
}
