/*
 Sorting is arbitrary. Currently sorted so black and reds line up in deck print out.
 */
public enum Suit {
    CLUBS("\u2663"),
    DIAMONDS("\u25C6"),
    SPADES("\u2660"),
    HEARTS("\u2665");

    private final String name;

    private Suit(String name) {
        this.name = name;
    }

    public String getColor() {
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_BLACK_BOLD = "\033[1;30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RED_BOLD = "\033[1;31m";

        if (this == CLUBS || this == SPADES) return ANSI_BLACK;
        else return ANSI_RED;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
