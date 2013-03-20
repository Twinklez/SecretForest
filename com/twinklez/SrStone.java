package com.twinklez;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SrStone extends Block
{
    public SrStone(int var1, int var2)
    {
        super(var1, Material.rock);
        this.setCreativeTab(com.twinklez.SecretForest.secretForestTab);
    }
    
	public String getTextureFile()
	{
		return "/sf/sf.png";
	}
}
