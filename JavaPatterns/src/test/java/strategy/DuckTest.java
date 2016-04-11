package strategy;

import org.junit.Test;

import strategy.flying.FlyWithRocket;

public class DuckTest {

  @Test
  public void testMallardDuck() {
    MallardDuck mallardDuck = new MallardDuck();
    mallardDuck.performFly();
    mallardDuck.performQuack();

    mallardDuck.setFlyBehaviour(new FlyWithRocket());
    mallardDuck.performFly();
  }

  @Test
  public void testRubberDuck() {
    RubberDuck rubberDuck = new RubberDuck();
    rubberDuck.performFly();
    rubberDuck.setFlyBehaviour(new FlyWithRocket());
    rubberDuck.performFly();
    rubberDuck.performQuack();
    rubberDuck.swim();
  }
}
