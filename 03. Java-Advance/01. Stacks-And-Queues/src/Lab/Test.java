package Lab;

import java.util.ArrayDeque;

public class Test {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(13);
        stack.push(25);
        stack.push(8);
        stack.push(44);

        System.out.println(stack);

        int peekStack = stack.peek();
        System.out.println(peekStack);

        int pop = stack.pop();
        System.out.println(pop);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(13);
        queue.offer(25);
        queue.offer(8);
        queue.offer(44);

        System.out.println(queue);

        int peek = queue.peek();
        System.out.println(peek);

        int poll = queue.poll();
        System.out.println(poll);
    }
}
