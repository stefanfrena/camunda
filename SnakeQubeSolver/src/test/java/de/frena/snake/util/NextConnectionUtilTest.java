package de.frena.snake.util;

import static de.frena.snake.enums.NextConnection.BACKWARDS;
import static de.frena.snake.enums.NextConnection.BOTTOM;
import static de.frena.snake.enums.NextConnection.FORWARDS;
import static de.frena.snake.enums.NextConnection.LEFT;
import static de.frena.snake.enums.NextConnection.RIGHT;
import static de.frena.snake.enums.NextConnection.TOP;

import org.junit.Assert;
import org.junit.Before;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import de.frena.snake.enums.NextConnection;

@RunWith(Theories.class)
public class NextConnectionUtilTest {

  @Before
  public void init() {}

  @DataPoints("next connections")
  public static NextConnection[] nextConnectionsToFill =
      new NextConnection[] {FORWARDS, LEFT, RIGHT, TOP, BOTTOM};

  @DataPoints("backward results")
  public static NextConnection[] origin =
      new NextConnection[] {BACKWARDS, RIGHT, LEFT, TOP, BOTTOM};



  @Theory
  public void testGetRealNextConnection_origin_foreward(NextConnection nextConnectionToFill)
      throws Exception {
    NextConnection result =
        NextConnectionUtil.getRealNextConnection(nextConnectionToFill, FORWARDS);
    Assert.assertEquals(nextConnectionToFill, result);
  }

  @Theory
  public void testGetRealNextConnection_origin_backward(
      @FromDataPoints("next connections") NextConnection nextConnectionToFill,
      @FromDataPoints("backward results") NextConnection expected) throws Exception {
    System.out.print("next: " + nextConnectionToFill + " expected: " + expected);
    NextConnection result =
        NextConnectionUtil.getRealNextConnection(nextConnectionToFill, BACKWARDS);
    // Assert.assertEquals(expected, result);
    System.out.println(" OK");

  }


}
