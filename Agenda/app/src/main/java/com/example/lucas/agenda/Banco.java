package com.example.lucas.agenda;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jose .
 */
public class Banco extends SQLiteOpenHelper {

    private SQLiteDatabase db;


    public Banco(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE contato(_id INTEGER PRIMARY KEY  AUTOINCREMENT,nome TEXT, tekefone TEXT, imagem integer)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS contato";
        db.execSQL(sql);

    }

    public Cursor buscar(String sql) {
        return getWritableDatabase().rawQuery(sql, null);
    }

    public int updateContato(Contato contato) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", contato.getNome());
        values.put("telefone", contato.getTelefone());
        // updating row
        return db.update("contato", values, "_id = ?", new String[]{String.valueOf(contato.getId())});
    }

    public void deteleContato(Contato contato) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("contato", "_id = ?", new String[]{String.valueOf(contato.getId())});
        db.close();
    }
}