package drachenbauer32.angrybirdsmod.entity.render;

import drachenbauer32.angrybirdsmod.entity.EntityChuck;
import drachenbauer32.angrybirdsmod.entity.model.ModelChuck;
import drachenbauer32.angrybirdsmod.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderChuck extends RenderLiving<EntityChuck>
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID,"textures/entity/chuck.png");
	
	public RenderChuck(RenderManager manager)
	{
		super(manager, new ModelChuck(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityChuck entity)
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityChuck entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
