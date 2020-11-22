package org.lab.dao.lab_dao.view;

public class Menu {
    public void displayMenu() {
        System.out.println(" _______________________________________________________________________");
        System.out.println("|                                                                       |");
        System.out.println("|       Enter any compination of existing entity and CRUD number :      |");
        System.out.println("|_______________________________________________________________________|");
        System.out.println("|                                  |                                    |");
        System.out.println("|        entity number:            |           CRUD number:             |");
        System.out.println("|__________________________________|____________________________________|");
        System.out.println("|   |                              |   |                                |");
        System.out.println("| 1 | User                         | 1 | GET ALL                        |");
        System.out.println("| 2 | User role                    | 2 | GET ONE                        |");
        System.out.println("| 3 | Driver                       | 3 | CREATE                         |");
        System.out.println("| 4 | Auto                         | 4 | UPDATE                         |");
        System.out.println("| 5 | License                      | 5 | DELETE                         |");
        System.out.println("| 6 | Passenger                    |   |                                |");
        System.out.println("|___|______________________________|___|________________________________|");

    }
}
