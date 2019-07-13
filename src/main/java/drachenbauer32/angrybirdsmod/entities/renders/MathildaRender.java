package drachenbauer32.angrybirdsmod.entities.renders;

import drachenbauer32.angrybirdsmod.entities.MathildaEntity;
import drachenbauer32.angrybirdsmod.entities.models.MathildaModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class MathildaRender extends LivingRenderer<MathildaEntity, MathildaModel>
{
    public MathildaRender(EntityRendererManager manager)
    {
        super(manager, new MathildaModel(), 0f);
    }

    @Override
    protected ResourceLocation getEntityTexture(MathildaEntity arg0)
    {
        return new ResourceLocation("textures/entity/mathilda.png");
    }
	
    public static class RenderFactory implements IRenderFactory<MathildaEntity>
    {
        @Override
        public EntityRenderer<? super MathildaEntity> createRenderFor(EntityRendererManager manager)
        {
            return new MathildaRender(manager);
        }
    }
}
