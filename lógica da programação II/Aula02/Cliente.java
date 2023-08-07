public class Cliente {
    private String nome;
    private String cpf;
    private String email;

    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente cliente = (Cliente) obj;
        return cpf.equals(cliente.cpf);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf + "\nEmail: " + email;
    }
}
