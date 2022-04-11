package CS1530.RottenApples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Controller
public class movieController {
    private Model movieModel;
    private View movieView;
    
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }
    
    @getMapping(value = "/movie/title")
    public String getTitle(){
        movieModel = Movie.getTitle();
    }

    @getMapping(value = "/movie/id")
    public int getId(){
        movieModel = Movie.getTitle();
    }

    @getMapping(value = "/movie/genre")
    public String getGenre(){
        movieModel = Movie.getGenre();
    }

    @getMapping(value = "/movie/releaseDate")
    public String getreleaseDate(){
        movieModel = Movie.getReleaseData();
    }

    @getMapping(value = "/movie/poster")
    public String getPoster(){
        movieModel = Movie.getPoster();
    }

    @getMapping(value = "/movie/poster")
    public List<User> getUserList(){
        movieModel = Movie.usersWhoWatched();
    }
}
 
