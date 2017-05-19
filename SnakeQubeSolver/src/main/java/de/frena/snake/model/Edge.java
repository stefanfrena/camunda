package de.frena.snake.model;

import de.frena.snake.enums.NextConnection;
import de.frena.snake.util.Coordinates;

public class Edge extends Cell {

  /**
   * 
   */
  private static final long serialVersionUID = 941731615707883493L;

  public Edge(Coordinates coordinates, NextConnection nextConnection) {
    super(coordinates, nextConnection);
  }

  @Override
  public NextConnection getNextConnection() {
    return nextConnection;
  }



}
