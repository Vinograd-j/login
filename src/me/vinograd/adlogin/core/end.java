package me.vinograd.adlogin.core;

import me.vinograd.adlogin.Main;
import me.vinograd.adlogin.db.database;
import me.xtopz.groups.manager.GroupManager;
import me.xtopz.groups.struct.Group;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.sql.SQLException;

public class end implements CommandExecutor {
    Main main;
    public end(Main main) {
        this.main=main;
    }
    database database = new database();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Group group = GroupManager.getInstance().getUserGroup(commandSender.getName());
        if(group.getType() == Group.Type.STAFF || group.getType() == Group.Type.ADMIN){
            commandSender.sendMessage("§c§lРабочий день окончен!");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"group remove "+commandSender.getName());
            try {
                database.time("END ",commandSender.getName());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return false;
        }
        return true;
    }
}
