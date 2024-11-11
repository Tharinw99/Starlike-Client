package net.starlikeclient.minecraft.entities.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityNetherCreeper extends EntityCreeper {
	private int fuseTime = 28;
	private int explosionRadius = 4;

	public EntityNetherCreeper(World worldIn) {
		super(worldIn);
		this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityPigZombie.class, 6.0F, 1.0D, 1.2D));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(22.0D);
	}

	@Override
	protected Item getDropItem() {
		return Items.blaze_powder;
	}
}
