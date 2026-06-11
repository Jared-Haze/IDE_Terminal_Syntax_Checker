import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SequencedMap;

public class Main {
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);

        SequencedMap<String, String> testDeck = new LinkedHashMap<>();
        testDeck.put(Prompts.q1, Prompts.a1);
        testDeck.put(Prompts.q2, Prompts.a2);
        testDeck.put(Prompts.q3, Prompts.a3);

        String deckKey1 = testDeck.sequencedKeySet().getFirst();
        String deckValue1 = testDeck.sequencedValues().getFirst();

        System.out.println(deckKey1);
        String input = scanner.nextLine();

        if (input.equals(deckValue1)) {
            System.out.println("correct!");
        } else {
            System.out.println("wrong");
        }

        System.out.println("end of test.");
    }

    public static void testDeckFirst() {
        SequencedMap<String, String> deck1 = new LinkedHashMap<>();

        deck1.put(Prompts.q1, Prompts.a1);
        deck1.put(Prompts.q2, Prompts.a2);
        deck1.put(Prompts.q3, Prompts.a3);

        System.out.println(deck1.entrySet());

        Map.Entry<String, String> card = deck1.pollFirstEntry();
        System.out.println(deck1.entrySet());

        deck1.putLast(card.getKey(), card.getValue());
        System.out.println(deck1.entrySet());
    }
}
