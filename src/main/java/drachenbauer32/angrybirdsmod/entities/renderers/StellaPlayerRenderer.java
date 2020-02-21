package drachenbauer32.angrybirdsmod.entities.renderers;

import drachenbauer32.angrybirdsmod.entities.models.StellaPlayerModel;
import drachenbauer32.angrybirdsmod.util.Reference;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.layers.ArrowLayer;
import net.minecraft.client.renderer.entity.layers.HeadLayer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StellaPlayerRenderer extends PlayerRenderer
{
    private static final ResourceLocation STELLA_PLAYER_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/stella_player.png");
    
    public StellaPlayerRenderer(EntityRendererManager renderManager)
    {
        this(renderManager, false);
    }

    public StellaPlayerRenderer(EntityRendererManager renderManager, boolean useSmallArms)
    {
        super(renderManager, useSmallArms);
        this.addLayer(new HeldItemLayer<>(this));
        this.addLayer(new ArrowLayer<>(this));
        this.addLayer(new HeadLayer<>(this));
    }
    
    @Override
    public ResourceLocation getEntityTexture(AbstractClientPlayerEntity entity)
    {
        return STELLA_PLAYER_TEXTURE;
    }
    
    @Override
    public PlayerModel<AbstractClientPlayerEntity> getEntityModel()
    {
        return new StellaPlayerModel<AbstractClientPlayerEntity>(1f, false);
    }
}
