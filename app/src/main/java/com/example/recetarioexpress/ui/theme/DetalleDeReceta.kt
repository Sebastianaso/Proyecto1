package com.example.recetarioexpress.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.recetarioexpress.model.Receta

@Composable
fun DetalleDeReceta(receta: Receta) {
    Column(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = rememberImagePainter(receta.imagenUrl),
            contentDescription = receta.nombre,
            modifier = Modifier.fillMaxWidth().height(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = receta.nombre)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Ingredientes:")
        receta.ingredientes.forEach { ingrediente ->
            Text("- $ingrediente")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Materiales:")
        receta.materiales.forEach { material ->
            Text("- $material")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = receta.instrucciones)
    }
}