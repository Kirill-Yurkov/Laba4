package text_objects;

import interfaces.Memorizible;
import interfaces.Talkingable;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
public class Parrot implements Talkingable, Memorizible {
    private String kind;
    private final String name;
    private boolean inBirdcage;
    private boolean isFly;
    private final ArrayList<String> memorizedPhrases = new ArrayList<>();
    public Parrot(String name){
        this.name = name;
        this.kind = "Волнистый";
    }
    public Parrot(String name, String kind){
        this(name);
        this.kind = kind;
    }


    public String getName() {
        return name;
    }



    public void setInBirdcage(boolean inBirdcage) {
        this.inBirdcage = inBirdcage;
    }

    @Override
    public void memorizePhrase(String phrase) {
        memorizedPhrases.add(phrase);
        System.out.println("Parrot has memorized phrase.");
    }

    @Override
    public void clearMemorize() {
        System.out.println("Parrot has cleared phrases.");
        memorizedPhrases.clear();
    }

    public boolean isFly() {
        return isFly;
    }

    public void setFly(boolean fly) {
        isFly = fly;
        if(fly){
            startFly();
        }
    }

    public void startFly(){
        System.out.println(name+" is trying to fly.");
        if(!inBirdcage){
            isFly = true;
            for (int i = 0; i < (int) (Math.random() * 3) + 1; i++) {
                System.out.println("Bird is flying for " + (i + 1) + "seconds.");
            }
            say();
            inBirdcage = true;
            isFly = false;
        }
        else{
            System.out.println(name + "cant fly.");
        }
    }

    private void choicePhrase(){
        if (!memorizedPhrases.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(memorizedPhrases.size());
            say(memorizedPhrases.get(randomIndex));
        } else {
            System.out.println("Parrot doesn't have any memorized phrases.");
        }
    }
    @Override
    public void say(String phrase){
        if(!memorizedPhrases.contains(phrase)){
            memorizePhrase(phrase);
        }
        System.out.println("Parrot is saying: " + phrase);
    }


    public void say(){
        choicePhrase();
    }

    @Override
    public String toString() {
        return "Parrot{" +
                "kind='" + kind + '\'' +
                ", name='" + name + '\'' +
                ", memorizedPhrases=" + memorizedPhrases +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parrot parrot = (Parrot) o;
        return Objects.equals(kind, parrot.kind) && Objects.equals(name, parrot.name);
    }

    @Override
    public int hashCode() {
        int total = 31;
        total = total * 31 + name.hashCode();
        total = total * 31 + kind.hashCode();
        return total;
    }
}
