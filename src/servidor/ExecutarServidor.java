package servidor;
import java.io.BufferedWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


import main.Principal;

public class ExecutarServidor extends Thread{
	public void run() {
		try{
			Principal.server = new ServerSocket(Integer.parseInt(Principal.pnPorta.getText()));
		    Principal.clientes = new ArrayList<BufferedWriter>();
	
		    while(true){
		    	Socket con = Principal.server.accept();
		    	Thread t = new Server(con);
		    	t.start();
		    }
	
		}catch (Exception e) {
	
		    e.printStackTrace();
		}
	}
}
