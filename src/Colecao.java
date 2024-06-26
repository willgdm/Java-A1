
import java.util.ArrayList;
import java.util.List;


public class Colecao {
    private List<Carta> cartas;

    public Colecao() {
        this.cartas = new ArrayList<>();
    }

    public boolean adicionarCartaNaColecao(Carta carta) {
        long count = cartas.stream().filter(c -> c.getTitulo().equals(carta.getTitulo())).count();
        if (count >= 4) {
            return false;
        }
        cartas.add(carta);
        return true;
    }
}