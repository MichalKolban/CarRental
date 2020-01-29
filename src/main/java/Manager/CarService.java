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
        String plateNumber = strUtil.checkSring(vehicle.getCarPlateNumber());
        vehicle.setCarBrand(vehicle.getCarBrand().toUpperCase());
        vehicle.setCarPlateNumber(plateNumber.toUpperCase());

        boolean exists = carDAO.checkIfCarExistsInDB(vehicle.getCarPlateNumber());
        if (exists) {
            return "SERVICE : Car already exists";
        } else {
            carDAO.addNewCarToDB(vehicle);
            return "SERVICE : Car saved in DB";
        }
    }



    public void deleteCar(String plateNumberToDelete) {
        //sprawdzić czy nie zawiera dziwnch znaków @!@$$
        plateNumberToDelete = strUtil.checkSring(plateNumberToDelete);

        carDAO.deleteCarFromDB(plateNumberToDelete);

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
            System.out.println("Tak mamy cos w bazie");
            carDAO.getAllCarsBasedOnType(carType);
        } else {
            System.out.println("NIE mamy takiego carType w bazie");
        }
    }

    public void getCarsBasedOnBrand(String carBrand) {
        carBrand = strUtil.checkSring(carBrand);



        carDAO.getAllCarsBasedOnBrand(carBrand);
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

