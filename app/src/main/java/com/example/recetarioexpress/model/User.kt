// User.kt
package com.example.recetarioexpress.model


data class User(
    val id: String = "",
    val username: String = "",
    val email: String = "",
    val password: String = "" // Solo incluye esta si es absolutamente necesaria
) {
    // Constructor vacío requerido por Firebase
    constructor() : this("", "", "", "")
}

