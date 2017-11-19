package ru.vsu;

public class PersonRepository {
    private static final int INITIAL_PERSON_CAP = 2;
    private static Person[] repository = new Person[INITIAL_PERSON_CAP];
    private static int numberOfCurrentElements = 0;

    public static Person getPerson(int index) {
        if (index < repository.length) {
            return repository[index];
        } else {
            System.out.println("This index bigger than repository capacity");
            return null;
        }
    }

    public static Person[] getAllPersons() {
        Person[] allPersons = new Person[numberOfCurrentElements];
        int ind = 0;
        for (Person person : repository) {
            if (!(person == null)) {
                allPersons[ind]=person;
                ind++;
            }
        }
        return allPersons;
    }

    public static void add(Person newPerson) {
        if (numberOfCurrentElements + 1 > repository.length) {
            extendArray();
        }
        repository[numberOfCurrentElements] = newPerson;
        numberOfCurrentElements++;
    }

    public static void remove(int index) {
        if (index < repository.length) {
            for (int i = index; i < repository.length - 1; i++) {
                repository[i] = repository[i + 1];
            }
            repository[repository.length - 1] = null;
            numberOfCurrentElements--;
        } else System.out.println("This index bigger than repository capacity");

    }

    private static void extendArray() {
        int newLength = repository.length + (int) Math.ceil(repository.length / 2.0);
        Person[] newRepository = new Person[newLength];
        System.arraycopy(repository, 0, newRepository, 0, repository.length);
        repository = newRepository;
    }

    public static void debug() {
        System.out.println("Capacity = " + repository.length + " numberOfCurrentElements = " + numberOfCurrentElements);
        System.out.println();
    }

    public static void print() {
        for (Person person : repository) {
            if (!(person == null)) {
                System.out.print(person.toString() + " ");
            } else System.out.print("NULL ");
        }
        System.out.println();
    }

    public static int getCapacity() {
        return repository.length;
    }
}
