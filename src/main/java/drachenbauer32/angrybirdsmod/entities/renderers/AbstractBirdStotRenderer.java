package drachenbauer32.angrybirdsmod.entities.renderers;

import java.nio.FloatBuffer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.blaze3d.platform.GLX;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.entity.Entity;
import net.minecraft.util.Util;

public abstract class AbstractBirdStotRenderer<T extends Entity, M extends EntityModel<T>> extends EntityRenderer<T> implements IEntityRenderer<T, M> 
{
    private static final Logger LOGGER = LogManager.getLogger();
    
    private static final DynamicTexture TEXTURE_BRIGHTNESS = Util.make(new DynamicTexture(16, 16, false), (p_203414_0_) ->
    {
        p_203414_0_.getTextureData().untrack();
        
        for(int i = 0; i < 16; ++i)
        {
            for(int j = 0; j < 16; ++j)
            {
                p_203414_0_.getTextureData().setPixelRGBA(j, i, -1);
            }
        }
        
        p_203414_0_.updateDynamicTexture();
    }
    );
    
    protected M entityModel;
    protected final FloatBuffer brightnessBuffer = GLAllocation.createDirectFloatBuffer(4);
    protected boolean renderMarker;
    
    protected AbstractBirdStotRenderer(EntityRendererManager manager, M model, float shadow) {
        super(manager);
        this.entityModel = model;
        this.shadowSize = shadow;
    }
    
    public M getEntityModel()
    {
        return this.entityModel;
    }
    
    public void doRender(T entity, double x, double y, double z, float entityYaw, float partialTicks) {
        //if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.RenderLivingEvent.Pre<T, M>(entity, this, partialTicks, x, y, z))) return;
        GlStateManager.pushMatrix();
        GlStateManager.disableCull();
        
        try
        {
            this.renderEntityAt(entity, x, y, z);
            float f8 = this.handleRotationFloat(entity, partialTicks);
            float f2 = 0.0F;
            float f4 = this.prepareScale(entity, partialTicks);
            float f5 = 0.0F;
            float f6 = 0.0F;
            float f7 = 0.0F;
            
            GlStateManager.enableAlphaTest();
            
            this.entityModel.setLivingAnimations(entity, f6, f5, partialTicks);
            this.entityModel.setRotationAngles(entity, f6, f5, f8, f2, f7, f4);
            
            if (this.renderOutlines)
            {
                if (!this.renderMarker)
                {
                    this.renderModel(entity, f6, f5, f8, f2, f7, f4);
                }
            }
            else
            {
                boolean flag1 = this.setDoRenderBrightness(entity, partialTicks);
                this.renderModel(entity, f6, f5, f8, f2, f7, f4);
                if (flag1)
                {
                    this.unsetBrightness();
                }
                
                GlStateManager.depthMask(true);
            }
            
            GlStateManager.disableRescaleNormal();
        }
        catch (Exception exception)
        {
            LOGGER.error("Couldn't render entity", (Throwable)exception);
        }
        
        GlStateManager.activeTexture(GLX.GL_TEXTURE1);
        GlStateManager.enableTexture();
        GlStateManager.activeTexture(GLX.GL_TEXTURE0);
        GlStateManager.enableCull();
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        //net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.RenderLivingEvent.Post<T, M>(entity, this, partialTicks, x, y, z));
    }
    
    public float prepareScale(T entitylivingbaseIn, float partialTicks)
    {
        GlStateManager.enableRescaleNormal();
        GlStateManager.scalef(-1.0F, -1.0F, 1.0F);
        this.preRenderCallback(entitylivingbaseIn, partialTicks);
        //float f = 0.0625F;
        GlStateManager.translatef(0.0F, -1.501F, 0.0F);
        return 0.0625F;
    }
    
