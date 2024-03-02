package locations;

import exceptions.PeopleAddedToLocationException;
import text_objects.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractLocation {
    private final String name;
    private final List<Person> people = new ArrayList<>();

    public AbstractLocation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void interactInside(Person person);

    public List<Person> getPeople() {
        return people;
    }
    public void removePeople(Person... people) {
        for (Person person : people) {
            this.people.remove(person);
            person.setLocation(null);
        }
    }

    public void addPeople(Person... people) throws PeopleAddedToLocationException {
        for (Person person : people) {
            if (this.people.contains(person)) {
                throw new PeopleAddedToLocationException(person + " is already in location.");
            }
            this.people.add(person);
            person.setLocation(this);
        }
    }

    public void exitLocation(Person person) {
        removePeople(person);
        person.setLocation(null);
        System.out.println(person.getName() + " exits " + getName() + ".");
    }


    @Override
    public String toString() {
        return "AbstractLocation{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractLocation that = (AbstractLocation) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int total = 31;
        total = total * 31 + name.hashCode();
        return total;
    }
}