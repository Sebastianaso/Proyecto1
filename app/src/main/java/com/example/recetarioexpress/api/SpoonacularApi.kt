package com.example.recetarioexpress.api

import com.example.recetarioexpress.model.Receta
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SpoonacularApi {
    @GET("recipes/complexSearch")
    fun buscarRecetas(
        @Query("query") query: String,
        @Query("number") numeroDeRecetas: Int,
        @Query("apiKey") apiKey: String
    ): Call<SpoonacularResponse>

    @GET("recipes/{id}/information")
    fun obtenerDetallesReceta(
        @Query("id") id: Int?,
        @Query("apiKey") apiKey: String
    ): Call<Receta>
}
