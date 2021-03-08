/**
 * Программа для работы с музыкальной системой
 * @author Kamron Boturkhonov
 */
public class Main {
    public static void main(String[] args) {
        Song song = new Song("P.I.M.P.", "50 Cent"); // Создаём объект песни

        StorageDevice cd = new CD("compact disk"); // Создаём объект CD диска
        cd.recordSong(song); // Записываем песню на CD диск

        Player cdPlayer = new CDPlayer("Sony CD player"); // Создаём CD плеер
        cdPlayer.loadStorageDevice(cd); // ОК: CD плеер может возпроизвести CD диск
        cdPlayer.play(); // Проигрование песни

        Player turntable = new Turntable("Мелодия"); // Создаём объект виниловой вертушки
        turntable.loadStorageDevice(cd); // Ошибка: Виниловая вертушка не может прочитать CD

        Record plastinka = new Record("Пластинка"); // Создаём объект пластинки
        Song roses = new Song("Миллион алых роз", "Алла Пугачева"); // Создаём объект песни
        plastinka.recordSong(song); // Записываем песню на пластинку
        turntable.loadStorageDevice(plastinka); // ОК: Виниловая вертушка может прочитать пластинку

        turntable.play(); // Проигрование

        Song paradise = new Song("Gangsta's Paradise", "Coolio feat L.V.");
        Flashcard flashcard = new Flashcard("Transcend");
        flashcard.recordSong(paradise);

        UniversalPlayer universalPlayer = new UniversalPlayer("Yamaha");
        universalPlayer.loadStorageDevice(flashcard);
        universalPlayer.play();
    }
}
