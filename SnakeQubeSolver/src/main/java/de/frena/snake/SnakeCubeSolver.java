package de.frena.snake;

import static de.frena.snake.enums.NextConnection.FORWARDS;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import de.frena.snake.enums.CellTypes;
import de.frena.snake.enums.NextConnection;
import de.frena.snake.input.Queue;
import de.frena.snake.model.Cube;
import de.frena.snake.util.Coordinates;

public class SnakeCubeSolver {

  public void solve() throws Exception {
    Queue queue = new Queue();
    CellTypes next;

    List<Cube> possibleCubes = new ArrayList<>();
    List<Cube> helperList = new ArrayList<>();
    possibleCubes.add(new Cube(3, new Coordinates(1, 1, 1)));


    while (queue.hasNext()) {
      next = queue.getNext();
      helperList.clear();

      if (CellTypes.STRAIGHT.equals(next)) {
        System.out.print("Straight ");
        for (Cube candidate : possibleCubes) {
          // only one next connection possible: front
          Cube workingCopy = cloneCube(candidate);
          try {
            workingCopy.fillStraightCell(FORWARDS);
            helperList.add(workingCopy);
          } catch (IndexOutOfBoundsException e) {
          }

        }

      } else if (CellTypes.EDGE.equals(next)) {
        System.out.print("Edge ");
        // four next connections possible: Left, Right, Top, Bottom
        for (Cube candidate : possibleCubes) {
          Cube workingCopy = cloneCube(candidate);
          try {
            workingCopy.fillEdgeCell(NextConnection.BOTTOM);
            helperList.add(workingCopy);
          } catch (IndexOutOfBoundsException e) {
          }

          try {
            workingCopy = cloneCube(candidate);
            workingCopy.fillEdgeCell(NextConnection.LEFT);
            helperList.add(workingCopy);
          } catch (IndexOutOfBoundsException e) {
          }
          try {
            workingCopy = cloneCube(candidate);
            workingCopy.fillEdgeCell(NextConnection.RIGHT);
            helperList.add(workingCopy);
          } catch (IndexOutOfBoundsException e) {
          }
          try {
            workingCopy = cloneCube(candidate);
            workingCopy.fillEdgeCell(NextConnection.TOP);
            helperList.add(workingCopy);
          } catch (IndexOutOfBoundsException e) {
          }


        }



      }
      possibleCubes.clear();
      possibleCubes = cloneList(helperList);
      System.out.println("Candidates: " + possibleCubes.size());

    }
    for (Cube resultCube : possibleCubes) {
      System.out.println("");
      for (NextConnection nextConnection : resultCube.getSolvedConnections()) {
        System.out.print(nextConnection.name() + "-");
      }


    }


  }


  @SuppressWarnings("unchecked")
  private List<Cube> cloneList(List<Cube> helperList) throws Exception {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(helperList);
    oos.flush();
    oos.close();
    bos.close();
    byte[] byteData = bos.toByteArray();

    ByteArrayInputStream bais = new ByteArrayInputStream(byteData);
    List<Cube> newCubeList = (List<Cube>) new ObjectInputStream(bais).readObject();

    return newCubeList;
  }

  private Cube cloneCube(Cube candidate) throws Exception {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(candidate);
    oos.flush();
    oos.close();
    bos.close();
    byte[] byteData = bos.toByteArray();

    ByteArrayInputStream bais = new ByteArrayInputStream(byteData);
    Cube newCube = (Cube) new ObjectInputStream(bais).readObject();

    return newCube;
  }


}
