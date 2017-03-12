package com.example.luan.cliente;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * Created by Luan on 07/03/2017.
 */
public class ClientThread extends Conection {

    private Activity Parent;
    private String ServerMessage;
    private String ClientMessage;

    public ClientThread(Activity Parent) {
        super();
        this.Parent = Parent;
    }

    private void StartClientThread(String Mensaje) throws Exception {
        OutputServer = new DataOutputStream(SocketClient.getOutputStream());
        InputServer = new DataInputStream(SocketClient.getInputStream());
        OutputServer.writeUTF(Mensaje);
        ServerMessage = InputServer.readUTF();
        SocketClient.close();
    }

    @Override
    protected void onPreExecute() {
        EditText Message = (EditText) Parent.findViewById(R.id.TxtMensaje);
        this.ClientMessage = Message.getText().toString();
    }

    @Override
    protected String doInBackground(String... Params) {
        try {
            Init("client");
            StartClientThread(Params[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServerMessage;
    }

    @Override
    protected void onPostExecute(String Result) {
        TextView Etiqueta = (TextView) Parent.findViewById(R.id.Etiqueta);
        Etiqueta.setText("Server: " + Result);
    }
}