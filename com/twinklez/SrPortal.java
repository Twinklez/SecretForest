package com.twinklez;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

public class SrPortal extends BlockPortal
{
	public SrPortal(int id, int texture)
	{
		super(id);
		this.setCreativeTab(com.twinklez.SecretForest.secretForestTab);
	}
	
	public String getTextureFile()
	{
		return "/sf/sf.png";
	}
	
    public String getEnteringMessage() 
    {
    	return "Entering The Secret Forest";
    }

    public String getLeavingMessage()
    {
    	return "Leaving The Secret Forest";
    }
    
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		
	}	

	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		if (par5Entity.ridingEntity == null && par5Entity.riddenByEntity == null)
		{
			if (par5Entity instanceof EntityPlayerMP)
			{
				EntityPlayerMP thePlayer = (EntityPlayerMP)par5Entity;
				if (par5Entity.dimension != SecretForest.dimension)
				{
					thePlayer.mcServer.getConfigurationManager().transferPlayerToCustomDimension(thePlayer, SecretForest.dimension, 
					new TeleporterSecretForest(thePlayer.mcServer.worldServerForDimension(SecretForest.dimension)));
				}
				else
				{
					thePlayer.mcServer.getConfigurationManager().transferPlayerToCustomDimension(thePlayer, SecretForest.dimension, 
					new TeleporterSecretForest(thePlayer.mcServer.worldServerForDimension(SecretForest.dimension)));
					thePlayer.sendChatToPlayer("\u00a78[SecretForest] You can not exit the SecretForest because of the force-field of this dimension!");
				}
			}
		}
	}
	
	
    public boolean tryToCreatePortal(World par1World, int par2, int par3, int par4)
    {
        byte b0 = 0;
        byte b1 = 0;

        if (par1World.getBlockId(par2 - 1, par3, par4) == SecretForest.specialStone.blockID || par1World.getBlockId(par2 + 1, par3, par4) == SecretForest.specialStone.blockID)
        {
            b0 = 1;
        }

        if (par1World.getBlockId(par2, par3, par4 - 1) == SecretForest.specialStone.blockID || par1World.getBlockId(par2, par3, par4 + 1) == SecretForest.specialStone.blockID)
        {
            b1 = 1;
        }

        if (b0 == b1)
        {
            return false;
        }
        else
        {
            if (par1World.getBlockId(par2 - b0, par3, par4 - b1) == 0)
            {
                par2 -= b0;
                par4 -= b1;
            }

            int l;
            int i1;

            for (l = -1; l <= 2; ++l)
            {
                for (i1 = -1; i1 <= 3; ++i1)
                {
                    boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;

                    if (l != -1 && l != 2 || i1 != -1 && i1 != 3)
                    {
                        int j1 = par1World.getBlockId(par2 + b0 * l, par3 + i1, par4 + b1 * l);

                        if (flag)
                        {
                            if (j1 != SecretForest.specialStone.blockID)
                            {
                                return false;
                            }
                        }
                        else if (j1 != 0 && j1 != Block.fire.blockID)
                        {
                            return false;
                        }
                    }
                }
            }

            for (l = 0; l < 2; ++l)
            {
                for (i1 = 0; i1 < 3; ++i1)
                {
                    par1World.setBlockAndMetadataWithNotify(par2 + b0 * l, par3 + i1, par4 + b1 * l, SecretForest.srPortal.blockID, 0, 2);
                }
            }

            return true;
        }
    }		

    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (par5Random.nextInt(100) == 0)
        {
            par1World.playSound((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "ambient.cave.cave11", 0.5F, par5Random.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int l = 0; l < 4; ++l)
        {
            double d0 = (double)((float)par2 + par5Random.nextFloat());
            double d1 = (double)((float)par3 + par5Random.nextFloat());
            double d2 = (double)((float)par4 + par5Random.nextFloat());
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = par5Random.nextInt(2) * 2 - 1;
            d3 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
            d4 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
            d5 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;

            if (par1World.getBlockId(par2 - 1, par3, par4) != this.blockID && par1World.getBlockId(par2 + 1, par3, par4) != this.blockID)
            {
                d0 = (double)par2 + 0.5D + 0.25D * (double)i1;
                d3 = (double)(par5Random.nextFloat() * 2.0F * (float)i1);
            }
            else
            {
                d2 = (double)par4 + 0.5D + 0.25D * (double)i1;
                d5 = (double)(par5Random.nextFloat() * 2.0F * (float)i1);
            }

            par1World.spawnParticle("witchMagic", d0, d1, d2, d3, d4, d5);
        }
    }
	
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        byte b0 = 0;
        byte b1 = 1;

        if (par1World.getBlockId(par2 - 1, par3, par4) == this.blockID || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID)
        {
            b0 = 1;
            b1 = 0;
        }

        int i1;

        for (i1 = par3; par1World.getBlockId(par2, i1 - 1, par4) == this.blockID; --i1)
        {
            ;
        }

        if (par1World.getBlockId(par2, i1 - 1, par4) != SecretForest.specialStone.blockID)
        {
            par1World.func_94571_i(par2, par3, par4);
        }
        else
        {
            int j1;

            for (j1 = 1; j1 < 4 && par1World.getBlockId(par2, i1 + j1, par4) == this.blockID; ++j1)
            {
                ;
            }

            if (j1 == 3 && par1World.getBlockId(par2, i1 + j1, par4) == SecretForest.specialStone.blockID)
            {
                boolean flag = par1World.getBlockId(par2 - 1, par3, par4) == this.blockID || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID;
                boolean flag1 = par1World.getBlockId(par2, par3, par4 - 1) == this.blockID || par1World.getBlockId(par2, par3, par4 + 1) == this.blockID;

                if (flag && flag1)
                {
                    par1World.func_94571_i(par2, par3, par4);
                }
                else
                {
                    if ((par1World.getBlockId(par2 + b0, par3, par4 + b1) != SecretForest.specialStone.blockID || par1World.getBlockId(par2 - b0, par3, par4 - b1) != this.blockID) && (par1World.getBlockId(par2 - b0, par3, par4 - b1) != SecretForest.specialStone.blockID || par1World.getBlockId(par2 + b0, par3, par4 + b1) != this.blockID))
                    {
                        par1World.func_94571_i(par2, par3, par4);
                    }
                }
            }
            else
            {
                par1World.func_94571_i(par2, par3, par4);
            }
        }
    }
}



















