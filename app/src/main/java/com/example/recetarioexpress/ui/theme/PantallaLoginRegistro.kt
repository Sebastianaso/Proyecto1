package com.example.recetarioexpress.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.recetarioexpress.data.UsuarioRepository

@Composable
fun PantallaLoginRegistro(usuarioRepository: UsuarioRepository, onLoginExitoso: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var mensajeError by remember { mutableStateOf("") }
    var esRegistro by remember { mutableStateOf(false) }  // Cambiar entre registro e inicio de sesión

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Nombre de usuario") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(), // Oculta la contraseña
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        if (mensajeError.isNotEmpty()) {
            Text(text = mensajeError, color = androidx.compose.ui.graphics.Color.Red)
            Spacer(modifier = Modifier.height(8.dp))
        }

        // Cambiar entre Iniciar Sesión y Registrar
        if (esRegistro) {
            Button(onClick = {
                if (usuarioRepository.obtenerUsuario(username)) {
                    mensajeError = "El usuario ya existe. Intente iniciar sesión."
                } else {
                    // Registrar nuevo usuario
                    val registroExitoso = usuarioRepository.registrarUsuario(username, password)
                    if (registroExitoso) {
                        mensajeError = "Registro exitoso. Ahora puede iniciar sesión."
                        esRegistro = false  // Cambiar a pantalla de login
                    } else {
                        mensajeError = "Error al registrar el usuario."
                    }
                }
            }) {
                Text("Registrar")
            }
        } else {
            Button(onClick = {
                if (usuarioRepository.iniciarSesion(username, password)) {
                    onLoginExitoso()
                } else {
                    mensajeError = "Usuario o contraseña incorrectos."
                }
            }) {
                Text("Iniciar Sesión")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { esRegistro = !esRegistro }) {
            Text(if (esRegistro) "Ya tienes cuenta? Inicia sesión" else "No tienes cuenta? Regístrate")
        }
    }
}
