
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

    public int size() {
        return lst.size();
    }

    @Override
    public String toString() {
        String s = ""; // = "[";
        for (int i = 0; i <= lst.size() - 1; i++) {
            s = s + lst.get(i) + ",";
        }
        if (s.length() > 0) {
            s = s.substring(0, s.length() - 1); // delete the last ","
        }
        //s = s + "]";
        return s;
    }
}
