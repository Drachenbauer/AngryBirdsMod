package drachenbauer32.angrybirdsmod.entities.renders;

import drachenbauer32.angrybirdsmod.entities.BluesEntity;
import drachenbauer32.angrybirdsmod.entities.models.BluesTrioModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class BluesRender extends LivingRenderer<BluesEntity, BluesTrioModel>
{
    public BluesRender(EntityRendererManager manager)
    {
        super(manager, new BluesTrioModel(), 0f);
    }

    @Override
    protected ResourceLocation getEntityTexture(BluesEntity arg0)
    {
        return new ResourceLocation("textures/entity/blues_trio.png");
    }
	
    public static class RenderFactory implements IRenderFactory<BluesEntity>
    {
        @Override
        public EntityRenderer<? super BluesEntity> createRenderFor(EntityRendererManager manager)
        {
            return new BluesRender(manager);
        }
    }
}
