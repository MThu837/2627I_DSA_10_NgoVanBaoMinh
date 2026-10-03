import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class Queue {
    static class MyQueue<T>{
        private Stack<T> stack1 = new Stack<>();
        private Stack<T> stack2 = new Stack<>();
        public void enqueue(T value){
            stack1.push(value);
        }
        public T dequeue(){
            if (stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
        public void print(){
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            System.out.println(stack2.peek());
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        MyQueue<Integer> queue = new MyQueue<>();
        for (int i = 0; i < q; i++){
            int type = scanner.nextInt();
            if (type == 1){
                int value = scanner.nextInt();
                queue.enqueue(value);
            }
            else if (type == 2){
                queue.dequeue();
            }
            else if (type == 3){
                queue.print();
            }
        }
        scanner.close();
    }
}
