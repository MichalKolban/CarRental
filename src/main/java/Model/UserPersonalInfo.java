package Model;

public class UserPersonalInfo {

    private String birthDate;
    private String phoneNumber;
    private String city;
    private String zipCode;


    public UserPersonalInfo() {
    }

    public UserPersonalInfo(String birthDate, String phoneNumber, String city, String zipCode) {
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
