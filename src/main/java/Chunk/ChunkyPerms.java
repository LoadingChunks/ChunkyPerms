package Chunk;

/*
    This file is part of ChunkyPerms

    Foobar is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Foobar is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ChunkyPerms extends JavaPlugin {

	//ClassListeners
	private ChunkyPermsCommandExecutor commandExecutor;
	private ChunkyPermsEventListener eventListener;
	//ClassListeners

	public void onDisable() {
		// add any code you want to be executed when your plugin is disabled
	}

	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		commandExecutor = new ChunkyPermsCommandExecutor(this);
		eventListener = new ChunkyPermsEventListener(this);

		getCommand("permissions").setExecutor(commandExecutor);

		// you can register multiple classes to handle events if you want
		// just call pm.registerEvents() on an instance of each class
		pm.registerEvents(eventListener, this);
	}
}
