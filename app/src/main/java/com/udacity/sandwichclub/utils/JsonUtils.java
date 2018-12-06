package com.udacity.sandwichclub.utils;

import android.content.res.Resources;
import android.util.Log;

import com.udacity.sandwichclub.R;
import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {


    public static List<Sandwich> parseSandwichJson(String json) {

        List<Sandwich> sandwichList = new ArrayList<>();

        try {
            JSONObject baseJsonParse = new JSONObject(json);
            JSONArray detailSandwich = baseJsonParse.getJSONArray("");


            for (int i = 0; i < detailSandwich.length(); i++) {
                JSONObject object = detailSandwich.getJSONObject(i);

                List<Sandwich.alsoKnownAs> alsoKnownAsList = new ArrayList<>();
                for (int j = 0; j < object.getJSONArray("alsoKnownAs").length(); j++) {
                    Sandwich.alsoKnownAs alsoKnownAs1 = new Sandwich.alsoKnownAs();
                    alsoKnownAs1.setAlsoKnownAs(object.getJSONArray("alsoKnownAs").
                            getJSONObject(j).getString("alsoKnownAs"));
                    alsoKnownAsList.add(alsoKnownAs1);
                }

                String placeOfOrigin = object.getString("placeOfOrigin");
                String description = object.getString("description");
                String image = object.getString("image");

                List<Sandwich.ingredients> ingredientsList = new ArrayList<>();
                for (int k = 0; k < object.getJSONArray("ingredients").length(); k++) {
                    Sandwich.ingredients ingredients1 = new Sandwich.ingredients();
                    ingredients1.setIngredients(object.getJSONArray("ingredients").
                            getJSONObject(k).getString("ingredients"));
                    ingredientsList.add(ingredients1);
                }

                Sandwich sandwich = new Sandwich(alsoKnownAsList, placeOfOrigin, description, image, ingredientsList);

                sandwichList.add(sandwich);

            }
        }catch(JSONException e){
            Log.e("JsonUtils", "Problem parsing the JSON results", e);

        }
        return sandwichList;
    }
}