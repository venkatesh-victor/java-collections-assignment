import java.util.ArrayList;

class CircularBuffer {
    int size;
    ArrayList<String> list;
    int index;

    CircularBuffer(int size) {
        this.size = size;
        list = new ArrayList<>(size);
    }

    public void addMessage(String s) {
        if(list.size() >= size) {
            list.set(index, s);
        } else {
            list.add(s);
        }
        index = (index + 1) % size;
    }

    public void printMessage() {
        for(String msg: list) {
            System.out.println(msg);
        }
    }
}

public class CircularBufferDemo {
    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(4);
        cb.addMessage("Hello World!");
        cb.addMessage("Hello, java.");
        cb.addMessage("I like java.");
        cb.addMessage("Java is oop language.");
        cb.printMessage();
        System.out.println();
        cb.addMessage("Java is platform independent language.");
        cb.addMessage("Java powers 2 billion android devices in the world.");
        cb.printMessage();

    }
}
