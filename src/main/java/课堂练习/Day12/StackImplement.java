package 课堂练习.Day12;

import java.util.LinkedList;

public class StackImplement implements MyStack{
    private LinkedList<Integer> list;

    public StackImplement() {
        list = new LinkedList<>();
    }

    @Override
    public void push(int value) {
        list.addFirst(value);
    }

    @Override
    public int pop() {
        return list.removeFirst();
    }

    @Override
    public int peek() {
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }
}
