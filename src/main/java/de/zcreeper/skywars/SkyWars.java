package de.zcreeper.skywars;

import de.zcreeper.skywars.gamestate.GameState;
import de.zcreeper.skywars.listener.JoinListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class SkyWars extends JavaPlugin {

    public static SkyWars instance;

    private String prefix;
    private String noperms;

    private GameState gameState;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        gameState = GameState.LOBBY;
        prefix = getConfig().getString("prefix");
        noperms = getConfig().getString("noperms");

        System.out.println("[SkyWars] Plugin aktiviert.");

        getServer().getPluginManager().registerEvents(new JoinListener(), this);

    }

    @Override
    public void onDisable() {
        System.out.println("[SkyWars] Plugin deaktiviert.");
    }

    public static SkyWars getInstance() {
        return instance;
    }

    @Override
    public @NotNull FileConfiguration getConfig() {
        return super.getConfig();
    }

    public String getPrefix() {
        return prefix;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public String getNoperms() {
        return noperms;
    }
}
