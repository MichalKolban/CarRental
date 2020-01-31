package Model;

import javax.persistence.*;

@Entity(name = "car_rent_details")
public class CarRentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_rent_details_id")
    private int carRentDetailsId;

    @OneToOne
    @JoinColumn(name = "carId")
    private Car car;

    @Column(name = "cost_per_day")
    private Double costPerDay;

    @Column(name = "rent_start_date")
    private String rentStartDate;

    @Column(name = "rent_end_date")
    private String rentEndDate;


    public CarRentDetails() {
    }

    public CarRentDetails(double costPerDay, String rentStartDate, String rentEndDate) {
        this.costPerDay = costPerDay;
        this.rentStartDate = rentStartDate;
        this.rentEndDate = rentEndDate;
    }

    public int getCarRentDetailsId() {
        return carRentDetailsId;
    }

    public void setCarRentDetailsId(int carRentDetailsId) {
        this.carRentDetailsId = carRentDetailsId;
    }



    public Double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(Double costPerDay) {
        this.costPerDay = costPerDay;
    }

    public String getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(String rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public String getRentEndDate() {
        return rentEndDate;
    }

    public void setRentEndDate(String rentEndDate) {
        this.rentEndDate = rentEndDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "CarRentDetails{" +
                "carRentDetailsId=" + carRentDetailsId +
                ", costPerDay=" + costPerDay +
                ", rentStartDate='" + rentStartDate + '\'' +
                ", rentEndDate='" + rentEndDate + '\'' +
                '}';
    }
}
