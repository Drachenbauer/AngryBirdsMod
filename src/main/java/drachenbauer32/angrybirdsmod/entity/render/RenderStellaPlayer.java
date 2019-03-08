package drachenbauer32.angrybirdsmod.entity.render;

import drachenbauer32.angrybirdsmod.entity.EntityStellaPlayer;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.util.ResourceLocation;

public class RenderStellaPlayer extends RenderPlayer
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID,"textures/entity/stella_player.png");
	
	protected RenderStellaPlayer(RenderManager manager)
	{
		super(manager);
	}

	protected ResourceLocation getEntityTexture(EntityStellaPlayer arg0)
	{
		return TEXTURES;
	}

}
