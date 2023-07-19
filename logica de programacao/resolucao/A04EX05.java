public class A04EX05 {
    public static int primeiroCaractereUnico(String input) {
        // Cria um mapa para armazenar a contagem de ocorrências de cada caractere
        java.util.HashMap<Character, Integer> charCountMap = new java.util.HashMap<>();

        // Percorre a string para contar a ocorrência de cada caractere
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Percorre novamente a string para encontrar o primeiro caractere não repetido
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (charCountMap.get(c) == 1) {
                return i;
            }
        }

        // Se nenhum caractere único foi encontrado, retorna -1
        return -1;
    }

    public static void main(String[] args) {
        String palavra1 = "amor";
        String palavra2 = "cocada";

        System.out.println(primeiroCaractereUnico(palavra1)); // Saída: 0
        System.out.println(primeiroCaractereUnico(palavra2)); // Saída: 1
    }
}
