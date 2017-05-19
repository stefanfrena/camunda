package strategy;

import strategy.flying.FlyBehaviour;
import strategy.quacking.QuackBehavoiur;

abstract public class Duck {
  private FlyBehaviour flyBehaviour;
  private QuackBehavoiur quackBehaviour;

  abstract void display();


  public void performFly() {
    flyBehaviour.fly();
  }

  public void performQuack() {
    quackBehaviour.quack();
  }

  public void swim() {
    System.out.println("I am swimming");
  }

  public void setFlyBehaviour(FlyBehaviour fb) {
    this.flyBehaviour = fb;
  }


  public void setQuackBehaviour(QuackBehavoiur qb) {
    this.quackBehaviour = qb;
  }



}
