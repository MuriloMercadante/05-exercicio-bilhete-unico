package bilhete;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Util {

    private Bilhete[] bilhete = new Bilhete[2];
    private int index = 0;

    public void menu(){
        String aux = "Escolha uma opção:\n";
        aux += "1. Emitir bilhete\n";
        aux += "2. Carregar bilhete\n";
        aux += "3. Consultar saldo\n";
        aux += "4. Passar na catraca\n";
        aux += "5. Finalizar sessão\n";

        int opcao;

        while (true){
            opcao = parseInt(showInputDialog(aux));
            if(opcao == 5) {
                break;
            }
            if(opcao < 1 || opcao > 5) {
                showMessageDialog(null, "Opção inválida");
            }
            else {
                switch (opcao) {
                    case 1:
                        emitirBilhete();
                        break;
                    case 2:
                        CarregarBilhete();
                        break;
                    case 3:
                        ConsultarSaldo();
                        break;
                    case 4:
                        PassarNaCatraca();

                }
            }
        }

    }

    public void emitirBilhete(){
      if (index< bilhete.length){
          String nome = showInputDialog("Nome");
          String perfil = showInputDialog("Perfil --> comum, estudante ou professor");
          long cpf = parseLong(showInputDialog("CPF"));

          Usuario usuario = new Usuario(nome, perfil, cpf);
          bilhete[index] = new Bilhete(usuario);
          index++;
      }
      else {
          showMessageDialog(null,"Bilhete não emitido");
      }
    }

    public  void ConsultarSaldo(){
        int posicao = pesquisar();
        if (posicao == -1){
            showMessageDialog(null,"cpf não encontrado");
        }
        else {
            showMessageDialog(null,bilhete[posicao].consultarSaldo());
        }

    }
    public  void CarregarBilhete(){
     int posicao = pesquisar();
        double valor;
        if (posicao != -1){
        valor = parseDouble(showInputDialog("Quanto vc quer carregar"));

            bilhete[posicao].carregarBilhete(valor);
        }
    }
    public void  PassarNaCatraca(){
        int posicao = pesquisar();
        if (posicao != -1){
            showMessageDialog(null, bilhete[posicao].passarCatraca());
        }
    }
    public int pesquisar(){
        long cpf = parseLong(showInputDialog("CPF para pesquisa"));
        for (int i = 0; i < index; i++){
            if (bilhete[i].usuario.cpf == cpf){
                return i;
            }
        }
        return -1;

    }


}

