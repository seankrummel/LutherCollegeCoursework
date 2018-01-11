
import java.util.ArrayList;

public class Stack<T> {

    private ArrayList<T> lst;

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
        return lst.size() == 0;
    }
}
