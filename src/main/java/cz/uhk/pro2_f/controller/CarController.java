package cz.uhk.pro2_f.controller;

import cz.uhk.pro2_f.model.Car;
import cz.uhk.pro2_f.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "cars_list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("car", new Car());
        return "cars_add";
    }

    @PostMapping("/add")
    public String addSave(@ModelAttribute Car car) {
        carService.saveCar(car);
        return "redirect:/cars/";
    }
}
