package com.udacity.sandwichclub;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;


import java.util.ArrayList;


public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;


    Toolbar toolbar;
    String json;
    Context context = DetailActivity.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar = findViewById(R.id.toolbar);


        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            toolbar.setTitle(bundle.getString("Title"));
        }

        Intent intent = this.getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        ArrayList<Sandwich> sandwiches = JsonUtils.parseSandwichJson(json);

        Sandwich sandwich = sandwiches.get(position);


        TextView alsoKnownAsTV = (TextView) findViewById(R.id.also_known_tv);
        final String alsoKnownAsSt = sandwich.getAlsoKnownAsList().toString();
        alsoKnownAsTV.setText(alsoKnownAsSt);

        TextView ingredientsTV = (TextView) findViewById(R.id.ingredients_tv);
        final String ingredientsSt = sandwich.getIngredientsList().toString();
        ingredientsTV.setText(ingredientsSt);

        TextView placeOfOriginTV = (TextView) findViewById(R.id.place_origin_tv);
        final String placeOfOriginSt = sandwich.getPlaceOfOrigin();
        placeOfOriginTV.setText(placeOfOriginSt);

        TextView descriptionTV = (TextView) findViewById(R.id.description_tv);
        final String descriptionSt = sandwich.getDescription();
        descriptionTV.setText(descriptionSt);

        ImageView imageIV = (ImageView) findViewById(R.id.image_iv);
        final String imageSt = sandwich.getImage();
        Picasso.with(context).load(imageSt).into(imageIV);

    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }
}
