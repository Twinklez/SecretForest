package com.twinklez;

import java.util.Random;

import javax.swing.ImageIcon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SrLog extends Block
{
	private Icon sides, secretLogMetadata;
	
    protected SrLog(int var1)
    {
        super(var1, Material.wood);
        this.setCreativeTab(com.twinklez.SecretForest.secretForestTab);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random var1)
    {
        return 1;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int var1, Random var2, int var3)
    {
        return SecretForest.srLog.blockID;
    }

    /**
     * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
     * block and l is the block's subtype/damage.
     */
    public void harvestBlock(World var1, EntityPlayer var2, int var3, int var4, int var5, int var6)
    {
        super.harvestBlock(var1, var2, var3, var4, var5, var6);
    }
    
    public void registerIcons(IconRegister par1IconRegister)
    {
    	this.sides = par1IconRegister.registerIcon("secretLog");
    	this.secretLogMetadata = par1IconRegister.registerIcon("secretLogMetadata");
    }
    
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        int k = par2 & 12;
        int l = par2 & 3;
        return k == 0 && (par1 == 1 || par1 == 0) ? this.secretLogMetadata : (k == 4 && (par1 == 5 || par1 == 4) ? this.secretLogMetadata : (k == 8 && (par1 == 2 || par1 == 3) ? this.secretLogMetadata : this.sides ));
    }
    
 /**   public Icon getBlockTextureFromSideAndMetadata(int i, int j)
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
    }*/ /** Old 1.5.0 stuff. */
    
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        byte b0 = 4;
        int j1 = b0 + 1;

        if (par1World.checkChunksExist(par2 - j1, par3 - j1, par4 - j1, par2 + j1, par3 + j1, par4 + j1))
        {
            for (int k1 = -b0; k1 <= b0; ++k1)
            {
                for (int l1 = -b0; l1 <= b0; ++l1)
                {
                    for (int i2 = -b0; i2 <= b0; ++i2)
                    {
                        int j2 = par1World.getBlockId(par2 + k1, par3 + l1, par4 + i2);

                        if (Block.blocksList[j2] != null)
                        {
                            Block.blocksList[j2].beginLeavesDecay(par1World, par2 + k1, par3 + l1, par4 + i2);
                        }
                    }
                }
            }
        }
    }


    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int var1)
    {
        return var1;
    }
    
	public String getTextureFile()
	{
		return "/sf/sf.png";
	}

}
