public class MusicRecord {
    private int id;
    private String title;
    private String artist;
    private String genre;
    private int yearReleased;

    // Constructor
    public MusicRecord() {}

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for artist
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    // Getter and Setter for genre
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Getter and Setter for yearReleased
    public int getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }

    // Optional: Override toString() for easier debugging/logging
    @Override
    public String toString() {
        return "MusicRecord{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", artist='" + artist + '\'' +
               ", genre='" + genre + '\'' +
               ", yearReleased=" + yearReleased +
               '}';
    }
}
