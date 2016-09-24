package de.frena.snake.model;

import static de.frena.snake.enums.NextConnection.FORWARDS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import de.frena.snake.enums.CellTypes;
import de.frena.snake.enums.NextConnection;
import de.frena.snake.util.Coordinates;

public class CubeTest {


  @Test
  public void test_checkBoundaries() {
    new Cube(3, new Coordinates(1, 1, 1));
    getList();



  }



  @Test
  public void test_initCube() {
    Cube cube = new Cube(3, new Coordinates(1, 1, 1));
    assertTrue(3 == cube.getSideLenght());

  }

  @Test
  public void test_addStraight() {
    Cube cube = new Cube(3, new Coordinates(1, 1, 1));
    cube.fillCell(new Straight(new Coordinates(1, 1, 1), FORWARDS));
    Cell cell = cube.getCell(1, 1, 1);
    assertTrue(cell instanceof Straight);
    assertEquals(1, cell.getX());
    assertEquals(1, cell.getY());
    assertEquals(1, cell.getZ());
  }

  @Test
  public void test_lastAddedCell() {
    Cube cube = new Cube(3, new Coordinates(1, 1, 1));
    Straight cell = new Straight(new Coordinates(1, 3, 1), FORWARDS);
    cube.fillCell(cell);
    assertEquals(cell, cube.getLastAddedCell());
    assertTrue(cell instanceof Straight);
    assertEquals(1, cell.getX());
    assertEquals(3, cell.getY());
    assertEquals(1, cell.getZ());
  }


  @Test(expected = NullPointerException.class)
  public void test_wrong_x() {
    Cube cube = new Cube(3, new Coordinates(1, 1, 1));
    cube.fillCell(new Straight(new Coordinates(2, 1, 1), FORWARDS));
    Cell cell = cube.getCell(1, 1, 1);
    assertEquals(1, cell.getX());
    assertEquals(1, cell.getY());
    assertEquals(1, cell.getZ());
  }

  @Test(expected = NullPointerException.class)
  public void test_wrong_y() {
    Cube cube = new Cube(3, new Coordinates(1, 1, 1));
    cube.fillCell(new Straight(new Coordinates(1, 2, 1), FORWARDS));
    Cell cell = cube.getCell(1, 1, 1);
    assertEquals(1, cell.getX());
    assertEquals(1, cell.getY());
    assertEquals(1, cell.getZ());
  }

