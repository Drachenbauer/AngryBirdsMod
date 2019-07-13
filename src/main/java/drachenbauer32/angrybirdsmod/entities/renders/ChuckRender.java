package drachenbauer32.angrybirdsmod.entities.renders;

import drachenbauer32.angrybirdsmod.entities.ChuckEntity;
import drachenbauer32.angrybirdsmod.entities.models.ChuckModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class ChuckRender extends LivingRenderer<ChuckEntity, ChuckModel>
{
    public ChuckRender(EntityRendererManager manager)
    {
        super(manager, new ChuckModel(), 0f);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected ResourceLocation getEntityTexture(ChuckEntity arg0)
    {
        return new ResourceLocation("textures/entity/chuck.png");
    }
	
    public static class RenderFactory implements IRenderFactory<ChuckEntity>
    {
        @Override
        public EntityRenderer<? super ChuckEntity> createRenderFor(EntityRendererManager manager)
        {
            return new ChuckRender(manager);
        }
    }
}
