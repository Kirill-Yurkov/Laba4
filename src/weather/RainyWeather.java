package weather;

import emotions.EmotionType;
import text_objects.Person;

public class RainyWeather extends AbstractWeather {
    public RainyWeather() {
        super("Rainy");
    }

    @Override
    public void interact(Person person) {
        System.out.println(person.getName() + " is staying indoors and listening to the sound of rain.");
        person.setCurrentEmotion(EmotionType.SADNESS);
    }
}