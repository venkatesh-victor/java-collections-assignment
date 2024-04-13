import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}

class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }
}

class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.getAge(), p2.getAge());
    }
}

public class CustomComparatorDemo {
    static List<Person> personList = new ArrayList<>();

    public static void main(String []args) {
        personList.add(new Person("Chris Evans", 39));
        personList.add(new Person("Brad Pitt", 42));
        personList.add(new Person("Ryan Gosling", 45));
        personList.add(new Person("Tom Cruise", 54));
        personList.add(new Person("Leonardo DeCaprio", 47));

        System.out.println("Persons in the list:-");
        show();

        System.out.println("Persons sorted by name:- ");
        Collections.sort(personList, new NameComparator());
        show();

        System.out.println("Persons sorted by age:-");
        Collections.sort(personList, new AgeComparator());
        show();
    }

    static void show() {
        for(Person person : personList) {
            System.out.println("Name: " + person.getName() + "  Age: " + person.getAge());
        }
        System.out.println("----------------------------------------");
    }
}
