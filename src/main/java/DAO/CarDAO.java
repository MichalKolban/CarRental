package DAO;

import Model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CarDAO {

    Logger log = LoggerFactory.getLogger(CarDAO.class);

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("Car_Rental_peristence");
    EntityManager entityManager = factory.createEntityManager();

    public List getAllCars() {
        List<Car> carList = entityManager.createQuery("FROM car_info ", Car.class).getResultList();

        System.out.println("Baza danych prezentuje sie tak");
        for (Car c : carList) {
            System.out.println(c.getCarId() + " " + c.getCarBrand() + " " + c.getCarModel() + " " + c.getCarPlateNumber() + " " + c.getCarType());
        }
        return carList;
    }

    public void addNewCarToDB(Car mazda) {

        entityManager.getTransaction().begin();
        entityManager.persist(mazda);
        entityManager.getTransaction().commit();
    }

    public boolean checkIfCarExistsInDB(String plateNumber) {

        Query query = entityManager.createQuery("SELECT carPlateNumber FROM car_info WHERE carPlateNumber='" + plateNumber + "'");

        List resultList = query.getResultList();

        if (!resultList.isEmpty()) {
            System.out.println("DAO : OBJECT EXISTS");
            return true;
        }
        System.out.println("DAO : OBJECT DON'T EXISTS");
        return false;
    }

    public void deleteCarFromDB(String plateNumberToDelete) {

        entityManager.getTransaction().begin();
        try {
            Car carToDelate = entityManager.createQuery("FROM car_info WHERE carPlateNumber='" + plateNumberToDelete + "'", Car.class).getSingleResult();

            entityManager.remove(carToDelate);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("DAO : Nie ma nic takiego w DB");
        }
    }


    public List<Car> getAllCarTypesBasedOnType(String carType) {

        List<Car> carTypeList = entityManager.createQuery("FROM car_info c WHERE c.carType='" + carType + "'").getResultList();
        for (Car obj : carTypeList) {
            System.out.println(obj);
        }
        return carTypeList;
    }

}