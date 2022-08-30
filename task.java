import java.util.Map;
import java.util.Stack;

/**
 * 12. *+Написать программу, определяющую правильность расстановки скобок в
 * выражении.
 * Пример 1: a+(d*3) - истина
 * Пример 2: [a+(1*3) - ложь
 * Пример 3: [6+(3*3)] - истина
 * Пример 4: {a}[+]{(d*3)} - истина
 * Пример 5: <{a}+{(d*3)}> - истина
 * Пример 6: {a+]}{(d*3)} - ложь
 * 
 */
public class task {

    public static void main(String[] args) {

        String input = "a+(d*3)";  // истина
        //String input = "[a+(1*3)"; //ложь
        // String input = "[6+(3*3)]"; //истина
        // String input = "{a}[+]{(d*3)}";  //истина
        // String input = "<{a}+{(d*3)}>";  //истина
        // String input = "{a+]}{(d*3)}";   //ложь

        if (checkBracket(input) == 0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private static int checkBracket(String input) {
        //int lenghtStack = 0;
        int result = 0;
        Stack<Character> stackchar = new Stack<>();
        Map<Character, Integer> Brackets = Map.of(
                '[', 1,
                '{', 2,
                '(', 3,
                '<', 4,
                ']', -1,
                '}', -2,
                ')', -3,
                '>', -4);

        for (int i = 0; i < input.length(); i++) {
            char currentSimbol = input.charAt(i);
            if (Brackets.containsKey(currentSimbol)) {
                stackchar.push(currentSimbol);
                // System.out.println(stackchar);
                //lenghtStack++;
            }
        }
        while (!stackchar.empty()) {          //  я же правильно понимаю запись "делай пока не пусто ????"
            result += Brackets.get(stackchar.pop());
        }
        // System.out.print(lenghtStack);
        return result;
    }
    // сам решил вроде работает и я сам до этого додумался если скажите что все окей я охренею!!!
}
