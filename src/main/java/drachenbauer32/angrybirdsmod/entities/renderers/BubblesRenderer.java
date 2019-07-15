package drachenbauer32.angrybirdsmod.entities.renderers;

import com.mojang.blaze3d.platform.GlStateManager;

import drachenbauer32.angrybirdsmod.entities.BubblesEntity;
import drachenbauer32.angrybirdsmod.entities.models.BubblesModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class BubblesRenderer extends LivingRenderer<BubblesEntity, BubblesModel>
{
    private static final ResourceLocation BUBBLES_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/bubbles.png");
    
    public BubblesRenderer(EntityRendererManager manager)
    {
        super(manager, new BubblesModel(), 0.25f);
    }
    
    @Override
    public float prepareScale(BubblesEntity entitylivingbaseIn, float partialTicks)
    {
        GlStateManager.scalef(0.5F, 0.5F, 0.5F);
        return super.prepareScale(entitylivingbaseIn, partialTicks);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(BubblesEntity arg0)
    {
        return BUBBLES_TEXTURE;
    }
    
    public static class RenderFactory implements IRenderFactory<BubblesEntity>
    {
        @Override
        public EntityRenderer<? super BubblesEntity> createRenderFor(EntityRendererManager manager)
        {
            return new BubblesRenderer(manager);
        }
    }
}
