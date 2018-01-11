
import java.util.ArrayList;

public class Stack<T> {

    private final ArrayList<T> lst;

    public Stack() {
        lst = new ArrayList();
    }

    public void push(T o) {
        lst.add(o);
    }

    public T pop() {
        return lst.remove(lst.size() - 1);
    }

    public T peek() {
        return lst.get(lst.size() - 1);
    }

    public boolean isEmpty() {
        return lst.isEmpty();
    }

    public int size() {
        return lst.size();
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i <= lst.size() - 1; i++) {
            s = lst.get(i) + "\n" + s;
        }
        return s;
    }
}
