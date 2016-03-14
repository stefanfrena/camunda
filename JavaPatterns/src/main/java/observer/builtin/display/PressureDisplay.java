package observer.builtin.display;

import java.util.Observable;
import java.util.Observer;

import observer.builtin.WeatherData;

public class PressureDisplay implements Observer {
  Observable observable;
  private float pressure;

  public PressureDisplay(Observable observable) {
    this.observable = observable;
    observable.addObserver(this);
  }

  @Override
  public void update(Observable obs, Object arg) {
    if (obs instanceof WeatherData) {
      WeatherData weatherData = (WeatherData) obs;
      this.pressure = weatherData.getPressure();
      display();
    }

  }

  private void display() {
    System.out.println("Pressure: " + pressure + " pascal");
  }

}
