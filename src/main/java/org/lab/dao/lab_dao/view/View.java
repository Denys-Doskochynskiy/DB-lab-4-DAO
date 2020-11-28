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


  private final TaxiDriverController taxiDriverController = new TaxiDriverController();
  private final TaxiPassengerController taxiPassengerController = new TaxiPassengerController();
  private final LicenseController licenseController = new LicenseController();
  private final AutoController autoController = new AutoController();
  private final DriverTaxiInfoController driverTaxiInfoController = new DriverTaxiInfoController();
  private final PassengerTaxiInfoController passengerTaxiInfoController = new PassengerTaxiInfoController();


  public View() {

    /////////_____Passenger_____////////
    menu.put("11", this::getAllPassenger);
    menu.put("12", this::getPassengerById);
    menu.put("13", this::createPassenger);
    menu.put("14", this::updatePassenger);
    menu.put("15", this::deletePassenger);

    /////////___Passenger Taxi Info Controller___/////////
    menu.put("21", this::getAllPassengerTaxiInfo);
    menu.put("22", this::getPassengerTaxiInfoById);
    menu.put("23", this::createPassengerTaxiInfo);
    menu.put("24", this::updatePassengerTaxiInfo);
    menu.put("25", this::deletePassengerTaxiInfo);
    /////////_____Driver_____////////
    menu.put("31", this::getAllDriver);
    menu.put("32", this::getDriverById);
    menu.put("33", this::createDriver);
    menu.put("34", this::updateDriver);
    menu.put("35", this::deleteDriver);

    /////////_____Driver Taxi Info_____////////
    menu.put("41", this::getAllDriverTaxiInfo);
    menu.put("42", this::getDriverTaxiInfoById);
    menu.put("43", this::createDriverTaxiInfo);
    menu.put("44", this::updateDriverTaxiInfo);
    menu.put("45", this::deleteDriverTaxiInfo);

    /////////_____License_____//////////
    menu.put("51", this::getAllLicense);
    menu.put("52", this::getLicenseById);
    menu.put("53", this::createLicense);
    menu.put("54", this::updateLicense);
    menu.put("55", this::deleteLicense);


    /////////_____Auto_____//////////
    menu.put("61", this::getAllAuto);
    menu.put("62", this::getAutoById);
    menu.put("63", this::createAuto);
    menu.put("64", this::updateAuto);
    menu.put("65", this::deleteAuto);


  }

  public final void show() {


    String input;
    Menu showMenu = new Menu();
    showMenu.displayMenu();
    System.out.println("\n(U w U） Welcome, please chose what you want do:\n");
    do {
      try {
        input = SCANNER.next();
        menu.get(input).print();
      } catch (Exception ignored) {
      }
    } while (SCANNER.hasNext());
  }


