package net.minecraft.world.biome;

import java.util.Random;

import com.twinklez.EntityRobot;
import com.twinklez.SecretForest;
import com.twinklez.WorldGenSForestTrees;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.passive.EntityLamb;
import net.minecraft.world.World;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraft.world.gen.feature.WorldGenSecretForestLog;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenVines;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenSForest extends BiomeGenBase
{
    protected WorldGenerator bushGen;
    protected WorldGenerator sandGen;
    
    public BiomeGenSForest(int var1)
    {
        super(var1);
        this.theBiomeDecorator.treesPerChunk = 33;
        this.theBiomeDecorator.grassPerChunk = 8;
        this.theBiomeDecorator.flowersPerChunk = 1;
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        //Class par1Class, Rate[Lower = Low, Higher = High], MinSpawnAmount, MaxSpawnAmount. PER GROUP!
        this.spawnableMonsterList.add(new SpawnListEntry(EntityRobot.class, 5, 1, 3));     
        this.topBlock = (byte)SecretForest.srGrass.blockID;
        this.fillerBlock = (byte)SecretForest.srDirt.blockID;
        this.theBiomeDecorator = new BiomeDecoratorSForest(this);
        
    }


    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return (WorldGenerator)(par1Random.nextInt(3) == 0 ? new WorldGenSForestTrees(false, 5, 0, 0) : new WorldGenTaiga2(false));
    }
    
    public void decorate(World par1World, Random par2Random, int par3, int par4)
    {
        super.decorate(par1World, par2Random, par3, par4);
        WorldGenSecretForestLog sfGenLog = new WorldGenSecretForestLog();
        WorldGenSForestTrees sfGenTrees = new WorldGenSForestTrees(true, 5, 0, 0);

        for (int k = 0; k < 1; k++)
        {
            int l = par3 + par2Random.nextInt(16) + 8;
            byte b0 = 64;
            int i1 = par4 + par2Random.nextInt(16) + 8;
            sfGenLog.generate(par1World, par2Random, l, b0, i1);
        }
        
        for (int m = 0; m < 3; m++)
        {
            int l = par3 + par2Random.nextInt(16) + 8;
            byte b0 = 64;
            int i1 = par4 + par2Random.nextInt(16) + 8;
            sfGenTrees.generate(par1World, par2Random, l, b0, i1);
        }
    }
}


