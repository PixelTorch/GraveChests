package com.pixeltorch.testplugin.Events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class OnDeath implements Listener {

    @EventHandler
    public void OnDeath(PlayerDeathEvent e){
        Player player = e.getEntity();
        ArrayList<ItemStack> a = new ArrayList<ItemStack>();

        for(ItemStack i : player.getInventory().getContents())
        {
            if(i != null)
            {
                a.add(i);
            }
        }

        player.getLocation().getBlock().setType(Material.CHEST);
        Chest chest = (Chest) player.getLocation().getBlock().getState();

        chest.getInventory().setContents(a.toArray(new ItemStack[a.size()]));
        e.getDrops().clear();

        Location playerCoords = e.getEntity().getLocation().getBlock().getLocation();
        int xCoord = playerCoords.getBlockX();
        int yCoord = playerCoords.getBlockY();
        int zCoord = playerCoords.getBlockZ();
        e.getEntity().sendMessage("Uh oh stinky! Your items are at X:" + xCoord + ", Y:" + yCoord + ", Z:" + zCoord + ".");
    }

}
