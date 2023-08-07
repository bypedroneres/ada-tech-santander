import java.util.Scanner;

public class TesteBanco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Criar Conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Exibir Dados da Conta");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            
            if (opcao == 1) {
                scanner.nextLine(); // Consumir a quebra de linha
                System.out.print("Nome do cliente: ");
                String nome = scanner.nextLine();
                System.out.print("CPF do cliente: ");
                String cpf = scanner.nextLine();
                System.out.print("Email do cliente: ");
                String email = scanner.nextLine();
                System.out.print("Número da conta: ");
                int numeroConta = scanner.nextInt();
                Cliente cliente = new Cliente(nome, cpf, email);
                banco.criarConta(cliente, numeroConta);
                System.out.println("Conta criada com sucesso!");
            } else if (opcao == 2) {
                System.out.print("Número da conta: ");
                int numeroConta = scanner.nextInt();
                System.out.print("Valor para depositar: ");
                double valor = scanner.nextDouble();
                banco.depositar(numeroConta, valor);
                System.out.println("Depósito realizado com sucesso!");
            } else if (opcao == 3) {
                System.out.print("Número da conta: ");
                int numeroConta = scanner.nextInt();
                System.out.print("Valor para sacar: ");
                double valor = scanner.nextDouble();
                boolean sacou = banco.sacar(numeroConta, valor);
                if (sacou) {
                    System.out.println("Saque realizado com sucesso!");
                } else {
                    System.out.println("Saldo insuficiente para saque.");
                }
            } else if (opcao == 4) {
                System.out.print("Número da conta: ");
                int numeroConta = scanner.nextInt();
                Conta conta = banco.buscarConta(numeroConta);
                if (conta != null) {
                    System.out.println(conta.toString());
                } else {
                    System.out.println("Conta não encontrada.");
                }
            } else if (opcao == 5) {
                System.out.println("Saindo do sistema...");
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
