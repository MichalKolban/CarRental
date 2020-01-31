import DAO.CarDAO;
import Manager.CarService;
import Model.Car;
import Model.CarRentDetails;
import Model.CarType;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    //
//    /*
//    TODO :
//    Dodac logger
//
//    Metody
//    Wyciągnięcie wszystkich zarezerwowanych samochodów
//    Wyciągniecie wszystkich wolnych samochodów
//    Filtrowanie samochodów na podstawie:
//    - ceny wypożyczenia
//
//    Dodawanie nowwego uzytkownika
//    Usunięcie uzytkownika
//    Wyświetlenie danych uzytkownika
//    Wyswietlenie aktualnie wypozyczonych aut przez uzytkownika
//     */
//
//


    public static void main(String[] args) {

        ///// testy

//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Car_Rental_peristence");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        Car maluch = new Car();
//        CarRentDetails details = new CarRentDetails();
//
//        maluch.setCarBrand("Fiat");
//        maluch.setCarPlateNumber("1232");
//        maluch.setCarType(CarType.VAN);
//        maluch.setCarModel("Panda");
//
//        details.setCar(maluch);
//        details.setCostPerDay(100.23);
//        details.setRentStartDate("22-06-2120");
//
//        entityManager.getTransaction().begin();
//
//        entityManager.persist(details);
//        entityManager.persist(maluch);
//
//        entityManager.getTransaction().commit();



            //to remove
        CarDAO carDAO = new CarDAO();
//
        carDAO.getCostam();
        System.out.println("=========");
        carDAO.getCostamWSZYSTKO();
//        carDAO.addCarDetils();

        ///////////////////

//        CarService service = new CarService();
//        CarRentDetails carRentDetails = new CarRentDetails();
//
//        //list of cars in DB
//        service.getAllCars();
//
//
//
//        // adding new vehicle
//        Car mazda = new Car("Toyota", "CRV", "162321", CarType.SUV);
//
//        String car = service.addNewCar(mazda);

        // check if car exists in DB
//        String plateNumber = "123";
//        boolean isIT = service.checkIfCarExists(plateNumber);
//        System.out.println("MAIN czy istnieje juz ? " + isIT);
//
//        // delete ca from DB
//        String plateNumberToDelete = "ZS12345";
//        service.deleteCar(plateNumberToDelete);
//
//        // list of cars based on CARTYPE
//        String carType = "suv";
//        service.getCarsBasedOnType(carType);
//
//        // list of cars based on rental_price
//
//        // list of cars based on car brand
//        System.out.println("CAAAR BRAAND");
//        String carBrand = "Ford";
//        service.getCarsBasedOnBrand(carBrand);



    }


}



