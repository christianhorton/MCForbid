package com.mcforbid.core;
import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;


public class McForbidPlugin extends JavaPlugin {

	
	public void onEnable() {
		if(!checkApiConnection()) {
			getLogger().log(Level.INFO, "API Database is down. Disabling Plugin.");
			getPluginLoader().disablePlugin(this);
		}
		
		getLogger().log(Level.INFO, "Enabled");
	}
	
	public void onDisable() {
		getLogger().log(Level.INFO, "Disabled");
	}
	
	private boolean checkApiConnection() {
		
		return false;
	}
}
