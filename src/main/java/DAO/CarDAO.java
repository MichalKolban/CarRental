package DAO;

import Model.Car;
import Model.CarRentDetails;
import Model.CarType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarDAO {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("Car_Rental_peristence");
    EntityManager entityManager = factory.createEntityManager();

    public List getAllCars() {
        List<Car> carList = entityManager.createQuery("FROM car_info ", Car.class).getResultList();

//        Car car = new Car();
//
//        List<Car> carList = new ArrayList<>();
//
//        Query query = entityManager.createNativeQuery("SELECT car_id, car_brand, car_model, car_plate_number, car_type FROM car_info");
//
//        Iterator iterator = query.getResultList().iterator();
//        Object[] item = (Object[]) iterator.next();
//        int id = (int) item[0];
//        String carBrand = (String) item[1];
//        String carModel = (String) item[2];
//        String carPlateNumber = (String) item[3];
//        CarType carType = (CarType) item[4];




        return carList;
    }

//    public void addNewCarToDB(Car vehicle) {
//
//        entityManager.getTransaction().begin();
//
//        entityManager.persist(vehicle);
//
//        entityManager.getTransaction().commit();
//    }

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
        System.out.println("DAO : OBJECT DON'T EXISTS");
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
        for (Car obj : carTypeList) {
            System.out.println(obj.getCarId() + " " + obj.getCarType() + " " + obj.getCarBrand() + " " + obj.getCarModel());
        }
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

    public List<Object> getAllAvaliableModels(String carBrand) {

        List<Object> avaliableList = new ArrayList<>();

        entityManager.getTransaction().begin();

        Query query = entityManager.createNativeQuery("SELECT car_id, car_brand, car_model, car_plate_number, car_type, cost_per_day FROM " +
                " car_info , car_rent_details WHERE car_info.car_id = car_rent_details.car_rent_details_id AND " +
                " car_info.car_brand = '" + carBrand + "'");

        Iterator iterator = query.getResultList().iterator();

        while (iterator.hasNext()) {
            Object[] item = (Object[]) iterator.next();
            int carId = (int) item[0];
            String brand = (String) item[1];
            String model = (String) item[2];
            String carPlateNumber = (String) item[3];
            String carType = (String) item[4];
            Double costPerDay = (Double) item[5];

            System.out.println(carId + " " + brand + " " + model + " " + carPlateNumber + " " + carType + " HAJS ZA WYPOZYCZENIE " + costPerDay);
            avaliableList.add(item);
        }
        entityManager.getTransaction().commit();

        return avaliableList;
    }

    public List<Object> getAllAvaliableCars() {

        ArrayList<Object> avaliableList = new ArrayList<>();

        entityManager.getTransaction().begin();

        Query query = entityManager.createNativeQuery("SELECT car_id, car_brand, car_model, car_plate_number, car_type, cost_per_day FROM " +
                " car_info , car_rent_details WHERE car_info.car_id = car_rent_details.car_rent_details_id ");

        Iterator iterator = query.getResultList().iterator();

        while (iterator.hasNext()) {
            Object[] item = (Object[]) iterator.next();
            int carId = (int) item[0];
            String brand = (String) item[1];
            String model = (String) item[2];
            String carPlateNumber = (String) item[3];
            String carType = (String) item[4];
            Double costPerDay = (Double) item[5];


            System.out.println("AVALIABLE RIGHT NOW : " + carId + " " + brand + " " + model + " " + carPlateNumber + " " + carType + " HAJS ZA WYPOZYCZENIE " + costPerDay);
            avaliableList.add(item);
        }
        entityManager.getTransaction().commit();
        return avaliableList;
    }
}