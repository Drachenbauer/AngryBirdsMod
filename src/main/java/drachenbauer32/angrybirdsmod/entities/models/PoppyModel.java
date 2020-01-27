package drachenbauer32.angrybirdsmod.entities.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import drachenbauer32.angrybirdsmod.entities.PoppyEntity;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PoppyModel<T extends PoppyEntity> extends AgeableModel<T>
{
    private final ModelRenderer bone;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer bone4;
    private final ModelRenderer bone5;
    
    public PoppyModel()
    {
        textureWidth = 32;
        textureHeight = 18;
        
        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 20.0F, 0.0F);
        bone.func_217178_a("body", -4.0F, -6.0F, -4.0F, 8, 10, 8, 0.0F, 0, 0);
        bone.func_217178_a("beak_upper", -1.0F, -3.0F, -6.0F, 2, 2, 2, 0.0F, 24, 0);
        bone.func_217178_a("beak_lower", -1.0F, -1.0F, -5.0F, 2, 1, 1, 0.0F, 25, 5);
        bone.func_217178_a("head_feather_1", 0.0F, -6.0F, 3.0F, 0, 2, 4, 0.0F, 0, 2);
        bone.func_217178_a("tail_feather_1", 0.0F, 1.0F, 4.0F, 0, 1, 4, 0.0F, 0, 2);
        
        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, -5.0F, 3.0F);
        setRotationAngle(bone2, 0.6109F, 0.0F, 0.0F);
        bone.addChild(bone2);
        bone2.func_217178_a("head_feather_2", 0.0F, -1.0F, 0.0F, 0, 2, 4, 0.0F, 0, 2);
        
        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0F, -5.0F, 3.0F);
        setRotationAngle(bone3, -0.6109F, 0.0F, 0.0F);
        bone.addChild(bone3);
        bone3.func_217178_a("head_feather_3", 0.0F, -1.0F, 0.0F, 0, 2, 4, 0.0F, 0, 2);
        
        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone4, 0.5236F, 0.0F, 0.0F);
        bone.addChild(bone4);
        bone4.func_217178_a("tail_feather_2", 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, 0, 2);
        
        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone5, -0.5236F, 0.0F, 0.0F);
        bone.addChild(bone5);
        bone5.func_217178_a("tail_feather_3", 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, 0, 2);
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
    
    public void render(final T poppy, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch)
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
    public void func_225597_a_(PoppyEntity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float netHeadYaw, float headPitch)
    {
        
    }
    
    public void setRotationAngle(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}