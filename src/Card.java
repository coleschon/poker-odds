public class Card implements Comparable<Card>{

    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.rank);
        sb.append(this.suit);
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Card) {
            if (this.compareTo((Card) obj) == 0) return true;
            else return false;
        }

        return super.equals(obj);
    }

    @Override
    public int compareTo(Card c) {
        int rankComparison = this.getRank().compareTo(c.getRank());
        int suitComparison = this.getSuit().compareTo(c.getSuit());

        if (rankComparison != 0) return rankComparison;
        else return suitComparison;
    }
}
