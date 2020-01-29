import DAO.CarDAO;
import Manager.CarService;
import Model.Car;
import Model.CarType;

public class Main {
    //
//    /*
//    TODO :
//    Dodac logger // dodany do carDao ale sie nie wyswietla
//
//    Metody
//    Wyciagniecie listy wszystkich samocodów
//    Sprawdzanie czy auto juz nie istnieje
//    Dodanie nowego auta
//    Usunięcie auta z listy
//    Wyciągnięcie wszystkich zarezerwowanych samochodów
//    Wyciągniecie wszystkich wolnych samochodów
//    Filtrowanie samochodów na podstawie:
//    - car type
//    - ceny wypożyczenia
//    - Marki samochodu
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
        CarDAO carDAO = new CarDAO();

        //lista z DB
        System.out.println("START cała lista");
        service.getAllCars();
        System.out.println("KONIEC cała lista");

        // dodanie nowego auta + sprawdzenie czy juz taki istnieje
        System.out.println("START dodanie auta");
        Car mazda = new Car("Mitsubishi", "CX-9", "16661265", CarType.VAN, 5);
        String car = service.addNewCar(mazda);
        System.out.println("KONIEC dodanie auta");

        // sprawdzenie czy auto istnieje w bazie
        System.out.println("START czy auto istnieje");
        String plateNumber = "123";
        boolean isIT = service.checkIfCarExists(plateNumber);
        System.out.println("MAIN czy istnieje juz ? " + isIT);
        System.out.println("KONIEC czy autp istnieje");

        // usunięcie auta z bazy danych
        System.out.println("START usuniecie z bazy");
        String plateNumberToDelete = "ZS12345";
        service.deleteCar(plateNumberToDelete);
        System.out.println("KONIEC usuniecie z bazy");

        // filtrowanie auta na podstawie CARTYPE
        System.out.println("START na podstawie cartype");
        String carType = "suv";
        service.getCarsBasedOnType(carType);
        System.out.println("KONIEC na podstawie cartype");


    }
}



