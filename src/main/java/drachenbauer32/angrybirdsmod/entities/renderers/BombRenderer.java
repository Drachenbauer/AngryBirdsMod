package drachenbauer32.angrybirdsmod.entities.renderers;

import javax.annotation.Nonnull;

import drachenbauer32.angrybirdsmod.entities.BombEntity;
import drachenbauer32.angrybirdsmod.entities.models.BombModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

//@OnlyIn(Dist.CLIENT)
public class BombRenderer extends MobRenderer<BombEntity, EntityModel<BombEntity>>
{
    private static final ResourceLocation BOMB_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/bomb.png");
    
    public BombRenderer(final EntityRendererManager manager)
    {
        super(manager, new BombModel(), 0.75f);
    }
    
    @Override
    public ResourceLocation getEntityTexture(final BombEntity arg0)
    {
        return BOMB_TEXTURE;
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
