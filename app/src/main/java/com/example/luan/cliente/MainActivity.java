package com.example.luan.cliente;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Luan on 07/03/2017.
 */
public class MainActivity extends Activity {

    private EditText Mensaje;
    protected static TextView Etiqueta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mensaje = (EditText) findViewById(R.id.TxtMensaje);
        Etiqueta = (TextView) findViewById(R.id.Etiqueta);
    }

    public void onClick(View V) {
        if (!Mensaje.getText().toString().equals("")) {
            ClientThread Client = new ClientThread(this);
            Client.execute(Mensaje.getText().toString());
            Mensaje.setText("");
        } else {
            Toast.makeText(MainActivity.this, "El mensaje no puede ir vacío", Toast.LENGTH_SHORT).show();
        }
    }
}
