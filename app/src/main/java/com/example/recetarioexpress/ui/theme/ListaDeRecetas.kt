package com.example.recetarioexpress.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.recetarioexpress.model.Receta

@Composable
fun ListaDeRecetas(recetas: List<Receta>, onRecetaClick: (Receta) -> Unit) {
    var textoBusqueda by remember { mutableStateOf("") } // Variable para el campo de búsqueda

    Column {
        // Barra de búsqueda
        TextField(
            value = textoBusqueda,
            onValueChange = { textoBusqueda = it },
            label = { Text("Buscar receta") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        // Filtrar recetas según el texto ingresado en la búsqueda
        val recetasFiltradas = if (textoBusqueda.isEmpty()) {
            recetas
        } else {
            recetas.filter { it.nombre.startsWith(textoBusqueda, ignoreCase = true) }
        }

        // Mostrar la lista de recetas filtradas
        LazyColumn {
            items(recetasFiltradas) { receta ->
                RecetaItem(receta, onRecetaClick)
            }
        }
    }
}

@Composable
fun RecetaItem(receta: Receta, onRecetaClick: (Receta) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onRecetaClick(receta) },
        elevation = 4.dp
    ) {
        Row {
            Image(
                painter = rememberImagePainter(receta.imagenUrl),
                contentDescription = receta.nombre,
                modifier = Modifier.size(80.dp)
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = receta.nombre)
                Text(text = receta.descripcion, maxLines = 2)
            }
        }
    }
}
