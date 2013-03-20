package com.twinklez;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SrDirt extends Block
{
    public SrDirt(int id, int texture)
    {
        super(id, Material.ground);
        this.setCreativeTab(com.twinklez.SecretForest.secretForestTab);
    }
    
	public String getTextureFile()
	{
		return "/sf/sf.png";
	}
	
    public int idDropped(int var1, Random var2, int var3)
    {
        return SecretForest.srDirt.blockID;
    }

}
