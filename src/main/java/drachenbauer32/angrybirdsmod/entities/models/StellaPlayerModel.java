package drachenbauer32.angrybirdsmod.entities.models;

import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StellaPlayerModel<T extends LivingEntity> extends PlayerModel<T>
{    
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer bone4;
    private final ModelRenderer bone5;
    
    public StellaPlayerModel(float modelSize, boolean smallArmsIn)
    {
        super(modelSize, smallArmsIn);
        
        textureWidth = 32;
        textureHeight = 24;
        
        bipedHead = new ModelRenderer(this);
        bipedHead.setRotationPoint(0.0F, 20.0F, 0.0F);
        bipedHead.addBox("body", -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, 0, 0);
        bipedHead.addBox("beak", -1.0F, 2.0F, -5.0F, 2, 1, 1, 0.0F, 25, 0);
        bipedHead.addBox("head_feather_1", 0.0F, -6.0F, -8.0F, 0, 2, 6, 0.0F, 10, 10);
        bipedHead.addBox("tail_feather_1", 0.0F, 1.0F, 4.0F, 0, 1, 4, 0.0F, 24, 3);
        
        bipedHeadwear = new ModelRenderer(this, 32, 0);
        bipedHeadwear.setRotationPoint(0.0F, 20.0F, 0.0F);
        bipedHeadwear.addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, modelSize + 0.5F);
        
        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, -4.0F, -2.0F);
        setRotationAngle(bone2, -0.5236F, 0.0F, 0.0F);
        bipedHead.addChild(bone2);
        bone2.addBox("head_feather_2", 0.0F, -2.0F, -6.0F, 0, 2, 6, 0.0F, 10, 10);

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0F, -4.0F, -2.0F);
        setRotationAngle(bone3, -1.0472F, 0.0F, 0.0F);
        bipedHead.addChild(bone3);
        bone3.addBox("head_feather_3", 0.0F, -2.0F, -6.0F, 0, 2, 8, 0.0F, 8, 8);
        
        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone4, 0.5236F, 0.0F, 0.0F);
        bipedHead.addChild(bone4);
        bone4.addBox("tail_feather_2", 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, 24, 3);
        
        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone5, -0.5236F, 0.0F, 0.0F);
        bipedHead.addChild(bone5);
        bone5.addBox("tail_feather_3", 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, 24, 3);
        
        bipedRightArm = new ModelRenderer(this);
        bipedRightArm.setRotationPoint(-6.0F, 22.0F, -4.0F);
        setRotationAngle(bipedRightArm, -1.5708F, 0.0F, 0.0F);
        bipedRightArm.addBox("invisible_right_arm", -2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F, 0, 16);
        
        bipedLeftArm = new ModelRenderer(this);
        bipedLeftArm.setRotationPoint(6.0F, 22.0F, -4.0F);
        setRotationAngle(bipedLeftArm, -1.5708F, 0.0F, 0.0F);
        bipedLeftArm.addBox("invisible_left_arm", -2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F, 0, 16);
    }
    
    public void setRotationAngle(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}