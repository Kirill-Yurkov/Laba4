package weather;

public enum WeatherType {
    SUNNY(new SunnyWeather()),
    RAINY(new RainyWeather()),
    SNOWY(new SnowyWeather());

    private final AbstractWeather weather;

    WeatherType(AbstractWeather weather) {
        this.weather = weather;
    }

    public AbstractWeather getWeather() {
        return weather;
    }
}