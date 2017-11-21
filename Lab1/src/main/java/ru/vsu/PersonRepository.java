package ru.vsu;

import java.util.Arrays;

/**
 * Class for storing Persons objects.
 */
public class PersonRepository {
    private final int INITIAL_PERSON_CAP = 2;
    private Person[] repository = new Person[INITIAL_PERSON_CAP];
    private int numberOfCurrentElements = 0;

    /**
     * Returns the Person element at the specified position in this repository.
     *
     * @param index Target index
     * @return Person object
     */
    public Person getPerson(int index) {
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
    public Person[] getAllPersons() {
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
    public void add(Person newPerson) {
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
    public void remove(int index) {
        //если указанный индекс меньше чем количество элементов в массиве, значит есть что удалять, если больше то там нулл и удалять ничего не надо
        if (index < numberOfCurrentElements) {
            //if (repository[index]==null) return;
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
    private void extendArray() {
        int newLength = repository.length + (int) Math.ceil(repository.length / 2.0);
        Person[] newRepository = new Person[newLength];
        System.arraycopy(repository, 0, newRepository, 0, repository.length);
        this.repository = newRepository;
    }
    //TODO:Delete debug method

    /**
     * Utility method for debugging.
     */
    public void debug() {
        System.out.println("Capacity = " + repository.length + " numberOfCurrentElements = " + numberOfCurrentElements);
        System.out.println();
    }

    /**
     * Method for printing elements from repository.
     */
    public void print() {
        for (Person person : repository) {
            if (!(person == null)) {
                System.out.print(person.toString() + " ");
            } else System.out.print("NULL ");
        }
        System.out.println();
    }

    /**
     * Search by id
     *
     * @param id target id
     * @return array of matching persons
     */
    public Person[] search(int id) {
        Person[] match = new Person[numberOfCurrentElements];
        int i = 0;
        for (Person person : repository) {
            if (person.getId() == id) match[i] = person;//TODO:спросить, мб здесь просто i++ и удалить некст строку
            i++;
        }
        trimToSize(match);
        return match;
    }

    /**
     * rims the capacity of target array instance to be the array's current size
     * @param rep target array
     * @return
     */
    public Person[] trimToSize(Person[] rep) { //TODO: понять, хорошо ли применять его к массиву, или все таки к самому репозиторию
        Person[] correctSize = new Person[numberOfCurrentElements];
        System.arraycopy(rep, 0, correctSize, 0, numberOfCurrentElements);
        return correctSize;
    }

    /**
     * Return repository capacity.
     *
     * @return capacity
     */
    public int getCapacity() {
        return this.repository.length;
    }
}
