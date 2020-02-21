package drachenbauer32.angrybirdsmod.entities.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import drachenbauer32.angrybirdsmod.entities.BubblesEntity;
import drachenbauer32.angrybirdsmod.entities.models.BubblesInflatedModel;
import drachenbauer32.angrybirdsmod.entities.models.BubblesModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BubblesRenderer extends MobRenderer<BubblesEntity, EntityModel<BubblesEntity>>
{
    private static final ResourceLocation BUBBLES_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/bubbles.png");
    private static final BubblesModel<BubblesEntity> BUBBLES_MODEL= new BubblesModel<>();
    private static final BubblesInflatedModel<BubblesEntity> BUBBLES_INFLATED_MODEL= new BubblesInflatedModel<>();
    
    public BubblesRenderer(EntityRendererManager manager)
    {
        super(manager, new BubblesModel<>(), 0.25f);
    }
    
    @Override
    public ResourceLocation getEntityTexture(BubblesEntity bubbles)
    {
        return BUBBLES_TEXTURE;
    }
    
    @Override
    protected void preRenderCallback(BubblesEntity bubbles, MatrixStack matrixStackIn, float partialTickTime)
    {
        float f = 0.5F;
        matrixStackIn.scale(f, f, f);
    }
    
    @Override
    public void render(BubblesEntity bubbles, float entityYaw, float partialTicks,
                       MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn)
    {
        if (bubbles.isInflated)
        {
            entityModel = BUBBLES_INFLATED_MODEL;
        }
        else
        {
            entityModel = BUBBLES_MODEL;
        }
        super.render(bubbles, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
    
    /*public static class RenderFactory implements IRenderFactory<BubblesEntity>
    {
        @Override
        public EntityRenderer<? super BubblesEntity> createRenderFor(EntityRendererManager manager)
        {
            return new BubblesRenderer(manager);
        }
    }*/
}
