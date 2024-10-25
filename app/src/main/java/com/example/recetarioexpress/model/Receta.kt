package com.example.recetarioexpress.model

data class Receta(
    val id: String,
    val nombre: String,
    val descripcion: String,
    val ingredientes: List<String>,
    val materiales: List<String>,
    val instrucciones: String,
    val imagenUrl: String
)