//////////////////////////////////////////////////////////////////////////////////
  //////////////////////_____DRIVER TAXI INFO_____////////////////////////////


  private void getAllPassengerTaxiInfo() throws SQLException {
    System.out.println("\nGETting PassengerTaxiInfo...");
    System.out.println(passengerTaxiInfoController.findAll() + "\n");
  }


  private void getPassengerTaxiInfoById() throws SQLException {
    System.out.println("\nGETting passengerTaxiInfo... Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(passengerTaxiInfoController.findOne(id) + "\n");
  }

  private PassengerTaxiInfo getPassengerTaxiInfoInputs() {


    System.out.println("\nEnter date of registration: ");
    String dateOfRegistration = SCANNER.next();
    System.out.println("Enter taxi trip history Id: ");
    int taxiTripHistoryId = Integer.parseInt(SCANNER.next());
    System.out.println("\nEnter rating: ");
    Float rating = Float.valueOf(SCANNER.next());


    return new PassengerTaxiInfo(dateOfRegistration, taxiTripHistoryId, rating);
  }

  private void createPassengerTaxiInfo() throws SQLException {
    System.out.println("\nCREATing PassengerTaxiInfo...");
    PassengerTaxiInfo passengerTaxiInfo = getPassengerTaxiInfoInputs();
    passengerTaxiInfoController.create(passengerTaxiInfo);
    System.out.println("Hurrey! PassengerTaxiInfo successfully created!\n");
  }

  private void updatePassengerTaxiInfo() throws SQLException {
    System.out.println("\nUPDATing PassengerTaxiInfo... Enter ID: ");
    int id = SCANNER.nextInt();
    PassengerTaxiInfo passengerTaxiInfo = getPassengerTaxiInfoInputs();
    passengerTaxiInfo.setId(id);

    passengerTaxiInfoController.update(passengerTaxiInfo.getId(), passengerTaxiInfo);
    System.out.println("Updated PassengerTaxiInfo with Id=" + id + "\n");
  }

  private void deletePassengerTaxiInfo() throws SQLException {
    System.out.println("\nDELETing PassengerTaxiInfo... Enter ID: ");
    int id = SCANNER.nextInt();

    passengerTaxiInfoController.delete(id);
    System.out.println("Deleted PassengerTaxiInfo with ID=" + id + "\n");
  }
/////////////////////////////////////////////////////////////////////////
  //////////////////////_____DRIVER TAXI INFO_____////////////////////////////


  private void getAllDriverTaxiInfo() throws SQLException {
    System.out.println("\nGETting DriverTaxiInfo...");
    System.out.println(driverTaxiInfoController.findAll() + "\n");
  }


  private void getDriverTaxiInfoById() throws SQLException {
    System.out.println("\nGETting DriverTaxiInfo... Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(driverTaxiInfoController.findOne(id) + "\n");
  }

  private DriverTaxiInfo getDriverTaxiInfoInputs() {


    System.out.println("\nEnter driving experience: ");
    Float drivingExperience = Float.valueOf(SCANNER.next());
    System.out.println("Enter rating driver: ");
    Float ratingDriver = Float.valueOf(SCANNER.next());
    System.out.println("Enter licenseId: ");
    int licenseId = Integer.parseInt(SCANNER.next());
    System.out.println("Enter autoId: ");
    int autoId = Integer.parseInt(SCANNER.next());
    System.out.println("Enter is booked: ");
    Boolean isBooked = Boolean.valueOf(SCANNER.next());

    return new DriverTaxiInfo(drivingExperience, ratingDriver, licenseId, autoId, isBooked);
  }

  private void createDriverTaxiInfo() throws SQLException {
    System.out.println("\nCREATing DriverTaxiInfo...");
    DriverTaxiInfo driverTaxiInfo = getDriverTaxiInfoInputs();
    driverTaxiInfoController.create(driverTaxiInfo);
    System.out.println("Hurrey! DriverTaxiInfo successfully created!\n");
  }

  private void updateDriverTaxiInfo() throws SQLException {
    System.out.println("\nUPDATing DriverTaxiInfo... Enter ID: ");
    int id = SCANNER.nextInt();
    DriverTaxiInfo driverTaxiInfo = getDriverTaxiInfoInputs();
    driverTaxiInfo.setId(id);

    driverTaxiInfoController.update(driverTaxiInfo.getId(), driverTaxiInfo);
    System.out.println("Updated DriverTaxiInfo with Id=" + id + "\n");
  }

  private void deleteDriverTaxiInfo() throws SQLException {
    System.out.println("\nDELETing DriverTaxiInfo... Enter ID: ");
    int id = SCANNER.nextInt();

    driverTaxiInfoController.delete(id);
    System.out.println("Deleted DriverTaxiInfo with ID=" + id + "\n");
  }
/////////////////////////////////////////////////////////////////////////


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

    System.out.println("\nEnter name: ");
    String firstName = SCANNER.next();
    System.out.println("Enter last name: ");
    String secondName = SCANNER.next();
    System.out.println("Enter gender: ");
    String gender = SCANNER.next();
    System.out.println("Enter date of birth: ");
    String dateOfBirth = SCANNER.next();
    System.out.println("Enter driverTaxiInfoId: ");
    int driverTaxiInfoId = Integer.parseInt(SCANNER.next());
    return new TaxiDriver(firstName, secondName, gender, dateOfBirth, driverTaxiInfoId);
  }

  private void createDriver() throws SQLException {
    System.out.println("\nCREATing driver...");
    TaxiDriver driver = getDriverInputs();
    taxiDriverController.create(driver);
    System.out.println("Hurrey! Driver successfully created!\n");
  }

  private void updateDriver() throws SQLException {
    System.out.println("\nUPDATing driver... Enter ID: ");
    int id = SCANNER.nextInt();
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
/////////////////////////////////////////////////////////////////////////

  /////////////////////____AUTO____///////////////////////

  private void getAllAuto() throws SQLException {
    System.out.println("\nGETting Auto...");
    System.out.println(autoController.findAll() + "\n");
  }


  private void getAutoById() throws SQLException {
    System.out.println("\nGETting Auto... Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(autoController.findOne(id) + "\n");
  }

  private Auto getAutoInputs() {
    System.out.println("\nEnter driving experience: ");
    String mark = SCANNER.next();
    System.out.println("Enter rating Auto: ");
    String autoNumber = SCANNER.next();
    System.out.println("Enter licenseId: ");
    String autoType = SCANNER.next();
    System.out.println("Enter autoId: ");
    String state = SCANNER.next();


    return new Auto(mark, autoNumber, autoType, state);
  }

  private void createAuto() throws SQLException {
    System.out.println("\nCREATing Auto...");
    Auto auto = getAutoInputs();
    autoController.create(auto);
    System.out.println("Hurrey! Auto successfully created!\n");
  }

  private void updateAuto() throws SQLException {
    System.out.println("\nUPDATing Auto... Enter ID: ");
    int id = SCANNER.nextInt();
    Auto auto = getAutoInputs();
    auto.setId(id);

    autoController.update(auto.getId(), auto);
    System.out.println("Updated Auto with Id=" + id + "\n");
  }

  private void deleteAuto() throws SQLException {
    System.out.println("\nDELETing Auto... Enter ID: ");
    int id = SCANNER.nextInt();

    autoController.delete(id);
    System.out.println("Deleted Auto with ID=" + id + "\n");
  }
  ///////////////////____LICENSE____///////////////////


  private void getAllLicense() throws SQLException {
    System.out.println("\nGETting License...");
    System.out.println(licenseController.findAll() + "\n");
  }


  private void getLicenseById() throws SQLException {
    System.out.println("\nGETting License... Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(licenseController.findOne(id) + "\n");
  }

  private License getLicenseInputs() {
    System.out.println("\nEnter date of issue: ");
    String dateOfIssue = SCANNER.next();
    System.out.println("Enter place of issue: ");
    String placeOfIssue = SCANNER.next();


    return new License(dateOfIssue, placeOfIssue);
  }

  private void createLicense() throws SQLException {
    System.out.println("\nCREATing License...");
    License license = getLicenseInputs();
    licenseController.create(license);
    System.out.println("Hurrey! License successfully created!\n");
  }

  private void updateLicense() throws SQLException {
    System.out.println("\nUPDATing License... Enter ID: ");
    int id = SCANNER.nextInt();
    License license = getLicenseInputs();
    license.setId(id);

    licenseController.update(license.getId(), license);
    System.out.println("Updated License with Id=" + id + "\n");
  }

  private void deleteLicense() throws SQLException {
    System.out.println("\nDELETing License... Enter ID: ");
    int id = SCANNER.nextInt();

    licenseController.delete(id);
    System.out.println("Deleted License with ID=" + id + "\n");
  }
///////////////////////////////////////////////////////////////////////////

  ///////////////////____LICENSE____///////////////////


  private void getAllPassenger() throws SQLException {
    System.out.println("\nGETting Passenger...");
    System.out.println(taxiPassengerController.findAll() + "\n");
  }


  private void getPassengerById() throws SQLException {
    System.out.println("\nGETting Passenger... Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(taxiPassengerController.findOne(id) + "\n");
  }

  private TaxiPassenger getPassengerInputs() {

    System.out.println("\nEnter name: ");
    String firstName = SCANNER.next();
    System.out.println("Enter last name: ");
    String secondName = SCANNER.next();
    System.out.println("Enter gender: ");
    String gender = SCANNER.next();
    System.out.println("Enter date of birth: ");
    String dateOfBirth = SCANNER.next();
    System.out.println("Enter passengerTaxiInfoId: ");
    int passengerTaxiInfoId = Integer.parseInt(SCANNER.next());
    return new TaxiPassenger(firstName, secondName, gender, dateOfBirth, passengerTaxiInfoId);

  }

  private void createPassenger() throws SQLException {
    System.out.println("\nCREATing Passenger...");
    TaxiPassenger passenger = getPassengerInputs();
    taxiPassengerController.create(passenger);
    System.out.println("Hurrey! Passenger successfully created!\n");
  }

  private void updatePassenger() throws SQLException {
    System.out.println("\nUPDATing Passenger... Enter ID: ");
    int id = SCANNER.nextInt();
    TaxiPassenger Passenger = getPassengerInputs();
    Passenger.setId(id);

    taxiPassengerController.update(Passenger.getId(), Passenger);
    System.out.println("Updated Passenger with Id=" + id + "\n");
  }

  private void deletePassenger() throws SQLException {
    System.out.println("\nDELETing Passenger... Enter ID: ");
    int id = SCANNER.nextInt();

    taxiPassengerController.delete(id);
    System.out.println("Deleted Passenger with ID=" + id + "\n");
  }
}

