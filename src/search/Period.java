package search;// search.Period.java
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public final class Period implements Serializable {
    private static final long serialVersionUID = 1L;
    public Date start;
    public Date end;
    private void readObject(ObjectInputStream s)
            throws IOException, ClassNotFoundException {
        s.defaultReadObject();

        start = new Date(start.getTime());
        end = new Date(end.getTime());

        if (start.compareTo(end) > 0)
            throw new InvalidObjectException(start + "가" + end + "보다 늦다.");
    }
    public Period(Date start, Date end) {
        // 방어적 복사
        this.start = new Date(Objects.requireNonNull(start).getTime());
        this.end = new Date(Objects.requireNonNull(end).getTime());
        if (this.start.compareTo(this.end) > 0)
            throw new IllegalArgumentException(start + " after " + end);
    }

    @Override
    public String toString() {
        return "search.Period{" + "start=" + start + ", end=" + end + '}';
    }

    // 필요하면 readObject로 추가 방어 복사도 구현
}