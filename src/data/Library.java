package data;

import java.io.Serializable;

public class Library implements Serializable{
    public static final int MAX_PUBLICATIONS = 2000;
    private int publicationsNumber;
    private Publication[] publications;

    public int getPublicationsNumber() {
        return publicationsNumber;
    }

    public Publication[] getPublications() {
        return publications;
    }

    public Library(){
        publications = new Publication[MAX_PUBLICATIONS];
        publicationsNumber = 0;
    }

    public void addPublication(Publication publication) throws ArrayIndexOutOfBoundsException{
        if(publicationsNumber == MAX_PUBLICATIONS) {
            throw new ArrayIndexOutOfBoundsException("Can't add new publication!");
        }else {
            publications[publicationsNumber] = publication;
            publicationsNumber++;
        }
    }

    public void addBook(Book book){
        addPublication(book);
    }

    public void addMagazine(Magazine magazine){
        addPublication(magazine);
    }

}