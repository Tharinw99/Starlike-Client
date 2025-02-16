package net.minecraft.tileentity;

import org.json.JSONException;

import net.lax1dude.eaglercraft.v1_8.profanity_filter.ProfanityFilter;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S33PacketUpdateSign;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentProcessor;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

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
public class TileEntitySign extends TileEntity {
	public final IChatComponent[] signText = new IChatComponent[] { new ChatComponentText(""),
			new ChatComponentText(""), new ChatComponentText(""), new ChatComponentText("") };
	protected IChatComponent[] signTextProfanityFilter = null;
	/**
	 * + The index of the line currently being edited. Only used on client side, but
	 * defined on both. Note this is only really used when the > < are going to be
	 * visible.
	 */
	public int lineBeingEdited = -1;
	private boolean isEditable = true;
	private EntityPlayer player;
	private final CommandResultStats stats = new CommandResultStats();

	public void clearProfanityFilterCache() {
		signTextProfanityFilter = null;
	}

	public boolean executeCommand(final EntityPlayer playerIn) {
		ICommandSender icommandsender = new ICommandSender() {
			@Override
			public void addChatMessage(IChatComponent var1) {
			}

			@Override
			public boolean canCommandSenderUseCommand(int j, String var2) {
				return j <= 2;
			}

			@Override
			public Entity getCommandSenderEntity() {
				return playerIn;
			}

			@Override
			public IChatComponent getDisplayName() {
				return playerIn.getDisplayName();
			}

			@Override
			public World getEntityWorld() {
				return playerIn.getEntityWorld();
			}

			@Override
			public String getName() {
				return playerIn.getName();
			}

			@Override
			public BlockPos getPosition() {
				return TileEntitySign.this.pos;
			}

			@Override
			public Vec3 getPositionVector() {
				return new Vec3((double) TileEntitySign.this.pos.getX() + 0.5D,
						(double) TileEntitySign.this.pos.getY() + 0.5D, (double) TileEntitySign.this.pos.getZ() + 0.5D);
			}

			@Override
			public boolean sendCommandFeedback() {
				return false;
			}

			@Override
			public void setCommandStat(CommandResultStats.Type commandresultstats$type, int j) {
				TileEntitySign.this.stats.func_179672_a(this, commandresultstats$type, j);
			}
		};

		for (int i = 0; i < this.signText.length; ++i) {
			ChatStyle chatstyle = this.signText[i] == null ? null : this.signText[i].getChatStyle();
			if (chatstyle != null && chatstyle.getChatClickEvent() != null) {
				ClickEvent clickevent = chatstyle.getChatClickEvent();
				if (clickevent.getAction() == ClickEvent.Action.RUN_COMMAND) {
					MinecraftServer.getServer().getCommandManager().executeCommand(icommandsender,
							clickevent.getValue());
				}
			}
		}

		return true;
	}

	@Override
	public boolean func_183000_F() {
		return true;
	}

	/**
	 * + Allows for a specialized description packet to be created. This is often
	 * used to sync tile entity data from the server to the client easily. For
	 * example this is used by signs to synchronise the text to be displayed.
	 */
	@Override
	public Packet getDescriptionPacket() {
		IChatComponent[] aichatcomponent = new IChatComponent[4];
		System.arraycopy(this.signText, 0, aichatcomponent, 0, 4);
		return new S33PacketUpdateSign(this.worldObj, this.pos, aichatcomponent);
	}

	public boolean getIsEditable() {
		return this.isEditable;
	}

	public EntityPlayer getPlayer() {
		return this.player;
	}

	public IChatComponent[] getSignTextProfanityFilter() {
		if (Minecraft.getMinecraft().isEnableProfanityFilter()) {
			if (signTextProfanityFilter == null) {
				signTextProfanityFilter = new IChatComponent[4];
				ProfanityFilter filter = ProfanityFilter.getInstance();
				for (int i = 0; i < 4; ++i) {
					signTextProfanityFilter[i] = filter.profanityFilterChatComponent(signText[i]);
				}
			}
			return signTextProfanityFilter;
		} else {
			return signText;
		}
	}

	public CommandResultStats getStats() {
		return this.stats;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbttagcompound) {
		this.isEditable = false;
		super.readFromNBT(nbttagcompound);
		ICommandSender icommandsender = new ICommandSender() {
			@Override
			public void addChatMessage(IChatComponent var1) {
			}

			@Override
			public boolean canCommandSenderUseCommand(int var1, String var2) {
				return true;
			}

			@Override
			public Entity getCommandSenderEntity() {
				return null;
			}

			@Override
			public IChatComponent getDisplayName() {
				return new ChatComponentText(this.getName());
			}

			@Override
			public World getEntityWorld() {
				return TileEntitySign.this.worldObj;
			}

			@Override
			public String getName() {
				return "Sign";
			}

			@Override
			public BlockPos getPosition() {
				return TileEntitySign.this.pos;
			}

			@Override
			public Vec3 getPositionVector() {
				return new Vec3((double) TileEntitySign.this.pos.getX() + 0.5D,
						(double) TileEntitySign.this.pos.getY() + 0.5D, (double) TileEntitySign.this.pos.getZ() + 0.5D);
			}

			@Override
			public boolean sendCommandFeedback() {
				return false;
			}

			@Override
			public void setCommandStat(CommandResultStats.Type var1, int var2) {
			}
		};

		for (int i = 0; i < 4; ++i) {
			String s = nbttagcompound.getString("Text" + (i + 1));

			try {
				IChatComponent ichatcomponent = IChatComponent.Serializer.jsonToComponent(s);

				try {
					this.signText[i] = ChatComponentProcessor.processComponent(icommandsender, ichatcomponent,
							(Entity) null);
				} catch (CommandException var7) {
					this.signText[i] = ichatcomponent;
				}
			} catch (JSONException var8) {
				this.signText[i] = new ChatComponentText(s);
			}
		}

		this.stats.readStatsFromNBT(nbttagcompound);
	}

	/**
	 * + Sets the sign's isEditable flag to the specified parameter.
	 */
	public void setEditable(boolean isEditableIn) {
		this.isEditable = isEditableIn;
		if (!isEditableIn) {
			this.player = null;
		}

	}

	public void setPlayer(EntityPlayer playerIn) {
		this.player = playerIn;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbttagcompound) {
		super.writeToNBT(nbttagcompound);

		for (int i = 0; i < 4; ++i) {
			String s = IChatComponent.Serializer.componentToJson(this.signText[i]);
			nbttagcompound.setString("Text" + (i + 1), s);
		}

		this.stats.writeStatsToNBT(nbttagcompound);
	}
}
