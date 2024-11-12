package com.example.recetarioexpress.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.recetarioexpress.model.Receta

@Composable
fun RecetaItem(receta: Receta, onRecetaClick: (Receta) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onRecetaClick(receta) },
        elevation = 4.dp
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = rememberImagePainter(receta.imagenUrl ?: ""), // Usa un string vacío si es nulo
                contentDescription = receta.nombre ?: "Receta sin nombre",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .padding(end = 8.dp)
            )
            Column {
                Text(
                    text = receta.nombre ?: "Sin nombre",
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = receta.descripcion ?: "Sin descripción",
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

