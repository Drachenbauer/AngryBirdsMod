package drachenbauer32.angrybirdsmod.entities.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import drachenbauer32.angrybirdsmod.entities.BombEntity;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BombModel<T extends BombEntity> extends AgeableModel<T>
{
    private final ModelRenderer bone;
    
    public BombModel()
    {
        textureWidth = 48;
        textureHeight = 24;
        
        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 18.0F, 0.0F);
        bone.func_217178_a("body", -6.0F, -6.0F, -6.0F, 12, 12, 12, 0.0F, 0, 0);
        bone.func_217178_a("beak_upper", -1.0F, -2.0F, -9.0F, 2, 1, 3, 0.0F, 36, 0);
        bone.func_217178_a("beak_lower", -1.0F, -1.0F, -8.0F, 2, 2, 2, 0.0F, 36, 4);
        bone.func_217178_a("head_feather", -1.0F, -13.0F, -1.0F, 2, 6, 2, 0.0F, 0, 0);
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
    
    public void render(final T bomb, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch)
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
    public void func_225597_a_(BombEntity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float netHeadYaw, float headPitch)
    {
        
    }
    
    public void setRotationAngle(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}