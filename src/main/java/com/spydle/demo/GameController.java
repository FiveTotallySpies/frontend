package com.spydle.demo;

import com.spydle.demo.models.Room;  // Import Room
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
        // Simulate creating a new room with the provided nickname as the owner
        Room newRoom = new Room("New Room", nickname);

        // redirect to room list after creating a room
        return "redirect:/room-list";
    }

    @GetMapping("/room-list")
    public String roomList(Model model) {
        // Sample list of rooms
        List<Room> rooms = Arrays.asList(
                new Room("Room 1", "Kai"),
                new Room("Room 2", "Xin Lei"),
                new Room("Room 3", "Polyna")
        );

        model.addAttribute("rooms", rooms);
        return "room-list";
    }
}
