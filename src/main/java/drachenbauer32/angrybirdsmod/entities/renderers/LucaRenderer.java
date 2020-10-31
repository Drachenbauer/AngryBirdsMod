package drachenbauer32.angrybirdsmod.entities.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import drachenbauer32.angrybirdsmod.entities.LucaEntity;
import drachenbauer32.angrybirdsmod.entities.models.LucaModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LucaRenderer extends MobRenderer<LucaEntity, EntityModel<LucaEntity>>
{
    private static final ResourceLocation LUCA_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/luca.png");
    
    public LucaRenderer(EntityRendererManager manager)
    {
        super(manager, new LucaModel<>(), 0.25f);
    }
    
    @Override
    public ResourceLocation getEntityTexture(LucaEntity luca)
    {
        return LUCA_TEXTURE;
    }
    
    @Override
    protected void preRenderCallback(LucaEntity luca, MatrixStack matrixStackIn, float partialTickTime)
    {
        float f = 0.5F;
        matrixStackIn.scale(f, f, f);
    }
}
