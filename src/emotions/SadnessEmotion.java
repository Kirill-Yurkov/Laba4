package emotions;

// Реализация для эмоции "Sadness"
class SadnessEmotion extends AbstractEmotion {
    public SadnessEmotion(String description, int mentalInfluence) {
        super(description,mentalInfluence);
    }

    @Override
    public void express() {
        System.out.println(getDescription());
        // Дополнительная логика выражения грусти
    }
}
