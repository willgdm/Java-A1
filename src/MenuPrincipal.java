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

    private static void organizarCartas() {
        System.out.println("=== Organização de Cartas ===");

        System.out.print("Filtrar por (raridade, tipo, poder, vida, custoDeMana): ");
        String criterio = Console.lerString();

        System.out.print("Valor: ");
        String valorFiltro = Console.lerString();

        List<Carta> cartasFiltradas = colecao.filtrarCartas(criterio, valorFiltro);

        if (!cartasFiltradas.isEmpty()) {
            System.out.println("Cartas filtradas:");
            cartasFiltradas.forEach(System.out::println);
        } else {
            System.out.println("Nenhuma carta encontrada com o filtro especificado.");
        }
    }

    private static void criarContinuarDeck() {
        System.out.println("=== Criação ou Edição de Decks ===");
    
        List<Deck> decksIncompletos = colecao.listarDecksIncompletos();
        if (!decksIncompletos.isEmpty()) {
            System.out.println("Decks incompletos disponíveis:");
            for (Deck deck : decksIncompletos) {
                System.out.println("- " + deck.getNome());
            }
        } else {
            System.out.println("Nenhum deck incompleto encontrado.");
        }
    
        System.out.print("Nome do Deck: ");
        String nome = Console.lerString();
        
        Deck deck = colecao.buscarDeckPorNome(nome);
        boolean novoDeck = (deck == null);
    
        if (novoDeck) {
            deck = new Deck(nome);
            System.out.println("Deck novo criado.");
        } else {
            System.out.println("Deck encontrado. Editando deck existente.");
        }
    
        boolean continuarEdicao = true;
        while (continuarEdicao) {
            System.out.println("Adicione uma carta ao deck (digite o título ou 'sair' para finalizar): ");
            String titulo = Console.lerString();
            if (titulo.equalsIgnoreCase("sair")) {
                continuarEdicao = false;
            } else {
                Carta carta = colecao.buscarCartaPorTitulo(titulo);
                if (carta != null) {
                    System.out.print("Quantidade de cópias: ");
                    int quantidade = Console.lerInt();
                    for (int i = 0; i < quantidade; i++) {
                        if (deck.adicionarCartaNoDeck(carta)) {
                            System.out.println("Carta adicionada ao deck.");
                        } else {
                            System.out.println("Não foi possível adicionar mais cópias desta carta ao deck.");
                            break;
                        }
                    }
                } else {
                    System.out.println("Carta não encontrada.");
                }
            }
    
            if (deck.isCompleto()) {
                System.out.println("Deck completo criado ou editado com sucesso!");
                break;
            }
        }
    
        if (!deck.isCompleto()) {
            System.out.println("Deck incompleto criado ou editado. Continue a edição posteriormente.");
        }
    
        if (novoDeck) {
            colecao.adicionarDeck(deck);
        }
    }

    private static void criarDeckAleatorio() {
        System.out.println("=== Criação de Deck Aleatório ===");
        System.out.print("Nome do Deck: ");
        String nome = Console.lerString();

        Deck deck = colecao.criarDeckAleatorio(nome);

        System.out.println("Deck aleatório criado com sucesso:");

        if (deck.isCompleto()) {
            System.out.println("Deck completo:");
        } else {
            System.out.println("Deck incompleto:");
        }
        System.out.println(deck);
    }

    private static void simularBatalha() {
        System.out.println("=== Simulação de Batalha ===");
        System.out.print("Nome do Deck 1: ");
        String nomeDeck1 = Console.lerString();
        Deck deck1 = colecao.buscarDeckPorNome(nomeDeck1);

        System.out.print("Nome do Deck 2: ");
        String nomeDeck2 = Console.lerString();
        Deck deck2 = colecao.buscarDeckPorNome(nomeDeck2);

        if (deck1 != null && deck2 != null) {
            String resultado = Batalha.simular(deck1, deck2);
            System.out.println("Resultado da batalha: " + resultado);
        } else {
            System.out.println("Um ou ambos os decks não foram encontrados.");
        }
    }

    private static void exibirEstatisticas() {
        System.out.println("=== Estatísticas e Relatórios ===");
        colecao.exibirEstatisticas();
    }

}
