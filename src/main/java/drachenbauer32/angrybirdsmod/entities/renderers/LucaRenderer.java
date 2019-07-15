package drachenbauer32.angrybirdsmod.entities.renderers;

import com.mojang.blaze3d.platform.GlStateManager;

import drachenbauer32.angrybirdsmod.entities.LucaEntity;
import drachenbauer32.angrybirdsmod.entities.models.LucaModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class LucaRenderer extends LivingRenderer<LucaEntity, LucaModel>
{
    private static final ResourceLocation LUCA_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/luca.png");
    
    public LucaRenderer(EntityRendererManager manager)
    {
        super(manager, new LucaModel(), 0.25f);
    }
    
    @Override
    public float prepareScale(LucaEntity entitylivingbaseIn, float partialTicks)
    {
        GlStateManager.scalef(0.5F, 0.5F, 0.5F);
        return super.prepareScale(entitylivingbaseIn, partialTicks);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(LucaEntity arg0)
    {
        return LUCA_TEXTURE;
    }
    
    public static class RenderFactory implements IRenderFactory<LucaEntity>
    {
        @Override
        public EntityRenderer<? super LucaEntity> createRenderFor(EntityRendererManager manager)
        {
            return new LucaRenderer(manager);
        }
    }
}
