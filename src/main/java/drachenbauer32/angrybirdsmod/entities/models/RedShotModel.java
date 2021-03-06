package drachenbauer32.angrybirdsmod.entities.models;

import com.google.common.collect.ImmutableList;
import drachenbauer32.angrybirdsmod.entities.RedShotEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RedShotModel<T extends RedShotEntity> extends SegmentedModel<T>
{
    private final ModelRenderer bone;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer bone4;
    
    public RedShotModel()
    {
        textureWidth = 32;
        textureHeight = 16;
        
        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 20.0F, 0.0F);
        bone.addBox("body", -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, 0, 0);
        bone.addBox("beak", -1.0F, 1.0F, -6.0F, 2, 2, 2, 0.0F, 0, 0);
        bone.addBox("head_feather_1", 0.0F, -6.0F, -1.0F, 0, 2, 3, 0.0F, 1, 1);
        bone.addBox("tail_feather_1", 0.0F, 1.0F, 4.0F, 0, 1, 4, 0.0F, 0, 3);
        
        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, -4.0F, -3.0F);
        setRotationAngle(bone2, 0.7854F, 0.0F, 0.0F);
        bone.addChild(bone2);
        bone2.addBox("head_feather_2", 0.0F, 0.0F, 0.0F, 0, 2, 4, 0.0F, 0, 0);
        
        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone3, 0.5236F, 0.0F, 0.0F);
        bone.addChild(bone3);
        bone3.addBox("tail_feather_2", 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, 0, 3);
        
        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone4, -0.5236F, 0.0F, 0.0F);
        bone.addChild(bone4);
        bone4.addBox("tail_feather_3", 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, 0, 3);
    }
    
    @Override
    public Iterable<ModelRenderer> getParts()
    {
        return ImmutableList.of(bone);
    }
    
    @Override
    public void setRotationAngles(RedShotEntity redShot, float limbSwing, float limbSwingAmount, float ageInTicks,
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