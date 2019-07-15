package drachenbauer32.angrybirdsmod.entities.renderers;

import drachenbauer32.angrybirdsmod.entities.DahliaEntity;
import drachenbauer32.angrybirdsmod.entities.models.DahliaModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class DahliaRenderer extends LivingRenderer<DahliaEntity, DahliaModel>
{
    private static final ResourceLocation DAHLIA_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/dahlia.png");
    
    public DahliaRenderer(EntityRendererManager manager)
    {
        super(manager, new DahliaModel(), 0.5f);
    }

    @Override
    protected ResourceLocation getEntityTexture(DahliaEntity arg0)
    {
        return DAHLIA_TEXTURE;
    }
    
    public static class RenderFactory implements IRenderFactory<DahliaEntity>
    {
        @Override
        public EntityRenderer<? super DahliaEntity> createRenderFor(EntityRendererManager manager)
        {
            return new DahliaRenderer(manager);
        }
    }
}
