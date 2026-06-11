import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SequencedMap;

public class Main {
    public static void main(String[] args){
        
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
