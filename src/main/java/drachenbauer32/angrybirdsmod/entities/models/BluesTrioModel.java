package drachenbauer32.angrybirdsmod.entities.models;

import drachenbauer32.angrybirdsmod.entities.BluesEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BluesTrioModel extends EntityModel<BluesEntity>
{
	private final RendererModel bone;
	private final RendererModel bone2;
	private final RendererModel bone3;
	private final RendererModel bone4;
	private final RendererModel bone5;
	private final RendererModel bone6;
	private final RendererModel bone7;
	private final RendererModel bone8;
	
	public BluesTrioModel()
	{

		textureWidth = 34;
		textureHeight = 32;

		bone = new RendererModel(this);
		bone.setRotationPoint(0.0F, 20.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -4.0F, -20.0F, -4.0F, 8, 24, 8, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 24, 0, -1.0F, 0.0F, -7.0F, 2, 2, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 24, 0, -1.0F, -8.0F, -7.0F, 2, 2, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 24, 0, -1.0F, -16.0F, -7.0F, 2, 2, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 1, 1, 0.0F, -22.0F, -1.0F, 0, 2, 3, 0.0F, false));

		bone2 = new RendererModel(this);
		bone2.setRotationPoint(0.0F, -20.0F, -3.0F);
		setRotationAngle(bone2, 0.7854F, 0.0F, 0.0F);
		bone.addChild(bone2);
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, 0.0F, 0.0F, 0.0F, 0, 2, 4, 0.0F, false));

		bone3 = new RendererModel(this);
		bone3.setRotationPoint(0.0F, -15.0F, 4.0F);
		setRotationAngle(bone3, 0.5236F, 0.0F, 0.0F);
		bone.addChild(bone3);
		bone3.cubeList.add(new ModelBox(bone3, 0, 4, 0.0F, 0.0F, 0.0F, 0, 1, 3, 0.0F, false));

		bone4 = new RendererModel(this);
		bone4.setRotationPoint(0.0F, -7.0F, 4.0F);
		setRotationAngle(bone4, 0.5236F, 0.0F, 0.0F);
		bone.addChild(bone4);
		bone4.cubeList.add(new ModelBox(bone4, 0, 4, 0.0F, 0.0F, 0.0F, 0, 1, 3, 0.0F, false));

		bone5 = new RendererModel(this);
		bone5.setRotationPoint(0.0F, 1.0F, 4.0F);
		setRotationAngle(bone5, 0.5236F, 0.0F, 0.0F);
		bone.addChild(bone5);
		bone5.cubeList.add(new ModelBox(bone5, 0, 4, 0.0F, 0.0F, 0.0F, 0, 1, 3, 0.0F, false));

		bone6 = new RendererModel(this);
		bone6.setRotationPoint(0.0F, -15.0F, 4.0F);
		setRotationAngle(bone6, -0.5236F, 0.0F, 0.0F);
		bone.addChild(bone6);
		bone6.cubeList.add(new ModelBox(bone6, 0, 4, 0.0F, 0.0F, 0.0F, 0, 1, 3, 0.0F, false));

		bone7 = new RendererModel(this);
		bone7.setRotationPoint(0.0F, -7.0F, 4.0F);
		setRotationAngle(bone7, -0.5236F, 0.0F, 0.0F);
		bone.addChild(bone7);
		bone7.cubeList.add(new ModelBox(bone7, 0, 4, 0.0F, 0.0F, 0.0F, 0, 1, 3, 0.0F, false));

		bone8 = new RendererModel(this);
		bone8.setRotationPoint(0.0F, 1.0F, 4.0F);
		setRotationAngle(bone8, -0.5236F, 0.0F, 0.0F);
		bone.addChild(bone8);
		bone8.cubeList.add(new ModelBox(bone8, 0, 4, 0.0F, 0.0F, 0.0F, 0, 1, 3, 0.0F, false));
	}
	
	@Override
	public void render(BluesEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	{
		bone.render(scale);
	}
	
	public void setRotationAngle(RendererModel model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(BluesEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch, float scaleFactor )
	{
		bone.rotateAngleX = headPitch * 0.017453292f;
		bone.rotateAngleY = netHeadYaw * 0.017453292f;
	}
}