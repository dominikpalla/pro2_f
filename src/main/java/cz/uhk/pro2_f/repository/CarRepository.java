package cz.uhk.pro2_f.repository;

import cz.uhk.pro2_f.model.Car;
import cz.uhk.pro2_f.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
