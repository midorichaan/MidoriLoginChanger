package midorichan.events;

import midorichan.LoginChanger;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class playerLogout implements Listener {

    private static LoginChanger plugin = LoginChanger.getInstance();

    @EventHandler(priority= EventPriority.HIGHEST)
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        if (p.hasPermission("midorilogin.admin")) {
            String m = plugin.config.getString(
                            "admin-logoutmessage",
                            plugin.prefix + "§6[Staff]§r" + p.getName() + "さんがサーバーから退出しました..."
                    )
                    .replace("{PLAYER}", p.getName())
                    .replace("{UUID}", p.getUniqueId().toString())
                    .replace("{DISPLAYNAME}", p.getDisplayName())
                    .replace("&", "§");

            e.setQuitMessage(m);
        } else {
            String m = plugin.config.getString(
                            "logoutmessage",
                            plugin.prefix + p.getName() + "さんがサーバーから退出しました..."
                    )
                    .replace("{PLAYER}", p.getName())
                    .replace("{UUID}", p.getUniqueId().toString())
                    .replace("{DISPLAYNAME}", p.getDisplayName())
                    .replace("&", "§");

            e.setQuitMessage(m);
        }
    }

}
