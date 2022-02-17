package midorichan.events;

import midorichan.LoginChanger;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class playerLogin implements Listener {

    private static LoginChanger plugin = LoginChanger.getInstance();

    @EventHandler(priority= EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if (p.hasPermission("midorilogin.admin")) {
            String m = plugin.config.getString(
                    "admin-loginmessage",
                    plugin.prefix + "§6[Staff]§r" + p.getName() + "さんがサーバーに参加しました！"
            )
                    .replace("{PLAYER}", p.getName())
                    .replace("{UUID}", p.getUniqueId().toString())
                    .replace("{DISPLAYNAME}", p.getDisplayName());

            e.setJoinMessage(m);
        } else {
            String m = plugin.config.getString(
                            "loginmessage",
                            plugin.prefix + p.getName() + "さんがサーバーに参加しました！"
                    )
                    .replace("{PLAYER}", p.getName())
                    .replace("{UUID}", p.getUniqueId().toString())
                    .replace("{DISPLAYNAME}", p.getDisplayName());

            e.setJoinMessage(m);
        }
    }

}
