package Manager;

import DAO.CarDAO;
import Model.Car;
import Model.CarType;
import Utils.StringUtils;

import java.util.List;

public class CarService {

    CarDAO carDAO = new CarDAO();

    static StringUtils strUtil = new StringUtils();

    public List<Car> getAllCars() {
        List allCars = carDAO.getAllCars();
        return allCars;
    }

    public String addNewCar(Car vehicle) {

        // sprawdzenie czy carPlateNumber nie ma !^*($@
        vehicle.setCarBrand(vehicle.getCarBrand().toUpperCase());
        vehicle.setCarPlateNumber(vehicle.getCarPlateNumber().toUpperCase());

        boolean exists = carDAO.checkIfCarExistsInDB(vehicle.getCarPlateNumber());
        if (exists) {
            return "SERVICE : Car already exists";
        } else {
            carDAO.addNewCarToDB(vehicle);
            return "SERVICE : Car saved in DB";
        }
    }

    public boolean checkIfCarExists(String plateNumber) {

        //sprawdzić czy nie zawiera dziwnch znaków @!@$$
        plateNumber = plateNumber.toUpperCase();

        return carDAO.checkIfCarExistsInDB(plateNumber);
    }

    public void deleteCar(String plateNumberToDelete) {
        //sprawdzić czy nie zawiera dziwnch znaków @!@$$
        plateNumberToDelete = plateNumberToDelete.toUpperCase();

        carDAO.deleteCarFromDB(plateNumberToDelete);

    }

    public void getCarsBasedOnType(String carType) {
        carType = carType.toUpperCase();

        boolean exists = carTypeExists(carType);

        if (exists) {
            System.out.println("Tak mamy cos w bazie");
            carDAO.getAllCarTypesBasedOnType(carType);
        } else {
            System.out.println("NIE mamy takiego carType w bazie");
        }
    }


    private boolean carTypeExists(String str) {
        for (CarType c : CarType.values()) {
            System.out.println(c);
            if (c.toString().equals(str)) {
                return true;
            }
        }
        return false;
    }


    public List<Car> getAllCarTypes(String carType) {

        carType = carType.toUpperCase();

        // sprawdzenie czy nie ma dziwnych znaków jeszcze

        List<Car> carTypesList = carDAO.getAllCarTypesBasedOnType(carType);

        return carTypesList;
    }
}

