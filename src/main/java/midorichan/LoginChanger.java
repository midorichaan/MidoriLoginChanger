package midorichan;

import midorichan.commands.reloadconfig;
import midorichan.events.playerLogin;
import midorichan.events.playerLogout;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class LoginChanger extends JavaPlugin {

    public static final String prefix = "§2>§a>§r ";
    private static LoginChanger instance;
    public static FileConfiguration config;

    public static LoginChanger getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        //init config
        this.saveDefaultConfig();

        //init vars
        instance = this;
        config = this.getConfig();

        //register commands
        Bukkit.getPluginCommand("mlcreload").setExecutor(new reloadconfig());

        //register events
        Bukkit.getPluginManager().registerEvents(new playerLogin(), this);
        Bukkit.getPluginManager().registerEvents(new playerLogout(), this);

        this.getLogger().info(prefix + "Enabled MidoriLoginChanger v1.0");
    }

    @Override
    public void onDisable() {
        this.getLogger().info(prefix + "Disabled MidoriLoginChanger v1.0");
    }
}
