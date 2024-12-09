package com.example.recetarioexpress.data

import com.example.recetarioexpress.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await
import android.util.Log
import com.google.firebase.auth.userProfileChangeRequest

class UsuarioRepository {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val database = FirebaseDatabase.getInstance()
    private val usersRef = database.getReference("usuarios")

    // Método para registrar un nuevo usuario
    suspend fun registrarUsuario(user: User): Boolean {
        return try {
            // Crear usuario en Firebase Authentication
            val result = auth.createUserWithEmailAndPassword(user.email, user.password).await()

            // Obtener el usuario creado
            val firebaseUser = result.user ?: throw FirebaseAuthException(
                "USER_CREATION_FAILED", "El usuario no se pudo crear"
            )

            // Actualiza displayName en Firebase Authentication
            val profileUpdates = userProfileChangeRequest {
                displayName = user.username
            }
            firebaseUser.updateProfile(profileUpdates).await()

            // Guardar el usuario en Realtime Database
            val userMap = mapOf(
                "id" to user.id, // Asegurarte de que sea String
                "username" to user.username,
                "email" to user.email,
                "password" to user.password // Si también necesitas almacenar la contraseña
            )
            usersRef.child(firebaseUser.uid).setValue(userMap).await()

            Log.d("UsuarioRepository", "Usuario registrado con éxito: ${user.username}")
            true
        } catch (e: Exception) {
            Log.e("UsuarioRepository", "Error al registrar el usuario: ${e.message}")
            false
        }
    }

    // Método para iniciar sesión con correo y contraseña
    suspend fun iniciarSesion(email: String, password: String): User? {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            val firebaseUser = result.user ?: return null

            // Recuperar datos del usuario desde Realtime Database
            val userSnapshot = usersRef.child(firebaseUser.uid).get().await()
            val userMap = userSnapshot.value as? Map<String, Any> // Convertir manualmente si es necesario

            val user = userMap?.let {
                User(
                    id = it["id"]?.toString() ?: "", // Asegurarte de que sea String
                    username = it["username"]?.toString() ?: "",
                    email = it["email"]?.toString() ?: "",
                    password = it["password"]?.toString() ?: "" // Si también almacenas la contraseña
                )
            }

            Log.d("UsuarioRepository", "Inicio de sesión exitoso para el correo: $email")
            user
        } catch (e: Exception) {
            Log.e("UsuarioRepository", "Error al iniciar sesión: ${e.message}")
            null
        }
    }

    // Método para verificar si un correo ya está registrado
    suspend fun obtenerUsuarioPorCorreo(correo: String): Boolean {
        return try {
            val methods = auth.fetchSignInMethodsForEmail(correo).await()
            val existe = methods.signInMethods?.isNotEmpty() == true
            Log.d("UsuarioRepository", "El correo $correo está registrado: $existe")
            existe
        } catch (e: Exception) {
            Log.e("UsuarioRepository", "Error al verificar el correo: ${e.message}")
            false
        }
    }
}
