package com.twinklez;

import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxySecretForest extends CommonProxySecretForest
{
	@Override
	public void registerRenderThings()
	{
		MinecraftForgeClient.preloadTexture("/sf/sf.png");
	}
}
