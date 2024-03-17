package sourceFiles;

public class MusicTrack {
    private String title;
    private String artist;
    private double duration;

    public MusicTrack(String title, String artist, double duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public void playTrack() {
        System.out.println("Now playing: " + title + " by " + artist + " [" + duration + " mins]");
    }
}
