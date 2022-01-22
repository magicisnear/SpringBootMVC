package hiber.controllers;

import hiber.model.Car;
import hiber.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping(value = "/cars")
    public String CarList(Model model) {
        List<Car> newCar = carService.listCar();
        model.addAttribute("carList", newCar);
        return "carList";
    }

}
