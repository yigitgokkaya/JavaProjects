import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SendHttpGETRequest {

    //creates the necessary  url for the api request , sets the requestMethod the get and gets the  conversion result from get_Result method
    public static void get_request(String api_key, String from_cur, String to_cur,double amount) throws IOException, JSONException {
        String GET_URL = "https://v6.exchangerate-api.com/v6/" + api_key + "/pair/" + from_cur + "/" + to_cur;
        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode=httpURLConnection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK){
            get_Result(read(httpURLConnection),from_cur,to_cur,amount);
        }
    }

    // reads the api string returns it as a string
    public static String read(HttpURLConnection httpURLConnection) throws IOException, JSONException {
        int responseCode = httpURLConnection.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
    }

     // creates a json object that gets the conversion_rate from the StringBuffer and prints out the conversion
    public static void get_Result(String response,String from_cur,String to_cur,double ammount)throws JSONException{
        JSONObject obj = new JSONObject(response.toString());
        System.out.println(ammount + " " + from_cur +"= " + ammount * obj.getDouble("conversion_rate") + to_cur);
    }
}




