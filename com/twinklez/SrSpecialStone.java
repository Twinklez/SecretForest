package com.twinklez;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class SrSpecialStone extends Block
{
    public SrSpecialStone(int id, int texture)
    {
        super(id, Material.rock);
        this.setCreativeTab(com.twinklez.SecretForest.secretForestTab);
    }
    
	public String getTextureFile()
	{
		return "/sf/sf.png";
	}
}
