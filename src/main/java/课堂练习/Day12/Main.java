package 课堂练习.Day12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        printQueue();
        printStack();
    }

    private static void printQueue(){
        Queue<Integer> queue = new LinkedList<>();
        MyQueue myQueue = new QueueImplement();
        for (int i = 0; i < 10; i++) {
            queue.offer(i);
            myQueue.offer(i);
            if (i%2 == 0){
                queue.poll();
                myQueue.poll();
            }
        }
        System.out.println("queue: ");
        while(!queue.isEmpty()){
            System.out.print(queue.poll() + " ");
        }
        System.out.println("\nmyQueue: ");
        while(!myQueue.isEmpty()){
            System.out.print(myQueue.poll() + " ");
        }
        System.out.println();
    }

    private static void printStack(){
        Stack<Integer> stack = new Stack<>();
        MyStack myStack = new StackImplement();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
            myStack.push(i);
            if (i%2 == 0){
                stack.pop();
                myStack.pop();
            }
        }
        System.out.println("stack: ");
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println("\nmyStack: ");
        while(!myStack.isEmpty()){
            System.out.print(myStack.pop() + " ");
        }
        System.out.println();
    }
}
