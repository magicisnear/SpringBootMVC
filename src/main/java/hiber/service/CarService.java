package hiber.service;

import hiber.model.Car;

import java.util.List;

public interface CarService {
    public void add(Car car);
    public List<Car> listCar();
    public void delete(int id);
    public Car update( Car car );
    public Car findOne( long id );

}
