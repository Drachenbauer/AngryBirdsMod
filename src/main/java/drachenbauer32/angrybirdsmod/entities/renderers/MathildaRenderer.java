package drachenbauer32.angrybirdsmod.entities.renderers;

import drachenbauer32.angrybirdsmod.entities.MathildaEntity;
import drachenbauer32.angrybirdsmod.entities.models.MathildaModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MathildaRenderer extends MobRenderer<MathildaEntity, EntityModel<MathildaEntity>>
{
    private static final ResourceLocation MATHILDA_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/mathilda.png");
    
    public MathildaRenderer(EntityRendererManager manager)
    {
        super(manager, new MathildaModel<>(), 0.5f);
    }
    
    @Override
    public ResourceLocation getEntityTexture(MathildaEntity mathilda)
    {
        return MATHILDA_TEXTURE;
    }
}
