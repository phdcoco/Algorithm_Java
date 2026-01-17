package queue;

// 링 버퍼
public class IntQueue {
    private int[] que; // 큐 배열
    private int capacity; // 큐 용량
    private int front; // 맨 앞의 요소 커서
    private int rear; // 맨 뒤의 요소 커서
    private int num; // 현재 데이터 개수, front = rear 일 때 큐가 비어있는지, 다 찼는지 알 수 없으.

    // 예외
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() { }
    }

    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() { }
    }

    // 생성자
    public IntQueue(int maxlen) {
        num = front = rear = 0;
        capacity = maxlen;
        try {
            que = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public int enque(int x) throws OverflowIntQueueException {
        if (num >= capacity)
            throw new OverflowIntQueueException();
        que[rear++] = x;
        num++;
        if (rear == capacity)
            rear = 0; // 맨 처음으로 돌아감
        return x;
    }

    public int deque() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();
        int x = que[front++];
        num--;
        if (front == capacity)
            front = 0; // 맨 처음으로 돌아감
        return x;
    }

    public int peek() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();
        return que[front];
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % capacity; // i는 0, 1, 2, 3... 이지만 idx는 7, 8, 9, 10, 11, 0, 1 ...
            if (que[idx] == x)
                return idx;
        }
        return -1;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= capacity;
    }

    public void dump() {
        if (num <= 0)
            System.out.println("큐가 비어 있습니다.");
        else {
            for (int i = 0; i < num; i++) {
                System.out.println(que[(i + front) % capacity] + " ");
            }
            System.out.println();
        }
    }
}
