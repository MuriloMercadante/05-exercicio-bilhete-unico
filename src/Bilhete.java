package bilhete;
import java.util.Random;

public class Bilhete {
    static final double TARIFA = 5.20;
    long numero;
    double saldo;
    Usuario usuario;

    public Bilhete(Usuario usuario){
        numero = gerarNumero();
        this.usuario = usuario;
    }

    public long gerarNumero(){
        Random random = new Random();
        return random.nextLong(1000, 10000);
    }

    // metodo para carregar o bilhete

    public void carregarBilhete(double valor){
        saldo += valor;
    }

    // metodo para consultar o saldo do bilhete

    public double consultarSaldo() {
        return saldo;
    }

    // metodo passar na catraca

    public String passarCatraca(){
        double debito = TARIFA / 2;

        if(usuario.perfil.equalsIgnoreCase("comum")) {
            debito = TARIFA;
        }

        if(saldo >= TARIFA){
            saldo -= debito;
            return "Catraca liberada";
        }
        return "Sem saldo";
    }


}
