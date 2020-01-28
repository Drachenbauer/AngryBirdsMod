package drachenbauer32.angrybirdsmod.entities.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import drachenbauer32.angrybirdsmod.entities.WillowEntity;
import drachenbauer32.angrybirdsmod.entities.models.WillowModel;
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
public class WillowRenderer extends MobRenderer<WillowEntity, EntityModel<WillowEntity>>
{
    private static final ResourceLocation WILLOW_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/willow.png");
    
    public WillowRenderer(EntityRendererManager manager)
    {
        super(manager, new WillowModel<>(), 0.5f);
    }
    
    @Override
    protected void func_225629_a_(WillowEntity p_225629_1_, String p_225629_2_, MatrixStack p_225629_3_, IRenderTypeBuffer p_225629_4_, int p_225629_5_)
    {
        RenderSystem.scalef(0.5f, 0.5f, 0.5f);
    }
    
    @Override
    public ResourceLocation getEntityTexture(WillowEntity arg0)
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
