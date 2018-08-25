package mx.edu.ittepic.clase8_ejemplo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre, txtDireccion;
    Button btnRegistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.txtNombre);
        txtDireccion = findViewById(R.id.txtDireccion);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        ConexionHelper conn = new ConexionHelper(this, "bd_ventas", null, 2);

        /*
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nombre", "Bryan Gutierrez");
        values.put("direccion", "Mexico centro");

        Long idRes = db.insert("vendedor", "id", values);

        Toast.makeText(this, "id: "+idRes, Toast.LENGTH_LONG).show();

        db.close();
        */

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConexionHelper conn = new ConexionHelper(MainActivity.this, "bd_ventas", null, 2);

                SQLiteDatabase db = conn.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("nombre", txtNombre.getText().toString());
                values.put("direccion", txtDireccion.getText().toString());

                Long idRes = db.insert("vendedor", "id", values);

                Toast.makeText(MainActivity.this, "id: "+idRes, Toast.LENGTH_LONG).show();

                db.close();
            }
        });

    }//onCreate


}
