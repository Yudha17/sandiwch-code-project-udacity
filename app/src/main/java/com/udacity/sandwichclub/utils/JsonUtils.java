package com.udacity.sandwichclub.utils;

import android.content.res.Resources;
import android.util.Log;

import com.udacity.sandwichclub.R;
import com.udacity.sandwichclub.SandwichAdapter;
import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class JsonUtils {

    private SandwichAdapter mSandiwchAdapter;
    ArrayList<Sandwich> sandwichList = new ArrayList<>();

    public static ArrayList<Sandwich> fetchEarthquakeData(String requestUrl) {

        URL url = createUrl(requestUrl);


        String jsonResponse = null;
        try{
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e){

        }


        ArrayList<Sandwich> sandwichList = parseSandwichJson(jsonResponse);

        return sandwichList;
    }


    private static URL createUrl(String stringUrl) {
        URL url = null;
        try{
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {

        }
        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException{
        String jsonResponse = "";

        // If the URL is null, then return early
        if (url == null){
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try{
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200)
            // then read the input stream and parse the response
            if(urlConnection.getResponseCode() == 200){
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {

            }
        } catch (IOException e) {

        } finally {
            if(urlConnection != null){
                urlConnection.disconnect();
            }
            if(inputStream != null){
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if(inputStream != null){
            Resources resources = Resources.getSystem();
            InputStream inputStreamReader = resources.openRawResource(R.raw.sandwiches);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStreamReader));
            String line = reader.readLine();
            while (line != null){
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }


    public static ArrayList parseSandwichJson(String json) {

        ArrayList sandwichList = new ArrayList();

        try {
            JSONArray rootJA = new JSONArray(json);

            for(int i=0; i<rootJA.length(); i++){
                Sandwich sandwich;
                JSONObject name=rootJA.getJSONObject(i);


            String mainName = name.getString("mainName");

            ArrayList<String> alsoKnownAsList = new ArrayList<>();
            JSONArray alsoKnownJSON = name.getJSONArray("alsoKnownAs");
            for (int j = 0; j < alsoKnownJSON.length(); j++) {
                 alsoKnownAsList.add(alsoKnownJSON.get(j).toString());
            }

            String placeOfOrigin = name.getString("placeOfOrigin");
            String description = name.getString("description");
            String image = name.getString("image");

            ArrayList<String> ingredientsList = new ArrayList<>();
            JSONArray ingredientsJSON = name.getJSONArray("ingredients");
            for (int k = 0; k < ingredientsJSON.length(); k++) {
                ingredientsList.add(ingredientsJSON.get(k).toString());
            }



            sandwich = new Sandwich();

            sandwich.setMainName(mainName);
            sandwich.setAlsoKnownAsList(alsoKnownAsList);
            sandwich.setPlaceOfOrigin(placeOfOrigin);
            sandwich.setDescription(description);
            sandwich.setImage(image);
            sandwich.setIngredientsList(ingredientsList);



            sandwichList.add(sandwich);

            }


        }catch(JSONException e){
            Log.e("JsonUtils", "Problem parsing the JSON results", e);
        }

        return sandwichList;
    }

}