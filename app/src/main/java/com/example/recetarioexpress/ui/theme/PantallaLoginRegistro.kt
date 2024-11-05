package com.example.recetarioexpress.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.recetarioexpress.data.UsuarioRepository

@Composable
fun PantallaLoginRegistro(usuarioRepository: UsuarioRepository, onLoginExitoso: (String, String) -> Unit)
 {
    var correo by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var mensajeError by remember { mutableStateOf("") }
    var esRegistro by remember { mutableStateOf(false) }  // Cambiar entre registro e inicio de sesión

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            if (esRegistro) {
                TextField(
                    value = correo,
                    onValueChange = { correo = it },
                    label = { Text("Correo electrónico") },
                    modifier = Modifier.fillMaxWidth()
                )
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
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )
                TextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = { Text("Confirmar contraseña") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )

                if (mensajeError.isNotEmpty()) {
                    Text(text = mensajeError, color = androidx.compose.ui.graphics.Color.Red)
                }

                Button(onClick = {
                    if (password != confirmPassword) {
                        mensajeError = "Las contraseñas no coinciden."
                    } else if (usuarioRepository.obtenerUsuarioPorCorreo(correo)) {
                        mensajeError = "El correo ya está registrado. Intente iniciar sesión."
                    } else {
                        val registroExitoso = usuarioRepository.registrarUsuario(correo, username, password, confirmPassword)
                        if (registroExitoso) {
                            mensajeError = "Registro exitoso. Ahora puede iniciar sesión."
                            esRegistro = false
                        } else {
                            mensajeError = "Error al registrar el usuario."
                        }
                    }
                }) {
                    Text("Registrar")
                }
            } else {
                TextField(
                    value = correo,
                    onValueChange = { correo = it },
                    label = { Text("Correo electrónico") },
                    modifier = Modifier.fillMaxWidth()
                )
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Contraseña") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )

                if (mensajeError.isNotEmpty()) {
                    Text(text = mensajeError, color = androidx.compose.ui.graphics.Color.Red)
                }

                Button(onClick = {
                    val usuario = usuarioRepository.iniciarSesion(correo, password)
                    if (usuario != null) {
                        onLoginExitoso(correo, usuario) // Pasar correo y nombre de usuario al iniciar sesión
                    } else {
                        mensajeError = "Correo o contraseña incorrectos."
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
}
