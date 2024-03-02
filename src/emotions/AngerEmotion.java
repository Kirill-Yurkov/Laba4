package emotions;

public class AngerEmotion extends AbstractEmotion {
    public AngerEmotion(String description, int mentalInfluence) {
        super(description,mentalInfluence);
    }

    @Override
    public void express() {
        System.out.println(getDescription());
        System.out.println("Feeling irritated and frustrated.");
    }
}