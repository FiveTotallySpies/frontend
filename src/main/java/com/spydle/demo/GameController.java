package com.spydle.demo;

import com.spydle.demo.models.Room; // Import Room
import com.spydle.demo.models.Player; // Import Player
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class GameController {

    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }

    @PostMapping("/create-room")
    public String createRoom(@RequestParam String nickname, Model model) {
        Room newRoom = new Room("New Room", nickname);
        // Redirect to room list after creating a room
        return "redirect:/room-list";
    }

    @GetMapping("/room-list")
    public String roomList(Model model) {
        List<Room> rooms = Arrays.asList(
                new Room("Room 1", "Owner1"),
                new Room("Room 2", "Owner2"),
                new Room("Room 3", "Owner3")
        );

        model.addAttribute("rooms", rooms);
        return "room-list";
    }

    @GetMapping("/end")
    public String endPage(Model model) {
        // Simulate a list of players with scores
        List<Player> players = Arrays.asList(
                new Player("Alice", 120),
                new Player("Bob", 150),
                new Player("Charlie", 100),
                new Player("Diana", 200),
                new Player("Eve", 180)
        );

        // Sort players by score in descending order and take the top 3
        List<Player> topPlayers = players.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()))
                .limit(3)
                .toList();

        // Add the top players to the model for the view
        model.addAttribute("topPlayers", topPlayers);

        return "end";
    }
}
