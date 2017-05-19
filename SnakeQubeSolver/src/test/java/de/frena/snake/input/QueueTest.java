package de.frena.snake.input;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.frena.snake.enums.CellTypes;

public class QueueTest {

  @Test
  public void testQueue() {

    Queue queue = new Queue();
    assertEquals(CellTypes.STRAIGHT, queue.getNext());
    assertEquals(CellTypes.STRAIGHT, queue.getNext());
    assertEquals(CellTypes.EDGE, queue.getNext());
    assertEquals(CellTypes.EDGE, queue.getNext());
    assertEquals(CellTypes.EDGE, queue.getNext());
  }

  @Test
  public void testQueue_maxReturnNull() {

    Queue queue = new Queue();
    for (int i = 0; i < queue.length; i++) {
      queue.getNext();
    }
    CellTypes next = queue.getNext();
    assertEquals(null, next);
  }

  @Test
  public void testQueue_hasNext() {
    Queue queue = new Queue();
    assertTrue(queue.hasNext());
    for (int i = 0; i < 27; i++) {
      queue.getNext();
    }
    assertFalse(queue.hasNext());


  }

}
