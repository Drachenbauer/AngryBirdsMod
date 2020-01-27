package drachenbauer32.angrybirdsmod.entities.renderers;

import com.mojang.blaze3d.platform.GlStateManager;

import drachenbauer32.angrybirdsmod.entities.ChuckShotEntity;
import drachenbauer32.angrybirdsmod.entities.models.ChuckShotModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class ChuckShotRenderer extends AbstractBirdStotRenderer<ChuckShotEntity, ChuckShotModel>
{
    private static final ResourceLocation CHUCK_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/chuck.png");
    
    public ChuckShotRenderer(EntityRendererManager manager)
    {
        super(manager, new ChuckShotModel(), 0f);
    }
    
    public float prepareScale(ChuckShotEntity entitylivingbaseIn, float partialTicks)
    {
        GlStateManager.scalef(0.25F, 0.25F, 0.25F);
        return super.prepareScale(entitylivingbaseIn, partialTicks);
    }
    
    @Override
    public ResourceLocation getEntityTexture(ChuckShotEntity arg0)
    {
        return CHUCK_TEXTURE;
    }
    
    public static class RenderFactory implements IRenderFactory<ChuckShotEntity>
    {
        @Override
        public EntityRenderer<? super ChuckShotEntity> createRenderFor(EntityRendererManager manager)
        {
            return new ChuckShotRenderer(manager);
        }
    }
}
