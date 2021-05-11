package servidor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Inet4Address;
import java.net.Socket;

import main.Mostrar;
import main.Principal;

public class Server extends Thread {
	private String nome;
	private Socket con;
	private InputStream in;
	private InputStreamReader inr;
	private BufferedReader bfr;
	
	Server(Socket con){
	   this.con = con;
	   try {
         in  = con.getInputStream();
         inr = new InputStreamReader(in);
         bfr = new BufferedReader(inr);
	   } catch (IOException e) {
          e.printStackTrace();
	   }
	}
	
	
	public void run(){
	  try{
	    String msg;
	    OutputStream ou =  this.con.getOutputStream();
	    Writer ouw = new OutputStreamWriter(ou);
	    BufferedWriter bfw = new BufferedWriter(ouw);
	    Principal.clientes.add(bfw);
	    nome = msg = bfr.readLine();
		if(Principal.tmJogos.getValueAt(0,0).equals(Principal.pnNomeUsuario.getText())) { //Add um novo usuario a lista
			if(!Principal.tmJogos.getValueAt(Principal.tmJogos.getRowCount()-1,0).equals(msg.substring(0,msg.indexOf("[")))) {
				Mostrar.adicionarSave(msg.substring(0,msg.indexOf("[")), msg.substring(msg.indexOf("[")+1, msg.indexOf("]")), Inet4Address.getLocalHost().getHostAddress()+":"+Principal.pnPorta.getText(), "Online");
				Principal.texto.append(msg.substring(0,msg.indexOf("["))+" se conectou...\n");
				Principal.cbTemploInimigo.addItem(msg.substring(0,msg.indexOf("[")));
			}
		}
		while(msg != null){
	       msg = bfr.readLine();
	       sendToAll(bfw, msg);
	    }
	   }catch (Exception e) {
	     e.printStackTrace();
	   }
	}
	private void sendToAll(BufferedWriter bwSaida, String msg) throws  IOException{
		  BufferedWriter bwS;

		  for(BufferedWriter bw : Principal.clientes){
		   bwS = (BufferedWriter)bw;
		   if(!(bwSaida == bwS)){
			 bw.write(nome+"-> " + msg+"\r\n");
		     bw.flush();
		   }
		  }
		
	}
}
