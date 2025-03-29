package io.github.recipesync;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Keyed;
import org.bukkit.inventory.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeAutoSync extends JavaPlugin implements Listener {

    private final List<NamespacedKey> serverRecipes = new ArrayList<>();

    @Override
    public void onEnable() {
        reloadServerRecipes();
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("RecipeAutoSync enabled");
    }

    private void reloadServerRecipes() {
        serverRecipes.clear();
        // 使用迭代器替代流式API
        Bukkit.recipeIterator().forEachRemaining(recipe -> {
            if (recipe instanceof Keyed) {
                serverRecipes.add(((Keyed) recipe).getKey());
            }
        });
        getLogger().info("Loaded " + serverRecipes.size() + " recipes");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        Bukkit.getScheduler().runTaskAsynchronously(this, () -> {
            final int count = syncRecipes(player);
            if (count > 0) {
                getLogger().info(player.getName() + " learned " + count + " new recipes");
            }
        });
    }

    private int syncRecipes(Player player) {
        List<NamespacedKey> missingRecipes = new ArrayList<>();
        for (NamespacedKey key : serverRecipes) {
            if (!player.hasDiscoveredRecipe(key)) {
                missingRecipes.add(key);
            }
        }
        
        if (!missingRecipes.isEmpty()) {
            Bukkit.getScheduler().runTask(this, () -> 
                player.discoverRecipes(missingRecipes)
            );
            return missingRecipes.size();
        }
        return 0;
    }
}