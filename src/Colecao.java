
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Colecao {
    private List<Carta> cartas;
 feature/criar-continuar-deck
    private List<Deck> decks;

    public Colecao() {
        this.cartas = new ArrayList<>();
        decks = new ArrayList<>();


    public Colecao() {
        this.cartas = new ArrayList<>();
main
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

  feature/criar-continuar-deck
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

main
}