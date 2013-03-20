package com.twinklez;

import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabSecretForest extends CreativeTabs
{
	public CreativeTabSecretForest(String label)
	{
		super(label);
	}
	
	@Override
	public ItemStack getIconItemStack()
    {
        return new ItemStack(SecretForest.srPortal);
    }

}
