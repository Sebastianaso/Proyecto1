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
                        tint = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = it.nombre ?: "Sin nombre", style = MaterialTheme.typography.h5)

            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Ingredientes:", style = MaterialTheme.typography.subtitle1)
            it.ingredientes.forEach { ingrediente ->
                Text("- ${ingrediente.nombre}: ${ingrediente.cantidad} ${ingrediente.unidad}")
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Instrucciones:", style = MaterialTheme.typography.subtitle1)
            Text(text = it.instrucciones ?: "Sin instrucciones")
        }
    } ?: Text("Receta no encontrada.")
}


