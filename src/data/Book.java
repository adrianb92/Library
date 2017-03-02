package data;

public class Book extends Publication{
    private String author;
    private int pages;
    private String isbn;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public Book(String title, String author, int releaseDate, int pages, String publisher, String isbn) {
        super(title, releaseDate, publisher);
        setAuthor(author);
        setPages(pages);
        setPublisher(publisher);
        setIsbn(isbn);
    }

    public Book(Book book) {
        this(book.getTitle(), book.getAuthor(), book.getReleaseDate(), book.getPages(), book.getPublisher(), book.getIsbn());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Book book = (Book) o;

        if (pages != book.pages) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        return isbn != null ? isbn.equals(book.isbn) : book.isbn == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + pages;
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(getTitle());
        stringBuilder.append("; ");
        stringBuilder.append(getAuthor());
        stringBuilder.append("; ");
        stringBuilder.append(getReleaseDate());
        stringBuilder.append("; ");
        stringBuilder.append(getPages());
        stringBuilder.append("; ");
        stringBuilder.append(getPublisher());
        stringBuilder.append("; ");
        stringBuilder.append(getIsbn());
        return stringBuilder.toString();
    }

}
