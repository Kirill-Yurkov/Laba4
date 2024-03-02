package text_objects;

public enum FoodType {
    PASTA("Pasta", 8, 40, 4),
    PIZZA("Pizza", 7, 30,7),
    SALAD("Salad", 6, 20,5),
    CHIPS("Chips"),
    SNICKERS("Snickers");

    private final int cost;
    private final String name;
    private final int preparationTime;

    private final int saturation;
    FoodType(String name){
        this.name = name;
        this.saturation = 5;
        preparationTime = 0;
        this.cost = 1;
    }
    FoodType(String name, int preparationTime, int saturation, int cost) {
        this.name = name;
        this.preparationTime = preparationTime;
        this.saturation = saturation;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public int getSaturation() {
        return saturation;
    }

    public int getPreparationTime() {
        return preparationTime;
    }
}