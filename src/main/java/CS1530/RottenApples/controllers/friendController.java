package CS1530.RottenApples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CS1530.RottenApples.models.*;
import CS1530.RottenApples.repositories.*;
import java.util.*;

@Controller
@RequestMapping("user/friends")
public class friendController {
    private UserRepository userRepository;
    private FriendRequestRepository friendRequest;
    //Create method named create friend that creates a friend request
    //recipient could be a username that you searched up
    // path could be {username}/friends
    // This should probably just go in friendController

}
