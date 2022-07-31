package 课堂练习.Day12;

public interface MyQueue {
    void offer(int value);  //入队
    int poll();             //出队
    int peek();
    boolean isEmpty();
}
