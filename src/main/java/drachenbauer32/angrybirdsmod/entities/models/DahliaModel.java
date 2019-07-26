package drachenbauer32.angrybirdsmod.entities.models;

import drachenbauer32.angrybirdsmod.entities.DahliaEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DahliaModel extends EntityModel<DahliaEntity>
{
    private final RendererModel bone;
    private final RendererModel bone2;
    private final RendererModel bone3;
    
    public DahliaModel()
    {
        textureWidth = 32;
        textureHeight = 16;
        
        bone = new RendererModel(this);
        bone.setRotationPoint(0.0F, 20.0F, 0.0F);
        bone.cubeList.add(new ModelBox(bone, 0, 0, -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 25, 6, -1.0F, 2.0F, -5.0F, 2, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 2, -2.0F, -8.0F, 0.0F, 1, 6, 0, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 2, 1.0F, -8.0F, 0.0F, 1, 6, 0, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 24, 1, 0.0F, 1.0F, 4.0F, 0, 1, 4, 0.0F, false));
        
        bone2 = new RendererModel(this);
        bone2.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone2, 0.5236F, 0.0F, 0.0F);
        bone.addChild(bone2);
        bone2.cubeList.add(new ModelBox(bone2, 24, 1, 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, false));
        
        bone3 = new RendererModel(this);
        bone3.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone3, -0.5236F, 0.0F, 0.0F);
        bone.addChild(bone3);
        bone3.cubeList.add(new ModelBox(bone3, 24, 1, 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, false));
    }
    
    @Override
    public void render(DahliaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
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
    public void setRotationAngles(DahliaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                                  float headPitch, float scaleFactor)
    {
        bone.rotateAngleX = headPitch * 0.017453292f;
        bone.rotateAngleY = netHeadYaw * 0.017453292f;
    }
}