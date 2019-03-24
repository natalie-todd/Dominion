import java.util.List;
import java.util.Objects;

public class Setup {
    private final String setupId;
    private final List<String> cards;
    private final int rating;

    public Setup(String setupId, List<String> cards, int rating) {
        this.setupId = setupId;
        this.cards = cards;
        this.rating = rating;
    }

    public String getSetupId() {
        return setupId;
    }

    public List<String> getCards() {
        return cards;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Setup setup = (Setup) o;
        return rating == setup.rating &&
                Objects.equals(setupId, setup.setupId) &&
                Objects.equals(cards, setup.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(setupId, cards, rating);
    }

    @Override
    public String toString() {
        return "Setup{" +
                "setupId='" + setupId + '\'' +
                ", cards=" + cards +
                ", rating=" + rating +
                '}';
    }
}
