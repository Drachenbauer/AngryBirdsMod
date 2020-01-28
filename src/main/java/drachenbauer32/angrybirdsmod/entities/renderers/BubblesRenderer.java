package drachenbauer32.angrybirdsmod.entities.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import drachenbauer32.angrybirdsmod.entities.BubblesEntity;
import drachenbauer32.angrybirdsmod.entities.models.BubblesInflatedModel;
import drachenbauer32.angrybirdsmod.entities.models.BubblesModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class BubblesRenderer extends MobRenderer<BubblesEntity, EntityModel<BubblesEntity>>
{
    private static final ResourceLocation BUBBLES_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/bubbles.png");
    private final BubblesModel<BubblesEntity> BUBBLES_MODEL= new BubblesModel<>();
    private final BubblesInflatedModel<BubblesEntity> BUBBLES_INFLATED_MODEL= new BubblesInflatedModel<>();
    
    public BubblesRenderer(EntityRendererManager manager)
    {
        super(manager, new BubblesModel<>(), 0.25f);
    }
    
    @Override
    public ResourceLocation getEntityTexture(BubblesEntity arg0)
    {
        return BUBBLES_TEXTURE;
    }
    
    @Override
    protected void func_225629_a_(BubblesEntity p_225629_1_, String p_225629_2_, MatrixStack p_225629_3_, IRenderTypeBuffer p_225629_4_, int p_225629_5_)
    {
        RenderSystem.scalef(0.5f, 0.5f, 0.5f);
    }
    
    public void setInflated(boolean inflated)
    {
        if (inflated)
        {
            entityModel = BUBBLES_INFLATED_MODEL;
        }
        else
        {
            entityModel = BUBBLES_MODEL;
        }
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
