package de.frena.snake.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.frena.snake.enums.NextConnection;
import de.frena.snake.util.Coordinates;
import de.frena.snake.util.NextConnectionUtil;

public class Cube implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -5822826067516757126L;


  private Coordinates startCoords;
  private int sideLength;
  private List<NextConnection> solvedConnections;

  public List<NextConnection> getSolvedConnections() {
    return solvedConnections;
  }


  private List<List<List<Cell>>> allCells;
  private Cell lastAddedCell;


  public Cube(int sideLength, Coordinates startCoords) {
    this.sideLength = sideLength;
    this.startCoords = startCoords;
    this.solvedConnections = new ArrayList<>(sideLength * sideLength * sideLength);
    initAllCells(sideLength);


  }

  private void initAllCells(int sideLength) {
    allCells = new ArrayList<List<List<Cell>>>(sideLength);
    for (int i = 0; i < sideLength; i++) {
      List<List<Cell>> plate = new ArrayList<List<Cell>>(sideLength);
      for (int j = 0; j < sideLength; j++) {
        List<Cell> row = new ArrayList<Cell>(sideLength);
        for (int k = 0; k < sideLength; k++) {
          row.add(null);
        }
        plate.add(row);
      }
      allCells.add(plate);
    }
  }

  public int getSideLenght() {
    return sideLength;
  }

  public void fillStraightCell(NextConnection nextConnection) throws IndexOutOfBoundsException {
    nextConnection = findCorrectHeadingOfNextConnection(nextConnection);
    Straight newCell = new Straight(getCoordinates(), nextConnection);
    fillCell(newCell);
  }

  public void fillEdgeCell(NextConnection nextConnection) throws IndexOutOfBoundsException {
    nextConnection = findCorrectHeadingOfNextConnection(nextConnection);
    fillCell(new Edge(getCoordinates(), nextConnection));
  }

  private NextConnection findCorrectHeadingOfNextConnection(NextConnection nextConnection) {
    if (!cubeIsEmpty()) {
      nextConnection = NextConnectionUtil.getRealNextConnection(nextConnection,
          this.lastAddedCell.getNextConnection());
    }
    return nextConnection;
  }

  private Coordinates getCoordinates() {
    if (cubeIsEmpty()) {
      return startCoords;
    }
    NextConnection nextConnection = lastAddedCell.getNextConnection();

    if (nextConnection.equals(NextConnection.FORWARDS)) {
      return increaseZ(lastAddedCell.getCoordinates());
    }

    if (nextConnection.equals(NextConnection.BACKWARDS)) {
      return decreaseZ(lastAddedCell.getCoordinates());
    }

    if (nextConnection.equals(NextConnection.BOTTOM)) {
      return decreaseY(lastAddedCell.getCoordinates());
    }

    if (nextConnection.equals(NextConnection.LEFT)) {
      return decreaseX(lastAddedCell.getCoordinates());
    }

    if (nextConnection.equals(NextConnection.RIGHT)) {
      return increaseX(lastAddedCell.getCoordinates());
    }
    if (nextConnection.equals(NextConnection.TOP)) {
      return increaseY(lastAddedCell.getCoordinates());
    }

    return null;

  }


  private Boolean cubeIsEmpty() {
    return null == this.getCell(startCoords.getX(), startCoords.getY(), startCoords.getZ());
  }

  private Coordinates decreaseX(Coordinates coordinates) {
    coordinates.setX(coordinates.getX() - 1);
    return coordinates;
  }

  private Coordinates increaseX(Coordinates coordinates) {
    coordinates.setX(coordinates.getX() + 1);
    return coordinates;
  }

  private Coordinates decreaseY(Coordinates coordinates) {
    coordinates.setY(coordinates.getY() - 1);
    return coordinates;
  }

  private Coordinates increaseY(Coordinates coordinates) {
    coordinates.setY(coordinates.getY() + 1);
    return coordinates;
  }

  private Coordinates increaseZ(Coordinates coordinates) {
    coordinates.setZ(coordinates.getZ() + 1);
    return coordinates;
  }

  private Coordinates decreaseZ(Coordinates coordinates) {
    coordinates.setZ(coordinates.getZ() - 1);
    return coordinates;
  }

  public void fillCell(Cell newCell) {
    try {
      if (isCellToFillStillEmpty(newCell.getCoordinates())) {

        allCells.get(newCell.getX() - 1).get(newCell.getY() - 1).set(newCell.getZ() - 1, newCell);
        solvedConnections.add(newCell.nextConnection);
        lastAddedCell = newCell;

      } else {
        throw new IndexOutOfBoundsException();
      }
    } catch (IndexOutOfBoundsException e) {
      throw e;
    }
  }

  private boolean isCellToFillStillEmpty(Coordinates coordinates) {
    return null == allCells.get(coordinates.getX() - 1).get(coordinates.getY() - 1)
        .get(coordinates.getZ() - 1);
  }

  public Cell getCell(int x, int y, int z) {
    Cell cell = allCells.get(x - 1).get(y - 1).get(z - 1);
    return cell;
  }

  public Cell getCellAndPrintNextConnection(int x, int y, int z) {
    Cell cell = getCell(x, y, z);
    System.out.println(cell.getNextConnection());
    return cell;
  }


  public Cell getFirstCell() {
    return getCell(startCoords.getX(), startCoords.getY(), startCoords.getZ());
  }

  public Object getLastAddedCell() {
    return lastAddedCell;
  }



}
