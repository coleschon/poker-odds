import java.util.List;
import java.util.Objects;

public enum Hand {
    ROYAL_FLUSH("Royal flush"),
    STRAIGHT_FLUSH("Straight flush"),
    FOUR_OF_A_KIND("Four of a kind"),
    FULL_HOUSE("Full house"),
    FLUSH("Flush"),
    STRAIGHT("Straight"),
    THREE_OF_A_KIND("Three of a kind"),
    TWO_PAIR("Two pair"),
    PAIR("Pair"),
    HIGH_CARD("High card");

    private final String name;
//    private List<Rank> kicker;

    private Hand(String name) {
        this.name = name;
    }

//    public List<Rank> getKicker() {
//        return kicker;
//    }
//
//    public void setKicker(List<Rank> kicker) {
//        this.kicker = kicker;
//    }
//
//    public String getKickerString(){
//        if (Objects.isNull(kicker)) return "";
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < kicker.size(); i++) {
//            sb.append(kicker.get(i));
//            if (i != kicker.size()-1) sb.append(", ");
//        }
//        return sb.toString();
//    }

    @Override
    public String toString() {
        return name;
    }
}
