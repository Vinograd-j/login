package me.vinograd.adlogin.core;

import me.vinograd.adlogin.db.CheckPlayer;
import me.vinograd.adlogin.db.database;
import me.xtopz.groups.manager.GroupManager;
import me.xtopz.groups.struct.Group;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class adminlogin implements Listener {
    Writing wr;
    @EventHandler
    public void takeoff(PlayerJoinEvent e) throws SQLException {
        Player p = e.getPlayer();
        Group group = GroupManager.getInstance().getUserGroup(p.getName());
        if (group.getType() == Group.Type.ADMIN || group.getType() == Group.Type.STAFF){
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "group remove "+p.getName());
            if(p.getName().equals(wr.nameFor)){
                p.sendMessage("§6§lВы были назначены на §с§lАДМИНКУ 1 УРОВНЯ!");
                wr.nameFor = "";
            }
        }
        if(checkPlayer.nameCheck(e.getPlayer().getName())){
            database.time("J ",p.getName());
        }
    }
    CheckPlayer checkPlayer = new CheckPlayer();
    database database = new database();
    @EventHandler
    public void sendoff(PlayerQuitEvent e) throws SQLException {
        Player p = e.getPlayer();
        if(checkPlayer.nameCheck(e.getPlayer().getName())){
            Bukkit.broadcastMessage("§d§l[!] §fАдминистратор §e§l"+p.getName()+" покинул сервер");
            database.time("L ",p.getName());
        }
    }
}
