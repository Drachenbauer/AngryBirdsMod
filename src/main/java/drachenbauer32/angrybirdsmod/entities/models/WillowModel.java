package drachenbauer32.angrybirdsmod.entities.models;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WillowModel extends EntityModel
{
	private final RendererModel bone;

	public WillowModel()
	{
		textureWidth = 128;
		textureHeight = 64;

		bone = new RendererModel(this);
		bone.setRotationPoint(0.0F, 16.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -8.0F, -8.0F, -8.0F, 16, 16, 16, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 50, 12, -2.0F, 4.0F, -10.0F, 4, 2, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 56, 28, -9.0F, -9.0F, -9.0F, 18, 17, 18, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -2.0F, -4.0F, -10.0F, 4, 4, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 2, 8, -4.0F, -8.0F, -10.0F, 2, 4, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 2, 8, 2.0F, -8.0F, -10.0F, 2, 4, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 52, 0, -9.0F, 2.0F, -6.0F, 1, 6, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 52, 0, 8.0F, 2.0F, -6.0F, 1, 6, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 52, 0, -9.0F, 4.0F, -2.0F, 1, 4, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 52, 0, 8.0F, 4.0F, -2.0F, 1, 4, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 32, -14.0F, 7.0F, -6.0F, 5, 1, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 32, 9.0F, 7.0F, -6.0F, 5, 1, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 32, -14.0F, 7.0F, -2.0F, 5, 1, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 32, 9.0F, 7.0F, -2.0F, 5, 1, 2, 0.0F, false));
	}
	
	@Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
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
    public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
            float headPitch, float scaleFactor )
    {
        bone.rotateAngleX = headPitch * 0.017453292f;
        bone.rotateAngleY = netHeadYaw * 0.017453292f;
    }
}