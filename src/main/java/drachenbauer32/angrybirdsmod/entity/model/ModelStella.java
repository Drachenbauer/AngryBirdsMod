package drachenbauer32.angrybirdsmod.entity.model;

import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.client.renderer.entity.model.ModelBox;
import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStella extends ModelBase
{
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	
	public ModelStella()
	{
		textureWidth = 64;
		textureHeight = 32;
		
		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 20.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 25, 6, -1.0F, 2.0F, -5.0F, 2, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 0.0F, -10.0F, -2.0F, 0, 6, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 16, 0.0F, 1.0F, 4.0F, 0, 1, 4, 0.0F, false));
		
		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -4.0F, -2.0F);
		setRotationAngle(bone2, 0.7854F, 0.0F, 0.0F);
		bone.addChild(bone2);
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, 0.0F, -6.0F, 0.0F, 0, 6, 2, 0.0F, false));
		
		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, -4.0F, -2.0F);
		setRotationAngle(bone3, 1.5708F, 0.0F, 0.0F);
		bone.addChild(bone3);
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, 0.0F, -6.0F, 0.0F, 0, 6, 2, 0.0F, false));
		
		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 1.0F, 4.0F);
		setRotationAngle(bone4, 0.5236F, 0.0F, 0.0F);
		bone.addChild(bone4);
		bone4.cubeList.add(new ModelBox(bone4, 0, 16, 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, false));
		
		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 1.0F, 4.0F);
		setRotationAngle(bone5, -0.5236F, 0.0F, 0.0F);
		bone.addChild(bone5);
		bone5.cubeList.add(new ModelBox(bone5, 0, 16, 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, false));
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