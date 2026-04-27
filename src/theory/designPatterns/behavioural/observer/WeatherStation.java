package theory.designPatterns.behavioural.observer;

public class WeatherStation {

    static void main() {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(25, 50);
    }
}
