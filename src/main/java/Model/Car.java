package Model;

import javax.persistence.*;

@Entity (name = "car_info")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private  int carId;
    @Column(name = "car_brand")
    private String carBrand;
    @Column(name = "car_model")
    private String carModel;
    @Column(name = "car_plate_number")
    private String carPlateNumber;
    @Column(name = "car_type")
    @Enumerated(EnumType.STRING)
    public CarType carType;
    @Column(name = "door_number")
    private int doorNumber;


    public Car() {
    }

    public Car(String carBrand, String carModel, String carPlateNumber, CarType carType, int doorNumber) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carPlateNumber = carPlateNumber;
        this.carType = carType;
        this.doorNumber = doorNumber;
    }

    public int getCarId() {
        return carId;
    }

//    public void setCarId(int carId) {
//        this.carId = carId;
//    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carMark) {
        this.carBrand = carMark;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public int getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getCarPlateNumber() {
        return carPlateNumber;
    }

    public void setCarPlateNumber(String carPlateNumber) {
        this.carPlateNumber = carPlateNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carPlateNumber='" + carPlateNumber + '\'' +
                ", carMark='" + carBrand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carType=" + carType +
                ", doorNumber=" + doorNumber +
                '}';
    }
}
