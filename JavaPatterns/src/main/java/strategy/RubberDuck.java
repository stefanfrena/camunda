package strategy;

import strategy.flying.FlyNoWay;
import strategy.quacking.Squeak;

public class RubberDuck extends Duck {

  public RubberDuck() {
    setFlyBehaviour(new FlyNoWay());
    setQuackBehaviour(new Squeak());
  }

  @Override
  void display() {
    System.out.println("looks like a rubber duck");
  }

}
