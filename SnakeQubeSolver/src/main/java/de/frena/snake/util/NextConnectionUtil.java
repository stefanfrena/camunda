package de.frena.snake.util;

import static de.frena.snake.enums.NextConnection.BACKWARDS;
import static de.frena.snake.enums.NextConnection.BOTTOM;
import static de.frena.snake.enums.NextConnection.FORWARDS;
import static de.frena.snake.enums.NextConnection.LEFT;
import static de.frena.snake.enums.NextConnection.RIGHT;
import static de.frena.snake.enums.NextConnection.TOP;

import de.frena.snake.enums.NextConnection;

public class NextConnectionUtil {

  public static NextConnection getRealNextConnection(NextConnection nextConnection,
      NextConnection origin) {

    switch (origin) {

      case FORWARDS:
        return nextConnection; // if forward next connection has not to be recalculated

      case BACKWARDS:
        switch (nextConnection) {
          case FORWARDS:
            return BACKWARDS;
          case BACKWARDS:
            return FORWARDS;
          case LEFT:
            return RIGHT;
          case RIGHT:
            return LEFT;
          case TOP:
            return TOP;
          case BOTTOM:
            return BOTTOM;
        }

      case BOTTOM:
        switch (nextConnection) {
          case FORWARDS:
            return BOTTOM;
          case BACKWARDS:
            return TOP;
          case LEFT:
            return LEFT;
          case RIGHT:
            return RIGHT;
          case TOP:
            return FORWARDS;
          case BOTTOM:
            return BACKWARDS;


        }

      case LEFT:
        switch (nextConnection) {
          case FORWARDS:
            return LEFT;
          case LEFT:
            return BACKWARDS;
          case RIGHT:
            return FORWARDS;
          case TOP:
            return TOP;
          case BOTTOM:
            return BOTTOM;
          case BACKWARDS:
            return RIGHT;


        }

      case RIGHT:
        switch (nextConnection) {
          case FORWARDS:
            return RIGHT;
          case LEFT:
            return FORWARDS;
          case RIGHT:
            return BACKWARDS;
          case TOP:
            return TOP;
          case BOTTOM:
            return BOTTOM;
          case BACKWARDS:
            return LEFT;

        }
      case TOP:
        switch (nextConnection) {
          case FORWARDS:
            return TOP;
          case BACKWARDS:
            return BOTTOM;
          case LEFT:
            return LEFT;
          case RIGHT:
            return RIGHT;
          case TOP:
            return BACKWARDS;
          case BOTTOM:
            return FORWARDS;
        }


      default:
        break;

    }


    return null;

  }

}
