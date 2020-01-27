package drachenbauer32.angrybirdsmod.entities.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import drachenbauer32.angrybirdsmod.entities.CoralEntity;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class CoralModel<T extends CoralEntity> extends AgeableModel<T>
{
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;

	public CoralModel()
	{
		textureWidth = 56;
		textureHeight = 32;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 17.9F, 0.0F);
		bone.func_217178_a("head", -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, 0, 0);
		bone.func_217178_a("antenna_part_1", -0.5F, -12.0F, -4.0F, 1, 4, 1, 0.0F, 28, 0);
		bone.func_217178_a("antenna_part_2", -0.5F, -12.0F, -6.0F, 1, 1, 2, 0.0F, 24, 5);
		bone.func_217178_a("antenna_light", -1.0F, -12.0F, -8.0F, 2, 3, 2, 0.0F, 0, 0);
		bone.func_217178_a("back_fin", 0.0F, -12.0F, 0.0F, 0, 12, 6, 0.0F, 38, 6);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 19.9F, 0.0F);
		bone2.func_217178_a("body", -3.0F, -2.0F, -3.0F, 6, 4, 6, 0.0F, 32, 0);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-2.0F, 21.9F, -2.0F);
		bone3.func_217178_a("right_front_leg", -1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, 0, 16);
		bone3.func_217178_a("right_front_flipper",  -1.0F, 2.0F, -2.0F, 2, 0, 1, 0.0F, 1, 20);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(2.0F, 21.9F, -2.0F);
		bone4.func_217178_a("left_front_leg", -1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, 8, 16);
        bone4.func_217178_a("left_front_flipper",  -1.0F, 2.0F, -2.0F, 2, 0, 1, 0.0F, 9, 20);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(-2.0F, 21.9F, 2.0F);
		bone5.func_217178_a("right_hind_leg", -1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, 16, 16);
        bone5.func_217178_a("right_hind_flipper",  -1.0F, 2.0F, -2.0F, 2, 0, 1, 0.0F, 17, 20);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(2.0F, 21.9F, 2.0F);
		bone6.func_217178_a("left_hind_leg", -1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, 24, 16);
        bone6.func_217178_a("left_hind_flipper",  -1.0F, 2.0F, -2.0F, 2, 0, 1, 0.0F, 25, 20);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 19.9F, 3.0F);
		bone7.func_217178_a("tail_part_1", -2.0F, -2.0F, 0.0F, 4, 4, 4, 0.0F, 24, 16);
		bone7.func_217178_a("tail_part_1", -1.0F, 0.0F, 4.0F, 2, 2, 2, 0.0F, 24, 16);
        bone7.func_217178_a("tail_fin",  0.0F, -1.0F, 6.0f, 2, 0, 1, 0.0F, 25, 20);
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
      //All the other parts (without child parts) e.g.
        return ImmutableList.of(bone2, bone3, bone4, bone5, bone6, bone7);
    }
	
    public void render(final T coral, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch)
    {
        bone.rotateAngleX = headPitch * 0.017453292f;
        bone.rotateAngleY = netHeadYaw * 0.017453292f;
        this.bone3.rotateAngleY = 0.5235988f + MathHelper.cos(limbSwing * 5.0f) * 1.4f * limbSwingAmount;
        this.bone4.rotateAngleY = -0.5235988f + -(MathHelper.cos(limbSwing * 5.0f) * 1.4f * limbSwingAmount);
        this.bone5.rotateAngleY = -0.5235988f + -(MathHelper.cos(limbSwing * 5.0f) * 1.4f * limbSwingAmount);
        this.bone6.rotateAngleY = 0.5235988f + MathHelper.cos(limbSwing * 5.0f) * 1.4f * limbSwingAmount;
        //this.bone7.rotateAngleX = MathHelper.cos(limbSwing * 0.4662f) * 0.6f * limbSwingAmount;
    }
    
	@Override
    public void func_225598_a_(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_,
                               float p_225598_7_, float p_225598_8_)
    {
        
    }
    
    @Override
    public void func_225597_a_(CoralEntity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float netHeadYaw, float headPitch)
    {
        this.bone7.rotateAngleX = p_225597_4_;
    }
    
    public void setRotationAngle(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}