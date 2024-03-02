package emotions;

public enum EmotionType {
    JOY(new JoyEmotion("Joy",10)),
    SURPRISE(new SurpriseEmotion("Surprise",5)),
    SADNESS(new SadnessEmotion("Sadness",-15)),
    ANGER(new AngerEmotion("Anger", -20)),
    FEAR(new FearEmotion("Fear",-10));
    private final AbstractEmotion emotion;

    EmotionType(AbstractEmotion emotion) {
        this.emotion = emotion;
    }

    public AbstractEmotion getEmotion() {
        return emotion;
    }
}
