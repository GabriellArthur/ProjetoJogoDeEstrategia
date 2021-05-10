package servidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.ArrayList;

import main.Comandos;
import main.Principal;

public class Cliente extends Thread {
   private Socket socket;
   private OutputStream ou;
   private Writer ouw;
   private BufferedWriter bfw;
   private String txtIP;
   private String txtPorta;
   private String txtNome;
   private String txtCivilizacao;

   public Cliente(String txtIP, String txtPorta, String txtNome, String civilizacao) throws IOException {
      this.txtIP = txtIP;
      this.txtPorta = txtPorta;
      this.txtNome = txtNome;
      this.txtCivilizacao = civilizacao;
   }

   public void conectar() throws IOException {
      socket = new Socket(txtIP, Integer.parseInt(txtPorta));
      ou = socket.getOutputStream();
      ouw = new OutputStreamWriter(ou);
      bfw = new BufferedWriter(ouw);
      bfw.write(txtNome + "[" + txtCivilizacao + "]\r\n");
      bfw.flush();
   }

   public void enviarMensagem(String msg) throws IOException {
      if (msg.equals("/Sair")) {
         bfw.write("Desconectado \r\n");
         Principal.texto.append("Desconectado\n");
      } else {
         bfw.write(msg + "\r\n");
         Principal.texto.append("EU ->" + msg + "\r\n");
         Principal.textoVila.append("EU ->" + msg + "\r\n");
      }
      bfw.flush();
      Principal.txtMsg.setText("");

   }

   public void run() {// Enviar Mensagem
      try {
         InputStream in = socket.getInputStream();
         InputStreamReader inr = new InputStreamReader(in);
         BufferedReader bfr = new BufferedReader(inr);
         String msg = "";

         while (!"Sair".equalsIgnoreCase(msg))

            if (bfr.ready()) {
               msg = bfr.readLine();
               if (msg.equals("Sair")) {
                  Principal.texto.append("Servidor caiu! \r\n");
               } else if (msg.endsWith("/Jogar")) {
                  Comandos.comandoIniciarVila();
               } else if (msg.indexOf("/AddJogador") > 0) {// Add jogador na lista de attack
                  if (!msg.substring(msg.indexOf("/AddJogador") + "/AddJogador ".length(), msg.length()).equals(Principal.pnNomeUsuario.getText())) {// N�o add o mesmo jogador a sua propria lista
                     Principal.cbTemploInimigo.addItem(msg.substring(msg.indexOf("/AddJogador") + "/AddJogador ".length(), msg.length()));
                  }
               } else if (msg.indexOf("/attack") > 0) {
                  ArrayList<Integer> ponteiros = new ArrayList<Integer>();
                  for (int i = 0; i < msg.length(); i++) {
                     char temp = msg.charAt(i);
                     if (temp == ' ') {
                        ponteiros.add(i + 1);
                     }
                  }
                  if (Principal.pnNomeUsuario.getText().equals(msg.substring(ponteiros.get(2), ponteiros.get(3) - 1))) {
                     String attack = msg.substring(ponteiros.get(3), msg.length() - 2);
                     int nivel = Integer.parseInt(msg.substring(msg.length() - 1, msg.length()));
                     Comandos.comandoReceberAttack(attack, nivel);
                  }
               } else if (msg.indexOf("Ganhouuuuuuuuuuuu") > 0) {
                  Comandos.comandoEncerrarVila();
               } else {
                  Principal.texto.append(msg + "\r\n");
                  Principal.textoVila.append(msg + "\r\n");
               }
            }
      } catch (IOException e) {
         e.printStackTrace();
      }

   }

   public void sair() throws IOException {

      enviarMensagem("Saiu...");
      bfw.close();
      ouw.close();
      ou.close();
      socket.close();
   }

}
