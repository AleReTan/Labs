package ru.vsu.repository.repositoryImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.vsu.comparator.comparatorImpl.CarComporatorById;
import ru.vsu.comparator.comparatorImpl.CarComporatorByPrice;
import ru.vsu.comparator.comparatorImpl.CarComporatorByYear;
import ru.vsu.entity.entityImpl.Car;
import ru.vsu.repository.Repository;
import ru.vsu.repository.RepositoryAbstract;
import ru.vsu.searcher.Checker;
import ru.vsu.util.Configurator;

public class CarRepository extends RepositoryAbstract<Car> implements Repository<Car> {

    private static final Logger LOGGER = LogManager.getLogger(PersonRepository.class.getName());

    public CarRepository() {
        repository = new Car[INITIAL_SIZE];
        size = INITIAL_SIZE;
        capacity = 0;
        sorter = Configurator.getInstance().getCarSorter();
    }

    public void sortById() {
        sorter.sort(repository, new CarComporatorById());
    }

    public void sortByPrice() {
        sorter.sort(repository, new CarComporatorByPrice());
    }

    public void sortByYear() {
        sorter.sort(repository, new CarComporatorByYear());
    }


    private CarRepository search(Checker<Car> checker, Object value) {
        CarRepository result = new CarRepository();
        for (int i = 0; i < repository.length; i++) {
            if (checker.check((Car) repository[i], value))
                result.add((Car) repository[i]);
        }
        return result;
    }

    public CarRepository searchByColor(String color) {
        LOGGER.debug("This method was used");
        return search((p, a) -> p.getColor().equals(a), color);
    }

    public CarRepository searchByPrice(Integer price) {
        LOGGER.debug("This method was used");
        return search((p, a) -> Integer.valueOf(p.getPrice()).equals(a), price);
    }

    public CarRepository searchByManufactureYear(Integer year) {
        LOGGER.debug("This method was used");
        return search((p, a) -> Integer.valueOf(p.getCarYearManufacture()).equals(a), year);
    }

}
