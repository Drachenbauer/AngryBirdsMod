package drachenbauer32.angrybirdsmod.entity.render;

import drachenbauer32.angrybirdsmod.entity.EntityMathilda;
import drachenbauer32.angrybirdsmod.entity.model.ModelMathilda;
import drachenbauer32.angrybirdsmod.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderMathilda extends RenderLiving<EntityMathilda>
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID,"textures/entity/mathilda.png");
	
	public RenderMathilda(RenderManager manager)
	{
		super(manager, new ModelMathilda(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityMathilda entity)
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityMathilda entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
