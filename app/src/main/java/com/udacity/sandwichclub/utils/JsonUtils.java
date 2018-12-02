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

    private static final String JSON_PARSE = "{\"name\":{\"mainName\":\"Ham and cheese sandwich\",\"alsoKnownAs\":[]},\"placeOfOrigin\":\"\",\"description\":\"A ham and cheese sandwich is a common type of sandwich. It is made by putting cheese and sliced ham between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables like lettuce, tomato, onion or pickle slices can also be included. Various kinds of mustard and mayonnaise are also common.\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG\",\"ingredients\":[\"Sliced bread\",\"Cheese\",\"Ham\"]}\n" +
                                             "{\"name\":{\"mainName\":\"Bosna\",\"alsoKnownAs\":[\"Bosner\"]},\"placeOfOrigin\":\"Austria\",\"description\":\"Bosna is a spicy Austrian fast food dish, said to have originated in either Salzburg or Linz. It is now popular all over western Austria and southern Bavaria.\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/c/ca/Bosna_mit_2_Bratw%C3%BCrsten.jpg\",\"ingredients\":[\"White bread\",\"Bratwurst\",\"Onions\",\"Tomato ketchup\",\"Mustard\",\"Curry powder\"]}\n" +
                                             "{\"name\":{\"mainName\":\"Chivito\",\"alsoKnownAs\":[]},\"placeOfOrigin\":\"Uruguay\",\"description\":\"Chivito is a national dish of Uruguay, It is a thin slice of tender cooked beef steak (churrasco), with mozzarella, tomatoes, mayonnaise, black or green olives, and commonly also bacon, fried or hard-boiled eggs and ham, served as a sandwich in a bun, often accompanied by French fried potatoes. Other ingredients, such as red beets, peas, grilled or pan-fried red peppers, and slices of cucumber, may be added.\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/4/48/Chivito1.jpg\",\"ingredients\":[\"Bun\",\"Churrasco beef\",\"Bacon\",\"Fried or hard-boiled eggs\",\"Ham\",\"Black or green olives\",\"Mozzarella\",\"Tomatoes\",\"Mayonnaise\"]}\n" +
                                             "{\"name\":{\"mainName\":\"Club sandwich\",\"alsoKnownAs\":[\"Clubhouse sandwich\"]},\"placeOfOrigin\":\"United States\",\"description\":\"A club sandwich, also called a clubhouse sandwich, is a sandwich of bread (occasionally toasted), sliced cooked poultry, fried bacon, lettuce, tomato, and mayonnaise. It is often cut into quarters or halves and held together by cocktail sticks. Modern versions frequently have two layers which are separated by an additional slice of bread.\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Club_sandwich.png/800px-Club_sandwich.png\",\"ingredients\":[\"Toasted bread\",\"Turkey or chicken\",\"Bacon\",\"Lettuce\",\"Tomato\",\"Mayonnaise\"]}\n" +
                                             "{\"name\":{\"mainName\":\"Gua bao\",\"alsoKnownAs\":[\"Steamed bao\",\"Pork belly bun\"]},\"placeOfOrigin\":\"Taiwan\",\"description\":\"Gua bao is a Taiwanese snack food consisting of a slice of stewed meat and other condiments sandwiched between flat steamed bread. The steamed bread is typically 6–8 centimetres (2.4–3.1 in) in size, semi-circular and flat in form, with a horizontal fold that, when opened, gives the appearance that it has been sliced. The traditional filling for gua bao is a slice of red-cooked porkbelly, typically dressed with stir-fried suan cai (pickled mustard greens), cilantro, and ground peanuts.\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Steamed_Sandwich%2Ctaken_by_LeoAlmighty.jpg/600px-Steamed_Sandwich%2Ctaken_by_LeoAlmighty.jpg\",\"ingredients\":[\"Steamed bread\",\"Stewed meat\",\"Condiments\"]}\n" +
                                             "{\"name\":{\"mainName\":\"Medianoche\",\"alsoKnownAs\":[\"Cuban Sandwich\"]},\"placeOfOrigin\":\"Cuba\",\"description\":\"Medianoche (\"midnight\" in Spanish) is a type of sandwich which originated in Cuba. It is served in many Cuban communities in the United States. It is so named because of the sandwich\'s popularity asa staple served in Havana\'s night clubs right around or after midnight.\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/a/a3/Sandwich_de_Medianoche.jpg/800px-Sandwich_de_Medianoche.jpg\",\"ingredients\":[\"Egg bread\",\"Roast pork\",\"Ham\",\"Mustard\",\"Swiss cheese\",\"Dill pickles\"]}\n" +
                                             "{\"name\":{\"mainName\":\"Pljeskavica\",\"alsoKnownAs\":[]},\"placeOfOrigin\":\"Serbia\",\"description\":\"Pljeskavica, a grilled dish of spiced meat patty mixture of pork, beef and lamb, is a national dish of Serbia, also popular in Bosnia and Herzegovina and Croatia. It is a main course served with onions, kajmak (milk cream), ajvar (relish), and urnebes (spicy cheese salad), either on plate with side dishes, or with lepinja (flatbread, as a type of hamburger). Recently, Pljeskavica has gained popularity elsewhere in Europe and is served in a few speciality fast food restaurants in Germany, Sweden, and Austria.\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/8/8f/Pljeskavica_%286883073017%29.jpg/800px-Pljeskavica_%286883073017%29.jpg\",\"ingredients\":[\"Two or more of beef, lamb, pork, veal\",\"Onions\",\"Bread crumbs\",\"Lard\"]}\n" +
                                             "{\"name\":{\"mainName\":\"Roujiamo\",\"alsoKnownAs\":[\"Rougamo\",\"Rou jiamo\"]},\"placeOfOrigin\":\"China\",\"description\":\"Roujiamo, meaning \"meat burger\" or \"meat sandwich\", is a street food originating from the cuisine of Shaanxi Province and now widely consumed all over China. The meat is most commonly pork,stewed for hours in a soup containing over 20 spices and seasonings. Although it is possible to use only a few spices (which many vendors do), the resulting meat is less flavourful.\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/Roujiamo.jpg/800px-Roujiamo.jpg\",\"ingredients\":[\"Pork\",\"bread\"]}\n" +
                                             "{\"name\":{\"mainName\":\"Shawarma\",\"alsoKnownAs\":[]},\"placeOfOrigin\":\"Middle East, Levant\",\"description\":\"Shawarma also spelled shawurma or shawerma, is a Levantine meat preparation, where lamb, chicken, turkey, beef, veal, or mixed meats are placed on a spit (commonly a vertical spit in restaurants), and may be grilled for as long as a day. Shavings are cut off the block of meat for serving, and the remainder of the block of meat is kept heated on the rotating spit. Shawarma can be served on a plate(generally with accompaniments), or as a sandwich or wrap. Shawarma is usually eaten with tabbouleh, fattoush, taboon bread, tomato, and cucumber. Toppings include tahini, hummus, pickled turnips, and amba.\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Shawarmafood.jpg/800px-Shawarmafood.jpg\",\"ingredients\":[\"Shawarma meat (lamb, chicken, turkey, beef) or shawarma falafel\",\"Pita or wrap bread\",\"Chopped or shredded vegetables\",\"Pickles\",\"Assorted condiments\"]}\n" +
                                             "{\"name\":{\"mainName\":\"Vada Pav\",\"alsoKnownAs\":[\"Bombay Burger\",\"Vada Pao\",\"Wada Pav\",\"Wada Pao\",\"Pao Vada\",\"Pav Vada\",\"Pao Wada\",\"Pav Wada\"]},\"placeOfOrigin\":\"India\",\"description\":\"Vada Pav is a vegetarian fast food dish native to the Indian state of Maharashtra. The dish consists of a deep fried potato dumpling placed inside a bread bun (pav) sliced almost in half through the middle. It is generally accompanied with one or more chutneys and a green chilli pepper.It originated as cheap street food in Mumbai, but is now served in food stalls and restaurants across India. It is also called Bombay Burger in keeping with its origins and its resemblance in physical form to a burger.\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/1/15/Vada_Paav-The_Mumbai_Burger.jpg\",\"ingredients\":[\"Deep-fried mashed potato patty\",\"chilli peppers\",\"garlic\",\"ginger\",\"bread bun\"]}";

    private JsonUtils(){}

    public class ArrayList<Sandwich> parseSandwichJson(){

        ArrayList<Sandwich> sandwiches = new ArrayList<>();

        try {
            JSONObject baseJsonParse = new JSONObject(JSON_PARSE);
            JSONArray sandwichArray = baseJsonParse.getJSONArray("sandwich_details");

            for (int i = 0; i<sandiwchArray.length(); i++){
                JSONObject currentSandwich = sandwichArray.getJSONObject(i);
                JSONObject details = currentSandwich.getJSONObject("details");
                String mainName = details.getString("mainName");
                String alsoKnownAs = details.getString("alsoKnownAs");
                String placeOfOrigin = details.getString("alsoKnownAs");
                String description = details.getString("description");
                String image = details.getString("image");
                String ingredients = details.getString("ingredients");

                Sandwich sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
                sandwiches.add(sandwich);
            }

        }catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

}
