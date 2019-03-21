package drachenbauer32.angrybirdsmod.entity.model;

import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.client.renderer.entity.model.ModelBox;
import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class ModelStellaMoviePlayer extends ModelBase
{
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;
	private final ModelRenderer bone10;
	private final ModelRenderer bone11;
	private final ModelRenderer bone12;
	private final ModelRenderer bone13;
	private final ModelRenderer bone14;
	private final ModelRenderer bone15;
	private final ModelRenderer bone16;
	
	public ModelStellaMoviePlayer()
	{
		textureWidth = 64;
		textureHeight = 32;
		
		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 25, 6, -1.0F, -2.0F, -5.0F, 2, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 0.0F, -14.0F, -2.0F, 0, 6, 2, 0.0F, false));
		
		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -8.0F, -2.0F);
		setRotationAngle(bone2, 0.7854F, 0.0F, 0.0F);
		bone.addChild(bone2);
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, 0.0F, -6.0F, 0.0F, 0, 6, 2, 0.0F, false));
		
		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, -8.0F, -2.0F);
		setRotationAngle(bone3, 1.5708F, 0.0F, 0.0F);
		bone.addChild(bone3);
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, 0.0F, -6.0F, 0.0F, 0, 6, 2, 0.0F, false));
		
		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 6.0F, 0.0F);
		bone4.cubeList.add(new ModelBox(bone4, 36, 0, -4.0F, -6.0F, -2.0F, 8, 12, 4, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 27, 0, 0.0F, 3.0F, 2.0F, 0, 1, 4, 0.0F, false));
		
		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 3.0F, 2.0F);
		setRotationAngle(bone5, 0.5236F, 0.0F, 0.0F);
		bone4.addChild(bone5);
		bone5.cubeList.add(new ModelBox(bone5, 28, 0, 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, false));
		
		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 3.0F, 2.0F);
		setRotationAngle(bone6, -0.5236F, 0.0F, 0.0F);
		bone4.addChild(bone6);
		bone6.cubeList.add(new ModelBox(bone6, 28, 0, 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, false));
		
		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(-5.0F, 2.0F, 0.0F);
		bone7.cubeList.add(new ModelBox(bone7, 0, 16, -1.0F, -2.0F, -2.0F, 2, 12, 4, 0.0F, false));
		
		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(5.0F, 2.0F, 0.0F);
		bone8.cubeList.add(new ModelBox(bone8, 12, 16, -1.0F, -2.0F, -2.0F, 2, 12, 4, 0.0F, false));
		
		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(-2.0F, 12.0F, 0.0F);
		bone9.cubeList.add(new ModelBox(bone9, 36, 18, -1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F, false));
		bone9.cubeList.add(new ModelBox(bone9, 28, 28, -1.0F, 11.0F, -3.0F, 1, 1, 3, 0.0F, false));
		
		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(0.0F, 12.0F, 0.0F);
		setRotationAngle(bone10, 0.0F, 3.1416F, 0.0F);
		bone9.addChild(bone10);
		bone10.cubeList.add(new ModelBox(bone10, 28, 28, -1.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, false));
		
		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, 12.0F, 0.0F);
		setRotationAngle(bone11, 0.0F, 0.7854F, 0.0F);
		bone9.addChild(bone11);
		bone11.cubeList.add(new ModelBox(bone11, 28, 28, -1.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, false));
		
		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(0.0F, 12.0F, 0.0F);
		setRotationAngle(bone12, 0.0F, -0.7854F, 0.0F);
		bone9.addChild(bone12);
		bone12.cubeList.add(new ModelBox(bone12, 28, 28, -1.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, false));
		
		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(2.0F, 12.0F, 0.0F);
		bone13.cubeList.add(new ModelBox(bone13, 44, 18, -1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F, false));
		bone13.cubeList.add(new ModelBox(bone13, 52, 28, 0.0F, 11.0F, -3.0F, 1, 1, 3, 0.0F, false));
		
		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(0.0F, 12.0F, 0.0F);
		setRotationAngle(bone14, 0.0F, 3.1416F, 0.0F);
		bone13.addChild(bone14);
		bone14.cubeList.add(new ModelBox(bone14, 52, 28, 0.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, false));
		
		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(0.0F, 12.0F, 0.0F);
		setRotationAngle(bone15, 0.0F, 0.7854F, 0.0F);
		bone13.addChild(bone15);
		bone15.cubeList.add(new ModelBox(bone15, 52, 28, 0.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, false));
		
		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(0.0F, 12.0F, 0.0F);
		setRotationAngle(bone16, 0.0F, -0.7854F, 0.0F);
		bone13.addChild(bone16);
		bone16.cubeList.add(new ModelBox(bone16, 52, 28, 0.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, false));
	}
	
	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	{
		bone.render(scale);
		bone4.render(scale);
		bone7.render(scale);
		bone8.render(scale);
		bone9.render(scale);
		bone13.render(scale);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch, float scaleFactor, Entity entityIn)
	{
		bone.rotateAngleX = headPitch * 0.017453292f;
		bone.rotateAngleY = netHeadYaw * 0.017453292f;
	}
	
	@Override
	public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_)
	{
		super.setLivingAnimations(p_78086_1_, p_78086_2_, p_78086_3_, p_78086_4_);
	}
}