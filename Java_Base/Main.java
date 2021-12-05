import java.util.List;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    String panda = "panda  ";
    String fish = " fish ";
    String cat = "CAT ";

    List<String> animals = List.of(panda, fish, cat);
    animals.stream().forEach(s -> System.out.println(s.trim()));

    findNoOfVowAndConsonant("abcdefghi");
    findNoOfVowAndConsonant("aovnwe vowebadf");
  }

  public static boolean isPalindrome(String string) {
    String normalized = string.toLowerCase();
    return IntStream.range(0, normalized.length()/2).allMatch(i -> normalized.charAt(i) == normalized.charAt(normalized.length()-1-i));
  }

  public static void findNoOfVowAndConsonant(String sentence) {
    System.out.println("No. of vowels : " + sentence.replaceAll("(?i)[^aeiou]", "").length());
    System.out.println("No. of consonants : " + sentence.replaceAll("(?i)[^[a-z&&[^aeiou]]]", "").length());
    //sentence.toLowerCase().chars().filter(Character::isAlphabetic).boxed().filter(c -> "aeiou".indexOf(c) != -1).count();
  }
}