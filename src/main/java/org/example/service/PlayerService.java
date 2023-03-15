package org.example.service;

import org.example.model.Player;

import java.util.List;

public interface PlayerService {
    Player getPlayerById(int id);
    Player addPlayer(Player player);
    Player updatePlayerById(int id,Player player);
    boolean deletePlayerById(int id);
    List<Player> getPlayers();
}
