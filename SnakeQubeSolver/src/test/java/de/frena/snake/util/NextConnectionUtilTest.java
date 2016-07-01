package de.frena.snake.util;

import static de.frena.snake.enums.NextConnection.BACKWARDS;
import static de.frena.snake.enums.NextConnection.BOTTOM;
import static de.frena.snake.enums.NextConnection.FORWARDS;
import static de.frena.snake.enums.NextConnection.LEFT;
import static de.frena.snake.enums.NextConnection.RIGHT;
import static de.frena.snake.enums.NextConnection.TOP;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import de.frena.snake.enums.NextConnection;

@RunWith(Theories.class)
public class NextConnectionUtilTest {


  @Theory
  public void testGetRealNextConnection(NCTestfall nCTestfall) throws Exception {
    NextConnection result =
        NextConnectionUtil.getRealNextConnection(nCTestfall.next, nCTestfall.origin);
    Assert.assertEquals(nCTestfall.expected, result);
  }

  // Forwards
  @DataPoint
  public static NCTestfall testfall1 =
      new NCTestfall().withOrigin(FORWARDS).withNext(FORWARDS).withResult(FORWARDS);
  @DataPoint
  public static NCTestfall testfall2 =
      new NCTestfall().withOrigin(FORWARDS).withNext(BACKWARDS).withResult(BACKWARDS);
  @DataPoint
  public static NCTestfall testfall3 =
      new NCTestfall().withOrigin(FORWARDS).withNext(TOP).withResult(TOP);
  @DataPoint
  public static NCTestfall testfall4 =
      new NCTestfall().withOrigin(FORWARDS).withNext(BOTTOM).withResult(BOTTOM);
  @DataPoint
  public static NCTestfall testfall5 =
      new NCTestfall().withOrigin(FORWARDS).withNext(LEFT).withResult(LEFT);
  @DataPoint
  public static NCTestfall testfall6 =
      new NCTestfall().withOrigin(FORWARDS).withNext(RIGHT).withResult(RIGHT);

  // Backwards
  @DataPoint
  public static NCTestfall testfall7 =
      new NCTestfall().withOrigin(BACKWARDS).withNext(FORWARDS).withResult(BACKWARDS);
  @DataPoint
  public static NCTestfall testfall8 =
      new NCTestfall().withOrigin(BACKWARDS).withNext(BACKWARDS).withResult(FORWARDS);
  @DataPoint
  public static NCTestfall testfall9 =
      new NCTestfall().withOrigin(BACKWARDS).withNext(TOP).withResult(TOP);
  @DataPoint
  public static NCTestfall testfall10 =
      new NCTestfall().withOrigin(BACKWARDS).withNext(BOTTOM).withResult(BOTTOM);
  @DataPoint
  public static NCTestfall testfall11 =
      new NCTestfall().withOrigin(BACKWARDS).withNext(LEFT).withResult(NextConnection.RIGHT);
  @DataPoint
  public static NCTestfall testfall12 =
      new NCTestfall().withOrigin(BACKWARDS).withNext(RIGHT).withResult(LEFT);

  // Top
  @DataPoint
  public static NCTestfall testfall13 =
      new NCTestfall().withOrigin(TOP).withNext(FORWARDS).withResult(TOP);
  @DataPoint
  public static NCTestfall testfall14 =
      new NCTestfall().withOrigin(TOP).withNext(BACKWARDS).withResult(BOTTOM);
  @DataPoint
  public static NCTestfall testfall15 =
      new NCTestfall().withOrigin(TOP).withNext(TOP).withResult(BACKWARDS);
  @DataPoint
  public static NCTestfall testfall16 =
      new NCTestfall().withOrigin(TOP).withNext(BOTTOM).withResult(FORWARDS);
  @DataPoint
  public static NCTestfall testfall17 =
      new NCTestfall().withOrigin(TOP).withNext(LEFT).withResult(LEFT);
  @DataPoint
  public static NCTestfall testfall18 =
      new NCTestfall().withOrigin(TOP).withNext(RIGHT).withResult(RIGHT);

  // Bottom
  @DataPoint
  public static NCTestfall testfall19 =
      new NCTestfall().withOrigin(BOTTOM).withNext(FORWARDS).withResult(BOTTOM);
  @DataPoint
  public static NCTestfall testfall20 =
      new NCTestfall().withOrigin(BOTTOM).withNext(BACKWARDS).withResult(TOP);
  @DataPoint
  public static NCTestfall testfall21 =
      new NCTestfall().withOrigin(BOTTOM).withNext(TOP).withResult(FORWARDS);
  @DataPoint
  public static NCTestfall testfall22 =
      new NCTestfall().withOrigin(BOTTOM).withNext(BOTTOM).withResult(BACKWARDS);
  @DataPoint
  public static NCTestfall testfall23 =
      new NCTestfall().withOrigin(BOTTOM).withNext(LEFT).withResult(LEFT);
  @DataPoint
  public static NCTestfall testfall24 =
      new NCTestfall().withOrigin(BOTTOM).withNext(RIGHT).withResult(RIGHT);

  // Right
  @DataPoint
  public static NCTestfall testfall25 =
      new NCTestfall().withOrigin(RIGHT).withNext(FORWARDS).withResult(RIGHT);
  @DataPoint
  public static NCTestfall testfall26 =
      new NCTestfall().withOrigin(RIGHT).withNext(BACKWARDS).withResult(LEFT);
  @DataPoint
  public static NCTestfall testfall27 =
      new NCTestfall().withOrigin(RIGHT).withNext(TOP).withResult(TOP);
  @DataPoint
  public static NCTestfall testfall28 =
      new NCTestfall().withOrigin(RIGHT).withNext(BOTTOM).withResult(BOTTOM);
  @DataPoint
  public static NCTestfall testfall29 =
      new NCTestfall().withOrigin(RIGHT).withNext(LEFT).withResult(FORWARDS);
  @DataPoint
  public static NCTestfall testfall30 =
      new NCTestfall().withOrigin(RIGHT).withNext(RIGHT).withResult(BACKWARDS);

  // Left
  @DataPoint
  public static NCTestfall testfall31 =
      new NCTestfall().withOrigin(LEFT).withNext(FORWARDS).withResult(LEFT);
  @DataPoint
  public static NCTestfall testfall32 =
      new NCTestfall().withOrigin(LEFT).withNext(BACKWARDS).withResult(RIGHT);
  @DataPoint
  public static NCTestfall testfall33 =
      new NCTestfall().withOrigin(LEFT).withNext(TOP).withResult(TOP);
  @DataPoint
  public static NCTestfall testfall34 =
      new NCTestfall().withOrigin(LEFT).withNext(BOTTOM).withResult(BOTTOM);
  @DataPoint
  public static NCTestfall testfall35 =
      new NCTestfall().withOrigin(LEFT).withNext(LEFT).withResult(BACKWARDS);
  @DataPoint
  public static NCTestfall testfall36 =
      new NCTestfall().withOrigin(LEFT).withNext(RIGHT).withResult(FORWARDS);



  // Testfall helper class for theories
  public static class NCTestfall {
    NextConnection next;
    NextConnection origin;
    NextConnection expected;

    NCTestfall withNext(NextConnection next) {
      this.next = next;
      return this;
    }

    NCTestfall withOrigin(NextConnection origin) {
      this.origin = origin;
      return this;
    }


    NCTestfall withResult(NextConnection expected) {
      this.expected = expected;
      return this;
    }

  }

}
