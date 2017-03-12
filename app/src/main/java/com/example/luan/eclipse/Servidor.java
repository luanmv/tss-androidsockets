/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Servidor extends Conexion
/* Se hereda de conexión para hacer uso de los sockets y demás */
{
	public Servidor() throws IOException {
		super("server");
	} /* Se usa el constructor para servidor de Conexion */

	public void startServer() /* Método para iniciar el servidor */
	{
		try {
			boolean flag = true;
			Scanner Read = new Scanner(System.in);
			/*
			 * Accept comienza el socket y espera una conexión desde un cliente
			 */
			while (flag) {
				SockClient = SockServer.accept();
				/*
				 * Se obtiene el flujo de salida del cliente para enviarle
				 * mensajes
				 */
				OutputClient = new DataOutputStream(SockClient.getOutputStream());
				InputClient = new DataInputStream(SockClient.getInputStream());

				String mensaje = InputClient
						.readUTF(); /*
									 * espera la peticion de entrada
									 */
				if (mensaje.equals("") || mensaje == null)
					flag = false;
				System.out.println("Cliente: " + mensaje);
				System.out.print("Mensaje para el cliente: ");
				String Respuesta = Read.nextLine();
				OutputClient.writeUTF(Respuesta);
			}

			SockServer.close();

			// System.out.println("Cliente en línea");

			/*
			 * Se inicia la comunicacion (por default el cliente espera un
			 * mensaje del cliente)
			 */

			// OutputClient.writeUTF("Petición recibida y aceptada");
			/*
			 * Se le envÃ­a un mensaje al cliente la notificacion usando su
			 * flujo de salida
			 */

			// System.out.printf("SE RECIBIO PETICION EN SERVIDOR %s\n",
			// mensaje);

			/* cs = ss.accept(); */
			// System.out.println("Fin de la conexión");

			// SockServer.close();/* Se finaliza la conexiÃ³n con el cliente */
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}