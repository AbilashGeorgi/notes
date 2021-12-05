import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class Parantheses {

  public static Map.Entry<Character, Character> SQUARE = Pair.of('[', ']');
  public static Map.Entry<Character, Character> SMALL = Pair.of('(', ')');
  public static Map.Entry<Character, Character> ANGLE = Pair.of('<', '>');


  public static void main(String[] args) {
    System.out.println(isParanthesesMatching("<>"));
    System.out.println(isParanthesesMatching("[<a>b]"));
    System.out.println(isParanthesesMatching("<]>"));
    System.out.println(isParanthesesMatching("adsf[<>"));
    System.out.println(isParanthesesMatching("<>a()"));
  }

  private static boolean isParanthesesMatching(String argument) {
    Stack<Character> openBracketStack = new Stack<>();
    Stack<Character> closeBracketStack = new Stack<>();
    boolean isMatching = true;

    argument.chars().mapToObj(i -> (char) i)
    .filter(Parantheses::isBracketCharacter)
    .filter(Parantheses::isOpeningCharacter)
    .forEach(openBracketStack::add);

    argument.chars().mapToObj(i -> (char) i)
    .filter(Parantheses::isBracketCharacter)
    .filter(Parantheses::isClosingCharacter)
    .forEach(closeBracketStack::add);

    while (!closeBracketStack.isEmpty()) {
      Character temp = closeBracketStack.pop();
      if (openBracketStack.isEmpty() || !isMatching(openBracketStack.pop(), temp)) {
        isMatching = false;
        break;
      }
    }

    if (!openBracketStack.isEmpty()) {
      isMatching = false;
    }
    return isMatching;
  }

  private static boolean isBracketCharacter(Character character) {
    if (SQUARE.getKey() == character || SQUARE.getValue() == character)
      return true;
    if (SMALL.getKey() == character || SMALL.getValue() == character)
      return true;
    if (ANGLE.getKey() == character || ANGLE.getValue() == character)
      return true;
    return false;
  }

  private static boolean isOpeningCharacter(Character character) {
    return !isClosingCharacter(character);
  }

  private static boolean isClosingCharacter(Character character) {
    if (SQUARE.getValue() == character
        || SMALL.getValue() == character
        || ANGLE.getValue() == character) {
     return true;     
    }
    return false;
  }

  private static boolean isMatching(Character open, Character close) {
    if (open == SQUARE.getKey() && close == SQUARE.getValue())
      return true;
    if (open == SMALL.getKey() && close == SMALL.getValue())
      return true;
    if (open == ANGLE.getKey() && close == ANGLE.getValue())
      return true;
    return false;
  }
}
