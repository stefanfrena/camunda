package observer.selfmade.interfaces;

public interface Observer {
  public void update(float temp, float humidity, float pressure);

  public void removeObservation();
}
