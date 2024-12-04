package com.example.recetarioexpress.data

import com.example.recetarioexpress.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class UsuarioRepository(mainActivity: MainActivity) {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    // Método para registrar un nuevo usuario
    suspend fun registrarUsuario(correo: String, username: String, password: String): Boolean {


        return try {
            val result = auth.createUserWithEmailAndPassword(correo, password).await()

            // Guardar el nombre de usuario en Firestore
            val user = hashMapOf(
                "correo" to correo,
                "username" to username
            )
            firestore.collection("usuarios").document(result.user!!.uid).set(user).await()
            true // Registro exitoso
        } catch (e: Exception) {
            e.printStackTrace()
            false // Error durante el registro
        }
    }

    // Método para iniciar sesión
    suspend fun iniciarSesion(correo: String, password: String): FirebaseUser? {
        return try {
            val result = auth.signInWithEmailAndPassword(correo, password).await()
            result.user  // Devuelve el usuario si el inicio de sesión fue exitoso
        } catch (e: FirebaseAuthException) {
            null  // Devuelve null si hay un error en el inicio de sesión
        }
    }

    // Verificar si un correo ya está registrado
    suspend fun obtenerUsuarioPorCorreo(correo: String): Boolean {
        return try {
            val methods = auth.fetchSignInMethodsForEmail(correo).await()
            methods.signInMethods?.isNotEmpty() == true  // Devuelve true si el correo ya está registrado
        } catch (e: FirebaseAuthException) {
            false  // Devuelve false si hay un error
        }
    }
}
