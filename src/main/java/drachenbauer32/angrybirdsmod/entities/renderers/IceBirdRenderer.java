package drachenbauer32.angrybirdsmod.entities.renderers;

import drachenbauer32.angrybirdsmod.entities.IceBirdEntity;
import drachenbauer32.angrybirdsmod.entities.models.IceBirdModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class IceBirdRenderer extends LivingRenderer<IceBirdEntity, IceBirdModel>
{
    private static final ResourceLocation ICE_BIRD_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/ice_bird.png");
    
    public IceBirdRenderer(EntityRendererManager manager)
    {
        super(manager, new IceBirdModel(), 0.5f);
    }

    @Override
    protected ResourceLocation getEntityTexture(IceBirdEntity arg0)
    {
        return ICE_BIRD_TEXTURE;
    }
    
    public static class RenderFactory implements IRenderFactory<IceBirdEntity>
    {
        @Override
        public EntityRenderer<? super IceBirdEntity> createRenderFor(EntityRendererManager manager)
        {
            return new IceBirdRenderer(manager);
        }
    }
}
