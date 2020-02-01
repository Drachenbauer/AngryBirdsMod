package drachenbauer32.angrybirdsmod.entities.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import drachenbauer32.angrybirdsmod.entities.RedShotEntity;
import drachenbauer32.angrybirdsmod.entities.models.RedShotModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

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
    
    @Override
    protected void func_225629_a_(RedShotEntity red_shot, String p_225629_2_, MatrixStack p_225629_3_, IRenderTypeBuffer p_225629_4_, int p_225629_5_)
    {
        RenderSystem.scalef(0.25F, 0.25F, 0.25F);
    }
    
    public static class RenderFactory implements IRenderFactory<RedShotEntity>
    {
        @Override
        public EntityRenderer<? super RedShotEntity> createRenderFor(EntityRendererManager manager)
        {
            return new RedShotRenderer(manager);
        }
    }
}
