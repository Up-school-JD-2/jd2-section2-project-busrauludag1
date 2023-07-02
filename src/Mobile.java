package src;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Mobile {
    private final Brand brand;
    private final String model;
    private final String serialNumber;
    private final int diskMemory;

    private int remainMemory;
    private final OperatingSystem os;

    private final Set<App> apps;

    private final Set<User> contacts;

    public Mobile(Brand brand, String model, int diskMemory, OperatingSystem os) {
        this.brand = brand;
        this.model = model;
        this.serialNumber = UUID.randomUUID().toString();;
        this.diskMemory = diskMemory;
        this.os = os;
        this.remainMemory = diskMemory;
        apps = new HashSet<>();
        contacts = new HashSet<>();
    }

    public Brand getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getDiskMemory() {
        return diskMemory;
    }

    public OperatingSystem getOs() {
        return os;
    }

    public int getRemainMemory(){
        return remainMemory;
    }

    public Set<App> getApps(){
        return apps;
    }


    public Set<User> getContacts(){
        return contacts;
    }

    public void setRemainMemory(int remainMemory){
        this.remainMemory = remainMemory;
    }

    public void addApp(App app){
        if (apps.contains(app)) {
            throw new RuntimeException("This app is already added!");
        }
        apps.add(app);
    }

    public void removeApp(App app){
        if (!apps.contains(app)){
            throw new RuntimeException("This app is not found!");
        }
        apps.remove(app);
    }

    public void updateApp(App app){
        removeApp(app);
        addApp(app);
    }

    public void addContact(User user){
        if (contacts.contains(user)) {
            throw new RuntimeException("This contact is already added!");
        }
        contacts.add(user);
    }

    public void removeContact(User user){
        if (!contacts.contains(user)){
            throw new RuntimeException("This contact is not found!");
        }
        contacts.remove(user);
    }

    public void updateContact(User user){
        removeContact(user);
        addContact(user);
    }

    public void printEmptyMemory(Mobile mobile){
        System.out.println(mobile.getRemainMemory());
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", memory=" + diskMemory +
                ", operating system=" + os +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mobile mobile = (Mobile) o;
        return brand == mobile.brand && Objects.equals(model, mobile.model) &&
                Objects.equals(serialNumber, mobile.serialNumber) &&
                diskMemory == mobile.diskMemory && os == mobile.os;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, serialNumber, diskMemory, os);
    }
}
