package ch.bbw.mygourmet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GourmetController {

    @GetMapping("/")
    private String editProfile(AnimeList animeList, Model model){
        model.addAttribute("formula", animeList);
        return "index";
    }

    @PostMapping("/result")
    private String results(@ModelAttribute AnimeList animeList, Model model){
        model.addAttribute("result", animeList);
        return "result";
    }

}
