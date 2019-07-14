package drachenbauer32.angrybirdsmod.entities.renderers;

import drachenbauer32.angrybirdsmod.entities.RedEntity;
import drachenbauer32.angrybirdsmod.entities.models.RedModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class RedRenderer extends LivingRenderer<RedEntity, RedModel>
{
    private static final ResourceLocation RED_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/red.png");
    
    public RedRenderer(EntityRendererManager manager)
    {
        super(manager, new RedModel(), 0.5f);
    }

    @Override
    protected ResourceLocation getEntityTexture(RedEntity arg0)
    {
        return RED_TEXTURE;
    }
	
    public static class RenderFactory implements IRenderFactory<RedEntity>
    {
        @Override
        public EntityRenderer<? super RedEntity> createRenderFor(EntityRendererManager manager)
        {
            return new RedRenderer(manager);
        }
    }
}
