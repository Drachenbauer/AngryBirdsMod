package drachenbauer32.angrybirdsmod.entities.models;

import com.google.common.collect.ImmutableList;
import drachenbauer32.angrybirdsmod.entities.BombEntity;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BombModel<T extends BombEntity> extends AgeableModel<T>
{
    private final ModelRenderer bone;
    
    public BombModel()
    {
        textureWidth = 48;
        textureHeight = 24;
        
        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 18.0F, 0.0F);
        bone.addBox("body", -6.0F, -6.0F, -6.0F, 12, 12, 12, 0.0F, 0, 0);
        bone.addBox("beak_upper", -1.0F, -2.0F, -9.0F, 2, 1, 3, 0.0F, 36, 0);
        bone.addBox("beak_lower", -1.0F, -1.0F, -8.0F, 2, 2, 2, 0.0F, 36, 4);
        bone.addBox("head_feather", -1.0F, -13.0F, -1.0F, 2, 6, 2, 0.0F, 0, 0);
    }
    
    @Override
    protected Iterable<ModelRenderer> getHeadParts()
    {
        return ImmutableList.of(bone);
    }
    
    @Override
    protected Iterable<ModelRenderer> getBodyParts()
    {
        return ImmutableList.of();
    }
    
    @Override
    public void setRotationAngles(BombEntity bomb, float limbSwing, float limbSwingAmount, float ageInTicks,
                                  float netHeadYaw, float headPitch)
    {
        bone.rotateAngleX = headPitch * 0.017453292f;
        bone.rotateAngleY = netHeadYaw * 0.017453292f;
    }
}