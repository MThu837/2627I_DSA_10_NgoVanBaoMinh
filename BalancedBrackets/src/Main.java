import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Stack<String> box = new Stack<>();
        String s = scanner.next();
        Map<String, String> match = new HashMap<>();
        match.put("}", "{");
        match.put(")", "(");
        match.put("]", "[");
        String k = "{[(";
        boolean valid = true;

        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (k.indexOf(s.charAt(i)) != -1) {
                box.push(c);
            } else {
                if (box.isEmpty() || !box.peek().equals(match.get(c))) {
                    valid = false;
                    break;
                }
                box.pop();
            }
        }

        if (valid && box.isEmpty()) {
            System.out.println("Hợp lệ");
        } else {
            System.out.println("Không hợp lệ");
        }
    }
}