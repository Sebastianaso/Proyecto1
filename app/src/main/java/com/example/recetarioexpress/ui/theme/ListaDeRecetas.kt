package com.example.recetarioexpress.ui.theme

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.recetarioexpress.model.Receta
import com.example.recetarioexpress.model.RecetaItem

@Composable
fun ListaDeRecetas(recetasFiltradas: List<Receta>, onRecetaClick: (Receta) -> Unit) {
    if (recetasFiltradas.isEmpty()) {
        Text("No se encontraron recetas.")
    } else {
        LazyColumn {
            items(recetasFiltradas) { receta ->
                RecetaItem(receta, onRecetaClick)
            }
        }
    }
}
