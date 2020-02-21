package drachenbauer32.angrybirdsmod.entities.renderers;

import drachenbauer32.angrybirdsmod.entities.models.StellaMoviePlayerModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StellaMoviePlayerRenderer extends PlayerRenderer
{
    private static final ResourceLocation STELLA_MOVIE_PLAYER_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/stella_movie_player.png");
    
    public StellaMoviePlayerRenderer(EntityRendererManager renderManager)
    {
        super(renderManager);
    }
    
    @Override
    public ResourceLocation getEntityTexture(AbstractClientPlayerEntity entity)
    {
        return STELLA_MOVIE_PLAYER_TEXTURE;
    }
    
    @Override
    public PlayerModel<AbstractClientPlayerEntity> getEntityModel()
    {
        return new StellaMoviePlayerModel<AbstractClientPlayerEntity>(1f, false);
    }
}
