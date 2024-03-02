package text_objects;

import exceptions.WrongSeatException;
import interfaces.Musicable;
import weather.WeatherType;

import java.util.Objects;

public class Car{
    private String model;
    private boolean isRunning;
    private boolean isMusicPlaying;
    private final int COST = 1000;
    private CarSeat carSeat;

    public Car(){
        this.isRunning = false;
        this.isMusicPlaying = false;
    }
    public Car(String model) {
        this();
        this.model = model;
    }


    public int getCost() {
        return COST;
    }

    public String getModel() {
        return model;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setCarSeat(CarSeat carSeat) {
        this.carSeat = carSeat;
    }

    public void start(CarSeat carSeat) throws WrongSeatException {
        if (carSeat == CarSeat.DRIVER) {
            if (!isRunning) {
                System.out.println(model + " starts running.");
                isRunning = true;
            } else {
                System.out.println(model + " is already running.");
            }
        } else {
            throw new WrongSeatException("You must seat on driver seat");
        }
    }

    public void stop() throws WrongSeatException{
        if (carSeat == CarSeat.DRIVER) {
            if (isRunning) {
                System.out.println(model + " stops running.");
                isRunning = false;
            } else {
                System.out.println(model + " is already stopped.");
            }
        } else {
            throw new WrongSeatException("You must seat on driver seat");
        }

    }

    public static class Engine {
        public boolean startEngine() {
            for (int i = 0; i < 3; i++){
                if(Math.random()>0.3){
                    return true;
                }
            }
            return false;
        }
        public boolean startEngine(WeatherType weatherType) {
            for (int i = 0; i < 3; i++){
                if(weatherType == WeatherType.SNOWY){
                   if(Math.random()>0.7){
                       return true;
                   }
                } else if (Math.random()>0.3){
                    return true;
                }
            }
            return false;
        }
    }

    public class Radio implements Musicable{
        @Override
        public void playMusic() {
            if (isRunning) {
                if (!isMusicPlaying) {
                    System.out.println(model + " is playing music.");
                    isMusicPlaying = true;
                } else {
                    System.out.println(model + " is already playing music.");
                }
            } else {
                System.out.println(model + " can't play music. The car is not running.");
            }
        }

        @Override
        public void stopMusic() {
            if (isMusicPlaying) {
                System.out.println(model + " stops playing music.");
                isMusicPlaying = false;
            } else {
                System.out.println(model + " is not playing music.");
            }
        }
    }

    public enum CarSeat {
        DRIVER,
        FRONT,
        BACK
    }


    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        int total = 31;
        total = total * 31 + model.hashCode();
        return total;
    }
}