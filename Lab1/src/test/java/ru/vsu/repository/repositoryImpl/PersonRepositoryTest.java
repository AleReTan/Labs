package ru.vsu.repository.repositoryImpl;

import org.joda.time.LocalDate;
import org.junit.Test;
import ru.vsu.entity.entityImpl.Person;

import static org.junit.Assert.*;

@SuppressWarnings("Duplicates")
public class PersonRepositoryTest {

    private Person person1 = new Person("1", "1", "1", new LocalDate(2016, 1, 1));
    private Person person2 = new Person("2", "2", "2", new LocalDate(2015, 2, 2));
    private Person person3 = new Person("3", "3", "2", new LocalDate(2014, 3, 3));

    @Test
    public void testGetPerson() {
        PersonRepository personRepository = new PersonRepository();
        personRepository.add(person1);

        Person expected = person1;

        Person actual = personRepository.get(0);

        assertEquals(expected, actual);
    }

    @Test
    public void testAddOnePerson() {
        PersonRepository personRepository = new PersonRepository();
        Person[] expected = new Person[1];
        expected[0] = person1;

        personRepository.add(person1);
        Person[] actual = personRepository.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddTwoPerson() {
        PersonRepository personRepository = new PersonRepository();
        Person[] expected = new Person[2];
        expected[0] = person1;
        expected[1] = person2;

        personRepository.add(person1);
        personRepository.add(person2);
        Person[] actual = personRepository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemove() {
        PersonRepository personRepository = new PersonRepository();
        Person[] expected = new Person[0];

        personRepository.add(person1);
        personRepository.remove(0);
        Person[] actual = personRepository.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenThereAreTwoPersonRemoveLast() {
        PersonRepository personRepository = new PersonRepository();
        Person[] expected = new Person[1];
        expected[0] = person1;

        personRepository.add(person1);
        personRepository.add(person2);
        personRepository.remove(1);
        Person[] actual = personRepository.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenThereAreTwoPersonRemoveFirst() {
        PersonRepository personRepository = new PersonRepository();
        Person[] expected = new Person[1];
        expected[0] = person2;

        personRepository.add(person1);
        personRepository.add(person2);
        personRepository.remove(0);
        Person[] actual = personRepository.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortByLastName() {
        PersonRepository personRepository = new PersonRepository();
        Person[] expected = new Person[2];
        expected[0] = person1;
        expected[1] = person2;


        personRepository.add(person2);
        personRepository.add(person1);
        personRepository.sortByLastName();
        Person[] actual = personRepository.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortByAge() {
        PersonRepository personRepository = new PersonRepository();
        Person[] expected = new Person[2];
        expected[0] = person1;
        expected[1] = person2;


        personRepository.add(person2);
        personRepository.add(person1);
        personRepository.sortByAge();
        Person[] actual = personRepository.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortById() {
        PersonRepository personRepository = new PersonRepository();
        Person[] expected = new Person[2];
        expected[0] = person1;
        expected[1] = person2;


        personRepository.add(person2);
        personRepository.add(person1);
        personRepository.sortById();
        Person[] actual = personRepository.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByLastName() {
        PersonRepository personRepository = new PersonRepository();
        Person[] expected = new Person[1];
        expected[0] = person1;

        personRepository.add(person2);
        personRepository.add(person1);
        personRepository.sortByLastName();
        Person[] actual = personRepository.searchByLastName("1").getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByLastNameWithTwoEntry() {
        PersonRepository personRepository = new PersonRepository();
        Person[] expected = new Person[2];
        expected[0] = person2;
        expected[1] = person3;

        personRepository.add(person2);
        personRepository.add(person1);
        personRepository.add(person3);
        personRepository.sortByLastName();
        Person[] actual = personRepository.searchByLastName("2").getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByAge() {
        PersonRepository personRepository = new PersonRepository();
        Person[] expected = new Person[1];
        expected[0] = person1;

        personRepository.add(person2);
        personRepository.add(person1);
        Person[] actual = personRepository.searchByAge(1).getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByBirthDate() {
        PersonRepository personRepository = new PersonRepository();
        Person[] expected = new Person[1];
        expected[0] = person1;

        personRepository.add(person2);
        personRepository.add(person1);
        Person[] actual = personRepository.searchByBirthDate(new LocalDate(2016,1,1)).getAll();

        assertArrayEquals(expected, actual);
    }
}