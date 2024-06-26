import java.util.List;

public class MenuPrincipal {

    private static Colecao colecao;
    public static void main(String[] args) {
        colecao = new Colecao();
        
        

    }

    private static void cadastrarCarta() {
        System.out.println("=== Cadastro de Cartas ===");
        System.out.print("Título: ");
        String titulo = Console.lerString();
        System.out.print("Descrição: ");
        String descricao = Console.lerString();
        System.out.print("Tipo (Criatura, Feitico, Encantamento): ");
        String tipo = Console.lerString();
        System.out.print("Raridade: ");
        String raridade = Console.lerString();
        System.out.print("Coleção: ");
        String colecaoNome = Console.lerString();
        System.out.print("Poder: ");
        int poder = Console.lerInt();
        System.out.print("Vida: ");
        int vida = Console.lerInt();
        System.out.print("Custo de Mana: ");
        int custoDeMana = Console.lerInt();
        System.out.print("Quantidade de cópias: ");
        int quantidade = Console.lerInt();

        Carta carta = new Carta(titulo, descricao, tipo, raridade, colecaoNome, poder, vida, custoDeMana);
        for (int i = 0; i < quantidade; i++) {
            if (colecao.adicionarCartaNaColecao(carta)) {
                System.out.println("Carta cadastrada com sucesso!");
            } else {
                System.out.println("Não foi possível cadastrar a carta. Verifique se já existem 4 cópias dessa carta.");
                break;
            }
        }
    }
}
