package net.minecraft.world.gen.feature;

import java.util.Random;

import com.twinklez.SecretForest;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class WorldGenSecretForestLog extends WorldGenerator
{
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        for (int l = 0; l < 1; ++l)
        {
            int i1 = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
            int j1 = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
            int k1 = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);

            if (par1World.isAirBlock(i1, j1, k1) && par1World.getBlockId(i1, j1 - 1, k1) == SecretForest.srGrass.blockID && SecretForest.srLog.canPlaceBlockAt(par1World, i1, j1, k1))
            {
                par1World.setBlock(i1, j1, k1, SecretForest.srLog.blockID, 0, 2);
                par1World.setBlock(i1, j1 + 1, k1, SecretForest.srLog.blockID, 0, 2);
                par1World.setBlock(i1, j1 + 2, k1, SecretForest.srLog.blockID, 0, 2);
                par1World.setBlock(i1, j1 + 3, k1, SecretForest.srLog.blockID, 0, 2);
                par1World.setBlock(i1, j1 + 4, k1, SecretForest.srLog.blockID, 0, 2);
                par1World.setBlock(i1, j1 + 5, k1, SecretForest.srLog.blockID, 0, 2);
                
                par1World.setBlock(i1, j1 + 6, k1, SecretForest.srLeaves.blockID, 0, 2);
                par1World.setBlock(i1 + 1, j1 + 6, k1, SecretForest.srLeaves.blockID, 0, 2);
                par1World.setBlock(i1 - 1, j1 + 6, k1, SecretForest.srLeaves.blockID, 0, 2);
                par1World.setBlock(i1, j1 + 6, k1 + 1, SecretForest.srLeaves.blockID, 0, 2);
                par1World.setBlock(i1, j1 + 6, k1 - 1, SecretForest.srLeaves.blockID, 0, 2);
                par1World.setBlock(i1 + 1, j1 + 6, k1 + 1, SecretForest.srLeaves.blockID, 0, 2);
                par1World.setBlock(i1 + 1, j1 + 6, k1 - 1, SecretForest.srLeaves.blockID, 0, 2);
                par1World.setBlock(i1 - 1, j1 + 6, k1 + 1, SecretForest.srLeaves.blockID, 0, 2);
                par1World.setBlock(i1 - 1, j1 + 6, k1 - 1, SecretForest.srLeaves.blockID, 0, 2);
                
                par1World.setBlock(i1, j1 + 7, k1, SecretForest.srLeaves.blockID, 0, 2);
            }
            

        }
        return true;
    }
}
