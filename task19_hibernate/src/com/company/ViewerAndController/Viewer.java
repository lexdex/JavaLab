package com.company.ViewerAndController;

import com.company.model.CityEntity;
import com.company.model.LibraryEntity;
import com.company.model.LibraryHasBookEntity;
import com.company.model.metadata.TableMetaData;
import com.company.persistant.ConnectionManager;
import com.company.service.CityService;
import com.company.service.LibraryHasBookService;
import com.company.service.LibraryService;
import com.company.service.MetaDataService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.company.model.BookEntity;
import com.company.service.BookService;

public class Viewer {

  private Map<String, String> menu;
  private Map<String, Printable> methodsMenu;
  private static Scanner input = new Scanner(System.in);

  public Viewer() {
    menu = new LinkedHashMap<>();
    methodsMenu = new LinkedHashMap<>();
    menu.put("A", "   A - Select all table");
    menu.put("B", "   B - Select structure of DB");

    menu.put("1", "   1 - Table: City");
    menu.put("11", "  11 - Create City");
    menu.put("12", "  12 - Update City");
    menu.put("13", "  13 - Delete from City");
    menu.put("14", "  14 - Select City");
    menu.put("15", "  15 - Find City by ID");

    menu.put("2", "   2 - Table: Book");
    menu.put("21", "  21 - Create Book");
    menu.put("22", "  22 - Update Book");
    menu.put("23", "  23 - Delete from Book");
    menu.put("24", "  24 - Select Book");
    menu.put("25", "  25 - Find Book by ID");
    menu.put("26", "  26 - Find Book by Name");

    menu.put("3", "   3 - Table: Library");
    menu.put("31", "  31 - Create Library");
    menu.put("32", "  32 - Update Library");
    menu.put("33", "  33 - Delete from Library");
    menu.put("34", "  34 - Select Library");
    menu.put("35", "  35 - Find Library by ID");

    menu.put("4", "   4 - Table: Library_has_book");
    menu.put("41", "  41 - Create Library_has_book");
    menu.put("43", "  42 - Delete from Library_has_book");
    menu.put("44", "  43 - Select Library_has_book");

    menu.put("Q", "   Q - exit");

    methodsMenu.put("A", this::selectAllTable);
    methodsMenu.put("B", this::takeStructureOfDB);

    methodsMenu.put("11", this::createForCity);
    methodsMenu.put("12", this::updateCity);
    methodsMenu.put("13", this::deleteFromCity);
    methodsMenu.put("14", this::selectCity);
    methodsMenu.put("15", this::findCityByID);

    methodsMenu.put("21", this::createForBookTable);
    methodsMenu.put("22", this::updateBookTable);
    methodsMenu.put("23", this::deleteFromBookTable);
    methodsMenu.put("24", this::selectBookTable);
    methodsMenu.put("25", this::findBookByID);

    methodsMenu.put("31", this::createForLibrary);
    methodsMenu.put("32", this::updateLibrary);
    methodsMenu.put("33", this::deleteFromLibrary);
    methodsMenu.put("34", this::selectLibrary);
    methodsMenu.put("35", this::findLibraryByID);

    methodsMenu.put("41", this::createForLibraryHasBook);
    methodsMenu.put("42", this::deleteFromLibraryHasBook);
    methodsMenu.put("43", this::selectLibraryHasBook);
  }

  private void selectAllTable() throws SQLException {
    selectCity();
    selectBookTable();
    selectLibrary();
    selectLibraryHasBook();
  }

  private void takeStructureOfDB() throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    MetaDataService metaDataService = new MetaDataService();
    List<TableMetaData> tables = metaDataService.getTablesStructure();
    System.out.println("========== TABLES OF DATABASE " + connection.getCatalog() + " ==========");

