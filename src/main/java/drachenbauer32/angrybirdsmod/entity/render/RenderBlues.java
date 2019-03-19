package drachenbauer32.angrybirdsmod.entity.render;

import org.lwjgl.opengl.GL11;

import drachenbauer32.angrybirdsmod.entity.EntityBlues;
import drachenbauer32.angrybirdsmod.entity.model.ModelBluesTrio;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBlues extends RenderLiving<EntityBlues>
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID,"textures/entity/blues_trio.png");
	
	public RenderBlues(RenderManager manager)
	{
		super(manager, new ModelBluesTrio(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBlues entity)
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityBlues entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
	
	@Override
	protected void preRenderCallback(EntityBlues entitylivingbaseIn, float partialTickTime)
	{
	      float f = 0.5F;
	      GlStateManager.scalef(f, f, f);
	}
	
	/*public float prepareScale(EntityBlues entitylivingbaseIn, float partialTicks)
	{
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		return super.prepareScale(entitylivingbaseIn, partialTicks);
	}*/
}
