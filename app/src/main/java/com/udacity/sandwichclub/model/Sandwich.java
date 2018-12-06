package com.udacity.sandwichclub.model;

import java.util.List;

public class Sandwich {

    private String mainName;
    private List<alsoKnownAs> alsoKnownAsList;
    private String placeOfOrigin;
    private String description;
    private String image;
    private List<ingredients> ingredientsList;

    public Sandwich(List<alsoKnownAs> alsoKnownAsList, String placeOfOrigin, String description, String image, List<ingredients> ingredientsList) {

        this.alsoKnownAsList = alsoKnownAsList;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredientsList = ingredientsList;
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public List<alsoKnownAs> getAlsoKnownAsList() {
        return alsoKnownAsList;
    }

    public void setAlsoKnownAsList(List<alsoKnownAs> alsoKnownAsList) {
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

    public List<ingredients> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<ingredients> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public static final class alsoKnownAs {
        private String alsoKnownAs;

        public String getAlsoKnownAs() {
            return alsoKnownAs;
        }

        public void setAlsoKnownAs(String alsoKnownAs) {
            this.alsoKnownAs = alsoKnownAs;
        }
    }
    public static final class ingredients {
        private String ingredients;

        public String getIngredients() {
            return ingredients;
        }

        public void setIngredients(String ingredients) {
            this.ingredients = ingredients;
        }
    }




    }

