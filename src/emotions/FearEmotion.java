package emotions;

public class FearEmotion extends AbstractEmotion {
    public FearEmotion(String description, int mentalInfluence) {
        super(description,mentalInfluence);
    }

    @Override
    public void express() {
        System.out.println(getDescription());
        System.out.println("Experiencing anxiety and fear.");
    }
}