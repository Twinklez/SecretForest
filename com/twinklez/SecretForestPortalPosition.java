package com.twinklez;

import net.minecraft.util.ChunkCoordinates;;

public class SecretForestPortalPosition extends ChunkCoordinates
{
	public long field_00000_SF;
	
	final TeleporterSecretForest field_00001_SF;
	
	public SecretForestPortalPosition(TeleporterSecretForest par1TeleporterSecretForest, int par2, int par3, int par4, long par5)
	{
		super(par2, par3, par4);
		this.field_00001_SF = par1TeleporterSecretForest;
		this.field_00000_SF = par5;
	}
}
