package ru.vsu.entity.entityImpl;

import org.joda.time.LocalDate;

/**
 * Person class.
 */
public class Person {
    //переменная для инкремментирвоания айдишника
    private static int tempId = 1; //TODO: почитать про uuid и uid и мб переделать на них
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthday;

    /**
     * Empty constructor.
     */
    public Person() {
        this.id=tempId;
        tempId++;

    }

    /**
     * Constructor with name.
     *
     * @param firstName  first name
     * @param middleName middle name
     * @param lastName   last name
     */
    public Person(String firstName, String middleName, String lastName) {
        this.id=tempId;
        tempId++;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    /**
     * Constructor with name, age and birth date.
     *
     * @param firstName  first name
     * @param middleName middle name
     * @param lastName   last name
     * @param birthday   birth date
     */
    public Person(String firstName, String middleName, String lastName, LocalDate birthday) {
        this.id=tempId;
        tempId++;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    /**
     * Constructor with name and age.
     *
     * @param firstName  first name
     * @param middleName middle name
     * @param lastName   last name
     */
    public Person(String firstName, String middleName, String lastName, int age) {
        this.id=tempId;
        tempId++;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Integer getAge() {
        if (birthday == null) return 0;
        else return LocalDate.now().getYear()-birthday.getYear();
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
                " id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", age=" + getAge() +
                '}';
    }
}
