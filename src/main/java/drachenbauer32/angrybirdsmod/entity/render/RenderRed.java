package drachenbauer32.angrybirdsmod.entity.render;

import drachenbauer32.angrybirdsmod.entity.EntityRed;
import drachenbauer32.angrybirdsmod.entity.model.ModelRed;
import drachenbauer32.angrybirdsmod.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderRed extends RenderLiving<EntityRed>
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID,"textures/entity/red.png");
	
	public RenderRed(RenderManager manager)
	{
		super(manager, new ModelRed(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityRed entity)
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityRed entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
