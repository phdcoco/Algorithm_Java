package deque;

import queue.IntQueue;

public class IntDeque {
    private int[] deque;
    private int capacity;
    private int front;
    private int rear;
    private int num;

    public static class EmptyIntDequeException extends RuntimeException {
        public EmptyIntDequeException() {}
    }

    public static class OverflowIntDequeException extends RuntimeException {
        public OverflowIntDequeException() {}
    }

    public IntDeque(int maxlen) {
        capacity = maxlen;
        deque = new int[capacity];
        front = rear = num = 0;
    }

    // 앞쪽 삽입
    public int addFirst(int x) {
        if (num >= capacity)
            throw new IntDeque.OverflowIntDequeException();
        front = (front - 1 + capacity) % capacity; // 다음 자리를 계산하고
        deque[front] = x; // 넣는다.
        num++;
        return x;
    }

    // 뒤쪽 삽입
    public int addLast(int x) {
        if (num >= capacity)
            throw new IntDeque.OverflowIntDequeException();
        deque[rear] = x; // 넣고
        rear = (rear + 1) % capacity; // rear를 다시 계산한다.
        num++;
        return x;
    }

    // 앞쪽 제거
    public int removeFirst() {
        if (num <= 0)
            throw new IntDeque.EmptyIntDequeException();

        int value = deque[front];
        front = (front + 1) % capacity;
        num--;
        return value;
    }

    // 뒤쪽 제거
    public int removeLast() {
        if (num <= 0)
            throw new IntDeque.EmptyIntDequeException();

        rear = (rear - 1 + capacity) % capacity;
        int value = deque[rear];
        num--;
        return value;
    }
}
