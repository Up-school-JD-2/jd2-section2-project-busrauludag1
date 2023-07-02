package src;

import java.util.UUID;

public class User {

    private final String id;
    private String name;
    private String surName;
    private String mobileNumber;
    private String eMail;

    private String password;

    private Mobile mobile;

    public User(String name, String surName, String mobileNumber, String eMail) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.surName = surName;
        this.mobileNumber = mobileNumber;
        this.eMail = eMail;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return eMail;
    }

    public String getPassword() {
        return password;
    }

    public Mobile getMobile(){
        return mobile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setEmail(String eMail) {
        this.eMail = eMail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMobile(Mobile mobile){
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                ", mobile serial number='" + mobile.getSerialNumber() +
                '}';
    }
}
