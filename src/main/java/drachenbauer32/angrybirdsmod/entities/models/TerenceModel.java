package drachenbauer32.angrybirdsmod.entities.models;

import drachenbauer32.angrybirdsmod.entities.TerenceEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TerenceModel extends EntityModel<TerenceEntity>
{
	private final RendererModel bone;
	private final RendererModel bone2;
	private final RendererModel bone3;
	private final RendererModel bone4;
	
	public TerenceModel()
	{
		textureWidth = 80;
		textureHeight = 40;

		bone = new RendererModel(this);
		bone.setRotationPoint(0.0F, 14.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -10.0F, -10.0F, -10.0F, 20, 20, 20, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 12, -1.0F, 5.0F, -12.0F, 2, 2, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 2, 2, 0.0F, -14.0F, -2.0F, 0, 4, 6, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 10, 0.0F, 4.0F, 10.0F, 0, 2, 8, 0.0F, false));

		bone2 = new RendererModel(this);
		bone2.setRotationPoint(0.0F, -10.0F, -6.0F);
		setRotationAngle(bone2, 0.7854F, 0.0F, 0.0F);
		bone.addChild(bone2);
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, 0.0F, 0.0F, 0.0F, 0, 4, 8, 0.0F, false));

		bone3 = new RendererModel(this);
		bone3.setRotationPoint(0.0F, 4.0F, 10.0F);
		setRotationAngle(bone3, 0.5236F, 0.0F, 0.0F);
		bone.addChild(bone3);
		bone3.cubeList.add(new ModelBox(bone3, 0, 10, 0.0F, 0.0F, 0.0F, 0, 2, 8, 0.0F, false));

		bone4 = new RendererModel(this);
		bone4.setRotationPoint(0.0F, 4.0F, 10.0F);
		setRotationAngle(bone4, -0.5236F, 0.0F, 0.0F);
		bone.addChild(bone4);
		bone4.cubeList.add(new ModelBox(bone4, 0, 10, 0.0F, 0.0F, 0.0F, 0, 2, 8, 0.0F, false));
	}
	
	@Override
    public void render(TerenceEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
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
    public void setRotationAngles(TerenceEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
            float headPitch, float scaleFactor )
    {
        bone.rotateAngleX = headPitch * 0.017453292f;
        bone.rotateAngleY = netHeadYaw * 0.017453292f;
    }
}