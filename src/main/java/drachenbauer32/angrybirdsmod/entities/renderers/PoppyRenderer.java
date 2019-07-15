package drachenbauer32.angrybirdsmod.entities.renderers;

import drachenbauer32.angrybirdsmod.entities.PoppyEntity;
import drachenbauer32.angrybirdsmod.entities.models.PoppyModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class PoppyRenderer extends LivingRenderer<PoppyEntity, PoppyModel>
{
    private static final ResourceLocation POPPY_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/poppy.png");
    
    public PoppyRenderer(EntityRendererManager manager)
    {
        super(manager, new PoppyModel(), 0.5f);
    }

    @Override
    protected ResourceLocation getEntityTexture(PoppyEntity arg0)
    {
        return POPPY_TEXTURE;
    }
    
    public static class RenderFactory implements IRenderFactory<PoppyEntity>
    {
        @Override
        public EntityRenderer<? super PoppyEntity> createRenderFor(EntityRendererManager manager)
        {
            return new PoppyRenderer(manager);
        }
    }
}
