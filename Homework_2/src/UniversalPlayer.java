/**
 * Класс универсального плеера
 */
public class UniversalPlayer extends Player {

    public UniversalPlayer(String name) {
        super(name);
    }

    @Override
    public void loadStorageDevice(StorageDevice storageDevice) {
        if (storageDevice instanceof CD || storageDevice instanceof Flashcard) {
            this.storageDevice = storageDevice;
            System.out.println("Носитель успешно прочитано");
        } else {
            System.out.println("Ошибка: Универсальный плеер может прочитать CD диск или флешку");
        }
    }
}
