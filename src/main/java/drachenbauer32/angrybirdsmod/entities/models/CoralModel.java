package drachenbauer32.angrybirdsmod.entities.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CoralModel<T extends Entity> extends SegmentedModel<T>
{
    private final ModelRenderer bone;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer bone4;
    private final ModelRenderer bone5;
    private final ModelRenderer bone6;
    private final ModelRenderer bone7;
    //private float prevlimbSwing = 0;
    Vec3d prevPos1 = Vec3d.ZERO;
    Vec3d prevPos2 = Vec3d.ZERO;
    Vec3d prevPos3 = Vec3d.ZERO;
    Vec3d prevPos4 = Vec3d.ZERO;
    private int limbSwingInt = 0;
    private int tailSwingInt = 0;
    private boolean isLimbSwingrising = true;
    private boolean isTailSwingrising = true;
    private boolean layer;
    
    public CoralModel(boolean layer)
    {
        this.layer = layer;
        
        textureWidth = 56;
        textureHeight = 32;
        
        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 17.9F, 0.0F);
        
        bone2 = new ModelRenderer(this);
        bone3 = new ModelRenderer(this);
        bone4 = new ModelRenderer(this);
        bone5 = new ModelRenderer(this);
        bone6 = new ModelRenderer(this);
        bone7 = new ModelRenderer(this);
        
        if (layer)
        {
            bone.addBox("back_fin", 0.0F, -12.0F, 0.0F, 0, 12, 6, 0.0F, 38, 6);
        }
        else
        {
            bone.addBox("head", -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, 0, 0);
            bone.addBox("antenna_part_1", -0.5F, -12.0F, -4.0F, 1, 4, 1, 0.0F, 28, 0);
            bone.addBox("antenna_part_2", -0.5F, -12.0F, -6.0F, 1, 1, 2, 0.0F, 24, 5);
            bone.addBox("antenna_light", -1.0F, -12.0F, -8.0F, 2, 3, 2, 0.0F, 0, 0);
            
            bone2.setRotationPoint(0.0F, 19.9F, 0.0F);
            bone2.addBox("body", -3.0F, -4.0F, -3.0F, 6, 6, 6, 0.0F, 32, 0);
            
            bone3.setRotationPoint(-2.0F, 21.9F, -2.0F);
            bone3.addBox("right_front_leg", -1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, 0, 16);
            bone3.addBox("right_front_flipper",  -1.0F, 2.0F, -2.0F, 2, 0, 1, 0.0F, 1, 20);
            
            bone4.setRotationPoint(2.0F, 21.9F, -2.0F);
            bone4.addBox("left_front_leg", -1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, 8, 16);
            bone4.addBox("left_front_flipper",  -1.0F, 2.0F, -2.0F, 2, 0, 1, 0.0F, 9, 20);
            
            bone5.setRotationPoint(-2.0F, 21.9F, 2.0F);
            bone5.addBox("right_hind_leg", -1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, 16, 16);
            bone5.addBox("right_hind_flipper",  -1.0F, 2.0F, -2.0F, 2, 0, 1, 0.0F, 17, 20);
            
            bone6.setRotationPoint(2.0F, 21.9F, 2.0F);
            bone6.addBox("left_hind_leg", -1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, 24, 16);
            bone6.addBox("left_hind_flipper",  -1.0F, 2.0F, -2.0F, 2, 0, 1, 0.0F, 25, 20);
            
            bone7.setRotationPoint(0.0F, 19.9F, 3.0F);
            bone7.addBox("tail_part_1", -2.0F, -2.0F, 0.0F, 4, 4, 4, 0.0F, 0, 24);
            bone7.addBox("tail_part_2", -1.0F, 0.0F, 4.0F, 2, 2, 2, 0.0F, 4, 20);
            bone7.addBox("tail_fin",  0.0F, -1.0F, 6.0f, 0, 4, 2, 0.0F, 16, 26);
        }
    }
    
    @Override
    public Iterable<ModelRenderer> getParts()
    {
        return ImmutableList.of(bone, bone2, bone3, bone4, bone5, bone6, bone7);
    }
    
    @Override
    public void setRotationAngles(Entity coral, float limbSwing, float limbSwingAmount, float ageInTicks,
                                  float netHeadYaw, float headPitch)
    {
        bone.rotateAngleX = headPitch * 0.017453292f;
        bone.rotateAngleY = netHeadYaw * 0.017453292f;
        
        if (!layer)
        {
            if (isLimbSwingrising)
            {
                limbSwingInt++;
                
                if (limbSwingInt == 8)
                {
                    isLimbSwingrising = false;
                }
            }
            else
            {
                limbSwingInt--;
                
                if (limbSwingInt == -8)
                {
                    isLimbSwingrising = true;
                }
            }
            
            float limbSwingValue = (float)limbSwingInt / 8;
            
            if (isTailSwingrising)
            {
                tailSwingInt++;
                
                if (tailSwingInt == 32)
                {
                    isTailSwingrising = false;
                }
            }
            else
            {
                tailSwingInt--;
                
                if (tailSwingInt == -32)
                {
                    isTailSwingrising = true;
                }
            }
            
            float tailSwingValue = (float)tailSwingInt / 32;
            
            if(prevPos1 == Vec3d.ZERO)
            {
                prevPos1 = coral.getPositionVector();
                prevPos2 = coral.getPositionVector();
                prevPos3 = coral.getPositionVector();
                prevPos4 = coral.getPositionVector();
            }
            
            if(prevPos4.getX() == coral.getPositionVector().getX() &&
               prevPos4.getY() == coral.getPositionVector().getY() &&
               prevPos4.getZ() == coral.getPositionVector().getZ())
            {
                bone3.rotateAngleX = 0;
                bone4.rotateAngleX = 0;
                bone5.rotateAngleX = 0;
                bone6.rotateAngleX = 0;
                
                bone7.rotateAngleY = (-15 * ((float)Math.PI / 180) * tailSwingValue);
            }
            else
            {
                bone3.rotateAngleX = (45 * ((float)Math.PI / 180) * limbSwingValue);
                bone4.rotateAngleX = (-45 * ((float)Math.PI / 180) * limbSwingValue);
                bone5.rotateAngleX = (-45 * ((float)Math.PI / 180) * limbSwingValue);
                bone6.rotateAngleX = (45 * ((float)Math.PI / 180) * limbSwingValue);
                
                bone7.rotateAngleY = (-15 * ((float)Math.PI / 180) * limbSwingValue);
            }
            
            /*bone3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 3 * limbSwingAmount;
            bone4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 3 * limbSwingAmount;
            bone5.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 3 * limbSwingAmount;
            bone6.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 3 * limbSwingAmount;*/
            
            bone7.rotateAngleX = ageInTicks;
            
            prevPos4 = prevPos3;
            prevPos3 = prevPos2;
            prevPos2 = prevPos1;
            prevPos1 = coral.getPositionVector();
        }
    }
}