package theory.designPatterns.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    private List<Observer> observers;
    private int temperature;
    private int humidity;
    private int pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public int getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setMeasurements(int temperature, int pressure) {
        this.temperature = temperature;
        this.pressure = pressure;

        notifyObserver();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer:observers)
            observer.update();
    }
}
