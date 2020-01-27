package drachenbauer32.angrybirdsmod.entities.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import drachenbauer32.angrybirdsmod.entities.BluesEntity;
import drachenbauer32.angrybirdsmod.entities.models.BluesTrioModel;
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
public class BluesTrioRenderer extends MobRenderer<BluesEntity, EntityModel<BluesEntity>>
{
    private static final ResourceLocation BLUES_TRIO_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/blues_trio.png");
    
    public BluesTrioRenderer(EntityRendererManager manager)
    {
        super(manager, new BluesTrioModel(), 0.25f);
    }
    
    @Override
    protected void func_225629_a_(BluesEntity p_225629_1_, String p_225629_2_, MatrixStack p_225629_3_, IRenderTypeBuffer p_225629_4_, int p_225629_5_)
    {
        RenderSystem.scalef(0.5f, 0.5f, 0.5f);
    }
    
    @Override
    public ResourceLocation getEntityTexture(BluesEntity arg0)
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
