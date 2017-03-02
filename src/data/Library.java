package data;

import java.io.Serializable;
import java.util.Arrays;

public class Library implements Serializable{
    public static final int MAX_PUBLICATIONS = 1;
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

    public void addPublication(Publication publication){
        publicationsNumber++;
        if(publicationsNumber > MAX_PUBLICATIONS) {
            Arrays.copyOf(publications, publications.length * 2);
        }
        publications[publicationsNumber-1] = publication;
    }

    public void removePublication(Publication pub) {
        if (pub == null)
            return;

        int i = 0;
        boolean done = false;
        do{
            if(publications[i].equals(pub)){
                System.arraycopy(publications,i+1,publications,i,publicationsNumber);
                done = true;
            }
            i++;
        }while(!done);
    }

    public void addBook(Book book){
        addPublication(book);
    }

    public void addMagazine(Magazine magazine){
        addPublication(magazine);
    }

}