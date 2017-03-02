package app;

public class LibraryApp {
    public static void main(String[] args) {
        final String appName = "Library v0.94";
        System.out.println(appName);
        LibraryControl libraryControl = new LibraryControl();
        libraryControl.controlLoop();
    }
}
