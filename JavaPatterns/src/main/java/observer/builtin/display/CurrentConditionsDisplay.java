package observer.builtin.display;

import java.util.Observable;
import java.util.Observer;

import observer.builtin.WeatherData;

public class CurrentConditionsDisplay implements Observer {
  Observable observable;
  private float temperature;
  private float humidity;

  public CurrentConditionsDisplay(Observable observable) {
    this.observable = observable;
    observable.addObserver(this);
  }

  @Override
  public void update(Observable obs, Object arg) {
    if (obs instanceof WeatherData) {
      WeatherData weatherData = (WeatherData) obs;
      this.temperature = weatherData.getTemperature();
      this.humidity = weatherData.getHumidity();
      display();
    }

  }

  private void display() {
    System.out.println(
        "Current conditions: " + temperature + " C degrees and " + humidity + "% humidity");
  }

}
