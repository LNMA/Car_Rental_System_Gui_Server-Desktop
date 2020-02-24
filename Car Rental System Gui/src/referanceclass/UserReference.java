package referanceclass;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserReference implements Serializable {
    private String username;
    private String password;
    private String type;
    private Timestamp dateCreate;
    private String firstName;
    private String lastName;
    private String gender;
    private String age;
    private int telephone;
    private String email;
    private String address;
    private String status;
    private String licenseValidity;
    private int discountPoint;
    private double totalBills;
    private String section;
    private String rank;

    public UserReference(String username, String password, String type, Timestamp dateCreate, String firstName, String lastName, String gender, String age, int telephone, String email, String address, String status, String licenseValidity, int discountPoint, double totalBills, String section, String rank) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.dateCreate = dateCreate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.status = status;
        this.licenseValidity = licenseValidity;
        this.discountPoint = discountPoint;
        this.totalBills = totalBills;
        this.section = section;
        this.rank = rank;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLicenseValidity() {
        return licenseValidity;
    }

    public void setLicenseValidity(String licenseValidity) {
        this.licenseValidity = licenseValidity;
    }

    public int getDiscountPoint() {
        return discountPoint;
    }

    public void setDiscountPoint(int discountPoint) {
        this.discountPoint = discountPoint;
    }

    public double getTotalBills() {
        return totalBills;
    }

    public void setTotalBills(double totalBills) {
        this.totalBills = totalBills;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "UserReference{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", dateCreate=" + dateCreate +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", telephone=" + telephone +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", licenseValidity='" + licenseValidity + '\'' +
                ", discountPoint=" + discountPoint +
                ", totalBills=" + totalBills +
                ", section='" + section + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
