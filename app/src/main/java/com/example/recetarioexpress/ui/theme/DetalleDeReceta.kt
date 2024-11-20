package com.example.recetarioexpress.ui.theme

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.recetarioexpress.model.Receta
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

@Composable

fun DetalleDeReceta(receta: Receta?) {
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    receta?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            // Imagen de la receta con botón de regreso
            Box {
                Image(
                    painter = rememberImagePainter(data = it.imagenUrl ?: ""),
                    contentDescription = it.nombre ?: "Sin nombre",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                IconButton(
                    onClick = { onBackPressedDispatcher?.onBackPressed() },
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.TopStart)
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Regresar",
                        tint = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Título de la receta
            Text(
                text = it.nombre ?: "Sin nombre",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Descripción de la receta
            Text(
                text = it.descripcion ?: "Sin descripción disponible.",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Ingredientes
            Text(
                text = "Ingredientes:",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            it.ingredientes.forEach { ingrediente ->
                Text(
                    text = "- ${ingrediente.nombre}: ${ingrediente.cantidad} ${ingrediente.unidad}",
                    style = MaterialTheme.typography.body2
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Instrucciones
            Text(
                text = "Instrucciones:",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = it.instrucciones ?: "No se han proporcionado instrucciones.",
                style = MaterialTheme.typography.body2
            )
        }
    } ?: Text("Receta no encontrada.")
}



