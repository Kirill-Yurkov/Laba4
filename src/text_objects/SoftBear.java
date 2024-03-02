package text_objects;

import java.util.Objects;

public class SoftBear extends Toy {
    private final String name;
    private final int cost;
    private boolean inMotion;
    private String costume;
    public SoftBear(String name, int cost){
        super(name,cost);
        this.name = name;
        this.cost = cost;
        inMotion = false;
        costume = "T-Shirt";
    }
    public SoftBear(String name, int cost, String costume){
        this(name,cost);
        inMotion = false;
        this.costume = costume;
    }
    public String getName() {
        return name;
    }


    public int getCost() {
        return cost;
    }



    @Override
    public void memorizePhrase(String phrase) {
        startDance();
        super.memorizePhrase(phrase);
        stopDance();
    }

    @Override
    public void clearMemorize() {
        startClap();
        super.clearMemorize();
        stopClap();
    }
    private void startDance(){
        if(!inMotion){
            System.out.println(name + " is starting dancing.");
            inMotion = true;
        }else {
            System.out.println(name + " is busy.");
        }
    }
    private void stopDance(){
        if(inMotion){
            System.out.println(name + " stop moving.");
            inMotion = false;
        }
    }
    public void startClap() {
        if(!inMotion){
            System.out.println(name + " is starting clapping.");
            inMotion = true;
        }else {
            System.out.println(name + " is busy.");
        }
    }
    public void stopClap(){
        if(inMotion){
            System.out.println(name + " stop moving.");
            inMotion = false;
        }
    }

    @Override
    public void play() {
        super.play();
        if (Math.random() > 0.5) {
            startDance();
        } else {
            startClap();
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SoftBear softBear = (SoftBear) o;
        return cost == softBear.cost && inMotion == softBear.inMotion && Objects.equals(name, softBear.name) && Objects.equals(costume, softBear.costume);
    }

    @Override
    public int hashCode() {
        int total = 31;
        total = total * 31 + name.hashCode();
        total = total * 31 + cost;
        total = inMotion ? total * 31 + 1 : total * 31;
        total = total * 31 + costume.hashCode();
        return total;
    }

    @Override
    public String toString() {
        return "SoftBear{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", inMotion=" + inMotion +
                ", costume='" + costume + '\'' +
                '}';
    }
}
