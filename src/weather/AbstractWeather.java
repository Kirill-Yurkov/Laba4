package weather;

import text_objects.Person;

import java.util.Objects;

public abstract class AbstractWeather {
    private final String description;

    public AbstractWeather(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract void interact(Person person);


    @Override
    public String toString() {
        return "AbstractWeather{" +
                "description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractWeather that = (AbstractWeather) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int total = 31;
        total = total * 31 + description.hashCode();
        return total;
    }
}
