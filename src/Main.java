import emotions.EmotionType;
import exceptions.CarFailException;
import exceptions.PeopleAddedToLocationException;
import exceptions.WrongSeatException;
import interfaces.Musicable;
import locations.AbstractLocation;
import locations.Home;
import locations.MedicineCenter;
import locations.Store;
import text_objects.*;
import weather.WeatherType;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Doctor louis = new Doctor("Louis");
        Person rachel = new Person("Rachel");
        Person gage = new Person("Gage");
        Person patient1 = new Person("Diana");
        Doctor steve = new Doctor("Steve");
        Person patient2 = new Person("Liana");
        Store store = new Store("ShopForAll");
        Home home = new Home("Louis' Home");
        MedicineCenter medicineCenter = new MedicineCenter("Hospital");
        Parrot kesha = new Parrot("Kesha");
        WeatherType currentWeatherType = WeatherType.RAINY;
        SoftBear freddyBear = new SoftBear("FreddyBear", 3, "jacket");
        Car car = new Car("Toyota");
        Car.Engine carEngine = new Car.Engine();
        Car.Radio carRadio = car.new Radio();
        Home.CinemaRoom cinema = home.new CinemaRoom();


        home.addPeople(louis, rachel, gage);
        try {
            cinema.startCinema();
        } catch (PeopleAddedToLocationException e){
            System.out.println(e.getMessage());
        }

        louis.setCurrentEmotion(EmotionType.SURPRISE);
        kesha.memorizePhrase("Ариэль Шэрон свихнулся");
        kesha.say();
        rachel.openBirdCage(kesha);
        gage.chaseParrot(kesha);
        louis.haveConversation(rachel, "telling funny joke");
        louis.haveConversation(gage, "telling funny joke");
        louis.checkHealth();
        home.cookFood(FoodType.PASTA);
        louis.eat(FoodType.PASTA);
        louis.expressLoveFor(rachel);
        louis.expressLoveFor(gage);
        kesha.clearMemorize();
        home.exitLocation(louis);

        louis.setLocation(store);
        store.interactInside(louis);
        louis.setToy(store.buyToy(freddyBear));
        gage.setToy(louis.getToy());
        freddyBear.play();
        freddyBear.stopClap();
        louis.setCar(store.buyCar(car), carEngine, carRadio);
        louis.eat(store.buyFood(FoodType.CHIPS));
        store.exitLocation(louis);
        try {
            louis.getCar().setCarSeat(Car.CarSeat.BACK);
            louis.getCar().start(Car.CarSeat.DRIVER);
            louis.driveCar(Car.CarSeat.DRIVER, currentWeatherType);
        } catch (WrongSeatException | CarFailException e) {
            System.out.println(e.getMessage());
        }

        louis.setCurrentEmotion(EmotionType.FEAR);
        try {
            louis.getCar().stop();
        } catch (WrongSeatException | CarFailException e) {
            System.out.println(e.getMessage());
        }

        louis.setLocation(medicineCenter);
        medicineCenter.buyMedicine(louis);
        medicineCenter.interactInside(louis);
        medicineCenter.exitLocation(louis);

        louis.setCurrentEmotion(EmotionType.SADNESS);
        currentWeatherType = WeatherType.SUNNY;
        try {
            louis.getCar().start(Car.CarSeat.DRIVER);
            louis.driveCar(Car.CarSeat.DRIVER, currentWeatherType);
            louis.playCarMusic();
            louis.getCar().stop();
            carRadio.stopMusic();
            louis.getCar().setCarSeat(Car.CarSeat.FRONT);
            louis.getCar().start(Car.CarSeat.DRIVER);
            louis.driveCar(Car.CarSeat.DRIVER);
            louis.getCar().stop();
        } catch (WrongSeatException | CarFailException e) {
            System.out.println(e.getMessage());
        }
        louis.setLocation(medicineCenter);
        steve.setLocation(medicineCenter);

        Musicable medicineGramophone = new Musicable() {
            public final AbstractLocation location = medicineCenter;
            private boolean isPlaying = false;
            @Override
            public void playMusic() {
                for(Person person : location.getPeople()) {
                    person.setCurrentEmotion(EmotionType.JOY);
                }
                if(isPlaying){
                    System.out.println("Gramophone is already playing music");
                } else{
                    isPlaying = true;
                    System.out.println("Gramophone playing " + choiceMusic() + " in " + location.getName());
                }
            }

            @Override
            public void stopMusic() {
                isPlaying = false;
                System.out.println("Gramophone stopped playing music");
            }
            private String choiceMusic(){
                return switch ((int) (Math.random() * 5)) {
                    case 0 -> "<< Athrax |-> Among The Living >>";
                    case 1 -> "<< Black Sabbath |-> The Shining Black >>";
                    case 2 -> "<< Metallica |-> Ride The Lightning >>";
                    case 3 -> "<< Ramones |-> Pet Sematary >>";
                    case 4 -> "<< Exodus |-> Black 13 >>";
                    case 5 -> "<< Sum41 |-> War >>";
                    default -> null;
                };
            }
        };
        medicineGramophone.playMusic();
        louis.examinePatient(patient1, Disease.ALCOHOL_INTOXICATION);
        steve.examinePatient(patient2, Disease.HEADACHE);
        steve.examinePatient(patient2, Disease.BROKEN_BONES);
        louis.printMedicalRecords();
        steve.printMedicalRecords();
        medicineGramophone.stopMusic();
        System.out.println("All doctors records: \n" + Doctor.MedicalRegister.stringAllMedicalRecordsOfCenter());

    }
}