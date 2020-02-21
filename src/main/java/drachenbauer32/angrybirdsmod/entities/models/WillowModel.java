package drachenbauer32.angrybirdsmod.entities.models;

import com.google.common.collect.ImmutableList;
import drachenbauer32.angrybirdsmod.entities.WillowEntity;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WillowModel<T extends WillowEntity> extends AgeableModel<T>
{
    private final ModelRenderer bone;
    
    public WillowModel()
    {
        textureWidth = 128;
        textureHeight = 64;
        
        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 16.0F, 0.0F);
        bone.addBox("body", -8.0F, -8.0F, -8.0F, 16, 16, 16, 0.0F, 0, 0);
        bone.addBox("beak", -2.0F, 4.0F, -10.0F, 4, 2, 2, 0.0F, 50, 12);
        bone.addBox("hat", -9.0F, -9.0F, -9.0F, 18, 17, 18, 0.0F, 53, 29);
        bone.addBox("hat_tip",-4.0F, -9.0F, 9.0F, 8, 8, 8, 0.0F, 96, 0);
        bone.addBox("front_feather_base",-2.0F, -4.0F, -10.0F, 4, 4, 2, 0.0F, 0, 0);
        bone.addBox("right_front_feather_end",-3.0F, -10.0F, -11.0F, 2, 6, 1, 0.0F, 3, 9);
        bone.addBox("left_front_feather_end",1.0F, -10.0F, -11.0F, 2, 6, 1, 0.0F, 3, 9);
        bone.addBox("right_front_side_feather_base",-9.0F, -8.0F, -6.0F, 1, 16, 2, 0.0F, 6, 46);
        bone.mirror=true;
        bone.addBox("left_front_side_feather_base",8.0F, -8.0F, -6.0F, 1, 16, 2, 0.0F, 6, 46);
        bone.mirror=false;
        bone.addBox("right_hind_side_feather_base",-9.0F, -8.0F, -2.0F, 1, 16, 2, 0.0F, 0, 46);
        bone.mirror=true;
        bone.addBox("left_hind_side_feather_base",8.0F, -8.0F, -2.0F, 1, 16, 2, 0.0F, 0, 46);
        bone.mirror=false;
        bone.addBox("right_front_side_feather_end",-14.0F, 7.0F, -6.0F, 5, 1, 2, 0.0F, 0, 32);
        bone.mirror=true;
        bone.addBox("left_front_side_feather_end",9.0F, 7.0F, -6.0F, 5, 1, 2, 0.0F, 0, 32);
        bone.mirror=false;
        bone.addBox("right_hind_side_feather_end",-14.0F, 7.0F, -2.0F, 5, 1, 2, 0.0F, 0, 32);
        bone.mirror=true;
        bone.addBox("left_hind_side_feather_end",9.0F, 7.0F, -2.0F, 5, 1, 2, 0.0F, 0, 32);
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
    public void setRotationAngles(WillowEntity willow, float limbSwing, float limbSwingAmount, float ageInTicks,
                                  float netHeadYaw, float headPitch)
    {
        bone.rotateAngleX = headPitch * 0.017453292f;
        bone.rotateAngleY = netHeadYaw * 0.017453292f;
    }
}