package net.starlikeclient.minecraft.init;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityList;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenEnd;
import net.minecraft.world.biome.BiomeGenHell;
import net.starlikeclient.minecraft.entities.entity.EntityEndCreeper;
import net.starlikeclient.minecraft.entities.entity.EntityNetherCreeper;
import net.starlikeclient.minecraft.entities.render.RenderEndCreeper;
import net.starlikeclient.minecraft.entities.render.RenderNetherCreeper;

public class EntitiesStarlike {
	public static void configEndEntities(BiomeGenEnd e) {
		e.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityEndCreeper.class, 7, 3, 3));
	}

	public static void configNetherEntities(BiomeGenHell e) {
		e.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityNetherCreeper.class, 100, 4, 1));
	}

	public static void registerEntities() {
		EntityList.addMapping(EntityNetherCreeper.class, EntityNetherCreeper::new, "NetherCreeper", 201, 0xFFCC0000,
				0xFFFFA500);
		EntityList.addMapping(EntityEndCreeper.class, EntityEndCreeper::new, "EndCreeper", 202, 0xFF6A0DAD, 0xFF000000);
	}

	public static void renderEntities(RenderManager e) {
		e.entityRenderMap.put(EntityNetherCreeper.class, new RenderNetherCreeper(e));
		e.entityRenderMap.put(EntityEndCreeper.class, new RenderEndCreeper(e));
	}
}