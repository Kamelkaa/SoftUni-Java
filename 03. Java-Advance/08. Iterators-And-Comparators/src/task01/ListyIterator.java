package task01;

import java.util.List;

public class ListyIterator {
    private List<String> data; //списък с данни за обхождане
    private int index; //текущ индекс

    public ListyIterator(List<String> data) {
        this.data = data;
        if (!this.data.isEmpty()) {
            this.index = 0;
        } else {
            this.index = -1;
        }
    }


    //Move - should move an internal index position to the next index in the list,
    // the method should return true if it successfully moved and false if there is no next index.
    public boolean move() {
        if (this.index < this.data.size() - 1) {
            this.index++;
            return true;
        }
        return false;
    }


    //HasNext - should return true if there is a next index and false if the
    // index is already at the last element of the list.
    public boolean hasNext() {
        return this.index < this.data.size() - 1;
    }

    //•	Print - should print the element at the current internal index, calling Print on a collection
    // without elements should throw an appropriate exception with the message "Invalid Operation!".
    public void print() throws Exception {
        if (!this.data.isEmpty()) {
            System.out.println(this.data.get(this.index));
        } else {
            throw new Exception("Invalid Operation!");
            //System.out.println("Invalid Operation!");
        }
    }
}
