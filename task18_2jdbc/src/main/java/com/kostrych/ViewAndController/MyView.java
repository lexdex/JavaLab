package com.kostrych.ViewAndController;

import com.kostrych.model.TheatreEntity;
import com.kostrych.model.TicketEntity;
import com.kostrych.model.metadata.TableMetaData;
import com.kostrych.persistant.ConnectionManager;
import com.kostrych.service.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MyView {
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input = new Scanner(System.in);

    public MyView() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();
        menu.put("A", "   A - Select all table");
        menu.put("B", "   B - Select structure of DB");

        menu.put("1", "   1 - Table: Theatre");
        menu.put("11", "  11 - Create for Theatre");
        menu.put("12", "  12 - Update Theatre");
        menu.put("13", "  13 - Delete from Theatre");
        menu.put("14", "  14 - Select Theatre");
        menu.put("15", "  15 - Find Theatre by ID");

        menu.put("2", "   2 - Table: Ticket");
        menu.put("21", "  21 - Create for Ticket");
        menu.put("22", "  22 - Update Ticket");
        menu.put("23", "  23 - Delete from Ticket");
        menu.put("24", "  24 - Select Ticket");
        menu.put("25", "  25 - Find Ticket by ID");
        menu.put("26", "  26 - Find Ticket by Name");


        menu.put("Q", "   Q - exit");

        methodsMenu.put("A", this::selectAllTable);
        methodsMenu.put("B", this::takeStructureOfDB);

        methodsMenu.put("11", this::createForTheatre);
        methodsMenu.put("12", this::updateTheatre);
        methodsMenu.put("13", this::deleteFromTheatre);
        methodsMenu.put("14", this::selectTheatre);
        methodsMenu.put("15", this::findTheatreByID);

        methodsMenu.put("21", this::createForTicket);
        methodsMenu.put("22", this::updateTicket);
        methodsMenu.put("23", this::deleteFromTicket);
        methodsMenu.put("24", this::selectTicket);
        methodsMenu.put("25", this::findTicketByID);
        methodsMenu.put("26", this::findTicketByName);

    }

    private void selectAllTable() throws SQLException {
        selectTheatre();
        selectTicket();
    }

    private void takeStructureOfDB() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        MetaDataService metaDataService = new MetaDataService();
        List<TableMetaData> tables = metaDataService.getTablesStructure();
        System.out.println("TABLE OF DATABASE: "+connection.getCatalog());

        for (TableMetaData table: tables ) {
            System.out.println(table);
        }
    }


    private void deleteFromTheatre() throws SQLException {
        System.out.println("Input ID for Theatre: ");
        String id = input.nextLine();
        TheatreService theatreService = new TheatreService();
        int count = theatreService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForTheatre() throws SQLException {
        System.out.println("Input ID for Theatre: ");
        Integer id = input.nextInt();
        System.out.println("Input location for Theatre: ");
        String location = input.nextLine();
        TheatreEntity entity = new TheatreEntity(id, location);

        TheatreService theatreService = new TheatreService();
        int count = theatreService.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateTheatre() throws SQLException {
        System.out.println("Input ID for Theatre: ");
        Integer id = input.nextInt();
        System.out.println("Input location for Theatre: ");
        String location = input.next();
        TheatreEntity entity = new TheatreEntity(id, location);

        TheatreService theatreService = new TheatreService();
        int count = theatreService.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectTheatre() throws SQLException {
        System.out.println("\nTable: Theatre");
        TheatreService theatreService = new TheatreService();
        List<TheatreEntity> theatreEntities = theatreService.findAll();
        for (TheatreEntity entity : theatreEntities) {
            System.out.println(entity);
        }
    }

    private void findTheatreByID() throws SQLException {
        System.out.println("Input ID for Theatre: ");
        String id = input.nextLine();
        TheatreService theatreService = new TheatreService();
        TheatreEntity entity = theatreService.findById(id);
        System.out.println(entity);
    }

    //------------------------------------------------------------------------

    private void deleteFromTicket() throws SQLException {
        System.out.println("Input ID for Ticket: ");
        Integer id = input.nextInt();
        input.nextLine();
        TicketService ticketService = new TicketService();
        int count = ticketService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForTicket() throws SQLException {
//        System.out.println("Input ID for Ticket: ");
//        Integer id = input.nextInt();
//        input.nextLine();
//        System.out.println("Input emp_fmane for Ticket: ");
//        String empFirstName = input.nextLine();
//        System.out.println("Input emp_lname for Ticket: ");
//        String empLastName = input.nextLine();
//        System.out.println("Input dept_no for Employee: ");
//        String deptNo = input.nextLine();
//        TicketEntity entity = new TicketEntity(id, empFirstName, empLastName, deptNo);
//        TicketService ticketService = new TicketService();
//
//        int count = ticketService.create(entity);
//        System.out.printf("There are created %d rows\n", count);
    }

    private void updateTicket() throws SQLException {
//        System.out.println("Input ID(epm_no) for Employee: ");
//        Integer id = input.nextInt();
//        input.nextLine();
//        System.out.println("Input emp_fmane for Employee: ");
//        String empFirstName = input.nextLine();
//        System.out.println("Input emp_lname for Employee: ");
//        String empLastName = input.nextLine();
//        System.out.println("Input dept_no for Employee: ");
//        String deptNo = input.nextLine();
//        TicketEntity entity = new TicketEntity(id, empFirstName, empLastName, deptNo);
//        TicketService ticketService = new TicketService();
//
//        int count = ticketService.update(entity);
//        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectTicket() throws SQLException {
//        System.out.println("\nTable: Employee");
//        TicketService ticketService = new TicketService();
//        List<TicketEntity> employees = ticketService.findAll();
//        for (TicketEntity entity : employees) {
//            System.out.println(entity);
//        }
    }

    private void findTicketByID() throws SQLException {
//        System.out.println("Input ID(emp_no) for Employee: ");
//        Integer id = input.nextInt();
//        input.nextLine();
//        TicketService ticketService = new TicketService();
//        TicketEntity entity = ticketService.findById(id);
//        System.out.println(entity);
    }

    private void findTicketByName() throws SQLException {
//        System.out.println("Input First Name for Employee: ");
//        String fname = input.nextLine();
//        TicketService ticketService = new TicketService();
//        List<TicketEntity> employees = ticketService.findByName(fname);
//        for (TicketEntity entity : employees) {
//            System.out.println(entity);
//        }
    }

    //------------------------------------------------------------------------



    //------------------------------------------------------------------------


    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
            }
        } while (!keyMenu.equals("Q"));
    }
}
