package main;

import config.Tempo;

public class Templo implements Runnable {
   int tempoConstrucao; // 100 horas

   Templo() {
      this.tempoConstrucao = 100;
   }

   @Override
   public void run() {
      if (Comandos.SwitchCriarTemplo == true) {
         this.criarTemplo();
      }
      if (Comandos.SwitchOrar == true) {
         this.orar();
      }
      if (Comandos.SwitchSacrificar == true) {
         this.sacrificar();
      }
   }

   public synchronized void criarTemplo() {
      Comandos.SwitchCriarTemplo = false;
      int aldeao = Comandos.comandoAldeaoConstruirTemplo + 1;
      Mostrar.mostrarAldeao(aldeao, "Construindo Templo");
      try {
         Comandos.isTemplo = true;
         Thread.sleep(Tempo.tempoDeCriacaoDoTemplo);// 10000
         Mostrar.mostrarOferendaFe(0);
         Mostrar.habilitarTemplo();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      Mostrar.mostrarAldeao(aldeao, "Pronto");
      Comandos.Aldeoes.remove(Comandos.Aldeoes.indexOf(Comandos.comandoAldeaoConstruirTemplo));

   }

   public synchronized void orar() {
      Comandos.SwitchOrar = false;
      boolean continuar = true;
      while (continuar) {
         if (Comandos.Aldeoes.contains(Comandos.comandoAldeaoOrar)) {
            int tamanho = 0;
            for (int i = 1; i <= Principal.tmAldeoes.getRowCount(); i++) {
               if (Principal.tmAldeoes.getValueAt(i - 1, 1) == "Orando") {
                  tamanho++;
               }
            }
            try {
               Mostrar.mostrarAldeao(Comandos.comandoAldeaoOrar + 1, "Orando");
               Thread.sleep(Tempo.tempoPadraoDeOrar);
               int fe = Integer.parseInt(Principal.lblOferenda.getText());
               fe = fe + (tamanho * 2);
               Mostrar.mostrarOferendaFe(fe);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         } else {
            Mostrar.mostrarAldeao(Comandos.comandoAldeaoOrar + 1, "Pronto");
            continuar = false;
         }
      }
   }

   public void sacrificar() {
      Comandos.SwitchSacrificar = false;

      int fe = Integer.parseInt(Principal.lblOferenda.getText());
      fe = fe + 100;
      Mostrar.mostrarOferendaFe(fe);

      int aldeao = Comandos.comandoAldeaoSacrificar + 1;
      Mostrar.mostrarAldeao(aldeao, "Sacrificado");

      Comandos.Aldeoes.remove(Comandos.Aldeoes.indexOf(aldeao - 1));
   }
}
