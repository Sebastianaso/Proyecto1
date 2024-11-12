package com.example.recetarioexpress.data

import com.example.recetarioexpress.api.SpoonacularApi
import com.example.recetarioexpress.api.SpoonacularResponse
import com.example.recetarioexpress.model.Receta
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecetaRepository {

    private val apiKey = "bda10f1127614b6798aa58fbeabb20f6"  // Reemplaza con tu clave de Spoonacular

    private val spoonacularApi: SpoonacularApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        spoonacularApi = retrofit.create(SpoonacularApi::class.java)
    }

    fun buscarRecetas(
        numeroDeRecetas: Int,
        callback: (List<Receta>?) -> Unit,
        errorCallback: () -> Unit
    ) {
        val call = spoonacularApi.buscarRecetas("all", numeroDeRecetas, apiKey)
        call.enqueue(object : Callback<SpoonacularResponse> {
            override fun onResponse(call: Call<SpoonacularResponse>, response: Response<SpoonacularResponse>) {
                if (response.isSuccessful) {
                    callback(response.body()?.recetas)
                } else {
                    callback(null)
                }
            }

            override fun onFailure(call: Call<SpoonacularResponse>, t: Throwable) {
                callback(null)
            }
        })
    }

    fun obtenerDetallesReceta(id: Int, callback: (Receta?) -> Unit, errorCallback: () -> Unit) {
        val call = spoonacularApi.obtenerDetallesReceta(id, apiKey)
        call.enqueue(object : Callback<Receta> {
            override fun onResponse(call: Call<Receta>, response: Response<Receta>) {
                if (response.isSuccessful) {
                    callback(response.body())
                } else {
                    callback(null)
                }
            }

            override fun onFailure(call: Call<Receta>, t: Throwable) {
                errorCallback()
            }
        })
    }


}
