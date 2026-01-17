package stack;

import java.sql.SQLOutput;

public class IntStack {
    private int[] stk; // 스택 배열
    private int capacity; // 스택 용량
    private int ptr; // 스택 포인터, 0부터 시작, 가득 차면 capacity와 같다.

    // 예외 처리
    public class EmptyStackException extends RuntimeException {
        public EmptyStackException() {}
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {}
    }

    // 생성자
    public IntStack(int maxlen) {
        ptr = 0;
        capacity = maxlen;
        try {
            stk = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public int push(int x) throws OverflowIntStackException {
        if (ptr >= capacity)
            throw new OverflowIntStackException();
        return stk[ptr++] = x;
    }

    public int pop() throws EmptyStackException {
        if (ptr <= 0)
            throw new EmptyStackException();
        return stk[--ptr];
    }

    // 맨 위 값 출력
    public int peek() throws EmptyStackException {
        if (ptr <= 0)
            throw new EmptyStackException();
        return stk[ptr - 1];
    }

    // 스택 모든 데이터 삭제
    public void clear() {
        ptr = 0; // 배열 요솟값을 변경할 필요가 없다.
    }

    // 특정 값의 인덱스 반환, 없으면 -1 반환
    public int indexOf(int x) {
        for (int i = ptr - 1; i >= 0; i--)
            if (stk[i] == x)
                return i;
        return -1;
    }

    // 스택의 용량 반환
    public int getCapacity() {
        return capacity;
    }

    // 스택에 쌓여있는 데이터 개수 반환
    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr <=0;
    }

    public boolean isFull() {
        return ptr >= capacity;
    }

    // 스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
    public void dump() {
        if (ptr <= 0)
            System.out.println("스택이 비어 있습니다.");
        else {
            for (int i = 0; i < ptr; i++) {
                System.out.println(stk[i] + " ");
            }
            System.out.println();
        }
    }
}

