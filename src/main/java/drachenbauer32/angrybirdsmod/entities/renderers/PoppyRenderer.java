package drachenbauer32.angrybirdsmod.entities.renderers;

import drachenbauer32.angrybirdsmod.entities.PoppyEntity;
import drachenbauer32.angrybirdsmod.entities.models.PoppyModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PoppyRenderer extends MobRenderer<PoppyEntity, EntityModel<PoppyEntity>>
{
    private static final ResourceLocation POPPY_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/poppy.png");
    
    public PoppyRenderer(EntityRendererManager manager)
    {
        super(manager, new PoppyModel<>(), 0.5f);
    }
    
    @Override
    public ResourceLocation getEntityTexture(PoppyEntity poppy)
    {
        return POPPY_TEXTURE;
    }
}
