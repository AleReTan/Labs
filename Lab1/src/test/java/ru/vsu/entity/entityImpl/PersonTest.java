package ru.vsu.entity.entityImpl;

import org.joda.time.LocalDate;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void testGetAge() {
        Person person = new Person("1","1","1",new LocalDate(2016,1,1));

        int expect = 1;

        int actual = person.getAge();

        assertEquals(expect,actual);
    }
}