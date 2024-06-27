import java.util.List;

public class Batalha {
    public static String simular(Deck deck1, Deck deck2) {
        List<Carta> cartasDeck1 = deck1.getCartas();
        List<Carta> cartasDeck2 = deck2.getCartas();

        int vidaTotalDeck1 = cartasDeck1.stream().mapToInt(Carta::getVida).sum();
        int vidaTotalDeck2 = cartasDeck2.stream().mapToInt(Carta::getVida).sum();

        int poderTotalDeck1 = cartasDeck1.stream().mapToInt(Carta::getPoder).sum();
        int poderTotalDeck2 = cartasDeck2.stream().mapToInt(Carta::getPoder).sum();

        int danoDeck1 = 0;
        int danoDeck2 = 0;

        while (vidaTotalDeck1 > 0 && vidaTotalDeck2 > 0) {
            danoDeck1 += poderTotalDeck1;
            danoDeck2 += poderTotalDeck2;

            vidaTotalDeck1 -= danoDeck2;
            vidaTotalDeck2 -= danoDeck1;
        }

        if (vidaTotalDeck1 <= 0 && vidaTotalDeck2 <= 0) {
            return "Empate!";
        } else if (vidaTotalDeck1 > 0) {
            return "Deck 1 (" + deck1 + ") vence!";
        } else {
            return "Deck 2 (" + deck2 + ") vence!";
        }
    }
}

