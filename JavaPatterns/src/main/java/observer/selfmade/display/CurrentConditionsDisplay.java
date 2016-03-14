package observer.selfmade.display;

import observer.selfmade.interfaces.DisplayElement;
import observer.selfmade.interfaces.Observer;
import observer.selfmade.interfaces.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
  private float temperature;
  private float humidity;
  private Subject weatherData;

  public CurrentConditionsDisplay(Subject wd) {
    weatherData = wd;
    weatherData.registerObserver(this);
  }

  @Override
  public void update(float temp, float humidity, float pressure) {
    this.temperature = temp;
    this.humidity = humidity;
    display();
  }

  @Override
  public void display() {
    System.out.println(
        "Current conditions: " + temperature + " C degrees and " + humidity + "% humidity");
  }

  @Override
  public void removeObservation() {
    weatherData.removeObserver(this);
  }

}
