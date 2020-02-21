package drachenbauer32.angrybirdsmod.entities.models;

import com.google.common.collect.ImmutableList;
import drachenbauer32.angrybirdsmod.entities.PoppyEntity;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PoppyModel<T extends PoppyEntity> extends AgeableModel<T>
{
    private final ModelRenderer bone;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer bone4;
    private final ModelRenderer bone5;
    
    public PoppyModel()
    {
        textureWidth = 32;
        textureHeight = 18;
        
        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 20.0F, 0.0F);
        bone.addBox("body", -4.0F, -6.0F, -4.0F, 8, 10, 8, 0.0F, 0, 0);
        bone.addBox("beak_upper", -1.0F, -3.0F, -6.0F, 2, 2, 2, 0.0F, 24, 0);
        bone.addBox("beak_lower", -1.0F, -1.0F, -5.0F, 2, 1, 1, 0.0F, 25, 5);
        bone.addBox("head_feather_1", 0.0F, -6.0F, 3.0F, 0, 2, 4, 0.0F, 0, 2);
        bone.addBox("tail_feather_1", 0.0F, 1.0F, 4.0F, 0, 1, 4, 0.0F, 0, 2);
        
        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, -5.0F, 3.0F);
        setRotationAngle(bone2, 0.6109F, 0.0F, 0.0F);
        bone.addChild(bone2);
        bone2.addBox("head_feather_2", 0.0F, -1.0F, 0.0F, 0, 2, 4, 0.0F, 0, 2);
        
        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0F, -5.0F, 3.0F);
        setRotationAngle(bone3, -0.6109F, 0.0F, 0.0F);
        bone.addChild(bone3);
        bone3.addBox("head_feather_3", 0.0F, -1.0F, 0.0F, 0, 2, 4, 0.0F, 0, 2);
        
        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone4, 0.5236F, 0.0F, 0.0F);
        bone.addChild(bone4);
        bone4.addBox("tail_feather_2", 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, 0, 2);
        
        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone5, -0.5236F, 0.0F, 0.0F);
        bone.addChild(bone5);
        bone5.addBox("tail_feather_3", 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, 0, 2);
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
    public void setRotationAngles(PoppyEntity poppy, float limbSwing, float limbSwingAmount, float ageInTicks,
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