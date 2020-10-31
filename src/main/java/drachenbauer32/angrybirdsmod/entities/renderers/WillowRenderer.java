package drachenbauer32.angrybirdsmod.entities.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import drachenbauer32.angrybirdsmod.entities.WillowEntity;
import drachenbauer32.angrybirdsmod.entities.models.WillowModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WillowRenderer extends MobRenderer<WillowEntity, EntityModel<WillowEntity>>
{
    private static final ResourceLocation WILLOW_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/willow.png");
    
    public WillowRenderer(EntityRendererManager manager)
    {
        super(manager, new WillowModel<>(), 0.5f);
    }
    
    @Override
    public ResourceLocation getEntityTexture(WillowEntity arg0willow)
    {
        return WILLOW_TEXTURE;
    }
    
    @Override
    protected void preRenderCallback(WillowEntity arg0willow, MatrixStack matrixStackIn, float partialTickTime)
    {
        float f = 0.5F;
        matrixStackIn.scale(f, f, f);
    }
}
