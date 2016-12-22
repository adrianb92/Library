package utils;

import data.Book;
import data.Library;
import data.Magazine;

public class LibraryUtils {
    public static void printBooks(Library lib){
        int booksNumber = 0;
        for(int i = 0; i < lib.getPublicationsNumber(); i++){
            if(lib.getPublications()[i] instanceof Book) {
                System.out.println(lib.getPublications()[i]);
                booksNumber++;
            }
        }

        if(booksNumber == 0){
            System.out.println("There's no books in the library!");
        }
    }

    public static void printMagazines(Library lib){
        int magazinesNumber = 0;
        for(int i = 0; i < lib.getPublicationsNumber(); i++){
            if(lib.getPublications()[i] instanceof Magazine){
                System.out.println(lib.getPublications()[i]);
                magazinesNumber++;
            }
        }

        if(magazinesNumber == 0){
            System.out.println("there's no magazines in the library!");
        }
    }
}
