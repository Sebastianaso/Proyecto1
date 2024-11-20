package com.example.recetarioexpress.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recetarioexpress.model.Receta
import com.example.recetarioexpress.model.RecetaItem

@Composable
fun ListaDeRecetas(
    recetas: List<Receta>,
    onRecetaClick: (Receta) -> Unit,
    onBuscarRecetas: (String) -> Unit
) {
    var textoBusqueda by remember { mutableStateOf("") }

    Column {
        TextField(
            value = textoBusqueda,
            onValueChange = {
                textoBusqueda = it
                onBuscarRecetas(it) // Llama a la función para buscar recetas
            },
            label = { Text(text = "Buscar recetas") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        LazyColumn {
            items(recetas) { receta ->
                RecetaItem(receta = receta, onRecetaClick = onRecetaClick)
            }
        }
    }
}



