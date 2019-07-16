package drachenbauer32.angrybirdsmod.entities.models;

import drachenbauer32.angrybirdsmod.entities.IceBirdEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class IceBirdModel extends EntityModel<IceBirdEntity>
{
	private final RendererModel bone;
	private final RendererModel bone2;
	private final RendererModel bone3;
	private final RendererModel bone4;
	private final RendererModel bone5;
	
	public IceBirdModel()
	{
		textureWidth = 34;
		textureHeight = 16;
		
		bone = new RendererModel(this);
		bone.setRotationPoint(0.0F, 20.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 24, 0, -1.0F, 0.0F, -7.0F, 2, 2, 3, 0.0F, false));
		
		bone2 = new RendererModel(this);
		bone2.setRotationPoint(0.0F, -4.0F, 0.0F);
		setRotationAngle(bone2, 0.2618F, 0.0F, 0.0F);
		bone.addChild(bone2);
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, -1.0F, -5.0F, -2.0F, 2, 5, 2, 0.0F, false));
		
		bone3 = new RendererModel(this);
		bone3.setRotationPoint(0.0F, -4.0F, 0.0F);
		setRotationAngle(bone3, -0.2618F, 0.0F, 0.0F);
		bone.addChild(bone3);
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, -1.0F, -3.0F, 0.0F, 2, 3, 2, 0.0F, false));
		
		bone4 = new RendererModel(this);
		bone4.setRotationPoint(0.0F, 1.0F, 4.0F);
		setRotationAngle(bone4, -1.309F, 0.0F, 0.0F);
		bone.addChild(bone4);
		bone4.cubeList.add(new ModelBox(bone4, 0, 0, -1.0F, -5.0F, -2.0F, 2, 5, 2, 0.0F, false));
		
		bone5 = new RendererModel(this);
		bone5.setRotationPoint(0.0F, 1.0F, 4.0F);
		setRotationAngle(bone5, -1.8326F, 0.0F, 0.0F);
		bone.addChild(bone5);
		bone5.cubeList.add(new ModelBox(bone5, 0, 0, -1.0F, -3.0F, 0.0F, 2, 3, 2, 0.0F, false));
	}
	
	@Override
    public void render(IceBirdEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
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
    public void setRotationAngles(IceBirdEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
            float headPitch, float scaleFactor )
    {
        bone.rotateAngleX = headPitch * 0.017453292f;
        bone.rotateAngleY = netHeadYaw * 0.017453292f;
    }
}