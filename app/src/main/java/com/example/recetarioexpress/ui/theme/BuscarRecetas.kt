package com.example.recetarioexpress.ui.theme


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.recetarioexpress.model.Receta

@Composable
fun BuscarRecetas(recetas: List<Receta>, onRecetaClick: (Receta) -> Unit) {
    var query by remember { mutableStateOf("") }
    val recetasFiltradas = recetas.filter { it.nombre?.startsWith(query, ignoreCase = true) ?: false }

    Column {
        TextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Buscar recetas") },
            modifier = Modifier.fillMaxWidth()
        )
        ListaDeRecetas(recetasFiltradas, onRecetaClick)
    }
}