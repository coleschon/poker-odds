import java.util.*;

public class Player {
    private List<Card> cards;
    private Rank rank1, rank2, rank3, rank4, rank5;
    private Suit suit1, suit2, suit3, suit4, suit5;
    private Hand hand;


    public Player() {
        this.cards = new ArrayList<>();
    }

    public Player(ArrayList<Card> cards) {
        this.cards = cards;
        Collections.sort(cards);
        rank1 = this.cards.get(0).getRank();
        rank2 = this.cards.get(1).getRank();
        rank3 = this.cards.get(2).getRank();
        rank4 = this.cards.get(3).getRank();
        rank5 = this.cards.get(4).getRank();
        suit1 = this.cards.get(0).getSuit();
        suit2 = this.cards.get(1).getSuit();
        suit3 = this.cards.get(2).getSuit();
        suit4 = this.cards.get(3).getSuit();
        suit5 = this.cards.get(4).getSuit();
    }

    protected List<Card> getCards() {
        return cards;
    }

    protected void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    protected Hand getHand() {
        return hand;
    }

    protected void evaluateHand() {
        if (royalFlush()) this.hand = Hand.ROYAL_FLUSH;
        else if (straightFlush()) this.hand = Hand.STRAIGHT_FLUSH;
        else if (fourOfAKind()) this.hand = Hand.FOUR_OF_A_KIND;
        else if (fullHouse()) this.hand = Hand.FULL_HOUSE;
        else if (flush()) this.hand = Hand.FLUSH;
        else if (straight()) this.hand = Hand.STRAIGHT;
        else if (threeOfAKind()) this.hand = Hand.THREE_OF_A_KIND;
        else if (twoPair()) this.hand = Hand.TWO_PAIR;
        else if (pair()) this.hand = Hand.PAIR;
        else {
            hand = Hand.HIGH_CARD;
            hand.setKicker(new ArrayList<>(List.of(rank1, rank2, rank3, rank4, rank5)));
        }
    }

    protected boolean royalFlush() {
        if (rank1 == Rank.ACE && straightFlush()) {
            hand = Hand.ROYAL_FLUSH;
            return true;
        }
        return false;
    }

    protected boolean straightFlush() {
        if (flush() && straight()) {
            hand = Hand.STRAIGHT_FLUSH;
            hand.setKicker(new ArrayList<>(List.of(rank1)));
            return true;
        }
        return false;
    }

    protected boolean fourOfAKind() {
        if (rank1 == rank2 && rank2 == rank3 && rank3 == rank4 || rank2 == rank3 && rank3 == rank4 && rank4 == rank5) {
            hand = Hand.FOUR_OF_A_KIND;
            if (rank1 == rank2) hand.setKicker(new ArrayList<>(List.of(rank1, rank5)));
            else hand.setKicker(new ArrayList<>(List.of(rank2, rank1)));
            return true;
        }
        return false;
    }

    protected boolean fullHouse() {
        if (rank1 == rank2 && rank2 == rank3 && rank4 == rank5 || rank1 == rank2 && rank3 == rank4 && rank4 == rank5) {
            hand = Hand.FULL_HOUSE;
            if (rank1 == rank3) hand.setKicker(new ArrayList<>(List.of(rank1, rank4)));
            else hand.setKicker(new ArrayList<>(List.of(rank3, rank1)));
            return true;
        }
        return false;
    }

    protected boolean flush() {
        if (suit1 == suit2 && suit2 == suit3 && suit3 == suit4 && suit4 == suit5) {
            hand = Hand.FLUSH;
            hand.setKicker(new ArrayList<>(List.of(rank1, rank2, rank3, rank4, rank5)));
            return true;
        }
        return false;
    }

    protected boolean straight() {
        if (rank1.compareTo(rank2) == -1 && rank2.compareTo(rank3) == -1 && rank3.compareTo(rank4) == -1 && rank4.compareTo(rank5) == -1) {
            hand = Hand.STRAIGHT;
            hand.setKicker(new ArrayList<>(List.of(rank1)));
            return true;
        }
        return false;
    }

    protected boolean threeOfAKind() {
        if (rank1 == rank2 && rank2 == rank3 || rank2 == rank3 && rank3 == rank4 || rank3 == rank4 && rank4 == rank5) {
            hand = Hand.THREE_OF_A_KIND;
            if (rank1 == rank2 && rank2 == rank3) hand.setKicker(new ArrayList<>(List.of(rank1, rank4, rank5)));
            else if (rank2 == rank3 && rank3 == rank4) hand.setKicker(new ArrayList<>(List.of(rank2, rank1, rank5)));
            else hand.setKicker(new ArrayList<>(List.of(rank3, rank1, rank2)));
            return true;
        }
        return false;
    }

    protected boolean twoPair() {
        List<Integer> kickerPosition = new ArrayList<>(List.of(0, 1, 2, 3, 4));

        int pairCount = 0;
        for (int i = 0; i < cards.size()-1; i++) {
            if (cards.get(i).getRank() == cards.get(i+1).getRank()) {
                kickerPosition.remove(new Integer(i));
                kickerPosition.remove(new Integer(i+1));
                pairCount++;
                i++;
            }
        }

        if (pairCount == 2) {
            hand = Hand.TWO_PAIR;
            int kicker = kickerPosition.get(0);
            if (kicker == 0) hand.setKicker(new ArrayList<>(List.of(rank2, rank4, rank1)));
            else if (kicker == 2) hand.setKicker(new ArrayList<>(List.of(rank1, rank4, rank3)));
            else hand.setKicker(new ArrayList<>(List.of(rank1, rank3, rank5)));
            return true;
        }
        return false;
    }

    protected boolean pair() {
        if (rank1 == rank2 || rank2 == rank3 || rank3 == rank4 || rank4 == rank5) {
            hand = Hand.PAIR;
            if (rank1 == rank2) hand.setKicker(new ArrayList<>(List.of(rank1, rank3, rank4, rank5)));
            else if (rank2 == rank3) hand.setKicker(new ArrayList<>(List.of(rank2, rank1, rank4, rank5)));
            else if (rank3 == rank4) hand.setKicker(new ArrayList<>(List.of(rank3, rank1, rank2, rank5)));
            else hand.setKicker(new ArrayList<>(List.of(rank4, rank1, rank2, rank3)));
            return true;
        }
        return false;
    }
}
