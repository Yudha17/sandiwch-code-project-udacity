package com.udacity.sandwichclub;

import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;
//    String requestURl;
    TextView mainNameTv, alsoKnownAsTv, ingredientsTv, placeOfOriginTv, descriptionTv;
    ImageView imageIv;
    Sandwich sandwich;
    String json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);




        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

//        Resources resources = Resources.getSystem();
//        InputStream inputStreamReader = resources.openRawResource(R.raw.sandwiches);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStreamReader));
//        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
//        String json = sandwiches[position];
        ArrayList sandwichList = JsonUtils.fetchEarthquakeData(json);

        if (sandwichList == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        mainNameTv = (TextView) findViewById(R.id.main_name_iv);
        alsoKnownAsTv = (TextView) findViewById(R.id.also_known_tv);
        ingredientsTv = (TextView) findViewById(R.id.ingredients_tv);
        placeOfOriginTv = (TextView) findViewById(R.id.place_origin_tv);
        descriptionTv = (TextView) findViewById(R.id.description_tv);
        imageIv = (ImageView) findViewById(R.id.image_iv);

        sandwich = new Sandwich();

        mainNameTv.setText(sandwich.getMainName());
        alsoKnownAsTv.setText(sandwich.getAlsoKnownAsList().toString());
        placeOfOriginTv.setText(sandwich.getPlaceOfOrigin());
        descriptionTv.setText(sandwich.getDescription());
        ingredientsTv.setText(sandwich.getIngredientsList().toString());
        Picasso.with(this).load(sandwich.getImage()).into(imageIv);

//        populateUI();
//        Picasso.with(this)
//                .load(sandwich.getImage())
//                .into(ingredientsIv);
//
//        setTitle(Sandwich.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    public void populateUI() {

    }


}
