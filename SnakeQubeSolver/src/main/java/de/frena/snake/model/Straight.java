package de.frena.snake.model;

import de.frena.snake.enums.NextConnection;
import de.frena.snake.util.Coordinates;

public class Straight extends Cell {

  /**
   * 
   */
  private static final long serialVersionUID = 796498932924904135L;

  public Straight(Coordinates coordinates, NextConnection nextConnection) {
    super(coordinates, nextConnection);
  }

  @Override
  public NextConnection getNextConnection() {
    return nextConnection;
  }



}
