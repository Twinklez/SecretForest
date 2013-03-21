package com.twinklez;

import java.util.Random;

import javax.swing.ImageIcon;

import com.twinklez.SecretForest;
import net.minecraft.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class SrGrass extends Block
{
	private Icon sides, bottom, top;
	
    protected SrGrass(int var1, int var2)
    {
        super(var1, Material.ground);
        this.setTickRandomly(true);
        this.setCreativeTab(com.twinklez.SecretForest.secretForestTab);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4 && par1World.getBlockLightOpacity(par2, par3 + 1, par4) > 2)
            {
                par1World.func_94575_c(par2, par3, par4, SecretForest.srDirt.blockID);
            }
            else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
            {
                for (int l = 0; l < 4; ++l)
                {
                    int i1 = par2 + par5Random.nextInt(3) - 1;
                    int j1 = par3 + par5Random.nextInt(5) - 3;
                    int k1 = par4 + par5Random.nextInt(3) - 1;
                    int l1 = par1World.getBlockId(i1, j1 + 1, k1);

                    if (par1World.getBlockId(i1, j1, k1) == SecretForest.srDirt.blockID && par1World.getBlockLightValue(i1, j1 + 1, k1) >= 4 && par1World.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
                    {
                        par1World.func_94575_c(i1, j1, k1, SecretForest.srGrass.blockID);
                    }
                }
            }
        }
    }

    public void func_94332_a(IconRegister par1IconRegister)
    {
    	this.sides = par1IconRegister.func_94245_a("secretGrassSide");
    	this.bottom = par1IconRegister.func_94245_a("srDirt");
    	this.top = par1IconRegister.func_94245_a("secretGrass");
    }
    
    public Icon getBlockTextureFromSideAndMetadata(int i, int j)
    {
    	if (i == 0)
    	{
    		return bottom;
    	}
    	if (i == 1)
    	{
    		return top;
    	}
    	else
    	{
    		return sides;
    	}
    }
    
    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World var1, int var2, int var3, int var4, Random var5)
    {
        super.randomDisplayTick(var1, var2, var3, var4, var5);

        if (var5.nextInt(75) == 0)
        {
            var1.spawnParticle("depthsuspend", (double)((float)var2 + var5.nextFloat()), (double)((float)var3 + 1.1F), (double)((float)var4 + var5.nextFloat()), 20.0D, 20.0D, 20.0D);
        }
    }


    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int var1, Random var2, int var3)
    {
        return SecretForest.srDirt.blockID;
    }
    
	public String getTextureFile()
	{
		return "/sf/sf.png";
	}


}
