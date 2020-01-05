// Source: https://medium.com/@JasonCromer/android-asynctask-http-request-tutorial-6b429d833e28
package com.example.werkstuk_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class RecipeAvtivity extends AppCompatActivity{

    private AppRepository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_avtivity);

        TextView recipeName = findViewById(R.id.recipe_name);
        TextView recipeDescription = findViewById(R.id.recipe_description);

        repo = new AppRepository(getApplication());
        String recipeString = repo.getRandomRecipeAsync();

        try {
            JSONObject jsonResult = new JSONObject(recipeString);
            JSONArray mealArray = jsonResult.getJSONArray("meals");
            JSONObject meal = mealArray.getJSONObject(0);

            recipeName.setText((meal.getString("strMeal")));
            recipeDescription.setText(meal.getString("strInstructions"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
