package net.minecraft.command;

import com.twinklez.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class CommandSF extends CommandBase
{
	public SecretForest sf;
    /**
     * Returns true if the given command sender is allowed to use this command.
     */
    public boolean canCommandSenderUseCommand(ICommandSender par1ICommandSender)
    {
        return MinecraftServer.getServer().isSinglePlayer() || super.canCommandSenderUseCommand(par1ICommandSender);
    }

    public String getCommandName()
    {
        return "sf";
    }

    /**
     * Return the required permission level for this command.
     */
    public int getRequiredPermissionLevel()
    {
        return 0;
    }

    public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
        Object object = par1ICommandSender instanceof EntityPlayer ? ((EntityPlayer)par1ICommandSender).worldObj : MinecraftServer.getServer().worldServerForDimension(0);
        par1ICommandSender.sendChatToPlayer("[SecretForest] Version: " + sf.sfVersion);
    }
}
