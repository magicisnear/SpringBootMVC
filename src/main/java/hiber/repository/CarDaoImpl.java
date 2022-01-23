package hiber.repository;


import hiber.model.Car;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CarDaoImpl implements CarDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Car car) {
        em.persist(car);
    }

    public Car update( Car car ){
        return em.merge(car);
    }

    public Car findOne( long id ){
        return em.find( Car.class, id );
    }

    @Override
    public void delete(int id) {
        Car car = em.find(Car.class, id);
        em.remove(car);
    }

    @Override
    public List<Car> listCar() {
        return em.createQuery("select u from Car u", Car.class).getResultList();

    }
}

