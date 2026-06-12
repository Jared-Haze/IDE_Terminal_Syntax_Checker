import java.util.ArrayDeque;

public class MultiValuePrompts {

    //prompts/questions
    static String q1 = "Test Prompt - answer is 'cheese' or 'cheeses': ";
    static String q2 = "Test Prompt - answer is 'top' or 'tops' or 'Top': ";

    //answers list
    private ArrayDeque<String> answers1 = new ArrayDeque<>();

    public ArrayDeque<String> getAnswers1() {
        answers1.add("cheese");
        answers1.add("cheeses");
        return answers1;
    }

    private ArrayDeque<String> answers2 = new ArrayDeque<>();

    public ArrayDeque<String> getAnswers2() {
        answers2.add("top");
        answers2.add("tops");
        answers2.add("Top");
        return answers2;
    }

}
