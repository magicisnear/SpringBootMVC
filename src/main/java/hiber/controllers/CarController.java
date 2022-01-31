package hiber.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import hiber.model.Car;
import hiber.service.CarService;
import hiber.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
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

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping("cars/{id}")
    public String show(@PathVariable("id") int id, Model model) {
    model.addAttribute("car", carService.findOne(id));
        return  "show";
    }

    @GetMapping("/cars/new")
    public String newCar(@ModelAttribute("car") Car car) {
                 return "new";
    }

    @PostMapping("/cars")
    public String create(@ModelAttribute("car") Car car) {
        carService.add(car);
        return "redirect:/cars";
    }

    @GetMapping("/cars/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("car", carService.findOne(id));
        return "edit";
    }

    @PatchMapping("/cars/{id}")
    public String update(@ModelAttribute("car") Car car, @PathVariable("id") int id) {
        Car oldCar = carService.findOne(id);
        oldCar.setModel(car.getModel());
        oldCar.setSeries(car.getSeries());
        carService.update(oldCar);
        return "redirect:/cars";
    }

    @GetMapping("/cars/{id}/delete")
    public String delete(Model model, @PathVariable("id") int id) {
        model.addAttribute("car", carService.findOne(id));
        return "delete";
    }

    @DeleteMapping("/cars/{id}")
    public String deleteCar(@PathVariable("id") int id) {
        carService.delete(id);
        return "redirect:/cars";
    }

}
