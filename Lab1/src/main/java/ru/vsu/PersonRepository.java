package ru.vsu;

/**
 * Class for storing Persons objects.
 */
public class PersonRepository {
    private static final int INITIAL_PERSON_CAP = 2;
    private static Person[] repository = new Person[INITIAL_PERSON_CAP];
    private static int numberOfCurrentElements = 0;

    /**
     * Returns the Person element at the specified position in this repository.
     *
     * @param index Target index
     * @return Person object
     */
    public static Person getPerson(int index) {
        if (index < repository.length) {
            return repository[index];
        } else {
            System.out.println("This index bigger than repository capacity");
            return null;
        }
    }

    /**
     * Returns all elements.
     *
     * @return Array of Persons's
     */
    public static Person[] getAllPersons() {
        Person[] allPersons = new Person[numberOfCurrentElements];
        int ind = 0;
        for (Person person : repository) {
            if (!(person == null)) {
                allPersons[ind] = person;
                ind++;
            }
        }
        return allPersons;
    }

    /**
     * Add the Person element into repository.
     *
     * @param newPerson Object Person for adding
     */
    public static void add(Person newPerson) {
        if (numberOfCurrentElements + 1 > repository.length) {
            extendArray();
        }
        repository[numberOfCurrentElements] = newPerson;
        numberOfCurrentElements++;
    }

    /**
     * Remove the Person element at the specified position in this repository.
     *
     * @param index Target index
     */
    public static void remove(int index) {
        if (index < repository.length) {
            for (int i = index; i < repository.length - 1; i++) {
                repository[i] = repository[i + 1];
            }
            repository[repository.length - 1] = null;
            numberOfCurrentElements--;
        } else System.out.println("This index bigger than repository capacity");

    }

    /**
     * Method for extending repository.
     */
    private static void extendArray() {
        int newLength = repository.length + (int) Math.ceil(repository.length / 2.0);
        Person[] newRepository = new Person[newLength];
        System.arraycopy(repository, 0, newRepository, 0, repository.length);
        repository = newRepository;
    }
    //TODO:Delete debug method

    /**
     * Utility method for debugging.
     */
    public static void debug() {
        System.out.println("Capacity = " + repository.length + " numberOfCurrentElements = " + numberOfCurrentElements);
        System.out.println();
    }

    /**
     * Method for printing elements from repository.
     */
    public static void print() {
        for (Person person : repository) {
            if (!(person == null)) {
                System.out.print(person.toString() + " ");
            } else System.out.print("NULL ");
        }
        System.out.println();
    }

    /**
     * Return repository capacity.
     *
     * @return capacity
     */
    public static int getCapacity() {
        return repository.length;
    }
}
