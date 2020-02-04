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
        List<Car> list = service.getAllCars();
        for(Car c : list){
            System.out.println(c.getCarId() + " " + c.getCarBrand() + "  | model : " + c.getCarModel() + " | plate number : " + c.getCarPlateNumber());
        }

//    // 2 list of cars based on car brand
//        carBrand = "reksus";
//        service.getCarsBasedOnBrand(carBrand);
//
//    // 3 list of cars based on car type
//        String carType = "minivan";
//        service.getCarsBasedOnType(carType);

     // 7 Delete car from DB
//        String plateNumberToDelete = "ZS1234";
//        service.deleteCar(plateNumberToDelete);

     // 8 Add new car to DB
//        Car car = new Car("Fiat", "126p","ZS123", CarType.SPORT);
//        details.setCarInfoId(car);
//        details.setCostPerDay(50.20);
//        String respond = service.addNewCar(car, details);
//        System.out.println(respond);

//     // 9 Check if car Exists in DB
        String plateNumber = "ZS11112";
        boolean exists = service.checkIfCarExists(plateNumber);
        System.out.println("MAIN: Exists ? " + exists);




        /////////////////////////////////////////
        // need to be improved
        /////////////////////////////////////////

//        // 4 All Avaliable Cars
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





    }
}



