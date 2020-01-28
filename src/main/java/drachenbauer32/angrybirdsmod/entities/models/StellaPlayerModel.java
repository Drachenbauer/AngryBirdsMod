package drachenbauer32.angrybirdsmod.entities.models;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.HandSide;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StellaPlayerModel<T extends LivingEntity> extends BipedModel<T>
{
    private List<ModelRenderer> field_228286_w_ = Lists.newArrayList();
    
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer bone4;
    private final ModelRenderer bone5;
    
    public StellaPlayerModel(float modelSize, boolean smallArmsIn)
    {
        super(RenderType::func_228644_e_, modelSize, 0.0F, 64, 64);
        
        textureWidth = 32;
        textureHeight = 24;
        
        bipedHead = new ModelRenderer(this);
        bipedHead.setRotationPoint(0.0F, 20.0F, 0.0F);
        bipedHead.func_217178_a("body", -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, 0, 0);
        bipedHead.func_217178_a("beak", -1.0F, 2.0F, -5.0F, 2, 1, 1, 0.0F, 25, 0);
        bipedHead.func_217178_a("head_feather_1", 0.0F, -6.0F, -8.0F, 0, 2, 6, 0.0F, 10, 10);
        bipedHead.func_217178_a("tail_feather_1", 0.0F, 1.0F, 4.0F, 0, 1, 4, 0.0F, 24, 3);
        
        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, -4.0F, -2.0F);
        setRotationAngle(bone2, -0.5236F, 0.0F, 0.0F);
        bipedHead.addChild(bone2);
        bone2.func_217178_a("head_feather_2", 0.0F, -2.0F, -6.0F, 0, 2, 6, 0.0F, 10, 10);

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0F, -4.0F, -2.0F);
        setRotationAngle(bone3, -1.0472F, 0.0F, 0.0F);
        bipedHead.addChild(bone3);
        bone3.func_217178_a("head_feather_3", 0.0F, -2.0F, -6.0F, 0, 2, 8, 0.0F, 8, 8);
        
        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone4, 0.5236F, 0.0F, 0.0F);
        bipedHead.addChild(bone4);
        bone4.func_217178_a("tail_feather_2", 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, 24, 3);
        
        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(0.0F, 1.0F, 4.0F);
        setRotationAngle(bone5, -0.5236F, 0.0F, 0.0F);
        bipedHead.addChild(bone5);
        bone5.func_217178_a("tail_feather_3", 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, 24, 3);
        
        bipedRightArm = new ModelRenderer(this);
        bipedRightArm.setRotationPoint(-6.0F, 22.0F, -4.0F);
        setRotationAngle(bipedRightArm, -1.5708F, 0.0F, 0.0F);
        bipedRightArm.func_217178_a("invisible_right_arm", -2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F, 0, 16);
        
        bipedLeftArm = new ModelRenderer(this);
        bipedLeftArm.setRotationPoint(6.0F, 22.0F, -4.0F);
        setRotationAngle(bipedLeftArm, -1.5708F, 0.0F, 0.0F);
        bipedLeftArm.func_217178_a("invisible_left_arm", -2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F, 0, 16);
    }
    
    /*public void render(StellaPlayerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        bipedHead.render(scale);
        bipedRightArm.render(scale);
        bipedLeftArm.render(scale);
    }*/
    
    protected Iterable<ModelRenderer> func_225600_b_()
    {
        return super.func_225600_b_();
    }
    
    public void setRotationAngle(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void func_225599_a_(HandSide p_225599_1_, MatrixStack p_225599_2_)
    {
        ModelRenderer modelrenderer = this.getArmForSide(p_225599_1_);
        float f = 0.5F * (float)(p_225599_1_ == HandSide.RIGHT ? 1 : -1);
        modelrenderer.rotationPointX += f;
        modelrenderer.func_228307_a_(p_225599_2_);
        modelrenderer.rotationPointX -= f;
    }
    
    public ModelRenderer func_228288_a_(Random p_228288_1_)
    {
        return this.field_228286_w_.get(p_228288_1_.nextInt(this.field_228286_w_.size()));
    }
    
    public void accept(ModelRenderer p_accept_1_)
    {
        if (this.field_228286_w_ == null)
        {
            this.field_228286_w_ = Lists.newArrayList();
        }
        
        this.field_228286_w_.add(p_accept_1_);
    }
}