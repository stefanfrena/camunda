package de.frena.snake.model;

import java.io.Serializable;

import de.frena.snake.enums.NextConnection;
import de.frena.snake.util.Coordinates;

public abstract class Cell implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -6241719177237038171L;
  private Coordinates coordinates;
  protected NextConnection nextConnection;
  private Cell nextCellInLine;

  public void setNextConnection(NextConnection nextConnection) {
    this.nextConnection = nextConnection;
  }

  abstract public NextConnection getNextConnection();

  public Cell(Coordinates coordinates, NextConnection nextConnection) {
    this.coordinates = coordinates;
    this.nextConnection = nextConnection;
  }

  public int getX() {
    return coordinates.getX();
  }

  public int getY() {
    return coordinates.getY();
  }

  public int getZ() {
    return coordinates.getZ();
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public Cell getNextCellInLine() {
    return nextCellInLine;
  }

  public void setNextCellInLine(Cell nextCellInLine) {
    this.nextCellInLine = nextCellInLine;
  }

  @Override
  public String toString() {
    return "Cell [coordinates=" + coordinates + ", nextConnection=" + nextConnection
        + ", nextCellInLine=" + nextCellInLine + "]";
  }



}
