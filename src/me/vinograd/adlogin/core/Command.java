package me.vinograd.adlogin.core;

import me.vinograd.adlogin.Main;
import me.vinograd.adlogin.db.database;
import me.xtopz.groups.manager.GroupManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.vinograd.adlogin.db.CheckPlayer;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class Command extends CheckPlayer implements CommandExecutor {
    private Main command;

    public Command(Main command) {
        this.command = command;
    }

    database database = new database();

    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        if (strings.length == 1) {
            if (check(commandSender.getName(),strings[0]) && checkLevel(commandSender.getName(), strings[0]) == 1) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "group set " + p.getName() + " HELPER");
            } else if (check(commandSender.getName(),strings[0]) && checkLevel(commandSender.getName(), strings[0]) == 2) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "group set " + p.getName() + " ADMIN");
            } else {
                return false;
            }

            p.sendMessage("§c§lВы начали рабочий день! Приятного админ процесса.");
            Bukkit.broadcastMessage("§d§l[!] §fАдминистратор §e§l" + p.getName() + " §fзашел на сервер");
            try {
                database.time("ST ",p.getName());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            return false;
        } if (!check(p.getName(), strings[0])) {
            commandSender.sendMessage("identification failed.");
            return true;
        } else {
            commandSender.sendMessage("alogin13 [arg], [arg], [arg]");
            return true;
        }
    }
}

