package midorichan.commands;

import midorichan.LoginChanger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class reloadconfig implements CommandExecutor {

    private static LoginChanger plugin = LoginChanger.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("mlcreload")) {
            if (sender.hasPermission("midorilogin.command")) {
                plugin.saveConfig();
                plugin.config = plugin.getConfig();
                sender.sendMessage(plugin.prefix + "Configを再読み込みしました");
                return true;
            } else {
                sender.sendMessage(plugin.prefix + "権限がありません");
                return true;
            }
        }
        return true;
    }

}
