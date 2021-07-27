package xyz.dwaslashe.bossbarstats.task;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.scheduler.BukkitRunnable;
import xyz.dwaslashe.bossbarstats.util.Api;

public class BossBarStatsTask extends BukkitRunnable {
    public static BossBar bar = Bukkit.createBossBar(Api.fixColor("&7TPS&8: &a" + Api.getTps()), BarColor.GREEN, BarStyle.SEGMENTED_6);

    @Override
    public void run() {
        double x = Api.getTps() * 5;
        x = x * 0.01;
        bar.setProgress(x);

        if (Api.getTps() >= 18) {
            bar.setTitle(Api.fixColor("&7TPS&8: &a" + Api.getTps()));
            bar.setColor(BarColor.GREEN);
            bar.setStyle(BarStyle.SEGMENTED_6);
        } else if (Api.getTps() >= 16) {
            bar.setTitle(Api.fixColor("&7TPS&8: &e" + Api.getTps()));
            bar.setColor(BarColor.YELLOW);
            bar.setStyle(BarStyle.SEGMENTED_6);
        } else if (Api.getTps() >= 13) {
            bar.setTitle(Api.fixColor("&7TPS&8: &c" + Api.getTps()));
            bar.setColor(BarColor.RED);
            bar.setStyle(BarStyle.SEGMENTED_10);
        } else {
            bar.setTitle(Api.fixColor("&7TPS&8: &4" + Api.getTps()));
            bar.setColor(BarColor.RED);
            bar.setStyle(BarStyle.SEGMENTED_12);
        }
    }
}
