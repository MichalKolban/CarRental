import DAO.CarDAO;
import Manager.CarService;
import Model.Car;
import Model.CarType;

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


        CarService service = new CarService();

        //to remove
//        CarDAO carDAO = new CarDAO();

        //list of cars in DB
        service.getAllCars();

        // adding new vehicle
        Car mazda = new Car("Mitsubishi", "CX-9", "16661265", CarType.VAN);
        String car = service.addNewCar(mazda);

        // check if car exists in DB
        String plateNumber = "123";
        boolean isIT = service.checkIfCarExists(plateNumber);
        System.out.println("MAIN czy istnieje juz ? " + isIT);

        // delete ca from DB
        String plateNumberToDelete = "ZS12345";
        service.deleteCar(plateNumberToDelete);

        // list of cars based on CARTYPE
        String carType = "suv";
        service.getCarsBasedOnType(carType);

        // list of cars based on rental_price

        // list of cars based on car brand
        System.out.println("CAAAR BRAAND");
        String carBrand = "Ford";
        service.getCarsBasedOnBrand(carBrand);



    }


}



