package drachenbauer32.angrybirdsmod.entities.models;

import com.google.common.collect.ImmutableList;
import drachenbauer32.angrybirdsmod.entities.IceBirdEntity;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class IceBirdModel<T extends IceBirdEntity> extends AgeableModel<T>
{
    private final ModelRenderer bone;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer bone4;
    private final ModelRenderer bone5;
    
    public IceBirdModel()
    {
        textureWidth = 34;
        textureHeight = 16;
        
        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 20.0F, 0.0F);
        bone.addBox("body", -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, 0, 0);
        bone.addBox("beak", -1.0F, 0.0F, -7.0F, 2, 2, 3, 0.0F, 24, 0);
        
        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, -4.0F, 0.0F);
        setRotationAngle(bone2, 0.2618F, 0.0F, 0.0F);
        bone.addChild(bone2);
        bone2.addBox("head_feather_1", -1.0F, -5.0F, -2.0F, 2, 5, 2, 0.0F, 0, 0);
        
        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0F, -4.0F, 0.0F);
        setRotationAngle(bone3, -0.2618F, 0.0F, 0.0F);
        bone.addChild(bone3);
        bone3.addBox("head_feather_2", -1.0F, -3.0F, -0.0F, 2, 3, 2, 0.0F, 0, 0);
        
        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone4, -1.309F, 0.0F, 0.0F);
        bone.addChild(bone4);
        bone4.addBox("tail_feather_1", -1.0F, -5.0F, -2.0F, 2, 5, 2, 0.0F, 0, 0);
        
        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone5, -1.8326F, 0.0F, 0.0F);
        bone.addChild(bone5);
        bone5.addBox("tail_feather_2", -1.0F, -3.0F, -0.0F, 2, 3, 2, 0.0F, 0, 0);
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
    public void setRotationAngles(IceBirdEntity iceBird, float limbSwing, float limbSwingAmount, float ageInTicks,
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