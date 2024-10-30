package com.example.recetarioexpress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.example.recetarioexpress.data.UsuarioRepository
import com.example.recetarioexpress.navigation.NavegacionRecetas
import com.example.recetarioexpress.ui.theme.PantallaLoginRegistro

class MainActivity : ComponentActivity() {
    private lateinit var usuarioRepository: UsuarioRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usuarioRepository = UsuarioRepository(this)

        setContent {
            val contexto = LocalContext.current
            val estaLogeado = remember { mutableStateOf(false) }

            MaterialTheme {
                Surface {
                    if (estaLogeado.value) {
                        NavegacionRecetas()  // Mostrar recetas una vez iniciado sesión
                    } else {
                        // Mostrar pantalla de login/registro
                        PantallaLoginRegistro(
                            usuarioRepository = usuarioRepository,
                            onLoginExitoso = { estaLogeado.value = true }
                        )
                    }
                }
            }
        }
    }
}
