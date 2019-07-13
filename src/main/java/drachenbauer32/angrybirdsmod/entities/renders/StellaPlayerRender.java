package drachenbauer32.angrybirdsmod.entities.renders;

import drachenbauer32.angrybirdsmod.entities.RedEntity;
import drachenbauer32.angrybirdsmod.entities.StellaPlayerEntity;
import drachenbauer32.angrybirdsmod.entities.models.RedModel;
import drachenbauer32.angrybirdsmod.entities.models.StellaPlayerModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class StellaPlayerRender extends LivingRenderer<StellaPlayerEntity, StellaPlayerModel>
{
    public StellaPlayerRender(EntityRendererManager manager)
    {
        super(manager, new StellaPlayerModel(), 0f);
    }

    @Override
    protected ResourceLocation getEntityTexture(StellaPlayerEntity arg0)
    {
        return new ResourceLocation("textures/entity/stella.png");
    }
	
    public static class RenderFactory implements IRenderFactory<StellaPlayerEntity>
    {
        @Override
        public EntityRenderer<? super StellaPlayerEntity> createRenderFor(EntityRendererManager manager)
        {
            return new StellaPlayerRender(manager);
        }
    }
}
