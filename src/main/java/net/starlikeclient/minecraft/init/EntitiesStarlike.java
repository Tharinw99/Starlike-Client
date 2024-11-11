package net.starlikeclient.minecraft.init;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenEnd;
import net.minecraft.world.biome.BiomeGenHell;
import net.minecraft.world.biome.BiomeGenSwamp;
import net.starlikeclient.minecraft.entities.entity.EntityEndCreeper;
import net.starlikeclient.minecraft.entities.entity.EntityNetherCreeper;
import net.starlikeclient.minecraft.entities.entity.EntityWatcher;
import net.starlikeclient.minecraft.entities.render.RenderEndCreeper;
import net.starlikeclient.minecraft.entities.render.RenderNetherCreeper;
import net.starlikeclient.minecraft.entities.render.RenderWatcher;
import net.starlikeclient.minecraft.world.biome.BiomeGenEnderForest;

public class EntitiesStarlike {
	public static void configEntities(BiomeGenBase e) {
		if (e instanceof BiomeGenHell) {
			e.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityNetherCreeper.class, 100, 4, 1));
		} else if (e instanceof BiomeGenEnd) {
			e.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityEndCreeper.class, 7, 3, 3));
		} else if (e instanceof BiomeGenEnderForest) {
			e.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityEnderman.class, 10, 4, 4));
		} else if (e instanceof BiomeGenSwamp) {
			e.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWatcher.class, 10, 5, 5));
		} else {
			throw new IllegalArgumentException("Unexpected biome type: " + e.getClass().getName());
		}
	}

	public static void registerEntities() {
		EntityList.addMapping(EntityNetherCreeper.class, EntityNetherCreeper::new, "NetherCreeper", 201, 0xFFCC0000,
				0xFFFFA500);
		EntityList.addMapping(EntityEndCreeper.class, EntityEndCreeper::new, "EndCreeper", 202, 0xFF6A0DAD, 0xFF000000);
		EntityList.addMapping(EntityWatcher.class, EntityWatcher::new, "Watcher", 203, 0xFFFFFFFF, 0xFFFF0000);
	}

	public static void renderEntities(RenderManager e) {
		e.entityRenderMap.put(EntityNetherCreeper.class, new RenderNetherCreeper(e));
		e.entityRenderMap.put(EntityEndCreeper.class, new RenderEndCreeper(e));
		e.entityRenderMap.put(EntityWatcher.class, new RenderWatcher(e));
	}
}
