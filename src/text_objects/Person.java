package text_objects;

import emotions.AbstractEmotion;
import emotions.EmotionType;
import exceptions.CarFailException;
import exceptions.PeopleAddedToLocationException;
import interfaces.Talkingable;
import locations.AbstractLocation;
import weather.WeatherType;

import java.util.Objects;

public class Person implements Talkingable {
    private int money;

    private Toy toy;
    private final String name;
    private int mentalHealth;
    private AbstractEmotion currentEmotion;
    private int hungerLevel;
    private Car car;
    private Car.Engine carEngine;
    private Car.Radio carRadio;
    private AbstractLocation location;

    public Person(String name) {
        this.name = name;
        this.hungerLevel = 0;
        this.mentalHealth = 100;
        this.money = (int) (Math.random()*5000) + 1500;
    }

    public void setToy(Toy toy) {
        this.toy = toy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setCar(Car car, Car.Engine carEngine, Car.Radio carRadio) {
        this.car = car;
        this.carRadio = carRadio;
        this.carEngine = carEngine;
    }

    public String getName() {
        return name;

    }

    public Car getCar() throws CarFailException{
        if(car == null){
            throw new CarFailException("Car doesnt exist");
        }
        return car;
    }

    public void setLocation(AbstractLocation location) {
        this.location = location;
        try {
            location.addPeople(this);
        } catch (PeopleAddedToLocationException | NullPointerException ignored){
        }
    }

    public AbstractLocation getLocation() {
        return location;
    }

    public AbstractEmotion getCurrentEmotion() {
        return currentEmotion;
    }



    public int getMentalHealth() {
        return mentalHealth;
    }

    public void setMentalHealth(int mentalHealth) {
        this.mentalHealth = mentalHealth;
    }


    public void setCurrentEmotion(EmotionType emotionType) {
        if (emotionType.getEmotion() != this.getCurrentEmotion()) {
            this.currentEmotion = emotionType.getEmotion();
            this.expressCurrentEmotion();
            this.applyEmotionToHealth();
            this.checkHealth();
        }

    }

    public void expressCurrentEmotion() {
        if (currentEmotion != null) {
            System.out.print(name + " is currently feeling:  ");
            currentEmotion.express();
            checkHealth();
        } else {
            System.out.println(name + " dont have any emotion");
        }
    }

    public void haveConversation(Person otherPerson, String topic) {
        if(otherPerson.getCurrentEmotion() != null && location.equals(otherPerson.getLocation())) {
            mentalHealth += otherPerson.getCurrentEmotion().getMentalInfluence();
            checkHealth();
            System.out.println(name + " have conversation with" + otherPerson.getName() + " about: " + topic);
        }
    }

    public void expressLoveFor(Person otherPerson) {
        if(location.equals(otherPerson.getLocation())) {
            System.out.println(name + " expresses love for " + otherPerson.getName());
            setCurrentEmotion(EmotionType.JOY);
            otherPerson.setCurrentEmotion(EmotionType.JOY);
        }
    }

    public void eat(FoodType foodType) {
        if(foodType != null){
            System.out.println(name + " eats to satisfy hunger.");
            hungerLevel = Math.max(0, hungerLevel - foodType.getSaturation() / 10 * 5);
            checkHunger();
        }
    }

    private void checkHunger() {
        if (hungerLevel <= 0) {
            System.out.println(name + " is no longer hungry.");
        } else if (hungerLevel < 30) {
            System.out.println(name + "'s hunger level is low. Consider eating!");
            setCurrentEmotion(EmotionType.SADNESS);
        }
    }

    public void driveCar(Car.CarSeat carSeat) throws CarFailException{
        if (car != null && car.isRunning()) {
            car.setCarSeat(carSeat);
            if(carEngine.startEngine()){
                System.out.println(name + " is driving the " + car.getModel());
                setCurrentEmotion(EmotionType.JOY);
            }else {
                System.out.println(car.getModel() + " isn't started. Engine is broken.");
                setCurrentEmotion(EmotionType.ANGER);
            }
        } else {
            setCurrentEmotion(EmotionType.SADNESS);
            throw new CarFailException(name + " can't drive. The car is not running or there is no car.");
        }
    }

    public void driveCar(Car.CarSeat carSeat, WeatherType weather) throws CarFailException {
        if (car != null && car.isRunning()) {
            car.setCarSeat(carSeat);
            if(carEngine.startEngine(weather)){
                System.out.println(name + " is driving the " + car.getModel() + " in " + weather.getWeather().getDescription() + " weather.");
                weather.getWeather().interact(this);
                setCurrentEmotion(EmotionType.JOY);
            } else {
                System.out.println(car.getModel() + " isn't started. Engine is too cold.");
                setCurrentEmotion(EmotionType.ANGER);
            }
        } else {
            setCurrentEmotion(EmotionType.SADNESS);
            throw new CarFailException(name + " can't drive. The car is not running or there is no car.");
        }
    }

    public void playCarMusic() throws CarFailException {
        if(car!=null){
            carRadio.playMusic();
            setCurrentEmotion(EmotionType.JOY);
        } else{
            setCurrentEmotion(EmotionType.SADNESS);
            throw new CarFailException(name + " can't play music. There is no car.");
        }

    }

    public void checkHealth() {
        System.out.println(name + "'s current mental health: " + mentalHealth);
        if (mentalHealth < 50) {
            System.out.println("Warning: Health is low. Consider taking a break.");
            setCurrentEmotion(EmotionType.SADNESS);
        }
    }

    public void applyEmotionToHealth() {
        if (currentEmotion != null) {
            System.out.println(name + " is affected by the current emotion.");
            mentalHealth += currentEmotion.getMentalInfluence();
        }
    }

    public void openBirdCage(Parrot parrot){
        System.out.println(name + "open birdcage with " + parrot.getName() + " parrot.");
        parrot.setFly(true);
        parrot.setInBirdcage(false);
    }
    public void chaseParrot(Parrot parrot) {
        double f = Math.random();
        System.out.println(name + " is trying to caught parrot.");
        if (parrot.isFly()) {
            if (f > 0.5) {
                parrot.setInBirdcage(true);
                System.out.println("Parrot" + parrot.getName() + " was caught.");
            } else {
                System.out.println("Parrot" + parrot.getName() + " is flying too good, so " + name + " cant caught.");
            }
        }

    }

    @Override
    public void say(String phrase) {
        System.out.println(name + " is saying: " + phrase);
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", mentalHealth=" + mentalHealth +
                ", currentEmotion=" + currentEmotion +
                ", hungerLevel=" + hungerLevel +
                ", car=" + car +
                ", location=" + location +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return mentalHealth == person.mentalHealth && hungerLevel == person.hungerLevel && Objects.equals(name, person.name) && Objects.equals(currentEmotion, person.currentEmotion) && Objects.equals(car, person.car) && Objects.equals(location, person.location);
    }

    @Override
    public int hashCode() {
        int total = 31;
        total = total * 31 + name.hashCode();
        total = total * 31 + mentalHealth;
        total = total * 31 + currentEmotion.hashCode();
        total = total * 31 + hungerLevel;
        total = total * 31 + car.hashCode();
        total = total * 31 + location.hashCode();
        return total;
    }

    public Toy getToy() {
        return toy;
    }
}
