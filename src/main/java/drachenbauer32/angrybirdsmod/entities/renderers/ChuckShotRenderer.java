package drachenbauer32.angrybirdsmod.entities.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import drachenbauer32.angrybirdsmod.entities.ChuckShotEntity;
import drachenbauer32.angrybirdsmod.entities.models.ChuckShotModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ChuckShotRenderer extends AbstractBirdStotRenderer<ChuckShotEntity, ChuckShotModel<?>>
{
    private static final ResourceLocation CHUCK_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/chuck.png");
    
    public ChuckShotRenderer(EntityRendererManager manager)
    {
        super(manager);
    }
    
    @Override
    public ResourceLocation getEntityTexture(ChuckShotEntity chuck_shot)
    {
        return CHUCK_TEXTURE;
    }
    
    @SuppressWarnings("rawtypes")
    @Override
    public ChuckShotModel<?> getEntityModel()
    {
        return new ChuckShotModel();
    }
    
    @Override
    public void render(ChuckShotEntity chuck_shot, float entityYaw, float partialTicks,
                       MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn)
    {
        RenderSystem.scalef(0.25F, 0.25F, 0.25F);
        super.render(chuck_shot, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
}
