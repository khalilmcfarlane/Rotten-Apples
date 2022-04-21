package CS1530.RottenApples.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import CS1530.RottenApples.impl.FriendImpl;
import CS1530.RottenApples.impl.UserImpl;
import CS1530.RottenApples.models.User;
import CS1530.RottenApples.models.friendRequest;
import CS1530.RottenApples.repositories.UserRepository;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    private UserImpl newUser;
    
    @PostMapping("/signup")
    public String register(String username, String password, BindingResult bindingResult) {
        newUser = new UserImpl();
        User user = userRepository.findByName(username);
        if(user != null) {
            bindingResult.rejectValue("username", "error.user", "This user already exists.");
            //return "redirect:/signup"; just ignore this return stmt for now
        }  
       /* if(bindingResult.hasErrors()) {
            return "redirect:/signup";
        }*/
        newUser.register(username, password);
        return "signup";
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpSession session) {
        UserImpl loginUser = new UserImpl();
        User user = userRepository.findByUser(username, password);
        if(user == null) {
            return "redirect:/UserLogin?error";
        }
        else {
            session.setAttribute("user", user);
            //Is this needed?
            loginUser.login(username, password);
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
