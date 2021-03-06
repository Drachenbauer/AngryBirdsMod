package drachenbauer32.angrybirdsmod.entities.renderers;

import drachenbauer32.angrybirdsmod.entities.SilverEntity;
import drachenbauer32.angrybirdsmod.entities.models.SilverModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SilverRenderer extends MobRenderer<SilverEntity, EntityModel<SilverEntity>>
{
    private static final ResourceLocation SILVER_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/silver.png");
    
    public SilverRenderer(EntityRendererManager manager)
    {
        super(manager, new SilverModel<>(), 0.5f);
    }
    
    @Override
    public ResourceLocation getEntityTexture(SilverEntity silver)
    {
        return SILVER_TEXTURE;
    }
}
