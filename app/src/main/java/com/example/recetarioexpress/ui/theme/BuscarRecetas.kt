package com.example.recetarioexpress.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.recetarioexpress.model.Receta
import com.example.recetarioexpress.model.RecetaItem

@Composable
fun BuscarRecetas(
    recetas: List<Receta>,
    onRecetaClick: (Receta) -> Unit
) {
    var query by remember { mutableStateOf("") }
    val recetasFiltradas by remember(query) {
        mutableStateOf(recetas.filter { it.nombre?.startsWith(query, ignoreCase = true) ?: false })
    }

    Column {
        // Barra de búsqueda
        TextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Buscar recetas") },
            modifier = Modifier.fillMaxWidth()
        )

        // Lista de recetas filtradas
        LazyColumn {
            items(recetasFiltradas) { receta ->
                RecetaItem(receta = receta, onRecetaClick = onRecetaClick)
            }
        }
    }
}
