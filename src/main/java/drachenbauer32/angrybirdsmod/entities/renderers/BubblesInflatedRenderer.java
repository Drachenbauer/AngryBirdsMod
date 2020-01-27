package drachenbauer32.angrybirdsmod.entities.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;

import drachenbauer32.angrybirdsmod.entities.BubblesEntity;
import drachenbauer32.angrybirdsmod.entities.BubblesInflatedEntity;
import drachenbauer32.angrybirdsmod.entities.models.BubblesInflatedModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class BubblesInflatedRenderer extends AbstractBirdStotRenderer<BubblesInflatedEntity, BubblesInflatedModel>
{
    private static final ResourceLocation BUBBLES_INFLATED_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/bubbles_inflated.png");
    
    public BubblesInflatedRenderer(EntityRendererManager manager)
    {
        super(manager, new BubblesInflatedModel(), 1.25f);
    }
    
    @Override
    protected void func_225629_a_(BubblesInflatedEntity p_225629_1_, String p_225629_2_, MatrixStack p_225629_3_, IRenderTypeBuffer p_225629_4_, int p_225629_5_)
    {
        RenderSystem.scalef(0.5f, 0.5f, 0.5f);
    }
    
    @Override
    public ResourceLocation getEntityTexture(BubblesInflatedEntity arg0)
    {
        return BUBBLES_INFLATED_TEXTURE;
    }
    
    public static class RenderFactory implements IRenderFactory<BubblesInflatedEntity>
    {
        @Override
        public EntityRenderer<? super BubblesInflatedEntity> createRenderFor(EntityRendererManager manager)
        {
            return new BubblesInflatedRenderer(manager);
        }
    }
}
