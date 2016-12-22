package data;

public class Publication {
    private String title;
    private int releaseDate;
    private String publisher;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    protected Publication(String title, int releaseDate, String publisher) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publication that = (Publication) o;

        if (releaseDate != that.releaseDate) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return publisher != null ? publisher.equals(that.publisher) : that.publisher == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + releaseDate;
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        return result;
    }
}
