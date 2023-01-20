import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.text.DecimalFormat;

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
//        p4.evaluateHand();
//        System.out.println(p4.getHand() + " (" + p4.getHand().getKickerString() + ")");
//        printCards(p4.getCards());
//        System.out.println(deck);
        test();
    }

    private static void test() {
        Deck deck = new Deck();
        Card As = new Card(Rank.ACE, Suit.SPADES);
        Card Ad = new Card(Rank.ACE, Suit.DIAMONDS);
        Card Ac = new Card(Rank.ACE, Suit.CLUBS);
        Card Ah = new Card(Rank.ACE, Suit.HEARTS);
        Card Kc = new Card(Rank.KING, Suit.CLUBS);
        Card Kd = new Card(Rank.KING, Suit.DIAMONDS);
        Card Jh = new Card(Rank.JACK, Suit.HEARTS);
        Card Jd = new Card(Rank.JACK, Suit.DIAMONDS);
        ArrayList<Card> p1Cards = new ArrayList<>(List.of(As, Ac));
        ArrayList<Card> p2Cards = new ArrayList<>(List.of(Kc, Kd));
        ArrayList<Card> holeCards = new ArrayList<>(p1Cards);
        holeCards.addAll(p2Cards);
        deck.removeCards(holeCards);
        List<Card> deckCards = deck.getCards();
        List<Player> p1Best = new ArrayList<>();
        List<Player> p2Best = new ArrayList<>();
        double p1Wins = 0;
        double p2Wins = 0;
        int tie = 0;

        int n = deckCards.size();
        int r = 5;
        List<Card[]> deckCombinations = combination(n, r, deckCards);
        System.out.println(deck + "\n");
        System.out.printf("generated %d combinations of %d items from %d\n", deckCombinations.size(), r, n);

        for (Card[] combination : deckCombinations) {
//            printCards2(p1Cards);
//            printCards2(List.of(combination));
//            System.out.println();
            List<Card> p1combinationList = new ArrayList<>(List.of(combination));
            List<Card> p2combinationList = new ArrayList<>(List.of(combination));
            p1combinationList.addAll(p1Cards);
            p2combinationList.addAll(p2Cards);
            Collections.sort(p1combinationList);
            Collections.sort(p2combinationList);
            List<Card[]> p1Combinations = combination(p1combinationList.size(), 5, p1combinationList);
            List<Card[]> p2Combinations = combination(p2combinationList.size(), 5, p2combinationList);
//            System.out.printf("generated %d combinations of %d items from %d\n", p1Combinations.size(), 5, combinationList.size());

            List<Player> p1Players = new ArrayList<>();
            List<Player> p2Players = new ArrayList<>();
            for (int i = 0; i < p1Combinations.size(); i++) {
                Player p1 = new Player(new ArrayList<>(List.of(p1Combinations.get(i))));
                Player p2 = new Player(new ArrayList<>(List.of(p2Combinations.get(i))));
                p1Players.add(p1);
                p2Players.add(p2);
            }

            List<Integer> p1Showdown = showdown(p1Players);
            List<Integer> p2Showdown = showdown(p2Players);
            Player bestP1 = p1Players.get(p1Showdown.get(0));
            Player bestP2 = p2Players.get(p2Showdown.get(0));
//            p1Best.add(p1Players.get(p1Showdown.get(0)));
//            p2Best.add(p2Players.get(p2Showdown.get(0)));

            List<Player> matchup = new ArrayList<>(List.of(bestP1, bestP2));
            List<Integer> matchupShowdown = showdown(matchup);
            if (matchupShowdown.size() == 2) tie++;
            else if (matchupShowdown.get(0) == 0) p1Wins++;
            else p2Wins++;
        }

        double totalWins = p1Wins+p2Wins;
        double total = totalWins+tie;
        DecimalFormat decFormat = new DecimalFormat("0.00%");
        printCards(p1Cards);
        System.out.println(decFormat.format((p1Wins / totalWins)) + "\n");
        printCards(p2Cards);
        System.out.println(decFormat.format((p2Wins / totalWins)) + "\n");
        System.out.println("p1Wins: " + (int) p1Wins + " " + decFormat.format((p1Wins / total)));
        System.out.println("p2Wins: " + (int) p2Wins + " " + decFormat.format((p2Wins / total)));
        System.out.println("ties:   " + tie + " " + decFormat.format((tie / total)));
        System.out.println("total: " + (int) total);
    }

    public static Hand bestHand(List<Card[]> combinations) {
        Player curBestPlayer = new Player(List.of(combinations.get(0)));
        for (int i = 1; i < combinations.size(); i++) {

        }

        return curBestPlayer.getHand();
    }

    public static List<Integer> showdown(List<Player> players) {
        List<Integer> bestHandPositions = new ArrayList<>(List.of(0));

        Player curBestPlayer = players.get(0);
        Hand curBestHand = curBestPlayer.getHand();
        List<Rank> curBestKicker = curBestPlayer.getKicker();
        for (int i = 1; i < players.size(); i++) {
            Player newPlayer = players.get(i);
            Hand newPlayerHand = newPlayer.getHand();
            List<Rank> newPlayerKicker = newPlayer.getKicker();
            int handComparison = curBestHand.compareTo(newPlayer.getHand());
            if (handComparison > 0) {
                bestHandPositions = new ArrayList<>(List.of(i));
                curBestPlayer = newPlayer;
                curBestHand = newPlayerHand;
                curBestKicker = newPlayerKicker;
            }
            else if (handComparison < 0) continue;
            else if (handComparison == 0) {
                for (int j = 0; j < curBestKicker.size(); j++) {
                    int kickerComparison = curBestKicker.get(j).compareTo(newPlayerKicker.get(j));
                    if (kickerComparison > 0) {
                        bestHandPositions = new ArrayList<>(List.of(i));
                        curBestPlayer = newPlayer;
                        curBestHand = newPlayerHand;
                        curBestKicker = newPlayerKicker;
                        break;
                    }
                    if (kickerComparison < 0) break;
                    if (kickerComparison == 0 && j == curBestKicker.size()-1) bestHandPositions.add(i);
                }
            }
        }

        return bestHandPositions;
    }

    public static List<Card[]> combination(int n, int r, List<Card> cards) {
        List<Card[]> combinations = new ArrayList<>();
        addData(combinations, new Card[r], 0, n-1, 0, cards);
        return combinations;
    }

    private static void addData(List<Card[]> combinations, Card data[], int start, int end, int index, List<Card> cards) {
        if (index == data.length) {
            Card[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = cards.get(start);
            addData(combinations, data, start + 1, end, index + 1, cards);
            addData(combinations, data, start + 1, end, index, cards);
        }
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

    private static void printCards2(List<Card> cards) {
        final String ANSI_WHITE_HI_BACKGROUND = "\033[0;107m"; // high intensity
        final String ANSI_RESET = "\u001B[0m";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            if (card.getRank() != Rank.TEN) sb.append(" ");
            sb.append(ANSI_WHITE_HI_BACKGROUND + card.getSuit().getColor() + card + ANSI_RESET);
            if (i != cards.size()-1) sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}