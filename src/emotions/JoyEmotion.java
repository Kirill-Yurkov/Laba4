package emotions;

class JoyEmotion extends AbstractEmotion {
    public JoyEmotion(String description, int mentalInfluence) {
        super(description, mentalInfluence);
    }

    @Override
    public void express() {
        System.out.println(getDescription());
        // Дополнительная логика выражения радости
    }
}
