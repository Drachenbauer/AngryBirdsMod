package drachenbauer32.angrybirdsmod.entities.renderers;

import drachenbauer32.angrybirdsmod.entities.ChuckEntity;
import drachenbauer32.angrybirdsmod.entities.models.ChuckModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class ChuckRenderer extends MobRenderer<ChuckEntity, EntityModel<ChuckEntity>>
{
    private static final ResourceLocation CHUCK_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/chuck.png");
    
    public ChuckRenderer(EntityRendererManager manager)
    {
        super(manager, new ChuckModel(), 0.5f);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public ResourceLocation getEntityTexture(ChuckEntity arg0)
    {
        return CHUCK_TEXTURE;
    }
    
    public static class RenderFactory implements IRenderFactory<ChuckEntity>
    {
        @Override
        public EntityRenderer<? super ChuckEntity> createRenderFor(EntityRendererManager manager)
        {
            return new ChuckRenderer(manager);
        }
    }
}
