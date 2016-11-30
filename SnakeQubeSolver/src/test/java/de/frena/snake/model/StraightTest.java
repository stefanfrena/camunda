package de.frena.snake.model;

import static de.frena.snake.enums.NextConnection.FORWARDS;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.frena.snake.util.Coordinates;

public class StraightTest {

  @Test
  public void test_Straight() {
    Straight straight = new Straight(new Coordinates(1, 1, 1), FORWARDS);
    assertEquals(FORWARDS, straight.getNextConnection());
  }
}
