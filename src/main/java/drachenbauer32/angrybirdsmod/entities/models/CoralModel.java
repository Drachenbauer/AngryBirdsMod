package drachenbauer32.angrybirdsmod.entities.models;

import com.google.common.collect.ImmutableList;
import drachenbauer32.angrybirdsmod.entities.CoralEntity;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class CoralModel<T extends CoralEntity> extends AgeableModel<T>
{
    private final ModelRenderer bone;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer bone4;
    private final ModelRenderer bone5;
    private final ModelRenderer bone6;
    private final ModelRenderer bone7;
    
    public CoralModel()
    {
        textureWidth = 56;
        textureHeight = 32;
        
        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 18.1F, 0.0F);
        bone.addBox("head", -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, 0, 0);
        bone.addBox("antenna_part_1", -0.5F, -12.0F, -4.0F, 1, 4, 1, 0.0F, 28, 0);
        bone.addBox("antenna_part_2", -0.5F, -12.0F, -6.0F, 1, 1, 2, 0.0F, 24, 5);
        bone.addBox("antenna_light", -1.0F, -12.0F, -8.0F, 2, 3, 2, 0.0F, 0, 0);
        bone.addBox("back_fin", 0.0F, -12.0F, 0.0F, 0, 12, 6, 0.0F, 38, 6);
        
        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, 20.1F, 0.0F);
        bone2.addBox("body", -3.0F, -4.0F, -3.0F, 6, 6, 6, 0.0F, 32, 0);
        
        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(-2.0F, 22.1F, -2.0F);
        bone3.addBox("right_front_leg", -1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, 0, 16);
        bone3.addBox("right_front_flipper",  -1.0F, 2.0F, -2.0F, 2, 0, 1, 0.0F, 1, 20);
        
        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(2.0F, 22.1F, -2.0F);
        bone4.addBox("left_front_leg", -1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, 8, 16);
        bone4.addBox("left_front_flipper",  -1.0F, 2.0F, -2.0F, 2, 0, 1, 0.0F, 9, 20);
        
        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(-2.0F, 22.1F, 2.0F);
        bone5.addBox("right_hind_leg", -1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, 16, 16);
        bone5.addBox("right_hind_flipper",  -1.0F, 2.0F, -2.0F, 2, 0, 1, 0.0F, 17, 20);
        
        bone6 = new ModelRenderer(this);
        bone6.setRotationPoint(2.0F, 22.1F, 2.0F);
        bone6.addBox("left_hind_leg", -1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, 24, 16);
        bone6.addBox("left_hind_flipper",  -1.0F, 2.0F, -2.0F, 2, 0, 1, 0.0F, 25, 20);
        
        bone7 = new ModelRenderer(this);
        bone7.setRotationPoint(0.0F, 20.1F, 3.0F);
        bone7.addBox("tail_part_1", -2.0F, -2.0F, 0.0F, 4, 4, 4, 0.0F, 24, 16);
        bone7.addBox("tail_part_1", -1.0F, 0.0F, 4.0F, 2, 2, 2, 0.0F, 24, 16);
        bone7.addBox("tail_fin",  0.0F, -1.0F, 6.0f, 2, 0, 1, 0.0F, 25, 20);
    }
    
    @Override
    protected Iterable<ModelRenderer> getHeadParts()
    {
        return ImmutableList.of(bone);
    }
    
    @Override
    protected Iterable<ModelRenderer> getBodyParts()
    {
        return ImmutableList.of(bone2, bone3, bone4, bone5, bone6, bone7);
    }
    
    @Override
    public void setRotationAngles(CoralEntity coral, float limbSwing, float limbSwingAmount, float ageInTicks,
                                  float netHeadYaw, float headPitch)
    {
        bone.rotateAngleX = headPitch * 0.017453292f;
        bone.rotateAngleY = netHeadYaw * 0.017453292f;
        /*this.bone3.rotateAngleX = 0.5235988f + MathHelper.cos(limbSwing * 5.0f) * 1.4f * limbSwingAmount;
        this.bone4.rotateAngleX = -0.5235988f + -(MathHelper.cos(limbSwing * 5.0f) * 1.4f * limbSwingAmount);
        this.bone5.rotateAngleX = -0.5235988f + -(MathHelper.cos(limbSwing * 5.0f) * 1.4f * limbSwingAmount);
        this.bone6.rotateAngleX = 0.5235988f + MathHelper.cos(limbSwing * 5.0f) * 1.4f * limbSwingAmount;*/
        
        this.bone3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.bone4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.bone5.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.bone6.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.bone7.rotateAngleX = ageInTicks;
    }
}