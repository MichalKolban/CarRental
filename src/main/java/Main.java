import DAO.CarDAO;
import Manager.CarService;
import Model.Car;
import Model.CarRentDetails;
import Model.CarType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Arrays;
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
//        - edycja ceny
//
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
        String plateNumber = "";

//          ========================================
//          ========== 1 ALL cars from DB ==========
//          ========================================

        List<Car> list = service.getAllCars();
        for(Car c : list){
            System.out.println(c.getCarId() + " " + c.getCarBrand() + "  | model : " + c.getCarModel() + " | plate number : " + c.getCarPlateNumber());
        }


//          ===============================================
//          ========== 2 list of cars based on car brand ==
//          ===============================================

//        carBrand = "FORD";
//        service.getCarsBasedOnBrand(carBrand);


//          ===============================================
//          ========== 3 list of cars based on car type ===
//          ===============================================

//        String carType = "mini";
//        List<Car> carsBasedOnType = service.getCarsBasedOnType(carType);
//        for(Car c : carsBasedOnType){
//            System.out.println(c.toString());
//        }


//          ===============================================
//          ========== 4 All Avaliable Cars ===============
//          ===============================================

//        List<Car> allAvaliableCars = service.getAllAvaliableCars();
//        for(Car c : allAvaliableCars){
//            System.out.println("MAIN " + c.toString());
//        }


//          ======================================================
//          ========== 5 All Avaliable Cars Based on CarBrand ====
//          ======================================================

//        carBrand = "FORD";
//        List<Car> allAvaliableModels = service.getAllAvaliableModels(carBrand);


//          ==================================================
//          ========== 6 All avaliable Cars based on price ===
//          ==================================================

//        Double price = 320.00;          // shows cars less than this price
//        List<Car> allCarsBasedOnPrice = service.getAllCarsBasedOnPrice(price);
//        for(Car c : allCarsBasedOnPrice){
//            System.out.println(c.toString());
//        }

//          ===============================================
//          ========== 7 Delete car from DB ===============
//          ===============================================

//        String plateNumberToDelete = "ZS11117";
//        service.deleteCar(plateNumberToDelete);


//          ===============================================
//          ========== 8 Add new car to DB ================
//          ===============================================

//        Car car = new Car("Fiat", "126p","ZS123", CarType.SPORT);
//        details.setCarInfoId(car);
//        details.setCostPerDay(50.20);
//        String respond = service.addNewCar(car, details);
//        System.out.println(respond);


//          ===============================================
//          ========== 9 Check if car Exists in DB ========
//          ===============================================

//        plateNumber = "ZS11115";
//        boolean exists = service.checkIfCarExists(plateNumber);
//        System.out.println("MAIN: Exists ? " + exists);

//          ===============================================
//          ========== 10 Edit price of price per day =====
//          ===============================================

//        double price = 89.99;
//        plateNumber = "ZS11112";
//        service.updatePricePerDay(price, plateNumber);

//          ===============================================
//          ========== 11 Find car based on plateNumber ===
//          ===============================================

//        plateNumber = "ZS11111";
//        service.findCar(plateNumber);


    }
}



