package com.example.recetarioexpress

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recetarioexpress.data.UsuarioRepository
import com.example.recetarioexpress.navigation.NavegacionRecetas
import com.example.recetarioexpress.ui.theme.PantallaLoginRegistro

class MainActivity : ComponentActivity() {
    private lateinit var usuarioRepository: UsuarioRepository

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usuarioRepository = UsuarioRepository(this)

        setContent {
            val contexto = LocalContext.current
            val estaLogeado = remember { mutableStateOf(false) }
            val usuarioActual = remember { mutableStateOf("") } // Almacena el nombre del usuario logeado

            MaterialTheme {
                Surface {
                    if (estaLogeado.value) {
                        Scaffold(
                            topBar = {
                                TopAppBar(
                                    title = { Text("RecetarioExpress") },
                                    actions = {
                                        var expanded by remember { mutableStateOf(false) }

                                        // Icono de perfil circular en la esquina superior derecha
                                        IconButton(onClick = { expanded = true }) {
                                            Image(
                                                painter = painterResource(id = R.drawable.usuario), // Cambia por tu recurso de imagen
                                                contentDescription = "Perfil",
                                                modifier = Modifier
                                                    .size(40.dp)
                                                    .clip(CircleShape),
                                                contentScale = ContentScale.Crop
                                            )
                                        }

                                        // Menú desplegable con opciones de perfil
                                        DropdownMenu(
                                            expanded = expanded,
                                            onDismissRequest = { expanded = false }
                                        ) {
                                            Text(
                                                text = "Hola, ${usuarioActual.value}",
                                                modifier = Modifier.padding(8.dp)
                                            )
                                            Divider()
                                            DropdownMenuItem(onClick = {
                                                expanded = false
                                                estaLogeado.value = false // Cerrar sesión
                                            }) {
                                                Text("Cerrar sesión")
                                            }
                                        }
                                    }
                                )
                            }
                        ) {
                            NavegacionRecetas()  // Mostrar recetas una vez iniciado sesión
                        }
                    } else {
                        // Mostrar pantalla de login/registro
                        PantallaLoginRegistro(
                            usuarioRepository = usuarioRepository,
                            onLoginExitoso = { correo, username ->
                                estaLogeado.value = true
                                usuarioActual.value = username  // Guarda el nombre de usuario
                            }
                        )
                    }
                }
            }
        }
    }
}
