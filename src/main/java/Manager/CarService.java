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

//    public String addNewCar(Car vehicle) {
//
//        String plateNumber = strUtil.checkSring(vehicle.getCarPlateNumber());
//        vehicle.setCarBrand(vehicle.getCarBrand().toUpperCase());
//        vehicle.setCarPlateNumber(plateNumber.toUpperCase());
//
//        boolean exists = carDAO.checkIfCarExistsInDB(vehicle.getCarPlateNumber());
//        if (exists) {
//            return "SERVICE : Car already exists";
//        } else {
//            carDAO.addNewCarToDB(vehicle);
//            return "SERVICE : Car saved in DB";
//        }
//    }

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

    public List<Car> getCarsBasedOnType(String carType) {
        List<Car> allCarsBasedOnType = new ArrayList<>();
        carType = strUtil.checkSring(carType);
        boolean exists = carTypeExists(carType);
        try {
            if (exists) {
                allCarsBasedOnType = carDAO.getAllCarsBasedOnType(carType);
                return allCarsBasedOnType;
            } else {
                System.out.println("Sorry We don't have " + carType + " type in Rental");
            }
        } catch (NullPointerException e) {
            System.out.println("Sorry We don't have " + carType + " type in Rental" + e);
        }
        return allCarsBasedOnType;
    }

    public void getCarsBasedOnBrand(String carBrand) {

        carBrand = strUtil.checkSring(carBrand);
        carDAO.getAllCarsBasedOnBrand(carBrand);
    }

    public List<Car> getAllAvaliableModels(String carBrand){

        carBrand = strUtil.checkSring(carBrand);

        List<Car> avaliableList = carDAO.getAllAvaliableModels(carBrand);

        return avaliableList;
    }

    public List<Car> getAllAvaliableCars() {

        List<Car> avaliableList = carDAO.getAllAvaliableCars();

        return avaliableList;
    }

    public List<Car> getAllCarsBasedOnPrice(Double price) {

        // no validation for now

        List<Car> carsList = carDAO.gettAllAvaliableCarsBasedOnPrice(price);

        return carsList;
    }

    public void updatePricePerDay(double price, String plateNumber) {

        plateNumber = strUtil.checkSring(plateNumber);

        carDAO.updatePricePerDay(price, plateNumber);

    }

    public Car findCar(String plateNumber) {

        carDAO.findCar(plateNumber);

        return null;
    }

    ///////////////////////////////// PRIVATE METHODS /////////////////////////////////

    private boolean carTypeExists(String str) {
        for (CarType c : CarType.values()) {
            if (c.toString().equals(str)) {
                return true;
            }
        }
        return false;
    }

}

