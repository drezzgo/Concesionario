package com.example.concesionario;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class UsuarioDAO {
    private SQLiteDatabase database;
    private AdminSQLiteOpenHelper dbHelper;

    public UsuarioDAO(Context context) {
        dbHelper = new AdminSQLiteOpenHelper(context);
    }
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }
    public void close() {
        dbHelper.close();
    }
    public long insertarUsuario(String email, String password, String rol) {
        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("password", password);
        values.put("rol", rol);
        return database.insert("usuarios", null, values);
    }

    @SuppressLint("Range")
    public Usuario buscarUsuarioPorEmail(String email) {
        Cursor cursor = database.query("usuarios", null, "email = ?", new String[]{email}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            Usuario usuario = new Usuario();
            usuario.setId(cursor.getLong(cursor.getColumnIndex(AdminSQLiteOpenHelper.COLUMN_ID))); // Utiliza la constante COLUMN_ID
            usuario.setEmail(cursor.getString(cursor.getColumnIndex(AdminSQLiteOpenHelper.COLUMN_EMAIL))); // Utiliza la constante COLUMN_EMAIL
            usuario.setPassword(cursor.getString(cursor.getColumnIndex(AdminSQLiteOpenHelper.COLUMN_PASSWORD))); // Utiliza la constante COLUMN_PASSWORD
            usuario.setRol(cursor.getString(cursor.getColumnIndex(AdminSQLiteOpenHelper.COLUMN_ROL))); // Utiliza la constante COLUMN_ROL
            cursor.close();
            return usuario;
        }
        return null;
    }

    public class Usuario {
        private long id;
        private String email;
        private String password;
        private String rol;

        public Usuario() {
            this.id = id;
            this.email = email;
            this.password = password;
            this.rol = rol;
        }

        public void setId(long id) {
            this.id = id;
        }
        public long getId() { return id; }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPassword(String password) {
            this.password = password;
        }
        public String getPassword() { return password; }
        public void setRol(String rol) {
            this.rol = rol;
        }
        public String getRol() { return rol; }
    }

    public void inicializarDatosDeEjemplo() {
        insertarUsuario("drezzgo@example.com", "Mirris14", "admi");
    }
}
