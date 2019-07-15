package drachenbauer32.angrybirdsmod.entities.models;

import drachenbauer32.angrybirdsmod.entities.StellaPlayerEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StellaMoviePlayerModel extends EntityModel<StellaPlayerEntity>
{
	private final RendererModel bipedHead;
	private final RendererModel bone2;
	private final RendererModel bone3;
	private final RendererModel bipedBody;
	private final RendererModel bone5;
	private final RendererModel bone6;
	private final RendererModel bipedRightArm;
	private final RendererModel bipedLeftArm;
	private final RendererModel bipedRightLeg;
	private final RendererModel bone10;
	private final RendererModel bone11;
	private final RendererModel bone12;
	private final RendererModel bipedLeftLeg;
	private final RendererModel bone14;
	private final RendererModel bone15;
	private final RendererModel bone16;
	public StellaMoviePlayerModel.ArmPose rightArmPose = StellaMoviePlayerModel.ArmPose.EMPTY;
	public StellaMoviePlayerModel.ArmPose leftArmPose = StellaMoviePlayerModel.ArmPose.EMPTY;
	public boolean isSneak;
	public float field_205061_a;
	
	public StellaMoviePlayerModel ()
	{
		textureWidth = 64;
		textureHeight = 32;
		
		bipedHead = new RendererModel(this);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.cubeList.add(new ModelBox(bipedHead, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));
		bipedHead.cubeList.add(new ModelBox(bipedHead, 25, 6, -1.0F, -2.0F, -5.0F, 2, 1, 1, 0.0F, false));
		bipedHead.cubeList.add(new ModelBox(bipedHead, 0, 0, 0.0F, -14.0F, -2.0F, 0, 6, 2, 0.0F, false));
		
		bone2 = new RendererModel(this);
		bone2.setRotationPoint(0.0F, -8.0F, -2.0F);
		setRotationAngle(bone2, 0.7854F, 0.0F, 0.0F);
		bipedHead.addChild(bone2);
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, 0.0F, -6.0F, 0.0F, 0, 6, 2, 0.0F, false));
		
		bone3 = new RendererModel(this);
		bone3.setRotationPoint(0.0F, -8.0F, -2.0F);
		setRotationAngle(bone3, 1.5708F, 0.0F, 0.0F);
		bipedHead.addChild(bone3);
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, 0.0F, -6.0F, 0.0F, 0, 6, 2, 0.0F, false));
		
		bipedBody = new RendererModel(this);
		bipedBody.setRotationPoint(0.0F, 6.0F, 0.0F);
		bipedBody.cubeList.add(new ModelBox(bipedBody, 36, 0, -4.0F, -6.0F, -2.0F, 8, 12, 4, 0.0F, false));
		bipedBody.cubeList.add(new ModelBox(bipedBody, 27, 0, 0.0F, 3.0F, 2.0F, 0, 1, 4, 0.0F, false));
		
		bone5 = new RendererModel(this);
		bone5.setRotationPoint(0.0F, 3.0F, 2.0F);
		setRotationAngle(bone5, 0.5236F, 0.0F, 0.0F);
		bipedBody.addChild(bone5);
		bone5.cubeList.add(new ModelBox(bone5, 28, 0, 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, false));
		
		bone6 = new RendererModel(this);
		bone6.setRotationPoint(0.0F, 3.0F, 2.0F);
		setRotationAngle(bone6, -0.5236F, 0.0F, 0.0F);
		bipedBody.addChild(bone6);
		bone6.cubeList.add(new ModelBox(bone6, 28, 0, 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, false));
		
		bipedRightArm = new RendererModel(this);
		bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 0, 16, -1.0F, -2.0F, -2.0F, 2, 12, 4, 0.0F, false));
		
		bipedLeftArm = new RendererModel(this);
		bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 12, 16, -1.0F, -2.0F, -2.0F, 2, 12, 4, 0.0F, false));
		
		bipedRightLeg = new RendererModel(this);
		bipedRightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
		bipedRightLeg.cubeList.add(new ModelBox(bipedRightLeg, 36, 17, -1.0F, -1.0F, -1.0F, 2, 13, 2, 0.0F, false));
		bipedRightLeg.cubeList.add(new ModelBox(bipedRightLeg, 28, 28, -1.0F, 11.0F, -3.0F, 1, 1, 3, 0.0F, false));
		
		bone10 = new RendererModel(this);
		bone10.setRotationPoint(0.0F, 12.0F, 0.0F);
		setRotationAngle(bone10, 0.0F, 3.1416F, 0.0F);
		bipedRightLeg.addChild(bone10);
		bone10.cubeList.add(new ModelBox(bone10, 28, 28, -1.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, false));
		
		bone11 = new RendererModel(this);
		bone11.setRotationPoint(0.0F, 12.0F, 0.0F);
		setRotationAngle(bone11, 0.0F, 0.7854F, 0.0F);
		bipedRightLeg.addChild(bone11);
		bone11.cubeList.add(new ModelBox(bone11, 28, 28, -1.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, false));
		
		bone12 = new RendererModel(this);
		bone12.setRotationPoint(0.0F, 12.0F, 0.0F);
		setRotationAngle(bone12, 0.0F, -0.7854F, 0.0F);
		bipedRightLeg.addChild(bone12);
		bone12.cubeList.add(new ModelBox(bone12, 28, 28, -1.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, false));
		
		bipedLeftLeg = new RendererModel(this);
		bipedLeftLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
		bipedLeftLeg.cubeList.add(new ModelBox(bipedLeftLeg, 44, 17, -1.0F, -1.0F, -1.0F, 2, 13, 2, 0.0F, false));
		bipedLeftLeg.cubeList.add(new ModelBox(bipedLeftLeg, 52, 28, 0.0F, 11.0F, -3.0F, 1, 1, 3, 0.0F, false));
		
		bone14 = new RendererModel(this);
		bone14.setRotationPoint(0.0F, 12.0F, 0.0F);
		setRotationAngle(bone14, 0.0F, 3.1416F, 0.0F);
		bipedLeftLeg.addChild(bone14);
		bone14.cubeList.add(new ModelBox(bone14, 52, 28, 0.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, false));
		
		bone15 = new RendererModel(this);
		bone15.setRotationPoint(0.0F, 12.0F, 0.0F);
		setRotationAngle(bone15, 0.0F, 0.7854F, 0.0F);
		bipedLeftLeg.addChild(bone15);
		bone15.cubeList.add(new ModelBox(bone15, 52, 28, 0.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, false));
		
		bone16 = new RendererModel(this);
		bone16.setRotationPoint(0.0F, 12.0F, 0.0F);
		setRotationAngle(bone16, 0.0F, -0.7854F, 0.0F);
		bipedLeftLeg.addChild(bone16);
		bone16.cubeList.add(new ModelBox(bone16, 52, 28, 0.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, false));
	}
	
	@Override
	public void render(StellaPlayerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	{
		bipedHead.render(scale);
		bipedBody.render(scale);
		bipedRightArm.render(scale);
		bipedLeftArm.render(scale);
		bipedRightLeg.render(scale);
		bipedLeftLeg.render(scale);
	}
	
	public void setRotationAngle(RendererModel model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
	
	@Override
	public void setRotationAngles(StellaPlayerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
            float headPitch, float scaleFactor )
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

	    this.bipedBody.rotateAngleY = 0.0F;
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
	    this.bipedRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
	    this.bipedLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;
	    this.bipedRightLeg.rotateAngleY = 0.0F;
	    this.bipedLeftLeg.rotateAngleY = 0.0F;
	    this.bipedRightLeg.rotateAngleZ = 0.0F;
	    this.bipedLeftLeg.rotateAngleZ = 0.0F;
	    
	    if (this.isSitting)
	    {
	        this.bipedRightArm.rotateAngleX += (-(float)Math.PI / 5F);
	        this.bipedLeftArm.rotateAngleX += (-(float)Math.PI / 5F);
	        this.bipedRightLeg.rotateAngleX = -1.4137167F;
	        this.bipedRightLeg.rotateAngleY = ((float)Math.PI / 10F);
	        this.bipedRightLeg.rotateAngleZ = 0.07853982F;
	        this.bipedLeftLeg.rotateAngleX = -1.4137167F;
	        this.bipedLeftLeg.rotateAngleY = (-(float)Math.PI / 10F);
	        this.bipedLeftLeg.rotateAngleZ = -0.07853982F;
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
	    }

	    if (this.leftArmPose == StellaMoviePlayerModel.ArmPose.THROW_SPEAR && this.rightArmPose != StellaMoviePlayerModel.ArmPose.BLOCK && this.rightArmPose != StellaMoviePlayerModel.ArmPose.THROW_SPEAR && this.rightArmPose != StellaMoviePlayerModel.ArmPose.BOW_AND_ARROW)
	    {
	        this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5F - (float)Math.PI;
	        this.bipedLeftArm.rotateAngleY = 0.0F;
	    }

	    if (this.swingProgress > 0.0F)
	    {
	        HandSide handside = this.getMainHand(entity);
	        RendererModel model = this.getArmForSide(handside);
	        float f1 = this.swingProgress;
	        this.bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f1) * ((float)Math.PI * 2F)) * 0.2F;
	        if (handside == HandSide.LEFT)
	        {
	            this.bipedBody.rotateAngleY *= -1.0F;
	        }

	        this.bipedRightArm.rotationPointZ = MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
	        this.bipedRightArm.rotationPointX = -MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
	        this.bipedLeftArm.rotationPointZ = -MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
	        this.bipedLeftArm.rotationPointX = MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
	        this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY;
	        this.bipedLeftArm.rotateAngleY += this.bipedBody.rotateAngleY;
	        this.bipedLeftArm.rotateAngleX += this.bipedBody.rotateAngleY;
	        f1 = 1.0F - this.swingProgress;
	        f1 = f1 * f1;
	        f1 = f1 * f1;
	        f1 = 1.0F - f1;
	        float f2 = MathHelper.sin(f1 * (float)Math.PI);
	        float f3 = MathHelper.sin(this.swingProgress * (float)Math.PI) * -(this.bipedHead.rotateAngleX - 0.7F) * 0.75F;
	        model.rotateAngleX = (float)((double)model.rotateAngleX - ((double)f2 * 1.2D + (double)f3));
	        model.rotateAngleY += this.bipedBody.rotateAngleY * 2.0F;
	        model.rotateAngleZ += MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F;
	    }

	    if (this.isSneak)
	    {
	        this.bipedBody.rotateAngleX = 0.5F;
	        this.bipedRightArm.rotateAngleX += 0.4F;
	        this.bipedLeftArm.rotateAngleX += 0.4F;
	        this.bipedRightLeg.rotationPointZ = 4.0F;
	        this.bipedLeftLeg.rotationPointZ = 4.0F;
	        this.bipedRightLeg.rotationPointY = 9.0F;
	        this.bipedLeftLeg.rotationPointY = 9.0F;
	        this.bipedHead.rotationPointY = 1.0F;
	    }
	    else
	    {
	        this.bipedBody.rotateAngleX = 0.0F;
	        this.bipedRightLeg.rotationPointZ = 0.1F;
	        this.bipedLeftLeg.rotationPointZ = 0.1F;
	        this.bipedRightLeg.rotationPointY = 12.0F;
	        this.bipedLeftLeg.rotationPointY = 12.0F;
	        this.bipedHead.rotationPointY = 0.0F;
	    }

	    this.bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
	    this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
	    this.bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	    this.bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	      
	    if (this.rightArmPose == StellaMoviePlayerModel.ArmPose.BOW_AND_ARROW)
	    {
	        this.bipedRightArm.rotateAngleY = -0.1F + this.bipedHead.rotateAngleY;
	        this.bipedLeftArm.rotateAngleY = 0.1F + this.bipedHead.rotateAngleY + 0.4F;
	        this.bipedRightArm.rotateAngleX = (-(float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
	        this.bipedLeftArm.rotateAngleX = (-(float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
	    }
	    else if (this.leftArmPose == StellaMoviePlayerModel.ArmPose.BOW_AND_ARROW && this.rightArmPose != StellaMoviePlayerModel.ArmPose.THROW_SPEAR && this.rightArmPose != StellaMoviePlayerModel.ArmPose.BLOCK)
	    {
	        this.bipedRightArm.rotateAngleY = -0.1F + this.bipedHead.rotateAngleY - 0.4F;
	        this.bipedLeftArm.rotateAngleY = 0.1F + this.bipedHead.rotateAngleY;
	        this.bipedRightArm.rotateAngleX = (-(float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
	        this.bipedLeftArm.rotateAngleX = (-(float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
	    }
	      
	    if (this.field_205061_a > 0.0F)
	    {
	        float f4 = limbSwing % 26.0F;
	        float f5 = this.swingProgress > 0.0F ? 0.0F : this.field_205061_a;
	          
	        if (f4 < 14.0F)
	        {
	            this.bipedLeftArm.rotateAngleX = this.func_205060_a(this.bipedLeftArm.rotateAngleX, 0.0F, this.field_205061_a);
	            this.bipedRightArm.rotateAngleX = this.func_205059_b(this.bipedRightArm.rotateAngleX, 0.0F, f5);
	            this.bipedLeftArm.rotateAngleY = this.func_205060_a(this.bipedLeftArm.rotateAngleY, (float)Math.PI, this.field_205061_a);
	            this.bipedRightArm.rotateAngleY = this.func_205059_b(this.bipedRightArm.rotateAngleY, (float)Math.PI, f5);
	            this.bipedLeftArm.rotateAngleZ = this.func_205060_a(this.bipedLeftArm.rotateAngleZ, (float)Math.PI + 1.8707964F * this.func_203068_a(f4) / this.func_203068_a(14.0F), this.field_205061_a);
	            this.bipedRightArm.rotateAngleZ = this.func_205059_b(this.bipedRightArm.rotateAngleZ, (float)Math.PI - 1.8707964F * this.func_203068_a(f4) / this.func_203068_a(14.0F), f5);
	        }
	        else if (f4 >= 14.0F && f4 < 22.0F)
	        {
	            float f7 = (f4 - 14.0F) / 8.0F;
	            this.bipedLeftArm.rotateAngleX = this.func_205060_a(this.bipedLeftArm.rotateAngleX, ((float)Math.PI / 2F) * f7, this.field_205061_a);
	            this.bipedRightArm.rotateAngleX = this.func_205059_b(this.bipedRightArm.rotateAngleX, ((float)Math.PI / 2F) * f7, f5);
	            this.bipedLeftArm.rotateAngleY = this.func_205060_a(this.bipedLeftArm.rotateAngleY, (float)Math.PI, this.field_205061_a);
	            this.bipedRightArm.rotateAngleY = this.func_205059_b(this.bipedRightArm.rotateAngleY, (float)Math.PI, f5);
	            this.bipedLeftArm.rotateAngleZ = this.func_205060_a(this.bipedLeftArm.rotateAngleZ, 5.012389F - 1.8707964F * f7, this.field_205061_a);
	            this.bipedRightArm.rotateAngleZ = this.func_205059_b(this.bipedRightArm.rotateAngleZ, 1.2707963F + 1.8707964F * f7, f5);
	        }
	        else if (f4 >= 22.0F && f4 < 26.0F)
	        {
	            float f6 = (f4 - 22.0F) / 4.0F;
	            this.bipedLeftArm.rotateAngleX = this.func_205060_a(this.bipedLeftArm.rotateAngleX, ((float)Math.PI / 2F) - ((float)Math.PI / 2F) * f6, this.field_205061_a);
	            this.bipedRightArm.rotateAngleX = this.func_205059_b(this.bipedRightArm.rotateAngleX, ((float)Math.PI / 2F) - ((float)Math.PI / 2F) * f6, f5);
	            this.bipedLeftArm.rotateAngleY = this.func_205060_a(this.bipedLeftArm.rotateAngleY, (float)Math.PI, this.field_205061_a);
	            this.bipedRightArm.rotateAngleY = this.func_205059_b(this.bipedRightArm.rotateAngleY, (float)Math.PI, f5);
	            this.bipedLeftArm.rotateAngleZ = this.func_205060_a(this.bipedLeftArm.rotateAngleZ, (float)Math.PI, this.field_205061_a);
	            this.bipedRightArm.rotateAngleZ = this.func_205059_b(this.bipedRightArm.rotateAngleZ, (float)Math.PI, f5);
	        }

	        float f8 = 0.3F;
	        float f9 = 0.33333334F;
	        this.bipedLeftLeg.rotateAngleX = this.func_205059_b(this.bipedLeftLeg.rotateAngleX, 0.3F * MathHelper.cos(limbSwing * 0.33333334F + (float)Math.PI), this.field_205061_a);
	        this.bipedRightLeg.rotateAngleX = this.func_205059_b(this.bipedRightLeg.rotateAngleX, 0.3F * MathHelper.cos(limbSwing * 0.33333334F), this.field_205061_a);
	    }
	}
	
	public void setLivingAnimations(StellaPlayerEntity entity, float limbSwing, float limbSwingAmount, float partialTickTime) 
	{
	    this.field_205061_a = entity.getSwimAnimation(partialTickTime);
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

    private float func_205059_b(float p_205059_1_, float p_205059_2_, float p_205059_3_)
    {
	    return p_205059_1_ + (p_205059_2_ - p_205059_1_) * p_205059_3_;
	}

	private float func_203068_a(float p_203068_1_)
	{
	    return -65.0F * p_203068_1_ + p_203068_1_ * p_203068_1_;
	}

	public void setModelAttributes(EntityModel model)
	{
	    super.setModelAttributes(model);
	    if (model instanceof StellaMoviePlayerModel)
	    {
	        StellaMoviePlayerModel modelbiped = (StellaMoviePlayerModel)model;
	        this.leftArmPose = modelbiped.leftArmPose;
	        this.rightArmPose = modelbiped.rightArmPose;
	        this.isSneak = modelbiped.isSneak;
	    }
	}

	public void setVisible(boolean visible)
	{
	    this.bipedHead.showModel = visible;
	    this.bipedBody.showModel = visible;
	    this.bipedRightArm.showModel = visible;
	    this.bipedLeftArm.showModel = visible;
	    this.bipedRightLeg.showModel = visible;
	    this.bipedLeftLeg.showModel = visible;
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