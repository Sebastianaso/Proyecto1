package com.example.recetarioexpress.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recetarioexpress.ui.theme.ListaDeRecetas
import com.example.recetarioexpress.ui.theme.DetalleDeReceta
import com.example.recetarioexpress.model.Receta
import com.example.recetarioexpress.data.RecetaRepository

@Composable
fun NavegacionRecetas() {
    val navController = rememberNavController() // Controlador único para toda la navegación
    val repository = RecetaRepository()
    var recetasFiltradas by remember { mutableStateOf<List<Receta>?>(null) }
    var cargando by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        cargando = true
        repository.buscarRecetas(20, callback = { resultado ->
            recetasFiltradas = resultado
            cargando = false
        }, errorCallback = {
            cargando = false
            // Manejar error
        })
    }

    NavHost(navController, startDestination = "lista_recetas") {
        composable(route = "lista_recetas") {
            if (cargando) {
                Text("Cargando recetas...")
            } else {
                recetasFiltradas?.let {
                    ListaDeRecetas(it) { receta ->
                        navController.navigate("detalle_receta/${receta.id}") // Navegación al detalle
                    }
                } ?: Text("No se encontraron recetas.")
            }
        }
        composable(route = "detalle_receta/{id}") { backStackEntry ->
            val recetaId = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            var receta by remember { mutableStateOf<Receta?>(null) }
            var cargandoReceta by remember { mutableStateOf(true) }

            if (recetaId != null) {
                LaunchedEffect(recetaId) {
                    cargandoReceta = true
                    repository.obtenerDetallesReceta(recetaId, callback = {
                        receta = it
                        cargandoReceta = false
                    }, errorCallback = {
                        cargandoReceta = false
                    })
                }

                if (cargandoReceta) {
                    Column {
                        Button(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack, // Ícono de flecha
                                contentDescription = "Regresar"
                            )
                        }
                        Text("Cargando detalles de la receta...")
                    }
                } else {
                    Column {
                        Button(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack, // Ícono de flecha
                                contentDescription = "Regresar"
                            )
                        }
                        DetalleDeReceta(receta)
                    }
                }
            } else {
                Column {
                    Button(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack, // Ícono de flecha
                            contentDescription = "Regresar"
                        )
                    }
                    Text("ID de receta no válido.")
                }
            }
        }
    }
}

