package com.twinklez;

import java.awt.Color;
import java.beans.EventHandler;
import java.io.File;
import java.net.URL;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.src.MLProp;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenSForest;
import net.minecraftforge.client.ModCompatibilityClient;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "SecretForest", name = "Secret Forest", version = "0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class SecretForest
{
	//Block and Item Define.
	public static BlockPortal srPortal; //id 0
	public static Block specialStone; //id 1
	public static Block srDirt; //id 2
	public static Block srGrass; //id 3
	public static Block srLog; //id 8
	public static Block srLeaves; //id 6
	public static Block srPlanks; //id 7
	public static Block srStone; //id 10

	//CreativeTabs.
	public static CreativeTabs secretForestTab = new CreativeTabSecretForest("secretForestTab");
	
	//Ints for like special kinds of textures, metadata, etc.
    public static int grassTop; //id 4
    public static int grassBottom; //id 5
    public static int logTop; //id 9
    
    //Configuration File.
    @MLProp public static int idSrPortal = 218; 
    @MLProp public static int idSpecialStone = 219; 
    @MLProp public static int idSrDirt = 220; 
    @MLProp public static int idSrGrass = 221; 
    @MLProp public static int idSrLog = 222; 
    @MLProp public static int idSrLeaves = 223; 
    @MLProp public static int idSrPlanks = 224;
    @MLProp public static int idSrStone = 225; 
    
    
    
    //Dimension ID
	public static int dimension = 20;
	
	//Mod Info
	public String sfVersion = "0.1";
	public String modName = "Secret Forest {Alpha Release} v0.1";
	public String modCreator = "Twinklez, coolboy4531";
	
	//Extra Stuff
	private static World world;
	public static File sfMusic = new File("13");
	public EntityPlayerMP mp;
	public EntityPlayerSP sp;
	public File lozLullaby = new File("secret");
	public Minecraft mc;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		//Configurable ID Code. :D
		config.load();
		Property property = config.get(Configuration.CATEGORY_GENERAL, "com", "com"); 
		property.comment = "You can edit the ID codes for SecretForest's Items or Blocks!";
		idSrPortal = config.getBlock("srPortal", 218).getInt();
		idSpecialStone = config.getBlock("specialStone", 219).getInt();
		idSrDirt = config.getBlock("srDirt", 220).getInt();
		idSrGrass = config.getBlock("srGrass", 221).getInt();
		idSrLeaves = config.getBlock("srLog", 222).getInt();
		idSrLog = config.getBlock("srLeaves", 223).getInt();
		//idSrPlanks = config.getBlock("srPlanks", 224).getInt();
		idSrStone = config.getBlock("srStone", 225).getInt();
		//id = config.getBlock("", ).getInt();
		//id = config.getBlock("", ).getInt();
		//id = config.getBlock("", ).getInt();
		//id = config.getBlock("", ).getInt();
		//id = config.getBlock("", ).getInt();
		//id = config.getBlock("", ).getInt();
		//id = config.getBlock("", ).getInt();
		//id = config.getBlock("", ).getInt();
		//id = config.getBlock("", ).getInt();	
		config.save();
		MinecraftForge.EVENT_BUS.register(new SFSoundManager());

	}
	
	@SidedProxy(clientSide = "com.twinklez.ClientProxySecretForest", serverSide = "com.twinklez.ClientProxySecretForest")
	public static CommonProxySecretForest proxy;
	
	//Does when SecretForest loads.
	@Init
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
		srPortal = (SrPortal)(new SrPortal(218, 0).setStepSound(Block.soundWoodFootstep).setHardness(100000000F).setResistance(1.0F).setUnlocalizedName("srForestPortal"));
		specialStone = (new SrSpecialStone(219, 1).setHardness(5.0F).setStepSound(Block.soundStoneFootstep).setResistance(1234.5F).setUnlocalizedName("specialStone"));
		srDirt = (new SrDirt(220, 2).setStepSound(Block.soundGrassFootstep).setHardness(0.5F).setResistance(0.5F).setUnlocalizedName("srDirt"));
		srGrass = (new SrGrass(221, 3).setStepSound(Block.soundGrassFootstep).setHardness(0.5F).setResistance(1.0F).setUnlocalizedName("secretGrass"));
		srLeaves = (new SrLeaves(222).setHardness(1.0F).setTickRandomly(true).setStepSound(Block.soundGrassFootstep).setResistance(1.0F).setUnlocalizedName("secretLeaves"));
		srLog = (new SrLog(223)).setStepSound(Block.soundWoodFootstep).setHardness(1.1F).setResistance(2F).setUnlocalizedName("secretLog");
		srStone = (new SrStone(225, 10)).setStepSound(Block.soundStoneFootstep).setHardness(2.5F).setResistance(5.0F).setUnlocalizedName("srStone");
		
		GameRegistry.registerBlock(srPortal, "Twinklez_Portal");
		GameRegistry.registerBlock(specialStone, "Twinklez_SpecialStone");
		GameRegistry.registerBlock(srDirt, "Twinklez_Dirt");
		GameRegistry.registerBlock(srGrass, "Twinklez_Grass");
		GameRegistry.registerBlock(srLeaves, "Twinklez_Leaves");
		GameRegistry.registerBlock(srLog, "Twinklez_Log");
		GameRegistry.registerBlock(srStone, "Twinklez_Stone");
		//GameRegistry.registerBlock(, "Twinklez_");
		//GameRegistry.registerBlock(, "Twinklez_");
		//GameRegistry.registerBlock(, "Twinklez_");
		
		LanguageRegistry.addName(srPortal, "Secret Forest Portal");
		LanguageRegistry.addName(specialStone, "Special Stone");
		LanguageRegistry.addName(srDirt, "Secret Dirt");
		LanguageRegistry.addName(srGrass, "Secret Grass");
		LanguageRegistry.addName(srLeaves, "Secret Leaves");
		LanguageRegistry.addName(srLog, "Secret Wood");
		LanguageRegistry.addName(srStone, "Secret Stone");
		//LanguageRegistry.addName(,"");
		//LanguageRegistry.addName(,"");
		
		LanguageRegistry.instance().addStringLocalization("itemGroup.secretForestTab", "en_US", "Secret Forest");
		
		DimensionManager.registerProviderType(dimension, WorldProviderSecretForest.class, false);
		DimensionManager.registerDimension(dimension, dimension);

	    EntityRegistry.registerModEntity(EntityRobot.class, "Robot", EntityRegistry.findGlobalUniqueEntityId(), this, 80, 3, true);
	    EntityRegistry.addSpawn(EntityRobot.class, 15, 1, 3, EnumCreatureType.creature, BiomeGenBase.secretForest);
	    
	    int gray = (220 << 220) + (220 << 220) + (220 << 220);
	    int darkGray = (200 << 89) + (255 << 37) + (255 << 137);
	    
	    Color grayColor = new Color(220, 220, 220);
	    Color darkGrayColor = new Color(139, 137, 137);	    
	       
	    EntityList.IDtoClassMapping.put(EntityRegistry.findGlobalUniqueEntityId(), EntityRobot.class);
	    EntityList.entityEggs.put(EntityRegistry.findGlobalUniqueEntityId(), new EntityEggInfo(EntityRegistry.findGlobalUniqueEntityId(), (new Color(220, 220, 220)).getRGB(), (new Color(139, 137, 137)).getRGB()));
	    LanguageRegistry.instance().addStringLocalization("entity.SecretForest.Robot.name", "Robot");
	    
	    //mc.installResource("resources/mod/music/secret.ogg", new File(mc.mcDataDir, "resources/mod/music/secret.ogg"));
	}

	private EntityPlayerSP changePlayerEntity(int type, Minecraft minecraft)
	{
		if (type == dimension) 
		{
			return new EntityPlayerSForest(minecraft, minecraft.theWorld, minecraft.session, type);
		}
		return new EntityPlayerSP(minecraft, minecraft.theWorld, minecraft.session, type);
	}
	
	public void addRenderer(Map map)
	{
		map.put(EntityRobot.class, new RenderBiped(new ModelBiped(), 0.5F));
	}
	  
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
	
	public boolean onTickInGame(Minecraft minecraft, EntityPlayerSP sp)
	{
		EntityPlayerSP thePlayer = (EntityPlayerSP) sp;
		if (thePlayer != null) 
		{
			if (world.provider.dimensionId == dimension && thePlayer instanceof EntityPlayerSForest)
				return true;

			if (world.provider.dimensionId!= dimension && !(thePlayer instanceof EntityPlayerSForest))
				return true;
		}
		return true;
	}
	
	public void chooseBackGroundMusic()
	{
		if (world.provider.dimensionId == dimension)
		{
			ModCompatibilityClient.audioModSoundPoolCave.addSound("resources/streaming", sfMusic);
		}
	}
	
 /**   public SoundPoolEntry onPlayBackgroundMusic(SoundManager soundmanager, SoundPoolEntry soundpoolentry)
    {
        if (mp.dimension == dimension)
        {
            return soundmanager.getMusicPool().func_1118_a("aether");
        } 
        else
        {
            return soundpoolentry;
        }
    }
}*/
	
		public SoundPoolEntry onPlayBackgroundMusic(SoundManager sm, SoundPoolEntry spe)
		{
			if (mp.dimension == dimension)
			{
				return sm.soundPoolMusic.addSound("loz", lozLullaby);
			}
			else
			{
				return spe;
			}
		}
}