package de.frena.snake.model;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import de.frena.snake.enums.NextConnection;
import de.frena.snake.util.Coordinates;

public class EdgeTest {

  @Test
  public void test_Edge() {
    Edge edge = new Edge(new Coordinates(1, 1, 1), NextConnection.LEFT);
    assertEquals(NextConnection.LEFT, edge.getNextConnection());
  }

  @Test
  public void test_Edge_setNextConnection() {
    Edge edge = new Edge(new Coordinates(1, 1, 1), NextConnection.LEFT);
    assertEquals(NextConnection.LEFT, edge.getNextConnection());
    edge.setNextConnection(NextConnection.RIGHT);
    assertEquals(NextConnection.RIGHT, edge.getNextConnection());

  }
}
