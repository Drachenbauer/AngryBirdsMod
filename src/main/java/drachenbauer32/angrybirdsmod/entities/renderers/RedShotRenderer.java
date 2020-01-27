package drachenbauer32.angrybirdsmod.entities.renderers;

import com.mojang.blaze3d.platform.GlStateManager;

import drachenbauer32.angrybirdsmod.entities.RedShotEntity;
import drachenbauer32.angrybirdsmod.entities.models.RedShotModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class RedShotRenderer extends AbstractBirdStotRenderer<RedShotEntity, RedShotModel>
{
    private static final ResourceLocation RED_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/red.png");
    
    public RedShotRenderer(EntityRendererManager manager)
    {
        super(manager, new RedShotModel(), 0f);
    }
    
    public float prepareScale(RedShotEntity entitylivingbaseIn, float partialTicks)
    {
        GlStateManager.scalef(0.25F, 0.25F, 0.25F);
        return super.prepareScale(entitylivingbaseIn, partialTicks);
    }
    
    @Override
    public ResourceLocation getEntityTexture(RedShotEntity arg0)
    {
        return RED_TEXTURE;
    }
    
    public static class RenderFactory implements IRenderFactory<RedShotEntity>
    {
        @Override
        public EntityRenderer<? super RedShotEntity> createRenderFor(EntityRendererManager manager)
        {
            return new RedShotRenderer(manager);
        }
    }
}
