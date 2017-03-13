package com.example.luan.cliente;

import android.os.AsyncTask;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * Created by Luan on 10/03/2017.
 */

abstract class Conection extends AsyncTask<String, String, String> {

    /* PORT */
    private static int PORT = 10999;
    /* HOST */
    private static String HOST = "192.168.43.171";

    Socket SocketClient;
    DataOutputStream OutputServer;
    DataInputStream InputServer;

    void Init(String TypeConection) throws Exception {
        if (TypeConection.equals("client")) {
            SocketClient = new Socket(HOST, PORT);
        }
    }

}
