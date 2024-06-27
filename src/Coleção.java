
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Colecao implements DadosPersistentes, Serializable {
    private List<Carta> cartas;
    private List<Deck> decks;

    public Colecao() {
        this.cartas = new ArrayList<>();
        decks = new ArrayList<>();
    }

    public boolean adicionarCartaNaColecao(Carta carta) {
        long count = cartas.stream().filter(c -> c.getTitulo().equals(carta.getTitulo())).count();
        if (count >= 4) {
            return false;
        }
        cartas.add(carta);
        return true;
    }

    public List<Carta> filtrarCartas(String criterio, String valorFiltro) {
        switch (criterio.toLowerCase()) {
            case "raridade":
                return cartas.stream()
                        .filter(carta -> carta.getRaridade().equalsIgnoreCase(valorFiltro))
                        .sorted((c1, c2) -> c1.getRaridade().compareTo(c2.getRaridade()))
                        .collect(Collectors.toList());
            case "tipo":
                return cartas.stream()
                        .filter(carta -> carta.getTipo().equalsIgnoreCase(valorFiltro))
                        .sorted((c1, c2) -> c1.getTipo().compareTo(c2.getTipo()))
                        .collect(Collectors.toList());
            case "poder":
                int poderFiltro = Integer.parseInt(valorFiltro);
                return cartas.stream()
                        .filter(carta -> carta.getPoder() == poderFiltro)
                        .sorted((c1, c2) -> Integer.compare(c1.getPoder(), c2.getPoder()))
                        .collect(Collectors.toList());
            case "vida":
                int vidaFiltro = Integer.parseInt(valorFiltro);
                return cartas.stream()
                        .filter(carta -> carta.getVida() == vidaFiltro)
                        .sorted((c1, c2) -> Integer.compare(c1.getVida(), c2.getVida()))
                        .collect(Collectors.toList());
            case "custodemana":
                int custoDeManaFiltro = Integer.parseInt(valorFiltro);
                return cartas.stream()
                        .filter(carta -> carta.getCustoDeMana() == custoDeManaFiltro)
                        .sorted((c1, c2) -> Integer.compare(c1.getCustoDeMana(), c2.getCustoDeMana()))
                        .collect(Collectors.toList());
            default:
                return new ArrayList<>();
        }
    }

    public boolean adicionarDeck(Deck deck) {
        decks.add(deck);
        return true;
    }

    public Deck buscarDeckPorNome(String nome) {
        for (Deck deck : decks) {
            if (deck.toString().trim().equalsIgnoreCase(nome.trim())) {
                return deck;
            }
        }
        return null;
    }

    public Carta buscarCartaPorTitulo(String titulo) {
        return cartas.stream().filter(c -> c.getTitulo().equalsIgnoreCase(titulo)).findFirst().orElse(null);
    }

    public List<Deck> listarDecksIncompletos() {
        return decks.stream().filter(deck -> !deck.isCompleto()).collect(Collectors.toList());
    }

    public Deck criarDeckAleatorio(String nomeDeck) {
        Deck deck = new Deck(nomeDeck);
        List<Carta> cartasDisponiveis = new ArrayList<>(cartas);

        Collections.shuffle(cartasDisponiveis);

        for (Carta carta : cartasDisponiveis) {
            int quantidadeNoDeck = deck.getQuantidadeCarta(carta);
            if (quantidadeNoDeck < 4) {
                deck.adicionarCartaNoDeck(carta);
            }
            if (deck.isCompleto()) {
                break;
            }
        }

        // Adicionar o deck à coleção
        decks.add(deck);
        return deck;
    }

    public void exibirEstatisticas() {
        long totalCartas = cartas.size();
        long comum = cartas.stream().filter(c -> c.getRaridade().equalsIgnoreCase("comum")).count();
        long incomum = cartas.stream().filter(c -> c.getRaridade().equalsIgnoreCase("incomum")).count();
        long rara = cartas.stream().filter(c -> c.getRaridade().equalsIgnoreCase("rara")).count();
        long mitica = cartas.stream().filter(c -> c.getRaridade().equalsIgnoreCase("mitica")).count();
    
        double poderMedio = cartas.stream().mapToInt(Carta::getPoder).average().orElse(0);
        double vidaMedia = cartas.stream().mapToInt(Carta::getVida).average().orElse(0);
    
        System.out.println("Total de Cartas: " + totalCartas);
        System.out.println("Comum: " + comum);
        System.out.println("Incomum: " + incomum);
        System.out.println("Rara: " + rara);
        System.out.println("Mítica: " + mitica);
        System.out.println("Poder Médio: " + poderMedio);
        System.out.println("Vida Média: " + vidaMedia);
    }
    

    @Override
    public void salvar(String fileName) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(this);
        }
    }
    
@Override
    public void carregar(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            Deck deckCarregado = (Deck) in.readObject();
            this.nome = deckCarregado.nome;
            this.cartas = deckCarregado.cartas;
        }
    }

}