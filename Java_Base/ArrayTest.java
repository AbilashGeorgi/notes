import java.util.stream.IntStream;

public class ArrayTest {
  public static void main(String[] args) {
    System.out.println(getMaxProduct(1,2,3,4));
    System.out.println(getMaxProduct(1));
  }

  private static int getMaxProduct(int... arr) {
    int highestVal = 0;
    int secondHighestVal = 0;
    for (int i = 0; i< arr.length; i++) {
      if (arr[i] > highestVal) {
        secondHighestVal = highestVal;
        highestVal = arr[i];
      } else if (arr[i] > secondHighestVal) {
        secondHighestVal = arr[i];
      }
    }
    return highestVal * secondHighestVal;
  }
}