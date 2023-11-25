import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Weather {



    public static JSONObject getweatherdata(String locationName) throws IOException, ParseException {

        JSONArray locationdata = getlocationdata(locationName);

        JSONObject location = (JSONObject) locationdata.get(0);
        double latitude = (double) location.get("latitude");
        double longitude = (double) location.get("longitude");

        String urlString = "https://api.open-meteo.com/v1/forecast?" +
                "latitude=" + latitude + "&longitude=" + longitude +
                "&hourly=temperature_2m,relativehumidity_2m,weathercode,windspeed_10m&timezone=America%2FLos_Angeles";

        HttpURLConnection conn = fetchApiResponse(urlString);
        try {
            if(conn.getResponseCode()!=200){

                System.out.println("Error: Could not connect to API");
                return null;
            }


        StringBuilder resultjson = new StringBuilder();
        Scanner scanner = new Scanner(conn.getInputStream());
        while (scanner.hasNext()){

            resultjson.append(scanner.nextLine());
        }
        scanner.close();
        conn.disconnect();

        JSONParser parser = new JSONParser();
        JSONObject resultobj = (JSONObject)parser.parse(String.valueOf(resultjson));

        JSONObject hourly = (JSONObject) resultobj.get("hourly");

        JSONArray time = (JSONArray)hourly.get("time");

        int index = getindexofcurrenttime(time);

        JSONArray temperaturedata =(JSONArray)hourly.get("temperature_2m");
        double temperature = (double) temperaturedata.get(index);

        JSONArray weathercode = (JSONArray)hourly.get("weathercode");

        String weathercondition = convertweathercode((long)weathercode.get(index));


        JSONArray relativeHumidity = (JSONArray) hourly.get("relativehumidity_2m");
        long humidity = (long) relativeHumidity.get(index);

        JSONArray windspeedData = (JSONArray) hourly.get("windspeed_10m");
        double windspeed = (double) windspeedData.get(index);
      JSONObject weatherData = new JSONObject();

        weatherData.put("temperature", temperature);
        weatherData.put("weather_condition", weathercondition);
        weatherData.put("humidity", humidity);
        weatherData.put("windspeed", windspeed);
        return weatherData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }








    }




    public static JSONArray getlocationdata(String locationName){

        locationName = locationName.replaceAll(" ", "+");

        String urlString = "https://geocoding-api.open-meteo.com/v1/search?name=" +
                locationName + "&count=10&language=en&format=json";

try {
    HttpURLConnection conn = fetchApiResponse(urlString);

    if(conn.getResponseCode()!=200){
        System.out.println("Error: Could not connect to API");
        return null;
    }else{

        StringBuilder resultJson = new StringBuilder();
        Scanner scanner = new Scanner(conn.getInputStream());

        while (scanner.hasNext()){
            resultJson.append(scanner.nextLine());
        }
        scanner.close();
        conn.disconnect();

        JSONParser parser = new JSONParser();
        JSONObject resultsjsonobj = (JSONObject)parser.parse(String.valueOf(resultJson));
        JSONArray locationdata = (JSONArray) resultsjsonobj.get("results");
        return  locationdata;
    }

}catch (Exception e){
    e.printStackTrace();
    return null;

}

    }

    public static HttpURLConnection fetchApiResponse(String urlstring){


        try {
            URL url = new URL(urlstring);

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            conn.setRequestMethod("GET");

            conn.connect();

            return conn;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    private static int getindexofcurrenttime(JSONArray timeList) {

        String currenttime = getcurrenttime();
        for(int i =0; i <timeList.size();i++){
                String time =(String)timeList.get(i);
                if(time.equalsIgnoreCase(currenttime)){

                    return i;
                }
        }
        return 0;
    }

    private static String getcurrenttime(){

        LocalDateTime currentdatetime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH':00'");
        String formattedtime = currentdatetime.format(formatter);
        return formattedtime;
    }
    private static String convertweathercode(long weathercode){

        String weatherCondition = "";
        if(weathercode == 0L){
            // clear
            weatherCondition = "Clear";
        }else if(weathercode > 0L && weathercode <= 3L){
            // cloudy
            weatherCondition = "Cloudy";
        }else if((weathercode >= 51L && weathercode <= 67L)
                || (weathercode >= 80L && weathercode <= 99L)){
            // rain
            weatherCondition = "Rain";
        }else if(weathercode >= 71L && weathercode <= 77L){
            // snow
            weatherCondition = "Snow";
        }

        return weatherCondition;
    }


    }


