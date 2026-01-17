package stack;

public class GenericStack<T> {
    private Object[] stk; // 자바는 제네릭 배열 대신 Object[]을 쓰고 캐스팅
    private int capacity;
    private int ptr;

    // 예외 처리
    public static class EmptyStackException extends RuntimeException {
        public EmptyStackException() {}
    }

    public static class OverflowStackException extends RuntimeException {
        public OverflowStackException() {}
    }

    // 생성자
    public GenericStack(int maxlen) {
        this.ptr = 0;
        this.capacity = maxlen;
        try {
            this.stk = new Object[this.capacity];
        } catch (OutOfMemoryError e) {
            this.capacity = 0;
            this.stk = new Object[0];
        }
    }

    public T push(T x) {
        if (ptr >= capacity) throw new OverflowStackException();
        stk[ptr++] = x;
        return x;
    }

    public T pop() {
        if (ptr <= 0) throw new EmptyStackException();
        T value = (T) stk[--ptr];
        stk[ptr] = null;
        return value;
    }

    public T peek() {
        if (ptr <= 0) throw new EmptyStackException();
        return (T) stk[ptr - 1];
    }

    public void clear() {
        for (int i = 0; i < ptr; i++)
            stk[i] = null;
        ptr = 0;
    }

}
