package xyz.dwaslashe.bossbarstats.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import xyz.dwaslashe.bossbarstats.task.BossBarStatsTask;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        if (BossBarStatsTask.bar.getPlayers().contains(player) == true) {
            BossBarStatsTask.bar.removePlayer(player);
        }
    }
}
