package text_objects;

public enum Disease {
    HEADACHE("Take pills"),
    ALCOHOL_INTOXICATION("Drink Рассол"),
    BROKEN_BONES("Put a cast");
    private final String treatment;
    Disease(String treatment){
        this.treatment = treatment;
    }

    public String getTreatment() {
        return treatment;
    }

}
