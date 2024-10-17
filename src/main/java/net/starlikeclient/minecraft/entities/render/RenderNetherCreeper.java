package net.starlikeclient.minecraft.entities.render;

import net.lax1dude.eaglercraft.v1_8.opengl.GlStateManager;
import net.lax1dude.eaglercraft.v1_8.opengl.ext.deferred.DeferredStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.starlikeclient.minecraft.entities.entity.EntityNetherCreeper;
import net.starlikeclient.minecraft.entities.layers.LayerNetherCreeperCharge;
import net.starlikeclient.minecraft.entities.model.ModelNetherCreeper;

public class RenderNetherCreeper extends RenderLiving<EntityNetherCreeper> {
	private static final ResourceLocation creeperTextures = new ResourceLocation(
			"starlike:textures/entity/nethercreeper/creeper.png");

	public RenderNetherCreeper(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelNetherCreeper(), 0.5F);
		this.addLayer(new LayerNetherCreeperCharge(this));
	}

	public void doRender(EntityNetherCreeper entitycreeper, double d0, double d1, double d2, float f, float f1) {
		float ff = entitycreeper.getCreeperFlashIntensity(f);
		if ((int) (ff * 10.0F) % 2 != 0) {
			DeferredStateManager.setEmissionConstant(1.0f);
		}
		try {
			super.doRender(entitycreeper, d0, d1, d2, f, f1);
		} finally {
			DeferredStateManager.setEmissionConstant(0.0f);
		}
	}

	/**
	 * + Returns an ARGB int color back. Args: entityLiving, lightBrightness,
	 * partialTickTime
	 */
	protected int getColorMultiplier(EntityNetherCreeper entitycreeper, float var2, float f) {
		float f1 = entitycreeper.getCreeperFlashIntensity(f);
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
	protected ResourceLocation getEntityTexture(EntityNetherCreeper var1) {
		return creeperTextures;
	}

	/**
	 * + Allows the render to do any OpenGL state modifications necessary before the
	 * model is rendered. Args: entityLiving, partialTickTime
	 */
	protected void preRenderCallback(EntityNetherCreeper entitycreeper, float f) {
		float f1 = entitycreeper.getCreeperFlashIntensity(f);
		float f2 = 1.0F + MathHelper.sin(f1 * 100.0F) * f1 * 0.01F;
		f1 = MathHelper.clamp_float(f1, 0.0F, 1.0F);
		f1 = f1 * f1;
		f1 = f1 * f1;
		float f3 = (1.0F + f1 * 0.4F) * f2;
		float f4 = (1.0F + f1 * 0.1F) / f2;
		GlStateManager.scale(f3, f4, f3);
	}
}