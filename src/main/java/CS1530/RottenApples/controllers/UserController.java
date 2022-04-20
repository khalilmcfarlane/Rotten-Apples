package CS1530.RottenApples.controllers;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import CS1530.RottenApples.impl.FriendImpl;
import CS1530.RottenApples.impl.UserImpl;
import CS1530.RottenApples.models.Playlist;
import CS1530.RottenApples.models.User;
import CS1530.RottenApples.models.friendRequest;
import CS1530.RottenApples.repositories.PlaylistRepository;
import CS1530.RottenApples.repositories.UserRepository;
//import friendRequest and friendRepository

@RestController
public class UserController {
    private UserRepository userRepository;
    private PlaylistRepository playlistRepository;

    UserImpl newUser, loginUser;
    
    //I think this code goes inside homePage.java
    @PostMapping("/signup")
    public String register(@RequestParam("username") String username, String password, BindingResult bindingResult) {
        newUser = new UserImpl();
        User user = userRepository.findByName(username);
        if(user != null) {
            bindingResult.rejectValue("username", "error.user", "This username already exists.");
            return "redirect:/signup";
        }  
        if(bindingResult.hasErrors()) {
            return "signup";
        }
        newUser.register(username, password);
        //After user has registered, how to automatically login in?  
        //Where is the user redirected?
        return "signup";
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpSession session) {
        loginUser = new UserImpl();
        User user = userRepository.findByUser(username, password);
        if(user == null) {
            return "redirect:/UserLogin?error";
        }
        else {
            session.setAttribute("user", user);
            //What do I return to?
            return "UserLogin";
        } 
    }

    @GetMapping(value = "logout")
    public String logout(HttpSession session) {
        //skeleton
        session.invalidate();
        return "redirect:/login";
    }

    //Need to map to an HTML page
    //@GetMapping("{username}/friends")
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
