import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.*;

public class MovieTitle{
    static String getMovieTitles(String substr) {
        List <String> listOfMovies = new ArrayList<>();
        int totalPages = Integer.MAX_VALUE;

        for(int pageCounter =1; pageCounter <= totalPages; pageCounter++){

            try {
                URL obj = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&page=" + pageCounter);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");
                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String httpResponse;
                while ((httpResponse = reader.readLine()) != null) {
                    JsonObject convertedObject = new Gson().fromJson(httpResponse, JsonObject.class);
                    JsonArray data = convertedObject.getAsJsonArray("data");
                    totalPages = Integer.parseInt(String.valueOf(convertedObject.get("total_pages")));
                    for(JsonElement element : data)
                        listOfMovies.add(element.getAsJsonObject().get("Title").getAsString());

                 }
                reader.close();
            } catch (Exception ex) {
                System.out.println("Error getting request. " + ex.getMessage());
            }

        }
        Collections.sort(listOfMovies);
        return String.join("\n", listOfMovies);
    }

    public static void main(String[] args) {
        System.out.println(getMovieTitles("spiderman"));
    }
 }