package net.starlikeclient;

import java.util.Iterator;

import com.logisticscraft.occlusionculling.DataProvider;
import com.logisticscraft.occlusionculling.OcclusionCullingInstance;
import com.logisticscraft.occlusionculling.util.Vec3d;

import net.lax1dude.eaglercraft.v1_8.EagRuntime;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;

public class Culling {
	private class CullingProvider implements DataProvider {
		private final Minecraft mc = Minecraft.getMinecraft();

		@Override
		public boolean isOpaqueFullCube(int x, int y, int z) {
			return this.mc.theWorld.getBlockState(new BlockPos(x, y, z)).getBlock().isOpaqueCube();
		}

		@Override
		public boolean prepareChunk(int var1, int var2) {
			return this.mc.theWorld != null;
		}
	}

	private static final Culling instance = new Culling();

	public static Culling getInstance() {
		return Culling.instance;
	}

	private final OcclusionCullingInstance culling = new OcclusionCullingInstance(
			StarlikeClient.Config.Culling.entityMaxTracingDistance, new CullingProvider());
	private final Minecraft mc = Minecraft.getMinecraft();
	public long lastPass = 0;
	public int renderedEntities = 0;
	public int culledEntities = 0;
	public int renderedBlockEntities = 0;
	public int culledBlockEntities = 0;

	public Culling() {
	}

	public void update() {
		if (this.mc.theWorld != null && this.mc.thePlayer != null && this.mc.thePlayer.ticksExisted > 0
				&& this.mc.getRenderViewEntity() != null && !this.mc.thePlayer.isSpectator()) {
			long startTime = EagRuntime.steadyTimeMillis();
			int renderedEntities = 0;
			int culledEntities = 0;
			int renderedBlockEntities = 0;
			int culledBlockEntities = 0;

			Vec3 cameraPos = this.mc.gameSettings.thirdPersonView == 0 ? this.mc.thePlayer.getPositionEyes(0)
					: this.mc.getRenderViewEntity().getPositionEyes(0);

			this.culling.resetCache();
			Vec3d aabbMin = new Vec3d(0, 0, 0);
			Vec3d aabbMax = new Vec3d(0, 0, 0);
			Vec3d viewerPosition = new Vec3d(cameraPos.xCoord, cameraPos.yCoord, cameraPos.zCoord);

			Iterator<Entity> entityIterator = this.mc.theWorld.loadedEntityList.iterator();
			while (entityIterator.hasNext()) {
				Entity entity = entityIterator.next();
				AxisAlignedBB boundingBox = entity.getEntityBoundingBox();
				if (entity != null
						&& !(entity instanceof EntityArmorStand && StarlikeClient.Config.Culling.skipMarkerArmorStands
								&& ((EntityArmorStand) entity).func_181026_s())
						&& entity.getPositionVector()
								.squareDistanceTo(cameraPos) <= StarlikeClient.Config.Culling.entityMaxTracingDistance
										* StarlikeClient.Config.Culling.entityMaxTracingDistance
						&& boundingBox.maxX - boundingBox.minX <= StarlikeClient.Config.Culling.entityHitboxSizeLimit
						&& boundingBox.maxY - boundingBox.minY <= StarlikeClient.Config.Culling.entityHitboxSizeLimit
						&& boundingBox.maxZ - boundingBox.minZ <= StarlikeClient.Config.Culling.entityHitboxSizeLimit) {
					aabbMin.set(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
					aabbMax.set(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);
					if (!this.culling.isAABBVisible(aabbMin, aabbMax, viewerPosition)) {
						entity.shouldCull = true;
						culledEntities++;
					} else {
						entity.shouldCull = false;
						renderedEntities++;
					}
				} else {
					entity.shouldCull = false;
					renderedEntities++;
				}
			}

			Iterator<TileEntity> tileEntityIterator = this.mc.theWorld.loadedTileEntityList.iterator();
			while (tileEntityIterator.hasNext()) {
				TileEntity tileentity = tileEntityIterator.next();
				BlockPos blockpos = tileentity.getPos();
				if (tileentity != null
						&& !StarlikeClient.Config.Culling.blockEntityWhitelist
								.contains(tileentity.getBlockType().getUnlocalizedName())
						&& blockpos.distanceSq(cameraPos.xCoord, cameraPos.yCoord, cameraPos.zCoord) < 64 * 64) {
					aabbMin.set(blockpos.getX(), blockpos.getY(), blockpos.getZ());
					aabbMax.set(blockpos.getX() + 1d, blockpos.getY() + 1d, blockpos.getZ() + 1d);
					if (!this.culling.isAABBVisible(aabbMin, aabbMax, viewerPosition)) {
						tileentity.shouldCull = true;
						culledBlockEntities++;
					} else {
						tileentity.shouldCull = false;
						renderedBlockEntities++;
					}
					;
				} else {
					tileentity.shouldCull = false;
					renderedBlockEntities++;
				}
			}

			this.renderedEntities = renderedEntities;
			this.culledEntities = culledEntities;
			this.renderedBlockEntities = renderedBlockEntities;
			this.culledBlockEntities = culledBlockEntities;
			this.lastPass = EagRuntime.steadyTimeMillis() - startTime;
		} else {
			this.lastPass = 0;
			this.renderedEntities = 0;
			this.culledEntities = 0;
			this.renderedBlockEntities = 0;
			this.culledBlockEntities = 0;
		}
	}
}
