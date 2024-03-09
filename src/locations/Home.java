package locations;

import emotions.EmotionType;
import exceptions.PeopleAddedToLocationException;
import text_objects.FoodType;
import text_objects.Person;

public class Home extends AbstractLocation {
    public Home(String name) {
        super(name);
    }

    @Override
    public void interactInside(Person person) {
        System.out.println(person.getName() + " is relaxing at " + getName());

        person.setCurrentEmotion(EmotionType.JOY);
    }

    public void cookFood(FoodType foodType) {
        if (foodType.getPreparationTime() != 0) {

            System.out.println("Cooking delicious " + foodType.getName() + " at " + getName());
            System.out.println("Preparing ingredients...");

            for (int i = 0; i < foodType.getPreparationTime(); i++) {
                System.out.println("Chopping vegetables... Step " + (i + 1));
            }

            System.out.println("Boiling water...");

            System.out.println(foodType.getName() + " is ready to be served!");
        } else {
            System.out.println(foodType.getName() + " cant cook any delicious.");
        }
    }

    public class CinemaRoom{
        public void startCinema(Person... people) throws PeopleAddedToLocationException{
            if(!getPeople().isEmpty()){
                for(Person person: people){
                    person.setMentalHealth(person.getMentalHealth()+10);
                    person.setCurrentEmotion(EmotionType.JOY);
                }
            } else{
                throw new PeopleAddedToLocationException("No people in Location");
            }

        }

        public void startCinema() throws PeopleAddedToLocationException{
            if(!getPeople().isEmpty()){
                for(Person person: getPeople()){
                    person.setMentalHealth(person.getMentalHealth()+10);
                    person.setCurrentEmotion(EmotionType.JOY);
                }
                System.out.println("Home cinema is started");
            } else{
                throw new PeopleAddedToLocationException("No people in Location");
            }

        }
    }

}