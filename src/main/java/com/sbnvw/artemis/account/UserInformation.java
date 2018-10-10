package com.sbnvw.artemis.account;

import javafx.scene.image.Image;
import java.util.Date;

/**
 *
 * @author djmbritt
 */
//      Potential future implementation for accountCreationDate:
//	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//	Date date = new Date();
//	System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
public abstract class UserInformation extends UserLogin implements UserManagement {

    private String userName;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String sex;
    private String email;
    private String phoneNumber;
    private String addres;
    private int houseNumber;
    private String addition;
    private String postalCode;
    private Image profilePicture;
    private Date dateAccountCreation;

    public UserInformation() {
        super(null);
    }

    public UserInformation(String password, String userName, String firstName, 
            String lastName, Date dateOfBirth, String sex, String email, 
            String phoneNumber, String addres, int houseNumber, String addition,
            String postalCode, Image profilePicture) {
        super(password);
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addres = addres;
        this.houseNumber = houseNumber;
        this.addition = addition;
        this.postalCode = postalCode;
        this.profilePicture = profilePicture;
        this.dateAccountCreation = new Date();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Image getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Image profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Date getDateAccountCreation() {
        return dateAccountCreation;
    }

    public void setDateAccountCreation(Date dateAccountCreation) {
        this.dateAccountCreation = dateAccountCreation;
    }

}
