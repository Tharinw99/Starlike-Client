package net.starlikeclient.minecraft.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWatcher extends ModelBase {
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer head;
	private final ModelRenderer leg;

	public ModelWatcher() {
		textureWidth = 64;
		textureHeight = 64;

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(0.0F, 24.0F, 0.0F);
		leg2.cubeList.add(new ModelBox(leg2, 20, 17, -4.0F, -6.0F, -12.0F, 2, 2, 8, 0.0F, false));

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(-3.0F, 0.0F, -5.0F);
		leg3.cubeList.add(new ModelBox(leg3, 0, 27, 4.0F, 16.0F, -7.0F, 2, 2, 8, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(-3.0F, 0.0F, -5.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -1.0F, 16.0F, 1.0F, 8, 8, 9, 0.0F, false));

		leg = new ModelRenderer(this);
		leg.setRotationPoint(0.0F, 24.0F, 0.0F);
		leg.cubeList.add(new ModelBox(leg, 0, 17, -1.0F, -3.0F, -12.0F, 2, 2, 8, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		leg2.render(f5);
		leg3.render(f5);
		head.render(f5);
		leg.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = -x;
		modelRenderer.rotateAngleY = -y;
		modelRenderer.rotateAngleZ = -z;
	}
}
