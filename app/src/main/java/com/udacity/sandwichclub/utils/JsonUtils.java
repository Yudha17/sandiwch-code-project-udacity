package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public final class JsonUtils {

    public static final String KEY_NAME = "name";
    public static final String KEY_MAIN_NAME = "mainName";
    public static final String KEY_ALSO_KNOWN_AS = "alsoKnownAs";
    public static final String KEY_PLACE_OF_ORIGIN = "placeOfOrigin";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_INGREDIENTS = "ingredients";


    public static Sandwich parseSandwichJson(String json) {


        Sandwich sandwich = new Sandwich();
        try {



            JSONObject objectSandwich = new JSONObject(json);

            if(objectSandwich.has(KEY_NAME)) {
                JSONObject objectName = objectSandwich.optJSONObject(KEY_NAME);


                String mainName = objectName.optString(KEY_MAIN_NAME);
                sandwich.setMainName(mainName);

                JSONArray ja1 = objectName.optJSONArray(KEY_ALSO_KNOWN_AS);
                List<String> alsoKnownAsList = new ArrayList<>();
                for (int i = 0; i < ja1.length(); i++) {

                    alsoKnownAsList.add(ja1.getString(i));
                }
                sandwich.setAlsoKnownAsList(alsoKnownAsList);

                String placeOfOrigin = objectSandwich.optString(KEY_PLACE_OF_ORIGIN);
                sandwich.setPlaceOfOrigin(placeOfOrigin);


                String description = objectSandwich.optString(KEY_DESCRIPTION);
                sandwich.setDescription(description);

                String image = objectSandwich.optString(KEY_IMAGE);
                sandwich.setImage(image);

                JSONArray ja2 = objectSandwich.optJSONArray(KEY_INGREDIENTS);
                List<String> ingredientsList = new ArrayList<>();
                for (int l = 0; l < ja2.length(); l++) {

                    ingredientsList.add(ja2.getString(l));
                }
                sandwich.setIngredientsList(ingredientsList);
            }


            return sandwich;

        } catch (JSONException e1) {
            e1.printStackTrace();
            return null;
        }

    }

}