package com.example.recetarioexpress.ui.theme

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.recetarioexpress.R
import com.example.recetarioexpress.model.Receta
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

@Composable
fun DetalleDeReceta(receta: Receta) {
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    Column(modifier = Modifier.padding(16.dp)) {
        Box {
            // Imagen de la receta
            Image(
                painter = rememberImagePainter(receta.imagenUrl),
                contentDescription = receta.nombre,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            // Flecha de retroceso sobre la imagen
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

        // Nombre de la receta
        Text(text = receta.nombre)

        Spacer(modifier = Modifier.height(8.dp))

        // Ingredientes
        Text(text = "Ingredientes:")
        receta.ingredientes.forEach { ingrediente ->
            Text("- $ingrediente")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Materiales
        Text(text = "Materiales:")
        receta.materiales.forEach { material ->
            Text("- $material")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sección de instrucciones con fondo de tabla de picar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .heightIn(min = 150.dp)
        ) {
            // Imagen de fondo de tabla de picar
            Image(
                painter = painterResource(id = R.drawable.tabla_picar),
                contentDescription = "Fondo de tabla de picar",
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )
            // Texto de instrucciones
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.Center)
            ) {
                Text(text = "Instrucciones:")
                Text(text = receta.instrucciones)
            }
        }
    }
}
