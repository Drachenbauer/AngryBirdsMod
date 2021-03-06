package drachenbauer32.angrybirdsmod.entities.renderers;

import drachenbauer32.angrybirdsmod.entities.DahliaEntity;
import drachenbauer32.angrybirdsmod.entities.models.DahliaModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DahliaRenderer extends MobRenderer<DahliaEntity, EntityModel<DahliaEntity>>
{
    private static final ResourceLocation DAHLIA_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/dahlia.png");
    
    public DahliaRenderer(EntityRendererManager manager)
    {
        super(manager, new DahliaModel<>(), 0.5f);
    }
    
    @Override
    public ResourceLocation getEntityTexture(DahliaEntity dahlia)
    {
        return DAHLIA_TEXTURE;
    }
}
