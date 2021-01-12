package mx.edu.tesoem.isc.rjae.a7s212021prac9;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gvDatos;
    EditText txtnombre, txtedad, txtsexo;
    List<Datos> datos = new ArrayList<>();
    Adaptadorbase adaptadorbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvDatos = findViewById(R.id.gvDatos);
        txtnombre = findViewById(R.id.txtNombre);
        txtedad = findViewById(R.id.txtEdad);
        txtsexo = findViewById(R.id.txtSexo);

        verificar();
    }

    private void verificar(){
        Almacen conexion = new Almacen();

        if (conexion.Existe(this)){
            if (conexion.Leer(this)){
                datos = conexion.getDatos();
                adaptadorbase = new Adaptadorbase(datos, this);
                gvDatos.setAdapter(adaptadorbase);
            } else {
                Toast.makeText(this, "no se puede leer la informacion", Toast.LENGTH_SHORT).show();
            }

            }else{
            Toast.makeText(this,"No existe el archivo, favor de gravar informacion",Toast.LENGTH_SHORT).show();
        }
    } 
}