package drachenbauer32.angrybirdsmod.entities.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import drachenbauer32.angrybirdsmod.entities.BluesEntity;
import drachenbauer32.angrybirdsmod.entities.models.BluesTrioModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BluesTrioRenderer extends MobRenderer<BluesEntity, EntityModel<BluesEntity>>
{
    private static final ResourceLocation BLUES_TRIO_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/blues_trio.png");
    
    public BluesTrioRenderer(EntityRendererManager manager)
    {
        super(manager, new BluesTrioModel<>(), 0.25f);
    }
    
    @Override
    public ResourceLocation getEntityTexture(BluesEntity blues)
    {
        return BLUES_TRIO_TEXTURE;
    }
    
    @Override
    protected void preRenderCallback(BluesEntity blues, MatrixStack matrixStackIn, float partialTickTime)
    {
        float f = 0.5F;
        matrixStackIn.scale(f, f, f);
    }
}
