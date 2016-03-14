package strategy.quacking;

public class MuteQuack implements QuackBehavoiur {

  @Override
  public void quack() {
    System.out.println("I cannot Quack");
  }

}
