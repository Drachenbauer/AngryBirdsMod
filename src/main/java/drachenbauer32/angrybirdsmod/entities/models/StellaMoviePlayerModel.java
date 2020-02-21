package drachenbauer32.angrybirdsmod.entities.models;

import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StellaMoviePlayerModel<T extends LivingEntity> extends PlayerModel<T>
{
    
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;;
    private final ModelRenderer bone5;
    private final ModelRenderer bone6;
    private final ModelRenderer bone10;
    private final ModelRenderer bone11;
    private final ModelRenderer bone12;
    private final ModelRenderer bone14;
    private final ModelRenderer bone15;
    private final ModelRenderer bone16;
    
    public StellaMoviePlayerModel (float modelSize, boolean smallArmsIn)
    {
        super(modelSize, smallArmsIn);
        
        textureWidth = 64;
        textureHeight = 32;
        
        bipedHead = new ModelRenderer(this);
        bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedHead.addBox("head", -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, 0, 0);
        bipedHead.addBox("beak", -1.0F, -2.0F, -5.0F, 2, 1, 1, 0.0F, 25, 0);
        bipedHead.addBox("head_feather_1", 0.0F, -10.0F, -8.0F, 0, 2, 6, 0.0F, 10, 10);
        
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
        
        bipedBody = new ModelRenderer(this);
        bipedBody.setRotationPoint(0.0F, 6.0F, 0.0F);
        bipedBody.addBox("body", -4.0F, -6.0F, -2.0F, 8, 12, 4, 0.0F, 36, 0);
        bipedBody.addBox("tail_feather_1", 0.0F, 3.0F, 2.0F, 0, 1, 4, 0.0F, 24, 3);
        
        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(0.0F, 3.0F, 2.0F);
        setRotationAngle(bone5, 0.5236F, 0.0F, 0.0F);
        bipedBody.addChild(bone5);
        bone5.addBox("tail_feather_2", 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, 24, 3);
        
        bone6 = new ModelRenderer(this);
        bone6.setRotationPoint(0.0F, 3.0F, 2.0F);
        setRotationAngle(bone6, -0.5236F, 0.0F, 0.0F);
        bipedBody.addChild(bone6);
        bone6.addBox("tail_feather_3", 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, 24, 3);
        
        bipedRightArm = new ModelRenderer(this);
        bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        bipedRightArm.addBox("right_arm", -1.0F, -2.0F, -2.0F, 2, 12, 4, 0.0F, 0, 16);
        
        bipedRightArmwear.setRotationPoint(-5.0F, 2.5F, 0.0F);
        
        bipedLeftArm = new ModelRenderer(this);
        bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
        bipedLeftArm.addBox("left_arm", -1.0F, -2.0F, -2.0F, 2, 12, 4, 0.0F, 12, 16);
        
        bipedLeftArmwear.setRotationPoint(5.0F, 2.5F, 0.0F);
        
        bipedRightLeg = new ModelRenderer(this);
        bipedRightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
        bipedRightLeg.addBox("right_leg", -1.0F, -1.0F, -1.0F, 2, 13, 2, 0.0F, 36, 17);
        bipedRightLeg.addBox("right_toe_1", -1.0F, 11.0F, -3.0F, 1, 1, 3, 0.0F, 28, 28);
        
        bone10 = new ModelRenderer(this);
        bone10.setRotationPoint(0.0F, 12.0F, 0.0F);
        setRotationAngle(bone10, 0.0F, 3.1416F, 0.0F);
        bipedRightLeg.addChild(bone10);
        bone10.addBox("right_toe_2", -1.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, 28, 28);
        
        bone11 = new ModelRenderer(this);
        bone11.setRotationPoint(0.0F, 12.0F, 0.0F);
        setRotationAngle(bone11, 0.0F, 0.7854F, 0.0F);
        bipedRightLeg.addChild(bone11);
        bone11.addBox("right_toe_3", -1.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, 28, 28);
        
        bone12 = new ModelRenderer(this);
        bone12.setRotationPoint(0.0F, 12.0F, 0.0F);
        setRotationAngle(bone12, 0.0F, -0.7854F, 0.0F);
        bipedRightLeg.addChild(bone12);
        bone12.addBox("right_toe_4", -1.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, 28, 28);
        
        bipedLeftLeg = new ModelRenderer(this);
        bipedLeftLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
        bipedLeftLeg.addBox("left_leg", -1.0F, -1.0F, -1.0F, 2, 13, 2, 0.0F, 44, 17);
        bipedLeftLeg.addBox("left_toe_1", 0.0F, 11.0F, -3.0F, 1, 1, 3, 0.0F, 52, 28);
        
        bone14 = new ModelRenderer(this);
        bone14.setRotationPoint(0.0F, 12.0F, 0.0F);
        setRotationAngle(bone14, 0.0F, 3.1416F, 0.0F);
        bipedLeftLeg.addChild(bone14);
        bone14.addBox("left_toe_2", 0.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, 52, 28);
        
        bone15 = new ModelRenderer(this);
        bone15.setRotationPoint(0.0F, 12.0F, 0.0F);
        setRotationAngle(bone15, 0.0F, 0.7854F, 0.0F);
        bipedLeftLeg.addChild(bone15);
        bone15.addBox("left_toe_3", 0.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, 52, 28);
        
        bone16 = new ModelRenderer(this);
        bone16.setRotationPoint(0.0F, 12.0F, 0.0F);
        setRotationAngle(bone16, 0.0F, -0.7854F, 0.0F);
        bipedLeftLeg.addChild(bone16);
        bone16.addBox("left_toe_4", 0.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, 52, 28);
    }
    
    public void setRotationAngle(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}