package com.udacity.sandwichclub.model;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {

     private String mainName;
     private List<String> alsoKnownAsList;
     private String placeOfOrigin;
     private String description;
     private String image;
     private List<String> ingredientsList;

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

    public void setAlsoKnownAsList(List<String> alsoKnownAsList) {
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

    public String getImage() {return image;}

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<String> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public Sandwich(String mainName, List<String> alsoKnownAsList, String placeOfOrigin, String description, String image, List<String> ingredientsList) {
        this.mainName = mainName;
        this.alsoKnownAsList = alsoKnownAsList;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredientsList = ingredientsList;
    }

    }

