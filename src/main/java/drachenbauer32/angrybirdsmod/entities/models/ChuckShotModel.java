package drachenbauer32.angrybirdsmod.entities.models;

import com.google.common.collect.ImmutableList;

import drachenbauer32.angrybirdsmod.entities.ChuckShotEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ChuckShotModel<T extends ChuckShotEntity> extends SegmentedModel<T>
{
    private final ModelRenderer bone;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer bone4;
    private final ModelRenderer bone5;
    
    public ChuckShotModel()
    {
        textureWidth = 32;
        textureHeight = 28;
        
        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 20.0F, 0.0F);
        bone.addBox("body_part_1", -4.0F, 1.0F, -4.0F, 8, 3, 8, 0.0F, 0, 17);
        bone.addBox("body_part_2", -3.0F, -1.0F, -3.0F, 6, 2, 6, 0.0F, 0, 9);
        bone.addBox("body_part_3", -2.0F, -3.0F, -2.0F, 4, 2, 4, 0.0F, 0, 3);
        bone.addBox("body_part_4", -1.0F, -4.0F, -1.0F, 2, 1, 2, 0.0F, 0, 0);
        bone.addBox("beak", -1.0F, 1.0F, -7.0F, 2, 2, 3, 0.0F, 20, 9);
        bone.addBox("right_eyebrow", -3.0F, -2.0F, -3.0F, 2, 1, 1, 0.0F, 25, 17);
        bone.addBox("left_eyebrow", 1.0F, -2.0F, -3.0F, 2, 1, 1, 0.0F, 25, 17);
        bone.addBox("head_feather_1", 0.0F, -6.0F, -1.0F, 0, 2, 2, 0.0F, 0, 17);
        bone.addBox("tail_feather_1", 0.0F, 1.0F, 4.0F, 0, 2, 2, 0.0F, 0, 17);
        
        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, 2.0F, 4.0F);
        setRotationAngle(bone2, -1.0472F, 0.0F, 0.0F);
        bone.addChild(bone2);
        bone2.addBox("head_feather_2", 0.0F, -3.0F, -1.0F, 0, 3, 2, 0.0F, 0, 17);
        
        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0F, -4.0F, 0.0F);
        setRotationAngle(bone3, -1.0472F, 0.0F, 0.0F);
        bone.addChild(bone3);
        bone3.addBox("head_feather_3", 0.0F, -4.0F, -1.0F, 0, 4, 2, 0.0F, 0, 17);
        
        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.0F, -4.0F, 0.0F);
        setRotationAngle(bone4, -0.5236F, 0.0F, 0.0F);
        bone.addChild(bone4);
        bone4.addBox("tail_feather_2", 0.0F, -3.0F, -1.0F, 0, 3, 2, 0.0F, 0, 17);
        
        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(0.0F, 2.0F, 4.0F);
        setRotationAngle(bone5, -0.5236F, 0.0F, 0.0F);
        bone.addChild(bone5);
        bone5.addBox("tail_feather_3", 0.0F, -4.0F, -1.0F, 0, 4, 2, 0.0F, 0, 17);
    }
    
    @Override
    public Iterable<ModelRenderer> getParts()
    {
        return ImmutableList.of(bone);
    }
    
    @Override
    public void setRotationAngles(ChuckShotEntity chuckShot, float limbSwing, float limbSwingAmount, float ageInTicks,
                                  float netHeadYaw, float headPitch)
    {
        
    }
    
    private void setRotationAngle(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}