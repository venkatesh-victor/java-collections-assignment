import java.util.ArrayList;
import java.util.Random;

public class DataAccessPerformance {
    static Random rand = new Random();

    public static void main(String[] args) {
        int[] capacities = {1_000, 10_000, 1_00_000, 10_00_000, 1_00_00_000};

        for(int capacity : capacities) {
            ArrayList<Integer> testList = new ArrayList<>(capacity);
            for (int i = 0; i < capacity; i++) {
                testList.add(rand.nextInt());
            }
            System.out.println("Measuring time taken for operation performed on " + capacity  + " capacity array list.");
            measureAddFirst(testList);
            measureAddLast(testList);
            measureRandomAccess(testList);
            measureSequentialAccess(testList);
            measureInsertOperation(testList);
            System.out.println("---------------------------------------------------------------------------------------");
        }


    }

    static void measureAddFirst(ArrayList<Integer> testList) {
        long startTime = System.nanoTime();
        testList.add(0, -1);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Time taken to add an element at the start " + duration + " nano secns");
    }

    static void measureAddLast(ArrayList<Integer> testList) {
        long startTime = System.nanoTime();
        testList.add(0);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Time taken to add element at the end " + duration + " nano secs");
    }

    static void measureRandomAccess(ArrayList<Integer> testList) {
        long startTime = System.nanoTime();
        int index = testList.size() - 1;
        int element = testList.get(index);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Last element: " + element);
        System.out.println("Time taken to access the last element: " + duration + " nano secs");
    }

    static void measureSequentialAccess(ArrayList<Integer> testList) {
        long startTime = System.nanoTime();
        for(int elem : testList) {
            //Just iterating through all the elements.
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Time taken to access every element sequentially: " + duration + " nano secs");
    }

    static void measureInsertOperation(ArrayList<Integer> testList) {
        int index = testList.size() - 1;
        long startTime = System.nanoTime();
        testList.add(index, 999);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Time take to insert an elemen at the second to last position is: " + duration + " nano secs");
    }


}
