package ru.vsu;

import org.joda.time.LocalDate;
import ru.vsu.Entities.Person;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        PersonRepository personRepository = new PersonRepository();
        //Creating new objects Person
        Person person1 = new Person("1", "1", "1");
        Person person2 = new Person("2", "2", "2");
        Person person3 = new Person("3", "3", "3");
        Person person4 = new Person("4", "4", "4");
        Person person5 = new Person("4", "4", "4",  new LocalDate(1993, 7, 27));

        personRepository.print();
        personRepository.debug();

        personRepository.add(person1);
        personRepository.print();
        personRepository.debug();

        personRepository.add(person2);
        personRepository.print();
        personRepository.debug();

        personRepository.add(person3);
        personRepository.print();
        personRepository.debug();

        personRepository.add(person4);
        personRepository.print();
        personRepository.debug();

        personRepository.remove(2);
        personRepository.print();
        personRepository.debug();

        personRepository.remove(0);
        personRepository.print();
        personRepository.debug();

        personRepository.trimToSize();
        personRepository.print();
        personRepository.debug();

        personRepository.add(person1);
        personRepository.print();
        personRepository.debug();

        System.out.println(Arrays.toString(personRepository.search(2)));
        System.out.println(person5.toString());
    }
}
