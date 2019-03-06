package drachenbauer32.angrybirdsmod.entity.model;

import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.client.renderer.entity.model.ModelBox;
import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelChuck extends ModelBase
{
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	
	public ModelChuck()
	{
		textureWidth = 64;
		textureHeight = 32;
		
		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 20.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -4.0F, 1.0F, -4.0F, 8, 3, 8, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 32, 0, -3.0F, -1.0F, -3.0F, 6, 2, 6, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 32, 8, -2.0F, -3.0F, -2.0F, 4, 2, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 48, 10, -1.0F, -4.0F, -1.0F, 2, 1, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 25, 0, -3.0F, -2.0F, -3.0F, 2, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 25, 0, 1.0F, -2.0F, -3.0F, 2, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 52, 0, -1.0F, 1.0F, -7.0F, 2, 2, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, 0.0F, -6.0F, -1.0F, 0, 2, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 2, 0.0F, 1.0F, 4.0F, 0, 2, 2, 0.0F, false));
		
		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 2.0F, 4.0F);
		setRotationAngle(bone2, -1.0472F, 0.0F, 0.0F);
		bone.addChild(bone2);
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, 0.0F, -3.0F, -1.0F, 0, 3, 2, 0.0F, false));
		
		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, -4.0F, 0.0F);
		setRotationAngle(bone3, -1.0472F, 0.0F, 0.0F);
		bone.addChild(bone3);
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, 0.0F, -4.0F, -1.0F, 0, 4, 2, 0.0F, false));
		
		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, -4.0F, 0.0F);
		setRotationAngle(bone4, -0.5236F, 0.0F, 0.0F);
		bone.addChild(bone4);
		bone4.cubeList.add(new ModelBox(bone4, 0, 0, 0.0F, -3.0F, -1.0F, 0, 3, 2, 0.0F, false));
		
		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 2.0F, 4.0F);
		setRotationAngle(bone5, -0.5236F, 0.0F, 0.0F);
		bone.addChild(bone5);
		bone5.cubeList.add(new ModelBox(bone5, 0, 0, 0.0F, -4.0F, -1.0F, 0, 4, 2, 0.0F, false));
	}
	
	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	{
		bone.render(scale);
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
}