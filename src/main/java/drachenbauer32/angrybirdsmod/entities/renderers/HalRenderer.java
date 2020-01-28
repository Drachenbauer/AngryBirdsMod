package drachenbauer32.angrybirdsmod.entities.renderers;

import drachenbauer32.angrybirdsmod.entities.HalEntity;
import drachenbauer32.angrybirdsmod.entities.models.HalModel;
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
public class HalRenderer extends MobRenderer<HalEntity, EntityModel<HalEntity>>
{
    private static final ResourceLocation HAL_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/hal.png");
    
    public HalRenderer(EntityRendererManager manager)
    {
        super(manager, new HalModel<>(), 0.5f);
    }
    
    @Override
    public ResourceLocation getEntityTexture(HalEntity arg0)
    {
        return HAL_TEXTURE;
    }
    
    public static class RenderFactory implements IRenderFactory<HalEntity>
    {
        @Override
        public EntityRenderer<? super HalEntity> createRenderFor(EntityRendererManager manager)
        {
            return new HalRenderer(manager);
        }
    }
}
