package drachenbauer32.angrybirdsmod.entities.renderers;

import drachenbauer32.angrybirdsmod.entities.MathildaEntity;
import drachenbauer32.angrybirdsmod.entities.models.MathildaModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class MathildaRenderer extends LivingRenderer<MathildaEntity, MathildaModel>
{
    private static final ResourceLocation MATHILDA_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/mathilda.png");
    
    public MathildaRenderer(EntityRendererManager manager)
    {
        super(manager, new MathildaModel(), 0.5f);
    }
    
    @Override
    public ResourceLocation getEntityTexture(MathildaEntity arg0)
    {
        return MATHILDA_TEXTURE;
    }
    
    public static class RenderFactory implements IRenderFactory<MathildaEntity>
    {
        @Override
        public EntityRenderer<? super MathildaEntity> createRenderFor(EntityRendererManager manager)
        {
            return new MathildaRenderer(manager);
        }
    }
}
