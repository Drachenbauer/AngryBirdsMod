package drachenbauer32.angrybirdsmod.entities.models;

import com.google.common.collect.ImmutableList;
import drachenbauer32.angrybirdsmod.entities.BluesEntity;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BluesTrioModel<T extends BluesEntity> extends AgeableModel<T>
{
    private final ModelRenderer bone;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer bone4;
    private final ModelRenderer bone5;
    private final ModelRenderer bone6;
    private final ModelRenderer bone7;
    private final ModelRenderer bone8;
    
    public BluesTrioModel()
    {
        textureWidth = 34;
        textureHeight = 32;
        
        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 20.0F, 0.0F);
        bone.addBox("body", -4.0F, -20.0F, -4.0F, 8, 24, 8, 0.0F, 0, 0);
        bone.addBox("beak_1", -1.0F, 0.0F, -7.0F, 2, 2, 3, 0.0F, 24, 0);
        bone.addBox("beak_2", -1.0F, -8.0F, -7.0F, 2, 2, 3, 0.0F, 24, 0);
        bone.addBox("beak_3", -1.0F, -16.0F, -7.0F, 2, 2, 3, 0.0F, 24, 0);
        bone.addBox("head_feather_1", 0.0F, -22.0F, -1.0F, 0, 2, 3, 0.0F, 1, 1);
        
        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, -20.0F, -3.0F);
        setRotationAngle(bone2, 0.7854F, 0.0F, 0.0F);
        bone.addChild(bone2);
        bone2.addBox("head_feather_2", 0.0F, 0.0F, 0.0F, 0, 2, 4, 0.0F, 0, 0);
        
        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0F, -15.0F, 4.0F);
        setRotationAngle(bone3, 0.5236F, 0.0F, 0.0F);
        bone.addChild(bone3);
        bone3.addBox("tail_feather_1", 0.0F, 0.0F, 0.0F, 0, 1, 3, 0.0F, 0, 4);
        
        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.0F, -7.0F, 4.0F);
        setRotationAngle(bone4, 0.5236F, 0.0F, 0.0F);
        bone.addChild(bone4);
        bone4.addBox("tail_feather_2", 0.0F, 0.0F, 0.0F, 0, 1, 3, 0.0F, 0, 4);
        
        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone5, 0.5236F, 0.0F, 0.0F);
        bone.addChild(bone5);
        bone5.addBox("tail_feather_3", 0.0F, 0.0F, 0.0F, 0, 1, 3, 0.0F, 0, 4);
        
        bone6 = new ModelRenderer(this);
        bone6.setRotationPoint(0.0F, -15.0F, 4.0F);
        setRotationAngle(bone6, -0.5236F, 0.0F, 0.0F);
        bone.addChild(bone6);
        bone6.addBox("tail_feather_4", 0.0F, 0.0F, 0.0F, 0, 1, 3, 0.0F, 0, 4);
        
        bone7 = new ModelRenderer(this);
        bone7.setRotationPoint(0.0F, -7.0F, 4.0F);
        setRotationAngle(bone7, -0.5236F, 0.0F, 0.0F);
        bone.addChild(bone7);
        bone7.addBox("tail_feather_5", 0.0F, 0.0F, 0.0F, 0, 1, 3, 0.0F, 0, 4);
        
        bone8 = new ModelRenderer(this);
        bone8.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone8, -0.5236F, 0.0F, 0.0F);
        bone.addChild(bone8);
        bone8.addBox("tail_feather_6", 0.0F, 0.0F, 0.0F, 0, 1, 3, 0.0F, 0, 4);
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
    public void setRotationAngles(BluesEntity blues, float limbSwing, float limbSwingAmount, float ageInTicks,
                                  float netHeadYaw, float headPitch)
    {
        bone.rotateAngleX = headPitch * 0.017453292f;
        bone.rotateAngleY = netHeadYaw * 0.017453292f;
    }
    
    private void setRotationAngle(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}