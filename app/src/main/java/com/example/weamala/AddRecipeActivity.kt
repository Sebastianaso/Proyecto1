package com.example.recetario

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddRecipeActivity : AppCompatActivity() {

    private lateinit var recipeName: EditText
    private lateinit var recipeIngredients: EditText
    private lateinit var recipeInstructions: EditText
    private lateinit var saveRecipeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        recipeName = findViewById(R.id.recipeName)
        recipeIngredients = findViewById(R.id.recipeIngredients)
        recipeInstructions = findViewById(R.id.recipeInstructions)
        saveRecipeButton = findViewById(R.id.saveRecipeButton)

        saveRecipeButton.setOnClickListener {
            val name = recipeName.text.toString()
            val ingredients = recipeIngredients.text.toString()
            val instructions = recipeInstructions.text.toString()

            if (name.isNotEmpty() && ingredients.isNotEmpty() && instructions.isNotEmpty()) {
                // Lógica para guardar la receta (puedes agregarla a la lista de recetas o base de datos)
                Toast.makeText(this, "Receta agregada", Toast.LENGTH_SHORT).show()
                finish() // Regresar a la pantalla anterior
            } else {
                Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
