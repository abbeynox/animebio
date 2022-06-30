package ch.bbw.mygourmet;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;
        import org.springframework.http.HttpStatus;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;

        import java.io.IOException;
        import java.io.OutputStreamWriter;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.ProtocolException;
        import java.sql.*;
        import java.time.LocalDate;

@Controller
public class GourmetController {

    @GetMapping("/")
    private String editProfile(Model model){
        //model.addAttribute("formula", select());
        return "index";
    }

    @PostMapping("/result")
    private String results(@ModelAttribute AnimeList animeList, Model model){
        model.addAttribute("result", animeList);
        return "result";
    }
}