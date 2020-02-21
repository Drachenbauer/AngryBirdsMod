package drachenbauer32.angrybirdsmod.entities.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import drachenbauer32.angrybirdsmod.entities.RedShotEntity;
import drachenbauer32.angrybirdsmod.entities.models.RedShotModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RedShotRenderer extends AbstractBirdStotRenderer<RedShotEntity, RedShotModel<?>>
{
    private static final ResourceLocation RED_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/red.png");
    
    public RedShotRenderer(EntityRendererManager manager)
    {
        super(manager);
    }
    
    @Override
    public ResourceLocation getEntityTexture(RedShotEntity red_shot)
    {
        return RED_TEXTURE;
    }
    
    @SuppressWarnings("rawtypes")
    @Override
    public RedShotModel<?> getEntityModel()
    {
        return new RedShotModel();
    }
    
    @Override
    public void render(RedShotEntity red_shot, float entityYaw, float partialTicks,
                       MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn)
    {
        RenderSystem.scalef(0.25F, 0.25F, 0.25F);
        super.render(red_shot, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
    
    /*public static class RenderFactory implements IRenderFactory<RedShotEntity>
    {
        @Override
        public EntityRenderer<? super RedShotEntity> createRenderFor(EntityRendererManager manager)
        {
            return new RedShotRenderer(manager);
        }
    }*/
}
