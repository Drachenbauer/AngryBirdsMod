package drachenbauer32.angrybirdsmod.entities.renders;

import drachenbauer32.angrybirdsmod.entities.RedEntity;
import drachenbauer32.angrybirdsmod.entities.models.RedModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class RedRender extends LivingRenderer<RedEntity, RedModel>
{
    public RedRender(EntityRendererManager manager)
    {
        super(manager, new RedModel(), 0f);
    }

    @Override
    protected ResourceLocation getEntityTexture(RedEntity arg0)
    {
        return new ResourceLocation("textures/entity/red.png");
    }
	
    public static class RenderFactory implements IRenderFactory<RedEntity>
    {
        @Override
        public EntityRenderer<? super RedEntity> createRenderFor(EntityRendererManager manager)
        {
            return new RedRender(manager);
        }
    }
}
