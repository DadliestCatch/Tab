package Tab;

import SpoutSDK.CraftPlayer;
import SpoutSDK.CraftServer;
import SpoutSDK.ModBase;
import SpoutSDK.ModInfo;
import SpoutSDK.SpoutHelper;
import Tab.commands.Tab;

public class Main extends ModBase {
	public static String modName = "Tab";
	public static String version = "1.0.0";
	public static String header;
	public static String footer;
	
	
	public void onStartup(CraftServer argServer) {
		System.out.println("[Tab/INFO]: Tab version " + version + " starting up...");
		Config.readConfig();
		SpoutHelper.getServer().registerCommand(new Tab());
	}
	
    public ModInfo getModInfo() {
		ModInfo info = new ModInfo();
		info.description = "Customization of the tab list menu (" + version + ")";
		info.name = modName;
		info.version = version;
		return info;
    }
    
    public void onPlayerJoin(CraftPlayer plr) {
		String coloredHeader = Main.header.replace("&", "§");
		String coloredFooter = Main.footer.replace("&", "§");
		plr.setPlayerListHeaderFooter(PlaceholderAPI.Main.replacePlaceholders(coloredHeader, plr), PlaceholderAPI.Main.replacePlaceholders(coloredFooter, plr));
    }
    
    public void onTick(int tick) {
    	if(SpoutHelper.getServer().getPlayers().size() > 0) {
    		for(CraftPlayer plr : SpoutHelper.getServer().getPlayers()) {
    			String coloredHeader = Main.header.replace("&", "§");
    			String coloredFooter = Main.footer.replace("&", "§");
    			plr.setPlayerListHeaderFooter(PlaceholderAPI.Main.replacePlaceholders(coloredHeader, plr), PlaceholderAPI.Main.replacePlaceholders(coloredFooter, plr));
    		}
    	}
    return;
    }

}
