package com.example.recetarioexpress.model

import com.google.gson.annotations.SerializedName

data class Receta(
    val id: Int,
    @SerializedName("title") val nombre: String?,
    @SerializedName("summary") val descripcion: String?,
    @SerializedName("image") val imagenUrl: String?,
    @SerializedName("instructions") val instrucciones: String?,
    @SerializedName("extendedIngredients") val ingredientes: List<Ingrediente>
)

data class Ingrediente(
    @SerializedName("name") val nombre: String,
    @SerializedName("amount") val cantidad: Float,
    @SerializedName("unit") val unidad: String
)
