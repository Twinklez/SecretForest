package com.twinklez;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderSecretForest extends WorldProvider
{
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.secretForest, 0.5F, 0.15F);
		this.dimensionId = SecretForest.dimension;
	}
	
	public String getDimensionName()
	{
		return "Secret Forest";
	}
	
	public boolean canRespawnHere()
	{
		return false;
	}	

    public boolean renderClouds()
    {
        return true;
    }

    public boolean renderEndSky()
    {
        return false;
    }

    public boolean renderVoidFog()
    {
        return true;
    }

    public float setMoonSize()
    {
        return 1.238483F;
    }

    public float setSunSize()
    {
        return 0.95286F;
    }

    public String getSaveFolder()
    {
    	return "DIM-SECRETFOREST";
    }
    
    public boolean renderStars()
    {
        return true;
    }

    public boolean darkenSkyDuringRain()
    {
        return true;
    }
    
    public double getMovementFactor()
    {
    	return 15.0;
    }
	
    public String getEnteringMessage() 
    {
    	return "Entering The Secret Forest";
    }

    public String getLeavingMessage()
    {
    	return "Leaving The Secret Forest";
    }
    
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderSForest(worldObj, worldObj.getSeed(), true);
	}
}

