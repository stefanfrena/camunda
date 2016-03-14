package observer.builtin.display;

import org.junit.Test;

import observer.builtin.WeatherData;

public class ObserverTest {

  @Test
  public void testCurrentConditionsDisplay() {
    WeatherData weatherData = new WeatherData();
    new CurrentConditionsDisplay(weatherData);
    new PressureDisplay(weatherData);

    weatherData.setMeasurements(10f, 25f, 30f);



  }
}
