package drachenbauer32.angrybirdsmod.entities.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import drachenbauer32.angrybirdsmod.entities.LucaEntity;
import drachenbauer32.angrybirdsmod.entities.models.LucaModel;
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
public class LucaRenderer extends MobRenderer<LucaEntity, EntityModel<LucaEntity>>
{
    private static final ResourceLocation LUCA_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/luca.png");
    
    public LucaRenderer(EntityRendererManager manager)
    {
        super(manager, new LucaModel<>(), 0.25f);
    }
    
    @Override
    public ResourceLocation getEntityTexture(LucaEntity luca)
    {
        return LUCA_TEXTURE;
    }
    
    @Override
    protected void func_225629_a_(LucaEntity luca, String p_225629_2_, MatrixStack p_225629_3_, IRenderTypeBuffer p_225629_4_, int p_225629_5_)
    {
        RenderSystem.scalef(0.5f, 0.5f, 0.5f);
    }
    
    public static class RenderFactory implements IRenderFactory<LucaEntity>
    {
        @Override
        public EntityRenderer<? super LucaEntity> createRenderFor(EntityRendererManager manager)
        {
            return new LucaRenderer(manager);
        }
    }
}
