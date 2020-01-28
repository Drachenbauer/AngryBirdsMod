package drachenbauer32.angrybirdsmod.entities.models;

import java.util.List;
import java.util.Random;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.HandSide;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StellaMoviePlayerModel<T extends LivingEntity> extends BipedModel<T>
{
    private List<ModelRenderer> field_228286_w_ = Lists.newArrayList();
    
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;;
    private final ModelRenderer bone5;
    private final ModelRenderer bone6;
    private final ModelRenderer bone10;
    private final ModelRenderer bone11;
    private final ModelRenderer bone12;
    private final ModelRenderer bone14;
    private final ModelRenderer bone15;
    private final ModelRenderer bone16;
    public ModelRenderer bipedHeadwear;
    public final ModelRenderer bipedLeftArmwear;
    public final ModelRenderer bipedRightArmwear;
    public final ModelRenderer bipedLeftLegwear;
    public final ModelRenderer bipedRightLegwear;
    public final ModelRenderer bipedBodyWear;
    private final ModelRenderer bipedCape;
    
    public StellaMoviePlayerModel (float modelSize, boolean smallArmsIn)
    {
        super(RenderType::func_228644_e_, modelSize, 0.0F, 64, 64);
        
        textureWidth = 64;
        textureHeight = 32;
        
        bipedHead = new ModelRenderer(this);
        bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedHead.func_217178_a("head", -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, 0, 0);
        bipedHead.func_217178_a("beak", -1.0F, -2.0F, -5.0F, 2, 1, 1, 0.0F, 25, 0);
        bipedHead.func_217178_a("head_feather_1", 0.0F, -10.0F, -8.0F, 0, 2, 6, 0.0F, 10, 10);
        
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
        
        bipedBody = new ModelRenderer(this);
        bipedBody.setRotationPoint(0.0F, 6.0F, 0.0F);
        bipedBody.func_217178_a("body", -4.0F, -6.0F, -2.0F, 8, 12, 4, 0.0F, 36, 0);
        bipedBody.func_217178_a("tail_feather_1", 0.0F, 3.0F, 2.0F, 0, 1, 4, 0.0F, 24, 3);
        
        this.bipedBodyWear = new ModelRenderer(this, 16, 32);
        this.bipedBodyWear.func_228301_a_(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, modelSize + 0.25F);
        this.bipedBodyWear.setRotationPoint(0.0F, 0.0F, 0.0F);
        
        this.bipedCape = new ModelRenderer(this, 0, 0);
        this.bipedCape.setTextureSize(64, 32);
        this.bipedCape.func_228301_a_(-5.0F, 0.0F, -1.0F, 10.0F, 16.0F, 1.0F, modelSize);
        
        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(0.0F, 3.0F, 2.0F);
        setRotationAngle(bone5, 0.5236F, 0.0F, 0.0F);
        bipedBody.addChild(bone5);
        bone5.func_217178_a("tail_feather_2", 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, 24, 3);
        
        bone6 = new ModelRenderer(this);
        bone6.setRotationPoint(0.0F, 3.0F, 2.0F);
        setRotationAngle(bone6, -0.5236F, 0.0F, 0.0F);
        bipedBody.addChild(bone6);
        bone6.func_217178_a("tail_feather_3", 0.0F, 0.0F, 0.0F, 0, 1, 4, 0.0F, 24, 3);
        
        bipedRightArm = new ModelRenderer(this);
        bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        bipedRightArm.func_217178_a("right_arm", -1.0F, -2.0F, -2.0F, 2, 12, 4, 0.0F, 0, 16);
        
        this.bipedRightArmwear = new ModelRenderer(this, 40, 32);
        this.bipedRightArmwear.func_228301_a_(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, modelSize + 0.25F);
        this.bipedRightArmwear.setRotationPoint(-5.0F, 2.5F, 10.0F);
        
        bipedLeftArm = new ModelRenderer(this);
        bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
        bipedLeftArm.func_217178_a("left_arm", -1.0F, -2.0F, -2.0F, 2, 12, 4, 0.0F, 12, 16);
        
        this.bipedLeftArmwear = new ModelRenderer(this, 48, 48);
        this.bipedLeftArmwear.func_228301_a_(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, modelSize + 0.25F);
        this.bipedLeftArmwear.setRotationPoint(5.0F, 2.5F, 0.0F);
        
        bipedRightLeg = new ModelRenderer(this);
        bipedRightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
        bipedRightLeg.func_217178_a("right_leg", -1.0F, -1.0F, -1.0F, 2, 13, 2, 0.0F, 36, 17);
        bipedRightLeg.func_217178_a("right_toe_1", -1.0F, 11.0F, -3.0F, 1, 1, 3, 0.0F, 28, 28);
        
        bone10 = new ModelRenderer(this);
        bone10.setRotationPoint(0.0F, 12.0F, 0.0F);
        setRotationAngle(bone10, 0.0F, 3.1416F, 0.0F);
        bipedRightLeg.addChild(bone10);
        bone10.func_217178_a("right_toe_2", -1.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, 28, 28);
        
        bone11 = new ModelRenderer(this);
        bone11.setRotationPoint(0.0F, 12.0F, 0.0F);
        setRotationAngle(bone11, 0.0F, 0.7854F, 0.0F);
        bipedRightLeg.addChild(bone11);
        bone11.func_217178_a("right_toe_3", -1.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, 28, 28);
        
        bone12 = new ModelRenderer(this);
        bone12.setRotationPoint(0.0F, 12.0F, 0.0F);
        setRotationAngle(bone12, 0.0F, -0.7854F, 0.0F);
        bipedRightLeg.addChild(bone12);
        bone12.func_217178_a("right_toe_4", -1.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, 28, 28);
        
        this.bipedRightLegwear = new ModelRenderer(this, 0, 32);
        this.bipedRightLegwear.func_228301_a_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize + 0.25F);
        this.bipedRightLegwear.setRotationPoint(-1.9F, 12.0F, 0.0F);
        
        bipedLeftLeg = new ModelRenderer(this);
        bipedLeftLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
        bipedLeftLeg.func_217178_a("left_leg", -1.0F, -1.0F, -1.0F, 2, 13, 2, 0.0F, 44, 17);
        bipedLeftLeg.func_217178_a("left_toe_1", 0.0F, 11.0F, -3.0F, 1, 1, 3, 0.0F, 52, 28);
        
        bone14 = new ModelRenderer(this);
        bone14.setRotationPoint(0.0F, 12.0F, 0.0F);
        setRotationAngle(bone14, 0.0F, 3.1416F, 0.0F);
        bipedLeftLeg.addChild(bone14);
        bone14.func_217178_a("left_toe_2", 0.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, 52, 28);
        
        bone15 = new ModelRenderer(this);
        bone15.setRotationPoint(0.0F, 12.0F, 0.0F);
        setRotationAngle(bone15, 0.0F, 0.7854F, 0.0F);
        bipedLeftLeg.addChild(bone15);
        bone15.func_217178_a("left_toe_3", 0.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, 52, 28);
        
        bone16 = new ModelRenderer(this);
        bone16.setRotationPoint(0.0F, 12.0F, 0.0F);
        setRotationAngle(bone16, 0.0F, -0.7854F, 0.0F);
        bipedLeftLeg.addChild(bone16);
        bone16.func_217178_a("left_toe_4", 0.0F, -1.0F, -3.0F, 1, 1, 3, 0.0F, 52, 28);
        
        this.bipedLeftLegwear = new ModelRenderer(this, 0, 48);
        this.bipedLeftLegwear.func_228301_a_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize + 0.25F);
        this.bipedLeftLegwear.setRotationPoint(1.9F, 12.0F, 0.0F);
    }
    
    protected Iterable<ModelRenderer> func_225600_b_()
    {
        return Iterables.concat(super.func_225600_b_(), ImmutableList.of(this.bipedLeftLegwear, this.bipedRightLegwear, this.bipedLeftArmwear, this.bipedRightArmwear, this.bipedBodyWear));
    }
    
    public void setRotationAngle(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void func_228289_b_(MatrixStack p_228289_1_, IVertexBuilder p_228289_2_, int p_228289_3_, int p_228289_4_)
    {
        this.bipedCape.func_228308_a_(p_228289_1_, p_228289_2_, p_228289_3_, p_228289_4_);
    }
    
    public void func_225597_a_(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_)
    {
        super.func_225597_a_(p_225597_1_, p_225597_2_, p_225597_3_, p_225597_4_, p_225597_5_, p_225597_6_);
        this.bipedLeftLegwear.copyModelAngles(this.bipedLeftLeg);
        this.bipedRightLegwear.copyModelAngles(this.bipedRightLeg);
        this.bipedLeftArmwear.copyModelAngles(this.bipedLeftArm);
        this.bipedRightArmwear.copyModelAngles(this.bipedRightArm);
        this.bipedBodyWear.copyModelAngles(this.bipedBody);
        
        if (p_225597_1_.isCrouching())
        {
            this.bipedCape.rotationPointY = 2.0F;
        }
        else
        {
            this.bipedCape.rotationPointY = 0.0F;
        }
    }
    
    public void setVisible(boolean visible)
    {
        super.setVisible(visible);
        this.bipedLeftArmwear.showModel = visible;
        this.bipedRightArmwear.showModel = visible;
        this.bipedLeftLegwear.showModel = visible;
        this.bipedRightLegwear.showModel = visible;
        this.bipedBodyWear.showModel = visible;
        this.bipedCape.showModel = visible;
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