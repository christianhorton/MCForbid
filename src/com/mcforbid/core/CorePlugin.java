package com.mcforbid.core;
import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;


public class CorePlugin extends JavaPlugin {
	
	public APIEngine apiEngine = new APIEngine();
	
	public void onEnable() {
		apiEngine = new APIEngine();
		if(!apiEngine.checkApiConnection()) {
			getLogger().log(Level.INFO, "API Database is down. Disabling Plugin.");
			getPluginLoader().disablePlugin(this);
		}
		
		getLogger().log(Level.INFO, "Enabled");
	}
	
	public void onDisable() {
		getLogger().log(Level.INFO, "Disabled");
	}
}
