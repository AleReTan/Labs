package ru.vsu.repository.repositoryImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.LocalDate;
import ru.vsu.comparator.comparatorImpl.*;
import ru.vsu.entity.entityImpl.Person;
import ru.vsu.repository.Repository;
import ru.vsu.repository.RepositoryAbstract;
import ru.vsu.searcher.Checker;
import ru.vsu.searcher.searcherImpl.LastNamePersonChecker;
import ru.vsu.util.Configurator;

public class PersonRepository extends RepositoryAbstract<Person> implements Repository<Person> {

    private static final Logger LOGGER = LogManager.getLogger(PersonRepository.class.getName());

    public PersonRepository() {
        repository = new Person[INITIAL_SIZE];
        size = INITIAL_SIZE;
        capacity = 0;
        sorter = Configurator.getInstance().getPersonSorter();
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


    private PersonRepository search(Checker<Person> checker, Object value) {
        PersonRepository result = new PersonRepository();
        for (int i = 0; i < repository.length; i++) {
            if (checker.check((Person) repository[i], value))
                result.add((Person) repository[i]);
        }
        return result;
    }

    public PersonRepository searchByLastName(String lastName) {
        LOGGER.debug("This method was used");
        return search(new LastNamePersonChecker(), lastName);
    }

    public PersonRepository searchByAge(Integer age) {
        LOGGER.debug("This method was used");
        return search((p, a) -> p.getAge().equals(a), age);
    }

    public PersonRepository searchByBirthDate(LocalDate date) {
        LOGGER.debug("This method was used");
        return search((p, a) -> p.getBirthday() != null && p.getBirthday().equals(a), date);
    }

}
