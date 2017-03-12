/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion
{
    private final int PORT = 10999; /* puerto para la conexión del 10 mil en adelante... */
    protected String ServerMessage; /* Mensajes entrantes (recibidos) en el servidor */
    protected ServerSocket SockServer; /* Socket del servidor */
    protected Socket SockClient; /* Socket del cliente */
    protected DataOutputStream OutputServer, OutputClient; /* Flujo de datos de salida */
    protected DataInputStream InputServer, InputClient; /* Flujo de datos de entrada */
            
    public Conexion(String tipo) throws IOException /* Constructor */
    {
        if(tipo.equalsIgnoreCase("server"))
        {
            SockServer = new ServerSocket(PORT); /* Se crea el socket para el servidor en puerto 1234 */
        }
    }
}

