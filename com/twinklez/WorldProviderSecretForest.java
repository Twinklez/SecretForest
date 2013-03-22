package com.twinklez;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
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

    public String getMoonTexture()
    {
    	return "";
    }
    
    public String getSunTexture()
    {
    	return "";
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
    
    public boolean onTickInGame(float f, Minecraft minecraft, EntityPlayerMP mp)
    {
    	EntityPlayerMP thePlayer = (EntityPlayerMP) mp;
    	
    	if (minecraft.thePlayer.dimension == SecretForest.dimension) 
        {
    		if (minecraft.thePlayer.jumpMovementFactor == 1F)
    		{
    			if (thePlayer.isJumping = true)
    			{
    				minecraft.thePlayer.motionY /= 1.6000000238418579D;
    				minecraft.thePlayer.fallDistance = 0.0F;
    			}
    		}
        }
    	return true;
    }
    
    public double getMovementFactor()
    {
    	return 15.0;
    }
    
    protected void generateLightBrightnessTable()
    {
        float var1 = -0.001F;

        for (int var2 = 0; var2 <= 15; ++var2)
        {
            float var3 = 1.0F - (float)var2 / 15.0F;
            this.lightBrightnessTable[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
        }
    }

    
    public float calculateCelestialAngle(long par1, float par3)
    {
    	return 1.11F;	 
    	//Somewhat Sun-set and Moon-rise. [1.268F]
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

