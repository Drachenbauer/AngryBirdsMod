package drachenbauer32.angrybirdsmod.entities.renderers;

import com.mojang.blaze3d.platform.GlStateManager;

import drachenbauer32.angrybirdsmod.entities.BluesEntity;
import drachenbauer32.angrybirdsmod.entities.models.BluesTrioModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class BluesTrioRenderer extends LivingRenderer<BluesEntity, BluesTrioModel>
{
    private static final ResourceLocation BLUES_TRIO_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/blues_trio.png");
    
    public BluesTrioRenderer(EntityRendererManager manager)
    {
        super(manager, new BluesTrioModel(), 0.25f);
    }
    
    @Override
    public float prepareScale(BluesEntity entitylivingbaseIn, float partialTicks)
    {
        GlStateManager.scalef(0.5F, 0.5F, 0.5F);
        return super.prepareScale(entitylivingbaseIn, partialTicks);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(BluesEntity arg0)
    {
        return BLUES_TRIO_TEXTURE;
    }
	
    public static class RenderFactory implements IRenderFactory<BluesEntity>
    {
        @Override
        public EntityRenderer<? super BluesEntity> createRenderFor(EntityRendererManager manager)
        {
            return new BluesTrioRenderer(manager);
        }
    }
}
