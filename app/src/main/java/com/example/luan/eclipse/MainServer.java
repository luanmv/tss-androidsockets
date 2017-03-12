package app;

import tools.sockets.Servidor;
import java.io.IOException;

//Clase principal que har� uso del servidor
public class MainServer
{
    public static void main(String[] args) throws IOException
    {        
        Servidor serv = new Servidor(); //Se crea el servidor
        
        System.out.println("Iniciando servidor\n");
        serv.startServer(); //Se inicia el servidor
    }
}
