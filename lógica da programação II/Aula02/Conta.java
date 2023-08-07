public class Conta {
    private Cliente cliente;
    private int numero;
    private double saldo;

    public Conta(Cliente cliente, int numero) {
        this.cliente = cliente;
        this.numero = numero;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Conta conta = (Conta) obj;
        return numero == conta.numero;
    }

    @Override
    public String toString() {
        return "Cliente:\n" + cliente.toString() + "\nNúmero da Conta: " + numero + "\nSaldo: " + saldo;
    }
}

