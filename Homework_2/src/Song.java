/**
 * Класс песен
 */
public class Song {
    private final String name;
    private final String singer;

    public String getName() {
        return name;
    }

    public String getSinger() {
        return singer;
    }

    public Song(String name, String singer) {
        this.name = name;
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "Название песни: " + name + '\n' +
                "Исполнитель: " + singer + '\n';
    }
}
