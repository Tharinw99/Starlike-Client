package net.starlikeclient.minecraft.entities.render;

import net.lax1dude.eaglercraft.v1_8.opengl.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.starlikeclient.minecraft.entities.entity.EntityNetherCreeper;
import net.starlikeclient.minecraft.entities.entity.EntityWatcher;
import net.starlikeclient.minecraft.entities.model.ModelWatcher;

public class RenderWatcher extends RenderLiving<EntityWatcher> {
	private static final ResourceLocation watcherTexture = new ResourceLocation(
			"starlike:textures/entity/watcher/watcher.png");

	public RenderWatcher(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelWatcher(), 0.5F);
	}

	@Override
	public void doRender(EntityWatcher watcher, double d0, double d1, double d2, float f, float f1) {

		super.doRender(watcher, d0, d1, d2, f, f1);

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

	@Override
	protected ResourceLocation getEntityTexture(EntityWatcher var1) {
		return watcherTexture;
	}

	/**
	 * + Allows the render to do any OpenGL state modifications necessary before the
	 * model is rendered. Args: entityLiving, partialTickTime
	 */
	@Override
	protected void preRenderCallback(EntityWatcher entityWatcher, float f) {

		GlStateManager.scale(1, 1, 1);
	}
}
