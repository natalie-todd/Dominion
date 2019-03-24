import org.bson.types.ObjectId;

import java.util.List;
import java.util.Objects;

public class Setup {
    private final ObjectId setupForeignKey;
    private final List<String> cards;
    private final Integer rating;

    private Setup(SetupBuilder setupBuilder) {
        this.setupForeignKey = setupBuilder.setupForeignKey;
        this.cards = setupBuilder.cards;
        this.rating = setupBuilder.rating;
    }

    public ObjectId getSetupForeignKey() {
        return setupForeignKey;
    }

    public List<String> getCards() {
        return cards;
    }

    public Integer getRating() {
        return rating;
    }
    private static class SetupBuilder {
        private  ObjectId setupForeignKey;
        private  List<String> cards;
        private  Integer rating;

        public Setup.SetupBuilder setupForeignKey(ObjectId setupForeignKey) {
            this.setupForeignKey = setupForeignKey;
            return this;
        }
        public Setup.SetupBuilder cards(List<String> cards) {
            this.cards = cards;
            return this;
        }
        public Setup.SetupBuilder rating(Integer rating) {
            this.rating = rating;
            return this;
        }
        public Setup build() {
//            Setup setup = new Setup(this);
            return new Setup(this);
        }

        @Override
        public String toString() {
            return "SetupBuilder{" +
                    "setupForeignKey=" + setupForeignKey +
                    ", cards=" + cards +
                    ", rating=" + rating +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SetupBuilder that = (SetupBuilder) o;
            return Objects.equals(setupForeignKey, that.setupForeignKey) &&
                    Objects.equals(cards, that.cards) &&
                    Objects.equals(rating, that.rating);
        }

        @Override
        public int hashCode() {
            return Objects.hash(setupForeignKey, cards, rating);
        }
    }
}