    for (TableMetaData table : tables) {
      System.out.println(table);
    }
  }

  //--------------------------------------------------------------------------------------

  private void deleteFromCity() throws SQLException {
    System.out.println("Input ID of City: ");
    String id = input.nextLine();
    CityService cityService = new CityService();
    int count = cityService.delete(id);
    System.out.printf("There are deleted %d rows\n", count);
  }

  private void createForCity() throws SQLException {
    System.out.println("Input ID of City: ");
    int id = input.nextInt();
    System.out.println("Input name of City: ");
    String name = input.nextLine();
    CityEntity entity = new CityEntity(id, name);

    CityService cityService = new CityService();
    int count = cityService.create(entity);
    System.out.printf("There are created %d rows\n", count);
  }

  private void updateCity() throws SQLException {
    System.out.println("Input ID of City: ");
    int id = input.nextInt();
    System.out.println("Input name of City: ");
    String name = input.next();
    CityEntity entity = new CityEntity(id, name);

    CityService cityService = new CityService();
    int count = cityService.update(entity);
    System.out.printf("There are updated %d rows\n", count);
  }

  private void selectCity() throws SQLException {
    System.out.println("\nTable: City");
    CityService cityService = new CityService();
    List<CityEntity> cities = cityService.findAll();
    for (CityEntity entity : cities) {
      System.out.println(entity);
    }
  }

  private void findCityByID() throws SQLException {
    System.out.println("Input ID of City: ");
    String id = input.nextLine();
    CityService cityService = new CityService();
    CityEntity entity = cityService.findById(id);
    System.out.println(entity);
  }

  //------------------------------------------------------------------------

  private void createForBookTable() throws SQLException {
    System.out.println("Input ID of Book: ");
    int id = input.nextInt();
    System.out.println("Input name and author of Book: ");
    String nameAuthor = input.nextLine();
    System.out.println("Input published year of Book: ");
    String published = input.nextLine();
    System.out.println("Input imdb id for Book: ");
    int imdbId = input.nextInt();

    BookEntity bookEntity = new BookEntity(id, nameAuthor, published, imdbId);
    BookService bookService = new BookService();
    int count = bookService.create(bookEntity);
    System.out.printf("There are created %d rows\n", count);
  }

  private void updateBookTable() throws SQLException {
    System.out.println("Input ID of Book: ");
    int id = input.nextInt();
    System.out.println("Input name and author of Book: ");
    String nameAuthor = input.nextLine();
    System.out.println("Input published year of Book: ");
    String published = input.nextLine();
    System.out.println("Input imdb id for Book: ");
    int imdbId = input.nextInt();

    BookEntity bookEntity = new BookEntity(id, nameAuthor, published, imdbId);
    BookService bookService = new BookService();
    int count = bookService.create(bookEntity);
    System.out.printf("There are updated %d rows\n", count);
  }

  private void deleteFromBookTable() throws SQLException {
    System.out.println("Input ID: ");
    String id = input.nextLine();
    BookService bookService = new BookService();
    int count = bookService.delete(id);
    System.out.printf("There are deleted %d rows\n", count);
  }

  private void selectBookTable() throws SQLException {
    System.out.println("\nTable: Book");
    BookService bookService = new BookService();
    List<BookEntity> books = bookService.findAll();
    for (BookEntity entity : books) {
      System.out.println(entity);
    }
  }

  private void findBookByID() throws SQLException {
    System.out.println("Input ID: ");
    String id = input.nextLine();
    BookService bookService = new BookService();
    BookEntity entity = bookService.findById(id);
    System.out.println(entity);
  }

  //-------------------------------------------------------------------------

  private void updateLibrary() throws SQLException {
    System.out.println("Input ID for Library: ");
    Integer id = input.nextInt();
    System.out.println("Input name for Library: ");
    String name = input.nextLine();
    System.out.println("Input count of books for Library: ");
    Integer books = input.nextInt();
    input.nextLine();
    Integer magazines = input.nextInt();
    input.nextLine();
    Double popularity = input.nextDouble();
    input.nextLine();
    Integer city_id = input.nextInt();
    input.nextLine();
    LibraryEntity entity = new LibraryEntity(id, name, books, magazines, popularity, city_id);

    LibraryService libraryService = new LibraryService();
    int count = libraryService.update(entity);
    System.out.printf("There are updated %d rows\n", count);
  }

  private void deleteFromLibrary() throws SQLException {
    System.out.println("Input ID for Library: ");
    Integer id = input.nextInt();
    LibraryService libraryService = new LibraryService();
    int count = libraryService.delete(id);
    System.out.printf("There are deleted %d rows\n", count);
  }

  private void createForLibrary() throws SQLException {
    System.out.println("Input ID for Library: ");
    Integer id = input.nextInt();
    System.out.println("Input name for Library: ");
    String name = input.nextLine();
    System.out.println("Input count of books for Library: ");
    Integer books = input.nextInt();
    input.nextLine();
    Integer magazines = input.nextInt();
    input.nextLine();
    Double popularity = input.nextDouble();
    input.nextLine();
    Integer city_id = input.nextInt();
    input.nextLine();
    LibraryEntity entity = new LibraryEntity(id, name, books, magazines, popularity, city_id);

    LibraryService libraryService = new LibraryService();
    int count = libraryService.create(entity);
    System.out.printf("There are created %d rows\n", count);
  }

  private void selectLibrary() throws SQLException {
    System.out.println("\nTable: Library");
    LibraryService libraryService = new LibraryService();
    List<LibraryEntity> libraries = libraryService.findAll();
    for (LibraryEntity entity : libraries) {
      System.out.println(entity);
    }
  }

  private void findLibraryByID() throws SQLException {
    System.out.println("Input ID for Library: ");
    Integer id = input.nextInt();
    LibraryService libraryService = new LibraryService();
    LibraryEntity entity = libraryService.findById(id);
    System.out.println(entity);
  }

  //-------------------------------------------------------------------------

  private void deleteFromLibraryHasBook() throws SQLException {
    System.out.println("Input ID for Library Has Book: ");
    Integer id_lib = input.nextInt();
    input.nextLine();
    System.out.println("Input ID for Library Has Book: ");
    Integer id_book = input.nextInt();
    LibraryHasBookEntity pk = new LibraryHasBookEntity(id_lib, id_book);

    LibraryHasBookService hasBookService = new LibraryHasBookService();
    int count = hasBookService.delete(pk);
    System.out.printf("There are deleted %d rows\n", count);
  }

  private void createForLibraryHasBook() throws SQLException {
    System.out.println("Input ID for Library Has Book: ");
    Integer id_lib = input.nextInt();
    input.nextLine();
    System.out.println("Input ID for Library Has Book: ");
    Integer id_book = input.nextInt();
    LibraryHasBookEntity pk = new LibraryHasBookEntity(id_lib, id_book);

    System.out.println("Input number for Library Has Book: ");
    String number = input.nextLine();
    System.out.printf("There are created %d rows\n", number);
  }


  private void selectLibraryHasBook() throws SQLException {
    System.out.println("\nTable: Library Has Book");
    LibraryHasBookService hasBookService = new LibraryHasBookService();
    List<LibraryHasBookEntity> has = hasBookService.findAll();
    for (LibraryHasBookEntity entity : has) {
      System.out.println(entity);
    }
  }

//------------------------------------------------------------------------------------------

  private void outputMenu() {
    System.out.println("\n============ MENU ============");
    for (String key : menu.keySet()) {
      if (key.length() == 1) {
        System.out.println(menu.get(key));
      }
    }
  }

  private void outputSubMenu(String fig) {

    System.out.println("\nSubMENU:");
    for (String key : menu.keySet()) {
      if (key.length() != 1 && key.substring(0, 1).equals(fig)) {
        System.out.println(menu.get(key));
      }
    }
  }

  public void show() {
    String keyMenu;
    do {
      outputMenu();
      System.out.println("Please, select menu point:");
      keyMenu = input.nextLine().toUpperCase();

      if (keyMenu.matches("^\\d")) {
        outputSubMenu(keyMenu);
        System.out.println("Please, select menu point:");
        keyMenu = input.nextLine().toUpperCase();
      }

      try {
        methodsMenu.get(keyMenu).print();
      } catch (Exception ignored) {
      }
    } while (!keyMenu.equals("Q"));
  }

}
