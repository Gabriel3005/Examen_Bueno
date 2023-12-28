package mx.edu.isc.tesoem.agcp.examen_bueno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PrincipalActivity extends AppCompatActivity {

    EditText texto;
    Button btnservicio, btncronometro;
    private TextView txtpalabra, txtconometro;

    public static String enviatexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        texto = findViewById(R.id.texto);
        btnservicio = findViewById(R.id.btnservicio);
        txtpalabra =  findViewById(R.id.txtpalabra);
        txtconometro = findViewById(R.id.txtconometro);
        btncronometro = findViewById(R.id.btncronometro);

        btnservicio.setOnClickListener(v ->{
            enviatexto=texto.getText().toString();
            Intent servicio = new Intent(this,Servicio.class);
            startService(servicio);
        });
        Servicio.ACTUALIZA_ESCUCHA(this);

        btncronometro.setOnClickListener(v ->{
          Intent servicio = new Intent(this,Cronometro.class);
          startService(servicio);
          btncronometro.setEnabled(false);
        });
        Servicio.ACTUALIZA_ESCUCHA(this);
        Cronometro.Escucha_actividad(this);
    }


    public void actualizatexto(String cadena){
        txtpalabra.setText(cadena);
    }

    public void cactualiza(String cadena){
        txtconometro.setText(cadena);
    }
}