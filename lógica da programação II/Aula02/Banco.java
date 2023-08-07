import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    public Conta criarConta(Cliente cliente, int numero) {
        Conta novaConta = new Conta(cliente, numero);
        contas.add(novaConta);
        return novaConta;
    }

    public Conta buscarConta(int numero) {
        for (Conta conta : contas) {
            if (conta.equals(new Conta(null, numero))) {
                return conta;
            }
        }
        return null;
    }

    public void depositar(int numeroConta, double valor) {
        Conta conta = buscarConta(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
        }
    }

    public boolean sacar(int numeroConta, double valor) {
        Conta conta = buscarConta(numeroConta);
        if (conta != null) {
            return conta.sacar(valor);
        }
        return false;
    }
}
