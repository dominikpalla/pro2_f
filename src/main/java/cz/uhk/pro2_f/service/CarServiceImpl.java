package cz.uhk.pro2_f.service;

import cz.uhk.pro2_f.model.Car;
import cz.uhk.pro2_f.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }
}
