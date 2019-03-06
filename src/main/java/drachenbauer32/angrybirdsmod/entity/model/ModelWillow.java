package drachenbauer32.angrybirdsmod.entity.model;

import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.client.renderer.entity.model.ModelBox;
import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWillow extends ModelBase
{
	private final ModelRenderer bone;
	
	public ModelWillow()
	{
		textureWidth = 64;
		textureHeight = 32;
		
		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 20.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 25, 6, -1.0F, 2.0F, -5.0F, 2, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 24, 12, -5.0F, -5.0F, -5.0F, 10, 9, 10, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.0F, -2.0F, -6.0F, 2, 2, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 1, 4, -2.0F, -4.0F, -6.0F, 1, 2, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 1, 4, 1.0F, -4.0F, -6.0F, 1, 2, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 26, 0, -5.0F, 1.0F, -3.0F, 1, 3, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 26, 0, 4.0F, 1.0F, -3.0F, 1, 3, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 26, 0, -5.0F, 2.0F, -1.0F, 1, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 26, 0, 4.0F, 2.0F, -1.0F, 1, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 16, -8.0F, 3.0F, -3.0F, 3, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 16, 5.0F, 3.0F, -3.0F, 3, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 16, -8.0F, 3.0F, -1.0F, 3, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 16, 5.0F, 3.0F, -1.0F, 3, 1, 1, 0.0F, false));
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