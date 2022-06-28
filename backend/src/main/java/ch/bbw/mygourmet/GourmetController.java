package ch.bbw.mygourmet;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;
        import org.springframework.http.HttpStatus;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;
        import java.sql.*;

@Controller
public class GourmetController {

    @GetMapping("/")
    private String editProfile(Model model){
        model.addAttribute("formula", select());
        return "index";
    }

    @PostMapping("/result")
    private String results(@ModelAttribute AnimeList animeList, Model model){
        model.addAttribute("result", animeList);
        return "result";
    }

    /*@GetMapping( "/")
    @ResponseBody
    public String select(Model model){
        return select();
    }*/

    @GetMapping("/select")
    @ResponseBody
    public String getOneUser(Model model, AnimeList animeList){
        model.addAttribute("select", animeList);
        return select1(animeList.getId());
    }
/*
    @PostMapping("/api/v1/users/")
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public void createUser(@RequestBody BlackboxModel blackboxModel){
        create(blackboxModel.getFirstName(), blackboxModel.getLastName(), blackboxModel.getEmail(), blackboxModel.getCreatedAt(), blackboxModel.getCreatedBy(), blackboxModel.getUpdatedAt(), blackboxModel.getUpdatedBy());
        return;
    }

    @RequestMapping(value = "/api/v1/users/{id}",
            produces = "application/json",
            method=RequestMethod.PUT)
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    @ResponseBody
    private void put(@PathVariable(value = "id") int id, @RequestBody BlackboxModel blackboxModel) throws JSONException {
        update(id, blackboxModel.getFirstName(), blackboxModel.getLastName(), blackboxModel.getEmail(), blackboxModel.getUpdatedAt(), blackboxModel.getUpdatedBy());
        return;
    }

    @RequestMapping(value = "/api/v1/users/{id}",
            produces = "application/json",
            method=RequestMethod.DELETE)
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    @ResponseBody
    private String delete(@PathVariable(value = "id") int id) throws JSONException {
        deleteUser(id);
        return "worked";
    }*/

    public String select(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/animebio", "root", "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM AnimeList");
            JSONArray jsonArray = new JSONArray();
            while(resultSet.next()) {
                JSONObject json = new JSONObject();
                json.put("id", resultSet.getInt(1));
                json.put("name", resultSet.getString(2));
                json.put("type", resultSet.getString(3));
                json.put("score", resultSet.getDouble(4));
                json.put("score_rank", resultSet.getInt(5));
                json.put("popularity_rank", resultSet.getInt(6));
                json.put("air_date", resultSet.getString(7));
                json.put("studio", resultSet.getString(8));
                json.put("num_of_episode", resultSet.getInt(9));
                json.put("genres", resultSet.getString(10));
                json.put("themes", resultSet.getString(11));
                json.put("demographic", resultSet.getString(12));
                jsonArray.put(json);
            }
            String list = jsonArray.toString();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String select1(int id){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_database", "root", "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE id="+ id);
            JSONObject json = new JSONObject();
            while(resultSet.next()) {
                json.put("id", resultSet.getInt(1));
                json.put("createdAt", resultSet.getDate(2));
                json.put("createdBy", resultSet.getString(3));
                json.put("email", resultSet.getString(4));
                json.put("firstName", resultSet.getString(5));
                json.put("lastName", resultSet.getString(6));
                json.put("updatedAt", resultSet.getDate(7));
                json.put("updatedBy", resultSet.getString(8));
            }
            String jsonObject = json.toString();
            connection.close();
            return jsonObject;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String create(String firstName, String lastName, String email, String createdAt, String createdBy, String updatedAt, String updatedBy){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_database", "root", "root");
            Statement statement = connection.createStatement();
            int executeUpdate = statement.executeUpdate("INSERT INTO users (first_name, last_name, email_address, created_at, created_by, updated_at, updated_by) VALUES ('" + firstName + "', '" + lastName + "', '" + email + "', '" + createdAt + "', '" + createdBy+"', '"+updatedAt+"', '"+updatedBy+"')");
            String toString = Integer.toString(executeUpdate);
            connection.close();
            return toString;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String update(int id, String firstName, String lastName, String email, String updatedAt, String updatedBy){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_database", "root", "root");
            Statement statement = connection.createStatement();
            int executeUpdate = statement.executeUpdate("UPDATE users SET first_name='" + firstName + "', last_name='" + lastName + "', email_address='" + email + "', updated_at='"+ updatedAt + "', updated_by='"+ updatedBy + "' WHERE id="+ id);
            String toString = Integer.toString(executeUpdate);
            connection.close();
            return toString;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String deleteUser(int id){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_database", "root", "root");
            Statement statement = connection.createStatement();
            int execute = statement.executeUpdate("DELETE FROM users WHERE id=" + id);
            String toString = Integer.toString(execute);
            connection.close();
            return toString;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}