package me.vinograd.adlogin.core;

import me.vinograd.adlogin.Main;
import me.vinograd.adlogin.db.database;
import me.xtopz.groups.manager.GroupManager;
import me.xtopz.groups.struct.Group;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import me.vinograd.adlogin.db.CheckPlayer;
import org.bukkit.entity.Player;

import java.sql.SQLException;

public class unlogin implements CommandExecutor {
    Main main;
    public unlogin(Main main) {
        this.main = main;
    }
    database db = new database();
    CheckPlayer ch;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length == 1){
            if(commandSender.hasPermission("aaadddmdeleteusers.rem")){
                try {
                    db.remove(strings[0]);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                return false;
            }else{
                commandSender.sendMessage("У вас нету прав.");
            }
        }
        return true;
    }
}
