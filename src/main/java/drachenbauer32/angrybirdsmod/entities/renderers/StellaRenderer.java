package drachenbauer32.angrybirdsmod.entities.renderers;

import drachenbauer32.angrybirdsmod.entities.StellaEntity;
import drachenbauer32.angrybirdsmod.entities.models.StellaModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StellaRenderer extends MobRenderer<StellaEntity, EntityModel<StellaEntity>>
{
    private static final ResourceLocation STELLA_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/stella.png");
    
    public StellaRenderer(EntityRendererManager manager)
    {
        super(manager, new StellaModel<>(), 0.5f);
    }
    
    @Override
    public ResourceLocation getEntityTexture(StellaEntity stella)
    {
        return STELLA_TEXTURE;
    }
    
    /*public static class RenderFactory implements IRenderFactory<StellaEntity>
    {
        @Override
        public EntityRenderer<? super StellaEntity> createRenderFor(EntityRendererManager manager)
        {
            return new StellaRenderer(manager);
        }
    }*/
}
