package drachenbauer32.angrybirdsmod.entities.renderers;

import drachenbauer32.angrybirdsmod.entities.BombEntity;
import drachenbauer32.angrybirdsmod.entities.models.BombModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class BombRenderer extends LivingRenderer<BombEntity, BombModel>
{
    private static final ResourceLocation BOMB_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/bomb.png");
    
    public BombRenderer(EntityRendererManager manager)
    {
        super(manager, new BombModel(), 0.75f);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(BombEntity arg0)
    {
        return BOMB_TEXTURE;
    }
    
    public static class RenderFactory implements IRenderFactory<BombEntity>
    {
        @Override
        public EntityRenderer<? super BombEntity> createRenderFor(EntityRendererManager manager)
        {
            return new BombRenderer(manager);
        }
    }
}
