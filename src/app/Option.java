package app;

import java.util.NoSuchElementException;

/**
 * Created by adrian on 23.11.16.
 */
public enum Option {
    EXIT(0, "Exit"),
    ADD_BOOK(1, "Add new book"),
    ADD_MAGAZINE(2, "Add new magazine"),
    PRINT_BOOKS(3, "Print all books"),
    PRINT_MAGAZINES(4, "Print all magazines");

    private int option;
    private String description;

    Option(int option, String description){
        this.option = option;
        this.description = description;
    }

    public int getOption() {
        return option;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return option + " - " + description;
    }

    public static Option createFromInt(int option) throws NoSuchElementException{
        Option result = null;
        try {
            result = Option.values()[option];
        }catch(ArrayIndexOutOfBoundsException ex){
            throw new NoSuchElementException("There's no element with such ID!");
        }
        return result;
    }
}
