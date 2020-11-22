package org.lab.dao.lab_dao.view;


import org.lab.dao.lab_dao.controller.*;
import org.lab.dao.lab_dao.model.entity.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private static final Scanner SCANNER = new Scanner(System.in);
    private final Map<String, Printable> menu = new LinkedHashMap<>();

    private final UserController userController = new UserController();
    private final UserRoleController userRoleController = new UserRoleController();
    private final TaxiDriverController taxiDriverController = new TaxiDriverController();
    private final TaxiPassengerController taxiPassengerController = new TaxiPassengerController();
    private final LicenseController licenseController = new LicenseController();
    private final AutoController autoController = new AutoController();

    public View() {
        /////////______User______/////////
        menu.put("11", this::getAllUser);
        menu.put("12", this::getUserById);
        menu.put("13", this::createUser);
        menu.put("14", this::updateUser);
        menu.put("15", this::deleteUser);

        /////////___User-Role___/////////
        menu.put("21", this::getAllUserRole);
        menu.put("22", this::getUserRoleById);
        menu.put("23", this::createUserRole);
        menu.put("24", this::updateUserRole);
        menu.put("25", this::deleteUserRole);

        /////////_____Driver_____////////
        menu.put("31", this::getAllDriver);
        menu.put("32", this::getDriverById);
        menu.put("33", this::createDriver);
        menu.put("34", this::updateDriver);
        menu.put("35", this::deleteDriver);
    }

    public final void show() {


        String input;
        Menu showMenu = new Menu();
        showMenu.displayMenu();
        System.out.println("\n( ͡° ͜ʖ ͡°) Shoot your shot:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (SCANNER.hasNext());
    }


    ///////////////////////_____USER_____////////////////////
    private void getAllUser() throws SQLException {
        System.out.println("\nGETting User...");
        System.out.println(userController.findAll() + "\n");
    }


    private void getUserById() throws SQLException {
        System.out.println("\nGETting User... Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(userController.findOne(id) + "\n");
    }

    private User getUserInputs() {
        System.out.println("\nEnter name: ");
        String firstName = SCANNER.next();
        System.out.println("Enter last name: ");
        String secondName = SCANNER.next();
        System.out.println("Enter gender: ");
        String gender = SCANNER.next();
        System.out.println("Enter date of birth: ");
        String dateOfBirth = SCANNER.next();
        System.out.println("Enter taxi user role Id: ");
        int taxiUserRoleId = Integer.parseInt(SCANNER.next());
        return new User(firstName, secondName, gender, dateOfBirth, taxiUserRoleId);
    }

    private void createUser() throws SQLException {
        System.out.println("\nCREATing User...");
        User user = getUserInputs();
        userController.create(user);
        System.out.println("Hurrey! User successfully created!\n");
    }

    private void updateUser() throws SQLException {
        System.out.println("\nUPDATing User... Enter ID: ");
        Integer id = SCANNER.nextInt();
        User user = getUserInputs();
        user.setId(id);

        userController.update(user.getId(), user);
        System.out.println("Updated user with Id=" + id + "\n");
    }

    private void deleteUser() throws SQLException {
        System.out.println("\nDELETing user... Enter ID: ");
        int id = SCANNER.nextInt();

        userController.delete(id);
        System.out.println("Deleted user with ID=" + id + "\n");
    }
//////////////////////////////////////////////////////////////////////////////////


    //////////////////////_____USER_ROLE_____///////////////////////////////

    private void getAllUserRole() throws SQLException {
        System.out.println("\nGETting UserRole...");
        System.out.println(userRoleController.findAll() + "\n");
    }


    private void getUserRoleById() throws SQLException {
        System.out.println("\nGETting User role... Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(userRoleController.findOne(id) + "\n");
    }

    private UserRole getUserRoleInputs() {
        System.out.println("\nEnter driverId: ");
        Integer driverId = Integer.valueOf(SCANNER.next());
        System.out.println("Enter passengerId: ");
        Integer passengerId = Integer.valueOf(SCANNER.next());

        return new UserRole(driverId, passengerId);
    }

    private void createUserRole() throws SQLException {
        System.out.println("\nCREATing User role...");
        UserRole userRole = getUserRoleInputs();
        userRoleController.create(userRole);
        System.out.println("Hurrey! User role successfully created!\n");
    }

    private void updateUserRole() throws SQLException {
        System.out.println("\nUPDATing User role... Enter ID: ");
        Integer id = SCANNER.nextInt();
        UserRole userRole = getUserRoleInputs();
        userRole.setId(id);

        userRoleController.update(userRole.getId(), userRole);
        System.out.println("Updated user role with Id=" + id + "\n");
    }

    private void deleteUserRole() throws SQLException {
        System.out.println("\nDELETing user role... Enter ID: ");
        int id = SCANNER.nextInt();

        userRoleController.delete(id);
        System.out.println("Deleted user role with ID=" + id + "\n");
    }
/////////////////////////////////////////////////////////////////////////////////
    //////////////////////_____DRIVER_____////////////////////////////



    private void getAllDriver() throws SQLException {
        System.out.println("\nGETting Driver...");
        System.out.println(taxiDriverController.findAll() + "\n");
    }


    private void getDriverById() throws SQLException {
        System.out.println("\nGETting Driver... Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(taxiDriverController.findOne(id) + "\n");
    }

    private TaxiDriver getDriverInputs() {
        System.out.println("\nEnter driving experience: ");
        Float drivingExperience = Float.valueOf(SCANNER.next());
        System.out.println("Enter rating driver: ");
        Float ratingDriver = Float.valueOf(SCANNER.next());
        System.out.println("Enter licenseId: ");
        Integer licenseId = Integer.valueOf(SCANNER.next());
        System.out.println("Enter autoId: ");
        Integer autoId = Integer.valueOf(SCANNER.next());
        System.out.println("Enter is booked: ");
        Boolean isBooked = Boolean.valueOf(SCANNER.next());

        return new TaxiDriver(drivingExperience, ratingDriver, licenseId, autoId, isBooked);
    }

    private void createDriver() throws SQLException {
        System.out.println("\nCREATing driver...");
        TaxiDriver driver = getDriverInputs();
        taxiDriverController.create(driver);
        System.out.println("Hurrey! Driver successfully created!\n");
    }

    private void updateDriver() throws SQLException {
        System.out.println("\nUPDATing driver... Enter ID: ");
        Integer id = SCANNER.nextInt();
        TaxiDriver driver = getDriverInputs();
        driver.setId(id);

        taxiDriverController.update(driver.getId(), driver);
        System.out.println("Updated driver with Id=" + id + "\n");
    }

    private void deleteDriver() throws SQLException {
        System.out.println("\nDELETing driver... Enter ID: ");
        int id = SCANNER.nextInt();

        taxiDriverController.delete(id);
        System.out.println("Deleted driver with ID=" + id + "\n");
    }

}

