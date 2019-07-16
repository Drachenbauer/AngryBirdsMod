package drachenbauer32.angrybirdsmod.entities.models;

import drachenbauer32.angrybirdsmod.entities.ChuckEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ChuckModel extends EntityModel<ChuckEntity>
{
	private final RendererModel bone;
	private final RendererModel bone2;
	private final RendererModel bone3;
	private final RendererModel bone4;
	private final RendererModel bone5;
	
	public ChuckModel()
	{
		textureWidth = 32;
		textureHeight = 28;
		
		bone = new RendererModel(this);
		bone.setRotationPoint(0.0F, 20.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 17, -4.0F, 1.0F, -4.0F, 8, 3, 8, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 9, -3.0F, -1.0F, -3.0F, 6, 2, 6, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 3, -2.0F, -3.0F, -2.0F, 4, 2, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.0F, -4.0F, -1.0F, 2, 1, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 20, 9, -1.0F, 1.0F, -7.0F, 2, 2, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 25, 17, -3.0F, -2.0F, -3.0F, 2, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 25, 17, 1.0F, -2.0F, -3.0F, 2, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 17, 0.0F, -6.0F, -1.0F, 0, 2, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 17, 0.0F, 1.0F, 4.0F, 0, 2, 2, 0.0F, false));
		
		bone2 = new RendererModel(this);
		bone2.setRotationPoint(0.0F, 2.0F, 4.0F);
		setRotationAngle(bone2, -1.0472F, 0.0F, 0.0F);
		bone.addChild(bone2);
		bone2.cubeList.add(new ModelBox(bone2, 0, 17, 0.0F, -3.0F, -1.0F, 0, 3, 2, 0.0F, false));
		
		bone3 = new RendererModel(this);
		bone3.setRotationPoint(0.0F, -4.0F, 0.0F);
		setRotationAngle(bone3, -1.0472F, 0.0F, 0.0F);
		bone.addChild(bone3);
		bone3.cubeList.add(new ModelBox(bone3, 0, 17, 0.0F, -4.0F, -1.0F, 0, 4, 2, 0.0F, false));
		
		bone4 = new RendererModel(this);
		bone4.setRotationPoint(0.0F, -4.0F, 0.0F);
		setRotationAngle(bone4, -0.5236F, 0.0F, 0.0F);
		bone.addChild(bone4);
		bone4.cubeList.add(new ModelBox(bone4, 0, 17, 0.0F, -3.0F, -1.0F, 0, 3, 2, 0.0F, false));
		
		bone5 = new RendererModel(this);
		bone5.setRotationPoint(0.0F, 2.0F, 4.0F);
		setRotationAngle(bone5, -0.5236F, 0.0F, 0.0F);
		bone.addChild(bone5);
		bone5.cubeList.add(new ModelBox(bone5, 0, 17, 0.0F, -4.0F, -1.0F, 0, 4, 2, 0.0F, false));
	}
	
	@Override
	public void render(ChuckEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
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
    public void setRotationAngles(ChuckEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
            float headPitch, float scaleFactor )
    {
        bone.rotateAngleX = headPitch * 0.017453292f;
        bone.rotateAngleY = netHeadYaw * 0.017453292f;
    }
}