package xyz.dwaslashe.bossbarstats.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import xyz.dwaslashe.bossbarstats.Main;
import xyz.dwaslashe.bossbarstats.task.BossBarStatsTask;
import xyz.dwaslashe.bossbarstats.util.Api;

public class BossBarStatsCommand implements CommandExecutor {
    public BossBarStatsCommand() {
    }

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage("Komenda nie jest dla konsoli! (TPS: " + Api.getTps() + ")");
            return false;
        } else if (args.length >= 0) {
            if (BossBarStatsTask.bar.getPlayers().contains(player) == true) {
                BossBarStatsTask.bar.removePlayer(player);
                player.sendMessage(Api.fixColor(Main.getPlugin(Main.class).getConfig().getString("bossbarstats.enable")));
            } else if (BossBarStatsTask.bar.getPlayers().contains(player) == false) {
                BossBarStatsTask.bar.addPlayer(player);
                player.sendMessage(Api.fixColor(Main.getPlugin(Main.class).getConfig().getString("bossbarstats.disable")));
            }
        }
        return false;
    }
}
