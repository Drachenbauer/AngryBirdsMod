package drachenbauer32.angrybirdsmod.entities.renders;

import drachenbauer32.angrybirdsmod.entities.BombEntity;
import drachenbauer32.angrybirdsmod.entities.models.BombModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class BombRender extends LivingRenderer<BombEntity, BombModel>
{
    public BombRender(EntityRendererManager manager)
    {
        super(manager, new BombModel(), 0f);
    }

    @Override
    protected ResourceLocation getEntityTexture(BombEntity arg0)
    {
        return new ResourceLocation("textures/entity/bomb.png");
    }
	
    public static class RenderFactory implements IRenderFactory<BombEntity>
    {
        @Override
        public EntityRenderer<? super BombEntity> createRenderFor(EntityRendererManager manager)
        {
            return new BombRender(manager);
        }
    }
}
