package utils;

import java.util.InputMismatchException;
import java.util.Scanner;
import data.Book;
import data.Magazine;

public class DataReader {
    private Scanner sc;

    public DataReader() {
        sc = new Scanner(System.in);
    }

    public void close() {
        sc.close();
    }

    public Book readAndCreateBook() throws InputMismatchException{
        System.out.println("Title: ");
        String title = sc.nextLine();
        System.out.println("Author: ");
        String author = sc.nextLine();
        System.out.println("Publisher: ");
        String publisher = sc.nextLine();
        System.out.println("ISBN: ");
        String isbn = sc.nextLine();
        System.out.println("Release year: ");
        int releaseDate = 0;
        int pages = 0;
        try {
            releaseDate = sc.nextInt();
            sc.nextLine();
            System.out.println("Pages: ");
            pages = sc.nextInt();
            sc.nextLine();
        }catch(InputMismatchException ex){
            sc.nextLine();
            throw ex;
        }

        return new Book(title, author, releaseDate, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine() throws InputMismatchException{
        System.out.println("Title: ");
        String title = sc.nextLine();
        System.out.println("Language: ");
        String language = sc.nextLine();
        System.out.println("Publisher: ");
        String publisher = sc.nextLine();
        System.out.println("Release year: ");
        int releaseDate = 0;
        int month = 0;
        int day = 0;
        try {
            releaseDate = sc.nextInt();
            sc.nextLine();
            System.out.println("Month: ");
            month = sc.nextInt();
            sc.nextLine();
            System.out.println("Day: ");
            day = sc.nextInt();
            sc.nextLine();
        }catch(InputMismatchException ex){
            sc.nextLine();
            throw ex;
        }

        return new Magazine(releaseDate, title, publisher, month, day, language);
    }

    public int getInt() throws NumberFormatException{
        int number = 0;
        try{
            number = sc.nextInt();
        }catch(InputMismatchException ex){
            throw new NumberFormatException("Wrong number format!");
        }finally {
            sc.nextLine();
        }
        return number;
    }
}