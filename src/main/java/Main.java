import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SequencedMap;

public class Main {
    public static void main(String[] args){
        
        

        SequencedMap<String, String> testDeck = new LinkedHashMap<>();
        SequencedMap<String, ArrayDeque<String>> mvpDeck = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);

        //greeting 
        System.out.println("Welcome to CLI syntax checker!");
        System.out.println("Pls choose which deck you'd like to study: ");
        System.out.println("1 = testDeck");
        System.out.println("2 = testDeck2");
        System.out.println("3 = testDeck3");
        System.out.println("4 = MultiValuePrompts");
        System.out.print("(enter # only): ");
        int chosenDeck = scanner.nextInt();
        scanner.nextLine();
        //deck chooser
        if (chosenDeck == 1) {
            testDeck.put(Prompts.q1, Prompts.a1);
            testDeck.put(Prompts.q2, Prompts.a2);
            testDeck.put(Prompts.q3, Prompts.a3);
            testDeck.put(Prompts.q4, Prompts.a4);
            testDeck.put(Prompts.q5, Prompts.a5);
            testDeck.put(Prompts.q6, Prompts.a6);
            testDeck.put(Prompts.q7, Prompts.a7);
            deckCycle(testDeck, scanner);
        } else if (chosenDeck == 2) {
            testDeck.put(Prompts2.q1, Prompts2.a1);
            testDeck.put(Prompts2.q2, Prompts2.a2);
            testDeck.put(Prompts2.q3, Prompts2.a3);
            testDeck.put(Prompts2.q4, Prompts2.a4);
            deckCycle(testDeck, scanner);
        } else if (chosenDeck == 3) {
            testDeck.put(Prompts3.q1, Prompts3.a1);
            testDeck.put(Prompts3.q2, Prompts3.a2);
            testDeck.put(Prompts3.q3, Prompts3.a3);
            testDeck.put(Prompts3.q4, Prompts3.a4);
            testDeck.put(Prompts3.q5, Prompts3.a5);
            deckCycle(testDeck, scanner);
        } else if (chosenDeck ==4) {
            MultiValuePrompts mvp = new MultiValuePrompts();
            mvpDeck.put(MultiValuePrompts.q1, mvp.getAnswers1());
            mvpDeck.put(MultiValuePrompts.q2, mvp.getAnswers2());
            deckCycleMultiValue(mvpDeck, scanner);
        } else {
            System.out.println("wrong input");
        }
        scanner.close();
        System.out.println("Ending program");

    }

    public static void deckCycle(SequencedMap<String, String> deck, Scanner scanner) {
        //loop through deck : key-value
        while (!deck.isEmpty()) {
            Map.Entry<String, String> card = deck.pollFirstEntry();

            System.out.println(card.getKey());
            String input = scanner.nextLine().strip();

            if (input.equals(card.getValue())) {
                System.out.println("correct!");
                System.out.println("");
            } else {
                System.out.println("wrong answer");
                System.out.println("the correct answer was: " + card.getValue());
                deck.putLast(card.getKey(), card.getValue());
                System.out.println("");
            }
        }
        System.out.println("congrats, you completed this deck!!!");
    }

    public static void deckCycleMultiValue(SequencedMap<String, ArrayDeque<String>> deck, Scanner scanner) {
        //loop through deck : key-value(s)
        while (!deck.isEmpty()) {
            Map.Entry<String, ArrayDeque<String>> card = deck.pollFirstEntry();

            System.out.println(card.getKey());
            String input = scanner.nextLine().strip();

            if (card.getValue().contains(input)) {
                System.out.println("correct!");
                System.out.println("");
            } else {
                System.out.println("wrong answer");
                System.out.println("the correct answers include: " + card.getValue());
                deck.putLast(card.getKey(), card.getValue());
                System.out.println("");
            }
        }
        System.out.println("congrats, you completed this deck!!!");
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

/* First attempt - leads to ConcurrentModificationException (you can't edit a collection while looping through it):
        for (Map.Entry<String, String> entry : testDeck.entrySet()) {
            System.out.println(entry.getKey());
            String input = scanner.nextLine();
            if (input.equals(entry.getValue())) {
                System.out.println("correct!");
            } else {
                System.out.println("wrong answer");
                System.out.println("the correct answer was: " + entry.getValue());
                Map.Entry<String, String> failedPrompt = testDeck.pollFirstEntry();
                testDeck.putLast(failedPrompt.getKey(), failedPrompt.getValue());
            }
        }
        System.out.println("congrats, you completed this deck!");
        */
        

        /* Origianl testing of answer checking, switched to using for-loop later...
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
        */

}
