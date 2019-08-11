package drachenbauer32.angrybirdsmod.entities.models;

import drachenbauer32.angrybirdsmod.entities.StellaPlayerEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StellaPlayerModel extends EntityModel<StellaPlayerEntity>
{
    private final RendererModel bipedHead;
    private final RendererModel bone2;
    private final RendererModel bone3;
    private final RendererModel bone4;
    private final RendererModel bone5;
    private final RendererModel bipedRightArm;
    private final RendererModel bipedLeftArm;
    
    public StellaPlayerModel()
    {
        textureWidth = 32;
        textureHeight = 24;
        
        bipedHead = new RendererModel(this);
        bipedHead.setRotationPoint(0.0F, 20.0F, 0.0F);
        bipedHead.cubeList.add(new ModelBox(bipedHead, 0, 0, -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, false));
        bipedHead.cubeList.add(new ModelBox(bipedHead, 25, 0, -1.0F, 2.0F, -5.0F, 2, 1, 1, 0.0F, false));
        bipedHead.cubeList.add(new ModelBox(bipedHead, 10, 10, 0.0F, -6.0F, -8.0F, 0, 2, 6, 0.0F, false));
        bipedHead.cubeList.add(new ModelBox(bipedHead, 24, 3, 0.0F, 1.0F, 4.0F, 0, 1, 4, 0.0F, false));
        
        bone2 = new RendererModel(this);
        bone2.setRotationPoint(0.0F, -4.0F, -2.0F);
        setRotationAngle(bone2, -0.5236F, 0.0F, 0.0F);
        bipedHead.addChild(bone2);
        bone2.cubeList.add(new ModelBox(bone2, 10, 10, 0.0F, -2.0F, -6.0F, 0, 2, 6, 0.0F, false));

        bone3 = new RendererModel(this);
        bone3.setRotationPoint(0.0F, -4.0F, -2.0F);
        setRotationAngle(bone3, -1.0472F, 0.0F, 0.0F);
        bipedHead.addChild(bone3);
        bone3.cubeList.add(new ModelBox(bone3, 8, 8, 0.0F, -2.0F, -6.0F, 0, 2, 8, 0.0F, false));
        
        bone4 = new RendererModel(this);
        bone4.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone4, 0.5236F, 0.0F, 0.0F);
        bipedHead.addChild(bone4);
        bone4.cubeList.add(new ModelBox(bone4, 24, 3, 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, false));
        
        bone5 = new RendererModel(this);
        bone5.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone5, -0.5236F, 0.0F, 0.0F);
        bipedHead.addChild(bone5);
        bone5.cubeList.add(new ModelBox(bone5, 24, 3, 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, false));
        
        bipedRightArm = new RendererModel(this);
        bipedRightArm.setRotationPoint(-6.0F, 22.0F, -4.0F);
        setRotationAngle(bipedRightArm, -1.5708F, 0.0F, 0.0F);
        bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 0, 16, -2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F, false));
        
        bipedLeftArm = new RendererModel(this);
        bipedLeftArm.setRotationPoint(6.0F, 22.0F, -4.0F);
        setRotationAngle(bipedLeftArm, -1.5708F, 0.0F, 0.0F);
        bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 0, 16, -2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F, false));
    }
    
    @Override
    public void render(StellaPlayerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        bipedHead.render(scale);
        bipedRightArm.render(scale);
        bipedLeftArm.render(scale);
    }
    
    public void setRotationAngle(RendererModel model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(StellaPlayerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                                  float headPitch, float scaleFactor)
    {
        bipedHead.rotateAngleX = headPitch * 0.017453292f;
        bipedHead.rotateAngleY = netHeadYaw * 0.017453292f;
    }
    
    @Override
    public void setLivingAnimations(StellaPlayerEntity entity, float p_212843_2_, float p_212843_3_, float p_212843_4_)
    {
        super.setLivingAnimations(entity, p_212843_2_, p_212843_3_, p_212843_4_);
    }
}