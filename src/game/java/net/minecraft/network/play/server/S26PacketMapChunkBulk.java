package net.minecraft.network.play.server;

import java.io.IOException;
import java.util.List;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.world.chunk.Chunk;

/**
 * + This portion of EaglercraftX contains deobfuscated Minecraft 1.8 source
 * code.
 *
 * Minecraft 1.8.8 bytecode is (c) 2015 Mojang AB. "Do not distribute!" Mod
 * Coder Pack v9.18 deobfuscation configs are (c) Copyright by the MCP Team
 *
 * EaglercraftX 1.8 patch files (c) 2022-2025 lax1dude, ayunami2000. All Rights
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
public class S26PacketMapChunkBulk implements Packet<INetHandlerPlayClient> {
	private int[] chunkXPositions;
	private int[] chunkZPositions;
	private S21PacketChunkData.Extracted[] chunkDataArray;
	private boolean isOverworld;

	public S26PacketMapChunkBulk() {
	}

	/**
	 * Constructs a new bulk chunk packet.
	 *
	 * @param chunks The list of chunks to include in this packet.
	 */
	public S26PacketMapChunkBulk(List<Chunk> chunks) {
		int chunkCount = chunks.size();
		this.chunkXPositions = new int[chunkCount];
		this.chunkZPositions = new int[chunkCount];
		this.chunkDataArray = new S21PacketChunkData.Extracted[chunkCount];
		this.isOverworld = !chunks.get(0).getWorld().provider.getHasNoSky();

		for (int i = 0; i < chunkCount; ++i) {
			Chunk chunk = chunks.get(i);
			S21PacketChunkData.Extracted extractedData = S21PacketChunkData.func_179756_a(chunk, true, this.isOverworld,
					'\uffff');
			this.chunkXPositions[i] = chunk.xPosition;
			this.chunkZPositions[i] = chunk.zPosition;
			this.chunkDataArray[i] = extractedData;
		}
	}

	/**
	 * Gets the raw byte data of a specific chunk.
	 *
	 * @param index The index of the chunk.
	 * @return The byte array representing the chunk data.
	 */
	public byte[] getChunkBytes(int index) {
		return this.chunkDataArray[index].data;
	}

	public int getChunkCount() {
		return this.chunkXPositions.length;
	}

	public int getChunkSize(int index) {
		return this.chunkDataArray[index].dataSize;
	}

	public int getChunkX(int index) {
		return this.chunkXPositions[index];
	}

	public int getChunkZ(int index) {
		return this.chunkZPositions[index];
	}

	@Override
	public void processPacket(INetHandlerPlayClient handler) {
		handler.handleMapChunkBulk(this);
	}

	@Override
	public void readPacketData(PacketBuffer buffer) throws IOException {
		this.isOverworld = buffer.readBoolean();
		int chunkCount = buffer.readVarIntFromBuffer();

		this.chunkXPositions = new int[chunkCount];
		this.chunkZPositions = new int[chunkCount];
		this.chunkDataArray = new S21PacketChunkData.Extracted[chunkCount];

		for (int i = 0; i < chunkCount; ++i) {
			this.chunkXPositions[i] = buffer.readInt();
			this.chunkZPositions[i] = buffer.readInt();
			this.chunkDataArray[i] = new S21PacketChunkData.Extracted();
			this.chunkDataArray[i].dataSize = buffer.readShort() & 0xFFFF;
			this.chunkDataArray[i].data = new byte[S21PacketChunkData
					.func_180737_a(Integer.bitCount(this.chunkDataArray[i].dataSize), this.isOverworld, true)];
		}

		for (int i = 0; i < chunkCount; ++i) {
			buffer.readBytes(this.chunkDataArray[i].data);
		}
	}

	@Override
	public void writePacketData(PacketBuffer buffer) throws IOException {
		buffer.writeBoolean(this.isOverworld);
		buffer.writeVarIntToBuffer(this.chunkDataArray.length);

		for (int i = 0; i < this.chunkXPositions.length; ++i) {
			buffer.writeInt(this.chunkXPositions[i]);
			buffer.writeInt(this.chunkZPositions[i]);
			buffer.writeShort((short) (this.chunkDataArray[i].dataSize & 0xFFFF));
		}

		for (int i = 0; i < this.chunkXPositions.length; ++i) {
			buffer.writeBytes(this.chunkDataArray[i].data);
		}
	}
}
