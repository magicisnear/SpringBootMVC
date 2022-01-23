package hiber.repository;

import hiber.model.Car;

import java.util.List;

public interface CarDao {
    public void add(Car car);
    public List<Car> listCar();
    public void delete(int id);
    public Car update( Car car );
    public Car findOne( long id );
}
