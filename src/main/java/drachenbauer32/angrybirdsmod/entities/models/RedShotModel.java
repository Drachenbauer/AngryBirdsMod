package drachenbauer32.angrybirdsmod.entities.models;

import drachenbauer32.angrybirdsmod.entities.RedShotEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RedShotModel extends EntityModel<RedShotEntity>
{
    private final RendererModel bone;
    private final RendererModel bone2;
    private final RendererModel bone3;
    private final RendererModel bone4;
    
    public RedShotModel()
    {
        textureWidth = 32;
        textureHeight = 16;
        
        bone = new RendererModel(this);
        bone.setRotationPoint(0.0F, 20.0F, 0.0F);
        bone.cubeList.add(new ModelBox(bone, 0, 0, -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 0, -1.0F, 1.0F, -6.0F, 2, 2, 2, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 1, 1, 0.0F, -6.0F, -1.0F, 0, 2, 3, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 3, 0.0F, 1.0F, 4.0F, 0, 1, 4, 0.0F, false));
        
        bone2 = new RendererModel(this);
        bone2.setRotationPoint(0.0F, -4.0F, -3.0F);
        setRotationAngle(bone2, 0.7854F, 0.0F, 0.0F);
        bone.addChild(bone2);
        bone2.cubeList.add(new ModelBox(bone2, 0, 0, 0.0F, 0.0F, 0.0F, 0, 2, 4, 0.0F, false));
        
        bone3 = new RendererModel(this);
        bone3.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone3, 0.5236F, 0.0F, 0.0F);
        bone.addChild(bone3);
        bone3.cubeList.add(new ModelBox(bone3, 0, 3, 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, false));
        
        bone4 = new RendererModel(this);
        bone4.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone4, -0.5236F, 0.0F, 0.0F);
        bone.addChild(bone4);
        bone4.cubeList.add(new ModelBox(bone4, 0, 3, 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, false));
    }
    
    @Override
    public void render(RedShotEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        bone.render(scale);
    }
    
    public void setRotationAngle(RendererModel model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}