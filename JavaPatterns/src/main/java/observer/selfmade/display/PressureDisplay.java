package observer.selfmade.display;

import observer.selfmade.interfaces.DisplayElement;
import observer.selfmade.interfaces.Observer;
import observer.selfmade.interfaces.Subject;

public class PressureDisplay implements Observer, DisplayElement {
  private float pressure;
  private Subject weatherData;

  public PressureDisplay(Subject weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  @Override
  public void update(float temp, float humidity, float pressure) {
    this.pressure = pressure;
    display();
  }

  @Override
  public void display() {
    System.out.println("Pressure: " + pressure + " pascal");
  }

  @Override
  public void removeObservation() {
    weatherData.removeObserver(this);
  }

}
