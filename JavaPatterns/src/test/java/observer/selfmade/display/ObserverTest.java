package observer.selfmade.display;

import org.junit.Test;

import observer.selfmade.WeatherData;

public class ObserverTest {

  @Test
  public void testCurrentConditionsDisplay() {
    WeatherData weatherData = new WeatherData();
    new CurrentConditionsDisplay(weatherData);
    new PressureDisplay(weatherData);
    HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

    weatherData.setMeasurements(10f, 25f, 30f);

    heatIndexDisplay.removeObservation();
    weatherData.setMeasurements(15f, 30f, 33f);



  }
}
