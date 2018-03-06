package Tab.commands;

import java.util.List;

import SpoutSDK.ChatColor;
import SpoutSDK.CraftCommand;
import SpoutSDK.CraftPlayer;
import Tab.Config;

public class Tab implements CraftCommand {

	@Override
	public List<String> getAliases() {
		return null;
	}

	@Override
	public String getCommandName() {
		return "tab";
	}

	@Override
	public String getHelpLine(CraftPlayer plr) {
		return ChatColor.GOLD + "/tab " + ChatColor.WHITE + "--- Manage tab list menu";
	}

	@Override
	public List<String> getTabCompletionList(CraftPlayer plr, String[] args) {
		return null;
	}

	@Override
	public void handleCommand(CraftPlayer plr, String[] args) {
		if(hasPermissionToUse(plr)) {
			Config.readConfig();
			plr.sendMessage(ChatColor.GOLD + "[TAB]: Configuration reloaded.");
			return;
		} else {
			plr.sendMessage(ChatColor.RED + "You do not have permission for that command.");
		}
		
	}

	@Override
	public boolean hasPermissionToUse(CraftPlayer plr) {
		return plr.hasPermission("tab.command");
	}

}
