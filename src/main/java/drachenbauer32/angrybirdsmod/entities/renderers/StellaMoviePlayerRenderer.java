package drachenbauer32.angrybirdsmod.entities.renderers;

import drachenbauer32.angrybirdsmod.entities.StellaMoviePlayerEntity;
import drachenbauer32.angrybirdsmod.entities.models.StellaMoviePlayerModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class StellaMoviePlayerRenderer extends LivingRenderer<StellaMoviePlayerEntity, StellaMoviePlayerModel>
{
    private static final ResourceLocation STELLA_MOVIE_PLAYER_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/stella_movie_player.png");
    
    public StellaMoviePlayerRenderer(EntityRendererManager manager)
    {
        super(manager, new StellaMoviePlayerModel(), 0.5f);
    }
    
    @Override
    public ResourceLocation getEntityTexture(StellaMoviePlayerEntity arg0)
    {
        return STELLA_MOVIE_PLAYER_TEXTURE;
    }
    
    public static class RenderFactory implements IRenderFactory<StellaMoviePlayerEntity>
    {
        @Override
        public EntityRenderer<? super StellaMoviePlayerEntity> createRenderFor(EntityRendererManager manager)
        {
            return new StellaMoviePlayerRenderer(manager);
        }
    }
}