    protected void renderModel(T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
    {
        boolean flag = this.isVisible(entitylivingbaseIn);
        
        if (flag)
        {
            if (!this.bindEntityTexture(entitylivingbaseIn))
            {
                return;
            }
            
            this.entityModel.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
        }
    }
    
    protected boolean isVisible(T p_193115_1_)
    {
        return !p_193115_1_.isInvisible() || this.renderOutlines;
    }
    
    protected boolean setDoRenderBrightness(T entityLivingBaseIn, float partialTicks)
    {
        return this.setBrightness(entityLivingBaseIn, partialTicks, true);
    }
    
    protected boolean setBrightness(T entitylivingbaseIn, float partialTicks, boolean combineTextures)
    {
        float f = entitylivingbaseIn.getBrightness();
        int i = this.getColorMultiplier(entitylivingbaseIn, f, partialTicks);
        boolean flag = (i >> 24 & 255) > 0;
        
        if (!flag && !combineTextures)
        {
            return false;
        }
        else
        {
            GlStateManager.activeTexture(GLX.GL_TEXTURE0);
            GlStateManager.enableTexture();
            GlStateManager.texEnv(8960, 8704, GLX.GL_COMBINE);
            GlStateManager.texEnv(8960, GLX.GL_COMBINE_RGB, 8448);
            GlStateManager.texEnv(8960, GLX.GL_SOURCE0_RGB, GLX.GL_TEXTURE0);
            GlStateManager.texEnv(8960, GLX.GL_SOURCE1_RGB, GLX.GL_PRIMARY_COLOR);
            GlStateManager.texEnv(8960, GLX.GL_OPERAND0_RGB, 768);
            GlStateManager.texEnv(8960, GLX.GL_OPERAND1_RGB, 768);
            GlStateManager.texEnv(8960, GLX.GL_COMBINE_ALPHA, 7681);
            GlStateManager.texEnv(8960, GLX.GL_SOURCE0_ALPHA, GLX.GL_TEXTURE0);
            GlStateManager.texEnv(8960, GLX.GL_OPERAND0_ALPHA, 770);
            GlStateManager.activeTexture(GLX.GL_TEXTURE1);
            GlStateManager.enableTexture();
            GlStateManager.texEnv(8960, 8704, GLX.GL_COMBINE);
            GlStateManager.texEnv(8960, GLX.GL_COMBINE_RGB, GLX.GL_INTERPOLATE);
            GlStateManager.texEnv(8960, GLX.GL_SOURCE0_RGB, GLX.GL_CONSTANT);
            GlStateManager.texEnv(8960, GLX.GL_SOURCE1_RGB, GLX.GL_PREVIOUS);
            GlStateManager.texEnv(8960, GLX.GL_SOURCE2_RGB, GLX.GL_CONSTANT);
            GlStateManager.texEnv(8960, GLX.GL_OPERAND0_RGB, 768);
            GlStateManager.texEnv(8960, GLX.GL_OPERAND1_RGB, 768);
            GlStateManager.texEnv(8960, GLX.GL_OPERAND2_RGB, 770);
            GlStateManager.texEnv(8960, GLX.GL_COMBINE_ALPHA, 7681);
            GlStateManager.texEnv(8960, GLX.GL_SOURCE0_ALPHA, GLX.GL_PREVIOUS);
            GlStateManager.texEnv(8960, GLX.GL_OPERAND0_ALPHA, 770);
            this.brightnessBuffer.position(0);
            
            float f1 = (float)(i >> 24 & 255) / 255.0F;
            float f2 = (float)(i >> 16 & 255) / 255.0F;
            float f3 = (float)(i >> 8 & 255) / 255.0F;
            float f4 = (float)(i & 255) / 255.0F;
            this.brightnessBuffer.put(f2);
            this.brightnessBuffer.put(f3);
            this.brightnessBuffer.put(f4);
            this.brightnessBuffer.put(1.0F - f1);
            
            this.brightnessBuffer.flip();
            GlStateManager.texEnv(8960, 8705, this.brightnessBuffer);
            GlStateManager.activeTexture(GLX.GL_TEXTURE2);
            GlStateManager.enableTexture();
            GlStateManager.bindTexture(TEXTURE_BRIGHTNESS.getGlTextureId());
            GlStateManager.texEnv(8960, 8704, GLX.GL_COMBINE);
            GlStateManager.texEnv(8960, GLX.GL_COMBINE_RGB, 8448);
            GlStateManager.texEnv(8960, GLX.GL_SOURCE0_RGB, GLX.GL_PREVIOUS);
            GlStateManager.texEnv(8960, GLX.GL_SOURCE1_RGB, GLX.GL_TEXTURE1);
            GlStateManager.texEnv(8960, GLX.GL_OPERAND0_RGB, 768);
            GlStateManager.texEnv(8960, GLX.GL_OPERAND1_RGB, 768);
            GlStateManager.texEnv(8960, GLX.GL_COMBINE_ALPHA, 7681);
            GlStateManager.texEnv(8960, GLX.GL_SOURCE0_ALPHA, GLX.GL_PREVIOUS);
            GlStateManager.texEnv(8960, GLX.GL_OPERAND0_ALPHA, 770);
            GlStateManager.activeTexture(GLX.GL_TEXTURE0);
            return true;
        }
    }
    
    protected void unsetBrightness() {
        GlStateManager.activeTexture(GLX.GL_TEXTURE0);
        GlStateManager.enableTexture();
        GlStateManager.texEnv(8960, 8704, GLX.GL_COMBINE);
        GlStateManager.texEnv(8960, GLX.GL_COMBINE_RGB, 8448);
        GlStateManager.texEnv(8960, GLX.GL_SOURCE0_RGB, GLX.GL_TEXTURE0);
        GlStateManager.texEnv(8960, GLX.GL_SOURCE1_RGB, GLX.GL_PRIMARY_COLOR);
        GlStateManager.texEnv(8960, GLX.GL_OPERAND0_RGB, 768);
        GlStateManager.texEnv(8960, GLX.GL_OPERAND1_RGB, 768);
        GlStateManager.texEnv(8960, GLX.GL_COMBINE_ALPHA, 8448);
        GlStateManager.texEnv(8960, GLX.GL_SOURCE0_ALPHA, GLX.GL_TEXTURE0);
        GlStateManager.texEnv(8960, GLX.GL_SOURCE1_ALPHA, GLX.GL_PRIMARY_COLOR);
        GlStateManager.texEnv(8960, GLX.GL_OPERAND0_ALPHA, 770);
        GlStateManager.texEnv(8960, GLX.GL_OPERAND1_ALPHA, 770);
        GlStateManager.activeTexture(GLX.GL_TEXTURE1);
        GlStateManager.texEnv(8960, 8704, GLX.GL_COMBINE);
        GlStateManager.texEnv(8960, GLX.GL_COMBINE_RGB, 8448);
        GlStateManager.texEnv(8960, GLX.GL_OPERAND0_RGB, 768);
        GlStateManager.texEnv(8960, GLX.GL_OPERAND1_RGB, 768);
        GlStateManager.texEnv(8960, GLX.GL_SOURCE0_RGB, 5890);
        GlStateManager.texEnv(8960, GLX.GL_SOURCE1_RGB, GLX.GL_PREVIOUS);
        GlStateManager.texEnv(8960, GLX.GL_COMBINE_ALPHA, 8448);
        GlStateManager.texEnv(8960, GLX.GL_OPERAND0_ALPHA, 770);
        GlStateManager.texEnv(8960, GLX.GL_SOURCE0_ALPHA, 5890);
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.activeTexture(GLX.GL_TEXTURE2);
        GlStateManager.disableTexture();
        GlStateManager.bindTexture(0);
        GlStateManager.texEnv(8960, 8704, GLX.GL_COMBINE);
        GlStateManager.texEnv(8960, GLX.GL_COMBINE_RGB, 8448);
        GlStateManager.texEnv(8960, GLX.GL_OPERAND0_RGB, 768);
        GlStateManager.texEnv(8960, GLX.GL_OPERAND1_RGB, 768);
        GlStateManager.texEnv(8960, GLX.GL_SOURCE0_RGB, 5890);
        GlStateManager.texEnv(8960, GLX.GL_SOURCE1_RGB, GLX.GL_PREVIOUS);
        GlStateManager.texEnv(8960, GLX.GL_COMBINE_ALPHA, 8448);
        GlStateManager.texEnv(8960, GLX.GL_OPERAND0_ALPHA, 770);
        GlStateManager.texEnv(8960, GLX.GL_SOURCE0_ALPHA, 5890);
        GlStateManager.activeTexture(GLX.GL_TEXTURE0);
    }
    
    protected int getColorMultiplier(T entitylivingbaseIn, float lightBrightness, float partialTickTime)
    {
        return 0;
    }
    
    protected void preRenderCallback(T entitylivingbaseIn, float partialTickTime)
    {
        
    }
    
    protected float handleRotationFloat(T livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }
    
    protected void renderEntityAt(T entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translatef((float)x, (float)y, (float)z);
    }
}
