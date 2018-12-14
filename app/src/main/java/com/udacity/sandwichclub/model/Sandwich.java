package com.udacity.sandwichclub.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Sandwich {

     String mainName;
     List<String> alsoKnownAsList = new ArrayList<>();
     String placeOfOrigin;
     String description;
     String image;
     List<String> ingredientsList = new ArrayList<>();

    public Sandwich() {

    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public List<String> getAlsoKnownAsList() {
        return alsoKnownAsList;
    }

    public void setAlsoKnownAsList(ArrayList<String> alsoKnownAsList) {
        this.alsoKnownAsList = alsoKnownAsList;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(ArrayList<String> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public Sandwich(String mainName, ArrayList<String> alsoKnownAsList, String placeOfOrigin, String description, String image, ArrayList<String> ingredientsList) {
        this.mainName = mainName;
        this.alsoKnownAsList = alsoKnownAsList;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredientsList = ingredientsList;
    }

    }

