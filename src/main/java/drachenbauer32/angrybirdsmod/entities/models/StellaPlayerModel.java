package drachenbauer32.angrybirdsmod.entities.models;

import drachenbauer32.angrybirdsmod.entities.StellaPlayerEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StellaPlayerModel extends EntityModel<StellaPlayerEntity>
{
	private final RendererModel bone;
	private final RendererModel bone2;
	private final RendererModel bone3;
	private final RendererModel bone4;
	private final RendererModel bone5;
	private final RendererModel bone6;
	private final RendererModel bone7;
	
	public StellaPlayerModel()
	{
		textureWidth = 32;
		textureHeight = 24;
		
		bone = new RendererModel(this);
        bone.setRotationPoint(0.0F, 20.0F, 0.0F);
        bone.cubeList.add(new ModelBox(bone, 0, 0, -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 25, 0, -1.0F, 2.0F, -5.0F, 2, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 0, 0.0F, -10.0F, -2.0F, 0, 6, 2, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 24, 3, 0.0F, 1.0F, 4.0F, 0, 1, 4, 0.0F, false));
        
        bone2 = new RendererModel(this);
        bone2.setRotationPoint(0.0F, -4.0F, -2.0F);
        setRotationAngle(bone2, 0.7854F, 0.0F, 0.0F);
        bone.addChild(bone2);
        bone2.cubeList.add(new ModelBox(bone2, 0, 0, 0.0F, -6.0F, 0.0F, 0, 6, 2, 0.0F, false));
        
        bone3 = new RendererModel(this);
        bone3.setRotationPoint(0.0F, -4.0F, -2.0F);
        setRotationAngle(bone3, 1.5708F, 0.0F, 0.0F);
        bone.addChild(bone3);
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 0.0F, -6.0F, 0.0F, 0, 6, 2, 0.0F, false));
        
        bone4 = new RendererModel(this);
        bone4.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone4, 0.5236F, 0.0F, 0.0F);
        bone.addChild(bone4);
        bone4.cubeList.add(new ModelBox(bone4, 24, 3, 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, false));
        
        bone5 = new RendererModel(this);
        bone5.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone5, -0.5236F, 0.0F, 0.0F);
        bone.addChild(bone5);
        bone5.cubeList.add(new ModelBox(bone5, 24, 3, 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, false));
		
		bone6 = new RendererModel(this);
		bone6.setRotationPoint(-6.0F, 22.0F, -4.0F);
		setRotationAngle(bone6, -1.5708F, 0.0F, 0.0F);
		bone6.cubeList.add(new ModelBox(bone6, 0, 16, -2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F, false));
		
		bone7 = new RendererModel(this);
		bone7.setRotationPoint(6.0F, 22.0F, -4.0F);
		setRotationAngle(bone7, -1.5708F, 0.0F, 0.0F);
		bone7.cubeList.add(new ModelBox(bone7, 0, 16, -2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F, false));
	}
	
	@Override
    public void render(StellaPlayerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
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
    public void setRotationAngles(StellaPlayerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
            float headPitch, float scaleFactor )
    {
        bone.rotateAngleX = headPitch * 0.017453292f;
        bone.rotateAngleY = netHeadYaw * 0.017453292f;
    }
	@Override
	
	public void setLivingAnimations(StellaPlayerEntity entity, float p_212843_2_, float p_212843_3_, float p_212843_4_)
	{
	    super.setLivingAnimations(entity, p_212843_2_, p_212843_3_, p_212843_4_);
	}
}