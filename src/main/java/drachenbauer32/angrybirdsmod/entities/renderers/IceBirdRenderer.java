package drachenbauer32.angrybirdsmod.entities.renderers;

import drachenbauer32.angrybirdsmod.entities.IceBirdEntity;
import drachenbauer32.angrybirdsmod.entities.models.IceBirdModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class IceBirdRenderer extends MobRenderer<IceBirdEntity, EntityModel<IceBirdEntity>>
{
    private static final ResourceLocation ICE_BIRD_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/ice_bird.png");
    
    public IceBirdRenderer(EntityRendererManager manager)
    {
        super(manager, new IceBirdModel<>(), 0.5f);
    }
    
    @Override
    public ResourceLocation getEntityTexture(IceBirdEntity ice_bird)
    {
        return ICE_BIRD_TEXTURE;
    }
    
    /*public static class RenderFactory implements IRenderFactory<IceBirdEntity>
    {
        @Override
        public EntityRenderer<? super IceBirdEntity> createRenderFor(EntityRendererManager manager)
        {
            return new IceBirdRenderer(manager);
        }
    }*/
}
