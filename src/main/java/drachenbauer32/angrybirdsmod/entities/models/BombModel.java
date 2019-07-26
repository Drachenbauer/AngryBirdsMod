package drachenbauer32.angrybirdsmod.entities.models;

import drachenbauer32.angrybirdsmod.entities.BombEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BombModel extends EntityModel<BombEntity>
{
    private final RendererModel bone;
    
    public BombModel()
    {
        textureWidth = 48;
        textureHeight = 24;
        
        bone = new RendererModel(this);
        bone.setRotationPoint(0.0F, 18.0F, 0.0F);
        bone.cubeList.add(new ModelBox(bone, 0, 0, -6.0F, -6.0F, -6.0F, 12, 12, 12, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 0, -1.0F, -13.0F, -1.0F, 2, 6, 2, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 36, 0, -1.0F, -2.0F, -9.0F, 2, 1, 3, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 36, 4, -1.0F, -1.0F, -8.0F, 2, 2, 2, 0.0F, false));
    }
    
    @Override
    public void render(BombEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
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
    public void setRotationAngles(BombEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                                  float headPitch, float scaleFactor)
    {
        bone.rotateAngleX = headPitch * 0.017453292f;
        bone.rotateAngleY = netHeadYaw * 0.017453292f;
    }
}