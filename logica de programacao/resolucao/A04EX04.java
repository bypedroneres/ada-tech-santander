public class A04EX04 {
    public static int idadeEmDias(int[] input) {
        int anos = input[0];
        int meses = input[1];
        int dias = input[2];

        // Calcula a idade em dias
        int idadeEmDias = (anos * 365) + (meses * 30) + dias;

        return idadeEmDias;
    }

    public static void main(String[] args) {
        int[] idade1 = {5, 4, 14};
        int[] idade2 = {10, 8, 16};

        System.out.println(idadeEmDias(idade1)); // Saída: 1959
        System.out.println(idadeEmDias(idade2)); // Saída: 3906
    }
}
