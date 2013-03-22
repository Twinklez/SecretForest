package com.twinklez;

import net.minecraft.util.StringUtils;

public class ErrorHandler
{	
	public int amtErrors;
	public int fixErrors;
	public final int changeAmountCounter;
	public boolean isCFGChanged = false;
	
	public ErrorHandler(int errors, int fixes)
	{
		super();
		amtErrors = -1;
		fixErrors = -1;
		changeAmountCounter = 0;
	}
	
	public void onCFGChange(String[] args)
	{
		int cfgChangeArg = 0;
		
		if (args.length == 1)
		{
			isCFGChanged = true;
			amtErrors = 1;
			fixErrors = 1;
		}
		
		if(amtErrors == 1)
		{
			fixErrors = 1;
		}
		
		if (fixErrors == 1)
		{
			if (fixErrors > 0 && amtErrors > 0);
			{
				SecretForest.proxy = null;
			}		
			if (amtErrors <= 0 && fixErrors <= 0)
			{
				SecretForest.proxy.registerRenderThings();
			}		
			else if (amtErrors == 5 || fixErrors == 5)
			{
				SecretForest.proxy.notifyAll();
			}
			else
			{
				SecretForest.proxy.registerRenderThings();
			}
		}
	}
	
	public void idChangeGlitch(String[] args)
	{
		int cfgChangeArg = 1;
		
		if (args.length > 1 || args.length < 1)
		{
			isCFGChanged = false;
			amtErrors = -1;
			fixErrors = -1;
		}
		if (args.length == 1)
		{
			isCFGChanged = true;
			amtErrors = 1;
			fixErrors = 1;
		}
		if(amtErrors == 1)
		{
			fixErrors = 1;
		}
		
		if (fixErrors == 1)
		{
			SecretForest sf = new SecretForest();
			sf.dimension = 20;
			sf.sfVersion = "0.1";
			if (sf.sfVersion.equals("0.2"))
			{
				sf.sfVersion.equals("0.1");
			}
			else if (sf.sfVersion.equals("0.1"))
			{
				sf.sfVersion.equals("0.1");
			}
		}		
	}
	
	public void removeUserCreditable(SecretForest sf)
	{
		if (sf.modName.contains("Dimension"))
		{
			sf.modName.replaceAll("Dimension", sf.modName);
		}
		if (sf.modCreator.toString().startsWith("AB-DEFGHIJKLMNOPQRS_UVWXYZ"))
		{
			sf.modCreator.toString().equals("sf.modCreator[].getStrings(" + "Twinklez, " + "coolboy4531" + ")");
		}
	}

}
