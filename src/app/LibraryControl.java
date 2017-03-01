package app;

import data.Book;
import data.Magazine;
import data.Library;
import utils.DataReader;
import utils.LibraryUtils;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class LibraryControl {

    private Library library;
    private DataReader dataReader;

    public LibraryControl(){
        library = new Library();
        dataReader = new DataReader();
    }

    public void controlLoop(){
        Option option = null;
        do{
            printOptions();
            try {
                option = Option.createFromInt(dataReader.getInt());
                switch (option) {
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_MAGAZINE:
                    addMagazine();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case PRINT_MAGAZINES:
                    printMagazines();
                    break;
                case EXIT:
                    break;
                }
            }catch(InputMismatchException ex){
                System.out.println("Wrong data. Can't add publication.");
            }catch(NoSuchElementException | NumberFormatException ex){
                System.out.println("Wrong option. Try again");
            }
        }while(option != Option.EXIT);
        dataReader.close();
    }

    private void printMagazines() {
        LibraryUtils.printMagazines(library);
    }

    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }

    private void printBooks() {
        LibraryUtils.printBooks(library);
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void printOptions() {
        System.out.println("Choose an option:");
        for(Option option : Option.values())
            System.out.println(option);
    }

    private enum Option {
        EXIT(0, "Exit"),
        ADD_BOOK(1, "Add new book"),
        ADD_MAGAZINE(2, "Add new magazine"),
        PRINT_BOOKS(3, "Print all books"),
        PRINT_MAGAZINES(4, "Print all magazines");

        private int option;
        private String description;

        Option(int option, String description) {
            this.option = option;
            this.description = description;
        }

        @Override
        public String toString() {
            return option + " - " + description;
        }

        public static Option createFromInt(int option) throws NoSuchElementException {
            Option result;
            try {
                result = Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException ex) {
                throw new NoSuchElementException("There's no element with such ID!");
            }
            return result;
        }
    }
}
