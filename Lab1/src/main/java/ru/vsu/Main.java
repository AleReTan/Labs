package ru.vsu;

import org.joda.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("1", "1", "1");
        Person person2 = new Person("2", "2", "2");
        Person person3 = new Person("3", "3", "3");
        Person person4 = new Person("4", "4", "4");
        Person person5 = new Person("4", "4", "4", 24, new LocalDate(1993,7,27));

        PersonRepository.print();
        PersonRepository.debug();

        PersonRepository.add(person1);
        PersonRepository.print();
        PersonRepository.debug();

        PersonRepository.add(person2);
        PersonRepository.print();
        PersonRepository.debug();

        PersonRepository.add(person3);
        PersonRepository.print();
        PersonRepository.debug();

        PersonRepository.add(person4);
        PersonRepository.print();
        PersonRepository.debug();

        PersonRepository.remove(5);
        PersonRepository.print();
        PersonRepository.debug();

        System.out.println(person5.toString());
    }
}
