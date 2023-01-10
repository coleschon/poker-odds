import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.removeCard(new Card(Rank.ACE,Suit.HEARTS));
        deck.removeCard(new Card(Rank.KING,Suit.CLUBS));

        Card Aceh = new Card(Rank.ACE, Suit.HEARTS);
        Card Acec = new Card(Rank.ACE, Suit.CLUBS);
        Card Kingh = new Card(Rank.KING, Suit.HEARTS);
        Card Kingc = new Card(Rank.KING, Suit.CLUBS);
        Card Kingd = new Card(Rank.KING, Suit.DIAMONDS);
        Card Kings = new Card(Rank.KING, Suit.SPADES);
        Card Queenh = new Card(Rank.QUEEN, Suit.HEARTS);
        Card Queend = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card Jackh = new Card(Rank.JACK, Suit.HEARTS);
        Card Tend = new Card(Rank.TEN, Suit.HEARTS);
        Card Tenh = new Card(Rank.TEN, Suit.HEARTS);
        Card Tens = new Card(Rank.TEN, Suit.SPADES);
        Card Nines = new Card(Rank.NINE, Suit.SPADES);
        Card Nineh = new Card(Rank.NINE, Suit.HEARTS);
        Card Tenc = new Card(Rank.TEN, Suit.CLUBS);
        Card Twod = new Card(Rank.TWO, Suit.DIAMONDS);
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(Aceh);
        hand.add(Queenh);
        hand.add(Kingh);
        hand.add(Jackh);
        hand.add(Tenh);
        ArrayList<Card> pair = new ArrayList<>();
        pair.add(Aceh);
        pair.add(Acec);
        pair.add(Kingh);
        pair.add(Jackh);
        pair.add(Tenh);
        ArrayList<Card> twoPair = new ArrayList<>();
        twoPair.add(Aceh);
        twoPair.add(Acec);
        twoPair.add(Tenc);
//        twoPair.add(Kingd);
        twoPair.add(Kingc);
        twoPair.add(Tenh);
        ArrayList<Card> threeOfAKind = new ArrayList<>();
        threeOfAKind.add(Aceh);
        threeOfAKind.add(Kingd);
//        threeOfAKind.add(Kingh);
//        threeOfAKind.add(Kingc);
        threeOfAKind.add(Tenh);
        threeOfAKind.add(Tens);
        threeOfAKind.add(Tend);
        ArrayList<Card> straight = new ArrayList<>();
        straight.add(Kingh);
        straight.add(Queend);
        straight.add(Jackh);
        straight.add(Tens);
        straight.add(Nines);
        ArrayList<Card> straightFlush = new ArrayList<>();
        straightFlush.add(Kingh);
        straightFlush.add(Queenh);
        straightFlush.add(Jackh);
        straightFlush.add(Tenh);
        straightFlush.add(Nineh);
        ArrayList<Card> flush = new ArrayList<>();
        flush.add(Kingh);
        flush.add(Nineh);
        flush.add(Aceh);
        flush.add(Queenh);
        flush.add(Jackh);
        ArrayList<Card> fullHouse = new ArrayList<>();
        fullHouse.add(Tenh);
        fullHouse.add(Tenc);
        fullHouse.add(Kingd);
//        fullHouse.add(Tens);
        fullHouse.add(Kingh);
        fullHouse.add(Kings);
        ArrayList<Card> fourOfAKind = new ArrayList<>();
        fourOfAKind.add(Tens);
        fourOfAKind.add(Acec);
        fourOfAKind.add(Tenh);
        fourOfAKind.add(Tend);
        fourOfAKind.add(Tenc);
        ArrayList<Card> royalFlush = new ArrayList<>();
        royalFlush.add(Kingh);
        royalFlush.add(Queenh);
        royalFlush.add(Jackh);
        royalFlush.add(Tenh);
        royalFlush.add(Aceh);

        Player p1 = new Player(hand);
        Player p2 = new Player(pair);
        Player p3 = new Player(twoPair);
        Player p4 = new Player(royalFlush);
        p4.evaluateHand();
        System.out.println(p4.getHand() + " (" + p4.getHand().getKickerString() + ")");
        printCards(p4.getCards());
//        System.out.println(deck);
    }

    private static void printCards(List<Card> cards) {
        final String ANSI_WHITE_HI_BACKGROUND = "\033[0;107m"; // high intensity
        final String ANSI_RESET = "\u001B[0m";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            sb.append(ANSI_WHITE_HI_BACKGROUND + card.getSuit().getColor() + card + ANSI_RESET);
            if (i != cards.size()-1) sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}