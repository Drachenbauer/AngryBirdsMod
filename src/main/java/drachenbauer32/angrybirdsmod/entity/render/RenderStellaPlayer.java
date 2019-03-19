package drachenbauer32.angrybirdsmod.entity.render;

import drachenbauer32.angrybirdsmod.entity.EntityStellaPlayer;
import drachenbauer32.angrybirdsmod.entity.model.ModelStellaPlayer;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.util.ResourceLocation;

public class RenderStellaPlayer extends RenderLivingBase<EntityStellaPlayer>
{
	public RenderStellaPlayer(RenderManager manager, ModelBase modelBaseIn, float shadowSizeIn) {
		super(manager, new ModelStellaPlayer(), 0.5f);
	}

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID,"textures/entity/stella_player.png");
	
	@Override
	protected ResourceLocation getEntityTexture(EntityStellaPlayer entity)
	{
		return TEXTURES;
	}
}
