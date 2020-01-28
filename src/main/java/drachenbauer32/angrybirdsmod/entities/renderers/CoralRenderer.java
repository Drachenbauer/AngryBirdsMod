package drachenbauer32.angrybirdsmod.entities.renderers;

import drachenbauer32.angrybirdsmod.entities.CoralEntity;
import drachenbauer32.angrybirdsmod.entities.models.CoralModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class CoralRenderer extends MobRenderer<CoralEntity, EntityModel<CoralEntity>>
{
    private static final ResourceLocation CORAL_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/coral.png");
    
    public CoralRenderer(final EntityRendererManager manager)
    {
        super(manager, new CoralModel<>(), 0.625f);
    }
    
    @Override
    public ResourceLocation getEntityTexture(final CoralEntity arg0)
    {
        return CORAL_TEXTURE;
    }
    
    @Override
    protected float handleRotationFloat(CoralEntity livingBase, float partialTicks) {
        return livingBase.getTailRotation();
    }
    
    /*public static class RenderFactory implements IRenderFactory<BombEntity>
    {
        @Override
        public EntityRenderer<? super BombEntity> createRenderFor(EntityRendererManager manager)
        {
            return new BombRenderer(manager);
        }
    }*/
}
