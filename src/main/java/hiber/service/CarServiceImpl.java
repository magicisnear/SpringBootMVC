package hiber.service;
import hiber.model.Car;
import hiber.repository.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarDao cardao;

    @Override
    @Transactional
    public void add(Car car) {
       cardao.add(car);
    }

    @Override
    @Transactional
    public void delete(int id) {
        cardao.delete(id);
    }

    @Override
    @Transactional
    public Car update(Car car) {
        return cardao.update(car);
    }

    @Override
    @Transactional
    public Car findOne(long id) {
        return cardao.findOne(id);
    }

    @Override
    @Transactional
    public List<Car> listCar() {
     return cardao.listCar();

    }


}
