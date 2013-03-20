package com.twinklez;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityRobot extends EntityMob
{
    private static final ItemStack defaultHeldItem;
    public int maxDmgDealt;
    
    public EntityRobot(World world)
    {
        super(world);
        texture = "/robot.png";
        moveSpeed = 0.31F;
        maxDmgDealt = 8;
        tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.29F, false));
        tasks.addTask(2, new EntityAIWander(this, 0.12F));
        tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 35F));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 19F, 0, true));
    }
    
    public boolean isAIEnabled()
    {
    	return true;
    }
    
    public int getMaxHealth()
    {
        return 112;
    }
    
    public boolean onWeakened()
    {
    	if (isBurning())
    	{
    		maxDmgDealt = 5;
    	}
    	else if (isWet())
    	{
    		maxDmgDealt = 3;
    	}
    	else if (this.isChild())
    	{
    		maxDmgDealt = 2;
    	}
    	return true;
    }
    
    /** What happens if robot is wet */
    
    public void onLivingUpdate()
    {
    	super.onLivingUpdate();

    	if(isWet())
    	{
    		attackEntityFrom(DamageSource.lava, 1);
    	}
 
    	if(isBurning())
    	{
    		attackEntityFrom(DamageSource.onFire, 1);
    	}
    }
    
    /** 
     *  Returns the sound when it is living
     */
    
    protected String getLivingSound()
    {
    	return "mob.blaze.breathe";
    }
    
    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.irongolem.hit";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.irongolem.death";
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    
    public int getDropItemId()
    {
    	return Item.ingotIron.itemID;
    }
    
    /** Few drop items. With obsidian */
    
    protected void dropFewItems(boolean par1, int par2)
    {
        int i = rand.nextInt(2);

        for (int j = 0; j < i; j++)
        {
            dropItem(Block.obsidian.blockID, 1);
        }

        int k = 3 + rand.nextInt(2);

        for (int l = 0; l < k; l++)
        {
            dropItem(Item.ingotIron.itemID, 1);
        }
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return true;
    }

    /**
     * Returns the item that this EntityLiving is holding, if any.
     */
    public ItemStack getHeldItem()
    {
        return defaultHeldItem;
    }

    static
    {
        defaultHeldItem = new ItemStack(Item.ingotIron, 1);
    }
    
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }
    protected void dropRareDrop(int par1)
    {
        switch (rand.nextInt(2))
        {
            case 0:
                dropItem(Item.swordSteel.itemID, 1);
                break;

            case 1:
                dropItem(Item.helmetSteel.itemID, 1);
                break;

        }
    }
}


