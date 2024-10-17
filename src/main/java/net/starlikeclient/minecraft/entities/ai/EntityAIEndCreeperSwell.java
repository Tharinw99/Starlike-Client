package net.starlikeclient.minecraft.entities.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.starlikeclient.minecraft.entities.entity.EntityEndCreeper;

public class EntityAIEndCreeperSwell extends EntityAIBase {
	EntityEndCreeper swellingCreeper;
	EntityLivingBase creeperAttackTarget;

	public EntityAIEndCreeperSwell(EntityEndCreeper entityEndCreeper) {
		this.swellingCreeper = entityEndCreeper;
		this.setMutexBits(1);
	}

	/**
	 * + Resets the task
	 */
	public void resetTask() {
		this.creeperAttackTarget = null;
	}

	/**
	 * + Returns whether the EntityAIBase should begin execution.
	 */
	public boolean shouldExecute() {
		EntityLivingBase entitylivingbase = this.swellingCreeper.getAttackTarget();
		return this.swellingCreeper.getCreeperState() > 0
				|| entitylivingbase != null && this.swellingCreeper.getDistanceSqToEntity(entitylivingbase) < 9.0D;
	}

	/**
	 * + Execute a one shot task or start executing a continuous task
	 */
	public void startExecuting() {
		this.swellingCreeper.getNavigator().clearPathEntity();
		this.creeperAttackTarget = this.swellingCreeper.getAttackTarget();
	}

	/**
	 * + Updates the task
	 */
	public void updateTask() {
		if (this.creeperAttackTarget == null) {
			this.swellingCreeper.setCreeperState(-1);
		} else if (this.swellingCreeper.getDistanceSqToEntity(this.creeperAttackTarget) > 49.0D) {
			this.swellingCreeper.setCreeperState(-1);
		} else if (!this.swellingCreeper.getEntitySenses().canSee(this.creeperAttackTarget)) {
			this.swellingCreeper.setCreeperState(-1);
		} else {
			this.swellingCreeper.setCreeperState(1);
		}
	}
}