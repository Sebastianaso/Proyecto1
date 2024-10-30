package com.example.recetarioexpress.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recetarioexpress.ui.theme.ListaDeRecetas
import com.example.recetarioexpress.ui.theme.DetalleDeReceta
import com.example.recetarioexpress.model.Receta
import com.example.recetarioexpress.data.RecetaRepository

@Composable
fun NavegacionRecetas() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "lista_recetas") {
        composable(route = "lista_recetas") {
            ListaDeRecetas(recetas = RecetaRepository.obtenerRecetas()) { receta ->
                navController.navigate("detalle_receta/${receta.id}")
            }
        }
        composable(route = "detalle_receta/{id}") { backStackEntry ->
            val recetaId = backStackEntry.arguments?.getString("id")
            val receta = RecetaRepository.obtenerRecetaPorId(recetaId!!)
            DetalleDeReceta(receta!!)
        }
    }
}
