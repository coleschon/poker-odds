import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck {
    private List<Card> cards;
    private final List<Card> fullCards = new ArrayList<>(Arrays.asList(
            new Card(Rank.ACE, Suit.CLUBS),
            new Card(Rank.KING, Suit.CLUBS),
            new Card(Rank.QUEEN, Suit.CLUBS),
            new Card(Rank.JACK, Suit.CLUBS),
            new Card(Rank.TEN, Suit.CLUBS),
            new Card(Rank.NINE, Suit.CLUBS),
            new Card(Rank.EIGHT, Suit.CLUBS),
            new Card(Rank.SEVEN, Suit.CLUBS),
            new Card(Rank.SIX, Suit.CLUBS),
            new Card(Rank.FIVE, Suit.CLUBS),
            new Card(Rank.FOUR, Suit.CLUBS),
            new Card(Rank.THREE, Suit.CLUBS),
            new Card(Rank.TWO, Suit.CLUBS),
            new Card(Rank.ONE, Suit.CLUBS),
            new Card(Rank.ACE, Suit.DIAMONDS),
            new Card(Rank.KING, Suit.DIAMONDS),
            new Card(Rank.QUEEN, Suit.DIAMONDS),
            new Card(Rank.JACK, Suit.DIAMONDS),
            new Card(Rank.TEN, Suit.DIAMONDS),
            new Card(Rank.NINE, Suit.DIAMONDS),
            new Card(Rank.EIGHT, Suit.DIAMONDS),
            new Card(Rank.SEVEN, Suit.DIAMONDS),
            new Card(Rank.SIX, Suit.DIAMONDS),
            new Card(Rank.FIVE, Suit.DIAMONDS),
            new Card(Rank.FOUR, Suit.DIAMONDS),
            new Card(Rank.THREE, Suit.DIAMONDS),
            new Card(Rank.TWO, Suit.DIAMONDS),
            new Card(Rank.ONE, Suit.DIAMONDS),
            new Card(Rank.ACE, Suit.SPADES),
            new Card(Rank.KING, Suit.SPADES),
            new Card(Rank.QUEEN, Suit.SPADES),
            new Card(Rank.JACK, Suit.SPADES),
            new Card(Rank.TEN, Suit.SPADES),
            new Card(Rank.NINE, Suit.SPADES),
            new Card(Rank.EIGHT, Suit.SPADES),
            new Card(Rank.SEVEN, Suit.SPADES),
            new Card(Rank.SIX, Suit.SPADES),
            new Card(Rank.FIVE, Suit.SPADES),
            new Card(Rank.FOUR, Suit.SPADES),
            new Card(Rank.THREE, Suit.SPADES),
            new Card(Rank.TWO, Suit.SPADES),
            new Card(Rank.ONE, Suit.SPADES),
            new Card(Rank.ACE, Suit.HEARTS),
            new Card(Rank.KING, Suit.HEARTS),
            new Card(Rank.QUEEN, Suit.HEARTS),
            new Card(Rank.JACK, Suit.HEARTS),
            new Card(Rank.TEN, Suit.HEARTS),
            new Card(Rank.NINE, Suit.HEARTS),
            new Card(Rank.EIGHT, Suit.HEARTS),
            new Card(Rank.SEVEN, Suit.HEARTS),
            new Card(Rank.SIX, Suit.HEARTS),
            new Card(Rank.FIVE, Suit.HEARTS),
            new Card(Rank.FOUR, Suit.HEARTS),
            new Card(Rank.THREE, Suit.HEARTS),
            new Card(Rank.TWO, Suit.HEARTS),
            new Card(Rank.ONE, Suit.HEARTS)));

    public Deck() {
        cards = new ArrayList<>();
        for (Card card : fullCards)
            cards.add(card);
    }

    protected void removeCards(ArrayList<Card> cards) {
        for (Card card : cards)
            removeCard(card);
    }

    protected void removeCard(Card card) {
        this.cards.remove(card);
    }

    @Override
    public String toString() {
        final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
        final String ANSI_WHITE_HI_BACKGROUND = "\033[0;107m"; // high intensity
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_RESET = "\u001B[0m";

        StringBuilder sb = new StringBuilder();
        for (Suit suit: Suit.values()) {
            for (Rank rank: Rank.values()) {
                Card card = new Card(rank, suit);
                if (cards.contains(card)) sb.append(ANSI_WHITE_HI_BACKGROUND + suit.getColor());
                else sb.append(ANSI_YELLOW); // removed card
                sb.append(card + ANSI_RESET);
                if (rank != Rank.ONE) sb.append(" ");
                if (rank == Rank.ONE && suit != Suit.HEARTS) sb.append("\n"); // last suit
            }
        }

//        for (Rank rank : Rank.values()) {
//            for (Suit suit : Suit.values()) {
//                Card card = new Card(rank, suit);
//                if (rank != Rank.TEN) sb.append(" ");
//                if (suit != Suit.CLUBS) sb.append(" "); // first suit
//                if (cards.contains(card)) sb.append(ANSI_WHITE_HI_BACKGROUND + suit.getColor());
//                else sb.append(ANSI_YELLOW); // removed card
//                sb.append(card + ANSI_RESET);
//                if (suit == Suit.HEARTS && rank != Rank.ONE) sb.append("\n"); // last suit
//            }
//        }

        return sb.toString();
    }
}
