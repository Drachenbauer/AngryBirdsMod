package drachenbauer32.angrybirdsmod.entities.models;

import com.google.common.collect.ImmutableList;
import drachenbauer32.angrybirdsmod.entities.BubblesEntity;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BubblesModel<T extends BubblesEntity> extends AgeableModel<T>
{
    private final ModelRenderer bone;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer bone4;
    
    public BubblesModel(boolean isInflated)
    {
        textureWidth = 160;
        textureHeight = 80;
        
        bone = new ModelRenderer(this);
        bone2 = new ModelRenderer(this);
        bone3 = new ModelRenderer(this);
        bone4 = new ModelRenderer(this);
        
        if (isInflated)
        {
            bone.setRotationPoint(0.0F, 4.0F, 0.0F);
            bone.addBox("body", -20.0F, -20.0F, -20.0F, 40, 40, 40, 0.0F, 0, 0);
            bone.addBox("beak", -1.0F, -16.0F, -23.0F, 2, 2, 3, 0.0F, 24, 0);
            bone.addBox("head_feather_1", 0.0F, -28.0F, -17.0F, 0, 8, 1, 0.0F, 32, 7);
            
            bone2.setRotationPoint(0.0F, -20.0F, -17.0F);
            setRotationAngle(bone2, -0.5236F, 0.0F, 0.0F);
            bone.addChild(bone2);
            bone.addBox("head_feather_2", 0.0F, -4.0F, 1.0F, 0, 4, 1, 0.0F, 32, 7);
            
            bone3.setRotationPoint(0.0F, 12.0F, 20.0F);
            setRotationAngle(bone3, 0.5236F, 0.0F, 0.0F);
            bone.addChild(bone3);
            bone3.addBox("tail_feather_1", 0.0F, 0.0F, 0.0F, 0, 1, 3, 0.0F, 0, 0);
            
            bone4.setRotationPoint(0.0F, 12.0F, 20.0F);
            setRotationAngle(bone4, -0.5236F, 0.0F, 0.0F);
            bone.addChild(bone4);
            bone4.addBox("tail_feather_2", 0.0F, 0.0F, 0.0F, 0, 1, 3, 0.0F, 0, 0);
        }
        else
        {
            bone.setRotationPoint(0.0F, 20.0F, 0.0F);
            bone.addBox("body", -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, 0, 0);
            bone.addBox("beak", -1.0F, 0.0F, -7.0F, 2, 2, 3, 0.0F, 24, 0);
            bone.addBox("head_feather_1", 0.0F, -12.0F, -1.0F, 0, 8, 1, 0.0F, 32, 7);
            
            bone2.setRotationPoint(0.0F, -4.0F, 0.0F);
            setRotationAngle(bone2, -0.5236F, 0.0F, 0.0F);
            bone.addChild(bone2);
            bone.addBox("head_feather_2", 0.0F, -4.0F, 1.0F, 0, 4, 1, 0.0F, 32, 7);
            
            bone3.setRotationPoint(0.0F, 1.0F, 4.0F);
            setRotationAngle(bone3, 0.5236F, 0.0F, 0.0F);
            bone.addChild(bone3);
            bone3.addBox("tail_feather_1", 0.0F, 0.0F, 0.0F, 0, 1, 3, 0.0F, 0, 0);
            
            bone4.setRotationPoint(0.0F, 1.0F, 4.0F);
            setRotationAngle(bone4, -0.5236F, 0.0F, 0.0F);
            bone.addChild(bone4);
            bone4.addBox("tail_feather_2", 0.0F, 0.0F, 0.0F, 0, 1, 3, 0.0F, 0, 0);
        }
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
    public void setRotationAngles(BubblesEntity bubbles, float limbSwing, float limbSwingAmount, float ageInTicks,
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