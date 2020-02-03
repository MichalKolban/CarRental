import DAO.CarDAO;
import Manager.CarService;
import Model.Car;
import Model.CarRentDetails;
import Model.CarType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    //
//    /*
//    TODO :
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

        CarService service = new CarService();
        CarRentDetails details = new CarRentDetails();

        String carBrand = "";

     // 1 All Car in DB
//        List<Car> list = service.getAllCars();
//        for(Car c : list){
//            System.out.println(c.getCarId() + " " + c.getCarBrand() + " " + c.getCarModel() + " " + c.getCarPlateNumber());
//        }

//    // 2 list of cars based on car brand
//        carBrand = "Ferrari";
//        service.getCarsBasedOnBrand(carBrand);
//
//    // 3 list of cars based on car type
//        String carType = "van";
//        service.getCarsBasedOnType(carType);
//
//     // 4 All Avaliable Cars
//        // CHECK IF CAR IS AVALIABLE
//        // need to secure if list is empty
//        service.getAllAvaliableCars();
//
//     // 5 All Avaliable Cars Based on CarBrand
//        // CHECK IF CAR IS AVALIABLE
//        // need to secure if carbrand is no on the list
//        carBrand = "fiat";
//        service.getAllAvaliableModels(carBrand);
//
//     // 6 All Avaliable Cars Based on price
//
//     // 7 Delete car from DB
        // need to delete also from carRetnalDetails in DB
        // SOMETHING WRONG, NEED TO BE IMPORVED !!!!!!!!!!!
//        String plateNumberToDelete = "123ZZSW";
//        service.deleteCar(plateNumberToDelete);
//
//     // 8 Add new car to DB
//        Car car = new Car("Ferrari", "LaFerrari","123ZZSW", CarType.SPORT);
//        details.setCar(car);
//        details.setCostPerDay(415.00);
//        String respond = service.addNewCar(car, details);
//        System.out.println(respond);
//
//     // 9 Check if car Exists in DB
//        String plateNumber = "123ZZSW";
//        boolean isIT = service.checkIfCarExists(plateNumber);
//        System.out.println("MAIN czy istnieje juz ? " + isIT);

    }
}



