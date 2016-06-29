package de.frena.snake.input;

import java.util.Arrays;
import java.util.List;

import de.frena.snake.enums.CellTypes;

public class Queue {

  final List<CellTypes> cubeSetup;
  int nextInLine;
  int length;

  public Queue() {
    nextInLine = 0;
    cubeSetup = (Arrays.asList(//
        CellTypes.STRAIGHT, //
        CellTypes.STRAIGHT, //
        CellTypes.EDGE, //
        CellTypes.EDGE, //
        CellTypes.EDGE, //
        CellTypes.STRAIGHT, //
        CellTypes.EDGE, //
        CellTypes.EDGE, //
        CellTypes.STRAIGHT, //
        CellTypes.EDGE, //
        CellTypes.EDGE, //
        CellTypes.EDGE, //
        CellTypes.STRAIGHT, //
        CellTypes.EDGE, //
        CellTypes.STRAIGHT, //
        CellTypes.EDGE, //
        CellTypes.EDGE, //
        CellTypes.EDGE, //
        CellTypes.EDGE, //
        CellTypes.STRAIGHT, //
        CellTypes.EDGE, //
        CellTypes.STRAIGHT, //
        CellTypes.EDGE, //
        CellTypes.STRAIGHT, //
        CellTypes.EDGE, //
        CellTypes.STRAIGHT, //
        CellTypes.STRAIGHT//
    ));
    length = cubeSetup.size();

  }

  public CellTypes getNext() {
    if (nextInLine < length) {
      CellTypes next = cubeSetup.get(nextInLine);
      nextInLine++;
      return next;
    }
    return null;
  }

  public Boolean hasNext() {
    if (nextInLine < length)
      return true;
    return false;
  }


}
