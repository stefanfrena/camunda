package decorator.beverages;

import decorator.Beverage;

public class DarkRoast extends Beverage {
  public DarkRoast() {
    description = "Dark Roast";
  }

  public double cost() {
    return .40;
  }
}
