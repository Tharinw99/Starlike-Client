package net.starlikeclient.minecraft.entities.layers;

import static net.lax1dude.eaglercraft.v1_8.opengl.RealOpenGLEnums.GL_MODELVIEW;
import static net.lax1dude.eaglercraft.v1_8.opengl.RealOpenGLEnums.GL_ONE;
import static net.lax1dude.eaglercraft.v1_8.opengl.RealOpenGLEnums.GL_TEXTURE;
import static net.lax1dude.eaglercraft.v1_8.opengl.RealOpenGLEnums.GL_ZERO;

import net.lax1dude.eaglercraft.v1_8.opengl.GlStateManager;
import net.lax1dude.eaglercraft.v1_8.opengl.ext.deferred.DeferredStateManager;
import net.lax1dude.eaglercraft.v1_8.opengl.ext.deferred.ShadersRenderPassFuture;
import net.lax1dude.eaglercraft.v1_8.vector.Matrix4f;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.starlikeclient.minecraft.entities.entity.EntityEndCreeper;
import net.starlikeclient.minecraft.entities.render.RenderEndCreeper;

public class LayerEndCreeperCharge implements LayerRenderer<EntityEndCreeper> {
	private static final ResourceLocation LIGHTNING_TEXTURE = new ResourceLocation(
			"textures/entity/creeper/creeper_armor.png");
	private final RenderEndCreeper EndCreeperRenderer;
	private final ModelCreeper EndCreeperModel = new ModelCreeper(2.0F);

	public LayerEndCreeperCharge(RenderEndCreeper EndCreeperRendererIn) {
		this.EndCreeperRenderer = EndCreeperRendererIn;
	}

	@Override
	public void doRenderLayer(EntityEndCreeper entityEndCreeper, float f, float f1, float f2, float f3, float f4,
			float f5, float f6) {
		if (entityEndCreeper.getPowered()) {
			if (DeferredStateManager.isInDeferredPass()) {
				if (DeferredStateManager.forwardCallbackHandler != null
						&& !DeferredStateManager.isEnableShadowRender()) {
					final Matrix4f mat = new Matrix4f(GlStateManager.getModelViewReference());
					DeferredStateManager.forwardCallbackHandler.push(new ShadersRenderPassFuture(entityEndCreeper) {
						@Override
						public void draw(PassType pass) {
							if (pass == PassType.MAIN) {
								DeferredStateManager.reportForwardRenderObjectPosition2(x, y, z);
							}
							boolean flag = entityEndCreeper.isInvisible();
							DeferredStateManager.setDefaultMaterialConstants();
							DeferredStateManager.setRoughnessConstant(0.3f);
							DeferredStateManager.setMetalnessConstant(0.1f);
							DeferredStateManager.setEmissionConstant(0.9f);
							EntityRenderer.disableLightmapStatic();
							GlStateManager.tryBlendFuncSeparate(GL_ONE, GL_ONE, GL_ZERO, GL_ZERO);
							GlStateManager.color(0.5F, 0.5F, 0.5F, 1.0F);
							if (flag) {
								GlStateManager.depthMask(false);
							}
							GlStateManager.pushMatrix();
							GlStateManager.loadMatrix(mat);
							GlStateManager.disableCull();
							GlStateManager.matrixMode(GL_TEXTURE);
							GlStateManager.pushMatrix();
							GlStateManager.loadIdentity();
							float f7 = entityEndCreeper.ticksExisted + f2;
							GlStateManager.translate(f7 * 0.01F, f7 * 0.01F, 0.0F);
							GlStateManager.matrixMode(GL_MODELVIEW);
							LayerEndCreeperCharge.this.EndCreeperRenderer.bindTexture(LIGHTNING_TEXTURE);
							LayerEndCreeperCharge.this.EndCreeperModel
									.setModelAttributes(LayerEndCreeperCharge.this.EndCreeperRenderer.getMainModel());
							LayerEndCreeperCharge.this.EndCreeperModel.setLivingAnimations(entityEndCreeper, f, f1, f1);
							LayerEndCreeperCharge.this.EndCreeperModel.render(entityEndCreeper, f, f1, f3, f4, f5, f6);
							GlStateManager.matrixMode(GL_TEXTURE);
							GlStateManager.popMatrix();
							GlStateManager.matrixMode(GL_MODELVIEW);
							GlStateManager.popMatrix();
							if (flag) {
								GlStateManager.depthMask(true);
							}
							GlStateManager.enableCull();
							DeferredStateManager.setDefaultMaterialConstants();
							DeferredStateManager.setHDRTranslucentPassBlendFunc();
							GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
						}
					});
				}
				return;
			}
			boolean flag = entityEndCreeper.isInvisible();
			if (flag) {
				GlStateManager.depthMask(false);
			}
			this.EndCreeperRenderer.bindTexture(LIGHTNING_TEXTURE);
			GlStateManager.matrixMode(GL_TEXTURE);
			GlStateManager.loadIdentity();
			float f7 = entityEndCreeper.ticksExisted + f2;
			GlStateManager.translate(f7 * 0.01F, f7 * 0.01F, 0.0F);
			GlStateManager.matrixMode(GL_MODELVIEW);
			GlStateManager.enableBlend();
			float f8 = 0.5F;
			GlStateManager.color(f8, f8, f8, 1.0F);
			GlStateManager.disableLighting();
			GlStateManager.blendFunc(GL_ONE, GL_ONE);
			this.EndCreeperModel.setModelAttributes(this.EndCreeperRenderer.getMainModel());
			this.EndCreeperModel.render(entityEndCreeper, f, f1, f3, f4, f5, f6);
			GlStateManager.matrixMode(GL_TEXTURE);
			GlStateManager.loadIdentity();
			GlStateManager.matrixMode(GL_MODELVIEW);
			GlStateManager.enableLighting();
			GlStateManager.disableBlend();
			if (flag) {
				GlStateManager.depthMask(true);
			}
		}
	}

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
}
