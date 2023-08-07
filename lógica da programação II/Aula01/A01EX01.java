import java.util.ArrayList;

class Contato {
    private String nome;
    private String numero;

    public Contato(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public void ligar() {
        System.out.println("Ligando para " + nome + " (" + numero + ")");
    }

    public void detalhar() {
        System.out.println("Detalhes do contato: ");
        System.out.println("Nome: " + nome);
        System.out.println("Número: " + numero);
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }
}

class Agenda {
    private ArrayList<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<>();
    }

    public void adicionar(Contato contato) {
        contatos.add(contato);
    }

    public void deletar(Contato contato) {
        contatos.remove(contato);
    }

    public Contato buscar(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equals(nome)) {
                return contato;
            }
        }
        return null;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }
}

public class A01EX01 {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        Contato contato1 = new Contato("João", "123456789");
        Contato contato2 = new Contato("Maria", "987654321");

        agenda.adicionar(contato1);
        agenda.adicionar(contato2);

        // Imprimir contatos
        System.out.println("Contatos na agenda:");
        for (Contato contato : agenda.getContatos()) {
            contato.detalhar();
        }

        // Buscar e imprimir um contato
        String nomeBusca = "João";
        Contato contatoEncontrado = agenda.buscar(nomeBusca);
        if (contatoEncontrado != null) {
            System.out.println("\nResultado da busca para '" + nomeBusca + "':");
            contatoEncontrado.detalhar();
        } else {
            System.out.println("\nContato com o nome '" + nomeBusca + "' não encontrado.");
        }

        // Deletar um contato
        agenda.deletar(contato1);

        // Imprimir contatos atualizados
        System.out.println("\nContatos após exclusão:");
        for (Contato contato : agenda.getContatos()) {
            contato.detalhar();
        }
    }
}
