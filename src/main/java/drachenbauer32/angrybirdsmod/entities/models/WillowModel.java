package drachenbauer32.angrybirdsmod.entities.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import drachenbauer32.angrybirdsmod.entities.WillowEntity;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WillowModel<T extends WillowEntity> extends AgeableModel<T>
{
    private final ModelRenderer bone;
    
    public WillowModel()
    {
        textureWidth = 128;
        textureHeight = 64;
        
        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 16.0F, 0.0F);
        bone.func_217178_a("body", -8.0F, -8.0F, -8.0F, 16, 16, 16, 0.0F, 0, 0);
        bone.func_217178_a("beak", -2.0F, 4.0F, -10.0F, 4, 2, 2, 0.0F, 50, 12);
        bone.func_217178_a("hat", -9.0F, -9.0F, -9.0F, 18, 17, 18, 0.0F, 53, 29);
        bone.func_217178_a("hat_tip",-4.0F, -9.0F, 9.0F, 8, 8, 8, 0.0F, 96, 0);
        bone.func_217178_a("front_feather_base",-2.0F, -4.0F, -10.0F, 4, 4, 2, 0.0F, 0, 0);
        bone.func_217178_a("right_front_feather_end",-3.0F, -10.0F, -11.0F, 2, 6, 1, 0.0F, 3, 9);
        bone.func_217178_a("left_front_feather_end",1.0F, -10.0F, -11.0F, 2, 6, 1, 0.0F, 3, 9);
        bone.func_217178_a("right_front_side_feather_base",-9.0F, -8.0F, -6.0F, 1, 16, 2, 0.0F, 6, 46);
        bone.func_217178_a("left_front_side_feather_base",8.0F, -8.0F, -6.0F, 1, 16, 2, 0.0F, 6, 46);
        bone.func_217178_a("right_hind_side_feather_base",-9.0F, -8.0F, -2.0F, 1, 16, 2, 0.0F, 0, 46);
        bone.func_217178_a("left_hind_side_feather_base",8.0F, -8.0F, -2.0F, 1, 16, 2, 0.0F, 0, 46);
      /*bone.cubeList.add(new ModelBox(bone, 6, 46, -9.0F, -8.0F, -6.0F, 1, 16, 2, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 6, 46, 8.0F, -8.0F, -6.0F, 1, 16, 2, 0.0F, true));
        bone.cubeList.add(new ModelBox(bone, 0, 46, -9.0F, -8.0F, -2.0F, 1, 16, 2, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 46, 8.0F, -8.0F, -2.0F, 1, 16, 2, 0.0F, true));*/
        bone.func_217178_a("right_front_side_feather_end",-14.0F, 7.0F, -6.0F, 5, 1, 2, 0.0F, 0, 32);
        bone.func_217178_a("left_front_side_feather_end",9.0F, 7.0F, -6.0F, 5, 1, 2, 0.0F, 0, 32);
        bone.func_217178_a("right_hind_side_feather_end",-14.0F, 7.0F, -2.0F, 5, 1, 2, 0.0F, 0, 32);
        bone.func_217178_a("left_hind_side_feather_end",9.0F, 7.0F, -2.0F, 5, 1, 2, 0.0F, 0, 32);
    }
    
    @Override
    protected Iterable<ModelRenderer> func_225602_a_()
    {
      //head/Main parts here 
        return ImmutableList.of(bone);
    }
    
    @Override
    protected Iterable<ModelRenderer> func_225600_b_()
    {
        return null;
    }
    
    public void render(final T willow, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch)
    {
        bone.rotateAngleX = headPitch * 0.017453292f;
        bone.rotateAngleY = netHeadYaw * 0.017453292f;
    }
    
    @Override
    public void func_225598_a_(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_,
                               float p_225598_7_, float p_225598_8_)
    {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void func_225597_a_(WillowEntity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float netHeadYaw, float headPitch)
    {
        
    }
    
    public void setRotationAngle(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}