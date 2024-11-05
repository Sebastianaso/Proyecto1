package com.example.recetarioexpress.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class UsuarioRepository(private val context: Context) {

    private val dbHelper = DatabaseHelper(context)

    // Método para registrar un nuevo usuario con correo, nombre de usuario, contraseña y confirmación
    fun registrarUsuario(correo: String, username: String, password: String, confirmarPassword: String): Boolean {
        // Verificar si el usuario ya existe por el correo
        if (obtenerUsuarioPorCorreo(correo)) {
            return false // El correo ya está registrado
        }

        // Verificar si las contraseñas coinciden
        if (password != confirmarPassword) {
            return false // Las contraseñas no coinciden
        }

        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_CORREO, correo)
            put(DatabaseHelper.COLUMN_USERNAME, username)
            put(DatabaseHelper.COLUMN_PASSWORD, password)
        }
        val newRowId = db.insert(DatabaseHelper.TABLE_USUARIOS, null, values)
        return newRowId != -1L // Devuelve true si el registro fue exitoso
    }

    // Método para iniciar sesión con el correo y contraseña
    fun iniciarSesion(correo: String, password: String): String? {
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.rawQuery(
            "SELECT ${DatabaseHelper.COLUMN_USERNAME} FROM ${DatabaseHelper.TABLE_USUARIOS} WHERE ${DatabaseHelper.COLUMN_CORREO} = ? AND ${DatabaseHelper.COLUMN_PASSWORD} = ?",
            arrayOf(correo, password)
        )

        val username: String? = if (cursor.moveToFirst()) {
            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_USERNAME))
        } else {
            null // Usuario no encontrado
        }

        cursor.close()  // Asegúrate de cerrar el cursor
        return username // Devuelve el nombre de usuario si el login fue exitoso
    }

    // Verificar si un correo ya está registrado
    fun obtenerUsuarioPorCorreo(correo: String): Boolean {
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.rawQuery(
            "SELECT * FROM ${DatabaseHelper.TABLE_USUARIOS} WHERE ${DatabaseHelper.COLUMN_CORREO} = ?",
            arrayOf(correo)
        )

        val existe = cursor.count > 0
        cursor.close() // Asegúrate de cerrar el cursor
        return existe
    }
}
