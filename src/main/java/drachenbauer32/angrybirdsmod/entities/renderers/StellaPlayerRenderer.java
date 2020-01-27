package drachenbauer32.angrybirdsmod.entities.renderers;

import drachenbauer32.angrybirdsmod.entities.StellaPlayerEntity;
import drachenbauer32.angrybirdsmod.entities.models.StellaPlayerModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class StellaPlayerRenderer extends LivingRenderer<StellaPlayerEntity, StellaPlayerModel>
{
    private static final ResourceLocation STELLA_PLAYER_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/stella_player.png");
    
    public StellaPlayerRenderer(EntityRendererManager manager)
    {
        super(manager, new StellaPlayerModel(), 0.5f);
    }
    
    @Override
    public ResourceLocation getEntityTexture(StellaPlayerEntity arg0)
    {
        return STELLA_PLAYER_TEXTURE;
    }
    
    public static class RenderFactory implements IRenderFactory<StellaPlayerEntity>
    {
        @Override
        public EntityRenderer<? super StellaPlayerEntity> createRenderFor(EntityRendererManager manager)
        {
            return new StellaPlayerRenderer(manager);
        }
    }
}