  @Test(expected = NullPointerException.class)
  public void test_wrong_z() {
    Cube cube = new Cube(3, new Coordinates(1, 1, 1));
    cube.fillCell(new Straight(new Coordinates(1, 1, 2), FORWARDS));
    Cell cell = cube.getCell(1, 1, 1);
    assertEquals(1, cell.getX());
    assertEquals(1, cell.getY());
    assertEquals(1, cell.getZ());
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void test_wrong_x_bounds() {
    Cube cube = new Cube(3, new Coordinates(1, 1, 1));
    cube.fillCell(new Straight(new Coordinates(4, 1, 1), FORWARDS));
    Cell cell = cube.getCell(1, 1, 1);
    assertEquals(1, cell.getX());
    assertEquals(1, cell.getY());
    assertEquals(1, cell.getZ());
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void test_wrong_y_bounds() {
    Cube cube = new Cube(3, new Coordinates(1, 1, 1));
    cube.fillCell(new Straight(new Coordinates(1, 4, 1), FORWARDS));
    Cell cell = cube.getCell(1, 1, 1);
    assertEquals(1, cell.getX());
    assertEquals(1, cell.getY());
    assertEquals(1, cell.getZ());
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void test_wrong_z_bounds() {
    Cube cube = new Cube(3, new Coordinates(1, 1, 1));
    cube.fillCell(new Straight(new Coordinates(0, 1, 4), FORWARDS));
    Cell cell = cube.getCell(1, 1, 1);
    assertEquals(1, cell.getX());
    assertEquals(1, cell.getY());
    assertEquals(1, cell.getZ());
  }

  @Test
  public void test_addEdge() {
    Cube cube = new Cube(3, new Coordinates(1, 1, 1));
    cube.fillCell(new Edge(new Coordinates(1, 1, 1), NextConnection.BOTTOM));
    Cell cell = cube.getCell(1, 1, 1);
    assertTrue(cell instanceof Edge);
    assertEquals(1, cell.getX());
    assertEquals(1, cell.getY());
    assertEquals(1, cell.getZ());
  }


  @Test(expected = NullPointerException.class)
  public void test_edge_wrong_x() {
    Cube cube = new Cube(3, new Coordinates(1, 1, 1));
    cube.fillCell(new Edge(new Coordinates(2, 1, 1), NextConnection.BOTTOM));
    Cell cell = cube.getCell(1, 1, 1);
    assertEquals(1, cell.getX());
    assertEquals(1, cell.getY());
    assertEquals(1, cell.getZ());
  }

  @Test(expected = NullPointerException.class)
  public void test_edge_wrong_y() {
    Cube cube = new Cube(3, new Coordinates(1, 1, 1));
    cube.fillCell(new Edge(new Coordinates(1, 2, 1), NextConnection.BOTTOM));
    Cell cell = cube.getCell(1, 1, 1);
    assertEquals(1, cell.getX());
    assertEquals(1, cell.getY());
    assertEquals(1, cell.getZ());
  }

  @Test(expected = NullPointerException.class)
  public void test_edge_wrong_z() {
    Cube cube = new Cube(3, new Coordinates(1, 1, 1));
    cube.fillCell(new Edge(new Coordinates(1, 1, 2), NextConnection.BOTTOM));
    Cell cell = cube.getCell(1, 1, 1);
    assertEquals(1, cell.getX());
    assertEquals(1, cell.getY());
    assertEquals(1, cell.getZ());
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void test_edge_wrong_x_bounds() {
    Cube cube = new Cube(3, new Coordinates(1, 1, 1));
    cube.fillCell(new Edge(new Coordinates(4, 1, 1), NextConnection.BOTTOM));
    Cell cell = cube.getCell(1, 1, 1);
    assertEquals(1, cell.getX());
    assertEquals(1, cell.getY());
    assertEquals(1, cell.getZ());
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void test_edge_wrong_y_bounds() {
    Cube cube = new Cube(3, new Coordinates(1, 1, 1));
    cube.fillCell(new Edge(new Coordinates(1, 4, 1), NextConnection.BOTTOM));
    Cell cell = cube.getCell(1, 1, 1);
    assertEquals(1, cell.getX());
    assertEquals(1, cell.getY());
    assertEquals(1, cell.getZ());
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void test_edge_wrong_z_bounds() {
    Cube cube = new Cube(3, new Coordinates(1, 1, 1));
    cube.fillCell(new Edge(new Coordinates(0, 1, 4), NextConnection.BOTTOM));
    Cell cell = cube.getCell(1, 1, 1);
    assertEquals(1, cell.getX());
    assertEquals(1, cell.getY());
    assertEquals(1, cell.getZ());
  }

  @Test
  public void testFillStraightCell() throws Exception {
    Cube cube = new Cube(3, new Coordinates(1, 1, 1));
    cube.fillStraightCell(FORWARDS);
    cube.fillStraightCell(FORWARDS);

  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testFillStraightCell_indexOutOfBounds() throws Exception {
    Cube cube = new Cube(3, new Coordinates(1, 1, 1));
    cube.fillStraightCell(FORWARDS);
    cube.fillStraightCell(FORWARDS);
    cube.fillStraightCell(FORWARDS);
    cube.fillStraightCell(FORWARDS);

  }

  private List<CellTypes> getList() {
    return Arrays.asList(//
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
    );
  }



}
