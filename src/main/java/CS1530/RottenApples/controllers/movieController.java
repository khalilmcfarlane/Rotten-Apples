package CS1530.RottenApples.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import CS1530.RottenApples.models.Movie;
import CS1530.RottenApples.repositories.MovieRepository;

@Controller
@RequestMapping("/movies")
public class movieController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/{id}")
    public String movieDetail(@PathVariable int id, Model model) {
        Movie movie = movieRepository.findById(id).get();
        model.addAttribute("movie", movie);
        return "movieDetail";
    }
}
