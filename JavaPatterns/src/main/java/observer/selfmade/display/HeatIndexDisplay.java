package observer.selfmade.display;

import observer.selfmade.interfaces.DisplayElement;
import observer.selfmade.interfaces.Observer;
import observer.selfmade.interfaces.Subject;

public class HeatIndexDisplay implements Observer, DisplayElement {
  private float temperature;
  private Subject weatherData;

  public HeatIndexDisplay(Subject weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  @Override
  public void update(float temp, float humidity, float pressure) {
    this.temperature = temp;
    display();
  }

  @Override
  public void display() {
    System.out.println("Heat index is: " + temperature + "08809");
  }

  @Override
  public void removeObservation() {
    weatherData.removeObserver(this);
  }
}
