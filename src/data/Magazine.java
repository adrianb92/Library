package data;

public class Magazine extends Publication {
    private int month;
    private int day;
    private String language;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Magazine(int releaseDate, String title, String publisher, int month, int day, String language) {
        super(title, releaseDate, publisher);
        setMonth(month);
        setDay(day);
        setLanguage(language);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Magazine magazine = (Magazine) o;

        if (month != magazine.month) return false;
        if (day != magazine.day) return false;
        return language != null ? language.equals(magazine.language) : magazine.language == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + month;
        result = 31 * result + day;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(getTitle());
        stringBuilder.append("; ");
        stringBuilder.append(getDay());
        stringBuilder.append("; ");
        stringBuilder.append(getMonth());
        stringBuilder.append("; ");
        stringBuilder.append(getReleaseDate());
        stringBuilder.append("; ");
        stringBuilder.append(getLanguage());
        stringBuilder.append("; ");
        stringBuilder.append(getPublisher());

        return stringBuilder.toString();
    }
}
