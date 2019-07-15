package drachenbauer32.angrybirdsmod.entities.renderers;

import drachenbauer32.angrybirdsmod.entities.StellaEntity;
import drachenbauer32.angrybirdsmod.entities.models.StellaModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class StellaRenderer extends LivingRenderer<StellaEntity, StellaModel>
{
    private static final ResourceLocation STELLA_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/stella.png");
    
    public StellaRenderer(EntityRendererManager manager)
    {
        super(manager, new StellaModel(), 0.5f);
    }

    @Override
    protected ResourceLocation getEntityTexture(StellaEntity arg0)
    {
        return STELLA_TEXTURE;
    }
    
    public static class RenderFactory implements IRenderFactory<StellaEntity>
    {
        @Override
        public EntityRenderer<? super StellaEntity> createRenderFor(EntityRendererManager manager)
        {
            return new StellaRenderer(manager);
        }
    }
}
