package com.logisticscraft.occlusionculling.cache;

public interface OcclusionCache {

	int getState(int x, int y, int z);

	void resetCache();

	void setHidden(int x, int y, int z);

	void setLastHidden();

	void setLastVisible();

	void setVisible(int x, int y, int z);

}
