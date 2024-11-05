package com.spydle.demo.models;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private String owner; // Maybe just without owner and
    private List<Player> players; // List to hold players
    // Fuck the owner, just list of player number 0.
    public Room(String name, String owner) {
        this.name = name;
        this.owner = owner;
        this.players = new ArrayList<>(); // Initialize the player list 4 players including the owner
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        this.players.add(player); // Method to add a player
    }
}
