package com.udacity.sandwichclub;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;


    @BindView(R.id.also_known_tv)
    TextView alsoKnownAsTV;

    @BindView(R.id.ingredients_tv)
    TextView ingredientsTV;

    @BindView(R.id.place_origin_tv)
    TextView placeOfOriginTV;

    @BindView(R.id.description_tv)
    TextView descriptionTV;

    @BindView(R.id.image_iv)
    ImageView imageIV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        ButterKnife.bind(this);

//        alsoKnownAsTV = (TextView) findViewById(R.id.also_known_tv);
//        ingredientsTV  = (TextView) findViewById(R.id.ingredients_tv);
//        placeOfOriginTV  = (TextView) findViewById(R.id.place_origin_tv);
//        descriptionTV  = (TextView) findViewById(R.id.description_tv);
//        imageIV  = (ImageView) findViewById(R.id.image_iv);


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

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich = JsonUtils.parseSandwichJson(json);
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI(sandwich);
        Picasso.with(this)
                .load(sandwich.getImage())
                .error(R.drawable.ic_error)
                .placeholder(R.drawable.ic_hourglass)
                .into(imageIV);

        setTitle(sandwich.getMainName());

    }

    private void populateUI(Sandwich sandwich) {
        for(int i = 0; i < sandwich.getAlsoKnownAsList().size();i++){
            if(i == sandwich.getAlsoKnownAsList().size()-1){
                alsoKnownAsTV.append(sandwich.getAlsoKnownAsList().get(i) );
            }else{
                alsoKnownAsTV.append(sandwich.getAlsoKnownAsList().get(i) + ", ");
            }
        }

        placeOfOriginTV.setText(sandwich.getPlaceOfOrigin());

        descriptionTV.setText(sandwich.getDescription());

        for(int l = 0; l < sandwich.getIngredientsList().size();l++){
            if(l == sandwich.getIngredientsList().size()-1){
                ingredientsTV.append(sandwich.getIngredientsList().get(l) );
            }else{
                ingredientsTV.append(sandwich.getIngredientsList().get(l) + ", ");
            }
        }

    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }
}
