package CS1530.RottenApples.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import CS1530.RottenApples.impl.FriendImpl;
import CS1530.RottenApples.models.User;
import CS1530.RottenApples.models.friendRequest;
import CS1530.RottenApples.repositories.UserRepository;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/signup")
    public String register(String username, String password) {
        userRepository.register(username, password);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(String username, String password) {
        User user = userRepository.findByUser(username, password);
        if(user.getUsername() != null && user.getPassword() != null) {
            return "redirect:/";
        }
        return null;
    }

    @GetMapping(value = "logout")
    public String logout(HttpSession session) {
        //skeleton
        session.invalidate();
        return "redirect:/login";
    }

    //Need to map to an HTML page
    @GetMapping("{username}/friends")
    public void displayFriends(Model model, @PathVariable String username) {
        FriendImpl friend = new FriendImpl(); 
        User user = userRepository.findByName(username);
        List<friendRequest> friends = friend.getFriends(user); //get the friends of this user
        model.addAttribute("Friends", friends);
        /*for(friendRequest reqs : friends) {
            //display users
            System.out.print(reqs.toString().replaceAll("[]", ""));
        }*/
    }
}
