package weather;

import emotions.EmotionType;
import text_objects.Person;

public class SnowyWeather extends AbstractWeather {
    public SnowyWeather() {
        super("Snowy");
    }

    @Override
    public void interact(Person person) {
        System.out.println(person.getName() + " is building a snowman!");
        person.setCurrentEmotion(EmotionType.JOY);
    }
}