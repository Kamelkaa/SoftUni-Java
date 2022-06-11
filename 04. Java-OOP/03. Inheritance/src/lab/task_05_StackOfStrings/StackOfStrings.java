package lab.task_05_StackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    //⦁	Private field: data: ArrayList<String>
    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    //⦁	Public method: push(String item): void
    public void push(String item) {
        this.data.add(item);
    }

    //⦁	Public method: pop(): String
    public String pop() {
        if (!this.data.isEmpty()) {
            return this.data.remove(this.data.size() - 1);
        }
        return null;
    }

    //⦁	Public method: peek(): String
    public String peek() {
        return this.data.get(this.data.size() - 1);
    }

    //⦁	Public method: isEmpty(): boolean
    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
