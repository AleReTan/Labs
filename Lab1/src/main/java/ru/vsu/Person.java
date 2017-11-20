package ru.vsu;

import org.joda.time.LocalDate;

/**
 * Person class.
 */
public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private LocalDate birthday;

    /**
     * Empty constructor.
     */
    public Person() {

    }

    /**
     * Constructor with name.
     *
     * @param firstName first name
     * @param middleName middle name
     * @param lastName last name
     */
    public Person(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    /**
     * Constructor with name, age and birth date.
     *
     * @param firstName first name
     * @param middleName middle name
     * @param lastName last name
     * @param age age
     * @param birthday birth date
     */
    public Person(String firstName, String middleName, String lastName, int age, LocalDate birthday) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.birthday = birthday;
    }

    /**
     * Constructor with name and age.
     *
     * @param firstName first name
     * @param middleName middle name
     * @param lastName last name
     * @param age age
     */
    public Person(String firstName, String middleName, String lastName, int age) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return Person.class.getSimpleName() +
                " firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", birthday=" + birthday + ";";
    }
}
