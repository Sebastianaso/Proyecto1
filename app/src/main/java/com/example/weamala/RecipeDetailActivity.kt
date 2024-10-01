package com.example.recetario

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class RecipeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        val recipeTitle: TextView = findViewById(R.id.recipeTitle)
        val recipeIngredients: TextView = findViewById(R.id.recipeIngredients)
        val recipeInstructions: TextView = findViewById(R.id.recipeInstructions)

        // Obtener los datos de la receta seleccionada
        val title = intent.getStringExtra("title")
        val ingredients = intent.getStringExtra("ingredients")
        val instructions = intent.getStringExtra("instructions")

        // Mostrar los datos de la receta
        recipeTitle.text = title
        recipeIngredients.text = ingredients
        recipeInstructions.text = instructions
    }
}
