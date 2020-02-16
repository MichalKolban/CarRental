package DAO;

import Model.Car;
import Model.CarRentDetails;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CarDAO {

    private static EntityManager em;
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("Car_Rental_peristence");
    EntityManager entityManager = factory.createEntityManager();

    public List getAllCars() {
        List<Car> carList = entityManager.createQuery("FROM car_info ", Car.class).getResultList();
        return carList;
    }

    public void addNewCarToDB(Car vehicle, CarRentDetails details) {
        entityManager.getTransaction().begin();
        entityManager.persist(vehicle);
        entityManager.persist(details);
        entityManager.getTransaction().commit();
    }

    public boolean checkIfCarExistsInDB(String plateNumber) {
        Query query = entityManager.createQuery("SELECT carPlateNumber FROM car_info WHERE carPlateNumber='" + plateNumber + "'");
        List resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            System.out.println("DAO : OBJECT EXISTS");
            return true;
        }
        System.out.println("DAO : OBJECT DOESN'T EXISTS");
        return false;
    }

    public void deleteCarFromDB(String plateNumberToDelete) {
        entityManager.getTransaction().begin();
        try {
            Car car = entityManager.createQuery("FROM car_info WHERE carPlateNumber='" + plateNumberToDelete + "'", Car.class).getSingleResult();
            entityManager.remove(car);
            entityManager.getTransaction().commit();
            System.out.println("DAO : CAR DELETED FROM DB");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("DAO : Nie ma nic takiego w DB");
        }
    }

    public List<Car> getAllCarsBasedOnType(String carType) {
        List<Car> carTypeList = entityManager.createQuery("FROM car_info c WHERE c.carType='" + carType + "'").getResultList();
        return carTypeList;
    }

    public List<Car> getAllCarsBasedOnBrand(String carBrand) {
        List<Car> carBrandList = entityManager.createQuery("FROM car_info  c WHERE c.carBrand='" + carBrand + "'").getResultList();
        if (!carBrandList.isEmpty())
            for (Car obj : carBrandList) {
                System.out.println(obj.getCarId() + " " + obj.getCarBrand() + " " + obj.getCarModel());
            }
        else {
            System.out.println("Sorry we don't have brand : " + carBrand + " in our Rental");
        }
        return carBrandList;
    }


    public List<Car> getAllAvaliableModels(String carBrand) {
        entityManager.getTransaction().begin();
        List<Car> avaliableModelsList = entityManager.createNativeQuery("SELECT c.car_id, c.car_brand, c.car_model, c.car_plate_number, c.car_type FROM car_info c WHERE c.car_brand = '" + carBrand + "' AND car_id IN " +
                " (SELECT car_info_id FROM car_rent_details WHERE avaliable_to_rent = true)", Car.class).getResultList();
        if (avaliableModelsList.isEmpty()) {
            return null;
        } else {
            for (Car c : avaliableModelsList) {
                System.out.println("DAO : " + c.getCarId() + " " + c.getCarBrand() + " " + c.getCarModel());
            }
            entityManager.getTransaction().commit();
            return avaliableModelsList;
        }
    }

    public List<Car> getAllAvaliableCars() {
        entityManager.getTransaction().begin();
        List<Car> avaliableCarsList = entityManager.createNativeQuery("SELECT car_id, car_brand, car_model, car_plate_number, car_type FROM car_info WHERE car_id IN " +
                " (SELECT car_info_id FROM car_rent_details WHERE avaliable_to_rent = true)", Car.class).getResultList();
        entityManager.getTransaction().commit();
        return avaliableCarsList;
    }


    public List<Car> gettAllAvaliableCarsBasedOnPrice(Double price) {
        entityManager.getTransaction().begin();
        List<Car> resultList = entityManager.createNativeQuery("SELECT c.car_id, c.car_brand, c.car_model, c.car_plate_number, c.car_type, d.cost_per_day FROM car_info c JOIN car_rent_details d ON (c.car_id = d.car_info_id) WHERE d.cost_per_day < '" + price + "' AND c.car_id IN " +
                " (SELECT car_info_id FROM car_rent_details WHERE avaliable_to_rent = true)", Car.class).getResultList();
        entityManager.getTransaction().commit();
        return resultList;
    }

    public Car findCar(String plateNumber) {
        entityManager.getTransaction().begin();
        Car car = entityManager.createQuery("FROM car_info WHERE carPlateNumber='" + plateNumber + "'", Car.class).getSingleResult();
        System.out.println(car.toString());
        entityManager.getTransaction().commit();
        return car;
    }

    public void updatePricePerDay(double price, String plateNumber) {
        Car carToUpdate = findCar(plateNumber);
        int carIdToUpdate = carToUpdate.getCarId();
        CarRentDetails carRentDetails = entityManager.find(CarRentDetails.class, carIdToUpdate);
        carRentDetails.setCostPerDay(price);
        entityManager.getTransaction().begin();
        entityManager.merge(carRentDetails);
        entityManager.getTransaction().commit();
    }
}