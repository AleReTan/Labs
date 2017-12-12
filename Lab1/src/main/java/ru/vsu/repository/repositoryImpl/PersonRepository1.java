package ru.vsu.repository.repositoryImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.LocalDate;
import ru.vsu.comparator.comparatorImpl.*;
import ru.vsu.entity.entityImpl.Car;
import ru.vsu.entity.entityImpl.Person;
import ru.vsu.repository.Repository;
import ru.vsu.repository.RepositoryAbstract;
import ru.vsu.searcher.Checker;
import ru.vsu.searcher.searcherImpl.LastNamePersonChecker;
import ru.vsu.util.Configurator;

public class PersonRepository1 extends RepositoryAbstract<Person> implements Repository<Person> {

    private static final Logger LOGGER = LogManager.getLogger(PersonRepository.class.getName());

    public PersonRepository1() {
        repository = new Car[INITIAL_SIZE];
        size = INITIAL_SIZE;
        capacity = 0;
        sorter = Configurator.getInstance().getCarSorter();
    }

    public void sortById() {
        sorter.sort(repository, new PersonComparatorById());
    }

    public void sortByAge() {
        sorter.sort(repository, new PersonComparatorByAge());
    }

    public void sortByLastName() {
        sorter.sort(repository, new PersonComparatorByLastName());
    }


    private PersonRepository1 search(Checker<Person> checker, Object value) {
        PersonRepository1 result = new PersonRepository1();
        for (int i = 0; i < repository.length; i++) {
            if (checker.check((Person) repository[i], value))
                result.add((Person) repository[i]);
        }
        return result;
    }

    public PersonRepository1 searchByLastName(String lastName) {
        LOGGER.debug("This method was used");
        return search(new LastNamePersonChecker(), lastName);
    }

    public PersonRepository1 searchByAge(Integer age) {
        LOGGER.debug("This method was used");
        return search((p, a) -> p.getAge().equals(a), age);
    }

    public PersonRepository1 searchByBirthDate(LocalDate date) {
        LOGGER.debug("This method was used");
        return search((p, a) -> p.getBirthday() != null && p.getBirthday().equals(a), date);
    }

}
