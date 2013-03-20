package net.minecraft.world.gen.feature;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenSForest;

import com.twinklez.WorldGenSForestTrees;

public class CustomBiomeAPI
{
	public void generateSurface(World world, Random random, int BlockX, int BlockZ)
	{
		BiomeGenBase biome = world.getBiomeGenForCoords(BlockX, BlockZ);
		WorldGenSForestTrees tree = new WorldGenSForestTrees(false, 5, 0, 0);
		
		if (biome instanceof BiomeGenSForest)
		{
			for (int i = 0; i < 5; i++)
			{
				int Xcoord1 = BlockX + random.nextInt(16);
				int Ycoord1 = random.nextInt(90);
				int Zcoord1 = BlockZ + random.nextInt(16);
				tree.generate(world, random, Xcoord1, Ycoord1, Zcoord1);
			}
		}
	}
}

