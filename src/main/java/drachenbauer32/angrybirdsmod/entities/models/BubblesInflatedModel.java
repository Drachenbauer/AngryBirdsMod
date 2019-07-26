package drachenbauer32.angrybirdsmod.entities.models;

import drachenbauer32.angrybirdsmod.entities.BubblesInflatedEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BubblesInflatedModel extends EntityModel<BubblesInflatedEntity>
{
    private final RendererModel bone;
    private final RendererModel bone2;
    private final RendererModel bone3;
    private final RendererModel bone4;
    
    public BubblesInflatedModel()
    {
        textureWidth = 160;
        textureHeight = 80;
        
        bone = new RendererModel(this);
        bone.setRotationPoint(0.0F, 4.0F, 0.0F);
        bone.cubeList.add(new ModelBox(bone, 0, 0, -20.0F, -20.0F, -20.0F, 40, 40, 40, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 5, 3, -1.0F, -16.0F, -23.0F, 2, 2, 3, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 7, 0.0F, -28.0F, -17.0F, 0, 8, 1, 0.0F, false));
        
        bone2 = new RendererModel(this);
        bone2.setRotationPoint(0.0F, -20.0F, -17.0F);
        setRotationAngle(bone2, -0.5236F, 0.0F, 0.0F);
        bone.addChild(bone2);
        bone2.cubeList.add(new ModelBox(bone2, 0, 11, 0.0F, -4.0F, 0.0F, 0, 4, 1, 0.0F, false));
        
        bone3 = new RendererModel(this);
        bone3.setRotationPoint(0.0F, 12.0F, 20.0F);
        setRotationAngle(bone3, 0.5236F, 0.0F, 0.0F);
        bone.addChild(bone3);
        bone3.cubeList.add(new ModelBox(bone3, 0, 16, 0.0F, 0.0F, 0.0F, 0, 1, 3, 0.0F, false));
        
        bone4 = new RendererModel(this);
        bone4.setRotationPoint(0.0F, 12.0F, 20.0F);
        setRotationAngle(bone4, -0.5236F, 0.0F, 0.0F);
        bone.addChild(bone4);
        bone4.cubeList.add(new ModelBox(bone4, 0, 16, 0.0F, 0.0F, 0.0F, 0, 1, 3, 0.0F, false));
    }
    
    @Override
    public void render(BubblesInflatedEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
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
    public void setRotationAngles(BubblesInflatedEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                                  float headPitch, float scaleFactor)
    {
        bone.rotateAngleX = headPitch * 0.017453292f;
        bone.rotateAngleY = netHeadYaw * 0.017453292f;
    }
}