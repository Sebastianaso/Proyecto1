package com.example.recetarioexpress.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.recetarioexpress.model.Receta

@Composable
fun ListaDeRecetas(recetas: List<Receta>, onRecetaClick: (Receta) -> Unit) {
    LazyColumn {
        items(recetas) { receta ->
            RecetaItem(receta, onRecetaClick)
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