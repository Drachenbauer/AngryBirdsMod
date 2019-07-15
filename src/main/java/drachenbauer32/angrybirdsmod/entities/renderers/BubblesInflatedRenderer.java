package drachenbauer32.angrybirdsmod.entities.renderers;

import com.mojang.blaze3d.platform.GlStateManager;

import drachenbauer32.angrybirdsmod.entities.BubblesEntity;
import drachenbauer32.angrybirdsmod.entities.models.BubblesInflatedModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class BubblesInflatedRenderer extends LivingRenderer<BubblesEntity, BubblesInflatedModel>
{
    private static final ResourceLocation BUBBLES_INFLATED_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/bubbles_inflated.png");
    
    public BubblesInflatedRenderer(EntityRendererManager manager)
    {
        super(manager, new BubblesInflatedModel(), 1.25f);
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
        return BUBBLES_INFLATED_TEXTURE;
    }
    
    public static class RenderFactory implements IRenderFactory<BubblesEntity>
    {
        @Override
        public EntityRenderer<? super BubblesEntity> createRenderFor(EntityRendererManager manager)
        {
            return new BubblesInflatedRenderer(manager);
        }
    }
}
