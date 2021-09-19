import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SendHttpGETRequest {
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

    public static void get_Result(String response,String from_cur,String to_cur,double ammount)throws JSONException{
        JSONObject obj = new JSONObject(response.toString());
        System.out.println(ammount + " " + from_cur +"= " + ammount * obj.getDouble("conversion_rate") + to_cur);
    }
}




/*
/*public static void get_request() throws IOException {

        String GET_URL =  "https://v6.exchangerate-api.com/v6/" + api_key + "/pair/" + from_cur + "/" + to_cur;
        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
    }








    public static void sendHttpGETRequest(String api_key,String from_cur,String to_cur,double ammount) throws IOException, JSONException {

        String GET_URL =  "https://v6.exchangerate-api.com/v6/" + api_key + "/pair/" + from_cur + "/" + to_cur;
        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        //get_request();
        int responseCode = httpURLConnection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }in.close();



        }
        else{

            System.out.println("GET request failed!");
        }
    }


 */