package drachenbauer32.angrybirdsmod.entities.renderers;

import drachenbauer32.angrybirdsmod.entities.TerenceEntity;
import drachenbauer32.angrybirdsmod.entities.models.TerenceModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class TerenceRenderer extends LivingRenderer<TerenceEntity, TerenceModel>
{
    private static final ResourceLocation TERENCE_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/terence.png");
    
    public TerenceRenderer(EntityRendererManager manager)
    {
        super(manager, new TerenceModel(), 1.25f);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(TerenceEntity arg0)
    {
        return TERENCE_TEXTURE;
    }
    
    public static class RenderFactory implements IRenderFactory<TerenceEntity>
    {
        @Override
        public EntityRenderer<? super TerenceEntity> createRenderFor(EntityRendererManager manager)
        {
            return new TerenceRenderer(manager);
        }
    }
}
