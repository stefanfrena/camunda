package strategy;

import strategy.flying.FlyWithWings;
import strategy.quacking.Quack;

public class MallardDuck extends Duck {

  public MallardDuck() {
    setFlyBehaviour(new FlyWithWings());
    setQuackBehaviour(new Quack());
  }

  @Override
  void display() {
    System.out.println("looks like a mallard duck");
  }

}
