package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MobileAppManager {
    private final Map<String, User> userMap;
    private final Map<String, Mobile> mobileMap;
    private final Map<String, App> appMap;
    private final Map<String, User> contactMap;

    public MobileAppManager(){
        userMap = new HashMap<>();
        mobileMap = new HashMap<>();
        appMap = new HashMap<>();
        contactMap = new HashMap<>();
    }

    public MobileAppManager addUser(User user){
        if (userMap.containsKey(user.getId()))
            throw new RuntimeException("User is already defined!");
        userMap.put(user.getId(), user);
        return this;
    }

    public MobileAppManager addMobile(Mobile mobile){
        if (mobileMap.containsKey(mobile.getSerialNumber()))
            throw new RuntimeException("Mobile is already defined!");
        mobileMap.put(mobile.getSerialNumber(), mobile);
        return this;
    }

    public MobileAppManager addApp(App app){
        if (appMap.containsKey(app.getName()))
            throw new RuntimeException("App is already defined!");
        appMap.put(app.getFullName(), app);
        return this;
    }

    public User getUserById(String id){
        if (!userMap.containsKey(id))
            throw new RuntimeException("User is not found!");
        return userMap.get(id);
    }

    public Mobile getMobileBySerialNumber(String serialNumber){
        if (!mobileMap.containsKey(serialNumber))
            throw new RuntimeException("Mobile is not found!");
        return mobileMap.get(serialNumber);
    }

    public App getAppByName(String name){
        if (!appMap.containsKey(name))
            throw new RuntimeException("App is not found!");
        return appMap.get(name);
    }

    public void assignMobile(Mobile mobile, User user){
        if (mobile.equals(user.getMobile()))
            throw new RuntimeException("Mobile is already assigned to this user!");
;        user.setMobile(getMobileBySerialNumber(mobile.getSerialNumber()));
    }

    public void addContact(String userId1, String userId2){
        User user1 = getUserById(userId1);
        User user2 = getUserById(userId2);
        user1.getMobile().addContact(user2);
    }

    public void removeContact(String userId1, String userId2){
        User user1 = getUserById(userId1);
        User user2 = getUserById(userId2);
        user1.getMobile().removeContact(user2);
    }

    public User updateContact(String userId1, String userId2){
        User user1 = getUserById(userId1);
        User user2 = getUserById(userId2);
        user1.getMobile().updateContact(user2);
        return user2;
    }

    public void printEmptyMemories(Map<String, Mobile> mobileMap){
        //printEmptyMemories();
    }


    public void downloadApp(String serialNumber, String appName){
        Mobile mobile = mobileMap.get(serialNumber);
        App app = appMap.get(appName);
        if (mobile.getApps().contains(app))
            throw new RuntimeException("App is already downloaded!");
        if (mobile.getRemainMemory() < app.getMemory())
            throw new RuntimeException("You don't have enough memory to download this app!");
        mobile.getApps().add(app);
        mobile.setRemainMemory(mobile.getRemainMemory() - app.getMemory());
        System.out.print("App is downloaded successfully!");
    }

    public void updateApp(String serialNumber, String olderAppFullName, String newerAppFullName){
        Mobile mobile = mobileMap.get(serialNumber);
        deleteApp(serialNumber, olderAppFullName);
        downloadApp(serialNumber, newerAppFullName);
        System.out.print("App is updated successfully!");
    }

    public void deleteApp(String serialNumber, String appName){
        Mobile mobile = mobileMap.get(serialNumber);
        App app = appMap.get(appName);
        if(!mobile.getApps().contains(app))
            throw new RuntimeException("There is no app downloaded!");
        mobile.getApps().remove(app);
        mobile.setRemainMemory(mobile.getRemainMemory() + app.getMemory());
        System.out.print("App is deleted successfully!");
    }

    public String searchApp(Mobile mobile, App app){
        if (mobile.getApps().contains(app))
            return app.getName();
        else {
            throw new RuntimeException("There is no app downloaded!");
        }
    }

    public App searchAppByName(String appName){
        App searchedApp = null;
        List<App> apps = new ArrayList<>(appMap.values());
        for (App app : apps) {
            if (app.getName().equalsIgnoreCase(appName)) {
                searchedApp = app;
            }
        }
        return searchedApp;
    }

    public User searchContactByName(String contactName) {
        User searchedContact = null;
        List<User> contacts = new ArrayList<User>(contactMap.values());
        for (User contact : contacts) {
            if (contact.getName().equalsIgnoreCase(contactName)) {
                searchedContact = contact;
            }
        }
        return searchedContact;
    }

    public Mobile searchMobileByNumber(String serialNumber) {
        Mobile searchedMobile = null;
        List<Mobile> mobiles = new ArrayList<>(mobileMap.values());
        for (Mobile mobile : mobiles) {
            if (mobile.getSerialNumber().equals(serialNumber)) {
                searchedMobile = mobile;
            }
        }
        return searchedMobile;
    }


    public User searchUserByName(String userName) {
        User searchedUser = null;
        List<User> users = new ArrayList<User>(userMap.values());
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(userName)) {
                searchedUser = user;
            }
        }
        return searchedUser;
    }


    public void listApps(){
        List<App> apps = new ArrayList<>(appMap.values());
        apps.forEach(System.out::println);
    }

    public void listContacts(){
        List<User> contacts = new ArrayList<>(contactMap.values());
        if (contacts.isEmpty())
            System.out.println("There is no contact person in your phone! you can add a contact.");
        contacts.forEach(System.out::println);
    }

    public void listMobiles(){
        List<Mobile> mobiles = new ArrayList<>(mobileMap.values());
        mobiles.forEach(System.out::println);
    }

    public void listUsers(){
        List<User> users = new ArrayList<>(userMap.values());
        users.forEach(System.out::println);
    }
}
