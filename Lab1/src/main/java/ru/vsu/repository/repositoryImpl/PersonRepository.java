package ru.vsu.repository.repositoryImpl;

import org.joda.time.LocalDate;
import ru.vsu.comparator.comparatorImpl.*;
import ru.vsu.util.Configurator;
import ru.vsu.entity.entityImpl.Person;
import ru.vsu.searcher.searcherImpl.LastNamePersonChecker;
import ru.vsu.searcher.PersonChecker;
import ru.vsu.sorter.PersonSorter;


/**
 * Class for storing Persons objects.
 */
public class PersonRepository {
    private final int INITIAL_PERSON_CAP = 2;
    private Person[] repository;
    private int numberOfCurrentElements = 0;

    private PersonSorter sorter = Configurator.getInstance().getSorter(); //sorter

    public PersonRepository() {
        repository = new Person[INITIAL_PERSON_CAP];
    }

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
        int count = 0;
        for (Person person : repository) {
            if (!(person == null)) {
                allPersons[count] = person;
                count++;
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
            extendRepository();
        }
        repository[numberOfCurrentElements] = newPerson;
        numberOfCurrentElements++;
        trimToSize();//TODO:плохо или сойдет, проблема в том, что при расширении появляются нулы и соответственно нулпоинтеры
    }

    /**
     * Remove the Person element at the specified position in this repository.
     *
     * @param index Target index
     */
    public void remove(int index) {
        //если указанный индекс меньше чем количество элементов в массиве, значит есть что удалять, если больше то там нулл и удалять ничего не надо
        if (index < numberOfCurrentElements) {
            for (int i = index; i < repository.length - 1; i++) {
                repository[i] = repository[i + 1];
            }
            repository[repository.length - 1] = null;
            numberOfCurrentElements--;

        } else System.out.println("This index bigger than repository capacity");

    }

    /**
     * Method for extending repository
     */
    private void extendRepository() {
        int newLength = repository.length + repository.length / 2 + 1;
        Person[] newRepository = new Person[newLength];
        System.arraycopy(repository, 0, newRepository, 0, repository.length);
        this.repository = newRepository;

    }

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
     * Trims the capacity of target array instance to be the array's current size
     */
    public void trimToSize() {
        Person[] correctSize = new Person[numberOfCurrentElements];
        System.arraycopy(repository, 0, correctSize, 0, numberOfCurrentElements);
        this.repository = correctSize;

    }

    /**
     * Return repository capacity.
     *
     * @return capacity
     */
    public int getCapacity() {
        return repository.length;
    }

    public Person[] getRepository() {
        return repository;
    }

    public void setSorter(PersonSorter sorter) {
        this.sorter = sorter;
    }

    public void sortByLastName() {
        sorter.sort(repository, new PersonComparatorByLastName());
    }

    public void sortByAge() {
        sorter.sort(repository, new PersonComparatorByAge());
    }

    public void sortById() {
        sorter.sort(repository, new PersonComparatorById());
    }

    private PersonRepository search(PersonChecker checker, Object value) {
        PersonRepository result = new PersonRepository();
        for (int i = 0; i < repository.length; i++) {
            if (checker.check(repository[i], value))
                result.add(repository[i]);


        }
        return result;
    }

    public PersonRepository searchByLastName(String lastName) {
        return search(new LastNamePersonChecker(), lastName);
    }

    public PersonRepository searchByAge(Integer age) {
        return search((p, a) -> p.getAge().equals(a), age);
    }

    public PersonRepository searchByBirthDate(LocalDate date) {
        return search((p, a) -> p.getBirthday() != null && p.getBirthday().equals(a), date);
    }
}
