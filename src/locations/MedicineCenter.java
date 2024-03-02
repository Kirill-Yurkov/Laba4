package locations;

import emotions.EmotionType;
import text_objects.Person;

public class MedicineCenter extends AbstractLocation {
    public MedicineCenter(String name) {
        super(name);
    }

    @Override
    public void interactInside(Person person) {
        System.out.println(person.getName() + " is receiving medical care at " + getName() + ".");
        person.setMentalHealth(person.getMentalHealth()+10);
        person.setCurrentEmotion(EmotionType.JOY);
    }

    public void buyMedicine(Person person){
        int costMedicine = (int) (Math.random()*5)+5;
        if(person.getMoney() > costMedicine){
            person.setMentalHealth(person.getMentalHealth() + 20);
            person.setMoney(person.getMoney() - costMedicine);
            person.setCurrentEmotion(EmotionType.JOY);
            System.out.println(person.getName() + " buy the newest pills.");
        } else{
            person.setCurrentEmotion(EmotionType.SADNESS);
            System.out.println(person.getName() + " cant buy pills.");
        }
    }

}