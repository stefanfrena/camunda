package decorator.beverages;

import decorator.Beverage;

public class DeCaf extends Beverage {
  public DeCaf() {
    description = "DeCaf";
  }

  public double cost() {
    return .99;
  }
}
