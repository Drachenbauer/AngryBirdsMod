package drachenbauer32.angrybirdsmod.entities.models;

import drachenbauer32.angrybirdsmod.entities.StellaPlayerEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StellaPlayerModel extends EntityModel<StellaPlayerEntity>
{
    private final ModelRenderer bipedHead;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer bone4;
    private final ModelRenderer bone5;
    private final ModelRenderer bipedRightArm;
    private final ModelRenderer bipedLeftArm;
    public StellaPlayerModel.ArmPose rightArmPose = StellaPlayerModel.ArmPose.EMPTY;
    public StellaPlayerModel.ArmPose leftArmPose = StellaPlayerModel.ArmPose.EMPTY;
    public float field_205061_a;
    
    public StellaPlayerModel()
    {
        textureWidth = 32;
        textureHeight = 24;
        
        bipedHead = new RendererModel(this);
        bipedHead.setRotationPoint(0.0F, 20.0F, 0.0F);
        bipedHead.func_217178_a("body", -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, 0, 0);
        bipedHead.func_217178_a("beak", -1.0F, 2.0F, -5.0F, 2, 1, 1, 0.0F, 25, 0);
        bipedHead.func_217178_a("head_feather_1", 0.0F, -6.0F, -8.0F, 0, 2, 6, 0.0F, 10, 10);
        bipedHead.func_217178_a("tail_feather_1", 0.0F, 1.0F, 4.0F, 0, 1, 4, 0.0F, 24, 3);
        
        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, -4.0F, -2.0F);
        setRotationAngle(bone2, -0.5236F, 0.0F, 0.0F);
        bipedHead.addChild(bone2);
        bone2.func_217178_a("head_feather_2", 0.0F, -2.0F, -6.0F, 0, 2, 6, 0.0F, 10, 10);

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0F, -4.0F, -2.0F);
        setRotationAngle(bone3, -1.0472F, 0.0F, 0.0F);
        bipedHead.addChild(bone3);
        bone3.func_217178_a("head_feather_3", 0.0F, -2.0F, -6.0F, 0, 2, 8, 0.0F, 10, 10);
        
        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone4, 0.5236F, 0.0F, 0.0F);
        bipedHead.addChild(bone4);
        bone4.func_217178_a("tail_feather_2", 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, 24, 3);
        
        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone5, -0.5236F, 0.0F, 0.0F);
        bipedHead.addChild(bone5);
        bone5.func_217178_a("tail_feather_3", 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, 24, 3);
        
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
        boolean flag = entity instanceof LivingEntity && ((LivingEntity)entity).getTicksElytraFlying() > 4;
        boolean flag1 = entity.isSwimming();
        this.bipedHead.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        
        if (flag)
        {
            this.bipedHead.rotateAngleX = (-(float)Math.PI / 4F);
        }
        else if (this.field_205061_a > 0.0F)
        {
            if (flag1)
            {
                this.bipedHead.rotateAngleX = this.func_205060_a(this.bipedHead.rotateAngleX, (-(float)Math.PI / 4F), this.field_205061_a);
            }
            else
            {
                this.bipedHead.rotateAngleX = this.func_205060_a(this.bipedHead.rotateAngleX, headPitch * ((float)Math.PI / 180F), this.field_205061_a);
            }
        }
        else
        {
            this.bipedHead.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        }
        
        this.bipedRightArm.rotationPointZ = 0.0F;
        this.bipedRightArm.rotationPointX = -5.0F;
        this.bipedLeftArm.rotationPointZ = 0.0F;
        this.bipedLeftArm.rotationPointX = 5.0F;
        float f = 1.0F;
        
        if (flag)
        {
            f = (float)entity.getMotion().lengthSquared();
            f = f / 0.2F;
            f = f * f * f;
        }
        
        if (f < 1.0F)
        {
            f = 1.0F;
        }
        
        this.bipedRightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
        this.bipedLeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
        this.bipedRightArm.rotateAngleZ = 0.0F;
        this.bipedLeftArm.rotateAngleZ = 0.0F;
        
        if (this.isSitting)
        {
            this.bipedRightArm.rotateAngleX += (-(float)Math.PI / 5F);
            this.bipedLeftArm.rotateAngleX += (-(float)Math.PI / 5F);
        }
        
        this.bipedRightArm.rotateAngleY = 0.0F;
        this.bipedRightArm.rotateAngleZ = 0.0F;
        
        switch(this.leftArmPose)
        {
            case EMPTY:
            this.bipedLeftArm.rotateAngleY = 0.0F;
            break;
            
            case BLOCK:
            this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5F - 0.9424779F;
            this.bipedLeftArm.rotateAngleY = ((float)Math.PI / 6F);
            break;
            
            case ITEM:
            this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5F - ((float)Math.PI / 10F);
            this.bipedLeftArm.rotateAngleY = 0.0F;
            break;
            
            case THROW_SPEAR:
            break;
            
            case BOW_AND_ARROW:
        }
        
        switch(this.rightArmPose)
        {
            case EMPTY:
            this.bipedRightArm.rotateAngleY = 0.0F;
            break;
            
            case BLOCK:
            this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5F - 0.9424779F;
            this.bipedRightArm.rotateAngleY = (-(float)Math.PI / 6F);
            break;
            
            case ITEM:
            this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5F - ((float)Math.PI / 10F);
            this.bipedRightArm.rotateAngleY = 0.0F;
            break;
            
            case THROW_SPEAR:
            this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5F - (float)Math.PI;
            this.bipedRightArm.rotateAngleY = 0.0F;
            break;
            
            case BOW_AND_ARROW:
        }
        
        if (this.leftArmPose == StellaPlayerModel.ArmPose.THROW_SPEAR && this.rightArmPose != StellaPlayerModel.ArmPose.BLOCK && this.rightArmPose != StellaPlayerModel.ArmPose.THROW_SPEAR && this.rightArmPose != StellaPlayerModel.ArmPose.BOW_AND_ARROW)
        {
            this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5F - (float)Math.PI;
            this.bipedLeftArm.rotateAngleY = 0.0F;
        }
        
        this.bipedHead.rotationPointY = 0.0F;
        
        this.bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        this.bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        
        if (this.rightArmPose == StellaPlayerModel.ArmPose.BOW_AND_ARROW)
        {
            this.bipedRightArm.rotateAngleY = -0.1F + this.bipedHead.rotateAngleY;
            this.bipedLeftArm.rotateAngleY = 0.1F + this.bipedHead.rotateAngleY + 0.4F;
            this.bipedRightArm.rotateAngleX = (-(float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
            this.bipedLeftArm.rotateAngleX = (-(float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
        }
        else if (this.leftArmPose == StellaPlayerModel.ArmPose.BOW_AND_ARROW && this.rightArmPose != StellaPlayerModel.ArmPose.THROW_SPEAR && this.rightArmPose != StellaPlayerModel.ArmPose.BLOCK)
        {
            this.bipedRightArm.rotateAngleY = -0.1F + this.bipedHead.rotateAngleY - 0.4F;
            this.bipedLeftArm.rotateAngleY = 0.1F + this.bipedHead.rotateAngleY;
            this.bipedRightArm.rotateAngleX = (-(float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
            this.bipedLeftArm.rotateAngleX = (-(float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
        }
    }
    
    public void setLivingAnimations(StellaPlayerEntity entity, float limbSwing, float limbSwingAmount, float partialTickTime) 
    {
        super.setLivingAnimations(entity, limbSwing, limbSwingAmount, partialTickTime);
    }
    
    protected float func_205060_a(float p_205060_1_, float p_205060_2_, float p_205060_3_)
    {
        float f;
        for(f = p_205060_2_ - p_205060_1_; f < -(float)Math.PI; f += ((float)Math.PI * 2F))
        {
            ;
        }
        
        while(f >= (float)Math.PI)
        {
            f -= ((float)Math.PI * 2F);
        }
        
        return p_205060_1_ + p_205060_3_ * f;
    }
    
    public void setModelAttributes(EntityModel<StellaPlayerEntity> model)
    {
        super.setModelAttributes(model);
        
        if (model instanceof StellaPlayerModel)
        {
            StellaPlayerModel modelbiped = (StellaPlayerModel)model;
            this.leftArmPose = modelbiped.leftArmPose;
            this.rightArmPose = modelbiped.rightArmPose;
        }
    }
    
    public void setVisible(boolean visible)
    {
        this.bipedHead.showModel = visible;
        this.bipedRightArm.showModel = visible;
        this.bipedLeftArm.showModel = visible;
    }
    
    public void postRenderArm(float scale, HandSide side)
    {
        this.getArmForSide(side).postRender(scale);
    }
    
    protected RendererModel getArmForSide(HandSide side)
    {
        return side == HandSide.LEFT ? this.bipedLeftArm : this.bipedRightArm;
    }
    
    protected HandSide getMainHand(Entity entityIn)
    {
        if (entityIn instanceof LivingEntity)
        {
            LivingEntity entitylivingbase = (LivingEntity)entityIn;
            HandSide enumhandside = entitylivingbase.getPrimaryHand();
            return entitylivingbase.swingingHand == Hand.MAIN_HAND ? enumhandside : enumhandside.opposite();
        }
        else
        {
            return HandSide.RIGHT;
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public static enum ArmPose
    {
        EMPTY,
        ITEM,
        BLOCK,
        BOW_AND_ARROW,
        THROW_SPEAR;
    }
}