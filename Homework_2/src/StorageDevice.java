/**
 * Общий абстрактный класс для носителей музыкальных композиций
 */
public abstract class StorageDevice {
    private String name;
    private Song song;

    public Song getSong() {
        return song;
    }

    public String getName() {
        return name;
    }

    public StorageDevice(String name) {
        this.name = name;
    }

    public void recordSong(Song song) {
        this.song = song;
    }

}
