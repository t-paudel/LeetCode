package theory.designPatterns.behavioural.observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {

    private int temperature;
    private int pressure;
    private WeatherData weatherData;

    public CurrentConditionDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        temperature = weatherData.getTemperature();
        pressure = weatherData.getPressure();

        display();
    }

    @Override
    public void display() {
        System.out.println("The updated temperature is:" + temperature);
        System.out.println("The updated pressure is:" + pressure);
    }
}
