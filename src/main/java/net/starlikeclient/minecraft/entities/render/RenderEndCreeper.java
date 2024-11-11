package net.starlikeclient.minecraft.entities.render;

import net.lax1dude.eaglercraft.v1_8.opengl.GlStateManager;
import net.lax1dude.eaglercraft.v1_8.opengl.ext.deferred.DeferredStateManager;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.starlikeclient.minecraft.entities.entity.EntityEndCreeper;
import net.starlikeclient.minecraft.entities.layers.LayerEndCreeperCharge;

public class RenderEndCreeper extends RenderLiving<EntityEndCreeper> {
	private static final ResourceLocation creeperTextures = new ResourceLocation(
			"starlike:textures/entity/endcreeper/endcreeper.png");

	public RenderEndCreeper(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelCreeper(), 0.5F);
		this.addLayer(new LayerEndCreeperCharge(this));
	}

	@Override
	public void doRender(EntityEndCreeper entityEndCreeper, double d0, double d1, double d2, float f, float f1) {
		float ff = entityEndCreeper.getCreeperFlashIntensity(f);
		if ((int) (ff * 10.0F) % 2 != 0) {
			DeferredStateManager.setEmissionConstant(1.0f);
		}
		try {
			super.doRender(entityEndCreeper, d0, d1, d2, f, f1);
		} finally {
			DeferredStateManager.setEmissionConstant(0.0f);
		}
	}

	/**
	 * + Returns an ARGB int color back. Args: entityLiving, lightBrightness,
	 * partialTickTime
	 */
	@Override
	protected int getColorMultiplier(EntityEndCreeper entityEndCreeper, float var2, float f) {
		float f1 = entityEndCreeper.getCreeperFlashIntensity(f);
		if ((int) (f1 * 10.0F) % 2 == 0) {
			return 0;
		} else {
			int i = (int) (f1 * 0.2F * 255.0F);
			i = MathHelper.clamp_int(i, 0, 255);
			return i << 24 | 16777215;
		}
	}

	/**
	 * + Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	@Override
	protected ResourceLocation getEntityTexture(EntityEndCreeper var1) {
		return creeperTextures;
	}

	/**
	 * + Allows the render to do any OpenGL state modifications necessary before the
	 * model is rendered. Args: entityLiving, partialTickTime
	 */
	@Override
	protected void preRenderCallback(EntityEndCreeper entityEndCreeper, float f) {
		float f1 = entityEndCreeper.getCreeperFlashIntensity(f);
		float f2 = 1.0F + MathHelper.sin(f1 * 100.0F) * f1 * 0.01F;
		f1 = MathHelper.clamp_float(f1, 0.0F, 1.0F);
		f1 = f1 * f1;
		f1 = f1 * f1;
		float f3 = (1.0F + f1 * 0.4F) * f2;
		float f4 = (1.0F + f1 * 0.1F) / f2;
		GlStateManager.scale(f3, f4, f3);
	}
}
