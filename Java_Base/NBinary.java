import java.util.LinkedList;
import java.util.Queue;

public class NBinary {

  public static void main(String[] args) {
    printBinaryIntegers(10);
  }

  private static void printBinaryIntegers(int n) {
    if (n <= 0) {
      System.out.println(" not valid number. ");
    }

    Queue<Integer> q = new LinkedList<>();
    q.add(1);
    for (int i = 0; i < n; i++) {
      Integer current = q.remove();
      System.out.println(current);

      q.add(current * 10);
      q.add(current * 10 + 1);
    }
  }
  
}