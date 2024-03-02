package emotions;

import interfaces.Emotionable;

import java.util.Objects;


public abstract class AbstractEmotion implements Emotionable {
    private final String description;
    private final int mentalInfluence;
    public AbstractEmotion(String description, int mentalInfluence) {
        this.description = description;
        this.mentalInfluence = mentalInfluence;
    }

    public int getMentalInfluence() {
        return mentalInfluence;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "AbstractEmotion{" +
                "description='" + description + '\'' +
                ", mentalInfluence=" + mentalInfluence +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEmotion that = (AbstractEmotion) o;
        return mentalInfluence == that.mentalInfluence && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int total = 31;
        total = total * 31 + description.hashCode();
        total = total * 31 + mentalInfluence;
        return total;
    }
}
