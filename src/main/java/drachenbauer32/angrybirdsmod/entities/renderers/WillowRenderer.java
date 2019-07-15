package drachenbauer32.angrybirdsmod.entities.renderers;

import com.mojang.blaze3d.platform.GlStateManager;

import drachenbauer32.angrybirdsmod.entities.WillowEntity;
import drachenbauer32.angrybirdsmod.entities.models.WillowModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class WillowRenderer extends LivingRenderer<WillowEntity, WillowModel>
{
    private static final ResourceLocation WILLOW_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/willow.png");
    
    public WillowRenderer(EntityRendererManager manager)
    {
        super(manager, new WillowModel(), 0.5f);
    }
    
    @Override
    public float prepareScale(WillowEntity entitylivingbaseIn, float partialTicks)
    {
        GlStateManager.scalef(0.5F, 0.5F, 0.5F);
        return super.prepareScale(entitylivingbaseIn, partialTicks);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(WillowEntity arg0)
    {
        return WILLOW_TEXTURE;
    }
    
    public static class RenderFactory implements IRenderFactory<WillowEntity>
    {
        @Override
        public EntityRenderer<? super WillowEntity> createRenderFor(EntityRendererManager manager)
        {
            return new WillowRenderer(manager);
        }
    }
}
