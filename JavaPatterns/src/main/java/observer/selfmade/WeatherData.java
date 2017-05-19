package observer.selfmade;

import java.util.ArrayList;

import observer.selfmade.interfaces.Observer;
import observer.selfmade.interfaces.Subject;

public class WeatherData implements Subject {
  private ArrayList<Observer> observers;
  private float temperature;
  private float humidity;
  private float pressure;

  public WeatherData() {
    observers = new ArrayList<Observer>();
  }

  @Override
  public void registerObserver(Observer o) {
    observers.add(o);

  }

  @Override
  public void removeObserver(Observer o) {
    int i = observers.indexOf(o);
    if (i > 0) {
      observers.remove(o);
    }
  }

  @Override
  public void notifyObservers() {
    for (int i = 0; i < observers.size(); i++) {
      Observer observer = observers.get(i);
      observer.update(temperature, humidity, pressure);
    }
  }

  public void measurementChanged() {
    notifyObservers();
  }

  public void setMeasurements(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementChanged();
  }

}
