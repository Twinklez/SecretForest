package net.minecraft.world.biome;

import net.minecraft.block.Block;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDecoratorSForest extends BiomeDecorator
{

    public BiomeDecoratorSForest(BiomeGenBase par1BiomeGenBase)
    {
        super(par1BiomeGenBase);
    }

    /**
     * The method that does the work of actually decorating chunks
     */
    protected void decorate()
    {
        this.generateOres();

        if (this.randomGenerator.nextInt(5) == 0)
        {
            int var1 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            int var2 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            int var3 = this.currentWorld.getTopSolidOrLiquidBlock(var1, var2);

            if (var3 > 0)
            {
                ;
            }
        }

        if (this.chunk_X == 0 && this.chunk_Z == 0)
        {
            EntityWither var4 = new EntityWither(this.currentWorld);
            var4.setLocationAndAngles(0.0D, 128.0D, 0.0D, this.randomGenerator.nextFloat() * 360.0F, 0.0F);
            this.currentWorld.spawnEntityInWorld(var4);
        }
        if (this.chunk_X == 999 && this.chunk_Z == 999)
        {
            EntityWither var4 = new EntityWither(this.currentWorld);
            var4.setLocationAndAngles(0.0D, 128.0D, 0.0D, this.randomGenerator.nextFloat() * 360.0F, 0.0F);
            this.currentWorld.spawnEntityInWorld(var4);
        }
        if (this.chunk_X == -999 && this.chunk_Z == -999)
        {
            EntityWither var4 = new EntityWither(this.currentWorld);
            var4.setLocationAndAngles(0.0D, 128.0D, 0.0D, this.randomGenerator.nextFloat() * 360.0F, 0.0F);
            this.currentWorld.spawnEntityInWorld(var4);
        }
    }
    
    public void generateTreesAmount()
    {
    	if (this.treesPerChunk <= 32)
    	{
    		this.treesPerChunk++;
    	}
    	else if (this.treesPerChunk > 50)
    	{
    		this.treesPerChunk -= 8;
    	}
    }
}
