package cz.uhk.pro2_f.service;

import cz.uhk.pro2_f.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    List<Car> getAllCars();
    void saveCar(Car car);
}
