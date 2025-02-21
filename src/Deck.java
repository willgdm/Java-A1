import java.util.ArrayList;
import java.util.List;

public class Deck {
    public static final int MAX_CARTAS = 20;

    private String nome;
    private List<Carta> cartas;

    public Deck(String nome) {
        this.nome = nome;
        this.cartas = new ArrayList<>();
    }

    public boolean adicionarCartaNoDeck(Carta carta) {
        if (cartas.size() < MAX_CARTAS && contarCarta(carta) < 4) {
            cartas.add(carta);
            return true;
        }
        return false;
    }

    public boolean isCompleto() {
        return cartas.size() >= MAX_CARTAS;
    }

    public String getNome() {
        return nome;
    }

    private long contarCarta(Carta carta) {
        return cartas.stream().filter(c -> c.getTitulo().equals(carta.getTitulo())).count();
    }

    public int getQuantidadeCarta(Carta carta) {
        int count = 0;
        for (Carta c : cartas) {
            if (c.equals(carta)) {
                count++;
            }
        }
        return count;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    @Override
    public String toString() {
        return nome;
    }
}
