package Manager;

import DAO.CarDAO;
import Model.Car;
import Model.CarRentDetails;
import Model.CarType;
import Utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    CarDAO carDAO = new CarDAO();
    static StringUtils strUtil = new StringUtils();

    public List<Car> getAllCars() {
        List allCars = carDAO.getAllCars();
        return allCars;
    }

    public String addNewCar(Car vehicle, CarRentDetails details) {

        String plateNumber = strUtil.checkSring(vehicle.getCarPlateNumber());
        vehicle.setCarBrand(vehicle.getCarBrand().toUpperCase());
        vehicle.setCarPlateNumber(plateNumber.toUpperCase());

        boolean exists = carDAO.checkIfCarExistsInDB(vehicle.getCarPlateNumber());
        if (exists) {
            return "SERVICE : Car already exists";
        } else {
            carDAO.addNewCarToDB(vehicle, details);
            return "SERVICE : Car saved in DB";
        }
    }



    public void deleteCar(String plateNumberToDelete) {
        //sprawdzić czy nie zawiera dziwnch znaków @!@$$
        plateNumberToDelete = strUtil.checkSring(plateNumberToDelete);

        boolean exists = checkIfCarExists(plateNumberToDelete);

        if(exists) {
            carDAO.deleteCarFromDB(plateNumberToDelete);
        } else {
            System.out.println("Sorry, no : " + plateNumberToDelete + " in DB");
        }

    }

    public boolean checkIfCarExists(String plateNumber) {

        //sprawdzić czy nie zawiera dziwnch znaków @!@$$
        plateNumber = strUtil.checkSring(plateNumber);

        return carDAO.checkIfCarExistsInDB(plateNumber);
    }

    public void getCarsBasedOnType(String carType) {
        carType = strUtil.checkSring(carType);
        boolean exists = carTypeExists(carType);
        if (exists) {
            carDAO.getAllCarsBasedOnType(carType);
        } else {
            System.out.println("NIE mamy takiego carType w bazie");
        }
    }

    public void getCarsBasedOnBrand(String carBrand) {

        carBrand = strUtil.checkSring(carBrand);
        carDAO.getAllCarsBasedOnBrand(carBrand);
    }

    public List<Object> getAllAvaliableModels(String carBrand){
        List<Object> avaliableList = new ArrayList<>();

        carBrand = strUtil.checkSring(carBrand);

        avaliableList = carDAO.getAllAvaliableModels(carBrand);

        return avaliableList;
    }

    public List<Object> getAllAvaliableCars() {
        List<Object> avaliableList = carDAO.getAllAvaliableCars();
//        avaliableList = carDAO.getAllAvaliableCars();
        return avaliableList;
    }

    ///////////////////////////////// PRIVATE METHODS /////////////////////////////////

    private boolean carTypeExists(String str) {
        for (CarType c : CarType.values()) {
            System.out.println(c);
            if (c.toString().equals(str)) {
                return true;
            }
        }
        return false;
    }


}

