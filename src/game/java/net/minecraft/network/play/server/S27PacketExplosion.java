package net.minecraft.network.play.server;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;

/**
 * + This portion of EaglercraftX contains deobfuscated Minecraft 1.8 source
 * code.
 *
 * Minecraft 1.8.8 bytecode is (c) 2015 Mojang AB. "Do not distribute!" Mod
 * Coder Pack v9.18 deobfuscation configs are (c) Copyright by the MCP Team
 *
 * EaglercraftX 1.8 patch files (c) 2022-2024 lax1dude, ayunami2000. All Rights
 * Reserved.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 */
public class S27PacketExplosion implements Packet<INetHandlerPlayClient> {
	private double posX, posY, posZ;
	private float strength;
	private List<BlockPos> affectedBlockPositions;
	private float motionX, motionY, motionZ;
	private float field_149152_f;
	private float field_149153_g;
	private float field_149159_h;

	public S27PacketExplosion() {
	}

	public S27PacketExplosion(double x, double y, double z, float strengthIn, List<BlockPos> affectedBlocksIn,
			Vec3 motion) {
		this.posX = x;
		this.posY = y;
		this.posZ = z;
		this.strength = strengthIn;
		this.affectedBlockPositions = Collections.unmodifiableList(Lists.newArrayList(affectedBlocksIn));
		if (motion != null) {
			this.motionX = (float) motion.xCoord;
			this.motionY = (float) motion.yCoord;
			this.motionZ = (float) motion.zCoord;
		}
	}

	public float func_149144_d() {
		return this.field_149153_g;
	}

	public float func_149147_e() {
		return this.field_149159_h;
	}

	public float func_149149_c() {
		return this.field_149152_f;
	}

	public List<BlockPos> getAffectedBlockPositions() {
		return this.affectedBlockPositions;
	}

	public float getStrength() {
		return this.strength;
	}

	public double getX() {
		return this.posX;
	}

	public double getY() {
		return this.posY;
	}

	public double getZ() {
		return this.posZ;
	}

	@Override
	public void processPacket(INetHandlerPlayClient handler) {
		handler.handleExplosion(this);
	}

	@Override
	public void readPacketData(PacketBuffer buf) throws IOException {
		this.posX = buf.readFloat();
		this.posY = buf.readFloat();
		this.posZ = buf.readFloat();
		this.strength = buf.readFloat();

		int affectedBlocks = buf.readInt();
		if (affectedBlocks < 0 || affectedBlocks > 4096) {
			throw new IOException("Too many affected blocks: " + affectedBlocks);
		}

		this.affectedBlockPositions = Lists.newArrayListWithCapacity(affectedBlocks);
		for (int i = 0; i < affectedBlocks; i++) {
			int x = buf.readByte() + (int) posX;
			int y = buf.readByte() + (int) posY;
			int z = buf.readByte() + (int) posZ;
			this.affectedBlockPositions.add(new BlockPos(x, y, z));
		}

		this.motionX = buf.readFloat();
		this.motionY = buf.readFloat();
		this.motionZ = buf.readFloat();
	}

	@Override
	public void writePacketData(PacketBuffer buf) throws IOException {
		buf.writeFloat((float) this.posX);
		buf.writeFloat((float) this.posY);
		buf.writeFloat((float) this.posZ);
		buf.writeFloat(this.strength);

		buf.writeInt(this.affectedBlockPositions.size());
		for (BlockPos blockPos : this.affectedBlockPositions) {
			buf.writeByte(blockPos.getX() - (int) posX);
			buf.writeByte(blockPos.getY() - (int) posY);
			buf.writeByte(blockPos.getZ() - (int) posZ);
		}

		buf.writeFloat(this.motionX);
		buf.writeFloat(this.motionY);
		buf.writeFloat(this.motionZ);
	}

}
