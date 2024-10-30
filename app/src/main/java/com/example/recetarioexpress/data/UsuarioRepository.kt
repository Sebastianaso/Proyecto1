package com.example.recetarioexpress.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log

class UsuarioRepository(private val context: Context) {

    private val dbHelper = DatabaseHelper(context)

    // Método para registrar un nuevo usuario
    fun registrarUsuario(username: String, password: String): Boolean {
        // Verificar si el usuario ya existe antes de registrarlo
        if (obtenerUsuario(username)) {
            return false // El usuario ya existe
        }

        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("username", username)
            put("password", password)
        }
        val newRowId = db.insert("usuarios", null, values)
        return newRowId != -1L // Devuelve true si el registro fue exitoso
    }

    // Método para iniciar sesión
    fun iniciarSesion(username: String, password: String): Boolean {
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM usuarios WHERE username = ? AND password = ?", arrayOf(username, password))
        val usuarioExiste = cursor.count > 0
        cursor.close()  // Asegúrate de cerrar el cursor
        return usuarioExiste
    }

    // Verificar si un usuario ya existe
    fun obtenerUsuario(username: String): Boolean {
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM usuarios WHERE username = ?", arrayOf(username))
        val existe = cursor.count > 0
        cursor.close() // Asegúrate de cerrar el cursor
        return existe
    }
}


