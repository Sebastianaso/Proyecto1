package com.example.recetarioexpress.api

import com.example.recetarioexpress.model.Receta
import com.google.gson.annotations.SerializedName

data class SpoonacularResponse(
    @SerializedName("results") val recetas: List<Receta>,
    @SerializedName("totalResults") val totalResultados: Int
)
