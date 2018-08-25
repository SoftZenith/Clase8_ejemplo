package mx.edu.ittepic.clase8_ejemplo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionHelper extends SQLiteOpenHelper {

    final String CREAR_TABLA_VENDEDOR = "CREATE TABLE vendedor(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, direccion TEXT)";

    public ConexionHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_VENDEDOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS vendedor");
        onCreate(db);
    }
}
