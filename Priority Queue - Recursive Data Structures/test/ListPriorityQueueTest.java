import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs5004.collections.EmptyPriorityQueueException;
import cs5004.collections.ListPriorityQueue;
import cs5004.collections.PriorityQueue;
import org.junit.jupiter.api.Test;

class ListPriorityQueueTest {

  @Test
  void testCreateEmpty() {
    PriorityQueue pq = ListPriorityQueue.createEmpty();
    assertTrue(pq.isEmpty());
  }

  @Test
  void testIsNotEmpty() {
    PriorityQueue pq = ListPriorityQueue.createEmpty();
    assertTrue(pq.isEmpty());

    pq = pq.add(5, "test");
    assertFalse(pq.isEmpty());
  }

  @Test
  void testAdd() throws EmptyPriorityQueueException {
    PriorityQueue pq = ListPriorityQueue.createEmpty();

    pq = pq.add(3, "apple");
    pq = pq.add(7, "banana");

    // check if elements appear correctly based on add method above
    // and with correct priority
    assertEquals("banana", pq.peek());
    pq = pq.pop();
    assertEquals("test", pq.peek());
    pq = pq.pop();
    assertEquals("apple", pq.peek());
  }

  @Test
  void testAddCorrectly() throws EmptyPriorityQueueException {
    PriorityQueue pq = ListPriorityQueue.createEmpty();
    pq = pq.add(5, "test");
    assertFalse(pq.isEmpty()); //check if adds correctly
  }

  @Test
  void testAddBoundsException() throws EmptyPriorityQueueException {
    PriorityQueue pq = ListPriorityQueue.createEmpty();

    assertThrows(IllegalArgumentException.class, () -> {
      PriorityQueue tempPq = ListPriorityQueue.createEmpty();
      tempPq.add(-1, "invalid");
    }); //check if lower bound of 1-10 works correctly

    assertThrows(IllegalArgumentException.class, () -> {
      PriorityQueue tempPq = ListPriorityQueue.createEmpty();
      tempPq.add(11, "invalid");
    }); //check if upper bound of 1-10 works correctly
  }

  @Test
  void testAddWithinBounds() throws EmptyPriorityQueueException {
    PriorityQueue pq = ListPriorityQueue.createEmpty();

    pq = pq.add(1, "lowest");
    pq = pq.add(10, "highest");

    assertEquals("highest", pq.peek());
    pq = pq.pop();
    assertEquals("lowest", pq.peek());
  }

  @Test
  void testPeek() throws EmptyPriorityQueueException {
    PriorityQueue pq = ListPriorityQueue.createEmpty();
    pq = pq.add(5, "five");

    assertEquals("five", pq.peek());
    pq = pq.add(3, "three");
    pq = pq.add(7, "seven");
    assertEquals("seven", pq.peek());

    assertThrows(EmptyPriorityQueueException.class, () -> ListPriorityQueue.createEmpty().peek());
  }

  @Test
  void testPop() throws EmptyPriorityQueueException {
    PriorityQueue pq = ListPriorityQueue.createEmpty();
    pq = pq.add(5, "orange");
    pq = pq.add(3, "apple");
    pq = pq.add(7, "banana");

    pq = pq.pop(); //banana popped
    assertEquals("orange", pq.peek()); //second highest is orange
    pq = pq.pop(); //orange popped
    assertEquals("apple", pq.peek()); //lowest is apple

    //list should now be empty
    assertThrows(EmptyPriorityQueueException.class, () -> ListPriorityQueue.createEmpty().pop());
  }

  @Test
  void testEquals() {
    PriorityQueue pq1 = ListPriorityQueue.createEmpty().add(5, "five1");
    PriorityQueue pq2 = ListPriorityQueue.createEmpty().add(5, "five2");
    PriorityQueue pq3 = ListPriorityQueue.createEmpty().add(3, "three");

    assertTrue(pq1.equals(pq2));
    assertFalse(pq1.equals(pq3));
    assertFalse(pq2.equals(pq3));

    assertEquals(pq1.hashCode(), pq2.hashCode());
    assertNotEquals(pq1.hashCode(), pq3.hashCode());
  }

  @Test
  void testSameHashCode() {
    PriorityQueue pq1 = ListPriorityQueue.createEmpty().add(5, "five1");
    PriorityQueue pq2 = ListPriorityQueue.createEmpty().add(5, "five2");
    PriorityQueue pq3 = ListPriorityQueue.createEmpty().add(3, "three");

    assertEquals(pq1.hashCode(), pq2.hashCode());
    assertNotEquals(pq1.hashCode(), pq3.hashCode());
  }

  @Test
  void testToString() {
    PriorityQueue pq = ListPriorityQueue.createEmpty().add(5, "five");
    pq = pq.add(3, "three");
    pq = pq.add(7, "seven");

    String expected = "[ (7, banana), (5, test), (3, apple) ]";
    assertEquals(expected, pq.toString());
  }

  @Test
  void testSameValueCorrectOrder() throws EmptyPriorityQueueException {
    PriorityQueue pq = ListPriorityQueue.createEmpty();

    pq = pq.add(5, "first");
    pq = pq.add(5, "second");
    pq = pq.add(5, "third");

    assertEquals("first", pq.peek());
    pq = pq.pop();
    assertEquals("second", pq.peek());
    pq = pq.pop();
    assertEquals("third", pq.peek());
  }
}
