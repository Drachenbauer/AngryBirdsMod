package drachenbauer32.angrybirdsmod.entity.render;

import drachenbauer32.angrybirdsmod.entity.EntityBomb;
import drachenbauer32.angrybirdsmod.entity.model.ModelBomb;
import drachenbauer32.angrybirdsmod.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBomb extends RenderLiving<EntityBomb>
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID,"textures/entity/bomb.png");
	
	public RenderBomb(RenderManager manager)
	{
		super(manager, new ModelBomb(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBomb entity)
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityBomb entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
