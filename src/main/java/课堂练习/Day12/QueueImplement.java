package 课堂练习.Day12;

import java.util.LinkedList;

public class QueueImplement implements MyQueue{
    private LinkedList<Integer> list;

    public QueueImplement() {
        list = new LinkedList<>();
    }

    @Override
    public void offer(int value) {
        list.addLast(value);
    }

    @Override
    public int poll() {
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
