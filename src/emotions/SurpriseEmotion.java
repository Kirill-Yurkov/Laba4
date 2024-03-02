package emotions;

class SurpriseEmotion extends AbstractEmotion {
    public SurpriseEmotion(String description, int mentalInfluence) {
        super(description,mentalInfluence);
    }

    @Override
    public void express() {
        System.out.println(getDescription());
        // Дополнительная логика выражения удивления
    }
}
