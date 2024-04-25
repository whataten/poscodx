package chapter03;

public class Song {
    public Song(String title, String artist) {
        this(title, artist, title, artist, 0, 0);

        // System.out.println("some code1");
        // System.out.println("some code2");
        // System.out.println("some code3");
        // System.out.println("some code4");
        // System.out.println("some code5");
    }

    public Song(String title, String album, String composer, String artist, int track, int year) {
        this.title = title;
        this.album = album;
        this.composer = composer;
        this.artist = artist;
        this.track = track;
        this.year = year;

        System.out.println("some code1");
        System.out.println("some code2");
        System.out.println("some code3");
        System.out.println("some code4");
        System.out.println("some code5");
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String album;

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    private String composer;

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    private String artist;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    private int track;

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void show() {
        System.out.println(this.artist + " " + this.title + " (" + this.album + " " + this.track + "track "
                + this.composer + "작곡)");
    }
}
