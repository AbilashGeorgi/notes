public class CustomLinkedList<T> {
  private Node<T> head;
  private Node<T> currNode;
  private int size = 0;
  
  public CustomLinkedList(T firstData) {
    head = new Node<T>(firstData);
    currNode = head;
    size++;
  }

  public void add(T data) {
    while(currNode.next != null) {
      currNode = currNode.next;
    }
    Node<T> newNode = new Node<T>(data);
    currNode.next = newNode;
    currNode = newNode;
    size++;
  }

  public void deleteMiddle() {
    int middleIndex = (int) Math.ceil(size/2.0);
    // handle first node deletion case seperately.
    currNode = head;
    Node<T> splitStartNode = currNode; 
    for (int i =1; i< middleIndex; i++) {
      splitStartNode = currNode;
      currNode = currNode.next;
    }
    splitStartNode.next = currNode;
  }

  private static class Node<T> {
    private Node(T data) {
      this.data = data;
    }
    private T data;
    private Node<T> next;
  }


}
