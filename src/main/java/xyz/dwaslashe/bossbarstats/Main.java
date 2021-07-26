package xyz.dwaslashe.bossbarstats;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.dwaslashe.bossbarstats.commands.BossBarStatsCommand;
import xyz.dwaslashe.bossbarstats.listeners.PlayerQuitListener;
import xyz.dwaslashe.bossbarstats.tasks.BossBarStatsTask;

public class Main extends JavaPlugin {
    public Main() {
    }

    @Override
    public void onEnable() {
        System.out.println("Dziękuje za korzystanie z mojego pluginu!");
        loadCommands();
        loadListeners();
        loadTasks();

        getConfig().addDefault("bossbarstats.enable", " &8>> &cPomyślnie &c&nwyłączyłeś&c statystyki");
        getConfig().addDefault("bossbarstats.disable", " &8>> &aPomyślnie &a&nwłączyłeś&a statystyki");
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    @Override
    public void onDisable() {
        System.out.println("Do zobaczenia.");
        BossBarStatsTask.bar.getPlayers().forEach(player -> BossBarStatsTask.bar.removePlayer(player));
    }

    public void loadCommands() {
        this.getCommand("bossbarstats").setExecutor(new BossBarStatsCommand());
    }

    public void loadListeners() {
        PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerQuitListener(), this);
    }

    public void loadTasks() {
        new BossBarStatsTask().runTaskTimer(this, 0, 40);
    }
}
