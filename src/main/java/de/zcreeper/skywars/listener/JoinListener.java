package de.zcreeper.skywars.listener;

import de.zcreeper.skywars.SkyWars;
import de.zcreeper.skywars.gamestate.GameState;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (SkyWars.getInstance().getGameState().equals(GameState.LOBBY)) {
            event.setJoinMessage(SkyWars.getInstance().getConfig().getString("join-message"));
            player.setGameMode(GameMode.ADVENTURE);
            player.setHealth(20);
            player.setFoodLevel(20);
        }

    }

}
