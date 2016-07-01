package de.frena.snake.input;

import org.junit.Assert;
import org.junit.Test;

import de.frena.snake.enums.CellTypes;

public class QueueTest {

  @Test
  public void testQueue() {

    Queue queue = new Queue();
    Assert.assertEquals(CellTypes.STRAIGHT, queue.getNext());
    Assert.assertEquals(CellTypes.STRAIGHT, queue.getNext());
    Assert.assertEquals(CellTypes.EDGE, queue.getNext());
    Assert.assertEquals(CellTypes.EDGE, queue.getNext());
    Assert.assertEquals(CellTypes.EDGE, queue.getNext());
  }

  @Test
  public void testQueue_maxReturnNull() {

    Queue queue = new Queue();
    for (int i = 0; i < queue.length; i++) {
      queue.getNext();
    }
    CellTypes next = queue.getNext();
    Assert.assertEquals(null, next);
  }

  @Test
  public void testQueue_hasNext() {
    Queue queue = new Queue();
    Assert.assertTrue(queue.hasNext());
    for (int i = 0; i < 27; i++) {
      queue.getNext();
    }
    Assert.assertFalse(queue.hasNext());


  }

}
