package com.example.recetario

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weamala.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recipeAdapter: RecipeAdapter
    private var recipeList: ArrayList<Recipe> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar la lista de recetas
        recipeList.add(Recipe("Spaghetti Bolognese", "Ingredients: ...", "Instructions: ..."))
        recipeList.add(Recipe("Tacos", "Ingredients: ...", "Instructions: ..."))

        // Configurar el RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recipeAdapter = RecipeAdapter(this, recipeList)
        recyclerView.adapter = recipeAdapter

        // Configurar el FAB para agregar recetas
        val fabAddRecipe: FloatingActionButton = findViewById(R.id.fab_add_recipe)
        fabAddRecipe.setOnClickListener {
            val intent = Intent(this@MainActivity, AddRecipeActivity::class.java)
            startActivity(intent)
        }
    }
}
