package com.example.recetarioexpress.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "recetario.db"
        private const val DATABASE_VERSION = 2 // Cambia la versión de la base de datos para que se ejecute onUpgrade
        const val TABLE_USUARIOS = "usuarios"
        const val COLUMN_USER_ID = "id"
        const val COLUMN_CORREO = "correo"
        const val COLUMN_USERNAME = "username"
        const val COLUMN_PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableUsuarios = ("CREATE TABLE " + TABLE_USUARIOS + " ("
                + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_CORREO + " TEXT UNIQUE, "
                + COLUMN_USERNAME + " TEXT, "
                + COLUMN_PASSWORD + " TEXT" + ")")
        db?.execSQL(createTableUsuarios)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion < 2) {
            db?.execSQL("DROP TABLE IF EXISTS $TABLE_USUARIOS")
            onCreate(db)
        }
    }
}


