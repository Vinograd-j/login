package me.vinograd.adlogin.core;

import me.vinograd.adlogin.Main;
import me.vinograd.adlogin.db.database;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.SQLException;

public class Writing implements CommandExecutor {
    Main comm;
    public Writing(Main main) {
        this.comm=main;
    }
    database database = new database();
    public String nameFor;
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender.hasPermission("addadminsfortheserver13.add") && strings.length == 2){
            Player p = Bukkit.getPlayer(strings[0]);
            try {
                database.input(strings[0],strings[1]);
                if(p.isOnline()) {
                    p.sendMessage("§6§lВы были назначены на " + "§с§l" + "АДМИНКУ 1 УРОВНЯ!");
                }else{
                   nameFor = p.getName();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return false;
           }
        commandSender.sendMessage("У вас нет прав на выполнение данной команды");

        return true;
    }
}