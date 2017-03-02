package utils;

import data.Library;

import java.io.*;

public class FileManager {

    public static final String FILE_NAME = "library.o";

    public void writeLibraryToFile(Library lib){
        try(
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))
                ) {
            objectOutputStream.writeObject(lib);
        }catch(FileNotFoundException ex){
            System.out.println("File not found");
        }catch(IOException ex){
            System.out.println("Error during save to file");
        }
    }

    public Library readLibraryFromFile() throws IOException, ClassNotFoundException {
        Library lib = null;
        try(
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))
                ) {
            lib = (Library)objectInputStream.readObject();
        }catch(FileNotFoundException ex){
            System.out.println("File not found");
            throw ex;
        }catch(IOException ex){
            System.out.println("Error during read from file");
            throw ex;
        }catch(ClassNotFoundException ex){
            System.out.println("Wrong file format");
            throw ex;
        }
        return lib;
    }
}
