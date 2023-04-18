package cs5004.collections;

/**
 * Immutable implementation of the PriorityQueue (PQ) interface using a
 * custom linked list data structure.
 * Each element in the priority queue contains a priority
 * and associated value.The priority queue is ordered from highest to lowest priority,
 * and for nodes with the same priority, the new node is treated as
 * if its priority is lower than the compared node.This PQ is recursive and does not allow
 * modification of the original priority queue when performing operations on it.
 */

public final class ListPriorityQueue implements PriorityQueue {

  //make final to make immutable
  private final Node head;

  private ListPriorityQueue(Node head) {
    this.head = head;
  } //so that any changes can reflect in a new private & immutable PQ


  /**
   * Node is an inner class to store data in the PQ, each node holds an
   * integer priority, string value, and following node.
   * By keeping node as an inner class, PQ prevents external manipulation.
   */
  private static class Node {

    private final Integer priority; //boxed
    private final String val;
    private final Node next;

    private Node(Integer priority, String val, Node next) {
      this.priority = priority;
      this.val = val;
      this.next = next;
    }
  }

  /**
   * Factory method that helps create a new empty PQ without accessing the priority queue directly.
   * Factory methods help implementation details as well, and are good replacements for public
   * constructors like in this case.
   */
  public static ListPriorityQueue createEmpty() {
    return new ListPriorityQueue(null); //null because empty
  }

  @Override
  public Boolean isEmpty() {
    return head == null; //if head is null it's empty
  }

  @Override
  public ListPriorityQueue add(Integer priority, String value) throws IllegalArgumentException {
    if (priority < 1 || priority > 10) {
      throw new IllegalArgumentException("Priority needs to be between 1 and 10.");
    }
    return new ListPriorityQueue(addHelper(head, priority, value));
  }

  private Node addHelper(Node currentNode, Integer priority, String val) {
    if (currentNode == null || priority > currentNode.priority) {
      return new Node(priority, val, currentNode);
    }
    return new Node(currentNode.priority, currentNode.val, addHelper(currentNode.next, priority,
        val));
  }

  @Override
  public String peek() throws EmptyPriorityQueueException {
    if (isEmpty()) {
      throw new EmptyPriorityQueueException();
    }
    return head.val;
  }

  @Override
  public ListPriorityQueue pop() throws EmptyPriorityQueueException {
    if (isEmpty()) {
      throw new EmptyPriorityQueueException();
    }
    return new ListPriorityQueue(head.next);
  }

  /**
   * Overriding the equals function to ensure that two equal PQS with all nodes and same
   * priority and value in the same order are considered equal.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    ListPriorityQueue other = (ListPriorityQueue) obj;

    Node current = this.head;
    Node otherNode = other.head;

    while (current != null && otherNode != null) {
      if (!current.priority.equals(otherNode.priority)
          || !current.val.equals(otherNode.val)) {
        return false;
      }

      current = current.next;
      otherNode = otherNode.next;
    }
    return current == null && otherNode == null;
  }

  /**
   * Create a unique haschode for the PQ instance based on node attributes. Ensure that two equal
   * PQs have the same hashcode.
   */
  @Override
  public int hashCode() {
    int result = 17; //initialize with prime number to reduce likelihood of collisions
    Node current = this.head;

    while (current != null) {
      result = 31 * result + current.priority.hashCode();
      result = 31 * result + current.val.hashCode();
      current = current.next;
    }

    return result;
  }

}
